package com.jyb.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<PK extends Serializable,T> {
	void add(T t);
	List<T> list();
	T getById(PK id);
	void update(T t);
	void delete(PK id);
}
