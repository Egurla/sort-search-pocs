package com.nisum.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.nisum.bean.Person;

public class MergeSort {

	public List<Person> mergeSort(List<Person> persons, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, boolean isDescendingOrder) {
		int from = distinct.indexOf(distinct.get(0));
		int to = distinct.size() - 1;
		merge(distinct, isDescendingOrder, from, to);
		return distinct;
	}

	private void merge(List<Person> distinct, boolean isDescendingOrder, int from, int to) {
		int mid = (from + to) / 2;
		if (from < to) {

			merge(distinct, isDescendingOrder, from, mid);
			merge(distinct, isDescendingOrder, mid + 1, to);
		}
		mergeS(distinct, from, mid, to, isDescendingOrder);

	}

	private void mergeS(List<Person> distinct, int from, int mid, int to, boolean isDescendingOrder) {

		int n = to - from + 1;
		Object[] values = new Object[n];

		int fromValue = from;

		int middleValue = mid + 1;

		int index = 0;

		while (fromValue <= mid && middleValue <= to) {
			Predicate<Integer> sortPred = (i) -> i < 0;

			if (isDescendingOrder) {
				sortPred = (i) -> i > 0;
			}
			if (sortPred.test((distinct.get(fromValue)).compareTo(distinct.get(middleValue)))) {
				values[index] = distinct.get(fromValue);
				fromValue++;
			} else {
				values[index] = distinct.get(middleValue);
				middleValue++;
			}
			index++;
		}

		while (fromValue <= mid) {
			values[index] = distinct.get(fromValue);
			fromValue++;
			index++;
		}
		while (middleValue <= to) {
			values[index] = distinct.get(middleValue);
			middleValue++;
			index++;
		}

		for (index = 0; index < n; index++)
			distinct.set((from + index), (Person) values[index]);
	}

	public List<Person> removeDuplicates(List<Person> persons) {

		Set<Person> uniqPersonData = persons.stream().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

	public List<Person> mergeSort(List<Person> persons, Comparator<Person> comparator, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, comparator, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinct, Comparator<Person> comparator, boolean isDescendingOrder) {
		int from = distinct.indexOf(distinct.get(0));
		int to = distinct.size() - 1;
		merge(distinct, comparator, isDescendingOrder, from, to);

		return distinct;

	}

	private void merge(List<Person> distinct, Comparator<Person> comparator, boolean isDescendingOrder, int from,
			int to) {

		int mid = (from + to) / 2;
		if (from < to) {
			merge(distinct, comparator, isDescendingOrder, from, mid);
			merge(distinct, comparator, isDescendingOrder, mid + 1, to);
		}
		mergeS(distinct, from, mid, comparator, to, isDescendingOrder);

	}

	private void mergeS(List<Person> distinct, int from, int mid, Comparator<Person> comparator, int to,
			boolean isDescendingOrder) {
		int n = to - from + 1;
		Object[] values = new Object[n];

		int fromValue = from;

		int middleValue = mid + 1;

		int index = 0;

		while (fromValue <= mid && middleValue <= to) {
			Predicate<Integer> sortPred = (i) -> i < 0;

			if (isDescendingOrder) {
				sortPred = (i) -> i > 0;
			}
			if (sortPred.test(comparator.compare(distinct.get(fromValue), distinct.get(middleValue)))) {
				values[index] = distinct.get(fromValue);
				fromValue++;
			} else {
				values[index] = distinct.get(middleValue);
				middleValue++;
			}
			index++;
		}

		while (fromValue <= mid) {
			values[index] = distinct.get(fromValue);
			fromValue++;
			index++;
		}
		while (middleValue <= to) {
			values[index] = distinct.get(middleValue);
			middleValue++;
			index++;
		}

		for (index = 0; index < n; index++)
			distinct.set((from + index), (Person) values[index]);

	}
}
