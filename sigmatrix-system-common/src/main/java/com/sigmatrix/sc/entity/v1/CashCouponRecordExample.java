package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CashCouponRecordExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CashCouponRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdIsNull() {
            addCriterion("_cash_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdIsNotNull() {
            addCriterion("_cash_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdEqualTo(Integer value) {
            addCriterion("_cash_prize_id =", value, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdNotEqualTo(Integer value) {
            addCriterion("_cash_prize_id <>", value, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdGreaterThan(Integer value) {
            addCriterion("_cash_prize_id >", value, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_cash_prize_id >=", value, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdLessThan(Integer value) {
            addCriterion("_cash_prize_id <", value, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("_cash_prize_id <=", value, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdIn(List<Integer> values) {
            addCriterion("_cash_prize_id in", values, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdNotIn(List<Integer> values) {
            addCriterion("_cash_prize_id not in", values, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdBetween(Integer value1, Integer value2) {
            addCriterion("_cash_prize_id between", value1, value2, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_cash_prize_id not between", value1, value2, "cashPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountIsNull() {
            addCriterion("_cash_prize_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountIsNotNull() {
            addCriterion("_cash_prize_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountEqualTo(Integer value) {
            addCriterion("_cash_prize_amount =", value, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountNotEqualTo(Integer value) {
            addCriterion("_cash_prize_amount <>", value, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountGreaterThan(Integer value) {
            addCriterion("_cash_prize_amount >", value, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_cash_prize_amount >=", value, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountLessThan(Integer value) {
            addCriterion("_cash_prize_amount <", value, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_cash_prize_amount <=", value, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountIn(List<Integer> values) {
            addCriterion("_cash_prize_amount in", values, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountNotIn(List<Integer> values) {
            addCriterion("_cash_prize_amount not in", values, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountBetween(Integer value1, Integer value2) {
            addCriterion("_cash_prize_amount between", value1, value2, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashPrizeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_cash_prize_amount not between", value1, value2, "cashPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdIsNull() {
            addCriterion("_get_prize_order_id is null");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdIsNotNull() {
            addCriterion("_get_prize_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdEqualTo(String value) {
            addCriterion("_get_prize_order_id =", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdNotEqualTo(String value) {
            addCriterion("_get_prize_order_id <>", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdGreaterThan(String value) {
            addCriterion("_get_prize_order_id >", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("_get_prize_order_id >=", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdLessThan(String value) {
            addCriterion("_get_prize_order_id <", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdLessThanOrEqualTo(String value) {
            addCriterion("_get_prize_order_id <=", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdLike(String value) {
            addCriterion("_get_prize_order_id like", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdNotLike(String value) {
            addCriterion("_get_prize_order_id not like", value, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdIn(List<String> values) {
            addCriterion("_get_prize_order_id in", values, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdNotIn(List<String> values) {
            addCriterion("_get_prize_order_id not in", values, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdBetween(String value1, String value2) {
            addCriterion("_get_prize_order_id between", value1, value2, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andGetPrizeOrderIdNotBetween(String value1, String value2) {
            addCriterion("_get_prize_order_id not between", value1, value2, "getPrizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdIsNull() {
            addCriterion("_prize_order_id is null");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdIsNotNull() {
            addCriterion("_prize_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdEqualTo(String value) {
            addCriterion("_prize_order_id =", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdNotEqualTo(String value) {
            addCriterion("_prize_order_id <>", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdGreaterThan(String value) {
            addCriterion("_prize_order_id >", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("_prize_order_id >=", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdLessThan(String value) {
            addCriterion("_prize_order_id <", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdLessThanOrEqualTo(String value) {
            addCriterion("_prize_order_id <=", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdLike(String value) {
            addCriterion("_prize_order_id like", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdNotLike(String value) {
            addCriterion("_prize_order_id not like", value, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdIn(List<String> values) {
            addCriterion("_prize_order_id in", values, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdNotIn(List<String> values) {
            addCriterion("_prize_order_id not in", values, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdBetween(String value1, String value2) {
            addCriterion("_prize_order_id between", value1, value2, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andPrizeOrderIdNotBetween(String value1, String value2) {
            addCriterion("_prize_order_id not between", value1, value2, "prizeOrderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("_user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("_user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("_user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("_user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("_user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("_user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("_user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("_user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("_open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("_open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("_open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("_open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("_open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("_open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("_open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("_open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("_open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("_open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("_open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("_open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("_open_id not between", value1, value2, "openId");
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
