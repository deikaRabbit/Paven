package com.paven.db.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class QueryDateSpecification<T> implements Specification<T> {

	private SearchDateInfo searchDateInfo;

	public QueryDateSpecification(SearchDateInfo searchDateInfo) {
		this.searchDateInfo = searchDateInfo;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		String[] joinTableName = searchDateInfo.getColumn().split("\\.");
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
		query.distinct(true);
		if (join != null) {
			return cb.between(join.<Date> get(joinTableColumn), (Date) searchDateInfo.getValue1(),
					(Date) searchDateInfo.getValue2());
		} else {
			return cb.between(root.<Date> get(searchDateInfo.getColumn()), (Date) searchDateInfo.getValue1(),
					(Date) searchDateInfo.getValue2());
		}
	}

}
