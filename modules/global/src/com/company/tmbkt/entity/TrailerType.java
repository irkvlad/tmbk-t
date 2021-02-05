/*
 * Copyright (c) 2021 com.company.tmbkt.entity
 */
package com.company.tmbkt.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

/**
 * @author loshilovvladimir
 */
public enum TrailerType implements EnumClass<String> {

    LowProfileTrawl("LOWTRAWL"),
    Eurofura("EUROFURA"),
    LightTruck("LIGHTTRUCK");

    private String id;

    TrailerType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TrailerType fromId(String id) {
        for (TrailerType at : TrailerType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}