package br.com.bankslipinterest.core.port.out;

import br.com.bankslipinterest.core.domain.CalculatedBankSlip;

public interface BankSlipSaveCalculatePort {
    void execute(CalculatedBankSlip calculatedBankSlip);
}
