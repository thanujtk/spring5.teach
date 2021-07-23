package org.tk.spring.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StockJpaDaoEM {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StockEntity> getAllStocks() {
        return entityManager.createNamedQuery(StockEntity.QUERY_ALL).getResultList();
    }
}
