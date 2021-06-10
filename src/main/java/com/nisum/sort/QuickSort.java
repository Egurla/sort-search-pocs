package com.nisum.sort;

import java.io.ObjectInputStream.GetField;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.nisum.bean.Person;

public class QuickSort {

	public List<Person> quickSort(List<Person> persons, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, boolean isDescendingOrder) {
		Predicate<Integer> sortPred = (i) -> i < 0;
		Person person;
		if (isDescendingOrder) {
			sortPred = (i) -> i > 0;
		}
		int low;
		int high;
		low = distinct.indexOf(distinct.get(0));
		high = distinct.lastIndexOf(distinct.size() - 1);
		if (low < high) {
			Person flag = distinct.get(high);
			int i = low - 1;

			for (int j = low; j <= distinct.size() - 1; j++) {

				if (sortPred.test(distinct.get(j).compareTo(distinct.get(i + 1)))) {
					i++;
					Person temp = distinct.get(i);
					distinct.set(i, distinct.get(j));
					distinct.set(j, flag);

				}

			}
			Person temp = distinct.get(i + 1);
			distinct.set(i + 1, flag);
			distinct.set(high, temp);

		}

		return distinct;
	}

	public List<Person> removeDuplicates(List<Person> persons) {

		Set<Person> uniqPersonData = persons.stream().distinct().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

	public List<Person> quickSort(List<Person> persons, Comparator<Person> comparator, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, comparator, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, Comparator<Person> comparator, boolean isDescendingOrder) {

		Predicate<Integer> sortPred = (i) -> i < 0;
		Person person;
		if (isDescendingOrder) {
			sortPred = (i) -> i > 0;
		}

		int low;
		int high;

		low = distinct.indexOf(distinct.get(0));
		high = distinct.size() - 1;
		if (low < high) {
			Person flag = distinct.get(high);
			int i = low;

			for (int j = low; j <= distinct.size() - 1; j++) {
				if (sortPred.test(comparator.compare(distinct.get(j), distinct.get(i + 1)))) {
					i++;
					Person temp = distinct.get(i);
					distinct.set(i, distinct.get(j));
					distinct.set(j, flag);

				}

			}
			Person temp = distinct.get(i + 1);
			distinct.set(i + 1, flag);
			distinct.set(high, temp);

		}
		return distinct;

	}
}
