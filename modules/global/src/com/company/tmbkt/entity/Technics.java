/*
 * Copyright (c) 2020 com.company.tmbkt.entity
 */
package com.company.tmbkt.entity;


/**
 * @author Владимир Лощилов
 */
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import java.math.BigDecimal;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@NamePattern("%s %s|nomination,code")
@Table(name = "TMBKT_TECHNICS")
@Entity(name = "tmbkt$Technics")
@EnableRestore
@TrackEditScreenHistory
public class Technics extends StandardEntity {
    private static final long serialVersionUID = -843386808458864188L;

    @Column(name = "CODE", nullable = false, length = 6)
    protected String code;

    @Column(name = "NOMINATION", nullable = false, length = 100)
    protected String nomination;

    @Column(name = "MODEL", length = 100)
    protected String model;

    @Column(name = "COMAR", length = 64)
    protected String comar;

    @Column(name = "SERIAL_NUMBER", length = 64)
    protected String serialNumber;

    @Column(name = "WEIGHT", length = 50, precision = 10, scale = 3)
    protected BigDecimal weight;

    @Column(name = "WIDTH", length = 50, precision = 10, scale = 3)
    protected BigDecimal width;

    @Column(name = "LENGTH", length = 50, precision = 10, scale = 3)
    protected BigDecimal length;

    @Column(name = "DEPTH", length = 50, precision = 10, scale = 3)
    protected BigDecimal depth;

    @Column(name = "SECOND_HAND", length = 50)
    protected Boolean secondHand;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public String getNomination() {
        return nomination;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setComar(String comar) {
        this.comar = comar;
    }

    public String getComar() {
        return comar;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setSecondHand(Boolean secondHand) {
        this.secondHand = secondHand;
    }

    public Boolean getSecondHand() {
        return secondHand;
    }


}