package xyz.creepercry.brain.sections.cerebrum;

import java.util.ArrayList;
import java.util.List;

import xyz.creepercry.brain.util.classes.Fiber;

public class CorpusCallosum {
	
	private final List<Fiber> fibers = new ArrayList<>();
	
	public void initiate() {
		// testing
		for (int i = 0; i < 100; i++)
			fibers.add(createFiber());
	}
	
	public Fiber createFiber() {
		return new Fiber();
	}
	
	public List<Fiber> getFibers() {
		return fibers;
	}
}