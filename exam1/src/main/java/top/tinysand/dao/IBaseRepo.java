package top.tinysand.dao;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface IBaseRepo<T> {
    T get(Class<T> entityClass, Serializable id);

    T getWithLock(Serializable id, LockOptions lockOptionsOptions);

    T load(Serializable id);

    T loadWithLock(Serializable id, LockOptions lockOptions);

    List<T> loadAll();

    void update(T entity);

    void save(T entity);

    void saveOrUpdate(T entity);

    void saveOrUpdate(Collection<T> entities);

    void delete(T entity);

    void deleteByKey(Serializable id);

    void deleteAll(Collection<T> entities);

    List<T> find(String queryString);

    List<T> find(String queryString, Object[] objects);

    Iterator<T> iterate(String queryString);

    Iterator<T> iterate(String queryString, Object[] values);

    void closeIterator(Iterator<T> iterator);

    T queryForObject(String hql, Object[] params);

    T queryForTopObject(String hql, Object[] params);

    List<T> queryForList(String hql, Object[] objects);

    List<T> queryForList(final String hql, final Object[] params, final int recordNum);

    DetachedCriteria createDetachedCriteria();

    Criteria createCriteria();

    List<T> findEqualByEntity(T entity, String[] propertyNames);

    void flush();

    Query createQuery(final String queryString);

    Query createQuery(final String hql, final Object[] params);

    SQLQuery createSqlQuery(String queryString);
}
