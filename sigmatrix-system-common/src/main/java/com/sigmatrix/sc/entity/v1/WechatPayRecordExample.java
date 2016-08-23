package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WechatPayRecordExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WechatPayRecordExample() {
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

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(String value) {
            addCriterion("_enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(String value) {
            addCriterion("_enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(String value) {
            addCriterion("_enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("_enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(String value) {
            addCriterion("_enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("_enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLike(String value) {
            addCriterion("_enterprise_id like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotLike(String value) {
            addCriterion("_enterprise_id not like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<String> values) {
            addCriterion("_enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<String> values) {
            addCriterion("_enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(String value1, String value2) {
            addCriterion("_enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("_enterprise_id not between", value1, value2, "enterpriseId");
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

        public Criteria andAmountIsNull() {
            addCriterion("_amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("_amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("_amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("_amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("_amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("_amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("_amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("_amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_amount not between", value1, value2, "amount");
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

        public Criteria andResultEqualTo(Integer value) {
            addCriterion("_result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Integer value) {
            addCriterion("_result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Integer value) {
            addCriterion("_result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("_result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Integer value) {
            addCriterion("_result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Integer value) {
            addCriterion("_result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Integer> values) {
            addCriterion("_result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Integer> values) {
            addCriterion("_result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Integer value1, Integer value2) {
            addCriterion("_result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Integer value1, Integer value2) {
            addCriterion("_result not between", value1, value2, "result");
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

        public Criteria andMchBillnoIsNull() {
            addCriterion("_mch_billno is null");
            return (Criteria) this;
        }

        public Criteria andMchBillnoIsNotNull() {
            addCriterion("_mch_billno is not null");
            return (Criteria) this;
        }

        public Criteria andMchBillnoEqualTo(String value) {
            addCriterion("_mch_billno =", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoNotEqualTo(String value) {
            addCriterion("_mch_billno <>", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoGreaterThan(String value) {
            addCriterion("_mch_billno >", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoGreaterThanOrEqualTo(String value) {
            addCriterion("_mch_billno >=", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoLessThan(String value) {
            addCriterion("_mch_billno <", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoLessThanOrEqualTo(String value) {
            addCriterion("_mch_billno <=", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoLike(String value) {
            addCriterion("_mch_billno like", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoNotLike(String value) {
            addCriterion("_mch_billno not like", value, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoIn(List<String> values) {
            addCriterion("_mch_billno in", values, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoNotIn(List<String> values) {
            addCriterion("_mch_billno not in", values, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoBetween(String value1, String value2) {
            addCriterion("_mch_billno between", value1, value2, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andMchBillnoNotBetween(String value1, String value2) {
            addCriterion("_mch_billno not between", value1, value2, "mchBillno");
            return (Criteria) this;
        }

        public Criteria andPaymentNoIsNull() {
            addCriterion("_payment_no is null");
            return (Criteria) this;
        }

        public Criteria andPaymentNoIsNotNull() {
            addCriterion("_payment_no is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentNoEqualTo(String value) {
            addCriterion("_payment_no =", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoNotEqualTo(String value) {
            addCriterion("_payment_no <>", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoGreaterThan(String value) {
            addCriterion("_payment_no >", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoGreaterThanOrEqualTo(String value) {
            addCriterion("_payment_no >=", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoLessThan(String value) {
            addCriterion("_payment_no <", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoLessThanOrEqualTo(String value) {
            addCriterion("_payment_no <=", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoLike(String value) {
            addCriterion("_payment_no like", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoNotLike(String value) {
            addCriterion("_payment_no not like", value, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoIn(List<String> values) {
            addCriterion("_payment_no in", values, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoNotIn(List<String> values) {
            addCriterion("_payment_no not in", values, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoBetween(String value1, String value2) {
            addCriterion("_payment_no between", value1, value2, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentNoNotBetween(String value1, String value2) {
            addCriterion("_payment_no not between", value1, value2, "paymentNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("_payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("_payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("_payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("_payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("_payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("_payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("_payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("_payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("_payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("_payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("_payment_time not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andResultMessageIsNull() {
            addCriterion("_result_message is null");
            return (Criteria) this;
        }

        public Criteria andResultMessageIsNotNull() {
            addCriterion("_result_message is not null");
            return (Criteria) this;
        }

        public Criteria andResultMessageEqualTo(String value) {
            addCriterion("_result_message =", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageNotEqualTo(String value) {
            addCriterion("_result_message <>", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageGreaterThan(String value) {
            addCriterion("_result_message >", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageGreaterThanOrEqualTo(String value) {
            addCriterion("_result_message >=", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageLessThan(String value) {
            addCriterion("_result_message <", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageLessThanOrEqualTo(String value) {
            addCriterion("_result_message <=", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageLike(String value) {
            addCriterion("_result_message like", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageNotLike(String value) {
            addCriterion("_result_message not like", value, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageIn(List<String> values) {
            addCriterion("_result_message in", values, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageNotIn(List<String> values) {
            addCriterion("_result_message not in", values, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageBetween(String value1, String value2) {
            addCriterion("_result_message between", value1, value2, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andResultMessageNotBetween(String value1, String value2) {
            addCriterion("_result_message not between", value1, value2, "resultMessage");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeIsNull() {
            addCriterion("_wx_err_code is null");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeIsNotNull() {
            addCriterion("_wx_err_code is not null");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeEqualTo(String value) {
            addCriterion("_wx_err_code =", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeNotEqualTo(String value) {
            addCriterion("_wx_err_code <>", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeGreaterThan(String value) {
            addCriterion("_wx_err_code >", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_wx_err_code >=", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeLessThan(String value) {
            addCriterion("_wx_err_code <", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeLessThanOrEqualTo(String value) {
            addCriterion("_wx_err_code <=", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeLike(String value) {
            addCriterion("_wx_err_code like", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeNotLike(String value) {
            addCriterion("_wx_err_code not like", value, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeIn(List<String> values) {
            addCriterion("_wx_err_code in", values, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeNotIn(List<String> values) {
            addCriterion("_wx_err_code not in", values, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeBetween(String value1, String value2) {
            addCriterion("_wx_err_code between", value1, value2, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrCodeNotBetween(String value1, String value2) {
            addCriterion("_wx_err_code not between", value1, value2, "wxErrCode");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgIsNull() {
            addCriterion("_wx_err_msg is null");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgIsNotNull() {
            addCriterion("_wx_err_msg is not null");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgEqualTo(String value) {
            addCriterion("_wx_err_msg =", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgNotEqualTo(String value) {
            addCriterion("_wx_err_msg <>", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgGreaterThan(String value) {
            addCriterion("_wx_err_msg >", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgGreaterThanOrEqualTo(String value) {
            addCriterion("_wx_err_msg >=", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgLessThan(String value) {
            addCriterion("_wx_err_msg <", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgLessThanOrEqualTo(String value) {
            addCriterion("_wx_err_msg <=", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgLike(String value) {
            addCriterion("_wx_err_msg like", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgNotLike(String value) {
            addCriterion("_wx_err_msg not like", value, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgIn(List<String> values) {
            addCriterion("_wx_err_msg in", values, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgNotIn(List<String> values) {
            addCriterion("_wx_err_msg not in", values, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgBetween(String value1, String value2) {
            addCriterion("_wx_err_msg between", value1, value2, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andWxErrMsgNotBetween(String value1, String value2) {
            addCriterion("_wx_err_msg not between", value1, value2, "wxErrMsg");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("_order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("_order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("_order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("_order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("_order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("_order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("_order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("_order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("_order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("_order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("_order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("_order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("_order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andMchidIsNull() {
            addCriterion("_mchid is null");
            return (Criteria) this;
        }

        public Criteria andMchidIsNotNull() {
            addCriterion("_mchid is not null");
            return (Criteria) this;
        }

        public Criteria andMchidEqualTo(String value) {
            addCriterion("_mchid =", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotEqualTo(String value) {
            addCriterion("_mchid <>", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidGreaterThan(String value) {
            addCriterion("_mchid >", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidGreaterThanOrEqualTo(String value) {
            addCriterion("_mchid >=", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLessThan(String value) {
            addCriterion("_mchid <", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLessThanOrEqualTo(String value) {
            addCriterion("_mchid <=", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLike(String value) {
            addCriterion("_mchid like", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotLike(String value) {
            addCriterion("_mchid not like", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidIn(List<String> values) {
            addCriterion("_mchid in", values, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotIn(List<String> values) {
            addCriterion("_mchid not in", values, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidBetween(String value1, String value2) {
            addCriterion("_mchid between", value1, value2, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotBetween(String value1, String value2) {
            addCriterion("_mchid not between", value1, value2, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchAppidIsNull() {
            addCriterion("_mch_appid is null");
            return (Criteria) this;
        }

        public Criteria andMchAppidIsNotNull() {
            addCriterion("_mch_appid is not null");
            return (Criteria) this;
        }

        public Criteria andMchAppidEqualTo(String value) {
            addCriterion("_mch_appid =", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidNotEqualTo(String value) {
            addCriterion("_mch_appid <>", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidGreaterThan(String value) {
            addCriterion("_mch_appid >", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidGreaterThanOrEqualTo(String value) {
            addCriterion("_mch_appid >=", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidLessThan(String value) {
            addCriterion("_mch_appid <", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidLessThanOrEqualTo(String value) {
            addCriterion("_mch_appid <=", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidLike(String value) {
            addCriterion("_mch_appid like", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidNotLike(String value) {
            addCriterion("_mch_appid not like", value, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidIn(List<String> values) {
            addCriterion("_mch_appid in", values, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidNotIn(List<String> values) {
            addCriterion("_mch_appid not in", values, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidBetween(String value1, String value2) {
            addCriterion("_mch_appid between", value1, value2, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andMchAppidNotBetween(String value1, String value2) {
            addCriterion("_mch_appid not between", value1, value2, "mchAppid");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNull() {
            addCriterion("_accept_time is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("_accept_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("_accept_time =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("_accept_time <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("_accept_time >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_accept_time >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("_accept_time <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("_accept_time <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("_accept_time in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("_accept_time not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("_accept_time between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("_accept_time not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNull() {
            addCriterion("_pay_count is null");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNotNull() {
            addCriterion("_pay_count is not null");
            return (Criteria) this;
        }

        public Criteria andPayCountEqualTo(Integer value) {
            addCriterion("_pay_count =", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotEqualTo(Integer value) {
            addCriterion("_pay_count <>", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThan(Integer value) {
            addCriterion("_pay_count >", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_pay_count >=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThan(Integer value) {
            addCriterion("_pay_count <", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThanOrEqualTo(Integer value) {
            addCriterion("_pay_count <=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountIn(List<Integer> values) {
            addCriterion("_pay_count in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotIn(List<Integer> values) {
            addCriterion("_pay_count not in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountBetween(Integer value1, Integer value2) {
            addCriterion("_pay_count between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_pay_count not between", value1, value2, "payCount");
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
