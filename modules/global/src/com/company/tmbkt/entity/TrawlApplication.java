

/*
 * Copyright (c) 2020 com.haulmont.thesis.core.entity
 */
package com.company.tmbkt.entity;

import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.Messages;

import com.haulmont.thesis.core.entity.Doc;

import com.haulmont.thesis.core.global.EntityCopyUtils;
import org.apache.commons.lang.StringUtils;
import com.haulmont.thesis.core.entity.HasDetailedDescription;
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import javax.persistence.OneToOne;
import com.haulmont.thesis.core.entity.Company;
import com.haulmont.thesis.core.entity.Contractor;
import com.haulmont.thesis.core.entity.ContactPerson;
import javax.persistence.Column;
import com.haulmont.thesis.core.entity.NumeratorType;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Владимир Лощилов
 */
@Listeners("thesis_DocEntityListener")
@PrimaryKeyJoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID")
@DiscriminatorValue("1100")
@Table(name = "TMBKT_TRAWL_APPLICATION")
@Entity(name = "tmbkt$TrawlApplication")
@EnableRestore
@TrackEditScreenHistory
public class TrawlApplication extends Doc implements HasDetailedDescription {
    private static final long serialVersionUID = -5965421547512856846L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Contractor customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPPER_ID")
    protected Company shipper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSIGNEE_ID")
    protected Contractor consignee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EQUIPMENT_NAME_ID")
    protected Technics equipmentName;

    @Column(name = "PASSING_CARGO", nullable = false)
    protected Boolean passingCargo = false;

    @Column(name = "POINT_DEPARTURE")
    protected String pointDeparture;

    @Column(name = "POINT_DESTINATION")
    protected String pointDestination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_PERSON_SHIPMENT_ID")
    protected ContactPerson contactPersonShipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_PERSON_UNLOADING_ID")
    protected ContactPerson contactPersonUnloading;

    
    @Column(name = "CATEGIRY_TRALL_APPLICATION")
    protected String categiryTrallApplication;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_DISPATCH_FACT")
    protected Date dateDispatchFact;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ARRIVAL_DATE_FACT")
    protected Date arrivalDateFact;

    @Column(name = "TRANSPORTATION_COST")
    protected Double transportationCost;

    @Column(name = "DESIRED_TRANSPORTATION_COST")
    protected Double desiredTransportationCost;

    @Temporal(TemporalType.DATE)
    @Column(name = "DESIRED_DELIVERY_TIME")
    protected Date desiredDeliveryTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "DESIRED_DATE_SHIPMENT")
    protected Date desiredDateShipment;

    @Column(name = "SPECIFY_CHARACTERISTICS")
    protected Boolean specifyCharacteristics;

    @Column(name = "OUR_TRAWL")
    protected Boolean ourTrawl;

    @Column(name = "TRANSPORTATION_EQUIPMENT")
    protected Boolean transportationEquipment;

    @Column(name = "THE_NEED_USE_CRANE")
    protected Boolean theNeedUseCrane;

    @Column(name = "NUMBER_SEATS")
    protected Integer numberSeats;

    @Column(name = "ADDITIONAL_CARGO")
    protected String additionalCargo;

    @Column(name = "ADDITIONAL_WEIGHT")
    protected Double additionalWeight;

    @Column(name = "ADDITIONAL_LOAD_LENGTH")
    protected Double additionalLoadLength;

    @Column(name = "ADDITIONAL_LOAD_WIDTH")
    protected Double additionalLoadWidth;

    @Column(name = "ADDITIONAL_LOAD_HEIGHT")
    protected Double additionalLoadHeight;

    @Column(name = "THIRD_PARTY_CARRIER")
    protected Boolean thirdPartyCarrier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THIRD_PARTY_CARRIER_NAME_ID")
    protected Contractor thirdPartyCarrierName;

    public Contractor getThirdPartyCarrierName() {
        return thirdPartyCarrierName;
    }

    public void setThirdPartyCarrierName(Contractor thirdPartyCarrierName) {
        this.thirdPartyCarrierName = thirdPartyCarrierName;
    }



    public void setThirdPartyCarrier(Boolean thirdPartyCarrier) {
        this.thirdPartyCarrier = thirdPartyCarrier;
    }

    public Boolean getThirdPartyCarrier() {
        return thirdPartyCarrier;
    }


    public void setAdditionalLoadHeight(Double additionalLoadHeight) {
        this.additionalLoadHeight = additionalLoadHeight;
    }

    public Double getAdditionalLoadHeight() {
        return additionalLoadHeight;
    }


    public void setAdditionalCargo(String additionalCargo) {
        this.additionalCargo = additionalCargo;
    }

    public String getAdditionalCargo() {
        return additionalCargo;
    }

    public void setAdditionalWeight(Double additionalWeight) {
        this.additionalWeight = additionalWeight;
    }

    public Double getAdditionalWeight() {
        return additionalWeight;
    }

    public void setAdditionalLoadLength(Double additionalLoadLength) {
        this.additionalLoadLength = additionalLoadLength;
    }

    public Double getAdditionalLoadLength() {
        return additionalLoadLength;
    }

    public void setAdditionalLoadWidth(Double additionalLoadWidth) {
        this.additionalLoadWidth = additionalLoadWidth;
    }

    public Double getAdditionalLoadWidth() {
        return additionalLoadWidth;
    }


    public void setSpecifyCharacteristics(Boolean specifyCharacteristics) {
        this.specifyCharacteristics = specifyCharacteristics;
    }

    public Boolean getSpecifyCharacteristics() {
        return specifyCharacteristics;
    }

    public void setOurTrawl(Boolean ourTrawl) {
        this.ourTrawl = ourTrawl;
    }

    public Boolean getOurTrawl() {
        return ourTrawl;
    }

    public void setTransportationEquipment(Boolean transportationEquipment) {
        this.transportationEquipment = transportationEquipment;
    }

    public Boolean getTransportationEquipment() {
        return transportationEquipment;
    }

    public void setTheNeedUseCrane(Boolean theNeedUseCrane) {
        this.theNeedUseCrane = theNeedUseCrane;
    }

    public Boolean getTheNeedUseCrane() {
        return theNeedUseCrane;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }


    public void setDesiredDateShipment(Date desiredDateShipment) {
        this.desiredDateShipment = desiredDateShipment;
    }

    public Date getDesiredDateShipment() {
        return desiredDateShipment;
    }


    public void setDesiredTransportationCost(Double desiredTransportationCost) {
        this.desiredTransportationCost = desiredTransportationCost;
    }

    public Double getDesiredTransportationCost() {
        return desiredTransportationCost;
    }

    public void setDesiredDeliveryTime(Date desiredDeliveryTime) {
        this.desiredDeliveryTime = desiredDeliveryTime;
    }

    public Date getDesiredDeliveryTime() {
        return desiredDeliveryTime;
    }


    public void setDateDispatchFact(Date dateDispatchFact) {
        this.dateDispatchFact = dateDispatchFact;
    }

    public Date getDateDispatchFact() {
        return dateDispatchFact;
    }

    public void setArrivalDateFact(Date arrivalDateFact) {
        this.arrivalDateFact = arrivalDateFact;
    }

    public Date getArrivalDateFact() {
        return arrivalDateFact;
    }

    public void setTransportationCost(Double transportationCost) {
        this.transportationCost = transportationCost;
    }

    public Double getTransportationCost() {
        return transportationCost;
    }


    public void setCategiryTrallApplication(CategiryTrallApplication categiryTrallApplication) {
        this.categiryTrallApplication = categiryTrallApplication == null ? null : categiryTrallApplication.getId();
    }

    public CategiryTrallApplication getCategiryTrallApplication() {
        return categiryTrallApplication == null ? null : CategiryTrallApplication.fromId(categiryTrallApplication);
    }


    public void setPassingCargo(Boolean passingCargo) {
        this.passingCargo = passingCargo;
    }

    public Boolean getPassingCargo() {
        return passingCargo;
    }

    public void setPointDeparture(String pointDeparture) {
        this.pointDeparture = pointDeparture;
    }

    public String getPointDeparture() {
        return pointDeparture;
    }

    public void setPointDestination(String pointDestination) {
        this.pointDestination = pointDestination;
    }

    public String getPointDestination() {
        return pointDestination;
    }

    public void setContactPersonShipment(ContactPerson contactPersonShipment) {
        this.contactPersonShipment = contactPersonShipment;
    }

    public ContactPerson getContactPersonShipment() {
        return contactPersonShipment;
    }

    public void setContactPersonUnloading(ContactPerson contactPersonUnloading) {
        this.contactPersonUnloading = contactPersonUnloading;
    }

    public ContactPerson getContactPersonUnloading() {
        return contactPersonUnloading;
    }


    public void setCustomer(Contractor customer) {
        this.customer = customer;
    }

    public Contractor getCustomer() {
        return customer;
    }

    public void setShipper(Company shipper) {
        this.shipper = shipper;
    }

    public Company getShipper() {
        return shipper;
    }

    public void setConsignee(Contractor consignee) {
        this.consignee = consignee;
    }

    public Contractor getConsignee() {
        return consignee;
    }


    public void setEquipmentName(Technics equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Technics getEquipmentName() {
        return equipmentName;
    }



    @Override
    public void copyFrom(Doc srcDoc, Set<com.haulmont.cuba.core.entity.Entity> toCommit, boolean copySignatures,
                         boolean onlyLastAttachmentsVersion, boolean useOriginalAttachmentCreatorAndCreateTs,
                         boolean copyAllVersionMainAttachment) {
        super.copyFrom(srcDoc, toCommit, copySignatures, onlyLastAttachmentsVersion,
                useOriginalAttachmentCreatorAndCreateTs, copyAllVersionMainAttachment);
        Metadata metadata = AppBeans.get(Metadata.NAME);
        MetaClass metaClass = metadata.getClassNN(getClass());
        EntityCopyUtils.copyProperties(srcDoc, this, metaClass.getOwnProperties(), toCommit);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public String getDetailedDescription(Locale locale, boolean includeState, boolean includeShortInfo) {
        Messages messages = AppBeans.get(Messages.NAME);
        String dateFormat = Datatypes.getFormatStrings(locale).getDateFormat();
        String description;
        String locState = getLocState(locale);

        description =
            getDocKind().getName() + " "
                + (StringUtils.isBlank(getNumber()) ? "" : messages.getMessage(Doc.class, "notification.number", locale) + " " + getNumber() + " ")
                + (getDate() == null ? "" : messages.getMessage(Doc.class, "notification.from", locale) + " "
                + new SimpleDateFormat(dateFormat).format(getDate()))
                + (includeState && StringUtils.isNotBlank(locState) ? " [" + locState + "]" : "");


        if (includeShortInfo && (StringUtils.isNotBlank(getTheme()) || StringUtils.isNotBlank(getComment()))) {
            int length = description.length();
            int infoLength = MAX_SUBJECT_LENGTH - length;

            if (infoLength < MIN_SHORT_INFO_LENGTH) return description;

            String shortInfo = StringUtils.defaultIfBlank(getTheme(), getComment());
            return description + " - " + StringUtils.abbreviate(shortInfo, infoLength);
        } else {
            return description;
        }
    }

    
}