package com.services.products.ihelp.dao.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceOrderServiceTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceOrderServiceTagExample() {
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

        public Criteria andServiceOrderIdIsNull() {
            addCriterion("service_order_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdIsNotNull() {
            addCriterion("service_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdEqualTo(Long value) {
            addCriterion("service_order_id =", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotEqualTo(Long value) {
            addCriterion("service_order_id <>", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdGreaterThan(Long value) {
            addCriterion("service_order_id >", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("service_order_id >=", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdLessThan(Long value) {
            addCriterion("service_order_id <", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("service_order_id <=", value, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdIn(List<Long> values) {
            addCriterion("service_order_id in", values, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotIn(List<Long> values) {
            addCriterion("service_order_id not in", values, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdBetween(Long value1, Long value2) {
            addCriterion("service_order_id between", value1, value2, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("service_order_id not between", value1, value2, "serviceOrderId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdIsNull() {
            addCriterion("service_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdIsNotNull() {
            addCriterion("service_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdEqualTo(Integer value) {
            addCriterion("service_tag_id =", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotEqualTo(Integer value) {
            addCriterion("service_tag_id <>", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdGreaterThan(Integer value) {
            addCriterion("service_tag_id >", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_tag_id >=", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdLessThan(Integer value) {
            addCriterion("service_tag_id <", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_tag_id <=", value, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdIn(List<Integer> values) {
            addCriterion("service_tag_id in", values, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotIn(List<Integer> values) {
            addCriterion("service_tag_id not in", values, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_id between", value1, value2, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andServiceTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_tag_id not between", value1, value2, "serviceTagId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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