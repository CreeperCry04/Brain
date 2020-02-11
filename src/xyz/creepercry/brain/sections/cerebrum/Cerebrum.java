package xyz.creepercry.brain.sections.cerebrum;

import xyz.creepercry.brain.sections.cerebrum.amygdala.Amygdala;
import xyz.creepercry.brain.sections.cerebrum.hemispheres.left.LeftHemisphere;
import xyz.creepercry.brain.sections.cerebrum.hemispheres.right.RightHemisphere;

public class Cerebrum {
	
	private LeftHemisphere left;
	private RightHemisphere right;
	
	private CorpusCallosum corpusCallosum;
	private Amygdala amygdala;
	
	public void initiate() {
		left = new LeftHemisphere();
		right = new RightHemisphere();

		corpusCallosum = new CorpusCallosum();
		amygdala = new Amygdala();

		left.initiate();
		right.initiate();
		
		corpusCallosum.initiate();
		amygdala.initiate();
	}

	public LeftHemisphere getLeftHemisphere() {
		return left;
	}

	public RightHemisphere getRightHemisphere() {
		return right;
	}
	
	public CorpusCallosum getCorpusCallosum() {
		return corpusCallosum;
	}
	
	public Amygdala getAmygdala() {
		return amygdala;
	}
}