package com.nisum;

import java.util.ArrayList;
import java.util.List;

import com.nisum.bean.Person;
import com.nisum.search.BinarySearch;

public class TestSearch {
	public static void main(String[] args) {
		boolean isDescendingOrder = true;
		List<Person> personlist = new ArrayList<Person>();

		personlist.add(new Person(101, 12343234, "kumar", "chette"));
		personlist.add(new Person(102, 12685869, "rakesh", "bandari"));
		personlist.add(new Person(101, 98778765, "shiva", "choedary"));
		personlist.add(new Person(105, 97669876, "buuny", "egurla"));
		personlist.add(new Person(104, 11222111, "rajesh", "ponnala"));
		personlist.add(new Person(106, 99866587, "saketh", "padigela"));
		personlist.add(new Person(101, 12343234, "kumar", "oraging"));

		BinarySearch binarySearch = new BinarySearch();
		int index = binarySearch.binarySearch(personlist);
		System.out.println("Index of serached key " + index);
		System.out.println(personlist.get(index).id + " " + personlist.get(index).firstName + " "
				+ personlist.get(index).lastName + " " + personlist.get(index).adharNumber);
	}
}
