package br.com.bankslipinterest.core.port.in;

import br.com.bankslipinterest.core.domain.CalculatedBill;

import java.time.LocalDate;

public interface CalculateBillPort {
    CalculatedBill execute(String code, LocalDate payDay);
}
