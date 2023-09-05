package br.com.billinterest.adapter.datasource.database;

import br.com.billinterest.adapter.datasource.database.repository.CalculatedBillRepository;
import br.com.billinterest.adapter.datasource.mapper.CalculatedBillMapper;
import br.com.billinterest.core.domain.CalculatedBill;
import br.com.billinterest.core.port.out.SaveBillCalculationPort;
import org.springframework.stereotype.Component;

@Component
public class SaveCalculatedBill implements SaveBillCalculationPort {

    private final CalculatedBillRepository repository;
    private final CalculatedBillMapper mapper;

    public SaveCalculatedBill(CalculatedBillRepository repository, CalculatedBillMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void execute(CalculatedBill calculatedBill) {
        var entity = mapper.toEntity(calculatedBill);
        repository.save(entity);
    }
}
