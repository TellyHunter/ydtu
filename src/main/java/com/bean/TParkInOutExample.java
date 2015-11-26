package com.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TParkInOutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TParkInOutExample() {
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

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(Integer value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(Integer value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(Integer value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(Integer value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(Integer value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<Integer> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<Integer> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(Integer value1, Integer value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andOccurTimeIsNull() {
            addCriterion("occur_time is null");
            return (Criteria) this;
        }

        public Criteria andOccurTimeIsNotNull() {
            addCriterion("occur_time is not null");
            return (Criteria) this;
        }

        public Criteria andOccurTimeEqualTo(String value) {
            addCriterion("occur_time =", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotEqualTo(String value) {
            addCriterion("occur_time <>", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeGreaterThan(String value) {
            addCriterion("occur_time >", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeGreaterThanOrEqualTo(String value) {
            addCriterion("occur_time >=", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeLessThan(String value) {
            addCriterion("occur_time <", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeLessThanOrEqualTo(String value) {
            addCriterion("occur_time <=", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeLike(String value) {
            addCriterion("occur_time like", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotLike(String value) {
            addCriterion("occur_time not like", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeIn(List<String> values) {
            addCriterion("occur_time in", values, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotIn(List<String> values) {
            addCriterion("occur_time not in", values, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeBetween(String value1, String value2) {
            addCriterion("occur_time between", value1, value2, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotBetween(String value1, String value2) {
            addCriterion("occur_time not between", value1, value2, "occurTime");
            return (Criteria) this;
        }

        public Criteria andInCarPlateIsNull() {
            addCriterion("in_car_plate is null");
            return (Criteria) this;
        }

        public Criteria andInCarPlateIsNotNull() {
            addCriterion("in_car_plate is not null");
            return (Criteria) this;
        }

        public Criteria andInCarPlateEqualTo(String value) {
            addCriterion("in_car_plate =", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateNotEqualTo(String value) {
            addCriterion("in_car_plate <>", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateGreaterThan(String value) {
            addCriterion("in_car_plate >", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateGreaterThanOrEqualTo(String value) {
            addCriterion("in_car_plate >=", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateLessThan(String value) {
            addCriterion("in_car_plate <", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateLessThanOrEqualTo(String value) {
            addCriterion("in_car_plate <=", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateLike(String value) {
            addCriterion("in_car_plate like", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateNotLike(String value) {
            addCriterion("in_car_plate not like", value, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateIn(List<String> values) {
            addCriterion("in_car_plate in", values, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateNotIn(List<String> values) {
            addCriterion("in_car_plate not in", values, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateBetween(String value1, String value2) {
            addCriterion("in_car_plate between", value1, value2, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCarPlateNotBetween(String value1, String value2) {
            addCriterion("in_car_plate not between", value1, value2, "inCarPlate");
            return (Criteria) this;
        }

        public Criteria andInCardCodeIsNull() {
            addCriterion("in_card_code is null");
            return (Criteria) this;
        }

        public Criteria andInCardCodeIsNotNull() {
            addCriterion("in_card_code is not null");
            return (Criteria) this;
        }

        public Criteria andInCardCodeEqualTo(String value) {
            addCriterion("in_card_code =", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeNotEqualTo(String value) {
            addCriterion("in_card_code <>", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeGreaterThan(String value) {
            addCriterion("in_card_code >", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("in_card_code >=", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeLessThan(String value) {
            addCriterion("in_card_code <", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeLessThanOrEqualTo(String value) {
            addCriterion("in_card_code <=", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeLike(String value) {
            addCriterion("in_card_code like", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeNotLike(String value) {
            addCriterion("in_card_code not like", value, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeIn(List<String> values) {
            addCriterion("in_card_code in", values, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeNotIn(List<String> values) {
            addCriterion("in_card_code not in", values, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeBetween(String value1, String value2) {
            addCriterion("in_card_code between", value1, value2, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInCardCodeNotBetween(String value1, String value2) {
            addCriterion("in_card_code not between", value1, value2, "inCardCode");
            return (Criteria) this;
        }

        public Criteria andInPicPathIsNull() {
            addCriterion("in_pic_path is null");
            return (Criteria) this;
        }

        public Criteria andInPicPathIsNotNull() {
            addCriterion("in_pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andInPicPathEqualTo(String value) {
            addCriterion("in_pic_path =", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathNotEqualTo(String value) {
            addCriterion("in_pic_path <>", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathGreaterThan(String value) {
            addCriterion("in_pic_path >", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("in_pic_path >=", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathLessThan(String value) {
            addCriterion("in_pic_path <", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathLessThanOrEqualTo(String value) {
            addCriterion("in_pic_path <=", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathLike(String value) {
            addCriterion("in_pic_path like", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathNotLike(String value) {
            addCriterion("in_pic_path not like", value, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathIn(List<String> values) {
            addCriterion("in_pic_path in", values, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathNotIn(List<String> values) {
            addCriterion("in_pic_path not in", values, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathBetween(String value1, String value2) {
            addCriterion("in_pic_path between", value1, value2, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInPicPathNotBetween(String value1, String value2) {
            addCriterion("in_pic_path not between", value1, value2, "inPicPath");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(String value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(String value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(String value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(String value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(String value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(String value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLike(String value) {
            addCriterion("in_time like", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotLike(String value) {
            addCriterion("in_time not like", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<String> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<String> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(String value1, String value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(String value1, String value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTypeIsNull() {
            addCriterion("in_type is null");
            return (Criteria) this;
        }

        public Criteria andInTypeIsNotNull() {
            addCriterion("in_type is not null");
            return (Criteria) this;
        }

        public Criteria andInTypeEqualTo(Integer value) {
            addCriterion("in_type =", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotEqualTo(Integer value) {
            addCriterion("in_type <>", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeGreaterThan(Integer value) {
            addCriterion("in_type >", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_type >=", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeLessThan(Integer value) {
            addCriterion("in_type <", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeLessThanOrEqualTo(Integer value) {
            addCriterion("in_type <=", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeIn(List<Integer> values) {
            addCriterion("in_type in", values, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotIn(List<Integer> values) {
            addCriterion("in_type not in", values, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeBetween(Integer value1, Integer value2) {
            addCriterion("in_type between", value1, value2, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("in_type not between", value1, value2, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeDescIsNull() {
            addCriterion("in_type_desc is null");
            return (Criteria) this;
        }

        public Criteria andInTypeDescIsNotNull() {
            addCriterion("in_type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andInTypeDescEqualTo(String value) {
            addCriterion("in_type_desc =", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescNotEqualTo(String value) {
            addCriterion("in_type_desc <>", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescGreaterThan(String value) {
            addCriterion("in_type_desc >", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("in_type_desc >=", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescLessThan(String value) {
            addCriterion("in_type_desc <", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescLessThanOrEqualTo(String value) {
            addCriterion("in_type_desc <=", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescLike(String value) {
            addCriterion("in_type_desc like", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescNotLike(String value) {
            addCriterion("in_type_desc not like", value, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescIn(List<String> values) {
            addCriterion("in_type_desc in", values, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescNotIn(List<String> values) {
            addCriterion("in_type_desc not in", values, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescBetween(String value1, String value2) {
            addCriterion("in_type_desc between", value1, value2, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInTypeDescNotBetween(String value1, String value2) {
            addCriterion("in_type_desc not between", value1, value2, "inTypeDesc");
            return (Criteria) this;
        }

        public Criteria andInPortIdIsNull() {
            addCriterion("in_port_id is null");
            return (Criteria) this;
        }

        public Criteria andInPortIdIsNotNull() {
            addCriterion("in_port_id is not null");
            return (Criteria) this;
        }

        public Criteria andInPortIdEqualTo(Integer value) {
            addCriterion("in_port_id =", value, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdNotEqualTo(Integer value) {
            addCriterion("in_port_id <>", value, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdGreaterThan(Integer value) {
            addCriterion("in_port_id >", value, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_port_id >=", value, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdLessThan(Integer value) {
            addCriterion("in_port_id <", value, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdLessThanOrEqualTo(Integer value) {
            addCriterion("in_port_id <=", value, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdIn(List<Integer> values) {
            addCriterion("in_port_id in", values, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdNotIn(List<Integer> values) {
            addCriterion("in_port_id not in", values, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdBetween(Integer value1, Integer value2) {
            addCriterion("in_port_id between", value1, value2, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("in_port_id not between", value1, value2, "inPortId");
            return (Criteria) this;
        }

        public Criteria andInPortNameIsNull() {
            addCriterion("in_port_name is null");
            return (Criteria) this;
        }

        public Criteria andInPortNameIsNotNull() {
            addCriterion("in_port_name is not null");
            return (Criteria) this;
        }

        public Criteria andInPortNameEqualTo(String value) {
            addCriterion("in_port_name =", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameNotEqualTo(String value) {
            addCriterion("in_port_name <>", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameGreaterThan(String value) {
            addCriterion("in_port_name >", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameGreaterThanOrEqualTo(String value) {
            addCriterion("in_port_name >=", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameLessThan(String value) {
            addCriterion("in_port_name <", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameLessThanOrEqualTo(String value) {
            addCriterion("in_port_name <=", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameLike(String value) {
            addCriterion("in_port_name like", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameNotLike(String value) {
            addCriterion("in_port_name not like", value, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameIn(List<String> values) {
            addCriterion("in_port_name in", values, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameNotIn(List<String> values) {
            addCriterion("in_port_name not in", values, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameBetween(String value1, String value2) {
            addCriterion("in_port_name between", value1, value2, "inPortName");
            return (Criteria) this;
        }

        public Criteria andInPortNameNotBetween(String value1, String value2) {
            addCriterion("in_port_name not between", value1, value2, "inPortName");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeIsNull() {
            addCriterion("out_card_code is null");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeIsNotNull() {
            addCriterion("out_card_code is not null");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeEqualTo(String value) {
            addCriterion("out_card_code =", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeNotEqualTo(String value) {
            addCriterion("out_card_code <>", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeGreaterThan(String value) {
            addCriterion("out_card_code >", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("out_card_code >=", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeLessThan(String value) {
            addCriterion("out_card_code <", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeLessThanOrEqualTo(String value) {
            addCriterion("out_card_code <=", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeLike(String value) {
            addCriterion("out_card_code like", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeNotLike(String value) {
            addCriterion("out_card_code not like", value, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeIn(List<String> values) {
            addCriterion("out_card_code in", values, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeNotIn(List<String> values) {
            addCriterion("out_card_code not in", values, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeBetween(String value1, String value2) {
            addCriterion("out_card_code between", value1, value2, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCardCodeNotBetween(String value1, String value2) {
            addCriterion("out_card_code not between", value1, value2, "outCardCode");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateIsNull() {
            addCriterion("out_car_plate is null");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateIsNotNull() {
            addCriterion("out_car_plate is not null");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateEqualTo(String value) {
            addCriterion("out_car_plate =", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateNotEqualTo(String value) {
            addCriterion("out_car_plate <>", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateGreaterThan(String value) {
            addCriterion("out_car_plate >", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateGreaterThanOrEqualTo(String value) {
            addCriterion("out_car_plate >=", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateLessThan(String value) {
            addCriterion("out_car_plate <", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateLessThanOrEqualTo(String value) {
            addCriterion("out_car_plate <=", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateLike(String value) {
            addCriterion("out_car_plate like", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateNotLike(String value) {
            addCriterion("out_car_plate not like", value, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateIn(List<String> values) {
            addCriterion("out_car_plate in", values, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateNotIn(List<String> values) {
            addCriterion("out_car_plate not in", values, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateBetween(String value1, String value2) {
            addCriterion("out_car_plate between", value1, value2, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutCarPlateNotBetween(String value1, String value2) {
            addCriterion("out_car_plate not between", value1, value2, "outCarPlate");
            return (Criteria) this;
        }

        public Criteria andOutPicPathIsNull() {
            addCriterion("out_pic_path is null");
            return (Criteria) this;
        }

        public Criteria andOutPicPathIsNotNull() {
            addCriterion("out_pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andOutPicPathEqualTo(String value) {
            addCriterion("out_pic_path =", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathNotEqualTo(String value) {
            addCriterion("out_pic_path <>", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathGreaterThan(String value) {
            addCriterion("out_pic_path >", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("out_pic_path >=", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathLessThan(String value) {
            addCriterion("out_pic_path <", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathLessThanOrEqualTo(String value) {
            addCriterion("out_pic_path <=", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathLike(String value) {
            addCriterion("out_pic_path like", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathNotLike(String value) {
            addCriterion("out_pic_path not like", value, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathIn(List<String> values) {
            addCriterion("out_pic_path in", values, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathNotIn(List<String> values) {
            addCriterion("out_pic_path not in", values, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathBetween(String value1, String value2) {
            addCriterion("out_pic_path between", value1, value2, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutPicPathNotBetween(String value1, String value2) {
            addCriterion("out_pic_path not between", value1, value2, "outPicPath");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeIsNull() {
            addCriterion("out_car_type is null");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeIsNotNull() {
            addCriterion("out_car_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeEqualTo(Integer value) {
            addCriterion("out_car_type =", value, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeNotEqualTo(Integer value) {
            addCriterion("out_car_type <>", value, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeGreaterThan(Integer value) {
            addCriterion("out_car_type >", value, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_car_type >=", value, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeLessThan(Integer value) {
            addCriterion("out_car_type <", value, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeLessThanOrEqualTo(Integer value) {
            addCriterion("out_car_type <=", value, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeIn(List<Integer> values) {
            addCriterion("out_car_type in", values, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeNotIn(List<Integer> values) {
            addCriterion("out_car_type not in", values, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeBetween(Integer value1, Integer value2) {
            addCriterion("out_car_type between", value1, value2, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutCarTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("out_car_type not between", value1, value2, "outCarType");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(String value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(String value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(String value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(String value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(String value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLike(String value) {
            addCriterion("out_time like", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotLike(String value) {
            addCriterion("out_time not like", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<String> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<String> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(String value1, String value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(String value1, String value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(String value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(String value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(String value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(String value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(String value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(String value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLike(String value) {
            addCriterion("stop_time like", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotLike(String value) {
            addCriterion("stop_time not like", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(List<String> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(List<String> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(String value1, String value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(String value1, String value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andOutTypeIsNull() {
            addCriterion("out_type is null");
            return (Criteria) this;
        }

        public Criteria andOutTypeIsNotNull() {
            addCriterion("out_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutTypeEqualTo(Integer value) {
            addCriterion("out_type =", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeNotEqualTo(Integer value) {
            addCriterion("out_type <>", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeGreaterThan(Integer value) {
            addCriterion("out_type >", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_type >=", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeLessThan(Integer value) {
            addCriterion("out_type <", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeLessThanOrEqualTo(Integer value) {
            addCriterion("out_type <=", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeIn(List<Integer> values) {
            addCriterion("out_type in", values, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeNotIn(List<Integer> values) {
            addCriterion("out_type not in", values, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeBetween(Integer value1, Integer value2) {
            addCriterion("out_type between", value1, value2, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("out_type not between", value1, value2, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescIsNull() {
            addCriterion("out_type_desc is null");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescIsNotNull() {
            addCriterion("out_type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescEqualTo(String value) {
            addCriterion("out_type_desc =", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescNotEqualTo(String value) {
            addCriterion("out_type_desc <>", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescGreaterThan(String value) {
            addCriterion("out_type_desc >", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("out_type_desc >=", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescLessThan(String value) {
            addCriterion("out_type_desc <", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescLessThanOrEqualTo(String value) {
            addCriterion("out_type_desc <=", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescLike(String value) {
            addCriterion("out_type_desc like", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescNotLike(String value) {
            addCriterion("out_type_desc not like", value, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescIn(List<String> values) {
            addCriterion("out_type_desc in", values, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescNotIn(List<String> values) {
            addCriterion("out_type_desc not in", values, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescBetween(String value1, String value2) {
            addCriterion("out_type_desc between", value1, value2, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutTypeDescNotBetween(String value1, String value2) {
            addCriterion("out_type_desc not between", value1, value2, "outTypeDesc");
            return (Criteria) this;
        }

        public Criteria andOutPortIdIsNull() {
            addCriterion("out_port_id is null");
            return (Criteria) this;
        }

        public Criteria andOutPortIdIsNotNull() {
            addCriterion("out_port_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutPortIdEqualTo(Integer value) {
            addCriterion("out_port_id =", value, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdNotEqualTo(Integer value) {
            addCriterion("out_port_id <>", value, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdGreaterThan(Integer value) {
            addCriterion("out_port_id >", value, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_port_id >=", value, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdLessThan(Integer value) {
            addCriterion("out_port_id <", value, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdLessThanOrEqualTo(Integer value) {
            addCriterion("out_port_id <=", value, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdIn(List<Integer> values) {
            addCriterion("out_port_id in", values, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdNotIn(List<Integer> values) {
            addCriterion("out_port_id not in", values, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdBetween(Integer value1, Integer value2) {
            addCriterion("out_port_id between", value1, value2, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("out_port_id not between", value1, value2, "outPortId");
            return (Criteria) this;
        }

        public Criteria andOutPortNameIsNull() {
            addCriterion("out_port_name is null");
            return (Criteria) this;
        }

        public Criteria andOutPortNameIsNotNull() {
            addCriterion("out_port_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutPortNameEqualTo(String value) {
            addCriterion("out_port_name =", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameNotEqualTo(String value) {
            addCriterion("out_port_name <>", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameGreaterThan(String value) {
            addCriterion("out_port_name >", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameGreaterThanOrEqualTo(String value) {
            addCriterion("out_port_name >=", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameLessThan(String value) {
            addCriterion("out_port_name <", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameLessThanOrEqualTo(String value) {
            addCriterion("out_port_name <=", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameLike(String value) {
            addCriterion("out_port_name like", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameNotLike(String value) {
            addCriterion("out_port_name not like", value, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameIn(List<String> values) {
            addCriterion("out_port_name in", values, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameNotIn(List<String> values) {
            addCriterion("out_port_name not in", values, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameBetween(String value1, String value2) {
            addCriterion("out_port_name between", value1, value2, "outPortName");
            return (Criteria) this;
        }

        public Criteria andOutPortNameNotBetween(String value1, String value2) {
            addCriterion("out_port_name not between", value1, value2, "outPortName");
            return (Criteria) this;
        }

        public Criteria andNeedPayIsNull() {
            addCriterion("need_pay is null");
            return (Criteria) this;
        }

        public Criteria andNeedPayIsNotNull() {
            addCriterion("need_pay is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPayEqualTo(BigDecimal value) {
            addCriterion("need_pay =", value, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayNotEqualTo(BigDecimal value) {
            addCriterion("need_pay <>", value, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayGreaterThan(BigDecimal value) {
            addCriterion("need_pay >", value, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("need_pay >=", value, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayLessThan(BigDecimal value) {
            addCriterion("need_pay <", value, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("need_pay <=", value, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayIn(List<BigDecimal> values) {
            addCriterion("need_pay in", values, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayNotIn(List<BigDecimal> values) {
            addCriterion("need_pay not in", values, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("need_pay between", value1, value2, "needPay");
            return (Criteria) this;
        }

        public Criteria andNeedPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("need_pay not between", value1, value2, "needPay");
            return (Criteria) this;
        }

        public Criteria andActualPayIsNull() {
            addCriterion("actual_pay is null");
            return (Criteria) this;
        }

        public Criteria andActualPayIsNotNull() {
            addCriterion("actual_pay is not null");
            return (Criteria) this;
        }

        public Criteria andActualPayEqualTo(BigDecimal value) {
            addCriterion("actual_pay =", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotEqualTo(BigDecimal value) {
            addCriterion("actual_pay <>", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayGreaterThan(BigDecimal value) {
            addCriterion("actual_pay >", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pay >=", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayLessThan(BigDecimal value) {
            addCriterion("actual_pay <", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pay <=", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayIn(List<BigDecimal> values) {
            addCriterion("actual_pay in", values, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotIn(List<BigDecimal> values) {
            addCriterion("actual_pay not in", values, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pay between", value1, value2, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pay not between", value1, value2, "actualPay");
            return (Criteria) this;
        }

        public Criteria andBeforePayIsNull() {
            addCriterion("before_pay is null");
            return (Criteria) this;
        }

        public Criteria andBeforePayIsNotNull() {
            addCriterion("before_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBeforePayEqualTo(BigDecimal value) {
            addCriterion("before_pay =", value, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayNotEqualTo(BigDecimal value) {
            addCriterion("before_pay <>", value, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayGreaterThan(BigDecimal value) {
            addCriterion("before_pay >", value, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("before_pay >=", value, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayLessThan(BigDecimal value) {
            addCriterion("before_pay <", value, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("before_pay <=", value, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayIn(List<BigDecimal> values) {
            addCriterion("before_pay in", values, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayNotIn(List<BigDecimal> values) {
            addCriterion("before_pay not in", values, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("before_pay between", value1, value2, "beforePay");
            return (Criteria) this;
        }

        public Criteria andBeforePayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("before_pay not between", value1, value2, "beforePay");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("charge_type is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("charge_type is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(Integer value) {
            addCriterion("charge_type =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(Integer value) {
            addCriterion("charge_type <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(Integer value) {
            addCriterion("charge_type >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_type >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(Integer value) {
            addCriterion("charge_type <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("charge_type <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<Integer> values) {
            addCriterion("charge_type in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<Integer> values) {
            addCriterion("charge_type not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(Integer value1, Integer value2) {
            addCriterion("charge_type between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_type not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andDutyPersonIsNull() {
            addCriterion("duty_person is null");
            return (Criteria) this;
        }

        public Criteria andDutyPersonIsNotNull() {
            addCriterion("duty_person is not null");
            return (Criteria) this;
        }

        public Criteria andDutyPersonEqualTo(String value) {
            addCriterion("duty_person =", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonNotEqualTo(String value) {
            addCriterion("duty_person <>", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonGreaterThan(String value) {
            addCriterion("duty_person >", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("duty_person >=", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonLessThan(String value) {
            addCriterion("duty_person <", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonLessThanOrEqualTo(String value) {
            addCriterion("duty_person <=", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonLike(String value) {
            addCriterion("duty_person like", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonNotLike(String value) {
            addCriterion("duty_person not like", value, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonIn(List<String> values) {
            addCriterion("duty_person in", values, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonNotIn(List<String> values) {
            addCriterion("duty_person not in", values, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonBetween(String value1, String value2) {
            addCriterion("duty_person between", value1, value2, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andDutyPersonNotBetween(String value1, String value2) {
            addCriterion("duty_person not between", value1, value2, "dutyPerson");
            return (Criteria) this;
        }

        public Criteria andCarNatureIsNull() {
            addCriterion("car_nature is null");
            return (Criteria) this;
        }

        public Criteria andCarNatureIsNotNull() {
            addCriterion("car_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCarNatureEqualTo(Integer value) {
            addCriterion("car_nature =", value, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureNotEqualTo(Integer value) {
            addCriterion("car_nature <>", value, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureGreaterThan(Integer value) {
            addCriterion("car_nature >", value, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_nature >=", value, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureLessThan(Integer value) {
            addCriterion("car_nature <", value, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureLessThanOrEqualTo(Integer value) {
            addCriterion("car_nature <=", value, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureIn(List<Integer> values) {
            addCriterion("car_nature in", values, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureNotIn(List<Integer> values) {
            addCriterion("car_nature not in", values, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureBetween(Integer value1, Integer value2) {
            addCriterion("car_nature between", value1, value2, "carNature");
            return (Criteria) this;
        }

        public Criteria andCarNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("car_nature not between", value1, value2, "carNature");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNull() {
            addCriterion("local_id is null");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNotNull() {
            addCriterion("local_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocalIdEqualTo(String value) {
            addCriterion("local_id =", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotEqualTo(String value) {
            addCriterion("local_id <>", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThan(String value) {
            addCriterion("local_id >", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThanOrEqualTo(String value) {
            addCriterion("local_id >=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThan(String value) {
            addCriterion("local_id <", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThanOrEqualTo(String value) {
            addCriterion("local_id <=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLike(String value) {
            addCriterion("local_id like", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotLike(String value) {
            addCriterion("local_id not like", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIn(List<String> values) {
            addCriterion("local_id in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotIn(List<String> values) {
            addCriterion("local_id not in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdBetween(String value1, String value2) {
            addCriterion("local_id between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotBetween(String value1, String value2) {
            addCriterion("local_id not between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
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