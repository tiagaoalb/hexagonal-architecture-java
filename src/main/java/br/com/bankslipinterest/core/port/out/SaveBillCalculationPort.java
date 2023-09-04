package br.com.bankslipinterest.core.port.out;

import br.com.bankslipinterest.core.domain.CalculatedBill;

public interface SaveBillCalculationPort {
    void execute(CalculatedBill calculatedBankSlip);
}
