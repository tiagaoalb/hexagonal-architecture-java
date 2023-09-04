package br.com.billinterest.core.domain;

import br.com.billinterest.core.domain.enums.BillType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Bill {

    private String code;
    private LocalDate dueDate;
    private BigDecimal value;
    private BillType type;
}
