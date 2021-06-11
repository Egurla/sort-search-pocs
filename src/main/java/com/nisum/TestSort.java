package com.nisum;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.nisum.bean.Person;
import com.nisum.sort.BubbleSort;
import com.nisum.sort.InsertionSort;
import com.nisum.sort.MergeSort;
import com.nisum.sort.QuickSort;
import com.nisum.sort.SelectionSort;

public class TestSort {
	public static void main(String[] args) {

		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
			
		};
		boolean isDescendingOrder = true;
		List<Person> personlist = new ArrayList<Person>();

		personlist.add(new Person(101, 12343234, "kumar", "chette"));
		personlist.add(new Person(102, 12685869, "rakesh", "bandari"));
		personlist.add(new Person(101, 98778765, "shiva", "choedary"));
		personlist.add(new Person(105, 97669876, "buuny", "egurla"));
		personlist.add(new Person(104, 11222111, "rajesh", "ponnala"));
		personlist.add(new Person(106, 99866587, "saketh", "padigela"));
		personlist.add(new Person(101, 12343234, "kumar", "oraging"));

		// Bubble sorting

		BubbleSort bubnleSort = new BubbleSort();
		System.out.println("--------Bubble sorting-----------------");
		List<Person> listOfpersons = bubnleSort.bubbleSort(personlist, isDescendingOrder);

		for (Person p : listOfpersons) {
			System.out.println(p.id + " " + p.firstName + " " + p.adharNumber);
		}

		List<Person> listofPersonUsingComparator = bubnleSort.bubbleSort(personlist, comparator, isDescendingOrder);
System.out.println("------------------------------------------------------------------------------------");
		for (Person p : listofPersonUsingComparator) {
			System.out.println(p.firstName + " " + p.lastName + " " + p.adharNumber + " " + p.id);
		}

		// Selection sorting

		SelectionSort selectionsorting = new SelectionSort();
		System.out.println("------------------------Selection sorting-----------------");
		List<Person> selectionSortlist = selectionsorting.selectionSort(personlist, isDescendingOrder);
		for (Person p : selectionSortlist) {
			System.out.println(p.id + " " + p.firstName + " " + p.adharNumber);
		}

		List<Person> selectionsortUsingComparator = selectionsorting.selectionSort(personlist, comparator,
				isDescendingOrder);
		System.out.println(" using comparator to sorting the elements");

		for (Person p : selectionsortUsingComparator) {
			System.out.println(p.firstName + " " + p.lastName + " " + p.adharNumber + " " + p.id);
		}
		

		// insertion Sorting
		InsertionSort insertionsort = new InsertionSort();
		System.out.println("------------------------INSERTION SORTING-----------------");
		List<Person> insertionsortlist = insertionsort.insertionSort(personlist, isDescendingOrder);
		for (Person p : insertionsortlist) {
			System.out.println(p.id + " " + p.firstName + " " + p.adharNumber);
		}
		List<Person> insertionUsingComparator = insertionsort.insertionSort(personlist, comparator, isDescendingOrder);
		System.out.println(" using comparator to sorting the elements");

		for (Person p : insertionUsingComparator) {
			System.out.println(p.firstName + " " + p.lastName + " " + p.adharNumber + " " + p.id);
		}

	
		// quickSort
		QuickSort quicksort = new QuickSort();
		System.out.println("------------------------QUICK SORTING-----------------");
		List<Person> quicksortlist = quicksort.quickSort(personlist, isDescendingOrder);
		for (Person p : quicksortlist) {
			System.out.println(p.id + " " + p.firstName + " " + p.adharNumber);
		}
		System.out.println("----------------------------------------------------------------------------------");
		List<Person> quicks = quicksort.quickSort(personlist, comparator, isDescendingOrder);

		for (Person p : quicks) {
			System.out.println(p.firstName + " " + p.lastName + " " + p.adharNumber + " " + p.id);
		}
		
		System.out.println("------------------------MERGE SORTING-----------------");
		
		MergeSort mergeSortt=new MergeSort();
		
		mergeSortt.mergeSort(personlist, isDescendingOrder);
		List<Person> mergesortlist = mergeSortt.mergeSort(personlist, isDescendingOrder);
		for (Person p : mergesortlist) {
			System.out.println(p.id + " " + p.firstName + " " + p.adharNumber);
		}

		System.out.println("--------------------------------------");
		List<Person> mergesortlistComp = mergeSortt.mergeSort(personlist, comparator, isDescendingOrder);
		for (Person p : mergesortlistComp) {
			System.out.println(p.id + " " + p.firstName + " " + p.adharNumber);
		}
	}
	}


