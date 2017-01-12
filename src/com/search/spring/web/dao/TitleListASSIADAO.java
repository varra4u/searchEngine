package com.search.spring.web.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Component("TitleListASSIADAO")
@Transactional
public class TitleListASSIADAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		System.out.println(sessionFactory);
		return sessionFactory.getCurrentSession();
	}

	public List<TitleListASSIA> getTitleListASSIAs() {
		return session().createQuery("from TitleListASSIA").list();
	}

	public void saveOrUpdate(TitleListASSIA TitleListASSIA) {
		session().saveOrUpdate(TitleListASSIA);
	}

	/*public boolean delete(String ISSNPrint) {
		Session session = session().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("delete from Titles where ISSNPrint=:ISSNPrint");
		query.setString("ISSNPrint", ISSNPrint);

		return query.executeUpdate() == 1;
	}

	public Titles getTitleListASSIA(String ISSNPrint) {
		Session session = session().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from TitleListASSIA where ISSNPrint=:ISSNPrint");
		query.setString("ISSNPrint", ISSNPrint);
		return (TitleListASSIA) query.uniqueResult();
	}
*/
}
