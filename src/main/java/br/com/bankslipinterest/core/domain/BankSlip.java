package br.com.bankslipinterest.core.domain;

import br.com.bankslipinterest.core.domain.enums.BankSlipType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class BankSlip {

    private String code;
    private LocalDate dueDate;
    private BigDecimal value;
    private BankSlipType type;
}
