package com.djt.core;

public class SequenceLightAlgorithm implements LightAlgorithm {

	public void run() {

		for (Light l : LightImpl.LIGHTS) {
			l.toggle();// on
			System.out.println(l.toString());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace(System.err);
			}

			l.toggle();// off
			System.out.println(l.toString());
		}
	}

}
