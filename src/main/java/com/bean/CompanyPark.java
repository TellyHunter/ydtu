package com.bean;

import java.math.BigDecimal;

public class CompanyPark {
    private Integer id;

    private Integer companyId;

    private String parkName;

    private Integer totalParkingSpace;

    private String address;

    private String positionX;

    private String positionY;

    private Byte monthRule;

    private String bankName;

    private String bankCard;

    private String bankAccount;

    private BigDecimal rate;

    private String remark;

    private String syncKey;

    private String parklogo;

    private String parkcarnum;

    private String type;

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

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public Integer getTotalParkingSpace() {
        return totalParkingSpace;
    }

    public void setTotalParkingSpace(Integer totalParkingSpace) {
        this.totalParkingSpace = totalParkingSpace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX == null ? null : positionX.trim();
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY == null ? null : positionY.trim();
    }

    public Byte getMonthRule() {
        return monthRule;
    }

    public void setMonthRule(Byte monthRule) {
        this.monthRule = monthRule;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSyncKey() {
        return syncKey;
    }

    public void setSyncKey(String syncKey) {
        this.syncKey = syncKey == null ? null : syncKey.trim();
    }

    public String getParklogo() {
        return parklogo;
    }

    public void setParklogo(String parklogo) {
        this.parklogo = parklogo == null ? null : parklogo.trim();
    }

    public String getParkcarnum() {
        return parkcarnum;
    }

    public void setParkcarnum(String parkcarnum) {
        this.parkcarnum = parkcarnum == null ? null : parkcarnum.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}