package com.bean;

import java.math.BigDecimal;

public class TParkInOut extends TParkInOutExtend{
    private Integer id;

    private Integer companyId;

    private Integer parkId;

    private String occurTime;

    private String inCarPlate;

    private String inCardCode;

    private String inPicPath;

    private String inTime;

    private Integer inType;

    private String inTypeDesc;

    private Integer inPortId;

    private String inPortName;

    private String outCardCode;

    private String outCarPlate;

    private String outPicPath;

    private Integer outCarType;

    private String outTime;

    private String stopTime;

    private Integer outType;

    private String outTypeDesc;

    private Integer outPortId;

    private String outPortName;

    private BigDecimal needPay;

    private BigDecimal actualPay;

    private BigDecimal beforePay;

    private Integer chargeType;

    private String dutyPerson;

    private Integer carNature;

    private String localId;

    private String orderId;

    private Integer memberId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime == null ? null : occurTime.trim();
    }

    public String getInCarPlate() {
        return inCarPlate;
    }

    public void setInCarPlate(String inCarPlate) {
        this.inCarPlate = inCarPlate == null ? null : inCarPlate.trim();
    }

    public String getInCardCode() {
        return inCardCode;
    }

    public void setInCardCode(String inCardCode) {
        this.inCardCode = inCardCode == null ? null : inCardCode.trim();
    }

    public String getInPicPath() {
        return inPicPath;
    }

    public void setInPicPath(String inPicPath) {
        this.inPicPath = inPicPath == null ? null : inPicPath.trim();
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime == null ? null : inTime.trim();
    }

    public Integer getInType() {
        return inType;
    }

    public void setInType(Integer inType) {
        this.inType = inType;
    }

    public String getInTypeDesc() {
        return inTypeDesc;
    }

    public void setInTypeDesc(String inTypeDesc) {
        this.inTypeDesc = inTypeDesc == null ? null : inTypeDesc.trim();
    }

    public Integer getInPortId() {
        return inPortId;
    }

    public void setInPortId(Integer inPortId) {
        this.inPortId = inPortId;
    }

    public String getInPortName() {
        return inPortName;
    }

    public void setInPortName(String inPortName) {
        this.inPortName = inPortName == null ? null : inPortName.trim();
    }

    public String getOutCardCode() {
        return outCardCode;
    }

    public void setOutCardCode(String outCardCode) {
        this.outCardCode = outCardCode == null ? null : outCardCode.trim();
    }

    public String getOutCarPlate() {
        return outCarPlate;
    }

    public void setOutCarPlate(String outCarPlate) {
        this.outCarPlate = outCarPlate == null ? null : outCarPlate.trim();
    }

    public String getOutPicPath() {
        return outPicPath;
    }

    public void setOutPicPath(String outPicPath) {
        this.outPicPath = outPicPath == null ? null : outPicPath.trim();
    }

    public Integer getOutCarType() {
        return outCarType;
    }

    public void setOutCarType(Integer outCarType) {
        this.outCarType = outCarType;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime == null ? null : stopTime.trim();
    }

    public Integer getOutType() {
        return outType;
    }

    public void setOutType(Integer outType) {
        this.outType = outType;
    }

    public String getOutTypeDesc() {
        return outTypeDesc;
    }

    public void setOutTypeDesc(String outTypeDesc) {
        this.outTypeDesc = outTypeDesc == null ? null : outTypeDesc.trim();
    }

    public Integer getOutPortId() {
        return outPortId;
    }

    public void setOutPortId(Integer outPortId) {
        this.outPortId = outPortId;
    }

    public String getOutPortName() {
        return outPortName;
    }

    public void setOutPortName(String outPortName) {
        this.outPortName = outPortName == null ? null : outPortName.trim();
    }

    public BigDecimal getNeedPay() {
        return needPay;
    }

    public void setNeedPay(BigDecimal needPay) {
        this.needPay = needPay;
    }

    public BigDecimal getActualPay() {
        return actualPay;
    }

    public void setActualPay(BigDecimal actualPay) {
        this.actualPay = actualPay;
    }

    public BigDecimal getBeforePay() {
        return beforePay;
    }

    public void setBeforePay(BigDecimal beforePay) {
        this.beforePay = beforePay;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public String getDutyPerson() {
        return dutyPerson;
    }

    public void setDutyPerson(String dutyPerson) {
        this.dutyPerson = dutyPerson == null ? null : dutyPerson.trim();
    }

    public Integer getCarNature() {
        return carNature;
    }

    public void setCarNature(Integer carNature) {
        this.carNature = carNature;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId == null ? null : localId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}