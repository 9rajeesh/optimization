package org.qc.general.combinatorics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TermHandler {

	private static Integer x1 = 11;
	private static Integer y1 = 29;
	private static Integer count = 8;
	private static List<Term> xterms = new ArrayList<Term>();
	private static List<Term> yterms = new ArrayList<Term>();
	private static List<Term> aterms = new ArrayList<Term>();
	private static List<Term> bterms = new ArrayList<Term>();
	private static List<Term> Pterms = new ArrayList<Term>();
	 static List<Term> XYAB = new ArrayList<Term>();
	 static List<Term> PAB = new ArrayList<Term>();
	 static Map<Integer,List<Term>> XYABMap = new HashMap<Integer,List<Term>>();
	 static Map<Integer,List<Term>> PABMap = new HashMap<Integer,List<Term>>();
	
	public static void main(String[] args) {
		
		xterms = createTerms("x");
		yterms = createTerms("y");
		aterms = createTerms("a");
		bterms = createTerms("b");
		createP();
		createXYAB();
		createPAB();
		multiply_XYAB_PAB();
				
		TermValues.initialize();
		
		TermValues.setXY(1,1);
		TermValues.setAB(89,89);
		   
		XYABMap.get(2).forEach(term->System.out.println(term));
		
		Double value_xy =   TermUtils.evaluateCombinedSum_XYAB(15);
		Double value_pab =  TermUtils.evaluateCombinedSum_PAB(15);
		
		System.out.println("Sum1 is:"+value_xy);
		System.out.println("Sum2 is:"+value_pab);
		
		/*
		for(int i=1;i<45;i++) {
			for(int j=1;j<45;j++) {
		      TermValues.setXY(i,j);
		      double sum = loop(6);
			System.out.println("Sum at i:"+i + " j:"+j+"is:"+sum);
		  }
		}
		*/
		
	}
	
 public static void main1(String[] args) {
		
		xterms = createTerms("x");
		yterms = createTerms("y");
		aterms = createTerms("a");
		bterms = createTerms("b");
		createP();
		createXYAB();
		createPAB();
		multiply_XYAB_PAB();
		
		TermValues.initialize();
		TermValues.setXY(15,25);
		
		double sum355=0;
          for(int i=1;i<50;i++) {
			
			for(int j=1;j<50;j++) {
		
		TermValues.setAB(i,j);
		
		
		//double sum = loop(6);
		int index = 5;
		double sum = TermUtils.evaluateCombinedSum_XYAB(index);
		double sum5=Math.sin(2*Math.PI*sum/Math.pow(2,index+3));
		//sum=sum/Math.pow(2,5);
		System.out.print("At i:"+i + " j:"+j);
		System.out.print(" Sum is:"+sum + " Value:"+sum5);
		  
		double sum1 = TermUtils.evaluateCombinedSum_PAB(index);
		//sum1=Math.sin(2*Math.PI*sum1/Math.pow(2,5+1));
		//sum1=sum1/Math.pow(2,5);
		double sum3=Math.sin(2*Math.PI*sum1/Math.pow(2,index+3));
		//sum=sum/Math.pow(2,5);
		System.out.print(" Sum is:"+sum1 + " Value:"+sum3);
		System.out.println();
		sum355 = sum3*sum5;
		
			}
      }
          System.out.println("Final Sum is:"+sum355);    
          
          
	}
	
	public static Double loop(Integer index) {
		double sum = 0.0;
		
		for(int i=0;i<256;i++) {
			
			for(int j=0;j<256;j++) {
		
		TermValues.setAB(i,j);
		Double value_xy =   TermUtils.evaluateCombinedSum_XYAB(index);
		Double value_pab =  TermUtils.evaluateCombinedSum_PAB(index);
		
		sum = sum + (Math.sin(2*Math.PI*(value_xy/Math.pow(2,index+1)))*Math.sin(2*Math.PI*(value_pab/Math.pow(2,index+1))));
		
		//PABMap.get(3).stream().forEach(term->System.out.println(term));
		//int size = XYABMap.get(14).size();
		//System.out.println("Sum is:"+ value_xy);
		//System.out.println("Sum is:" + value_pab);
		
		//System.out.println("Sum1 is:"+  Math.sin(2*Math.PI*(value_xy/512)));
		//System.out.println("Sum1 is:" + Math.sin(2*Math.PI*(value_pab/512)));
			}
		}
		
		return sum;
	}
	
	
	private static double normalize(double d) {
	
		if(d<0) {
		return -0.99;
		}
		
		return 0.99;
	}

	public static  Double evaluate(List<Term> termList) {
		Double sum = 0.0;
		sum = termList.stream().collect(Collectors.summingDouble((Term::evaluate)));
		return sum;
		
	}
	private static void multiply_XYAB_PAB() {
	
	}

	private static void createP() {
		String s = padZeroes(Integer.toBinaryString(x1*y1),count*2);
		for(int i=(count*2)-1,j=0;i>=0;i--,j++) {
			Long factor = Long.parseLong(String.valueOf(s.charAt(j)));
			Term term = new Term(factor,i);
			Pterms.add(term);
		}
		
	}

	public static void createXYAB() {
		List<Term> xy = multiplyList(xterms,yterms);
		List<Term> ab = multiplyList(aterms,bterms);
		XYAB  = multiplyList(xy,ab);
		XYABMap = XYAB.stream().collect(Collectors.groupingBy(Term::getPower2));
	}
	
   

	public static void createPAB() {
    	List<Term> ab = multiplyList(aterms,bterms);
    	PAB  = multiplyList(Pterms,ab);
    	PABMap = PAB.stream().collect(Collectors.groupingBy(Term::getPower2));
    	
	}
    public static List<Term> createTerms(String parameter) {
    	List<Term> termList = new ArrayList<Term>();
    	for(int i=0;i<count;i++) {
    	termList.add(new Term(1L,i,parameter+i));
    	}
    	return termList;
    }
    public static List<Term> multiplyList(List<Term> termList1,List<Term> termList2){
    	
    	List<Term> termList = new ArrayList<Term>();
    	termList1.stream().forEach(term1->{
    		termList2.stream().forEach(term2->{
    			termList.add(term1.multiply(term1, term2));	
    			
    		});
    	});
    	
    	return termList;
    }

	public static Integer getCount() {
		return count;
	}

	public static void setCount(Integer count) {
		TermHandler.count = count;
	}
	
	
private static String padZeroes(String binaryString, Integer count) {
		
		String s = binaryString;
		while(binaryString.length()<count) {
			binaryString = "0"+binaryString;
		}
		
		return binaryString;
	}
	
	
	
	
}
