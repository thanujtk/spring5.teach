package org.tk.spring.jpa;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
@Data
@ToString
@NamedQuery(name = StockEntity.QUERY_ALL, query = "select e from StockEntity e") //Using JPA-QL
public class StockEntity {
    public static final String QUERY_ALL = "StockEntity.findAll";

    @Id
    private String id;
    private String name;
    private double price;
}
