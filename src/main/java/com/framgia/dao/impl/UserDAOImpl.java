package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.search.SearchUser;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getUsers(SearchUser searchUser) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = builder.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		if (StringUtils.isNotBlank(searchUser.getKeyword())) {
			cr.where(builder.like(builder.lower(root.get("username")), "%" + searchUser.getKeyword() + "%"));
		}
		TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery(cr.select(root));

		typedQuery.setFirstResult((searchUser.getPage() - 1) * searchUser.getPageSize());
		typedQuery.setMaxResults(searchUser.getPageSize());

		// sort by id
		cr.orderBy(builder.asc(root.get("id")));

		return typedQuery.getResultList();
	}

	@Override
	public User getUserById(Integer user_id) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = builder.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		cr.select(root).where(builder.equal(root.get("id"), user_id));
		cr.select(root);
		return (User) sessionFactory.getCurrentSession().createQuery(cr).uniqueResult();

	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);

	}

	@Override
	public void deleteUser(Integer user_id) {
		// TODO Auto-generated method stub

		User user = getUserById(user_id);
		if (user != null) {
			this.sessionFactory.getCurrentSession().delete(user);
		}

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(user);

	}

	@Override
	public Long countUser(SearchUser searchUser) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> cr = builder.createQuery(Long.class);
		Root<User> root = cr.from(User.class);
		if (StringUtils.isNotBlank(searchUser.getKeyword())) {
			cr.where(builder.like(builder.lower(root.get("username")), "%" + searchUser.getKeyword() + "%"));
		}
		return sessionFactory.getCurrentSession().createQuery(cr.select(builder.count(root))).getSingleResult();
	}

}
