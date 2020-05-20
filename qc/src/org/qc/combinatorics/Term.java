package org.qc.combinatorics;

public class Term {

	private Long factor;
	private Long aPower;
	private Long bPower;
	private Long cPower;
	private Long dPower;
	private Long ePower;
	private Long fPower;
	
	
	
	
	
	public Term(Long factor, Long aPower, Long bPower, Long cPower, Long dPower, Long ePower, Long fPower) {
		super();
		this.factor = factor;
		this.aPower = aPower;
		this.bPower = bPower;
		this.cPower = cPower;
		this.dPower = dPower;
		this.ePower = ePower;
		this.fPower = fPower;
	}
	public Long getFactor() {
		return factor;
	}
	public void setFactor(Long factor) {
		this.factor = factor;
	}
	public Long getaPower() {
		return aPower;
	}
	public void setaPower(Long aPower) {
		this.aPower = aPower;
	}
	public Long getbPower() {
		return bPower;
	}
	public void setbPower(Long bPower) {
		this.bPower = bPower;
	}
	public Long getcPower() {
		return cPower;
	}
	public void setcPower(Long cPower) {
		this.cPower = cPower;
	}
	public Long getdPower() {
		return dPower;
	}
	public void setdPower(Long dPower) {
		this.dPower = dPower;
	}
	public Long getePower() {
		return ePower;
	}
	public void setePower(Long ePower) {
		this.ePower = ePower;
	}
	public Long getfPower() {
		return fPower;
	}
	public void setfPower(Long fPower) {
		this.fPower = fPower;
	}
	
	public static Term multiply(Term term1,Term term2) {
		Term term = new Term(1L,0L,0L,0L,0L,0L,0L);
		term.setFactor(term1.getFactor()*term2.getFactor());
		term.setaPower(term1.getaPower()+term2.getaPower());
		term.setbPower(term1.getbPower()+term2.getbPower());
		term.setcPower(term1.getcPower()+term2.getcPower());
		term.setdPower(term1.getdPower()+term2.getdPower());
		term.setePower(term1.getePower()+term2.getePower());
		term.setfPower(term1.getfPower()+term2.getfPower());
		return term;
	}
	
	public String toString() {
		String s = "";
		return this.factor+"*"
				+"a^"+this.getaPower()
				+"b^"+this.getbPower()
				+"c^"+this.getcPower()
				+"d^"+this.getdPower()
		        +"e^"+this.getePower()
		        +"f^"+this.getfPower();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aPower == null) ? 0 : aPower.hashCode());
		result = prime * result + ((bPower == null) ? 0 : bPower.hashCode());
		result = prime * result + ((cPower == null) ? 0 : cPower.hashCode());
		result = prime * result + ((dPower == null) ? 0 : dPower.hashCode());
		result = prime * result + ((ePower == null) ? 0 : ePower.hashCode());
		result = prime * result + ((fPower == null) ? 0 : fPower.hashCode());
		result = prime * result + ((factor == null) ? 0 : factor.hashCode());
		return result;
	}

	public boolean similarTo(Term obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (aPower == null) {
			if (other.aPower != null)
				return false;
		} else if (!aPower.equals(other.aPower))
			return false;
		if (bPower == null) {
			if (other.bPower != null)
				return false;
		} else if (!bPower.equals(other.bPower))
			return false;
		if (cPower == null) {
			if (other.cPower != null)
				return false;
		} else if (!cPower.equals(other.cPower))
			return false;
		if (dPower == null) {
			if (other.dPower != null)
				return false;
		} else if (!dPower.equals(other.dPower))
			return false;
		if (ePower == null) {
			if (other.ePower != null)
				return false;
		} else if (!ePower.equals(other.ePower))
			return false;
		if (fPower == null) {
			if (other.fPower != null)
				return false;
		} else if (!fPower.equals(other.fPower))
			return false;
		if (factor == null) {
			if (other.factor != null)
				return false;
		}
		return true;
	}
		
}
