package com.nisum.search;

import java.awt.Dialog;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nisum.bean.Person;
import com.nisum.bean.PersonComp;

public class LinearSearch {

	public int linearSearch(List<Person> persons,List<Person> item) {
		System.out.println("using insertionsort");
		List<Person> distinct = removeDuplicates(persons);
		return search(distinct,item);
	}

	private int search(List<Person> distinct,List<Person> item) {
		Collections.sort(distinct);
		//Person p = new Person(106, 99866587, "saketh", "padigela");
		int num=distinct.size();
		int counter;
		for (counter = 0; counter < num; counter++)
	      {
	         if (distinct.get(counter) == item) 
	         {
	           System.out.println(item+" is present at location "+(counter+1));
	           break;
	         }
	      }
	      if (counter == num) {
	        System.out.println(item + " doesn't exist in list.");
	      }
		return item.indexOf(item);
	
	}
	

	private List<Person> removeDuplicates(List<Person> persons) {
		Set<Person> uniqPersonData = persons.stream().distinct().collect(Collectors.toSet());
		return uniqPersonData.stream().collect(Collectors.toList());

	}

}
