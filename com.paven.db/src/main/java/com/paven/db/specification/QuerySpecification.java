package com.paven.db.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class QuerySpecification<T> implements Specification<T> {

	private SearchInfo searchInfo;

	public QuerySpecification(SearchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		String[] joinTableName = searchInfo.getColumn().split("\\.");
		String joinTableColumn = joinTableName[joinTableName.length - 1];
		Join join = null;
		if (joinTableName.length > 1) {
			for (int i = 0; i < joinTableName.length - 1; i++) {
				if (join == null)
					join = root.join(joinTableName[i], JoinType.INNER);
				else
					join = join.join(joinTableName[i], JoinType.INNER);
			}
		}

		if (searchInfo.getOperator().equalsIgnoreCase(">")) {
			if (join != null) {
				if (join.get(joinTableColumn).getJavaType() == Date.class) {
					query.distinct(true);
					return cb.greaterThan(join.<Date> get(joinTableColumn), (Date) searchInfo.getValue());
				} else {
					return cb.greaterThan(join.<String> get(joinTableColumn), searchInfo.getValue().toString());
				}
			} else {
				if (root.get(searchInfo.getColumn()).getJavaType() == Date.class) {
					return cb.greaterThan(root.<Date> get(searchInfo.getColumn()), (Date) searchInfo.getValue());
				} else {
					return cb.greaterThan(root.<String> get(searchInfo.getColumn()), searchInfo.getValue().toString());
				}
			}
		} else if (searchInfo.getOperator().equalsIgnoreCase(">=")) {
			if (join != null) {
				if (join.get(joinTableColumn).getJavaType() == Date.class) {
					query.distinct(true);
					return cb.greaterThanOrEqualTo(join.<Date> get(joinTableColumn), (Date) searchInfo.getValue());
				} else {
					return cb.greaterThanOrEqualTo(join.<String> get(joinTableColumn),
							searchInfo.getValue().toString());
				}
			} else {
				if (root.get(searchInfo.getColumn()).getJavaType() == Date.class) {
					return cb.greaterThanOrEqualTo(root.<Date> get(searchInfo.getColumn()),
							(Date) searchInfo.getValue());
				} else {
					return cb.greaterThanOrEqualTo(root.<String> get(searchInfo.getColumn()),
							searchInfo.getValue().toString());
				}
			}

		} else if (searchInfo.getOperator().equalsIgnoreCase("<")) {
			if (join != null) {
				if (join.get(joinTableColumn).getJavaType() == Date.class) {
					query.distinct(true);
					return cb.lessThan(join.<Date> get(joinTableColumn), (Date) searchInfo.getValue());
				} else {
					return cb.lessThan(join.<String> get(joinTableColumn), searchInfo.getValue().toString());
				}
			} else {
				if (root.get(searchInfo.getColumn()).getJavaType() == Date.class) {
					return cb.lessThan(root.<Date> get(searchInfo.getColumn()), (Date) searchInfo.getValue());
				} else {
					return cb.lessThan(root.<String> get(searchInfo.getColumn()), searchInfo.getValue().toString());
				}
			}
		} else if (searchInfo.getOperator().equalsIgnoreCase("<=")) {
			if (join != null) {
				if (join.get(joinTableColumn).getJavaType() == Date.class) {
					query.distinct(true);
					return cb.lessThanOrEqualTo(join.<Date> get(joinTableColumn), (Date) searchInfo.getValue());
				} else {
					return cb.lessThanOrEqualTo(join.<String> get(joinTableColumn), searchInfo.getValue().toString());
				}
			} else {
				if (root.get(searchInfo.getColumn()).getJavaType() == Date.class) {
					return cb.lessThanOrEqualTo(root.<Date> get(searchInfo.getColumn()), (Date) searchInfo.getValue());
				} else {
					return cb.lessThanOrEqualTo(root.<String> get(searchInfo.getColumn()),
							searchInfo.getValue().toString());
				}
			}
		} else if (searchInfo.getOperator().equalsIgnoreCase(":")) {
			if (join != null) {
				if (join.get(joinTableColumn).getJavaType() == String.class) {
					return cb.like(join.<String> get(joinTableColumn), "%" + searchInfo.getValue() + "%");
				} else {
					return cb.equal(join.get(joinTableColumn), searchInfo.getValue());
				}
			} else {
				if (root.get(searchInfo.getColumn()).getJavaType() == String.class) {
					return cb.like(root.<String> get(searchInfo.getColumn()), "%" + searchInfo.getValue() + "%");
				} else {
					return cb.equal(root.get(searchInfo.getColumn()), searchInfo.getValue());
				}
			}
		}
		return null;
	}

}
