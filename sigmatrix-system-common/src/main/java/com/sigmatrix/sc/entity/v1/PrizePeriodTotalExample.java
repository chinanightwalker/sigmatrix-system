package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrizePeriodTotalExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrizePeriodTotalExample() {
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

        public Criteria andDateSlotIsNull() {
            addCriterion("_date_slot is null");
            return (Criteria) this;
        }

        public Criteria andDateSlotIsNotNull() {
            addCriterion("_date_slot is not null");
            return (Criteria) this;
        }

        public Criteria andDateSlotEqualTo(String value) {
            addCriterion("_date_slot =", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotNotEqualTo(String value) {
            addCriterion("_date_slot <>", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotGreaterThan(String value) {
            addCriterion("_date_slot >", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotGreaterThanOrEqualTo(String value) {
            addCriterion("_date_slot >=", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotLessThan(String value) {
            addCriterion("_date_slot <", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotLessThanOrEqualTo(String value) {
            addCriterion("_date_slot <=", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotLike(String value) {
            addCriterion("_date_slot like", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotNotLike(String value) {
            addCriterion("_date_slot not like", value, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotIn(List<String> values) {
            addCriterion("_date_slot in", values, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotNotIn(List<String> values) {
            addCriterion("_date_slot not in", values, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotBetween(String value1, String value2) {
            addCriterion("_date_slot between", value1, value2, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andDateSlotNotBetween(String value1, String value2) {
            addCriterion("_date_slot not between", value1, value2, "dateSlot");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIsNull() {
            addCriterion("_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIsNotNull() {
            addCriterion("_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdEqualTo(Integer value) {
            addCriterion("_prize_id =", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotEqualTo(Integer value) {
            addCriterion("_prize_id <>", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThan(Integer value) {
            addCriterion("_prize_id >", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_id >=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThan(Integer value) {
            addCriterion("_prize_id <", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_id <=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIn(List<Integer> values) {
            addCriterion("_prize_id in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotIn(List<Integer> values) {
            addCriterion("_prize_id not in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdBetween(Integer value1, Integer value2) {
            addCriterion("_prize_id between", value1, value2, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_id not between", value1, value2, "prizeId");
            return (Criteria) this;
        }

        public Criteria andGetCountIsNull() {
            addCriterion("_get_count is null");
            return (Criteria) this;
        }

        public Criteria andGetCountIsNotNull() {
            addCriterion("_get_count is not null");
            return (Criteria) this;
        }

        public Criteria andGetCountEqualTo(Integer value) {
            addCriterion("_get_count =", value, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountNotEqualTo(Integer value) {
            addCriterion("_get_count <>", value, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountGreaterThan(Integer value) {
            addCriterion("_get_count >", value, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_get_count >=", value, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountLessThan(Integer value) {
            addCriterion("_get_count <", value, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountLessThanOrEqualTo(Integer value) {
            addCriterion("_get_count <=", value, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountIn(List<Integer> values) {
            addCriterion("_get_count in", values, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountNotIn(List<Integer> values) {
            addCriterion("_get_count not in", values, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountBetween(Integer value1, Integer value2) {
            addCriterion("_get_count between", value1, value2, "getCount");
            return (Criteria) this;
        }

        public Criteria andGetCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_get_count not between", value1, value2, "getCount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("_create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("_create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("_create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("_create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("_create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("_create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("_create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("_create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("_create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("_update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("_update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("_update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("_update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("_update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("_update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("_update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("_update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("_update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("_update_time not between", value1, value2, "updateTime");
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
