package br.com.billinterest.core.usecase;

import br.com.billinterest.core.domain.Bill;
import br.com.billinterest.core.domain.CalculatedBill;
import br.com.billinterest.core.domain.enums.BillType;
import br.com.billinterest.core.domain.enums.ExceptionType;
import br.com.billinterest.core.exceptions.ApplicationException;
import br.com.billinterest.core.port.in.CalculateBillPort;
import br.com.billinterest.core.port.out.BillComplementPort;
import br.com.billinterest.core.port.out.SaveBillCalculationPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalculateBillUseCase implements CalculateBillPort {

    private static final BigDecimal DAILY_FEES = BigDecimal.valueOf(0.033);

    private final BillComplementPort billComplementPort;
    private final SaveBillCalculationPort saveBillCalculationPort;

    public CalculateBillUseCase(BillComplementPort billComplementPort, SaveBillCalculationPort saveBillCalculationPort) {
        this.billComplementPort = billComplementPort;
        this.saveBillCalculationPort = saveBillCalculationPort;
    }

    @Override
    public CalculatedBill execute(String code, LocalDate payDay) {

        var bill = billComplementPort.execute(code);

        validateBill(bill);

        var expiredDays = getExpiredDays(bill.getDueDate(), payDay);
        var dayFeesValue = DAILY_FEES.multiply(bill.getValue()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        var fees = dayFeesValue.multiply(BigDecimal.valueOf(expiredDays)).setScale(2, RoundingMode.HALF_EVEN);
        var calculatedBill = CalculatedBill.builder()
                .code(bill.getCode())
                .payDay(payDay)
                .fees(fees)
                .dueDate(bill.getDueDate())
                .originalValue(bill.getValue())
                .value(bill.getValue().add(fees))
                .type(bill.getType())
                .build();

        saveBillCalculationPort.execute(calculatedBill);

        return calculatedBill;
    }

    private void validateBill(Bill bill) {
        if (bill == null) {
            throw new ApplicationException(ExceptionType.INVALID_BILL);
        }

        if (bill.getType() != BillType.XPTO) {
            throw new ApplicationException(ExceptionType.INVALID_BILL_TYPE);
        }

        if (bill.getDueDate().isAfter(LocalDate.now())) {
            throw new ApplicationException(ExceptionType.BILL_NOT_EXPIRED);
        }
    }

    private Long getExpiredDays(LocalDate dueDate, LocalDate payDay) {
        return ChronoUnit.DAYS.between(dueDate, payDay);
    }
}
