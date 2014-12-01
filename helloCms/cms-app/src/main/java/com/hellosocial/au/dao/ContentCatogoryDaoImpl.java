package com.hellosocial.au.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hellosocial.au.entity.Client;
import com.hellosocial.au.entity.ContentCatogory;
import com.hellosocial.au.entity.Rule;
import com.hellosocial.au.util.HibernateCreator;

@Stateless
public class ContentCatogoryDaoImpl implements ContentCatogoryDao {
	@Inject
	private SessionFactory sessionFactory = new HibernateCreator()
			.produceHibernateSessionFactory();

	@Override
	public void addContentCatogory(ContentCatogory contentCatogory) {
		try {

			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(contentCatogory);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

	@Override
	public List<ContentCatogory> getContentCatogories(int clientId) {
		List<ContentCatogory> list = null;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "FROM ContentCatogory cc WHERE cc.client.clientId = :clientId";
			Query query = session.createQuery(hql);
			query.setParameter("clientId", clientId);
			list = (List<ContentCatogory>) query.list();
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContentCatogory> getContentCatogories(Client client) {
		List<ContentCatogory> list = null;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "FROM ContentCatogory cc WHERE cc.client.clientId = :clientId";
			Query query = session.createQuery(hql);
			System.out.println("the client" + client.getClientId());
			query.setParameter("clientId", client.getClientId());
			list = (List<ContentCatogory>) query.list();
			transaction.commit();

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

		return list;
	}

	@Override
	public ContentCatogory getContentCatogory(int contentCatogoryId) {
		ContentCatogory contentCatogory = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			contentCatogory = (ContentCatogory) session.get(
					ContentCatogory.class, contentCatogoryId);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		return contentCatogory;
	}

	@Override
	public List<Rule> getRuleList(int contentCatogoryId) {

		List<Rule> list = null;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = " FROM Rule rule WHERE rule.contentCatogory.contentCatogoryId = :contentCatogoryId";
			Query query = session.createQuery(hql);
			query.setParameter("contentCatogoryId", contentCatogoryId);
			list = (List<Rule>) query.list();
			transaction.commit();

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

		return list;
	}

}
