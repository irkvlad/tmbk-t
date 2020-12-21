/*
 * Copyright (c) 2020 com.company.tmbkt.entity
 */
package com.company.tmbkt.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

/**
 * @author Владимир Лощилов
 */
public enum CategiryTrallApplication implements EnumClass<String> {

    Marketing("MARKETING"),
    Commercial("COMMERCIAL"),
    Moving("MOVING"),
    Outsourcing("OUTSOURCING");

    private String id;

    CategiryTrallApplication(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CategiryTrallApplication fromId(String id) {
        for (CategiryTrallApplication at : CategiryTrallApplication.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}