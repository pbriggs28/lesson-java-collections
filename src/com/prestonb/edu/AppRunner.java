package com.prestonb.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AppRunner {
	private static final int ARRAY_SIZE = 100;
	private int searchValue = (int) Math.round(Math.random() * 100);
	private int[] intArray = new int[ARRAY_SIZE];
	private List<Integer> intArrayList = new ArrayList<>();

	// Main methods
	// ====================================================================================================
	
	public static void main(String[] args) {
		new AppRunner().run();
	}
	
	public AppRunner() {
		for(int i = 0; i < ARRAY_SIZE; i++) {
			int num = (int) Math.round(Math.random() * 100);
			intArray[i] = num;
			intArrayList.add(num);
		}
	}
	
	public void run() {
		searchArray();
		searchArrayList();
		
		System.out.println("Before sorting array...");
		printArray();
		sortArray();
		System.out.println("After sorting array...");
		printArray();
		
		System.out.println("Before sorting arrayList...");
		printArrayList();
		sortArrayListOption1();
		System.out.println("After sorting arrayList...");
		printArrayList();

		System.out.println("Before sorting arrayList by evens...");
		printArrayList();
		customArrayListSort();
		System.out.println("After sorting arrayList by evens...");
		printArrayList();
	}
	
	// Searching methods
	// ====================================================================================================
	
	private void searchArray() {
		for(int i = 0; i < intArray.length; i++) {
			if(intArray[i] == searchValue) {
				System.out.println("Found value [" + searchValue + "]!");
			}
		}
	}

	private void searchArrayList() {
		if(intArrayList.contains(searchValue)) {
			System.out.println("Found value [" + searchValue + "]!");
		}
	}

	// Sorting methods
	// ====================================================================================================
	
	private void sortArray() {
		int i;
		int j;
		for (i = 0; i < intArray.length - 1; i++) {
			int minValIndex = i;
			for (j = i+1; j < intArray.length; j++) {
				if(intArray[j] < intArray[minValIndex]) {
					minValIndex = j;
				}
			}
			
			if(minValIndex != i) {
				int tmp = intArray[i];
				intArray[i] = intArray[minValIndex];
				intArray[minValIndex] = tmp;
			}
 		}
	}
	
	private void sortArrayListOption1() {
		intArrayList.sort(null);
	}
	
	private void sortArrayListOption2() {
		Collections.sort(intArrayList);
	}
	
	private void customArrayListSort() {
		intArrayList.sort(new EvensFirstSorter());
	}
	
	private static class EvensFirstSorter implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			boolean o1Even = isEven(o1);
			boolean o2Even = isEven(o2);
			
			if(o1Even && o2Even)
				return 0;
			
			if(!o1Even && !o2Even)
				return 0;
			
			if(o1Even && !o2Even)
				return -1;
			
			if(!o1Even && o2Even)
				return 1;
			
			throw new IllegalStateException("I suck at coding");
		}
		
		private boolean isEven(int n) {
			return n % 2 == 0;
		}
	}


	// Helper methods
	// ====================================================================================================

	private void printArray() {
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("\t" + intArray[i]);
		}
	}
	private void printArrayList() {
		for (int intVal : intArrayList) {
			System.out.println("\t" + intVal);
		}
	}
	
}
