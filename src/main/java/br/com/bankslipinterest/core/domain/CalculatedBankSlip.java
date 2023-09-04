package br.com.bankslipinterest.core.domain;

import br.com.bankslipinterest.core.domain.enums.BankSlipType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CalculatedBankSlip {

    private String code;
    private BigDecimal originalValue;
    private BigDecimal value;
    private LocalDate dueDate;
    private LocalDate payDay;
    private BigDecimal fees;
    private BankSlipType type;
}
