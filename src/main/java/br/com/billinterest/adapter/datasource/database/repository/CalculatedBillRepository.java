package br.com.billinterest.adapter.datasource.database.repository;

import br.com.billinterest.adapter.datasource.database.entity.CalculatedBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatedBillRepository extends JpaRepository<CalculatedBillEntity, Long> {
}
