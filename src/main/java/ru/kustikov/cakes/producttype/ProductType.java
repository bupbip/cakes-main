package ru.kustikov.cakes.producttype;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ProductType {
    private Long productTypeId;

    private String name;

    private boolean canOrder;

    private boolean canWeight;

    private boolean canCount;

    private ArrayList<Integer> fillings;
}
