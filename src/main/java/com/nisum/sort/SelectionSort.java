package com.nisum.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.nisum.bean.Person;

public class SelectionSort {
	public List<Person> selectionSort(List<Person> persons, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinctpersonData, boolean isDescendingOrder) {

		

			List<Person> per = SelectionSort.selectionSortPerson(distinctpersonData,isDescendingOrder);
			
			return SelectionSort.selectionSortPerson(distinctpersonData,isDescendingOrder);
		
	}

	public List<Person> removeDuplicates(List<Person> persons) {

		Set<Person> uniqPersonData = persons.stream().distinct().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

	public List<Person> selectionSort(List<Person> persons, Comparator<Person> comparator, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, comparator, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, Comparator<Person> comparator, boolean isDescendingOrder) {

		Predicate<Integer> sortPred = (i) -> i < 0;

		if(isDescendingOrder) {
			sortPred = (i) -> i > 0;
		}
			Person person;
			int minIndex;
			boolean sorted = false;

			while (!sorted) {
				sorted = true;
				for (int i = 0; i < distinct.size() - 1; i++) {
					minIndex = i;
					
					
					if (sortPred.test(comparator.compare(distinct.get(i),distinct.get(i+1)))) {
						minIndex = i + 1;
						sorted = false;
					}

					person = distinct.get(i);
					distinct.set(i, distinct.get(minIndex));
					distinct.set(minIndex, person);
				}

			

		}
		return distinct;
	}

	protected static List<Person> selectionSortPerson(List<Person> distinct,boolean isDescendingOrder) {
		Person person;
		int minIndex;
		boolean sorted = false;
		Predicate<Integer> sortPred = (i) -> i < 0;
		
		if(isDescendingOrder) {
			sortPred = (i) -> i > 0;
		}
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < distinct.size() - 1; i++) {
				minIndex = i;
				if (sortPred.test(distinct.get(i).compareTo(distinct.get(i + 1)))) {
					minIndex = i + 1;
					sorted = false;
				}

				person = distinct.get(i);
				distinct.set(i, distinct.get(minIndex));
				distinct.set(minIndex, person);
			}

		}

		return distinct;
	}
}
