package com.sigmatrix.sc.entity.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample extends TablePrefix {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andIsIntegralIsNull() {
            addCriterion("_is_integral is null");
            return (Criteria) this;
        }

        public Criteria andIsIntegralIsNotNull() {
            addCriterion("_is_integral is not null");
            return (Criteria) this;
        }

        public Criteria andIsIntegralEqualTo(Integer value) {
            addCriterion("_is_integral =", value, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralNotEqualTo(Integer value) {
            addCriterion("_is_integral <>", value, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralGreaterThan(Integer value) {
            addCriterion("_is_integral >", value, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("_is_integral >=", value, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralLessThan(Integer value) {
            addCriterion("_is_integral <", value, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("_is_integral <=", value, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralIn(List<Integer> values) {
            addCriterion("_is_integral in", values, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralNotIn(List<Integer> values) {
            addCriterion("_is_integral not in", values, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralBetween(Integer value1, Integer value2) {
            addCriterion("_is_integral between", value1, value2, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("_is_integral not between", value1, value2, "isIntegral");
            return (Criteria) this;
        }

        public Criteria andIsAreaIsNull() {
            addCriterion("_is_area is null");
            return (Criteria) this;
        }

        public Criteria andIsAreaIsNotNull() {
            addCriterion("_is_area is not null");
            return (Criteria) this;
        }

        public Criteria andIsAreaEqualTo(Integer value) {
            addCriterion("_is_area =", value, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaNotEqualTo(Integer value) {
            addCriterion("_is_area <>", value, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaGreaterThan(Integer value) {
            addCriterion("_is_area >", value, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("_is_area >=", value, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaLessThan(Integer value) {
            addCriterion("_is_area <", value, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaLessThanOrEqualTo(Integer value) {
            addCriterion("_is_area <=", value, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaIn(List<Integer> values) {
            addCriterion("_is_area in", values, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaNotIn(List<Integer> values) {
            addCriterion("_is_area not in", values, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaBetween(Integer value1, Integer value2) {
            addCriterion("_is_area between", value1, value2, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("_is_area not between", value1, value2, "isArea");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("_is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("_is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(Integer value) {
            addCriterion("_is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(Integer value) {
            addCriterion("_is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(Integer value) {
            addCriterion("_is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("_is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(Integer value) {
            addCriterion("_is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(Integer value) {
            addCriterion("_is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<Integer> values) {
            addCriterion("_is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<Integer> values) {
            addCriterion("_is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(Integer value1, Integer value2) {
            addCriterion("_is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("_is_open not between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlIsNull() {
            addCriterion("_activity_img_url is null");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlIsNotNull() {
            addCriterion("_activity_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlEqualTo(String value) {
            addCriterion("_activity_img_url =", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotEqualTo(String value) {
            addCriterion("_activity_img_url <>", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlGreaterThan(String value) {
            addCriterion("_activity_img_url >", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("_activity_img_url >=", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlLessThan(String value) {
            addCriterion("_activity_img_url <", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlLessThanOrEqualTo(String value) {
            addCriterion("_activity_img_url <=", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlLike(String value) {
            addCriterion("_activity_img_url like", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotLike(String value) {
            addCriterion("_activity_img_url not like", value, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlIn(List<String> values) {
            addCriterion("_activity_img_url in", values, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotIn(List<String> values) {
            addCriterion("_activity_img_url not in", values, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlBetween(String value1, String value2) {
            addCriterion("_activity_img_url between", value1, value2, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityImgUrlNotBetween(String value1, String value2) {
            addCriterion("_activity_img_url not between", value1, value2, "activityImgUrl");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIsNull() {
            addCriterion("_activity_title is null");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIsNotNull() {
            addCriterion("_activity_title is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTitleEqualTo(String value) {
            addCriterion("_activity_title =", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotEqualTo(String value) {
            addCriterion("_activity_title <>", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleGreaterThan(String value) {
            addCriterion("_activity_title >", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleGreaterThanOrEqualTo(String value) {
            addCriterion("_activity_title >=", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLessThan(String value) {
            addCriterion("_activity_title <", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLessThanOrEqualTo(String value) {
            addCriterion("_activity_title <=", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLike(String value) {
            addCriterion("_activity_title like", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotLike(String value) {
            addCriterion("_activity_title not like", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIn(List<String> values) {
            addCriterion("_activity_title in", values, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotIn(List<String> values) {
            addCriterion("_activity_title not in", values, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleBetween(String value1, String value2) {
            addCriterion("_activity_title between", value1, value2, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotBetween(String value1, String value2) {
            addCriterion("_activity_title not between", value1, value2, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("_start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("_start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("_start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("_start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("_start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("_start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("_start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("_start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("_start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("_start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("_start_date not between", value1, value2, "startDate");
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
            addCriterion("_end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("_end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("_end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("_end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("_end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("_end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("_end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("_end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("_end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("_end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateIsNull() {
            addCriterion("_award_end_date is null");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateIsNotNull() {
            addCriterion("_award_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateEqualTo(Date value) {
            addCriterion("_award_end_date =", value, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateNotEqualTo(Date value) {
            addCriterion("_award_end_date <>", value, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateGreaterThan(Date value) {
            addCriterion("_award_end_date >", value, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("_award_end_date >=", value, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateLessThan(Date value) {
            addCriterion("_award_end_date <", value, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateLessThanOrEqualTo(Date value) {
            addCriterion("_award_end_date <=", value, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateIn(List<Date> values) {
            addCriterion("_award_end_date in", values, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateNotIn(List<Date> values) {
            addCriterion("_award_end_date not in", values, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateBetween(Date value1, Date value2) {
            addCriterion("_award_end_date between", value1, value2, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andAwardEndDateNotBetween(Date value1, Date value2) {
            addCriterion("_award_end_date not between", value1, value2, "awardEndDate");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectIsNull() {
            addCriterion("_is_force_collect is null");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectIsNotNull() {
            addCriterion("_is_force_collect is not null");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectEqualTo(Integer value) {
            addCriterion("_is_force_collect =", value, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectNotEqualTo(Integer value) {
            addCriterion("_is_force_collect <>", value, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectGreaterThan(Integer value) {
            addCriterion("_is_force_collect >", value, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectGreaterThanOrEqualTo(Integer value) {
            addCriterion("_is_force_collect >=", value, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectLessThan(Integer value) {
            addCriterion("_is_force_collect <", value, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectLessThanOrEqualTo(Integer value) {
            addCriterion("_is_force_collect <=", value, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectIn(List<Integer> values) {
            addCriterion("_is_force_collect in", values, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectNotIn(List<Integer> values) {
            addCriterion("_is_force_collect not in", values, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectBetween(Integer value1, Integer value2) {
            addCriterion("_is_force_collect between", value1, value2, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andIsForceCollectNotBetween(Integer value1, Integer value2) {
            addCriterion("_is_force_collect not between", value1, value2, "isForceCollect");
            return (Criteria) this;
        }

        public Criteria andUseIntegralIsNull() {
            addCriterion("_use_Integral is null");
            return (Criteria) this;
        }

        public Criteria andUseIntegralIsNotNull() {
            addCriterion("_use_Integral is not null");
            return (Criteria) this;
        }

        public Criteria andUseIntegralEqualTo(Integer value) {
            addCriterion("_use_Integral =", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralNotEqualTo(Integer value) {
            addCriterion("_use_Integral <>", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralGreaterThan(Integer value) {
            addCriterion("_use_Integral >", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("_use_Integral >=", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralLessThan(Integer value) {
            addCriterion("_use_Integral <", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("_use_Integral <=", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralIn(List<Integer> values) {
            addCriterion("_use_Integral in", values, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralNotIn(List<Integer> values) {
            addCriterion("_use_Integral not in", values, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralBetween(Integer value1, Integer value2) {
            addCriterion("_use_Integral between", value1, value2, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("_use_Integral not between", value1, value2, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andActivityRoleIsNull() {
            addCriterion("_activity_role is null");
            return (Criteria) this;
        }

        public Criteria andActivityRoleIsNotNull() {
            addCriterion("_activity_role is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRoleEqualTo(Integer value) {
            addCriterion("_activity_role =", value, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleNotEqualTo(Integer value) {
            addCriterion("_activity_role <>", value, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleGreaterThan(Integer value) {
            addCriterion("_activity_role >", value, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("_activity_role >=", value, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleLessThan(Integer value) {
            addCriterion("_activity_role <", value, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleLessThanOrEqualTo(Integer value) {
            addCriterion("_activity_role <=", value, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleIn(List<Integer> values) {
            addCriterion("_activity_role in", values, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleNotIn(List<Integer> values) {
            addCriterion("_activity_role not in", values, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleBetween(Integer value1, Integer value2) {
            addCriterion("_activity_role between", value1, value2, "activityRole");
            return (Criteria) this;
        }

        public Criteria andActivityRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("_activity_role not between", value1, value2, "activityRole");
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

        public Criteria andUnprizeIntegrationIsNull() {
            addCriterion("_unprize_integration is null");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationIsNotNull() {
            addCriterion("_unprize_integration is not null");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationEqualTo(Integer value) {
            addCriterion("_unprize_integration =", value, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationNotEqualTo(Integer value) {
            addCriterion("_unprize_integration <>", value, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationGreaterThan(Integer value) {
            addCriterion("_unprize_integration >", value, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("_unprize_integration >=", value, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationLessThan(Integer value) {
            addCriterion("_unprize_integration <", value, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("_unprize_integration <=", value, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationIn(List<Integer> values) {
            addCriterion("_unprize_integration in", values, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationNotIn(List<Integer> values) {
            addCriterion("_unprize_integration not in", values, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("_unprize_integration between", value1, value2, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andUnprizeIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("_unprize_integration not between", value1, value2, "unprizeIntegration");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNull() {
            addCriterion("_scan_count is null");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNotNull() {
            addCriterion("_scan_count is not null");
            return (Criteria) this;
        }

        public Criteria andScanCountEqualTo(Integer value) {
            addCriterion("_scan_count =", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotEqualTo(Integer value) {
            addCriterion("_scan_count <>", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThan(Integer value) {
            addCriterion("_scan_count >", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_scan_count >=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThan(Integer value) {
            addCriterion("_scan_count <", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThanOrEqualTo(Integer value) {
            addCriterion("_scan_count <=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountIn(List<Integer> values) {
            addCriterion("_scan_count in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotIn(List<Integer> values) {
            addCriterion("_scan_count not in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountBetween(Integer value1, Integer value2) {
            addCriterion("_scan_count between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_scan_count not between", value1, value2, "scanCount");
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

        public Criteria andNameIsNull() {
            addCriterion("_name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("_name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("_name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("_name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("_name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("_name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("_name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("_name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("_name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("_name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("_name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("_name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("_name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("_name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("_comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("_comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("_comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("_comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("_comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("_comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("_comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("_comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("_comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("_comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("_comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("_comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("_comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("_comments not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("_template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Integer value) {
            addCriterion("_template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Integer value) {
            addCriterion("_template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Integer value) {
            addCriterion("_template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Integer value) {
            addCriterion("_template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("_template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Integer> values) {
            addCriterion("_template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Integer> values) {
            addCriterion("_template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("_template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("_pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("_pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("_pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("_pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("_pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("_pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("_pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("_pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("_pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("_pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("_pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("_pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNull() {
            addCriterion("_pic_path is null");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNotNull() {
            addCriterion("_pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicPathEqualTo(String value) {
            addCriterion("_pic_path =", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotEqualTo(String value) {
            addCriterion("_pic_path <>", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThan(String value) {
            addCriterion("_pic_path >", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("_pic_path >=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThan(String value) {
            addCriterion("_pic_path <", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThanOrEqualTo(String value) {
            addCriterion("_pic_path <=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLike(String value) {
            addCriterion("_pic_path like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotLike(String value) {
            addCriterion("_pic_path not like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathIn(List<String> values) {
            addCriterion("_pic_path in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotIn(List<String> values) {
            addCriterion("_pic_path not in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathBetween(String value1, String value2) {
            addCriterion("_pic_path between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotBetween(String value1, String value2) {
            addCriterion("_pic_path not between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountIsNull() {
            addCriterion("_user_day_max_prize_count is null");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountIsNotNull() {
            addCriterion("_user_day_max_prize_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountEqualTo(Integer value) {
            addCriterion("_user_day_max_prize_count =", value, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountNotEqualTo(Integer value) {
            addCriterion("_user_day_max_prize_count <>", value, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountGreaterThan(Integer value) {
            addCriterion("_user_day_max_prize_count >", value, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("_user_day_max_prize_count >=", value, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountLessThan(Integer value) {
            addCriterion("_user_day_max_prize_count <", value, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountLessThanOrEqualTo(Integer value) {
            addCriterion("_user_day_max_prize_count <=", value, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountIn(List<Integer> values) {
            addCriterion("_user_day_max_prize_count in", values, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountNotIn(List<Integer> values) {
            addCriterion("_user_day_max_prize_count not in", values, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountBetween(Integer value1, Integer value2) {
            addCriterion("_user_day_max_prize_count between", value1, value2, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserDayMaxPrizeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("_user_day_max_prize_count not between", value1, value2, "userDayMaxPrizeCount");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeIsNull() {
            addCriterion("_user_max_prize_process_type is null");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeIsNotNull() {
            addCriterion("_user_max_prize_process_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeEqualTo(Integer value) {
            addCriterion("_user_max_prize_process_type =", value, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeNotEqualTo(Integer value) {
            addCriterion("_user_max_prize_process_type <>", value, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeGreaterThan(Integer value) {
            addCriterion("_user_max_prize_process_type >", value, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_user_max_prize_process_type >=", value, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeLessThan(Integer value) {
            addCriterion("_user_max_prize_process_type <", value, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeLessThanOrEqualTo(Integer value) {
            addCriterion("_user_max_prize_process_type <=", value, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeIn(List<Integer> values) {
            addCriterion("_user_max_prize_process_type in", values, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeNotIn(List<Integer> values) {
            addCriterion("_user_max_prize_process_type not in", values, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeBetween(Integer value1, Integer value2) {
            addCriterion("_user_max_prize_process_type between", value1, value2, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUserMaxPrizeProcessTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("_user_max_prize_process_type not between", value1, value2, "userMaxPrizeProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeIsNull() {
            addCriterion("_unactivite_process_type is null");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeIsNotNull() {
            addCriterion("_unactivite_process_type is not null");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeEqualTo(Integer value) {
            addCriterion("_unactivite_process_type =", value, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeNotEqualTo(Integer value) {
            addCriterion("_unactivite_process_type <>", value, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeGreaterThan(Integer value) {
            addCriterion("_unactivite_process_type >", value, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_unactivite_process_type >=", value, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeLessThan(Integer value) {
            addCriterion("_unactivite_process_type <", value, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeLessThanOrEqualTo(Integer value) {
            addCriterion("_unactivite_process_type <=", value, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeIn(List<Integer> values) {
            addCriterion("_unactivite_process_type in", values, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeNotIn(List<Integer> values) {
            addCriterion("_unactivite_process_type not in", values, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeBetween(Integer value1, Integer value2) {
            addCriterion("_unactivite_process_type between", value1, value2, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andUnactiviteProcessTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("_unactivite_process_type not between", value1, value2, "unactiviteProcessType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeIsNull() {
            addCriterion("_valid_date_type is null");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeIsNotNull() {
            addCriterion("_valid_date_type is not null");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeEqualTo(Integer value) {
            addCriterion("_valid_date_type =", value, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeNotEqualTo(Integer value) {
            addCriterion("_valid_date_type <>", value, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeGreaterThan(Integer value) {
            addCriterion("_valid_date_type >", value, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("_valid_date_type >=", value, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeLessThan(Integer value) {
            addCriterion("_valid_date_type <", value, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("_valid_date_type <=", value, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeIn(List<Integer> values) {
            addCriterion("_valid_date_type in", values, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeNotIn(List<Integer> values) {
            addCriterion("_valid_date_type not in", values, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeBetween(Integer value1, Integer value2) {
            addCriterion("_valid_date_type between", value1, value2, "validDateType");
            return (Criteria) this;
        }

        public Criteria andValidDateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("_valid_date_type not between", value1, value2, "validDateType");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdIsNull() {
            addCriterion("_first_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdIsNotNull() {
            addCriterion("_first_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdEqualTo(Integer value) {
            addCriterion("_first_prize_id =", value, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdNotEqualTo(Integer value) {
            addCriterion("_first_prize_id <>", value, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdGreaterThan(Integer value) {
            addCriterion("_first_prize_id >", value, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_first_prize_id >=", value, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdLessThan(Integer value) {
            addCriterion("_first_prize_id <", value, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("_first_prize_id <=", value, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdIn(List<Integer> values) {
            addCriterion("_first_prize_id in", values, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdNotIn(List<Integer> values) {
            addCriterion("_first_prize_id not in", values, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdBetween(Integer value1, Integer value2) {
            addCriterion("_first_prize_id between", value1, value2, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andFirstPrizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_first_prize_id not between", value1, value2, "firstPrizeId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("_account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("_account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("_account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("_account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("_account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("_account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("_account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("_account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("_account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andEstimateNumIsNull() {
            addCriterion("_estimate_num is null");
            return (Criteria) this;
        }

        public Criteria andEstimateNumIsNotNull() {
            addCriterion("_estimate_num is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateNumEqualTo(Integer value) {
            addCriterion("_estimate_num =", value, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumNotEqualTo(Integer value) {
            addCriterion("_estimate_num <>", value, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumGreaterThan(Integer value) {
            addCriterion("_estimate_num >", value, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("_estimate_num >=", value, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumLessThan(Integer value) {
            addCriterion("_estimate_num <", value, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumLessThanOrEqualTo(Integer value) {
            addCriterion("_estimate_num <=", value, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumIn(List<Integer> values) {
            addCriterion("_estimate_num in", values, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumNotIn(List<Integer> values) {
            addCriterion("_estimate_num not in", values, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumBetween(Integer value1, Integer value2) {
            addCriterion("_estimate_num between", value1, value2, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andEstimateNumNotBetween(Integer value1, Integer value2) {
            addCriterion("_estimate_num not between", value1, value2, "estimateNum");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("_step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("_step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("_step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("_step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("_step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("_step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("_step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("_step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("_step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("_step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("_step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("_step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andBindStatusIsNull() {
            addCriterion("_bind_status is null");
            return (Criteria) this;
        }

        public Criteria andBindStatusIsNotNull() {
            addCriterion("_bind_status is not null");
            return (Criteria) this;
        }

        public Criteria andBindStatusEqualTo(Integer value) {
            addCriterion("_bind_status =", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotEqualTo(Integer value) {
            addCriterion("_bind_status <>", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusGreaterThan(Integer value) {
            addCriterion("_bind_status >", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("_bind_status >=", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusLessThan(Integer value) {
            addCriterion("_bind_status <", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusLessThanOrEqualTo(Integer value) {
            addCriterion("_bind_status <=", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusIn(List<Integer> values) {
            addCriterion("_bind_status in", values, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotIn(List<Integer> values) {
            addCriterion("_bind_status not in", values, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusBetween(Integer value1, Integer value2) {
            addCriterion("_bind_status between", value1, value2, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("_bind_status not between", value1, value2, "bindStatus");
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
