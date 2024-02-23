package com.ulas.entity.impl;

public abstract class Entity {
    private static long nextId = 0;
    private long id;

    public Entity() {
        this.id = nextId++;
    }

    public long getId() {
        return id;
    }
}
