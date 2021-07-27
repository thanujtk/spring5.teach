package org.tk.spring.jpa2;

import lombok.Data;
import lombok.ToString;
import org.tk.spring.jpa.StockEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stocks")
@Data
@ToString
public class Stock2Entity {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private double price;
}
