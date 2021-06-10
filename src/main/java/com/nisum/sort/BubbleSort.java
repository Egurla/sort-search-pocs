package com.nisum.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.nisum.bean.Person;

public class BubbleSort {

	public List<Person> bubbleSort(List<Person> persons, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, boolean isDescendingOrder) {

		Predicate<Integer> sortPred = (i) -> i < 0;
		Person person;
		if (isDescendingOrder) {
			sortPred = (i) -> i > 0;
		}
		
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < distinct.size() - 1; i++)
					if (sortPred.test((distinct.get(i)).compareTo(distinct.get(i + 1)))) {
						person = distinct.get(i);
						distinct.set(i, distinct.get(i + 1));
						distinct.set(i + 1, person);
						sorted = false;
					

			}
		}
		return distinct;
	}

	public List<Person> removeDuplicates(List<Person> persons) {

		Set<Person> uniqPersonData = persons.stream().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

	public List<Person> bubbleSort(List<Person> persons, Comparator<Person> comparator, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, comparator, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, Comparator<Person> comparator, boolean isDescendingOrder) {

		Predicate<Integer> sortPred = (i) -> i < 0;

		if (isDescendingOrder) {
			sortPred = (i) -> i > 0;
		}
		Person person;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < distinct.size() - 1; i++) {
				if (sortPred.test(comparator.compare(distinct.get(i), distinct.get(i + 1)))) {
					person = distinct.get(i);
					distinct.set(i, distinct.get(i + 1));
					distinct.set(i + 1, person);
					sorted = false;
				}
			}
		}

		return distinct;

	}
}
