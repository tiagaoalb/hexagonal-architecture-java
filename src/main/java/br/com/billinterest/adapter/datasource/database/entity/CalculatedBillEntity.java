package br.com.billinterest.adapter.datasource.database.entity;

import br.com.billinterest.core.domain.enums.BillType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "calculated_bill")
@Getter
@Setter
public class CalculatedBillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;
    @Column(name = "original_value")
    private BigDecimal originalValue;
    @Column
    private BigDecimal value;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "pay_day")
    private LocalDate payDay;
    @Column
    private BigDecimal fees;
    @Column
    private BillType type;
}
