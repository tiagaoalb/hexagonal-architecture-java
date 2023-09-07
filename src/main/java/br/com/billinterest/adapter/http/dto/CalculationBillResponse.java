package br.com.billinterest.adapter.http.dto;

import br.com.billinterest.core.domain.enums.BillType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CalculationBillResponse {

    private String codigo;
    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private BillType tipo;
}
