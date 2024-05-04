package ru.kustikov.cakes.consumables;

import lombok.Data;

@Data
public class ConsumableProduct {
    private Long consumableProductId;

    private Consumable consumable;

    private Double count;
}
