package com.recipee.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GenericDataService<T> {

	public T getById(int id);
	
	public List<T> getAll();

	public void store(T t);

	public void update(T t);

	public void delete(T t);

	public void deleteByID(int id);

}
