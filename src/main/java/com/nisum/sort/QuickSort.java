package com.nisum.sort;

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
		int low = distinct.indexOf(distinct.get(0));
		int high = distinct.size() - 1;
		QuickSort.quicksort(distinct, low, high, isDescendingOrder);
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

		int low = distinct.indexOf(distinct.get(0));
		int high = distinct.size() - 1;
		QuickSort.quicksortComp(distinct, low, comparator, high, isDescendingOrder);
		return distinct;
	}

	private static void quicksortComp(List<Person> distinct, int low, Comparator<Person> comparator, int high,
			boolean isDescendingOrder) {
		if (low < high) {
			int pi = partition(distinct, comparator, low, high, isDescendingOrder);
			quicksortComp(distinct, low, comparator, pi - 1, isDescendingOrder);
			quicksortComp(distinct, pi + 1, comparator, high, isDescendingOrder);
		}
	}

	private static int partition(List<Person> distinct, Comparator<Person> comparator, int low, int high,
			boolean isDescendingOrder) {
		Predicate<Integer> sortPred = (i) -> i > 0;

		if (isDescendingOrder) {
			sortPred = (i) -> i < 0;
		}
		int pivot = distinct.indexOf(distinct.get(high));
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {
			if (sortPred.test(comparator.compare(distinct.get(j), distinct.get(pivot)))) {
				i++;
				swap(distinct, i, j);
			}
		}
		swapCom(distinct, i + 1, high);
		return (i + 1);
	}

	private static void swapCom(List<Person> distinct, int i, int j) {
		Person temp = distinct.get(i);
		distinct.set(i, distinct.get(j));
		distinct.set(j, temp);

	}

	static void swap(List<Person> distinct, int i, int j) {
		Person temp = distinct.get(i);
		distinct.set(i, distinct.get(j));
		distinct.set(j, temp);
	}

	static int partition(List<Person> distinct, int low, int high, boolean isDescendingOrder) {
		Predicate<Integer> sortPred = (i) -> i < 0;

		if (isDescendingOrder) {
			sortPred = (i) -> i > 0;
		}
		int pivot = distinct.indexOf(distinct.get(high));
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {
			if (sortPred.test((distinct.get(j)).compareTo(distinct.get(pivot))))
				;
			{
				i++;
				swap(distinct, i, j);
			}
		}
		swap(distinct, i + 1, high);
		return (i + 1);
	}

	static void quicksort(List<Person> distinct, int low, int high, boolean isDescendingOrder) {
		if (low < high) {
			int pi = partition(distinct, low, high, isDescendingOrder);
			quicksort(distinct, low, pi - 1, isDescendingOrder);
			quicksort(distinct, pi + 1, high, isDescendingOrder);
		}
	}
}
