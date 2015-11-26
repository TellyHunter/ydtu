package com.bean;

public class TMemberCar {
    private Integer id;

    private Integer memberId;

    private String carPlate;

    private String carColor;

    private String carIdentiNum;

    private String carEngineNum;

    private String remark;

    private String driverImg;

    private String carImg;

    private String carType;

    private String status;

    private String payAuto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate == null ? null : carPlate.trim();
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    public String getCarIdentiNum() {
        return carIdentiNum;
    }

    public void setCarIdentiNum(String carIdentiNum) {
        this.carIdentiNum = carIdentiNum == null ? null : carIdentiNum.trim();
    }

    public String getCarEngineNum() {
        return carEngineNum;
    }

    public void setCarEngineNum(String carEngineNum) {
        this.carEngineNum = carEngineNum == null ? null : carEngineNum.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDriverImg() {
        return driverImg;
    }

    public void setDriverImg(String driverImg) {
        this.driverImg = driverImg == null ? null : driverImg.trim();
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg == null ? null : carImg.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPayAuto() {
        return payAuto;
    }

    public void setPayAuto(String payAuto) {
        this.payAuto = payAuto == null ? null : payAuto.trim();
    }
}