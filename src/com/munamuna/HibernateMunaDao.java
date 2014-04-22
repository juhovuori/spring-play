package com.munamuna;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateMunaDao implements MunaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
	    return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Muna getMuna(long id) {

		if (id >= 100) return null;
		
		return (Muna) getSession().get(Muna.class, new Long(id));

	}
	
	@Transactional
	public Collection<Integer> getMunas() {
		return null;
	}
	
	@Transactional
	public void storeMuna(Muna muna) {
		getSession().saveOrUpdate(muna);
	}

	@Transactional
	public void removeMuna(Muna muna) {
		
	}


}
