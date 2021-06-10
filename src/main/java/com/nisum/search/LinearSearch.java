package com.nisum.search;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nisum.bean.Person;
import com.nisum.bean.PersonComp;

public class LinearSearch {

	public int linearSearch(List<Person> persons) {
		System.out.println("using insertionsort");
		List<Person> distinct = removeDuplicates(persons);
		return search(distinct);
	}

	private int search(List<Person> distinct) {
		Collections.sort(distinct);
		
		 Collections

		return search;
	}
	/*
	 * private List<Person> search(List<Person> distinct,int index){ List<Person>
	 * personlist=Collections.sea(distinct, distinct.get(4)); return distinct;
	 * 
	 * }
	 */

	private List<Person> removeDuplicates(List<Person> persons) {
		Set<Person> uniqPersonData = persons.stream().distinct().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

}
