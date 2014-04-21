package com.munamuna;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Muna {
	public long id;
	public String text;
	public Date date;
	
	public long getId() { return this.id; }
	public void setId(long id) { this.id = id; }

	public String getText() { return this.text; }
	public void setText(String text) { this.text = text; }

	public Date getDate() { return this.date; }
	public void setDate(Date date) { this.date = date; }

	public Muna() { }
	
	public Muna(long id, String text, Date date) {
		this.id = id;
		this.text = text;
		this.date = date;
	}
}
