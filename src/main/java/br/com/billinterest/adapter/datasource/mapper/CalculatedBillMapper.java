package br.com.billinterest.adapter.datasource.mapper;

import br.com.billinterest.adapter.datasource.database.entity.CalculatedBillEntity;
import br.com.billinterest.core.domain.CalculatedBill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculatedBillMapper {
    CalculatedBillEntity toEntity(CalculatedBill calculatedBill);
}
