package com.genericsdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonMain {

	public static void main(String[] args) {

		Person john = new Person("John Doe",32);
		Person jane = new Person("Jane Doe",28);
		Person baby= new Person("Baby Doe",1);
		List<Person> doeFamily = new ArrayList<>();
		
		doeFamily.add(jane);
		doeFamily.add(john);
		doeFamily.add(baby);
		
		System.out.println(doeFamily);
		Collections.sort(doeFamily,new AgeComparator());
		System.out.println(doeFamily);
		Collections.sort(doeFamily,new ReverseComparator<Person>(new AgeComparator()));
		System.out.println(doeFamily);
	}

}

class AgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
	
}

class ReverseComparator<T> implements Comparator<T>{
	
	
	private final Comparator<T> delegateComparator;
	
	public ReverseComparator(final Comparator<T> delegateComparator){
		this.delegateComparator=delegateComparator;
	}

	@Override
	public int compare(final T o1, final T o2) {
		return -1 * delegateComparator.compare(o1, o2);
	}
	
}
