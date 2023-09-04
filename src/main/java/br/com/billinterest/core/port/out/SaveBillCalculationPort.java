package br.com.billinterest.core.port.out;

import br.com.billinterest.core.domain.CalculatedBill;

public interface SaveBillCalculationPort {
    void execute(CalculatedBill calculatedBill);
}
