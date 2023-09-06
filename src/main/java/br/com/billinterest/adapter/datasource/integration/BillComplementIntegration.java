package br.com.billinterest.adapter.datasource.integration;

import br.com.billinterest.adapter.datasource.integration.client.BillComplementClient;
import br.com.billinterest.adapter.datasource.mapper.BillMapper;
import br.com.billinterest.core.domain.Bill;
import br.com.billinterest.core.port.out.BillComplementPort;
import org.springframework.stereotype.Component;

@Component
public class BillComplementIntegration implements BillComplementPort {

    private final BillComplementClient client;
    private final BillMapper mapper;

    public BillComplementIntegration(BillComplementClient client, BillMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public Bill execute(String code) {
        var billDTO = client.getBill(code);
        return mapper.toDomain(billDTO);
    }
}
