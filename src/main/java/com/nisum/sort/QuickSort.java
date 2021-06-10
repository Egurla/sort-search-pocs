package com.nisum.sort;

import java.io.ObjectInputStream.GetField;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nisum.bean.Person;

public class QuickSort {

	public List<Person> quickSort(List<Person> persons, boolean isDescendingOrder) {
		List<Person> distinct = removeDuplicates(persons);
		return sort(distinct, isDescendingOrder);
	}

	public List<Person> sort(List<Person> distinctpersonData, boolean isDescendingOrder) {

		if (isDescendingOrder) {
			System.out.println("reverse order");
			List<Person> per = QuickSort.quickSortPerson(distinctpersonData);
			Collections.reverse(per);
			return per;
			// Collections.sort(distinctpersonData, Collections.reverseOrder());
		} else {
			System.out.println("before quick sorting");
			// Collections.sort(distinctpersonData);
			return QuickSort.quickSortPerson(distinctpersonData);
		}
		// return distinctpersonData;
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

		if (isDescendingOrder) {
			int low;
			int high;
System.out.println("reverse order--------------------");
			// low=distinct.get(0);
			// high=distinct.get(distinct.size()-1);
			low = distinct.indexOf(distinct.get(0));
			high = distinct.size() - 1;
			Person person;
			System.out.println("=+++++++++++++++++++++++++++++++++++++++++++++++");
			if (low < high) {
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
				Person flag = distinct.get(high);
				int i = low - 1;
				
				for (int j = low; j <= distinct.size() - 1; j++) {

					if (distinct.get(j).firstName.compareTo(distinct.get(i + 1).firstName) < 1) {
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

		} else {

			int low;
			int high;
System.out.println("sorting order");
			// low=distinct.get(0);
			// high=distinct.get(distinct.size()-1);
			low = distinct.indexOf(distinct.get(0));
			high = distinct.lastIndexOf(distinct.size() - 1);
			Person person;
			if (low < high) {
				Person flag = distinct.get(high);
				int i = low - 1;
				System.out.println("----------------------------------------------------------hhhhhhhhhhhhh");
				for (int j = low; j <= distinct.size() - 1; j++) {

					if (distinct.get(j).firstName.compareTo(distinct.get(i + 1).firstName) > 1) {
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
		}
		return distinct;

	}

	protected static List<Person> quickSortPerson(List<Person> distinct) {
		int low;
		int high;
System.out.println("-----------------------------====================================================");
		// low=distinct.get(0);
		// high=distinct.get(distinct.size()-1);
		low = distinct.indexOf(distinct.get(0));
		high = distinct.lastIndexOf(distinct.size() - 1);
		Person person;
		if (low < high) {
			Person flag = distinct.get(high);
			int i = low - 1;
			System.out.println("====================");
			for (int j = low; j <= distinct.size() - 1; j++) {

				if (distinct.get(j).compareTo(distinct.get(i + 1)) > 1) {
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
