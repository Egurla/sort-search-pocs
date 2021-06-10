package com.nisum.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.omg.CORBA.OMGVMCID;

import com.nisum.bean.Person;

public class InsertionSort {
	public List<Person> insertionSort(List<Person> persons, boolean isDescendingOrder) {

		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinctpersonData, boolean isDescendingOrder) {

		if (!isDescendingOrder) {
			System.out.println("calling  insertionSortPerson method");
			List<Person> per = InsertionSort.insertionSortPerson(distinctpersonData);
			Collections.reverse(per);
			return per;
		} else {
			return InsertionSort.insertionSortPerson(distinctpersonData);
		}

	}

	public List<Person> removeDuplicates(List<Person> persons) {

		Set<Person> uniqPersonData = persons.stream().distinct().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

	public List<Person> insertionSort(List<Person> persons, Comparator<Person> comparator, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, comparator, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, Comparator<Person> comparator, boolean isDescendingOrder) {

		if (isDescendingOrder) {
			Person key_i;
			int n = distinct.size();
			
			for (int j = 1; j < n; j++) {
				key_i = distinct.get(j);
				int i = j - 1;
				while ((i > -1) && ((distinct.get(i).firstName.compareTo(key_i.firstName)) > 1)) {
					distinct.set(i + 1, distinct.get(i));
					i--;
				}
				distinct.set(i + 1, key_i);
			}
			return distinct;
		} else {
			Person key_i;
			int n = distinct.size();
			System.out.println(" insertionSort ");
			for (int j = 1; j < n; j++) {
				key_i = distinct.get(j);
				int i = j - 1;
				while ((i > -1) && (((key_i.firstName).compareTo(distinct.get(i).firstName)) < 1)) {
					distinct.set(i + 1, distinct.get(i));
					i--;
				}
				distinct.set(i + 1, key_i);
			}
		}
			return distinct;			
		
	}

	protected static List<Person> insertionSortPerson(List<Person> distinct) {
		Person key_i;
		int n = distinct.size();
		
		for (int j = 1; j < n; j++) {
			key_i = distinct.get(j);
			int i = j - 1;
			while ((i > -1) && ((distinct.get(i).compareTo(key_i)) > 1)) {
				distinct.set(i + 1, distinct.get(i));
				i--;
			}
			distinct.set(i + 1, key_i);
		}
		return distinct;
	}
}
