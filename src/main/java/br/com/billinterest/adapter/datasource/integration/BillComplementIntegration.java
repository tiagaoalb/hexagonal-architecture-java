package br.com.billinterest.adapter.datasource.integration;

import br.com.billinterest.adapter.datasource.integration.client.BillComplementClient;
import br.com.billinterest.core.domain.Bill;
import br.com.billinterest.core.port.out.BillComplementPort;

public class BillComplementIntegration implements BillComplementPort {

    private final BillComplementClient client;

    public BillComplementIntegration(BillComplementClient client) {
        this.client = client;
    }

    @Override
    public Bill execute(String code) {
        var billDTO = client.getBill(code);
        return null;
    }
}
