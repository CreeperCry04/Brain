package xyz.creepercry.brain.util.classes;

import java.util.ArrayList;
import java.util.List;

public class DNA {
	
	private final List<Protein> proteins = new ArrayList<>();
	
	
	public void initiate() {
		for (int i = 0; i < 100; i++)
			proteins.add(new Protein());
	}
	
	public List<Protein> getProteins() {
		return proteins;
	}
}