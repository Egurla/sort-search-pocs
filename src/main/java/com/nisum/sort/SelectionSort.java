package com.nisum.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nisum.bean.Person;

public class SelectionSort {
	public List<Person> selectionSort(List<Person> persons, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinctpersonData, boolean isDescendingOrder) {

		if (!isDescendingOrder) {
			System.out.println("reverse order");
			List<Person> per = SelectionSort.selectionSortPerson(distinctpersonData);
			Collections.reverse(per);
			return per;
			// Collections.sort(distinctpersonData, Collections.reverseOrder());
		} else {
			System.out.println("before selection sorting");
			// Collections.sort(distinctpersonData);
			return SelectionSort.selectionSortPerson(distinctpersonData);
		}
		// return distinctpersonData;
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

		if (isDescendingOrder) {
			Person person;
			int minIndex;
			boolean sorted = false;
			System.out.println(" INSERTION ORDER selectionSortArrayList ");
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < distinct.size() - 1; i++) {
					minIndex = i;
					if (distinct.get(i).firstName.compareTo(distinct.get(i + 1).firstName) > 0) {
						minIndex = i + 1;
						sorted = false;
					}

					person = distinct.get(i);
					distinct.set(i, distinct.get(minIndex));
					distinct.set(minIndex, person);
				}

			}

		} else {
 System.out.println("sorted order");
			Person person;
			int minIndex;
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < distinct.size() - 1; i++) {
					minIndex = i;
					if (distinct.get(i+1).firstName.compareTo(distinct.get(i).firstName) > 0) {
						minIndex = i + 1;
						sorted = false;
					}

					person = distinct.get(i);
					distinct.set(i, distinct.get(minIndex));
					distinct.set(minIndex, person);
				}

			}
			// distinct.sort((o1, o2) -> o2.firstName.compareTo(o1.firstName));
		}
		return distinct;
	}

	protected static List<Person> selectionSortPerson(List<Person> distinct) {
		Person person;
		int minIndex;
		boolean sorted = false;

		while (!sorted) {
			sorted = true;
			for (int i = 0; i < distinct.size() - 1; i++) {
				minIndex = i;
				if (distinct.get(i).compareTo(distinct.get(i + 1)) > 0) {
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
