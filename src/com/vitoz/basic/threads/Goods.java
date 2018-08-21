package com.vitoz.basic.threads;

import java.util.Random;

public class Goods{
    private String name = "商品";
    private int id = Math.abs(new Random().nextInt());

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Goods{name="+this.getName()+", id="+this.getId()+"}";
    }
}