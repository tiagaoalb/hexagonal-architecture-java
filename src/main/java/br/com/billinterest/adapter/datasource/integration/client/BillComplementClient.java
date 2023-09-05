package br.com.billinterest.adapter.datasource.integration.client;

import br.com.billinterest.adapter.datasource.integration.dto.BillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "complement", url = "${api.boleto}")
public interface BillComplementClient {

    @GetMapping("/{code}")
    BillDTO getBill(@PathVariable(value = "code") String code);
}
