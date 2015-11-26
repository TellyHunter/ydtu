package com.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TCompanyParkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TCompanyParkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andParkNameIsNull() {
            addCriterion("park_name is null");
            return (Criteria) this;
        }

        public Criteria andParkNameIsNotNull() {
            addCriterion("park_name is not null");
            return (Criteria) this;
        }

        public Criteria andParkNameEqualTo(String value) {
            addCriterion("park_name =", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotEqualTo(String value) {
            addCriterion("park_name <>", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameGreaterThan(String value) {
            addCriterion("park_name >", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameGreaterThanOrEqualTo(String value) {
            addCriterion("park_name >=", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLessThan(String value) {
            addCriterion("park_name <", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLessThanOrEqualTo(String value) {
            addCriterion("park_name <=", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLike(String value) {
            addCriterion("park_name like", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotLike(String value) {
            addCriterion("park_name not like", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameIn(List<String> values) {
            addCriterion("park_name in", values, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotIn(List<String> values) {
            addCriterion("park_name not in", values, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameBetween(String value1, String value2) {
            addCriterion("park_name between", value1, value2, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotBetween(String value1, String value2) {
            addCriterion("park_name not between", value1, value2, "parkName");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceIsNull() {
            addCriterion("total_parking_space is null");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceIsNotNull() {
            addCriterion("total_parking_space is not null");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceEqualTo(Integer value) {
            addCriterion("total_parking_space =", value, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceNotEqualTo(Integer value) {
            addCriterion("total_parking_space <>", value, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceGreaterThan(Integer value) {
            addCriterion("total_parking_space >", value, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_parking_space >=", value, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceLessThan(Integer value) {
            addCriterion("total_parking_space <", value, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceLessThanOrEqualTo(Integer value) {
            addCriterion("total_parking_space <=", value, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceIn(List<Integer> values) {
            addCriterion("total_parking_space in", values, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceNotIn(List<Integer> values) {
            addCriterion("total_parking_space not in", values, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceBetween(Integer value1, Integer value2) {
            addCriterion("total_parking_space between", value1, value2, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andTotalParkingSpaceNotBetween(Integer value1, Integer value2) {
            addCriterion("total_parking_space not between", value1, value2, "totalParkingSpace");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNull() {
            addCriterion("position_x is null");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNotNull() {
            addCriterion("position_x is not null");
            return (Criteria) this;
        }

        public Criteria andPositionXEqualTo(String value) {
            addCriterion("position_x =", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotEqualTo(String value) {
            addCriterion("position_x <>", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThan(String value) {
            addCriterion("position_x >", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThanOrEqualTo(String value) {
            addCriterion("position_x >=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThan(String value) {
            addCriterion("position_x <", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThanOrEqualTo(String value) {
            addCriterion("position_x <=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLike(String value) {
            addCriterion("position_x like", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotLike(String value) {
            addCriterion("position_x not like", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXIn(List<String> values) {
            addCriterion("position_x in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotIn(List<String> values) {
            addCriterion("position_x not in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXBetween(String value1, String value2) {
            addCriterion("position_x between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotBetween(String value1, String value2) {
            addCriterion("position_x not between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNull() {
            addCriterion("position_y is null");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNotNull() {
            addCriterion("position_y is not null");
            return (Criteria) this;
        }

        public Criteria andPositionYEqualTo(String value) {
            addCriterion("position_y =", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotEqualTo(String value) {
            addCriterion("position_y <>", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThan(String value) {
            addCriterion("position_y >", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThanOrEqualTo(String value) {
            addCriterion("position_y >=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThan(String value) {
            addCriterion("position_y <", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThanOrEqualTo(String value) {
            addCriterion("position_y <=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLike(String value) {
            addCriterion("position_y like", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotLike(String value) {
            addCriterion("position_y not like", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYIn(List<String> values) {
            addCriterion("position_y in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotIn(List<String> values) {
            addCriterion("position_y not in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYBetween(String value1, String value2) {
            addCriterion("position_y between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotBetween(String value1, String value2) {
            addCriterion("position_y not between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andMonthRuleIsNull() {
            addCriterion("month_rule is null");
            return (Criteria) this;
        }

        public Criteria andMonthRuleIsNotNull() {
            addCriterion("month_rule is not null");
            return (Criteria) this;
        }

        public Criteria andMonthRuleEqualTo(Byte value) {
            addCriterion("month_rule =", value, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleNotEqualTo(Byte value) {
            addCriterion("month_rule <>", value, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleGreaterThan(Byte value) {
            addCriterion("month_rule >", value, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleGreaterThanOrEqualTo(Byte value) {
            addCriterion("month_rule >=", value, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleLessThan(Byte value) {
            addCriterion("month_rule <", value, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleLessThanOrEqualTo(Byte value) {
            addCriterion("month_rule <=", value, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleIn(List<Byte> values) {
            addCriterion("month_rule in", values, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleNotIn(List<Byte> values) {
            addCriterion("month_rule not in", values, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleBetween(Byte value1, Byte value2) {
            addCriterion("month_rule between", value1, value2, "monthRule");
            return (Criteria) this;
        }

        public Criteria andMonthRuleNotBetween(Byte value1, Byte value2) {
            addCriterion("month_rule not between", value1, value2, "monthRule");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNull() {
            addCriterion("bank_card is null");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNotNull() {
            addCriterion("bank_card is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardEqualTo(String value) {
            addCriterion("bank_card =", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotEqualTo(String value) {
            addCriterion("bank_card <>", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThan(String value) {
            addCriterion("bank_card >", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card >=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThan(String value) {
            addCriterion("bank_card <", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThanOrEqualTo(String value) {
            addCriterion("bank_card <=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLike(String value) {
            addCriterion("bank_card like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotLike(String value) {
            addCriterion("bank_card not like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardIn(List<String> values) {
            addCriterion("bank_card in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotIn(List<String> values) {
            addCriterion("bank_card not in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardBetween(String value1, String value2) {
            addCriterion("bank_card between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotBetween(String value1, String value2) {
            addCriterion("bank_card not between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSyncKeyIsNull() {
            addCriterion("sync_key is null");
            return (Criteria) this;
        }

        public Criteria andSyncKeyIsNotNull() {
            addCriterion("sync_key is not null");
            return (Criteria) this;
        }

        public Criteria andSyncKeyEqualTo(String value) {
            addCriterion("sync_key =", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyNotEqualTo(String value) {
            addCriterion("sync_key <>", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyGreaterThan(String value) {
            addCriterion("sync_key >", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sync_key >=", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyLessThan(String value) {
            addCriterion("sync_key <", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyLessThanOrEqualTo(String value) {
            addCriterion("sync_key <=", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyLike(String value) {
            addCriterion("sync_key like", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyNotLike(String value) {
            addCriterion("sync_key not like", value, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyIn(List<String> values) {
            addCriterion("sync_key in", values, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyNotIn(List<String> values) {
            addCriterion("sync_key not in", values, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyBetween(String value1, String value2) {
            addCriterion("sync_key between", value1, value2, "syncKey");
            return (Criteria) this;
        }

        public Criteria andSyncKeyNotBetween(String value1, String value2) {
            addCriterion("sync_key not between", value1, value2, "syncKey");
            return (Criteria) this;
        }

        public Criteria andParklogoIsNull() {
            addCriterion("parkLogo is null");
            return (Criteria) this;
        }

        public Criteria andParklogoIsNotNull() {
            addCriterion("parkLogo is not null");
            return (Criteria) this;
        }

        public Criteria andParklogoEqualTo(String value) {
            addCriterion("parkLogo =", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoNotEqualTo(String value) {
            addCriterion("parkLogo <>", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoGreaterThan(String value) {
            addCriterion("parkLogo >", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoGreaterThanOrEqualTo(String value) {
            addCriterion("parkLogo >=", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoLessThan(String value) {
            addCriterion("parkLogo <", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoLessThanOrEqualTo(String value) {
            addCriterion("parkLogo <=", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoLike(String value) {
            addCriterion("parkLogo like", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoNotLike(String value) {
            addCriterion("parkLogo not like", value, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoIn(List<String> values) {
            addCriterion("parkLogo in", values, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoNotIn(List<String> values) {
            addCriterion("parkLogo not in", values, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoBetween(String value1, String value2) {
            addCriterion("parkLogo between", value1, value2, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParklogoNotBetween(String value1, String value2) {
            addCriterion("parkLogo not between", value1, value2, "parklogo");
            return (Criteria) this;
        }

        public Criteria andParkcarnumIsNull() {
            addCriterion("parkCarNum is null");
            return (Criteria) this;
        }

        public Criteria andParkcarnumIsNotNull() {
            addCriterion("parkCarNum is not null");
            return (Criteria) this;
        }

        public Criteria andParkcarnumEqualTo(String value) {
            addCriterion("parkCarNum =", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumNotEqualTo(String value) {
            addCriterion("parkCarNum <>", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumGreaterThan(String value) {
            addCriterion("parkCarNum >", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumGreaterThanOrEqualTo(String value) {
            addCriterion("parkCarNum >=", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumLessThan(String value) {
            addCriterion("parkCarNum <", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumLessThanOrEqualTo(String value) {
            addCriterion("parkCarNum <=", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumLike(String value) {
            addCriterion("parkCarNum like", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumNotLike(String value) {
            addCriterion("parkCarNum not like", value, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumIn(List<String> values) {
            addCriterion("parkCarNum in", values, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumNotIn(List<String> values) {
            addCriterion("parkCarNum not in", values, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumBetween(String value1, String value2) {
            addCriterion("parkCarNum between", value1, value2, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andParkcarnumNotBetween(String value1, String value2) {
            addCriterion("parkCarNum not between", value1, value2, "parkcarnum");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}