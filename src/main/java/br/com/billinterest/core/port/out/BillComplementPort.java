package br.com.billinterest.core.port.out;

import br.com.billinterest.core.domain.Bill;

public interface BillComplementPort {
    Bill execute(String code);
}
