package br.com.billinterest.core.port.in;

import br.com.billinterest.core.domain.CalculatedBill;

import java.time.LocalDate;

public interface CalculateBillPort {
    CalculatedBill execute(String code, LocalDate payDay);
}
