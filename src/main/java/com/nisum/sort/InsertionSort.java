package com.nisum.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.omg.CORBA.OMGVMCID;

import com.nisum.bean.Person;

public class InsertionSort {
	public List<Person> insertionSort(List<Person> persons, boolean isDescendingOrder) {

		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, boolean isDescendingOrder) {

		Predicate<Integer> sortPred = (i) -> i < 1;
		Person person;
		if (isDescendingOrder) {
			sortPred = (i) -> i > 1;
		}
		Person key_i;
		int n = distinct.size();

		for (int j = 1; j < n; j++) {
			key_i = distinct.get(j);
			int i = j - 1;
			while ((i > -1) && (sortPred.test((distinct.get(i).compareTo(key_i))))) {
				distinct.set(i + 1, distinct.get(i));
				i--;
			}
			distinct.set(i + 1, key_i);
		}
		return distinct;
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

		Predicate<Integer> sortPred = (i) -> i < 1;
		Person person;
		if (isDescendingOrder) {
			sortPred = (i) -> i > 1;
		}
		Person key_i;
		int n = distinct.size();

		for (int j = 1; j < n; j++) {
			key_i = distinct.get(j);
			int i = j - 1;
			while ((i > -1) && (sortPred.test((comparator.compare(distinct.get(i), (key_i)))))) {
				distinct.set(i + 1, distinct.get(i));
				i--;
			}
			distinct.set(i + 1, key_i);
		}
		return distinct;

	}

}
