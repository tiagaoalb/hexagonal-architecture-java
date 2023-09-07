package br.com.billinterest.core.domain;

import br.com.billinterest.core.domain.enums.BillType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CalculatedBill {

    private String codigo;
    private BigDecimal valorOriginal;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal juros;
    private BillType tipo;
}
