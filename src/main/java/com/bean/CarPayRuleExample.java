package com.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarPayRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CarPayRuleExample() {
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

        public Criteria andRuleNameIsNull() {
            addCriterion("rule_name is null");
            return (Criteria) this;
        }

        public Criteria andRuleNameIsNotNull() {
            addCriterion("rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andRuleNameEqualTo(String value) {
            addCriterion("rule_name =", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotEqualTo(String value) {
            addCriterion("rule_name <>", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThan(String value) {
            addCriterion("rule_name >", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_name >=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThan(String value) {
            addCriterion("rule_name <", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThanOrEqualTo(String value) {
            addCriterion("rule_name <=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLike(String value) {
            addCriterion("rule_name like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotLike(String value) {
            addCriterion("rule_name not like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameIn(List<String> values) {
            addCriterion("rule_name in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotIn(List<String> values) {
            addCriterion("rule_name not in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameBetween(String value1, String value2) {
            addCriterion("rule_name between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotBetween(String value1, String value2) {
            addCriterion("rule_name not between", value1, value2, "ruleName");
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

        public Criteria andYearFeeIsNull() {
            addCriterion("year_fee is null");
            return (Criteria) this;
        }

        public Criteria andYearFeeIsNotNull() {
            addCriterion("year_fee is not null");
            return (Criteria) this;
        }

        public Criteria andYearFeeEqualTo(BigDecimal value) {
            addCriterion("year_fee =", value, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeNotEqualTo(BigDecimal value) {
            addCriterion("year_fee <>", value, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeGreaterThan(BigDecimal value) {
            addCriterion("year_fee >", value, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("year_fee >=", value, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeLessThan(BigDecimal value) {
            addCriterion("year_fee <", value, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("year_fee <=", value, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeIn(List<BigDecimal> values) {
            addCriterion("year_fee in", values, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeNotIn(List<BigDecimal> values) {
            addCriterion("year_fee not in", values, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_fee between", value1, value2, "yearFee");
            return (Criteria) this;
        }

        public Criteria andYearFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_fee not between", value1, value2, "yearFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeIsNull() {
            addCriterion("season_fee is null");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeIsNotNull() {
            addCriterion("season_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeEqualTo(BigDecimal value) {
            addCriterion("season_fee =", value, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeNotEqualTo(BigDecimal value) {
            addCriterion("season_fee <>", value, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeGreaterThan(BigDecimal value) {
            addCriterion("season_fee >", value, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("season_fee >=", value, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeLessThan(BigDecimal value) {
            addCriterion("season_fee <", value, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("season_fee <=", value, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeIn(List<BigDecimal> values) {
            addCriterion("season_fee in", values, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeNotIn(List<BigDecimal> values) {
            addCriterion("season_fee not in", values, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("season_fee between", value1, value2, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andSeasonFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("season_fee not between", value1, value2, "seasonFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeIsNull() {
            addCriterion("month_fee is null");
            return (Criteria) this;
        }

        public Criteria andMonthFeeIsNotNull() {
            addCriterion("month_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMonthFeeEqualTo(BigDecimal value) {
            addCriterion("month_fee =", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeNotEqualTo(BigDecimal value) {
            addCriterion("month_fee <>", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeGreaterThan(BigDecimal value) {
            addCriterion("month_fee >", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_fee >=", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeLessThan(BigDecimal value) {
            addCriterion("month_fee <", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_fee <=", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeIn(List<BigDecimal> values) {
            addCriterion("month_fee in", values, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeNotIn(List<BigDecimal> values) {
            addCriterion("month_fee not in", values, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_fee between", value1, value2, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_fee not between", value1, value2, "monthFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeIsNull() {
            addCriterion("day_fee is null");
            return (Criteria) this;
        }

        public Criteria andDayFeeIsNotNull() {
            addCriterion("day_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDayFeeEqualTo(BigDecimal value) {
            addCriterion("day_fee =", value, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeNotEqualTo(BigDecimal value) {
            addCriterion("day_fee <>", value, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeGreaterThan(BigDecimal value) {
            addCriterion("day_fee >", value, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("day_fee >=", value, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeLessThan(BigDecimal value) {
            addCriterion("day_fee <", value, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("day_fee <=", value, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeIn(List<BigDecimal> values) {
            addCriterion("day_fee in", values, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeNotIn(List<BigDecimal> values) {
            addCriterion("day_fee not in", values, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_fee between", value1, value2, "dayFee");
            return (Criteria) this;
        }

        public Criteria andDayFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_fee not between", value1, value2, "dayFee");
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

        public Criteria andLocalIdIsNull() {
            addCriterion("local_id is null");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNotNull() {
            addCriterion("local_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocalIdEqualTo(Integer value) {
            addCriterion("local_id =", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotEqualTo(Integer value) {
            addCriterion("local_id <>", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThan(Integer value) {
            addCriterion("local_id >", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("local_id >=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThan(Integer value) {
            addCriterion("local_id <", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThanOrEqualTo(Integer value) {
            addCriterion("local_id <=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIn(List<Integer> values) {
            addCriterion("local_id in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotIn(List<Integer> values) {
            addCriterion("local_id not in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdBetween(Integer value1, Integer value2) {
            addCriterion("local_id between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("local_id not between", value1, value2, "localId");
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