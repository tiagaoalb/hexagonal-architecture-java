package br.com.bankslipinterest.core.port.in;

import br.com.bankslipinterest.core.domain.CalculatedBankSlip;

import java.time.LocalDate;

public interface BankSlipCalculatePort {
    CalculatedBankSlip execute(String code, LocalDate payDay);
}
