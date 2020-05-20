package org.supersymmetry.integration;

import java.util.List;
import java.util.Map;

public abstract class Grouper {

	public abstract Map<String,List<Clause>> group(List<Clause> clauses);
	
}
