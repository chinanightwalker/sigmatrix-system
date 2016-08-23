package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RedbagForciblyOrderExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RedbagForciblyOrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andForciblyOrderIdIsNull() {
            addCriterion("_forcibly_order_id is null");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdIsNotNull() {
            addCriterion("_forcibly_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdEqualTo(String value) {
            addCriterion("_forcibly_order_id =", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdNotEqualTo(String value) {
            addCriterion("_forcibly_order_id <>", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdGreaterThan(String value) {
            addCriterion("_forcibly_order_id >", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("_forcibly_order_id >=", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdLessThan(String value) {
            addCriterion("_forcibly_order_id <", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdLessThanOrEqualTo(String value) {
            addCriterion("_forcibly_order_id <=", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdLike(String value) {
            addCriterion("_forcibly_order_id like", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdNotLike(String value) {
            addCriterion("_forcibly_order_id not like", value, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdIn(List<String> values) {
            addCriterion("_forcibly_order_id in", values, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdNotIn(List<String> values) {
            addCriterion("_forcibly_order_id not in", values, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdBetween(String value1, String value2) {
            addCriterion("_forcibly_order_id between", value1, value2, "forciblyOrderId");
            return (Criteria) this;
        }

        public Criteria andForciblyOrderIdNotBetween(String value1, String value2) {
            addCriterion("_forcibly_order_id not between", value1, value2, "forciblyOrderId");
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

        public Criteria andForciblyOpenIdIsNull() {
            addCriterion("_forcibly_open_id is null");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdIsNotNull() {
            addCriterion("_forcibly_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdEqualTo(String value) {
            addCriterion("_forcibly_open_id =", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdNotEqualTo(String value) {
            addCriterion("_forcibly_open_id <>", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdGreaterThan(String value) {
            addCriterion("_forcibly_open_id >", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("_forcibly_open_id >=", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdLessThan(String value) {
            addCriterion("_forcibly_open_id <", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdLessThanOrEqualTo(String value) {
            addCriterion("_forcibly_open_id <=", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdLike(String value) {
            addCriterion("_forcibly_open_id like", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdNotLike(String value) {
            addCriterion("_forcibly_open_id not like", value, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdIn(List<String> values) {
            addCriterion("_forcibly_open_id in", values, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdNotIn(List<String> values) {
            addCriterion("_forcibly_open_id not in", values, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdBetween(String value1, String value2) {
            addCriterion("_forcibly_open_id between", value1, value2, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyOpenIdNotBetween(String value1, String value2) {
            addCriterion("_forcibly_open_id not between", value1, value2, "forciblyOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdIsNull() {
            addCriterion("_forcibly_pay_open_id is null");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdIsNotNull() {
            addCriterion("_forcibly_pay_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdEqualTo(String value) {
            addCriterion("_forcibly_pay_open_id =", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdNotEqualTo(String value) {
            addCriterion("_forcibly_pay_open_id <>", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdGreaterThan(String value) {
            addCriterion("_forcibly_pay_open_id >", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("_forcibly_pay_open_id >=", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdLessThan(String value) {
            addCriterion("_forcibly_pay_open_id <", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdLessThanOrEqualTo(String value) {
            addCriterion("_forcibly_pay_open_id <=", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdLike(String value) {
            addCriterion("_forcibly_pay_open_id like", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdNotLike(String value) {
            addCriterion("_forcibly_pay_open_id not like", value, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdIn(List<String> values) {
            addCriterion("_forcibly_pay_open_id in", values, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdNotIn(List<String> values) {
            addCriterion("_forcibly_pay_open_id not in", values, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdBetween(String value1, String value2) {
            addCriterion("_forcibly_pay_open_id between", value1, value2, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andForciblyPayOpenIdNotBetween(String value1, String value2) {
            addCriterion("_forcibly_pay_open_id not between", value1, value2, "forciblyPayOpenId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("_status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("_status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("_status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("_status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("_status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("_status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("_status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("_status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("_status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("_status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("_status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("_status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPayResultIsNull() {
            addCriterion("_pay_result is null");
            return (Criteria) this;
        }

        public Criteria andPayResultIsNotNull() {
            addCriterion("_pay_result is not null");
            return (Criteria) this;
        }

        public Criteria andPayResultEqualTo(Integer value) {
            addCriterion("_pay_result =", value, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultNotEqualTo(Integer value) {
            addCriterion("_pay_result <>", value, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultGreaterThan(Integer value) {
            addCriterion("_pay_result >", value, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("_pay_result >=", value, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultLessThan(Integer value) {
            addCriterion("_pay_result <", value, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultLessThanOrEqualTo(Integer value) {
            addCriterion("_pay_result <=", value, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultIn(List<Integer> values) {
            addCriterion("_pay_result in", values, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultNotIn(List<Integer> values) {
            addCriterion("_pay_result not in", values, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultBetween(Integer value1, Integer value2) {
            addCriterion("_pay_result between", value1, value2, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayResultNotBetween(Integer value1, Integer value2) {
            addCriterion("_pay_result not between", value1, value2, "payResult");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterionForJDBCDate("_pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("_pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("_pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("_pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterionForJDBCDate("_pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("_pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterionForJDBCDate("_pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("_pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("_pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("_pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountIsNull() {
            addCriterion("_forcibly_amount is null");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountIsNotNull() {
            addCriterion("_forcibly_amount is not null");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountEqualTo(Integer value) {
            addCriterion("_forcibly_amount =", value, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountNotEqualTo(Integer value) {
            addCriterion("_forcibly_amount <>", value, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountGreaterThan(Integer value) {
            addCriterion("_forcibly_amount >", value, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_forcibly_amount >=", value, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountLessThan(Integer value) {
            addCriterion("_forcibly_amount <", value, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_forcibly_amount <=", value, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountIn(List<Integer> values) {
            addCriterion("_forcibly_amount in", values, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountNotIn(List<Integer> values) {
            addCriterion("_forcibly_amount not in", values, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountBetween(Integer value1, Integer value2) {
            addCriterion("_forcibly_amount between", value1, value2, "forciblyAmount");
            return (Criteria) this;
        }

        public Criteria andForciblyAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_forcibly_amount not between", value1, value2, "forciblyAmount");
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
