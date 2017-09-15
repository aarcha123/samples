package com.genericsdemo;

public class CircularBufferMain {

	public static void main(String[] args) {
		GenericCircularBuffer<String> buffer = new GenericCircularBuffer<String>(10);
		buffer.offer("a");	
		buffer.offer("b");	
		buffer.offer("c");	

		String result = concatenate(buffer);
		System.out.println(result);
	}
	
	private static String concatenate(GenericCircularBuffer<String> buffer){
		StringBuilder result = new StringBuilder();
		String value;
		while((value=buffer.poll())!=null){
			result.append(value);		
		}
		return result.toString();
	}

}
