package com.djt.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Colour algorithm. Toggles all Red lights on for 1 sec, then all green, then all white
 * 
 * @author DTillin
 *
 */
public class ColourLightAlgorithm implements LightAlgorithm {

	/**
	 * Run the algorithm
	 */
	public void run() {
	
		// get the lights
		Light[] lights = LightImpl.LIGHTS;
		
		/*
		 *  Create an executor service to light up each light independently
		 *  Use the length of the lights array so that if we change number of lights
		 *  it will adjust the thread ppol accordingly
		 *  If we increase the number of lights too much, the implementation might have to
		 *  consider there being too many threads
		 */
		ExecutorService service = Executors.newFixedThreadPool(lights.length);
		// iterate over the colours in turn
		for (Colour c: Colour.values()) {
			// collect the futures
			List<Future> results = new ArrayList<Future>(lights.length) ;
			// light up each light in a thread on the executor service
			for (Light l: lights) {
				if (c.equals(l.colour())) {
					// run(Light) will block for the interval as Light.lightFor(interval) blocks
					results.add(service.submit( ()-> {ColourLightAlgorithm.run(l);}));
				}
				
			}
			// check the futures until they are all complete.
			// Should be elapsed 1 sec, but just be sure
			// loop until all future results are returned
			do {
				try {
					Future f= results.get(0);
					f.get();// wait on the result
					results.remove(f);// remove from list
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (!results.isEmpty());
			
		}
		
		
	}
	
	
	static String run(Light l) {
		l.lightFor(1000);
		return null;
	}
	

}
