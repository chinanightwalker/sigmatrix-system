package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChangeOrderExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChangeOrderExample() {
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

        public Criteria andChangeOrderIdIsNull() {
            addCriterion("_change_order_id is null");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdIsNotNull() {
            addCriterion("_change_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdEqualTo(String value) {
            addCriterion("_change_order_id =", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdNotEqualTo(String value) {
            addCriterion("_change_order_id <>", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdGreaterThan(String value) {
            addCriterion("_change_order_id >", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("_change_order_id >=", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdLessThan(String value) {
            addCriterion("_change_order_id <", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdLessThanOrEqualTo(String value) {
            addCriterion("_change_order_id <=", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdLike(String value) {
            addCriterion("_change_order_id like", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdNotLike(String value) {
            addCriterion("_change_order_id not like", value, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdIn(List<String> values) {
            addCriterion("_change_order_id in", values, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdNotIn(List<String> values) {
            addCriterion("_change_order_id not in", values, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdBetween(String value1, String value2) {
            addCriterion("_change_order_id between", value1, value2, "changeOrderId");
            return (Criteria) this;
        }

        public Criteria andChangeOrderIdNotBetween(String value1, String value2) {
            addCriterion("_change_order_id not between", value1, value2, "changeOrderId");
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

        public Criteria andActivityIdIsNull() {
            addCriterion("_activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("_activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("_activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("_activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("_activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("_activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("_activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("_activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("_activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("_activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_activity_id not between", value1, value2, "activityId");
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

        public Criteria andChangeAmountIsNull() {
            addCriterion("_change_amount is null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIsNotNull() {
            addCriterion("_change_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChangeAmountEqualTo(Integer value) {
            addCriterion("_change_amount =", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotEqualTo(Integer value) {
            addCriterion("_change_amount <>", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThan(Integer value) {
            addCriterion("_change_amount >", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_change_amount >=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThan(Integer value) {
            addCriterion("_change_amount <", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_change_amount <=", value, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountIn(List<Integer> values) {
            addCriterion("_change_amount in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotIn(List<Integer> values) {
            addCriterion("_change_amount not in", values, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountBetween(Integer value1, Integer value2) {
            addCriterion("_change_amount between", value1, value2, "changeAmount");
            return (Criteria) this;
        }

        public Criteria andChangeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_change_amount not between", value1, value2, "changeAmount");
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

        public Criteria andResultIsNull() {
            addCriterion("_result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("_result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("_result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("_result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("_result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("_result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("_result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("_result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("_result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("_result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("_result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("_result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("_result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("_result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultMsgIsNull() {
            addCriterion("_result_msg is null");
            return (Criteria) this;
        }

        public Criteria andResultMsgIsNotNull() {
            addCriterion("_result_msg is not null");
            return (Criteria) this;
        }

        public Criteria andResultMsgEqualTo(String value) {
            addCriterion("_result_msg =", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotEqualTo(String value) {
            addCriterion("_result_msg <>", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgGreaterThan(String value) {
            addCriterion("_result_msg >", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgGreaterThanOrEqualTo(String value) {
            addCriterion("_result_msg >=", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgLessThan(String value) {
            addCriterion("_result_msg <", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgLessThanOrEqualTo(String value) {
            addCriterion("_result_msg <=", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgLike(String value) {
            addCriterion("_result_msg like", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotLike(String value) {
            addCriterion("_result_msg not like", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgIn(List<String> values) {
            addCriterion("_result_msg in", values, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotIn(List<String> values) {
            addCriterion("_result_msg not in", values, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgBetween(String value1, String value2) {
            addCriterion("_result_msg between", value1, value2, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotBetween(String value1, String value2) {
            addCriterion("_result_msg not between", value1, value2, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdIsNull() {
            addCriterion("_change_platform_order_id is null");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdIsNotNull() {
            addCriterion("_change_platform_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdEqualTo(String value) {
            addCriterion("_change_platform_order_id =", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdNotEqualTo(String value) {
            addCriterion("_change_platform_order_id <>", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdGreaterThan(String value) {
            addCriterion("_change_platform_order_id >", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("_change_platform_order_id >=", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdLessThan(String value) {
            addCriterion("_change_platform_order_id <", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdLessThanOrEqualTo(String value) {
            addCriterion("_change_platform_order_id <=", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdLike(String value) {
            addCriterion("_change_platform_order_id like", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdNotLike(String value) {
            addCriterion("_change_platform_order_id not like", value, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdIn(List<String> values) {
            addCriterion("_change_platform_order_id in", values, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdNotIn(List<String> values) {
            addCriterion("_change_platform_order_id not in", values, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdBetween(String value1, String value2) {
            addCriterion("_change_platform_order_id between", value1, value2, "changePlatformOrderId");
            return (Criteria) this;
        }

        public Criteria andChangePlatformOrderIdNotBetween(String value1, String value2) {
            addCriterion("_change_platform_order_id not between", value1, value2, "changePlatformOrderId");
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
