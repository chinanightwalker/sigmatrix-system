package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BarcodeALevelExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BarcodeALevelExample() {
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

        public Criteria andEncryptBarcodeALevelIsNull() {
            addCriterion("_encrypt_barcode_a_level is null");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelIsNotNull() {
            addCriterion("_encrypt_barcode_a_level is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelEqualTo(String value) {
            addCriterion("_encrypt_barcode_a_level =", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelNotEqualTo(String value) {
            addCriterion("_encrypt_barcode_a_level <>", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelGreaterThan(String value) {
            addCriterion("_encrypt_barcode_a_level >", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelGreaterThanOrEqualTo(String value) {
            addCriterion("_encrypt_barcode_a_level >=", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelLessThan(String value) {
            addCriterion("_encrypt_barcode_a_level <", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelLessThanOrEqualTo(String value) {
            addCriterion("_encrypt_barcode_a_level <=", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelLike(String value) {
            addCriterion("_encrypt_barcode_a_level like", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelNotLike(String value) {
            addCriterion("_encrypt_barcode_a_level not like", value, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelIn(List<String> values) {
            addCriterion("_encrypt_barcode_a_level in", values, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelNotIn(List<String> values) {
            addCriterion("_encrypt_barcode_a_level not in", values, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelBetween(String value1, String value2) {
            addCriterion("_encrypt_barcode_a_level between", value1, value2, "encryptBarcodeALevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeALevelNotBetween(String value1, String value2) {
            addCriterion("_encrypt_barcode_a_level not between", value1, value2, "encryptBarcodeALevel");
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

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("_enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("_enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("_enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("_enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("_enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("_enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("_enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("_enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("_product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("_product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("_product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("_product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("_product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("_product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("_product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("_product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("_product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelIsNull() {
            addCriterion("_encrypt_barcode_b_level is null");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelIsNotNull() {
            addCriterion("_encrypt_barcode_b_level is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level =", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelNotEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level <>", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelGreaterThan(String value) {
            addCriterion("_encrypt_barcode_b_level >", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelGreaterThanOrEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level >=", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelLessThan(String value) {
            addCriterion("_encrypt_barcode_b_level <", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelLessThanOrEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level <=", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelLike(String value) {
            addCriterion("_encrypt_barcode_b_level like", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelNotLike(String value) {
            addCriterion("_encrypt_barcode_b_level not like", value, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelIn(List<String> values) {
            addCriterion("_encrypt_barcode_b_level in", values, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelNotIn(List<String> values) {
            addCriterion("_encrypt_barcode_b_level not in", values, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelBetween(String value1, String value2) {
            addCriterion("_encrypt_barcode_b_level between", value1, value2, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelNotBetween(String value1, String value2) {
            addCriterion("_encrypt_barcode_b_level not between", value1, value2, "encryptBarcodeBLevel");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeIsNull() {
            addCriterion("_outside_code is null");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeIsNotNull() {
            addCriterion("_outside_code is not null");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeEqualTo(String value) {
            addCriterion("_outside_code =", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeNotEqualTo(String value) {
            addCriterion("_outside_code <>", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeGreaterThan(String value) {
            addCriterion("_outside_code >", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_outside_code >=", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeLessThan(String value) {
            addCriterion("_outside_code <", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeLessThanOrEqualTo(String value) {
            addCriterion("_outside_code <=", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeLike(String value) {
            addCriterion("_outside_code like", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeNotLike(String value) {
            addCriterion("_outside_code not like", value, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeIn(List<String> values) {
            addCriterion("_outside_code in", values, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeNotIn(List<String> values) {
            addCriterion("_outside_code not in", values, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeBetween(String value1, String value2) {
            addCriterion("_outside_code between", value1, value2, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andOutsideCodeNotBetween(String value1, String value2) {
            addCriterion("_outside_code not between", value1, value2, "outsideCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeIsNull() {
            addCriterion("_input_code is null");
            return (Criteria) this;
        }

        public Criteria andInputCodeIsNotNull() {
            addCriterion("_input_code is not null");
            return (Criteria) this;
        }

        public Criteria andInputCodeEqualTo(String value) {
            addCriterion("_input_code =", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotEqualTo(String value) {
            addCriterion("_input_code <>", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeGreaterThan(String value) {
            addCriterion("_input_code >", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_input_code >=", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLessThan(String value) {
            addCriterion("_input_code <", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLessThanOrEqualTo(String value) {
            addCriterion("_input_code <=", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLike(String value) {
            addCriterion("_input_code like", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotLike(String value) {
            addCriterion("_input_code not like", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeIn(List<String> values) {
            addCriterion("_input_code in", values, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotIn(List<String> values) {
            addCriterion("_input_code not in", values, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeBetween(String value1, String value2) {
            addCriterion("_input_code between", value1, value2, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotBetween(String value1, String value2) {
            addCriterion("_input_code not between", value1, value2, "inputCode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNull() {
            addCriterion("_barcode is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("_barcode is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            addCriterion("_barcode =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            addCriterion("_barcode <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            addCriterion("_barcode >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("_barcode >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(String value) {
            addCriterion("_barcode <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            addCriterion("_barcode <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLike(String value) {
            addCriterion("_barcode like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotLike(String value) {
            addCriterion("_barcode not like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            addCriterion("_barcode in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            addCriterion("_barcode not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            addCriterion("_barcode between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            addCriterion("_barcode not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andValidationNumberIsNull() {
            addCriterion("_validation_number is null");
            return (Criteria) this;
        }

        public Criteria andValidationNumberIsNotNull() {
            addCriterion("_validation_number is not null");
            return (Criteria) this;
        }

        public Criteria andValidationNumberEqualTo(Integer value) {
            addCriterion("_validation_number =", value, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberNotEqualTo(Integer value) {
            addCriterion("_validation_number <>", value, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberGreaterThan(Integer value) {
            addCriterion("_validation_number >", value, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("_validation_number >=", value, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberLessThan(Integer value) {
            addCriterion("_validation_number <", value, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberLessThanOrEqualTo(Integer value) {
            addCriterion("_validation_number <=", value, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberIn(List<Integer> values) {
            addCriterion("_validation_number in", values, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberNotIn(List<Integer> values) {
            addCriterion("_validation_number not in", values, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberBetween(Integer value1, Integer value2) {
            addCriterion("_validation_number between", value1, value2, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andValidationNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("_validation_number not between", value1, value2, "validationNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberIsNull() {
            addCriterion("_query_number is null");
            return (Criteria) this;
        }

        public Criteria andQueryNumberIsNotNull() {
            addCriterion("_query_number is not null");
            return (Criteria) this;
        }

        public Criteria andQueryNumberEqualTo(Integer value) {
            addCriterion("_query_number =", value, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberNotEqualTo(Integer value) {
            addCriterion("_query_number <>", value, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberGreaterThan(Integer value) {
            addCriterion("_query_number >", value, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("_query_number >=", value, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberLessThan(Integer value) {
            addCriterion("_query_number <", value, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberLessThanOrEqualTo(Integer value) {
            addCriterion("_query_number <=", value, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberIn(List<Integer> values) {
            addCriterion("_query_number in", values, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberNotIn(List<Integer> values) {
            addCriterion("_query_number not in", values, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberBetween(Integer value1, Integer value2) {
            addCriterion("_query_number between", value1, value2, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andQueryNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("_query_number not between", value1, value2, "queryNumber");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeIsNull() {
            addCriterion("_first_validation_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeIsNotNull() {
            addCriterion("_first_validation_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeEqualTo(Date value) {
            addCriterion("_first_validation_time =", value, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeNotEqualTo(Date value) {
            addCriterion("_first_validation_time <>", value, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeGreaterThan(Date value) {
            addCriterion("_first_validation_time >", value, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_first_validation_time >=", value, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeLessThan(Date value) {
            addCriterion("_first_validation_time <", value, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeLessThanOrEqualTo(Date value) {
            addCriterion("_first_validation_time <=", value, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeIn(List<Date> values) {
            addCriterion("_first_validation_time in", values, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeNotIn(List<Date> values) {
            addCriterion("_first_validation_time not in", values, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeBetween(Date value1, Date value2) {
            addCriterion("_first_validation_time between", value1, value2, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andFirstValidationTimeNotBetween(Date value1, Date value2) {
            addCriterion("_first_validation_time not between", value1, value2, "firstValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeIsNull() {
            addCriterion("_last_validation_time is null");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeIsNotNull() {
            addCriterion("_last_validation_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeEqualTo(Date value) {
            addCriterion("_last_validation_time =", value, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeNotEqualTo(Date value) {
            addCriterion("_last_validation_time <>", value, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeGreaterThan(Date value) {
            addCriterion("_last_validation_time >", value, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_last_validation_time >=", value, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeLessThan(Date value) {
            addCriterion("_last_validation_time <", value, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeLessThanOrEqualTo(Date value) {
            addCriterion("_last_validation_time <=", value, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeIn(List<Date> values) {
            addCriterion("_last_validation_time in", values, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeNotIn(List<Date> values) {
            addCriterion("_last_validation_time not in", values, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeBetween(Date value1, Date value2) {
            addCriterion("_last_validation_time between", value1, value2, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andLastValidationTimeNotBetween(Date value1, Date value2) {
            addCriterion("_last_validation_time not between", value1, value2, "lastValidationTime");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberIsNull() {
            addCriterion("_continue_validation_number is null");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberIsNotNull() {
            addCriterion("_continue_validation_number is not null");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberEqualTo(Integer value) {
            addCriterion("_continue_validation_number =", value, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberNotEqualTo(Integer value) {
            addCriterion("_continue_validation_number <>", value, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberGreaterThan(Integer value) {
            addCriterion("_continue_validation_number >", value, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("_continue_validation_number >=", value, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberLessThan(Integer value) {
            addCriterion("_continue_validation_number <", value, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberLessThanOrEqualTo(Integer value) {
            addCriterion("_continue_validation_number <=", value, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberIn(List<Integer> values) {
            addCriterion("_continue_validation_number in", values, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberNotIn(List<Integer> values) {
            addCriterion("_continue_validation_number not in", values, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberBetween(Integer value1, Integer value2) {
            addCriterion("_continue_validation_number between", value1, value2, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andContinueValidationNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("_continue_validation_number not between", value1, value2, "continueValidationNumber");
            return (Criteria) this;
        }

        public Criteria andActivateStatusIsNull() {
            addCriterion("_activate_status is null");
            return (Criteria) this;
        }

        public Criteria andActivateStatusIsNotNull() {
            addCriterion("_activate_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivateStatusEqualTo(Integer value) {
            addCriterion("_activate_status =", value, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusNotEqualTo(Integer value) {
            addCriterion("_activate_status <>", value, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusGreaterThan(Integer value) {
            addCriterion("_activate_status >", value, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("_activate_status >=", value, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusLessThan(Integer value) {
            addCriterion("_activate_status <", value, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusLessThanOrEqualTo(Integer value) {
            addCriterion("_activate_status <=", value, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusIn(List<Integer> values) {
            addCriterion("_activate_status in", values, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusNotIn(List<Integer> values) {
            addCriterion("_activate_status not in", values, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusBetween(Integer value1, Integer value2) {
            addCriterion("_activate_status between", value1, value2, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andActivateStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("_activate_status not between", value1, value2, "activateStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNull() {
            addCriterion("_is_status is null");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNotNull() {
            addCriterion("_is_status is not null");
            return (Criteria) this;
        }

        public Criteria andIsStatusEqualTo(Integer value) {
            addCriterion("_is_status =", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotEqualTo(Integer value) {
            addCriterion("_is_status <>", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThan(Integer value) {
            addCriterion("_is_status >", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("_is_status >=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThan(Integer value) {
            addCriterion("_is_status <", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("_is_status <=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusIn(List<Integer> values) {
            addCriterion("_is_status in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotIn(List<Integer> values) {
            addCriterion("_is_status not in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusBetween(Integer value1, Integer value2) {
            addCriterion("_is_status between", value1, value2, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("_is_status not between", value1, value2, "isStatus");
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

        public Criteria andErrorLastValidationTimeIsNull() {
            addCriterion("_error_last_validation_time is null");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeIsNotNull() {
            addCriterion("_error_last_validation_time is not null");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeEqualTo(Date value) {
            addCriterion("_error_last_validation_time =", value, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeNotEqualTo(Date value) {
            addCriterion("_error_last_validation_time <>", value, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeGreaterThan(Date value) {
            addCriterion("_error_last_validation_time >", value, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_error_last_validation_time >=", value, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeLessThan(Date value) {
            addCriterion("_error_last_validation_time <", value, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeLessThanOrEqualTo(Date value) {
            addCriterion("_error_last_validation_time <=", value, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeIn(List<Date> values) {
            addCriterion("_error_last_validation_time in", values, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeNotIn(List<Date> values) {
            addCriterion("_error_last_validation_time not in", values, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeBetween(Date value1, Date value2) {
            addCriterion("_error_last_validation_time between", value1, value2, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andErrorLastValidationTimeNotBetween(Date value1, Date value2) {
            addCriterion("_error_last_validation_time not between", value1, value2, "errorLastValidationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIsNull() {
            addCriterion("_batch_code is null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIsNotNull() {
            addCriterion("_batch_code is not null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeEqualTo(String value) {
            addCriterion("_batch_code =", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotEqualTo(String value) {
            addCriterion("_batch_code <>", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThan(String value) {
            addCriterion("_batch_code >", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_batch_code >=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThan(String value) {
            addCriterion("_batch_code <", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThanOrEqualTo(String value) {
            addCriterion("_batch_code <=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLike(String value) {
            addCriterion("_batch_code like", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotLike(String value) {
            addCriterion("_batch_code not like", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIn(List<String> values) {
            addCriterion("_batch_code in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotIn(List<String> values) {
            addCriterion("_batch_code not in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeBetween(String value1, String value2) {
            addCriterion("_batch_code between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotBetween(String value1, String value2) {
            addCriterion("_batch_code not between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlIsNull() {
            addCriterion("_encrypt_barcode_b_level_fl is null");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlIsNotNull() {
            addCriterion("_encrypt_barcode_b_level_fl is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level_fl =", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlNotEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level_fl <>", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlGreaterThan(String value) {
            addCriterion("_encrypt_barcode_b_level_fl >", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlGreaterThanOrEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level_fl >=", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlLessThan(String value) {
            addCriterion("_encrypt_barcode_b_level_fl <", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlLessThanOrEqualTo(String value) {
            addCriterion("_encrypt_barcode_b_level_fl <=", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlLike(String value) {
            addCriterion("_encrypt_barcode_b_level_fl like", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlNotLike(String value) {
            addCriterion("_encrypt_barcode_b_level_fl not like", value, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlIn(List<String> values) {
            addCriterion("_encrypt_barcode_b_level_fl in", values, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlNotIn(List<String> values) {
            addCriterion("_encrypt_barcode_b_level_fl not in", values, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlBetween(String value1, String value2) {
            addCriterion("_encrypt_barcode_b_level_fl between", value1, value2, "encryptBarcodeBLevelFl");
            return (Criteria) this;
        }

        public Criteria andEncryptBarcodeBLevelFlNotBetween(String value1, String value2) {
            addCriterion("_encrypt_barcode_b_level_fl not between", value1, value2, "encryptBarcodeBLevelFl");
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
