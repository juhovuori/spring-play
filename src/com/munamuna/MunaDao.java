package com.munamuna;

import java.util.Collection;

public interface MunaDao {
	public Muna getMuna(long id);
	public Collection<Integer> getMunas();
	public void storeMuna(Muna muna);
	public void removeMuna(Muna muna);
}
