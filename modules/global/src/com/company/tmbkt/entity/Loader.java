/*
 * Copyright (c) 2021 com.company.tmbkt.entity
 */
package com.company.tmbkt.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

/**
 * @author loshilovvladimir
 */
public enum Loader implements EnumClass<String> {
    SelfPropelled("SELFPROPELLED"),
    Rampa("RAMPA"),
    Crane("CRANE");

    private String id;

    Loader(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Loader fromId(String id) {
        for (Loader at : Loader.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}