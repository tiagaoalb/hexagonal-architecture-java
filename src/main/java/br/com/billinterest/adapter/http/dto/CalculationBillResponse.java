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

    @JsonProperty("coodigo")
    private String code;
    @JsonProperty("data_vencimento")
    private LocalDate dueDate;
    @JsonProperty("valor")
    private BigDecimal value;
    @JsonProperty("tipo")
    private BillType type;
}
