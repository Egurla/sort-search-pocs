package com.nisum.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.omg.CORBA.OMGVMCID;

public class InsertionSort {
	public List<Person> insertionSort(List<Person> persons, boolean isDescendingOrder) {
		System.out.println("using insertionsort");
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinctpersonData, boolean isDescendingOrder) {

		if (!isDescendingOrder) {
			System.out.println("reverse order");
			List<Person> per = InsertionSort.insertionSortPerson(distinctpersonData);
			Collections.reverse(per);
			return per;
		} else {
			System.out.println("before insertion sorting");
			
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
			Collections.sort(distinct, new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					return o1.firstName.compareTo(o1.firstName);

				}

			});

		} else {

			distinct.sort((o1, o2) -> o2.firstName.compareTo(o1.firstName));
		}
		return distinct;
	}

	protected static List<Person> insertionSortPerson(List<Person> distinct) {
		Person key_i;
		int n = distinct.size();
		System.out.println(" insertionSort ");
		for (int j = 1; j < n; j++) {
			key_i = distinct.get(j);
			int i = j - 1;
			while ((i > -1) && ((distinct.get(i).compareTo(key_i)) == 1)) {
	            distinct.set(i+1, distinct.get(i));
	            i--;
	        }
			distinct.set(i+1, key_i);
		}
		return distinct;
	}
}
