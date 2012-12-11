
package net.javaci.testrock.core.dao;

import java.util.List;

import net.javaci.testrock.core.model.DomainObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

public abstract class AbstractHibernateDaoImpl<T extends DomainObject> implements Dao<T> {
	
	private Class<T> domainClass;
	
	private SessionFactory sessionFactory;
	
	public AbstractHibernateDaoImpl(Class<T> domainClass) {
		this.domainClass =  domainClass;
	}

	protected Class<T> getDomainClass() {
		return domainClass;
	}
	
	// injected from Spring
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void delete(T object) {
		getSession().delete(object);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(long id) {
		return (T) getSession().get(domainClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T save(T object) {
		return (T) getSession().merge(object);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createCriteria(domainClass).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getCriteriaUnique(Criterion exp) {
		return (T) getSession()
			.createCriteria(domainClass)
			.add(exp)
			.uniqueResult();
	}
}
