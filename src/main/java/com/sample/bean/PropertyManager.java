package com.sample.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.sample.ejb.SingletonBean;
import com.sample.model.Property;

@ManagedBean(name = "manager")
@SessionScoped
public class PropertyManager {

	@EJB
	SingletonBean ejb;

	private Property selectedProp;
	private String key;
	private String value;

	public void save() {
		ejb.put(key, value);
	}

	public void clear() {
		ejb.delete(selectedProp);
	}

	public List getCacheList() {
		return ejb.getCache();
	}

	// Getters and Setters

	public Property getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Property selectedProp) {
		this.selectedProp = selectedProp;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}