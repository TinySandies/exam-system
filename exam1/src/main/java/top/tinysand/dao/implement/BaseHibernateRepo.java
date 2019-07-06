package top.tinysand.dao.implement;

import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.tinysand.dao.IBaseRepo;
import top.tinysand.model.ExamTest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Transactional
public abstract class BaseHibernateRepo<T> {
    @SuppressWarnings("unchecked")
    public List<T> queryForList
            (final String hql, final Object[] params, final int recordNum) {
        return createQuery(hql, params).setFirstResult(0)
                .setMaxResults(recordNum).list();
    }

    private void setQueryParams(Query query, Object[] params) {
        if (null == params) {
            return;
        }
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
    }

    public T get(Class<T> entityClass, Serializable id) {
        return this.getSession().get(entityClass, id);
    }

    public T load(Serializable id) {
        return this.getSession().load(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public T queryForObject(final String hql, final Object[] params) {
        return (T) createQuery(hql, params).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public T queryForTopObject(final String hql, final Object[] params) {
        return (T) createQuery(hql, params).setFirstResult(0).setMaxResults(1).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<T> queryForList(final String hql, final Object[] params) {
        return createQuery(hql, params).list();
    }

    public List<T> loadAll() {
        String hql = " FROM " + entityClass.getName();
        return queryForList(hql, null);
    }

    public T getWithLock(Serializable id, LockOptions lockOptions) {
        T t = this.getSession().get(entityClass, id, lockOptions);
        if (t != null) this.flush();
        return t;
    }

    public T loadWithLock(Serializable id, LockOptions lockOptions) {
        T t = this.getSession().load(entityClass, id, lockOptions);
        if (t != null) this.flush();
        return t;
    }

    public void update(T entity) {
        if (null == entity) return;
        this.getSession().update(entity);
    }

    public void save(T entity) {
        if (null == entity) return;
        this.getSession().save(entity);
    }

    public void saveOrUpdate(T entity) {
        if (null == entity) return;
        this.getSession().saveOrUpdate(entity);
    }

    public void saveOrUpdate(Collection<T> entities) {
        if (null == entities) return;
        for (T t : entities) {
            this.getSession().save(t);
        }
    }

    public void delete(T entity) {
        this.getSession().delete(entity);
    }

    public void deleteByKey(Serializable id) {
        this.getSession().delete(this.load(id));
    }

    public void deleteAll(Collection<T> entities) {
        if (null == entities) return;
        for (T t : entities) {
            this.getSession().delete(t);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> find(String queryString) {
        Query query = this.getSession().createQuery(queryString);
        return query.list();
    }

    public List<T> find(String queryString, Object[] objects) {
        return this.queryForList(queryString, objects);
    }

    public Iterator<T> iterate(String queryString) {
        return this.find(queryString).iterator();
    }

    public Iterator<T> iterate(String queryString, Object[] values) {
        return this.queryForList(queryString, values).iterator();
    }

    public void closeIterator(Iterator<T> iterators) {
        this.closeIterator(iterators);
    }

    public DetachedCriteria createDetachedCriteria() {
        return DetachedCriteria.forClass(this.entityClass);
    }

    public Criteria createCriteria() {
        return this.createDetachedCriteria().getExecutableCriteria(getSession());
    }

    @SuppressWarnings("unchecked")
    public List<T> findEqualByEntity(T entity, String[] propertyNames) {
        Criteria criteria = this.createCriteria();
        Example example = Example.create(entity);
        example.excludeZeroes();
        String[] defProperties = this.getSessionFactory()
                .getClassMetadata(entityClass).getPropertyNames();

        for (String defProperty : defProperties) {
            int ii;
            for (ii = 0; ii < propertyNames.length; ii++) {
                if (defProperty.equals(propertyNames[ii])) {
                    criteria.addOrder(Order.asc(defProperty));
                    break;
                }
            }
            if (ii == propertyNames.length) {
                example.excludeProperty(defProperty);
            }
        }
        criteria.add(example);
        return (List<T>) criteria.list();
    }

    @Transactional
    public Query createQuery(final String queryString) {
        return this.getSession().createQuery(queryString);
    }

    @Transactional
    public Query createQuery(final String hql, final Object[] params) {
        Query query = this.createQuery(hql);
        setQueryParams(query, params);
        return query;
    }

    @Transactional
    public SQLQuery createSqlQuery(String queryString) {
        return this.getSession().createSQLQuery(queryString);
    }

    public void flush() {
        this.getSession().flush();
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.openSession();
    }

    private Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;
}
