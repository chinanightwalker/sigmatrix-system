package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ActivityPrizeExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityPrizeExample() {
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

        public Criteria andPrizeNameIsNull() {
            addCriterion("_prize_name is null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNotNull() {
            addCriterion("_prize_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameEqualTo(String value) {
            addCriterion("_prize_name =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(String value) {
            addCriterion("_prize_name <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(String value) {
            addCriterion("_prize_name >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("_prize_name >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(String value) {
            addCriterion("_prize_name <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(String value) {
            addCriterion("_prize_name <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLike(String value) {
            addCriterion("_prize_name like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotLike(String value) {
            addCriterion("_prize_name not like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<String> values) {
            addCriterion("_prize_name in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<String> values) {
            addCriterion("_prize_name not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(String value1, String value2) {
            addCriterion("_prize_name between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(String value1, String value2) {
            addCriterion("_prize_name not between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeIsNull() {
            addCriterion("_is_box_prize is null");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeIsNotNull() {
            addCriterion("_is_box_prize is not null");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeEqualTo(Integer value) {
            addCriterion("_is_box_prize =", value, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeNotEqualTo(Integer value) {
            addCriterion("_is_box_prize <>", value, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeGreaterThan(Integer value) {
            addCriterion("_is_box_prize >", value, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_is_box_prize >=", value, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeLessThan(Integer value) {
            addCriterion("_is_box_prize <", value, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeLessThanOrEqualTo(Integer value) {
            addCriterion("_is_box_prize <=", value, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeIn(List<Integer> values) {
            addCriterion("_is_box_prize in", values, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeNotIn(List<Integer> values) {
            addCriterion("_is_box_prize not in", values, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeBetween(Integer value1, Integer value2) {
            addCriterion("_is_box_prize between", value1, value2, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andIsBoxPrizeNotBetween(Integer value1, Integer value2) {
            addCriterion("_is_box_prize not between", value1, value2, "isBoxPrize");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNull() {
            addCriterion("_prize_type is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("_prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(Integer value) {
            addCriterion("_prize_type =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(Integer value) {
            addCriterion("_prize_type <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(Integer value) {
            addCriterion("_prize_type >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_type >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(Integer value) {
            addCriterion("_prize_type <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_type <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<Integer> values) {
            addCriterion("_prize_type in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<Integer> values) {
            addCriterion("_prize_type not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(Integer value1, Integer value2) {
            addCriterion("_prize_type between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_type not between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeDescIsNull() {
            addCriterion("_prize_desc is null");
            return (Criteria) this;
        }

        public Criteria andPrizeDescIsNotNull() {
            addCriterion("_prize_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeDescEqualTo(String value) {
            addCriterion("_prize_desc =", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescNotEqualTo(String value) {
            addCriterion("_prize_desc <>", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescGreaterThan(String value) {
            addCriterion("_prize_desc >", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescGreaterThanOrEqualTo(String value) {
            addCriterion("_prize_desc >=", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescLessThan(String value) {
            addCriterion("_prize_desc <", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescLessThanOrEqualTo(String value) {
            addCriterion("_prize_desc <=", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescLike(String value) {
            addCriterion("_prize_desc like", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescNotLike(String value) {
            addCriterion("_prize_desc not like", value, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescIn(List<String> values) {
            addCriterion("_prize_desc in", values, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescNotIn(List<String> values) {
            addCriterion("_prize_desc not in", values, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescBetween(String value1, String value2) {
            addCriterion("_prize_desc between", value1, value2, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeDescNotBetween(String value1, String value2) {
            addCriterion("_prize_desc not between", value1, value2, "prizeDesc");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressIsNull() {
            addCriterion("_prize_get_address is null");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressIsNotNull() {
            addCriterion("_prize_get_address is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressEqualTo(String value) {
            addCriterion("_prize_get_address =", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressNotEqualTo(String value) {
            addCriterion("_prize_get_address <>", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressGreaterThan(String value) {
            addCriterion("_prize_get_address >", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressGreaterThanOrEqualTo(String value) {
            addCriterion("_prize_get_address >=", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressLessThan(String value) {
            addCriterion("_prize_get_address <", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressLessThanOrEqualTo(String value) {
            addCriterion("_prize_get_address <=", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressLike(String value) {
            addCriterion("_prize_get_address like", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressNotLike(String value) {
            addCriterion("_prize_get_address not like", value, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressIn(List<String> values) {
            addCriterion("_prize_get_address in", values, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressNotIn(List<String> values) {
            addCriterion("_prize_get_address not in", values, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressBetween(String value1, String value2) {
            addCriterion("_prize_get_address between", value1, value2, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeGetAddressNotBetween(String value1, String value2) {
            addCriterion("_prize_get_address not between", value1, value2, "prizeGetAddress");
            return (Criteria) this;
        }

        public Criteria andPrizeRateIsNull() {
            addCriterion("_prize_rate is null");
            return (Criteria) this;
        }

        public Criteria andPrizeRateIsNotNull() {
            addCriterion("_prize_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeRateEqualTo(Float value) {
            addCriterion("_prize_rate =", value, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateNotEqualTo(Float value) {
            addCriterion("_prize_rate <>", value, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateGreaterThan(Float value) {
            addCriterion("_prize_rate >", value, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateGreaterThanOrEqualTo(Float value) {
            addCriterion("_prize_rate >=", value, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateLessThan(Float value) {
            addCriterion("_prize_rate <", value, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateLessThanOrEqualTo(Float value) {
            addCriterion("_prize_rate <=", value, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateIn(List<Float> values) {
            addCriterion("_prize_rate in", values, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateNotIn(List<Float> values) {
            addCriterion("_prize_rate not in", values, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateBetween(Float value1, Float value2) {
            addCriterion("_prize_rate between", value1, value2, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andPrizeRateNotBetween(Float value1, Float value2) {
            addCriterion("_prize_rate not between", value1, value2, "prizeRate");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNull() {
            addCriterion("_integration is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNotNull() {
            addCriterion("_integration is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationEqualTo(Integer value) {
            addCriterion("_integration =", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotEqualTo(Integer value) {
            addCriterion("_integration <>", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThan(Integer value) {
            addCriterion("_integration >", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("_integration >=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThan(Integer value) {
            addCriterion("_integration <", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("_integration <=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationIn(List<Integer> values) {
            addCriterion("_integration in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotIn(List<Integer> values) {
            addCriterion("_integration not in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("_integration between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("_integration not between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andPrizeCountIsNull() {
            addCriterion("_prize_count is null");
            return (Criteria) this;
        }

        public Criteria andPrizeCountIsNotNull() {
            addCriterion("_prize_count is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeCountEqualTo(Integer value) {
            addCriterion("_prize_count =", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountNotEqualTo(Integer value) {
            addCriterion("_prize_count <>", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountGreaterThan(Integer value) {
            addCriterion("_prize_count >", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_count >=", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountLessThan(Integer value) {
            addCriterion("_prize_count <", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_count <=", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountIn(List<Integer> values) {
            addCriterion("_prize_count in", values, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountNotIn(List<Integer> values) {
            addCriterion("_prize_count not in", values, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountBetween(Integer value1, Integer value2) {
            addCriterion("_prize_count between", value1, value2, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_count not between", value1, value2, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountIsNull() {
            addCriterion("_prize_amount is null");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountIsNotNull() {
            addCriterion("_prize_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountEqualTo(Integer value) {
            addCriterion("_prize_amount =", value, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountNotEqualTo(Integer value) {
            addCriterion("_prize_amount <>", value, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountGreaterThan(Integer value) {
            addCriterion("_prize_amount >", value, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_amount >=", value, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountLessThan(Integer value) {
            addCriterion("_prize_amount <", value, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_amount <=", value, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountIn(List<Integer> values) {
            addCriterion("_prize_amount in", values, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountNotIn(List<Integer> values) {
            addCriterion("_prize_amount not in", values, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountBetween(Integer value1, Integer value2) {
            addCriterion("_prize_amount between", value1, value2, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_amount not between", value1, value2, "prizeAmount");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateIsNull() {
            addCriterion("_is_first_prize_rate is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateIsNotNull() {
            addCriterion("_is_first_prize_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateEqualTo(Float value) {
            addCriterion("_is_first_prize_rate =", value, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateNotEqualTo(Float value) {
            addCriterion("_is_first_prize_rate <>", value, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateGreaterThan(Float value) {
            addCriterion("_is_first_prize_rate >", value, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateGreaterThanOrEqualTo(Float value) {
            addCriterion("_is_first_prize_rate >=", value, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateLessThan(Float value) {
            addCriterion("_is_first_prize_rate <", value, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateLessThanOrEqualTo(Float value) {
            addCriterion("_is_first_prize_rate <=", value, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateIn(List<Float> values) {
            addCriterion("_is_first_prize_rate in", values, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateNotIn(List<Float> values) {
            addCriterion("_is_first_prize_rate not in", values, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateBetween(Float value1, Float value2) {
            addCriterion("_is_first_prize_rate between", value1, value2, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andIsFirstPrizeRateNotBetween(Float value1, Float value2) {
            addCriterion("_is_first_prize_rate not between", value1, value2, "isFirstPrizeRate");
            return (Criteria) this;
        }

        public Criteria andLuckyCountIsNull() {
            addCriterion("_lucky_count is null");
            return (Criteria) this;
        }

        public Criteria andLuckyCountIsNotNull() {
            addCriterion("_lucky_count is not null");
            return (Criteria) this;
        }

        public Criteria andLuckyCountEqualTo(Integer value) {
            addCriterion("_lucky_count =", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountNotEqualTo(Integer value) {
            addCriterion("_lucky_count <>", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountGreaterThan(Integer value) {
            addCriterion("_lucky_count >", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_lucky_count >=", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountLessThan(Integer value) {
            addCriterion("_lucky_count <", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountLessThanOrEqualTo(Integer value) {
            addCriterion("_lucky_count <=", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountIn(List<Integer> values) {
            addCriterion("_lucky_count in", values, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountNotIn(List<Integer> values) {
            addCriterion("_lucky_count not in", values, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountBetween(Integer value1, Integer value2) {
            addCriterion("_lucky_count between", value1, value2, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_lucky_count not between", value1, value2, "luckyCount");
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

        public Criteria andCreateUseridIsNull() {
            addCriterion("_create_userid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNotNull() {
            addCriterion("_create_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridEqualTo(Integer value) {
            addCriterion("_create_userid =", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotEqualTo(Integer value) {
            addCriterion("_create_userid <>", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThan(Integer value) {
            addCriterion("_create_userid >", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("_create_userid >=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThan(Integer value) {
            addCriterion("_create_userid <", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("_create_userid <=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIn(List<Integer> values) {
            addCriterion("_create_userid in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotIn(List<Integer> values) {
            addCriterion("_create_userid not in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridBetween(Integer value1, Integer value2) {
            addCriterion("_create_userid between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("_create_userid not between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIsNull() {
            addCriterion("_update_userid is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIsNotNull() {
            addCriterion("_update_userid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridEqualTo(Integer value) {
            addCriterion("_update_userid =", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotEqualTo(Integer value) {
            addCriterion("_update_userid <>", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridGreaterThan(Integer value) {
            addCriterion("_update_userid >", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("_update_userid >=", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridLessThan(Integer value) {
            addCriterion("_update_userid <", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("_update_userid <=", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIn(List<Integer> values) {
            addCriterion("_update_userid in", values, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotIn(List<Integer> values) {
            addCriterion("_update_userid not in", values, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridBetween(Integer value1, Integer value2) {
            addCriterion("_update_userid between", value1, value2, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("_update_userid not between", value1, value2, "updateUserid");
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

        public Criteria andPrizePicUrlIsNull() {
            addCriterion("_prize_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlIsNotNull() {
            addCriterion("_prize_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlEqualTo(String value) {
            addCriterion("_prize_pic_url =", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlNotEqualTo(String value) {
            addCriterion("_prize_pic_url <>", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlGreaterThan(String value) {
            addCriterion("_prize_pic_url >", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("_prize_pic_url >=", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlLessThan(String value) {
            addCriterion("_prize_pic_url <", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlLessThanOrEqualTo(String value) {
            addCriterion("_prize_pic_url <=", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlLike(String value) {
            addCriterion("_prize_pic_url like", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlNotLike(String value) {
            addCriterion("_prize_pic_url not like", value, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlIn(List<String> values) {
            addCriterion("_prize_pic_url in", values, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlNotIn(List<String> values) {
            addCriterion("_prize_pic_url not in", values, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlBetween(String value1, String value2) {
            addCriterion("_prize_pic_url between", value1, value2, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicUrlNotBetween(String value1, String value2) {
            addCriterion("_prize_pic_url not between", value1, value2, "prizePicUrl");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathIsNull() {
            addCriterion("_prize_pic_path is null");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathIsNotNull() {
            addCriterion("_prize_pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathEqualTo(String value) {
            addCriterion("_prize_pic_path =", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathNotEqualTo(String value) {
            addCriterion("_prize_pic_path <>", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathGreaterThan(String value) {
            addCriterion("_prize_pic_path >", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathGreaterThanOrEqualTo(String value) {
            addCriterion("_prize_pic_path >=", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathLessThan(String value) {
            addCriterion("_prize_pic_path <", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathLessThanOrEqualTo(String value) {
            addCriterion("_prize_pic_path <=", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathLike(String value) {
            addCriterion("_prize_pic_path like", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathNotLike(String value) {
            addCriterion("_prize_pic_path not like", value, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathIn(List<String> values) {
            addCriterion("_prize_pic_path in", values, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathNotIn(List<String> values) {
            addCriterion("_prize_pic_path not in", values, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathBetween(String value1, String value2) {
            addCriterion("_prize_pic_path between", value1, value2, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andPrizePicPathNotBetween(String value1, String value2) {
            addCriterion("_prize_pic_path not between", value1, value2, "prizePicPath");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeIsNull() {
            addCriterion("_red_bag_type is null");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeIsNotNull() {
            addCriterion("_red_bag_type is not null");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeEqualTo(Integer value) {
            addCriterion("_red_bag_type =", value, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeNotEqualTo(Integer value) {
            addCriterion("_red_bag_type <>", value, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeGreaterThan(Integer value) {
            addCriterion("_red_bag_type >", value, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_red_bag_type >=", value, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeLessThan(Integer value) {
            addCriterion("_red_bag_type <", value, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeLessThanOrEqualTo(Integer value) {
            addCriterion("_red_bag_type <=", value, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeIn(List<Integer> values) {
            addCriterion("_red_bag_type in", values, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeNotIn(List<Integer> values) {
            addCriterion("_red_bag_type not in", values, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeBetween(Integer value1, Integer value2) {
            addCriterion("_red_bag_type between", value1, value2, "redBagType");
            return (Criteria) this;
        }

        public Criteria andRedBagTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("_red_bag_type not between", value1, value2, "redBagType");
            return (Criteria) this;
        }

        public Criteria andMinAmountIsNull() {
            addCriterion("_min_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinAmountIsNotNull() {
            addCriterion("_min_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinAmountEqualTo(Integer value) {
            addCriterion("_min_amount =", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountNotEqualTo(Integer value) {
            addCriterion("_min_amount <>", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountGreaterThan(Integer value) {
            addCriterion("_min_amount >", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_min_amount >=", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountLessThan(Integer value) {
            addCriterion("_min_amount <", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_min_amount <=", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountIn(List<Integer> values) {
            addCriterion("_min_amount in", values, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountNotIn(List<Integer> values) {
            addCriterion("_min_amount not in", values, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountBetween(Integer value1, Integer value2) {
            addCriterion("_min_amount between", value1, value2, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_min_amount not between", value1, value2, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNull() {
            addCriterion("_max_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNotNull() {
            addCriterion("_max_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEqualTo(Integer value) {
            addCriterion("_max_amount =", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotEqualTo(Integer value) {
            addCriterion("_max_amount <>", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThan(Integer value) {
            addCriterion("_max_amount >", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_max_amount >=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThan(Integer value) {
            addCriterion("_max_amount <", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_max_amount <=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIn(List<Integer> values) {
            addCriterion("_max_amount in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotIn(List<Integer> values) {
            addCriterion("_max_amount not in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountBetween(Integer value1, Integer value2) {
            addCriterion("_max_amount between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_max_amount not between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountIsNull() {
            addCriterion("_first_min_amount is null");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountIsNotNull() {
            addCriterion("_first_min_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountEqualTo(Integer value) {
            addCriterion("_first_min_amount =", value, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountNotEqualTo(Integer value) {
            addCriterion("_first_min_amount <>", value, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountGreaterThan(Integer value) {
            addCriterion("_first_min_amount >", value, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_first_min_amount >=", value, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountLessThan(Integer value) {
            addCriterion("_first_min_amount <", value, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_first_min_amount <=", value, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountIn(List<Integer> values) {
            addCriterion("_first_min_amount in", values, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountNotIn(List<Integer> values) {
            addCriterion("_first_min_amount not in", values, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountBetween(Integer value1, Integer value2) {
            addCriterion("_first_min_amount between", value1, value2, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andFirstMinAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_first_min_amount not between", value1, value2, "firstMinAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountIsNull() {
            addCriterion("_prize_lucky_amount is null");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountIsNotNull() {
            addCriterion("_prize_lucky_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountEqualTo(Long value) {
            addCriterion("_prize_lucky_amount =", value, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountNotEqualTo(Long value) {
            addCriterion("_prize_lucky_amount <>", value, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountGreaterThan(Long value) {
            addCriterion("_prize_lucky_amount >", value, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("_prize_lucky_amount >=", value, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountLessThan(Long value) {
            addCriterion("_prize_lucky_amount <", value, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountLessThanOrEqualTo(Long value) {
            addCriterion("_prize_lucky_amount <=", value, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountIn(List<Long> values) {
            addCriterion("_prize_lucky_amount in", values, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountNotIn(List<Long> values) {
            addCriterion("_prize_lucky_amount not in", values, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountBetween(Long value1, Long value2) {
            addCriterion("_prize_lucky_amount between", value1, value2, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeLuckyAmountNotBetween(Long value1, Long value2) {
            addCriterion("_prize_lucky_amount not between", value1, value2, "prizeLuckyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountIsNull() {
            addCriterion("_prize_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountIsNotNull() {
            addCriterion("_prize_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountEqualTo(Long value) {
            addCriterion("_prize_total_amount =", value, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountNotEqualTo(Long value) {
            addCriterion("_prize_total_amount <>", value, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountGreaterThan(Long value) {
            addCriterion("_prize_total_amount >", value, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("_prize_total_amount >=", value, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountLessThan(Long value) {
            addCriterion("_prize_total_amount <", value, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountLessThanOrEqualTo(Long value) {
            addCriterion("_prize_total_amount <=", value, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountIn(List<Long> values) {
            addCriterion("_prize_total_amount in", values, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountNotIn(List<Long> values) {
            addCriterion("_prize_total_amount not in", values, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountBetween(Long value1, Long value2) {
            addCriterion("_prize_total_amount between", value1, value2, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeTotalAmountNotBetween(Long value1, Long value2) {
            addCriterion("_prize_total_amount not between", value1, value2, "prizeTotalAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountIsNull() {
            addCriterion("_prize_forcibly_count is null");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountIsNotNull() {
            addCriterion("_prize_forcibly_count is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountEqualTo(Integer value) {
            addCriterion("_prize_forcibly_count =", value, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountNotEqualTo(Integer value) {
            addCriterion("_prize_forcibly_count <>", value, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountGreaterThan(Integer value) {
            addCriterion("_prize_forcibly_count >", value, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_forcibly_count >=", value, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountLessThan(Integer value) {
            addCriterion("_prize_forcibly_count <", value, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_forcibly_count <=", value, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountIn(List<Integer> values) {
            addCriterion("_prize_forcibly_count in", values, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountNotIn(List<Integer> values) {
            addCriterion("_prize_forcibly_count not in", values, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountBetween(Integer value1, Integer value2) {
            addCriterion("_prize_forcibly_count between", value1, value2, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_forcibly_count not between", value1, value2, "prizeForciblyCount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountIsNull() {
            addCriterion("_prize_forcibly_amount is null");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountIsNotNull() {
            addCriterion("_prize_forcibly_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountEqualTo(Integer value) {
            addCriterion("_prize_forcibly_amount =", value, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountNotEqualTo(Integer value) {
            addCriterion("_prize_forcibly_amount <>", value, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountGreaterThan(Integer value) {
            addCriterion("_prize_forcibly_amount >", value, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_forcibly_amount >=", value, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountLessThan(Integer value) {
            addCriterion("_prize_forcibly_amount <", value, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_forcibly_amount <=", value, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountIn(List<Integer> values) {
            addCriterion("_prize_forcibly_amount in", values, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountNotIn(List<Integer> values) {
            addCriterion("_prize_forcibly_amount not in", values, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountBetween(Integer value1, Integer value2) {
            addCriterion("_prize_forcibly_amount between", value1, value2, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeForciblyAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_forcibly_amount not between", value1, value2, "prizeForciblyAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagHintIsNull() {
            addCriterion("_redbag_hint is null");
            return (Criteria) this;
        }

        public Criteria andRedbagHintIsNotNull() {
            addCriterion("_redbag_hint is not null");
            return (Criteria) this;
        }

        public Criteria andRedbagHintEqualTo(String value) {
            addCriterion("_redbag_hint =", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintNotEqualTo(String value) {
            addCriterion("_redbag_hint <>", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintGreaterThan(String value) {
            addCriterion("_redbag_hint >", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintGreaterThanOrEqualTo(String value) {
            addCriterion("_redbag_hint >=", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintLessThan(String value) {
            addCriterion("_redbag_hint <", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintLessThanOrEqualTo(String value) {
            addCriterion("_redbag_hint <=", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintLike(String value) {
            addCriterion("_redbag_hint like", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintNotLike(String value) {
            addCriterion("_redbag_hint not like", value, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintIn(List<String> values) {
            addCriterion("_redbag_hint in", values, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintNotIn(List<String> values) {
            addCriterion("_redbag_hint not in", values, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintBetween(String value1, String value2) {
            addCriterion("_redbag_hint between", value1, value2, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andRedbagHintNotBetween(String value1, String value2) {
            addCriterion("_redbag_hint not between", value1, value2, "redbagHint");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterionForJDBCDate("_begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("_begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("_begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("_begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterionForJDBCDate("_begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("_begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterionForJDBCDate("_begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("_begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("_begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("_begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("_end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("_end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("_end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("_end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("_end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("_end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("_end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("_end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("_end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("_end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("_end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeIsNull() {
            addCriterion("_prize_period_mode is null");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeIsNotNull() {
            addCriterion("_prize_period_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeEqualTo(Integer value) {
            addCriterion("_prize_period_mode =", value, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeNotEqualTo(Integer value) {
            addCriterion("_prize_period_mode <>", value, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeGreaterThan(Integer value) {
            addCriterion("_prize_period_mode >", value, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_period_mode >=", value, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeLessThan(Integer value) {
            addCriterion("_prize_period_mode <", value, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_period_mode <=", value, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeIn(List<Integer> values) {
            addCriterion("_prize_period_mode in", values, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeNotIn(List<Integer> values) {
            addCriterion("_prize_period_mode not in", values, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeBetween(Integer value1, Integer value2) {
            addCriterion("_prize_period_mode between", value1, value2, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodModeNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_period_mode not between", value1, value2, "prizePeriodMode");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountIsNull() {
            addCriterion("_prize_period_count is null");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountIsNotNull() {
            addCriterion("_prize_period_count is not null");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountEqualTo(Integer value) {
            addCriterion("_prize_period_count =", value, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountNotEqualTo(Integer value) {
            addCriterion("_prize_period_count <>", value, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountGreaterThan(Integer value) {
            addCriterion("_prize_period_count >", value, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_period_count >=", value, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountLessThan(Integer value) {
            addCriterion("_prize_period_count <", value, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_period_count <=", value, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountIn(List<Integer> values) {
            addCriterion("_prize_period_count in", values, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountNotIn(List<Integer> values) {
            addCriterion("_prize_period_count not in", values, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountBetween(Integer value1, Integer value2) {
            addCriterion("_prize_period_count between", value1, value2, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andPrizePeriodCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_period_count not between", value1, value2, "prizePeriodCount");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoIsNull() {
            addCriterion("_timeslot_info is null");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoIsNotNull() {
            addCriterion("_timeslot_info is not null");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoEqualTo(String value) {
            addCriterion("_timeslot_info =", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoNotEqualTo(String value) {
            addCriterion("_timeslot_info <>", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoGreaterThan(String value) {
            addCriterion("_timeslot_info >", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoGreaterThanOrEqualTo(String value) {
            addCriterion("_timeslot_info >=", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoLessThan(String value) {
            addCriterion("_timeslot_info <", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoLessThanOrEqualTo(String value) {
            addCriterion("_timeslot_info <=", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoLike(String value) {
            addCriterion("_timeslot_info like", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoNotLike(String value) {
            addCriterion("_timeslot_info not like", value, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoIn(List<String> values) {
            addCriterion("_timeslot_info in", values, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoNotIn(List<String> values) {
            addCriterion("_timeslot_info not in", values, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoBetween(String value1, String value2) {
            addCriterion("_timeslot_info between", value1, value2, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andTimeslotInfoNotBetween(String value1, String value2) {
            addCriterion("_timeslot_info not between", value1, value2, "timeslotInfo");
            return (Criteria) this;
        }

        public Criteria andValidDaysIsNull() {
            addCriterion("_valid_days is null");
            return (Criteria) this;
        }

        public Criteria andValidDaysIsNotNull() {
            addCriterion("_valid_days is not null");
            return (Criteria) this;
        }

        public Criteria andValidDaysEqualTo(Integer value) {
            addCriterion("_valid_days =", value, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysNotEqualTo(Integer value) {
            addCriterion("_valid_days <>", value, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysGreaterThan(Integer value) {
            addCriterion("_valid_days >", value, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("_valid_days >=", value, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysLessThan(Integer value) {
            addCriterion("_valid_days <", value, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysLessThanOrEqualTo(Integer value) {
            addCriterion("_valid_days <=", value, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysIn(List<Integer> values) {
            addCriterion("_valid_days in", values, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysNotIn(List<Integer> values) {
            addCriterion("_valid_days not in", values, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysBetween(Integer value1, Integer value2) {
            addCriterion("_valid_days between", value1, value2, "validDays");
            return (Criteria) this;
        }

        public Criteria andValidDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("_valid_days not between", value1, value2, "validDays");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountIsNull() {
            addCriterion("_cash_get_min_prize_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountIsNotNull() {
            addCriterion("_cash_get_min_prize_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountEqualTo(Integer value) {
            addCriterion("_cash_get_min_prize_amount =", value, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountNotEqualTo(Integer value) {
            addCriterion("_cash_get_min_prize_amount <>", value, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountGreaterThan(Integer value) {
            addCriterion("_cash_get_min_prize_amount >", value, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_cash_get_min_prize_amount >=", value, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountLessThan(Integer value) {
            addCriterion("_cash_get_min_prize_amount <", value, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_cash_get_min_prize_amount <=", value, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountIn(List<Integer> values) {
            addCriterion("_cash_get_min_prize_amount in", values, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountNotIn(List<Integer> values) {
            addCriterion("_cash_get_min_prize_amount not in", values, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountBetween(Integer value1, Integer value2) {
            addCriterion("_cash_get_min_prize_amount between", value1, value2, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andCashGetMinPrizeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_cash_get_min_prize_amount not between", value1, value2, "cashGetMinPrizeAmount");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorIsNull() {
            addCriterion("_prize_factor is null");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorIsNotNull() {
            addCriterion("_prize_factor is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorEqualTo(Integer value) {
            addCriterion("_prize_factor =", value, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorNotEqualTo(Integer value) {
            addCriterion("_prize_factor <>", value, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorGreaterThan(Integer value) {
            addCriterion("_prize_factor >", value, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorGreaterThanOrEqualTo(Integer value) {
            addCriterion("_prize_factor >=", value, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorLessThan(Integer value) {
            addCriterion("_prize_factor <", value, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorLessThanOrEqualTo(Integer value) {
            addCriterion("_prize_factor <=", value, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorIn(List<Integer> values) {
            addCriterion("_prize_factor in", values, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorNotIn(List<Integer> values) {
            addCriterion("_prize_factor not in", values, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorBetween(Integer value1, Integer value2) {
            addCriterion("_prize_factor between", value1, value2, "prizeFactor");
            return (Criteria) this;
        }

        public Criteria andPrizeFactorNotBetween(Integer value1, Integer value2) {
            addCriterion("_prize_factor not between", value1, value2, "prizeFactor");
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
