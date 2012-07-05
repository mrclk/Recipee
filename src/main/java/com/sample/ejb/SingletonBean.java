package com.sample.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.sample.model.Property;

@Singleton
public class SingletonBean {

	private List<Property> cache;

	@PostConstruct
	public void initCache() {
		cache = new ArrayList<Property>();
	}

	public void delete(Property prop) {
		this.cache.remove(prop);
	}

	public void put(String key, String value) {
		Property p = new Property();
		p.setKey(key);
		p.setValue(value);

		this.cache.add(p);
	}

	public List<Property> getCache() {
		return cache;
	}

}