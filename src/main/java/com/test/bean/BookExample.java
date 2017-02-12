package com.test.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Long value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Long value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Long value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Long value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Long value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Long value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Long> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Long> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Long value1, Long value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Long value1, Long value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Long value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Long value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Long value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Long value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Long> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Long> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Long value1, Long value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andBookTypeIsNull() {
            addCriterion("book_type is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeIsNotNull() {
            addCriterion("book_type is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeEqualTo(Integer value) {
            addCriterion("book_type =", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotEqualTo(Integer value) {
            addCriterion("book_type <>", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeGreaterThan(Integer value) {
            addCriterion("book_type >", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_type >=", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeLessThan(Integer value) {
            addCriterion("book_type <", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeLessThanOrEqualTo(Integer value) {
            addCriterion("book_type <=", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeIn(List<Integer> values) {
            addCriterion("book_type in", values, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotIn(List<Integer> values) {
            addCriterion("book_type not in", values, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeBetween(Integer value1, Integer value2) {
            addCriterion("book_type between", value1, value2, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("book_type not between", value1, value2, "bookType");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterIsNull() {
            addCriterion("all_varcharacter is null");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterIsNotNull() {
            addCriterion("all_varcharacter is not null");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterEqualTo(Long value) {
            addCriterion("all_varcharacter =", value, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterNotEqualTo(Long value) {
            addCriterion("all_varcharacter <>", value, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterGreaterThan(Long value) {
            addCriterion("all_varcharacter >", value, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterGreaterThanOrEqualTo(Long value) {
            addCriterion("all_varcharacter >=", value, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterLessThan(Long value) {
            addCriterion("all_varcharacter <", value, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterLessThanOrEqualTo(Long value) {
            addCriterion("all_varcharacter <=", value, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterIn(List<Long> values) {
            addCriterion("all_varcharacter in", values, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterNotIn(List<Long> values) {
            addCriterion("all_varcharacter not in", values, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterBetween(Long value1, Long value2) {
            addCriterion("all_varcharacter between", value1, value2, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andAllVarcharacterNotBetween(Long value1, Long value2) {
            addCriterion("all_varcharacter not between", value1, value2, "allVarcharacter");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNull() {
            addCriterion("book_status is null");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNotNull() {
            addCriterion("book_status is not null");
            return (Criteria) this;
        }

        public Criteria andBookStatusEqualTo(Integer value) {
            addCriterion("book_status =", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotEqualTo(Integer value) {
            addCriterion("book_status <>", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThan(Integer value) {
            addCriterion("book_status >", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_status >=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThan(Integer value) {
            addCriterion("book_status <", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThanOrEqualTo(Integer value) {
            addCriterion("book_status <=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusIn(List<Integer> values) {
            addCriterion("book_status in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotIn(List<Integer> values) {
            addCriterion("book_status not in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusBetween(Integer value1, Integer value2) {
            addCriterion("book_status between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("book_status not between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusIsNull() {
            addCriterion("write_status is null");
            return (Criteria) this;
        }

        public Criteria andWriteStatusIsNotNull() {
            addCriterion("write_status is not null");
            return (Criteria) this;
        }

        public Criteria andWriteStatusEqualTo(Integer value) {
            addCriterion("write_status =", value, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusNotEqualTo(Integer value) {
            addCriterion("write_status <>", value, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusGreaterThan(Integer value) {
            addCriterion("write_status >", value, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("write_status >=", value, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusLessThan(Integer value) {
            addCriterion("write_status <", value, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("write_status <=", value, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusIn(List<Integer> values) {
            addCriterion("write_status in", values, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusNotIn(List<Integer> values) {
            addCriterion("write_status not in", values, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusBetween(Integer value1, Integer value2) {
            addCriterion("write_status between", value1, value2, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andWriteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("write_status not between", value1, value2, "writeStatus");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("click_num is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("click_num is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Long value) {
            addCriterion("click_num =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Long value) {
            addCriterion("click_num <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Long value) {
            addCriterion("click_num >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Long value) {
            addCriterion("click_num >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Long value) {
            addCriterion("click_num <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Long value) {
            addCriterion("click_num <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Long> values) {
            addCriterion("click_num in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Long> values) {
            addCriterion("click_num not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Long value1, Long value2) {
            addCriterion("click_num between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Long value1, Long value2) {
            addCriterion("click_num not between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNull() {
            addCriterion("read_num is null");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNotNull() {
            addCriterion("read_num is not null");
            return (Criteria) this;
        }

        public Criteria andReadNumEqualTo(Long value) {
            addCriterion("read_num =", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotEqualTo(Long value) {
            addCriterion("read_num <>", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThan(Long value) {
            addCriterion("read_num >", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThanOrEqualTo(Long value) {
            addCriterion("read_num >=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThan(Long value) {
            addCriterion("read_num <", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThanOrEqualTo(Long value) {
            addCriterion("read_num <=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIn(List<Long> values) {
            addCriterion("read_num in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotIn(List<Long> values) {
            addCriterion("read_num not in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumBetween(Long value1, Long value2) {
            addCriterion("read_num between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotBetween(Long value1, Long value2) {
            addCriterion("read_num not between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumIsNull() {
            addCriterion("income_num is null");
            return (Criteria) this;
        }

        public Criteria andIncomeNumIsNotNull() {
            addCriterion("income_num is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeNumEqualTo(Long value) {
            addCriterion("income_num =", value, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumNotEqualTo(Long value) {
            addCriterion("income_num <>", value, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumGreaterThan(Long value) {
            addCriterion("income_num >", value, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumGreaterThanOrEqualTo(Long value) {
            addCriterion("income_num >=", value, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumLessThan(Long value) {
            addCriterion("income_num <", value, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumLessThanOrEqualTo(Long value) {
            addCriterion("income_num <=", value, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumIn(List<Long> values) {
            addCriterion("income_num in", values, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumNotIn(List<Long> values) {
            addCriterion("income_num not in", values, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumBetween(Long value1, Long value2) {
            addCriterion("income_num between", value1, value2, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeNumNotBetween(Long value1, Long value2) {
            addCriterion("income_num not between", value1, value2, "incomeNum");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Long value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Long value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Long value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Long value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Long value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Long value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Long> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Long> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Long value1, Long value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Long value1, Long value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Float value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Float value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Float value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Float value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Float value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Float> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Float> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Float value1, Float value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Float value1, Float value2) {
            addCriterion("score not between", value1, value2, "score");
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