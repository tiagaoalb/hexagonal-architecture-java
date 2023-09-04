package br.com.bankslipinterest.core.port.out;

import br.com.bankslipinterest.core.domain.Bill;

public interface BillComplementPort {
    Bill execute(String code);
}
