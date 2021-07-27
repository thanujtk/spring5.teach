package org.tk.spring.jpa3;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stocks")
@Data
@ToString
public class Stock3Entity {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private double price;
}
