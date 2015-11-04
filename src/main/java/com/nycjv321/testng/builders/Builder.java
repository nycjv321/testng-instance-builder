package com.nycjv321.testng.builders;

/**
 * Created by fedora on 11/3/15.
 */
public abstract class Builder<T, B extends Builder<T, B>> {
    private T entity;

    protected T getEntity() {
        return entity;
    }

    protected void setEntity(T entity) {
        this.entity = entity;
    }

    public abstract B getThis();

    public T build() {
        return entity;
    }

}