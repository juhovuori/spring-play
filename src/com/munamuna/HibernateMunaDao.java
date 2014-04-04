package com.munamuna;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateMunaDao implements MunaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
	    return sessionFactory.getCurrentSession();
	}

	public Muna getMuna(long id) {

		if (id >= 100) return null;
		
		return (Muna) getSession().get(Muna.class, new Long(id));

	}
	
	public Collection<Integer> getMunas() {
		return null;
	}
	
	public void storeMuna(Muna muna) {
		
	}

	public void removeMuna(Muna muna) {
		
	}


}
