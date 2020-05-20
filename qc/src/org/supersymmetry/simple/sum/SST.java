package org.supersymmetry.simple.sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SST {

	private boolean isConstant = false;
	private BigDecimal factor;
	private Integer unique;
	private Integer n;
	private List<String> combs = new ArrayList<String>();
	private Integer setbits = 0;
	
	
	public Integer getUnique() {
		return unique;
	}
	public void setUnique(Integer unique) {
		this.unique = unique;
	}
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	
	public BigDecimal getFactor() {
		return factor;
	}
	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}
	public List<String> getCombs() {
		return combs;
	}
	public void setCombs(List<String> combs) {
		this.combs = combs;
	}
	
	
	public SST(BigDecimal factor,Integer unique, Integer n) {
		super();
		this.factor=factor;
		this.unique = unique;
		this.n = n;
		
		if(n==0){
		this.isConstant=true;
		}
	}
	public SST(BigDecimal factor,Integer unique, Integer n,Integer setbits) {
		super();
		this.factor=factor;
		this.unique = unique;
		this.n = n;
		this.setbits=setbits;
		
		if(n==0){
		this.isConstant=true;
		}
	}
	
	public SST(BigDecimal factor) {
		super();
		this.factor=factor;
		this.isConstant=true;
	}
	
    public SST(double d, int unique2, int n2) {
	
    	super();
		this.factor=new BigDecimal(d);
		this.unique = unique2;
		this.n = n2;
		 	
	}
    
	public SST(double d, Integer count_unset, int n, Integer count_set) {
		super();
		this.factor=new BigDecimal(d);
		this.unique = count_unset;
		this.n = n;
		this.setbits=count_set;
	}
	
	public static List<SST> multiplyWithUnitSST(SST sst,SST sstUnit) {
		
		List<SST> sstList = new ArrayList<SST>();
		BigDecimal factor = sst.getFactor() .multiply(sstUnit.getFactor());
		
		//if any of sst is of simple type (constant) just multipy the factor and return
		if(sst.isConstant && sstUnit.isConstant){
			SST simpleSST = new SST(factor,0,0);
			sstList.add(simpleSST);
			return sstList;
		}
			
		else if (sst.isConstant) {
			SST simpleSST = new SST(factor, sstUnit.getUnique(), sstUnit.getN());
			sstList.add(simpleSST);
			return sstList;
		}
		
		else if (sstUnit.isConstant) {
			SST simpleSST = new SST(factor, sst.getUnique(), sst.getN());
			sstList.add(simpleSST);
			return sstList;
		}
		
		else if(sst.getN().equals(sst.getUnique())){
		sstList.add(new SST(
				factor.multiply (new BigDecimal((sst.getN()))),
				sst.getUnique(),
				sst.getN(),
				sst.setbits));
		return sstList;
		}
		
	     BigDecimal sst_factor_n_plus_1 = 
	    		factor
	    		 .multiply(new BigDecimal((sst.getUnique())))
	    		 .multiply(Utility.comb(sst.getUnique()-1,sst.getN()))
	    		 .divide(Utility.comb(sst.getUnique(),sst.getN()+1));
	     
	     SST sstL1 = new SST(sst_factor_n_plus_1,sst.getUnique(),sst.getN()+1,sst.setbits);
		
		
	     BigDecimal sst_factor_n = 
	    		 factor
	    		.multiply(new BigDecimal(sst.getUnique())
	    		.multiply(
	    		   Utility.comb(sst.getUnique(),sst.getN()) 
	    		   .subtract(Utility.comb(sst.getUnique()-1,sst.getN()))
	    		   )
	    		.divide(Utility.comb(sst.getUnique(),sst.getN())));
	     
	     SST sstL2 = new SST(sst_factor_n,sst.getUnique(),sst.getN(),sst.setbits);
		
		
		sstList.add(sstL1);
		sstList.add(sstL2);
			
		return sstList;
	}
	
    /*
	public static List<SST> multiply(SST sst1,SST sst2){
		
		List<SST> sstList = new ArrayList<SST>();
		Double factor = sst1.getFactor() * sst2.getFactor();
		
		//if any of sst is of simple type (constant) just multipy the factor and return
		if(sst1.isConstant){
			sst2.setFactor(factor*sst2.getFactor());
			sstList.add(sst2);
			return sstList;
		}
		
		SST sstL1 = new SST(factor*sst1.getUnique()
				       *Utility.comb(
				        sst1.getUnique()- 1,
				        sst1.getN()-1
				        ),
				        sst1.getUnique(),
		        	    sst1.getN());
		
		

		SST sstL2 = new SST(factor*sst1.getUnique()*
				         (Utility.comb(sst1.getUnique(),sst1.getN())
						- Utility.comb(sst1.getUnique()-1,sst1.getN()-1)),
				        sst1.getUnique(),
				        sst1.getN()+1);
		
		sstList.add(sstL1);
		sstList.add(sstL2);
			
		return sstList;
	}
	*/
	
	public static List<SST> multiply(List<SST> sst1,List<SST> sst2){
		
		List<SST> mergedList  = new ArrayList<SST>();
		
		sst1.stream().forEach(sst_1->{
			sst2.stream().forEach(sst_2->{
				mergedList.addAll(multiplyWithUnitSST(sst_1,sst_2));	
			});
		});
		
		
	return mergedList;
	}
	
	public static List<SST> merge (List<SST> sstList) {
		
		List<SST> mergedList  = new ArrayList<SST>();
		Map<Integer,List<SST>> sstMap = sstList
				                       .stream()
				                       .collect(Collectors.groupingBy(SST::getN));
		
		sstMap.forEach((n,ssts)->{
			BigDecimal factor = ssts
					       .stream()
					       .map(sst->sst.getFactor())
					       .reduce(BigDecimal::add).get();
			
			Integer unique = ssts
				            .stream().findAny().get().getUnique();
			
			Integer setbits = ssts
		            .stream().findAny().get().setbits;
			
		    SST sst = new SST(factor,unique,n,setbits);
			mergedList.add(sst);
		});
			
		
		return mergedList;
	}
	
	
	
	
	public  BigDecimal evaluate() {
		
		if(this.isConstant){
		return this.factor;
		}
		
		else if(this.setbits.equals(0) || this.unique.equals(this.n)){
			//uCn * 2^(u-n)
			return   this.factor
					.multiply(Utility.comb(this.unique,this.n))
				    .multiply(Utility.pow(2, this.unique-this.n));
		}
		else{
		return this.factor.multiply(computeSetBits());			
		}
		
	
	}
	
	private BigDecimal computeSetBits() {
	   
		Integer u = this.getUnique();
		Integer p= this.setbits;
		Integer n = this.getN();
		BigDecimal sum = new BigDecimal("0");
		Integer r= 0;
		
		while(n>=0 && p>=r){
		
		if(u-p-n < 0 ){
		n=n-1;	
		r= r+1;
		continue;
		}
			
		sum = sum .add(
				      Utility.comb(u-p, n) 
		             .multiply(Utility.comb(p, r))
		             .multiply(Utility.pow(2, u-p-n))
		             );
		n=n-1;	
		r= r+1;
		}
				
		return sum;
	}
	
	public  static BigDecimal evaluate(List<SST> ssts){
		BigDecimal sum = ssts
				    .stream()
				    .map(sst->sst.evaluate())
				    .reduce(BigDecimal::add).get();
		return sum;
	}
	
	
}
