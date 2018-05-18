package com.djt.core;

/**
 * Sequence algorithm
 * @author DTillin
 *
 */
public class SequenceLightAlgorithm implements LightAlgorithm {

	@Override
	public void run() {

		for (Light l : LightImpl.LIGHTS) {
			l.lightFor(500);
		}
	}

}
