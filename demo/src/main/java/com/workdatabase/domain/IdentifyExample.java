package com.workdatabase.domain;

import java.util.ArrayList;
import java.util.List;

public class IdentifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IdentifyExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRoommatenameIsNull() {
            addCriterion("roommateName is null");
            return (Criteria) this;
        }

        public Criteria andRoommatenameIsNotNull() {
            addCriterion("roommateName is not null");
            return (Criteria) this;
        }

        public Criteria andRoommatenameEqualTo(String value) {
            addCriterion("roommateName =", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameNotEqualTo(String value) {
            addCriterion("roommateName <>", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameGreaterThan(String value) {
            addCriterion("roommateName >", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameGreaterThanOrEqualTo(String value) {
            addCriterion("roommateName >=", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameLessThan(String value) {
            addCriterion("roommateName <", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameLessThanOrEqualTo(String value) {
            addCriterion("roommateName <=", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameLike(String value) {
            addCriterion("roommateName like", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameNotLike(String value) {
            addCriterion("roommateName not like", value, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameIn(List<String> values) {
            addCriterion("roommateName in", values, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameNotIn(List<String> values) {
            addCriterion("roommateName not in", values, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameBetween(String value1, String value2) {
            addCriterion("roommateName between", value1, value2, "roommatename");
            return (Criteria) this;
        }

        public Criteria andRoommatenameNotBetween(String value1, String value2) {
            addCriterion("roommateName not between", value1, value2, "roommatename");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeIsNull() {
            addCriterion("graduationTime is null");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeIsNotNull() {
            addCriterion("graduationTime is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeEqualTo(String value) {
            addCriterion("graduationTime =", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeNotEqualTo(String value) {
            addCriterion("graduationTime <>", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeGreaterThan(String value) {
            addCriterion("graduationTime >", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeGreaterThanOrEqualTo(String value) {
            addCriterion("graduationTime >=", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeLessThan(String value) {
            addCriterion("graduationTime <", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeLessThanOrEqualTo(String value) {
            addCriterion("graduationTime <=", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeLike(String value) {
            addCriterion("graduationTime like", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeNotLike(String value) {
            addCriterion("graduationTime not like", value, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeIn(List<String> values) {
            addCriterion("graduationTime in", values, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeNotIn(List<String> values) {
            addCriterion("graduationTime not in", values, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeBetween(String value1, String value2) {
            addCriterion("graduationTime between", value1, value2, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andGraduationtimeNotBetween(String value1, String value2) {
            addCriterion("graduationTime not between", value1, value2, "graduationtime");
            return (Criteria) this;
        }

        public Criteria andAcademynameIsNull() {
            addCriterion("academyName is null");
            return (Criteria) this;
        }

        public Criteria andAcademynameIsNotNull() {
            addCriterion("academyName is not null");
            return (Criteria) this;
        }

        public Criteria andAcademynameEqualTo(String value) {
            addCriterion("academyName =", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotEqualTo(String value) {
            addCriterion("academyName <>", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameGreaterThan(String value) {
            addCriterion("academyName >", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameGreaterThanOrEqualTo(String value) {
            addCriterion("academyName >=", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameLessThan(String value) {
            addCriterion("academyName <", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameLessThanOrEqualTo(String value) {
            addCriterion("academyName <=", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameLike(String value) {
            addCriterion("academyName like", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotLike(String value) {
            addCriterion("academyName not like", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameIn(List<String> values) {
            addCriterion("academyName in", values, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotIn(List<String> values) {
            addCriterion("academyName not in", values, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameBetween(String value1, String value2) {
            addCriterion("academyName between", value1, value2, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotBetween(String value1, String value2) {
            addCriterion("academyName not between", value1, value2, "academyname");
            return (Criteria) this;
        }

        public Criteria andBanjiIsNull() {
            addCriterion("banji is null");
            return (Criteria) this;
        }

        public Criteria andBanjiIsNotNull() {
            addCriterion("banji is not null");
            return (Criteria) this;
        }

        public Criteria andBanjiEqualTo(Integer value) {
            addCriterion("banji =", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotEqualTo(Integer value) {
            addCriterion("banji <>", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiGreaterThan(Integer value) {
            addCriterion("banji >", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiGreaterThanOrEqualTo(Integer value) {
            addCriterion("banji >=", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLessThan(Integer value) {
            addCriterion("banji <", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLessThanOrEqualTo(Integer value) {
            addCriterion("banji <=", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiIn(List<Integer> values) {
            addCriterion("banji in", values, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotIn(List<Integer> values) {
            addCriterion("banji not in", values, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiBetween(Integer value1, Integer value2) {
            addCriterion("banji between", value1, value2, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotBetween(Integer value1, Integer value2) {
            addCriterion("banji not between", value1, value2, "banji");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("Department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("Department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("Department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("Department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("Department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("Department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("Department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("Department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("Department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("Department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("Department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("Department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("Department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("Department not between", value1, value2, "department");
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