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

        var diasVencidos = getExpiredDays(bill.getDataVencimento(), payDay);
        var valorJurosDia = DAILY_FEES.multiply(bill.getValor()).divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
        var juros = valorJurosDia.multiply(BigDecimal.valueOf(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);
        var boletoCalculado = CalculatedBill.builder()
                .codigo(bill.getCodigo())
                .dataPagamento(payDay)
                .juros(juros)
                .dataVencimento(bill.getDataVencimento())
                .valorOriginal(bill.getValor())
                .valor(bill.getValor().add(juros))
                .tipo(bill.getTipo())
                .build();

        saveBillCalculationPort.execute(boletoCalculado);

        return boletoCalculado;
    }

    private void validateBill(Bill boleto) {
        if (boleto == null) {
            throw new ApplicationException(ExceptionType.INVALID_BILL);
        }

        if (boleto.getTipo() != BillType.XPTO) {
            throw new ApplicationException(ExceptionType.INVALID_BILL_TYPE);
        }

        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
            throw new ApplicationException(ExceptionType.BILL_NOT_EXPIRED);
        }
    }

    private Long getExpiredDays(LocalDate dataVencimento, LocalDate dataPagamento) {
        return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
    }
}
