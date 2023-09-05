package br.com.billinterest.adapter.http.mapper;

import br.com.billinterest.adapter.http.dto.CalculationBillResponse;
import br.com.billinterest.core.domain.CalculatedBill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculationBillMapper {

    CalculationBillResponse toDTO(CalculatedBill calculatedBill);
}
