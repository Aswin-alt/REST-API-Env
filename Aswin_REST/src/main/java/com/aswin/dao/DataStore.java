package com.aswin.dao;

import java.util.HashMap;
import java.util.Map;

import com.aswin.model.Person;

public class DataStore {

	private Map<String, Person> personMap = new HashMap<>();
	
	//this class is a singleton and should not be instantiated directly!
	private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}

	//private constructor so people know to use the getInstance() function instead
	private DataStore(){
		//dummy data
		personMap.put("Aswin", new Person("Aswin", "Aswin was the first programmer.", 1999));
		personMap.put("Kevin", new Person("Kevin", "Kevin is the author of HappyCoding.io.", 1986));
		personMap.put("Stanley", new Person("Stanley", "Stanley is Kevin's cat.", 2007));
	}

	public Person getPerson(String name) {
		return personMap.get(name);
	}

	public void putPerson(Person person) {
		personMap.put(person.getName(), person);
	}
}
