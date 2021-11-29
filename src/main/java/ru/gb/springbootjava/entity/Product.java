package ru.gb.springbootjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private double cost;

    @Override
    public String toString() {
        return id + " " + title + " " + cost;
    }

    public Product(){}
}
