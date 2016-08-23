package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductBaseExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductBaseExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("_product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("_product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("_product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("_product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("_product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("_product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("_product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("_product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("_product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("_product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("_product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("_product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("_product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("_product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("_product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("_product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("_product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("_product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("_product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("_product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("_product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("_product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("_product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("_product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("_product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("_product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("_product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("_product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("_product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("_product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("_product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("_product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("_product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("_product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("_product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("_product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("_product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("_product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("_product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("_product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("_product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdIsNull() {
            addCriterion("_product_classify_id is null");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdIsNotNull() {
            addCriterion("_product_classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdEqualTo(Integer value) {
            addCriterion("_product_classify_id =", value, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdNotEqualTo(Integer value) {
            addCriterion("_product_classify_id <>", value, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdGreaterThan(Integer value) {
            addCriterion("_product_classify_id >", value, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_product_classify_id >=", value, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdLessThan(Integer value) {
            addCriterion("_product_classify_id <", value, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("_product_classify_id <=", value, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdIn(List<Integer> values) {
            addCriterion("_product_classify_id in", values, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdNotIn(List<Integer> values) {
            addCriterion("_product_classify_id not in", values, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdBetween(Integer value1, Integer value2) {
            addCriterion("_product_classify_id between", value1, value2, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductClassifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_product_classify_id not between", value1, value2, "productClassifyId");
            return (Criteria) this;
        }

        public Criteria andProductInfoIsNull() {
            addCriterion("_product_info is null");
            return (Criteria) this;
        }

        public Criteria andProductInfoIsNotNull() {
            addCriterion("_product_info is not null");
            return (Criteria) this;
        }

        public Criteria andProductInfoEqualTo(String value) {
            addCriterion("_product_info =", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoNotEqualTo(String value) {
            addCriterion("_product_info <>", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoGreaterThan(String value) {
            addCriterion("_product_info >", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoGreaterThanOrEqualTo(String value) {
            addCriterion("_product_info >=", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoLessThan(String value) {
            addCriterion("_product_info <", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoLessThanOrEqualTo(String value) {
            addCriterion("_product_info <=", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoLike(String value) {
            addCriterion("_product_info like", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoNotLike(String value) {
            addCriterion("_product_info not like", value, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoIn(List<String> values) {
            addCriterion("_product_info in", values, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoNotIn(List<String> values) {
            addCriterion("_product_info not in", values, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoBetween(String value1, String value2) {
            addCriterion("_product_info between", value1, value2, "productInfo");
            return (Criteria) this;
        }

        public Criteria andProductInfoNotBetween(String value1, String value2) {
            addCriterion("_product_info not between", value1, value2, "productInfo");
            return (Criteria) this;
        }

        public Criteria andPackCountIsNull() {
            addCriterion("_pack_count is null");
            return (Criteria) this;
        }

        public Criteria andPackCountIsNotNull() {
            addCriterion("_pack_count is not null");
            return (Criteria) this;
        }

        public Criteria andPackCountEqualTo(Integer value) {
            addCriterion("_pack_count =", value, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountNotEqualTo(Integer value) {
            addCriterion("_pack_count <>", value, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountGreaterThan(Integer value) {
            addCriterion("_pack_count >", value, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_pack_count >=", value, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountLessThan(Integer value) {
            addCriterion("_pack_count <", value, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountLessThanOrEqualTo(Integer value) {
            addCriterion("_pack_count <=", value, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountIn(List<Integer> values) {
            addCriterion("_pack_count in", values, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountNotIn(List<Integer> values) {
            addCriterion("_pack_count not in", values, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountBetween(Integer value1, Integer value2) {
            addCriterion("_pack_count between", value1, value2, "packCount");
            return (Criteria) this;
        }

        public Criteria andPackCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_pack_count not between", value1, value2, "packCount");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateIsNull() {
            addCriterion("_product_integrate is null");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateIsNotNull() {
            addCriterion("_product_integrate is not null");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateEqualTo(Integer value) {
            addCriterion("_product_integrate =", value, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateNotEqualTo(Integer value) {
            addCriterion("_product_integrate <>", value, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateGreaterThan(Integer value) {
            addCriterion("_product_integrate >", value, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("_product_integrate >=", value, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateLessThan(Integer value) {
            addCriterion("_product_integrate <", value, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateLessThanOrEqualTo(Integer value) {
            addCriterion("_product_integrate <=", value, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateIn(List<Integer> values) {
            addCriterion("_product_integrate in", values, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateNotIn(List<Integer> values) {
            addCriterion("_product_integrate not in", values, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateBetween(Integer value1, Integer value2) {
            addCriterion("_product_integrate between", value1, value2, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andProductIntegrateNotBetween(Integer value1, Integer value2) {
            addCriterion("_product_integrate not between", value1, value2, "productIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateIsNull() {
            addCriterion("_is_user_integrate is null");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateIsNotNull() {
            addCriterion("_is_user_integrate is not null");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateEqualTo(Integer value) {
            addCriterion("_is_user_integrate =", value, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateNotEqualTo(Integer value) {
            addCriterion("_is_user_integrate <>", value, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateGreaterThan(Integer value) {
            addCriterion("_is_user_integrate >", value, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("_is_user_integrate >=", value, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateLessThan(Integer value) {
            addCriterion("_is_user_integrate <", value, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateLessThanOrEqualTo(Integer value) {
            addCriterion("_is_user_integrate <=", value, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateIn(List<Integer> values) {
            addCriterion("_is_user_integrate in", values, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateNotIn(List<Integer> values) {
            addCriterion("_is_user_integrate not in", values, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateBetween(Integer value1, Integer value2) {
            addCriterion("_is_user_integrate between", value1, value2, "isUserIntegrate");
            return (Criteria) this;
        }

        public Criteria andIsUserIntegrateNotBetween(Integer value1, Integer value2) {
            addCriterion("_is_user_integrate not between", value1, value2, "isUserIntegrate");
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

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("_last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("_last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("_last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("_last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("_last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("_last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("_last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("_last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("_last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("_last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("_last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("_last_update_time not between", value1, value2, "lastUpdateTime");
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

        public Criteria andShelfLifeIsNull() {
            addCriterion("_shelf_life is null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIsNotNull() {
            addCriterion("_shelf_life is not null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeEqualTo(Integer value) {
            addCriterion("_shelf_life =", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotEqualTo(Integer value) {
            addCriterion("_shelf_life <>", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeGreaterThan(Integer value) {
            addCriterion("_shelf_life >", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_shelf_life >=", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeLessThan(Integer value) {
            addCriterion("_shelf_life <", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeLessThanOrEqualTo(Integer value) {
            addCriterion("_shelf_life <=", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIn(List<Integer> values) {
            addCriterion("_shelf_life in", values, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotIn(List<Integer> values) {
            addCriterion("_shelf_life not in", values, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeBetween(Integer value1, Integer value2) {
            addCriterion("_shelf_life between", value1, value2, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotBetween(Integer value1, Integer value2) {
            addCriterion("_shelf_life not between", value1, value2, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andSuppRuleIsNull() {
            addCriterion("_supp_rule is null");
            return (Criteria) this;
        }

        public Criteria andSuppRuleIsNotNull() {
            addCriterion("_supp_rule is not null");
            return (Criteria) this;
        }

        public Criteria andSuppRuleEqualTo(Integer value) {
            addCriterion("_supp_rule =", value, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleNotEqualTo(Integer value) {
            addCriterion("_supp_rule <>", value, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleGreaterThan(Integer value) {
            addCriterion("_supp_rule >", value, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("_supp_rule >=", value, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleLessThan(Integer value) {
            addCriterion("_supp_rule <", value, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleLessThanOrEqualTo(Integer value) {
            addCriterion("_supp_rule <=", value, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleIn(List<Integer> values) {
            addCriterion("_supp_rule in", values, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleNotIn(List<Integer> values) {
            addCriterion("_supp_rule not in", values, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleBetween(Integer value1, Integer value2) {
            addCriterion("_supp_rule between", value1, value2, "suppRule");
            return (Criteria) this;
        }

        public Criteria andSuppRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("_supp_rule not between", value1, value2, "suppRule");
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
