package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPrizeTotalExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserPrizeTotalExample() {
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

        public Criteria andRedbagCountIsNull() {
            addCriterion("_redbag_count is null");
            return (Criteria) this;
        }

        public Criteria andRedbagCountIsNotNull() {
            addCriterion("_redbag_count is not null");
            return (Criteria) this;
        }

        public Criteria andRedbagCountEqualTo(Integer value) {
            addCriterion("_redbag_count =", value, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountNotEqualTo(Integer value) {
            addCriterion("_redbag_count <>", value, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountGreaterThan(Integer value) {
            addCriterion("_redbag_count >", value, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_redbag_count >=", value, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountLessThan(Integer value) {
            addCriterion("_redbag_count <", value, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountLessThanOrEqualTo(Integer value) {
            addCriterion("_redbag_count <=", value, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountIn(List<Integer> values) {
            addCriterion("_redbag_count in", values, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountNotIn(List<Integer> values) {
            addCriterion("_redbag_count not in", values, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_count between", value1, value2, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_count not between", value1, value2, "redbagCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountIsNull() {
            addCriterion("_redbag_success_count is null");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountIsNotNull() {
            addCriterion("_redbag_success_count is not null");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountEqualTo(Integer value) {
            addCriterion("_redbag_success_count =", value, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountNotEqualTo(Integer value) {
            addCriterion("_redbag_success_count <>", value, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountGreaterThan(Integer value) {
            addCriterion("_redbag_success_count >", value, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_redbag_success_count >=", value, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountLessThan(Integer value) {
            addCriterion("_redbag_success_count <", value, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountLessThanOrEqualTo(Integer value) {
            addCriterion("_redbag_success_count <=", value, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountIn(List<Integer> values) {
            addCriterion("_redbag_success_count in", values, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountNotIn(List<Integer> values) {
            addCriterion("_redbag_success_count not in", values, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_success_count between", value1, value2, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_success_count not between", value1, value2, "redbagSuccessCount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountIsNull() {
            addCriterion("_redbag_success_amount is null");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountIsNotNull() {
            addCriterion("_redbag_success_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountEqualTo(Integer value) {
            addCriterion("_redbag_success_amount =", value, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountNotEqualTo(Integer value) {
            addCriterion("_redbag_success_amount <>", value, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountGreaterThan(Integer value) {
            addCriterion("_redbag_success_amount >", value, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_redbag_success_amount >=", value, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountLessThan(Integer value) {
            addCriterion("_redbag_success_amount <", value, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_redbag_success_amount <=", value, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountIn(List<Integer> values) {
            addCriterion("_redbag_success_amount in", values, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountNotIn(List<Integer> values) {
            addCriterion("_redbag_success_amount not in", values, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_success_amount between", value1, value2, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagSuccessAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_success_amount not between", value1, value2, "redbagSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountIsNull() {
            addCriterion("_redbag_amount is null");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountIsNotNull() {
            addCriterion("_redbag_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountEqualTo(Integer value) {
            addCriterion("_redbag_amount =", value, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountNotEqualTo(Integer value) {
            addCriterion("_redbag_amount <>", value, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountGreaterThan(Integer value) {
            addCriterion("_redbag_amount >", value, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_redbag_amount >=", value, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountLessThan(Integer value) {
            addCriterion("_redbag_amount <", value, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_redbag_amount <=", value, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountIn(List<Integer> values) {
            addCriterion("_redbag_amount in", values, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountNotIn(List<Integer> values) {
            addCriterion("_redbag_amount not in", values, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_amount between", value1, value2, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andRedbagAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_redbag_amount not between", value1, value2, "redbagAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountIsNull() {
            addCriterion("_share_self_count is null");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountIsNotNull() {
            addCriterion("_share_self_count is not null");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountEqualTo(Integer value) {
            addCriterion("_share_self_count =", value, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountNotEqualTo(Integer value) {
            addCriterion("_share_self_count <>", value, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountGreaterThan(Integer value) {
            addCriterion("_share_self_count >", value, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_self_count >=", value, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountLessThan(Integer value) {
            addCriterion("_share_self_count <", value, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_self_count <=", value, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountIn(List<Integer> values) {
            addCriterion("_share_self_count in", values, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountNotIn(List<Integer> values) {
            addCriterion("_share_self_count not in", values, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_count between", value1, value2, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_count not between", value1, value2, "shareSelfCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountIsNull() {
            addCriterion("_share_self_success_count is null");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountIsNotNull() {
            addCriterion("_share_self_success_count is not null");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountEqualTo(Integer value) {
            addCriterion("_share_self_success_count =", value, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountNotEqualTo(Integer value) {
            addCriterion("_share_self_success_count <>", value, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountGreaterThan(Integer value) {
            addCriterion("_share_self_success_count >", value, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_self_success_count >=", value, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountLessThan(Integer value) {
            addCriterion("_share_self_success_count <", value, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_self_success_count <=", value, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountIn(List<Integer> values) {
            addCriterion("_share_self_success_count in", values, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountNotIn(List<Integer> values) {
            addCriterion("_share_self_success_count not in", values, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_success_count between", value1, value2, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_success_count not between", value1, value2, "shareSelfSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountIsNull() {
            addCriterion("_share_self_success_amount is null");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountIsNotNull() {
            addCriterion("_share_self_success_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountEqualTo(Integer value) {
            addCriterion("_share_self_success_amount =", value, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountNotEqualTo(Integer value) {
            addCriterion("_share_self_success_amount <>", value, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountGreaterThan(Integer value) {
            addCriterion("_share_self_success_amount >", value, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_self_success_amount >=", value, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountLessThan(Integer value) {
            addCriterion("_share_self_success_amount <", value, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_self_success_amount <=", value, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountIn(List<Integer> values) {
            addCriterion("_share_self_success_amount in", values, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountNotIn(List<Integer> values) {
            addCriterion("_share_self_success_amount not in", values, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_success_amount between", value1, value2, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfSuccessAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_success_amount not between", value1, value2, "shareSelfSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountIsNull() {
            addCriterion("_share_self_amount is null");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountIsNotNull() {
            addCriterion("_share_self_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountEqualTo(Integer value) {
            addCriterion("_share_self_amount =", value, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountNotEqualTo(Integer value) {
            addCriterion("_share_self_amount <>", value, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountGreaterThan(Integer value) {
            addCriterion("_share_self_amount >", value, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_self_amount >=", value, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountLessThan(Integer value) {
            addCriterion("_share_self_amount <", value, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_self_amount <=", value, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountIn(List<Integer> values) {
            addCriterion("_share_self_amount in", values, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountNotIn(List<Integer> values) {
            addCriterion("_share_self_amount not in", values, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_amount between", value1, value2, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareSelfAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_self_amount not between", value1, value2, "shareSelfAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountIsNull() {
            addCriterion("_share_other_count is null");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountIsNotNull() {
            addCriterion("_share_other_count is not null");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountEqualTo(Integer value) {
            addCriterion("_share_other_count =", value, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountNotEqualTo(Integer value) {
            addCriterion("_share_other_count <>", value, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountGreaterThan(Integer value) {
            addCriterion("_share_other_count >", value, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_other_count >=", value, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountLessThan(Integer value) {
            addCriterion("_share_other_count <", value, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_other_count <=", value, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountIn(List<Integer> values) {
            addCriterion("_share_other_count in", values, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountNotIn(List<Integer> values) {
            addCriterion("_share_other_count not in", values, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_count between", value1, value2, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_count not between", value1, value2, "shareOtherCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountIsNull() {
            addCriterion("_share_other_success_count is null");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountIsNotNull() {
            addCriterion("_share_other_success_count is not null");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountEqualTo(Integer value) {
            addCriterion("_share_other_success_count =", value, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountNotEqualTo(Integer value) {
            addCriterion("_share_other_success_count <>", value, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountGreaterThan(Integer value) {
            addCriterion("_share_other_success_count >", value, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_other_success_count >=", value, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountLessThan(Integer value) {
            addCriterion("_share_other_success_count <", value, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_other_success_count <=", value, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountIn(List<Integer> values) {
            addCriterion("_share_other_success_count in", values, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountNotIn(List<Integer> values) {
            addCriterion("_share_other_success_count not in", values, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_success_count between", value1, value2, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_success_count not between", value1, value2, "shareOtherSuccessCount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountIsNull() {
            addCriterion("_share_other_success_amount is null");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountIsNotNull() {
            addCriterion("_share_other_success_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountEqualTo(Integer value) {
            addCriterion("_share_other_success_amount =", value, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountNotEqualTo(Integer value) {
            addCriterion("_share_other_success_amount <>", value, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountGreaterThan(Integer value) {
            addCriterion("_share_other_success_amount >", value, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_other_success_amount >=", value, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountLessThan(Integer value) {
            addCriterion("_share_other_success_amount <", value, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_other_success_amount <=", value, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountIn(List<Integer> values) {
            addCriterion("_share_other_success_amount in", values, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountNotIn(List<Integer> values) {
            addCriterion("_share_other_success_amount not in", values, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_success_amount between", value1, value2, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherSuccessAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_success_amount not between", value1, value2, "shareOtherSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountIsNull() {
            addCriterion("_share_other_amount is null");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountIsNotNull() {
            addCriterion("_share_other_amount is not null");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountEqualTo(Integer value) {
            addCriterion("_share_other_amount =", value, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountNotEqualTo(Integer value) {
            addCriterion("_share_other_amount <>", value, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountGreaterThan(Integer value) {
            addCriterion("_share_other_amount >", value, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_share_other_amount >=", value, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountLessThan(Integer value) {
            addCriterion("_share_other_amount <", value, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_share_other_amount <=", value, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountIn(List<Integer> values) {
            addCriterion("_share_other_amount in", values, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountNotIn(List<Integer> values) {
            addCriterion("_share_other_amount not in", values, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_amount between", value1, value2, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andShareOtherAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_share_other_amount not between", value1, value2, "shareOtherAmount");
            return (Criteria) this;
        }

        public Criteria andChangeCountIsNull() {
            addCriterion("_change_count is null");
            return (Criteria) this;
        }

        public Criteria andChangeCountIsNotNull() {
            addCriterion("_change_count is not null");
            return (Criteria) this;
        }

        public Criteria andChangeCountEqualTo(Integer value) {
            addCriterion("_change_count =", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountNotEqualTo(Integer value) {
            addCriterion("_change_count <>", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountGreaterThan(Integer value) {
            addCriterion("_change_count >", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_change_count >=", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountLessThan(Integer value) {
            addCriterion("_change_count <", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountLessThanOrEqualTo(Integer value) {
            addCriterion("_change_count <=", value, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountIn(List<Integer> values) {
            addCriterion("_change_count in", values, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountNotIn(List<Integer> values) {
            addCriterion("_change_count not in", values, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountBetween(Integer value1, Integer value2) {
            addCriterion("_change_count between", value1, value2, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_change_count not between", value1, value2, "changeCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountIsNull() {
            addCriterion("_change_success_count is null");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountIsNotNull() {
            addCriterion("_change_success_count is not null");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountEqualTo(Integer value) {
            addCriterion("_change_success_count =", value, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountNotEqualTo(Integer value) {
            addCriterion("_change_success_count <>", value, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountGreaterThan(Integer value) {
            addCriterion("_change_success_count >", value, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_change_success_count >=", value, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountLessThan(Integer value) {
            addCriterion("_change_success_count <", value, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountLessThanOrEqualTo(Integer value) {
            addCriterion("_change_success_count <=", value, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountIn(List<Integer> values) {
            addCriterion("_change_success_count in", values, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountNotIn(List<Integer> values) {
            addCriterion("_change_success_count not in", values, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountBetween(Integer value1, Integer value2) {
            addCriterion("_change_success_count between", value1, value2, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_change_success_count not between", value1, value2, "changeSuccessCount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountIsNull() {
            addCriterion("_change_success_amount is null");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountIsNotNull() {
            addCriterion("_change_success_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountEqualTo(Integer value) {
            addCriterion("_change_success_amount =", value, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountNotEqualTo(Integer value) {
            addCriterion("_change_success_amount <>", value, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountGreaterThan(Integer value) {
            addCriterion("_change_success_amount >", value, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_change_success_amount >=", value, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountLessThan(Integer value) {
            addCriterion("_change_success_amount <", value, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_change_success_amount <=", value, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountIn(List<Integer> values) {
            addCriterion("_change_success_amount in", values, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountNotIn(List<Integer> values) {
            addCriterion("_change_success_amount not in", values, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountBetween(Integer value1, Integer value2) {
            addCriterion("_change_success_amount between", value1, value2, "changeSuccessAmount");
            return (Criteria) this;
        }

        public Criteria andChangeSuccessAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_change_success_amount not between", value1, value2, "changeSuccessAmount");
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

        public Criteria andIntegralCountIsNull() {
            addCriterion("_integral_count is null");
            return (Criteria) this;
        }

        public Criteria andIntegralCountIsNotNull() {
            addCriterion("_integral_count is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralCountEqualTo(Integer value) {
            addCriterion("_integral_count =", value, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNotEqualTo(Integer value) {
            addCriterion("_integral_count <>", value, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountGreaterThan(Integer value) {
            addCriterion("_integral_count >", value, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_integral_count >=", value, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountLessThan(Integer value) {
            addCriterion("_integral_count <", value, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountLessThanOrEqualTo(Integer value) {
            addCriterion("_integral_count <=", value, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountIn(List<Integer> values) {
            addCriterion("_integral_count in", values, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNotIn(List<Integer> values) {
            addCriterion("_integral_count not in", values, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountBetween(Integer value1, Integer value2) {
            addCriterion("_integral_count between", value1, value2, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_integral_count not between", value1, value2, "integralCount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountIsNull() {
            addCriterion("_integral_amount is null");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountIsNotNull() {
            addCriterion("_integral_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountEqualTo(Integer value) {
            addCriterion("_integral_amount =", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountNotEqualTo(Integer value) {
            addCriterion("_integral_amount <>", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountGreaterThan(Integer value) {
            addCriterion("_integral_amount >", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_integral_amount >=", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountLessThan(Integer value) {
            addCriterion("_integral_amount <", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_integral_amount <=", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountIn(List<Integer> values) {
            addCriterion("_integral_amount in", values, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountNotIn(List<Integer> values) {
            addCriterion("_integral_amount not in", values, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountBetween(Integer value1, Integer value2) {
            addCriterion("_integral_amount between", value1, value2, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_integral_amount not between", value1, value2, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andZlypCountIsNull() {
            addCriterion("_zlyp_count is null");
            return (Criteria) this;
        }

        public Criteria andZlypCountIsNotNull() {
            addCriterion("_zlyp_count is not null");
            return (Criteria) this;
        }

        public Criteria andZlypCountEqualTo(Integer value) {
            addCriterion("_zlyp_count =", value, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountNotEqualTo(Integer value) {
            addCriterion("_zlyp_count <>", value, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountGreaterThan(Integer value) {
            addCriterion("_zlyp_count >", value, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_zlyp_count >=", value, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountLessThan(Integer value) {
            addCriterion("_zlyp_count <", value, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountLessThanOrEqualTo(Integer value) {
            addCriterion("_zlyp_count <=", value, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountIn(List<Integer> values) {
            addCriterion("_zlyp_count in", values, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountNotIn(List<Integer> values) {
            addCriterion("_zlyp_count not in", values, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountBetween(Integer value1, Integer value2) {
            addCriterion("_zlyp_count between", value1, value2, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_zlyp_count not between", value1, value2, "zlypCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountIsNull() {
            addCriterion("_zlyp_get_count is null");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountIsNotNull() {
            addCriterion("_zlyp_get_count is not null");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountEqualTo(Integer value) {
            addCriterion("_zlyp_get_count =", value, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountNotEqualTo(Integer value) {
            addCriterion("_zlyp_get_count <>", value, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountGreaterThan(Integer value) {
            addCriterion("_zlyp_get_count >", value, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_zlyp_get_count >=", value, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountLessThan(Integer value) {
            addCriterion("_zlyp_get_count <", value, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountLessThanOrEqualTo(Integer value) {
            addCriterion("_zlyp_get_count <=", value, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountIn(List<Integer> values) {
            addCriterion("_zlyp_get_count in", values, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountNotIn(List<Integer> values) {
            addCriterion("_zlyp_get_count not in", values, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountBetween(Integer value1, Integer value2) {
            addCriterion("_zlyp_get_count between", value1, value2, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andZlypGetCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_zlyp_get_count not between", value1, value2, "zlypGetCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountIsNull() {
            addCriterion("_time_redbag_count is null");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountIsNotNull() {
            addCriterion("_time_redbag_count is not null");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountEqualTo(Integer value) {
            addCriterion("_time_redbag_count =", value, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountNotEqualTo(Integer value) {
            addCriterion("_time_redbag_count <>", value, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountGreaterThan(Integer value) {
            addCriterion("_time_redbag_count >", value, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_time_redbag_count >=", value, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountLessThan(Integer value) {
            addCriterion("_time_redbag_count <", value, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountLessThanOrEqualTo(Integer value) {
            addCriterion("_time_redbag_count <=", value, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountIn(List<Integer> values) {
            addCriterion("_time_redbag_count in", values, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountNotIn(List<Integer> values) {
            addCriterion("_time_redbag_count not in", values, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountBetween(Integer value1, Integer value2) {
            addCriterion("_time_redbag_count between", value1, value2, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_time_redbag_count not between", value1, value2, "timeRedbagCount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountIsNull() {
            addCriterion("_time_redbag_amount is null");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountIsNotNull() {
            addCriterion("_time_redbag_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountEqualTo(Integer value) {
            addCriterion("_time_redbag_amount =", value, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountNotEqualTo(Integer value) {
            addCriterion("_time_redbag_amount <>", value, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountGreaterThan(Integer value) {
            addCriterion("_time_redbag_amount >", value, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_time_redbag_amount >=", value, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountLessThan(Integer value) {
            addCriterion("_time_redbag_amount <", value, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_time_redbag_amount <=", value, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountIn(List<Integer> values) {
            addCriterion("_time_redbag_amount in", values, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountNotIn(List<Integer> values) {
            addCriterion("_time_redbag_amount not in", values, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountBetween(Integer value1, Integer value2) {
            addCriterion("_time_redbag_amount between", value1, value2, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andTimeRedbagAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_time_redbag_amount not between", value1, value2, "timeRedbagAmount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNull() {
            addCriterion("_coupon_count is null");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNotNull() {
            addCriterion("_coupon_count is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCountEqualTo(Integer value) {
            addCriterion("_coupon_count =", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotEqualTo(Integer value) {
            addCriterion("_coupon_count <>", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThan(Integer value) {
            addCriterion("_coupon_count >", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_coupon_count >=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThan(Integer value) {
            addCriterion("_coupon_count <", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThanOrEqualTo(Integer value) {
            addCriterion("_coupon_count <=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIn(List<Integer> values) {
            addCriterion("_coupon_count in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotIn(List<Integer> values) {
            addCriterion("_coupon_count not in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountBetween(Integer value1, Integer value2) {
            addCriterion("_coupon_count between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_coupon_count not between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNull() {
            addCriterion("_coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNotNull() {
            addCriterion("_coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountEqualTo(Integer value) {
            addCriterion("_coupon_amount =", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotEqualTo(Integer value) {
            addCriterion("_coupon_amount <>", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThan(Integer value) {
            addCriterion("_coupon_amount >", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_coupon_amount >=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThan(Integer value) {
            addCriterion("_coupon_amount <", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThanOrEqualTo(Integer value) {
            addCriterion("_coupon_amount <=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIn(List<Integer> values) {
            addCriterion("_coupon_amount in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotIn(List<Integer> values) {
            addCriterion("_coupon_amount not in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountBetween(Integer value1, Integer value2) {
            addCriterion("_coupon_amount between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("_coupon_amount not between", value1, value2, "couponAmount");
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
