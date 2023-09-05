package br.com.billinterest.adapter.datasource.mapper;

import br.com.billinterest.adapter.datasource.integration.dto.BillDTO;
import br.com.billinterest.core.domain.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill toDomain(BillDTO billDTO);
}
