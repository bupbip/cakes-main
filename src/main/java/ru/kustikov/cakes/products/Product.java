package ru.kustikov.cakes.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ru.kustikov.cakes.consumables.Consumable;
import ru.kustikov.cakes.consumables.ConsumableProduct;
import ru.kustikov.cakes.filling.Filling;
import ru.kustikov.cakes.producttype.ProductType;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Product {
    private Long productId;

    private String name;

    private BigDecimal price;

    private Integer count;

    private Double weight;

    private Filling topping;

    private String comment;

    private ProductType productType;

    private String image;

    private String ownerUsername;

    private List<ConsumableProduct> consumableProducts;
}
