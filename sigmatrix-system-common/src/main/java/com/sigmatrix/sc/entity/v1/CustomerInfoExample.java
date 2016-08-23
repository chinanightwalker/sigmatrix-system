package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerInfoExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerInfoExample() {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("_customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("_customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("_customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("_customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("_customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("_customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("_customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("_customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNull() {
            addCriterion("_customer_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNotNull() {
            addCriterion("_customer_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeEqualTo(String value) {
            addCriterion("_customer_code =", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotEqualTo(String value) {
            addCriterion("_customer_code <>", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThan(String value) {
            addCriterion("_customer_code >", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_customer_code >=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThan(String value) {
            addCriterion("_customer_code <", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
            addCriterion("_customer_code <=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLike(String value) {
            addCriterion("_customer_code like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotLike(String value) {
            addCriterion("_customer_code not like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIn(List<String> values) {
            addCriterion("_customer_code in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotIn(List<String> values) {
            addCriterion("_customer_code not in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeBetween(String value1, String value2) {
            addCriterion("_customer_code between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotBetween(String value1, String value2) {
            addCriterion("_customer_code not between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("_customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("_customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("_customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("_customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("_customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("_customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("_customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("_customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("_customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("_customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("_customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("_customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("_customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("_customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("_phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("_phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("_phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("_phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("_phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("_phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("_phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("_phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("_phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("_phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("_phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("_phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("_phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andFirstAwardIsNull() {
            addCriterion("_first_award is null");
            return (Criteria) this;
        }

        public Criteria andFirstAwardIsNotNull() {
            addCriterion("_first_award is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAwardEqualTo(Integer value) {
            addCriterion("_first_award =", value, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardNotEqualTo(Integer value) {
            addCriterion("_first_award <>", value, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardGreaterThan(Integer value) {
            addCriterion("_first_award >", value, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardGreaterThanOrEqualTo(Integer value) {
            addCriterion("_first_award >=", value, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardLessThan(Integer value) {
            addCriterion("_first_award <", value, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardLessThanOrEqualTo(Integer value) {
            addCriterion("_first_award <=", value, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardIn(List<Integer> values) {
            addCriterion("_first_award in", values, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardNotIn(List<Integer> values) {
            addCriterion("_first_award not in", values, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardBetween(Integer value1, Integer value2) {
            addCriterion("_first_award between", value1, value2, "firstAward");
            return (Criteria) this;
        }

        public Criteria andFirstAwardNotBetween(Integer value1, Integer value2) {
            addCriterion("_first_award not between", value1, value2, "firstAward");
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

        public Criteria andTypeIsNull() {
            addCriterion("_type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("_type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("_type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("_type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("_type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("_type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("_type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("_type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("_type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("_type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("_type not between", value1, value2, "type");
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

        public Criteria andPayOpenIdIsNull() {
            addCriterion("_pay_open_id is null");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdIsNotNull() {
            addCriterion("_pay_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdEqualTo(String value) {
            addCriterion("_pay_open_id =", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdNotEqualTo(String value) {
            addCriterion("_pay_open_id <>", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdGreaterThan(String value) {
            addCriterion("_pay_open_id >", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("_pay_open_id >=", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdLessThan(String value) {
            addCriterion("_pay_open_id <", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdLessThanOrEqualTo(String value) {
            addCriterion("_pay_open_id <=", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdLike(String value) {
            addCriterion("_pay_open_id like", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdNotLike(String value) {
            addCriterion("_pay_open_id not like", value, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdIn(List<String> values) {
            addCriterion("_pay_open_id in", values, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdNotIn(List<String> values) {
            addCriterion("_pay_open_id not in", values, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdBetween(String value1, String value2) {
            addCriterion("_pay_open_id between", value1, value2, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andPayOpenIdNotBetween(String value1, String value2) {
            addCriterion("_pay_open_id not between", value1, value2, "payOpenId");
            return (Criteria) this;
        }

        public Criteria andCurrentsIsNull() {
            addCriterion("_currents is null");
            return (Criteria) this;
        }

        public Criteria andCurrentsIsNotNull() {
            addCriterion("_currents is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentsEqualTo(Integer value) {
            addCriterion("_currents =", value, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsNotEqualTo(Integer value) {
            addCriterion("_currents <>", value, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsGreaterThan(Integer value) {
            addCriterion("_currents >", value, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsGreaterThanOrEqualTo(Integer value) {
            addCriterion("_currents >=", value, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsLessThan(Integer value) {
            addCriterion("_currents <", value, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsLessThanOrEqualTo(Integer value) {
            addCriterion("_currents <=", value, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsIn(List<Integer> values) {
            addCriterion("_currents in", values, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsNotIn(List<Integer> values) {
            addCriterion("_currents not in", values, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsBetween(Integer value1, Integer value2) {
            addCriterion("_currents between", value1, value2, "currents");
            return (Criteria) this;
        }

        public Criteria andCurrentsNotBetween(Integer value1, Integer value2) {
            addCriterion("_currents not between", value1, value2, "currents");
            return (Criteria) this;
        }

        public Criteria andHeadIconIsNull() {
            addCriterion("_head_icon is null");
            return (Criteria) this;
        }

        public Criteria andHeadIconIsNotNull() {
            addCriterion("_head_icon is not null");
            return (Criteria) this;
        }

        public Criteria andHeadIconEqualTo(String value) {
            addCriterion("_head_icon =", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotEqualTo(String value) {
            addCriterion("_head_icon <>", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThan(String value) {
            addCriterion("_head_icon >", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThanOrEqualTo(String value) {
            addCriterion("_head_icon >=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThan(String value) {
            addCriterion("_head_icon <", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThanOrEqualTo(String value) {
            addCriterion("_head_icon <=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLike(String value) {
            addCriterion("_head_icon like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotLike(String value) {
            addCriterion("_head_icon not like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconIn(List<String> values) {
            addCriterion("_head_icon in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotIn(List<String> values) {
            addCriterion("_head_icon not in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconBetween(String value1, String value2) {
            addCriterion("_head_icon between", value1, value2, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotBetween(String value1, String value2) {
            addCriterion("_head_icon not between", value1, value2, "headIcon");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("_nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("_nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("_nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("_nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("_nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("_nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("_nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("_nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("_nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("_nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("_nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("_nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeIsNull() {
            addCriterion("_verfy_code is null");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeIsNotNull() {
            addCriterion("_verfy_code is not null");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeEqualTo(String value) {
            addCriterion("_verfy_code =", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeNotEqualTo(String value) {
            addCriterion("_verfy_code <>", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeGreaterThan(String value) {
            addCriterion("_verfy_code >", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_verfy_code >=", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeLessThan(String value) {
            addCriterion("_verfy_code <", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeLessThanOrEqualTo(String value) {
            addCriterion("_verfy_code <=", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeLike(String value) {
            addCriterion("_verfy_code like", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeNotLike(String value) {
            addCriterion("_verfy_code not like", value, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeIn(List<String> values) {
            addCriterion("_verfy_code in", values, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeNotIn(List<String> values) {
            addCriterion("_verfy_code not in", values, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeBetween(String value1, String value2) {
            addCriterion("_verfy_code between", value1, value2, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andVerfyCodeNotBetween(String value1, String value2) {
            addCriterion("_verfy_code not between", value1, value2, "verfyCode");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNull() {
            addCriterion("_valid_time is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNotNull() {
            addCriterion("_valid_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeEqualTo(Date value) {
            addCriterion("_valid_time =", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotEqualTo(Date value) {
            addCriterion("_valid_time <>", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThan(Date value) {
            addCriterion("_valid_time >", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_valid_time >=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThan(Date value) {
            addCriterion("_valid_time <", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThanOrEqualTo(Date value) {
            addCriterion("_valid_time <=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeIn(List<Date> values) {
            addCriterion("_valid_time in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotIn(List<Date> values) {
            addCriterion("_valid_time not in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeBetween(Date value1, Date value2) {
            addCriterion("_valid_time between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotBetween(Date value1, Date value2) {
            addCriterion("_valid_time not between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeIsNull() {
            addCriterion("_input_verfy_code is null");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeIsNotNull() {
            addCriterion("_input_verfy_code is not null");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeEqualTo(String value) {
            addCriterion("_input_verfy_code =", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeNotEqualTo(String value) {
            addCriterion("_input_verfy_code <>", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeGreaterThan(String value) {
            addCriterion("_input_verfy_code >", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_input_verfy_code >=", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeLessThan(String value) {
            addCriterion("_input_verfy_code <", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeLessThanOrEqualTo(String value) {
            addCriterion("_input_verfy_code <=", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeLike(String value) {
            addCriterion("_input_verfy_code like", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeNotLike(String value) {
            addCriterion("_input_verfy_code not like", value, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeIn(List<String> values) {
            addCriterion("_input_verfy_code in", values, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeNotIn(List<String> values) {
            addCriterion("_input_verfy_code not in", values, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeBetween(String value1, String value2) {
            addCriterion("_input_verfy_code between", value1, value2, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputVerfyCodeNotBetween(String value1, String value2) {
            addCriterion("_input_verfy_code not between", value1, value2, "inputVerfyCode");
            return (Criteria) this;
        }

        public Criteria andInputErrNumIsNull() {
            addCriterion("_input_err_num is null");
            return (Criteria) this;
        }

        public Criteria andInputErrNumIsNotNull() {
            addCriterion("_input_err_num is not null");
            return (Criteria) this;
        }

        public Criteria andInputErrNumEqualTo(Integer value) {
            addCriterion("_input_err_num =", value, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumNotEqualTo(Integer value) {
            addCriterion("_input_err_num <>", value, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumGreaterThan(Integer value) {
            addCriterion("_input_err_num >", value, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("_input_err_num >=", value, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumLessThan(Integer value) {
            addCriterion("_input_err_num <", value, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumLessThanOrEqualTo(Integer value) {
            addCriterion("_input_err_num <=", value, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumIn(List<Integer> values) {
            addCriterion("_input_err_num in", values, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumNotIn(List<Integer> values) {
            addCriterion("_input_err_num not in", values, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumBetween(Integer value1, Integer value2) {
            addCriterion("_input_err_num between", value1, value2, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrNumNotBetween(Integer value1, Integer value2) {
            addCriterion("_input_err_num not between", value1, value2, "inputErrNum");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeIsNull() {
            addCriterion("_input_err_last_time is null");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeIsNotNull() {
            addCriterion("_input_err_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeEqualTo(Date value) {
            addCriterion("_input_err_last_time =", value, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeNotEqualTo(Date value) {
            addCriterion("_input_err_last_time <>", value, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeGreaterThan(Date value) {
            addCriterion("_input_err_last_time >", value, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_input_err_last_time >=", value, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeLessThan(Date value) {
            addCriterion("_input_err_last_time <", value, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("_input_err_last_time <=", value, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeIn(List<Date> values) {
            addCriterion("_input_err_last_time in", values, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeNotIn(List<Date> values) {
            addCriterion("_input_err_last_time not in", values, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeBetween(Date value1, Date value2) {
            addCriterion("_input_err_last_time between", value1, value2, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andInputErrLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("_input_err_last_time not between", value1, value2, "inputErrLastTime");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumIsNull() {
            addCriterion("_scan_code_total_num is null");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumIsNotNull() {
            addCriterion("_scan_code_total_num is not null");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumEqualTo(Integer value) {
            addCriterion("_scan_code_total_num =", value, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumNotEqualTo(Integer value) {
            addCriterion("_scan_code_total_num <>", value, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumGreaterThan(Integer value) {
            addCriterion("_scan_code_total_num >", value, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("_scan_code_total_num >=", value, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumLessThan(Integer value) {
            addCriterion("_scan_code_total_num <", value, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("_scan_code_total_num <=", value, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumIn(List<Integer> values) {
            addCriterion("_scan_code_total_num in", values, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumNotIn(List<Integer> values) {
            addCriterion("_scan_code_total_num not in", values, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("_scan_code_total_num between", value1, value2, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("_scan_code_total_num not between", value1, value2, "scanCodeTotalNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumIsNull() {
            addCriterion("_scan_code_use_num is null");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumIsNotNull() {
            addCriterion("_scan_code_use_num is not null");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumEqualTo(Integer value) {
            addCriterion("_scan_code_use_num =", value, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumNotEqualTo(Integer value) {
            addCriterion("_scan_code_use_num <>", value, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumGreaterThan(Integer value) {
            addCriterion("_scan_code_use_num >", value, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("_scan_code_use_num >=", value, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumLessThan(Integer value) {
            addCriterion("_scan_code_use_num <", value, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumLessThanOrEqualTo(Integer value) {
            addCriterion("_scan_code_use_num <=", value, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumIn(List<Integer> values) {
            addCriterion("_scan_code_use_num in", values, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumNotIn(List<Integer> values) {
            addCriterion("_scan_code_use_num not in", values, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumBetween(Integer value1, Integer value2) {
            addCriterion("_scan_code_use_num between", value1, value2, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andScanCodeUseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("_scan_code_use_num not between", value1, value2, "scanCodeUseNum");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdIsNull() {
            addCriterion("_cash_coupon_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdIsNotNull() {
            addCriterion("_cash_coupon_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdEqualTo(Integer value) {
            addCriterion("_cash_coupon_prize_id =", value, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdNotEqualTo(Integer value) {
            addCriterion("_cash_coupon_prize_id <>", value, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdGreaterThan(Integer value) {
            addCriterion("_cash_coupon_prize_id >", value, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_cash_coupon_prize_id >=", value, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdLessThan(Integer value) {
            addCriterion("_cash_coupon_prize_id <", value, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("_cash_coupon_prize_id <=", value, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdIn(List<Integer> values) {
            addCriterion("_cash_coupon_prize_id in", values, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdNotIn(List<Integer> values) {
            addCriterion("_cash_coupon_prize_id not in", values, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdBetween(Integer value1, Integer value2) {
            addCriterion("_cash_coupon_prize_id between", value1, value2, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponPrizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_cash_coupon_prize_id not between", value1, value2, "cashCouponPrizeId");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeIsNull() {
            addCriterion("_cash_coupon_get_time is null");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeIsNotNull() {
            addCriterion("_cash_coupon_get_time is not null");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeEqualTo(Date value) {
            addCriterion("_cash_coupon_get_time =", value, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeNotEqualTo(Date value) {
            addCriterion("_cash_coupon_get_time <>", value, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeGreaterThan(Date value) {
            addCriterion("_cash_coupon_get_time >", value, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_cash_coupon_get_time >=", value, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeLessThan(Date value) {
            addCriterion("_cash_coupon_get_time <", value, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeLessThanOrEqualTo(Date value) {
            addCriterion("_cash_coupon_get_time <=", value, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeIn(List<Date> values) {
            addCriterion("_cash_coupon_get_time in", values, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeNotIn(List<Date> values) {
            addCriterion("_cash_coupon_get_time not in", values, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeBetween(Date value1, Date value2) {
            addCriterion("_cash_coupon_get_time between", value1, value2, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponGetTimeNotBetween(Date value1, Date value2) {
            addCriterion("_cash_coupon_get_time not between", value1, value2, "cashCouponGetTime");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountIsNull() {
            addCriterion("_cash_coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountIsNotNull() {
            addCriterion("_cash_coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountEqualTo(Integer value) {
            addCriterion("_cash_coupon_amount =", value, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountNotEqualTo(Integer value) {
            addCriterion("_cash_coupon_amount <>", value, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountGreaterThan(Integer value) {
            addCriterion("_cash_coupon_amount >", value, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_cash_coupon_amount >=", value, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountLessThan(Integer value) {
            addCriterion("_cash_coupon_amount <", value, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_cash_coupon_amount <=", value, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountIn(List<Integer> values) {
            addCriterion("_cash_coupon_amount in", values, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountNotIn(List<Integer> values) {
            addCriterion("_cash_coupon_amount not in", values, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountBetween(Integer value1, Integer value2) {
            addCriterion("_cash_coupon_amount between", value1, value2, "cashCouponAmount");
            return (Criteria) this;
        }

        public Criteria andCashCouponAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_cash_coupon_amount not between", value1, value2, "cashCouponAmount");
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
