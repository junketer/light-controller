package com.djt.core;

/**
 * Interface to represent a light
 * @author DTillin
 *
 */
public interface Light {

	/**
	 * Return the state of the light
	 * @return LightState
	 */
	LightState state();
	
	/**
	 * Toggle the light state on / off
	 * @return LightStatue - current light state
	 */
	LightState toggle();
	
	/**
	 * Return the colour of the light
	 * @return Colour
	 */
	Colour colour();
	
	/**
	 * Turn the light on for <code>interval</code> milliseconds.
	 * Note this method will block for the interval
	 * @param interval long - the interval to light up for
	 */
	void lightFor(long interval);
}
