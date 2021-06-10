package com.nisum.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nisum.bean.Person;

public class BubbleSort{

	public List<Person> bubbleSort(List<Person> persons, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinctpersonData, boolean isDescendingOrder) {

		if (!isDescendingOrder) {
			System.out.println("reverse order");
			List<Person> per = BubbleSort.bubbleSortingPerson(distinctpersonData);
			Collections.reverse(per);
			return per;
			// Collections.sort(distinctpersonData, Collections.reverseOrder());
		} else {
			// Collections.sort(distinctpersonData);
			return BubbleSort.bubbleSortingPerson(distinctpersonData);
		}
		
	}

	public List<Person> removeDuplicates(List<Person> persons) {

		Set<Person> uniqPersonData = persons.stream().distinct().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

	public List<Person> bubbleSort(List<Person> persons, Comparator<Person> comparator, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, comparator, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, Comparator<Person> comparator, boolean isDescendingOrder) {

		if (!isDescendingOrder) {
			Person person;
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < distinct.size() - 1; i++)
					if ((distinct.get(i).firstName).compareTo(distinct.get(i + 1).firstName) > 0) {
						person = distinct.get(i);
						distinct.set(i, distinct.get(i + 1));
						distinct.set(i + 1, person);
						sorted = false;
					}
			}
		} else {
			Person person;
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < distinct.size() - 1; i++)
					if ((distinct.get(i + 1).firstName).compareTo(distinct.get(i).firstName) > 0) {
						person = distinct.get(i);
						distinct.set(i, distinct.get(i + 1));
						distinct.set(i + 1, person);
						sorted = false;
					}
			}

		}
		return distinct;

	}

	protected static List<Person> bubbleSortingPerson(List<Person> distinct) {
		Person person;
		boolean sorted = false;
		System.out.println("bubble sorung bubbleSortArrayList ");
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < distinct.size() - 1; i++)
				if ((distinct.get(i)).compareTo(distinct.get(i + 1)) > 0) {
					person = distinct.get(i);
					distinct.set(i, distinct.get(i + 1));
					distinct.set(i + 1, person);
					sorted = false;
				}
			// System.out.println(distinct);
		}
		System.out.println(distinct);
		System.out.println("=============");
		return distinct;

	}
}
