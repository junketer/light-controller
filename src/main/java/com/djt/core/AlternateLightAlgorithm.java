package com.djt.core;

/**
 * Run all algorithms 
 * @author DTillin
 *
 */
public class AlternateLightAlgorithm implements LightAlgorithm {

	@Override
	public void run() {
		
		LightAlgorithm a1 = AlgorithmFactory.getAlgorithm(LightAlgorithmType.Sequence);
		LightAlgorithm a2 = AlgorithmFactory.getAlgorithm(LightAlgorithmType.Colour);
		a1.run();
		a2.run();
			
	}

}
