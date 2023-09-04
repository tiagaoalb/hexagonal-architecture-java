package br.com.bankslipinterest.core.port.out;

import br.com.bankslipinterest.core.domain.BankSlip;

public interface BankSlipComplementPort {
    BankSlip execute(String code);
}
