package com.nisum;

import java.util.ArrayList;
import java.util.List;

import com.nisum.bean.Person;
import com.nisum.search.BinarySearch;
import com.nisum.search.LinearSearch;

public class TestSearch {
	public static void main(String[] args) {
		
		List<Person> personlist = new ArrayList<Person>();

		personlist.add(new Person(101, 12343234, "kumar", "chette"));
		personlist.add(new Person(102, 12685869, "rakesh", "bandari"));
		personlist.add(new Person(101, 98778765, "shiva", "choedary"));
		personlist.add(new Person(105, 97669876, "buuny", "egurla"));
		personlist.add(new Person(104, 11222111, "rajesh", "ponnala"));
		personlist.add(new Person(106, 99866587, "saketh", "padigela"));
		personlist.add(new Person(101, 12343234, "kumar", "oraging"));

		// BinarySearch
		BinarySearch binarySearch = new BinarySearch();
		int index = binarySearch.binarySearch(personlist);
		System.out.println("Index of serached key " + index);
		System.out.println(personlist.get(index).getId() + " " + personlist.get(index).getFirstName() + " "
				+ personlist.get(index).getLastName() + " " + personlist.get(index).getAdharNumber());

		// linearSearch
		LinearSearch linearSearch = new LinearSearch();

		List<Person> item = new ArrayList<Person>();
		item.add(new Person(101, 12343234, "kumar", "oraging"));
		int linersS = linearSearch.linearSearch(personlist, item);
		System.err.println(personlist.get(linersS).getId() + " " + personlist.get(linersS).getFirstName() + " "
				+ personlist.get(linersS).getLastName() + " " + personlist.get(linersS).getAdharNumber());

	}
}
