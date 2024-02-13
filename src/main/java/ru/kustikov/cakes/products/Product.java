package ru.kustikov.cakes.products;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long productId;

    private String name;

    private BigDecimal price;

    private Integer count;

    private Double weight;

    private String topping;

    private String comment;

    private String type;

    private byte[] image;
}
