package com.djt.core;

public class SequenceLightAlgorithm implements LightAlgorithm {

	public void run() {

		for (Light l : LightImpl.LIGHTS) {
			l.lightFor(500);
		}
	}

}
