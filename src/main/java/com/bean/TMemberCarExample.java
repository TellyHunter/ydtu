package com.bean;

import java.util.ArrayList;
import java.util.List;

public class TMemberCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TMemberCarExample() {
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

        public Criteria andCarPlateIsNull() {
            addCriterion("car_plate is null");
            return (Criteria) this;
        }

        public Criteria andCarPlateIsNotNull() {
            addCriterion("car_plate is not null");
            return (Criteria) this;
        }

        public Criteria andCarPlateEqualTo(String value) {
            addCriterion("car_plate =", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotEqualTo(String value) {
            addCriterion("car_plate <>", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateGreaterThan(String value) {
            addCriterion("car_plate >", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateGreaterThanOrEqualTo(String value) {
            addCriterion("car_plate >=", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateLessThan(String value) {
            addCriterion("car_plate <", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateLessThanOrEqualTo(String value) {
            addCriterion("car_plate <=", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateLike(String value) {
            addCriterion("car_plate like", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotLike(String value) {
            addCriterion("car_plate not like", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateIn(List<String> values) {
            addCriterion("car_plate in", values, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotIn(List<String> values) {
            addCriterion("car_plate not in", values, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateBetween(String value1, String value2) {
            addCriterion("car_plate between", value1, value2, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotBetween(String value1, String value2) {
            addCriterion("car_plate not between", value1, value2, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNull() {
            addCriterion("car_color is null");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNotNull() {
            addCriterion("car_color is not null");
            return (Criteria) this;
        }

        public Criteria andCarColorEqualTo(String value) {
            addCriterion("car_color =", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotEqualTo(String value) {
            addCriterion("car_color <>", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThan(String value) {
            addCriterion("car_color >", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThanOrEqualTo(String value) {
            addCriterion("car_color >=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThan(String value) {
            addCriterion("car_color <", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThanOrEqualTo(String value) {
            addCriterion("car_color <=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLike(String value) {
            addCriterion("car_color like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotLike(String value) {
            addCriterion("car_color not like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorIn(List<String> values) {
            addCriterion("car_color in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotIn(List<String> values) {
            addCriterion("car_color not in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorBetween(String value1, String value2) {
            addCriterion("car_color between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotBetween(String value1, String value2) {
            addCriterion("car_color not between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumIsNull() {
            addCriterion("car_identi_num is null");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumIsNotNull() {
            addCriterion("car_identi_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumEqualTo(String value) {
            addCriterion("car_identi_num =", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumNotEqualTo(String value) {
            addCriterion("car_identi_num <>", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumGreaterThan(String value) {
            addCriterion("car_identi_num >", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumGreaterThanOrEqualTo(String value) {
            addCriterion("car_identi_num >=", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumLessThan(String value) {
            addCriterion("car_identi_num <", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumLessThanOrEqualTo(String value) {
            addCriterion("car_identi_num <=", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumLike(String value) {
            addCriterion("car_identi_num like", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumNotLike(String value) {
            addCriterion("car_identi_num not like", value, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumIn(List<String> values) {
            addCriterion("car_identi_num in", values, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumNotIn(List<String> values) {
            addCriterion("car_identi_num not in", values, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumBetween(String value1, String value2) {
            addCriterion("car_identi_num between", value1, value2, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarIdentiNumNotBetween(String value1, String value2) {
            addCriterion("car_identi_num not between", value1, value2, "carIdentiNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumIsNull() {
            addCriterion("car_engine_num is null");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumIsNotNull() {
            addCriterion("car_engine_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumEqualTo(String value) {
            addCriterion("car_engine_num =", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumNotEqualTo(String value) {
            addCriterion("car_engine_num <>", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumGreaterThan(String value) {
            addCriterion("car_engine_num >", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumGreaterThanOrEqualTo(String value) {
            addCriterion("car_engine_num >=", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumLessThan(String value) {
            addCriterion("car_engine_num <", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumLessThanOrEqualTo(String value) {
            addCriterion("car_engine_num <=", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumLike(String value) {
            addCriterion("car_engine_num like", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumNotLike(String value) {
            addCriterion("car_engine_num not like", value, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumIn(List<String> values) {
            addCriterion("car_engine_num in", values, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumNotIn(List<String> values) {
            addCriterion("car_engine_num not in", values, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumBetween(String value1, String value2) {
            addCriterion("car_engine_num between", value1, value2, "carEngineNum");
            return (Criteria) this;
        }

        public Criteria andCarEngineNumNotBetween(String value1, String value2) {
            addCriterion("car_engine_num not between", value1, value2, "carEngineNum");
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

        public Criteria andDriverImgIsNull() {
            addCriterion("driver_img is null");
            return (Criteria) this;
        }

        public Criteria andDriverImgIsNotNull() {
            addCriterion("driver_img is not null");
            return (Criteria) this;
        }

        public Criteria andDriverImgEqualTo(String value) {
            addCriterion("driver_img =", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgNotEqualTo(String value) {
            addCriterion("driver_img <>", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgGreaterThan(String value) {
            addCriterion("driver_img >", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgGreaterThanOrEqualTo(String value) {
            addCriterion("driver_img >=", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgLessThan(String value) {
            addCriterion("driver_img <", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgLessThanOrEqualTo(String value) {
            addCriterion("driver_img <=", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgLike(String value) {
            addCriterion("driver_img like", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgNotLike(String value) {
            addCriterion("driver_img not like", value, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgIn(List<String> values) {
            addCriterion("driver_img in", values, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgNotIn(List<String> values) {
            addCriterion("driver_img not in", values, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgBetween(String value1, String value2) {
            addCriterion("driver_img between", value1, value2, "driverImg");
            return (Criteria) this;
        }

        public Criteria andDriverImgNotBetween(String value1, String value2) {
            addCriterion("driver_img not between", value1, value2, "driverImg");
            return (Criteria) this;
        }

        public Criteria andCarImgIsNull() {
            addCriterion("car_img is null");
            return (Criteria) this;
        }

        public Criteria andCarImgIsNotNull() {
            addCriterion("car_img is not null");
            return (Criteria) this;
        }

        public Criteria andCarImgEqualTo(String value) {
            addCriterion("car_img =", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotEqualTo(String value) {
            addCriterion("car_img <>", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgGreaterThan(String value) {
            addCriterion("car_img >", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgGreaterThanOrEqualTo(String value) {
            addCriterion("car_img >=", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgLessThan(String value) {
            addCriterion("car_img <", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgLessThanOrEqualTo(String value) {
            addCriterion("car_img <=", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgLike(String value) {
            addCriterion("car_img like", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotLike(String value) {
            addCriterion("car_img not like", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgIn(List<String> values) {
            addCriterion("car_img in", values, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotIn(List<String> values) {
            addCriterion("car_img not in", values, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgBetween(String value1, String value2) {
            addCriterion("car_img between", value1, value2, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotBetween(String value1, String value2) {
            addCriterion("car_img not between", value1, value2, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPayAutoIsNull() {
            addCriterion("pay_auto is null");
            return (Criteria) this;
        }

        public Criteria andPayAutoIsNotNull() {
            addCriterion("pay_auto is not null");
            return (Criteria) this;
        }

        public Criteria andPayAutoEqualTo(String value) {
            addCriterion("pay_auto =", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoNotEqualTo(String value) {
            addCriterion("pay_auto <>", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoGreaterThan(String value) {
            addCriterion("pay_auto >", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_auto >=", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoLessThan(String value) {
            addCriterion("pay_auto <", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoLessThanOrEqualTo(String value) {
            addCriterion("pay_auto <=", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoLike(String value) {
            addCriterion("pay_auto like", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoNotLike(String value) {
            addCriterion("pay_auto not like", value, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoIn(List<String> values) {
            addCriterion("pay_auto in", values, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoNotIn(List<String> values) {
            addCriterion("pay_auto not in", values, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoBetween(String value1, String value2) {
            addCriterion("pay_auto between", value1, value2, "payAuto");
            return (Criteria) this;
        }

        public Criteria andPayAutoNotBetween(String value1, String value2) {
            addCriterion("pay_auto not between", value1, value2, "payAuto");
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