package org.supersymmetry.order.zero.validate;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validate2 {

	
	static List<Number> a1 = new ArrayList<Number>();
	static List<Number> b1 = new ArrayList<Number>();
	
	public static void main(String[] args) {
		
		a1 = Arrays.asList(3,1,1,1);
		b1 = Arrays.asList(0,2,2,2);
		
		Map a11 = new HashMap();
		a11.put(1,1);
		
		Double sum = 0.0;
		
		for(int i=0;i<a1.size();i++) {
			Double a = (Double)a1.get(i).doubleValue();
			for(int j=0;j<a1.size();j++) {
				
		       if(i==j){
		       continue;
		       }
				Double b = (Double) a1.get(j).doubleValue();
				
				for(int k=0;k<a1.size();k++) {
					
					if(j==k){
					continue;
				    }
					Double c = (Double) a1.get(k).doubleValue();
				
				sum = sum+Math.pow((a+b+c),2);
			}
		 }
		}
		System.out.println("A is:"+sum);
		
		
		 sum = 0.0;
		for(int i=0;i<b1.size();i++) {
			Double a = (Double)b1.get(i).doubleValue();
			for(int j=0;j<b1.size();j++) {
				Double b = (Double)b1.get(j).doubleValue();
				for(int k=0;k<a1.size();k++) {
					Double c = (Double) a1.get(k).doubleValue();
				        sum = sum+Math.pow((a+b+c),2);
			}
		  }
		}
		System.out.println("B is:"+sum);
		
		try {
		
		Field field = Thread.class.getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object map = field.get(Thread.currentThread());
        Field table = Class.forName("java.lang.ThreadLocal$ThreadLocalMap").getDeclaredField("table");
        table.setAccessible(true);
        Object tbl = table.get(map);
        int length = Array.getLength(tbl);
        for(int i = 0; i < length; i++) {                   
            Object entry = Array.get(tbl, i);
            Object value = null;
            String valueClass = null;
            if(entry != null) { 
            	
            	 Field nameField = Class.forName("java.lang.ThreadLocal$ThreadLocalMap$Entry").getDeclaredField("entry");
                Field valueField = Class.forName("java.lang.ThreadLocal$ThreadLocalMap$Entry").getDeclaredField("value");
               
                if(nameField!=null) {
                nameField.setAccessible(true);
                Object name  =  nameField.get(entry);
                System.out.println("[" + i + "] type[" + valueClass + "] " + name);
                }
                
                
                if(valueField!=null) {
                valueField.setAccessible(true);
               
                value = valueField.get(entry);
                if(value != null && value.getClass()!=null) {
                    valueClass = value.getClass().getName();
                }
                if(valueClass!=null && valueClass.contains("Boolean")) {
                System.out.println("[" + i + "] type[" + valueClass + "] " + value);
                }
               }
            }
        }


	}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
	
	
	}
	
	
}
	
	

