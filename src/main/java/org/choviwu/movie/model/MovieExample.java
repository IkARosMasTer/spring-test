package org.choviwu.movie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNull() {
            addCriterion("movie_name is null");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNotNull() {
            addCriterion("movie_name is not null");
            return (Criteria) this;
        }

        public Criteria andMovieNameEqualTo(String value) {
            addCriterion("movie_name =", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotEqualTo(String value) {
            addCriterion("movie_name <>", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThan(String value) {
            addCriterion("movie_name >", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThanOrEqualTo(String value) {
            addCriterion("movie_name >=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThan(String value) {
            addCriterion("movie_name <", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThanOrEqualTo(String value) {
            addCriterion("movie_name <=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLike(String value) {
            addCriterion("movie_name like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotLike(String value) {
            addCriterion("movie_name not like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameIn(List<String> values) {
            addCriterion("movie_name in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotIn(List<String> values) {
            addCriterion("movie_name not in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameBetween(String value1, String value2) {
            addCriterion("movie_name between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotBetween(String value1, String value2) {
            addCriterion("movie_name not between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieLogoIsNull() {
            addCriterion("movie_logo is null");
            return (Criteria) this;
        }

        public Criteria andMovieLogoIsNotNull() {
            addCriterion("movie_logo is not null");
            return (Criteria) this;
        }

        public Criteria andMovieLogoEqualTo(String value) {
            addCriterion("movie_logo =", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoNotEqualTo(String value) {
            addCriterion("movie_logo <>", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoGreaterThan(String value) {
            addCriterion("movie_logo >", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoGreaterThanOrEqualTo(String value) {
            addCriterion("movie_logo >=", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoLessThan(String value) {
            addCriterion("movie_logo <", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoLessThanOrEqualTo(String value) {
            addCriterion("movie_logo <=", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoLike(String value) {
            addCriterion("movie_logo like", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoNotLike(String value) {
            addCriterion("movie_logo not like", value, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoIn(List<String> values) {
            addCriterion("movie_logo in", values, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoNotIn(List<String> values) {
            addCriterion("movie_logo not in", values, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoBetween(String value1, String value2) {
            addCriterion("movie_logo between", value1, value2, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieLogoNotBetween(String value1, String value2) {
            addCriterion("movie_logo not between", value1, value2, "movieLogo");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeIsNull() {
            addCriterion("movie_update_time is null");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeIsNotNull() {
            addCriterion("movie_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeEqualTo(String value) {
            addCriterion("movie_update_time =", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeNotEqualTo(String value) {
            addCriterion("movie_update_time <>", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeGreaterThan(String value) {
            addCriterion("movie_update_time >", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("movie_update_time >=", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeLessThan(String value) {
            addCriterion("movie_update_time <", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("movie_update_time <=", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeLike(String value) {
            addCriterion("movie_update_time like", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeNotLike(String value) {
            addCriterion("movie_update_time not like", value, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeIn(List<String> values) {
            addCriterion("movie_update_time in", values, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeNotIn(List<String> values) {
            addCriterion("movie_update_time not in", values, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeBetween(String value1, String value2) {
            addCriterion("movie_update_time between", value1, value2, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMovieUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("movie_update_time not between", value1, value2, "movieUpdateTime");
            return (Criteria) this;
        }

        public Criteria andActorListIsNull() {
            addCriterion("actor_list is null");
            return (Criteria) this;
        }

        public Criteria andActorListIsNotNull() {
            addCriterion("actor_list is not null");
            return (Criteria) this;
        }

        public Criteria andActorListEqualTo(String value) {
            addCriterion("actor_list =", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListNotEqualTo(String value) {
            addCriterion("actor_list <>", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListGreaterThan(String value) {
            addCriterion("actor_list >", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListGreaterThanOrEqualTo(String value) {
            addCriterion("actor_list >=", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListLessThan(String value) {
            addCriterion("actor_list <", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListLessThanOrEqualTo(String value) {
            addCriterion("actor_list <=", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListLike(String value) {
            addCriterion("actor_list like", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListNotLike(String value) {
            addCriterion("actor_list not like", value, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListIn(List<String> values) {
            addCriterion("actor_list in", values, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListNotIn(List<String> values) {
            addCriterion("actor_list not in", values, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListBetween(String value1, String value2) {
            addCriterion("actor_list between", value1, value2, "actorList");
            return (Criteria) this;
        }

        public Criteria andActorListNotBetween(String value1, String value2) {
            addCriterion("actor_list not between", value1, value2, "actorList");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
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