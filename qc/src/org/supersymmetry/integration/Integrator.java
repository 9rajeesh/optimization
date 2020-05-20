package org.supersymmetry.integration;

import java.util.List;

public abstract class Integrator {


	
	public abstract Number integrateOverVariables(List<Clause> clauses, String targetVariable,Integer value);
	
	
	
	
  }
