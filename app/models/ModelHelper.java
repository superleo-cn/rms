package models;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;

import play.db.jpa.Model;
import utils.PaginationList;


public class ModelHelper {

	public static PaginationList pagination(String jpql, PaginationList paginationList, Class clazz, Object... objs) {
		paginationList = initPaginationList(paginationList);
		
		Query query = Model.em().createQuery(jpql, clazz);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter(i, objs[i]);
			}
		}
		query.setMaxResults(paginationList.getPageSize());
		query.setFirstResult(paginationList.getCurrentPage() - 1);
		paginationList.setRecordCount(getRowCount(jpql, objs));
		paginationList.setRecordList(query.getResultList());
		return paginationList;
	}

	public static PaginationList pagination(String jpql, PaginationList paginationList, Object... objs) {
		paginationList = initPaginationList(paginationList);

		Query query = Model.em().createQuery(jpql);
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter((i+1), objs[i]);
			}
		}
		query.setMaxResults(paginationList.getPageSize());
		query.setFirstResult((paginationList.getCurrentPage() - 1) * paginationList.getPageSize());
		paginationList.setRecordCount(getRowCount(jpql, objs));
		paginationList.setRecordList(query.getResultList());
		return paginationList;
	}

	public static Long getRowCount(final String jpql, Object... objs) {

		StringBuffer coutSql = new StringBuffer("select count(*) ");
		String trimSQL = jpql;
		if (StringUtils.contains(jpql.toLowerCase(), "select")) {
			trimSQL = jpql.substring(jpql.indexOf("from"), jpql.length());
		}

		if (StringUtils.contains(trimSQL.toLowerCase(), "order")) {
			trimSQL = trimSQL.substring(0, trimSQL.indexOf("order"));
		}
		coutSql.append(trimSQL);
		Query query = Model.em().createQuery(coutSql.toString());
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				query.setParameter((i+1), objs[i]);
			}
		}
		return (Long) query.getSingleResult();

	}
	
	public static PaginationList initPaginationList(PaginationList paginationList){
		return paginationList != null ? paginationList : new PaginationList();
	}

}