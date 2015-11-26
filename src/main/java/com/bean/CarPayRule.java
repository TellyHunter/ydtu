package com.bean;

import java.math.BigDecimal;

public class CarPayRule {
    private Integer id;

    private String ruleName;

    private String type;

    private BigDecimal yearFee;

    private BigDecimal seasonFee;

    private BigDecimal monthFee;

    private BigDecimal dayFee;

    private Integer parkId;

    private Integer localId;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getYearFee() {
        return yearFee;
    }

    public void setYearFee(BigDecimal yearFee) {
        this.yearFee = yearFee;
    }

    public BigDecimal getSeasonFee() {
        return seasonFee;
    }

    public void setSeasonFee(BigDecimal seasonFee) {
        this.seasonFee = seasonFee;
    }

    public BigDecimal getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(BigDecimal monthFee) {
        this.monthFee = monthFee;
    }

    public BigDecimal getDayFee() {
        return dayFee;
    }

    public void setDayFee(BigDecimal dayFee) {
        this.dayFee = dayFee;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}