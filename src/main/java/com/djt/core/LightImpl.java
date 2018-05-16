package com.djt.core;

import java.io.PrintStream;
import java.time.LocalDateTime;

/**
 * Implementatino of the light interface
 * @author DTillin
 *
 */
public class LightImpl implements Light {

	private static final String TO_STRING_PATTERN ="Light %s %s %s";
	private LightState state = LightState.Off;
	
	
	public static final Light[] LIGHTS = init(Main.NUM_OF_LIGHTS);
	
	
	private int index;
	private Colour colour;
	
	protected static Light[] init(int numOfLights) {
		Light[] lights = new LightImpl[numOfLights];
		for (int i=0; i< numOfLights; i++) {
			lights[i]=new LightImpl(i, Colour.Red);
			i++;
			lights[i]=new LightImpl(i, Colour.Green);
			i++;
			if (i<20) {
				lights[i]=new LightImpl(i, Colour.White);
			}
		}
		return lights;
	}
	
	LightImpl(int i, Colour c) {
		this.index=i;
		this.colour=c;
	}
	
	public LightState state() {
		return LightState.Off;
	}
	
	public synchronized LightState toggle() {
		
		state = (LightState.Off == state) ? LightState.On : LightState.Off;
		return state;
	}
	
	
	public String toString() {
		return String.format(TO_STRING_PATTERN, String.valueOf(index+1), colour.toString(), state.toString().toLowerCase());
	}

	public Colour colour() {
		return colour;
	}

	@Override
	public void lightFor(long interval) {
		toggle();
		reportTo(System.out);
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		toggle();
		reportTo(System.out);
	}
	
	private void reportTo(PrintStream ps) {
		ps.println(LocalDateTime.now() +  " " + toString());
	}
}
