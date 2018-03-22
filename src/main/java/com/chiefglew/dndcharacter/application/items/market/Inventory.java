package com.chiefglew.dndcharacter.application.items.market;

public interface Inventory<T> {

	void addAll(Inventory<? extends T> t);

	void add(T t);

	void remove(T t);
}
