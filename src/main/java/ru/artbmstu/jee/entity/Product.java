package ru.artbmstu.jee.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product extends AbstractEntity{

    private String id;

    private String name = "";

    private String description = "";

    public Product(final String name){
        this.name = name;
    }
}
