package com.djt.core;

public interface Light {

	/**
	 * Return the state of the light
	 * @return LightState
	 */
	public LightState state();
	
	/**
	 * Toggle the light state on / off
	 * @return LightStatue - current light state
	 */
	public LightState toggle();
	
	/**
	 * Return the colour of the light
	 * @return Colour
	 */
	public Colour colour();
	
	/**
	 * Turn the light on for <code>interval</code> milliseconds.
	 * Note this method will block for the interval
	 */
	public void lightFor(long interval);
}
