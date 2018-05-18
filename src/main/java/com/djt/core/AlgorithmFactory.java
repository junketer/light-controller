package com.djt.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for obtaining algorithm to run
 * <P>
 * @author DTillin
 *
 */
public class AlgorithmFactory {

	/*
	 * Map to hold the algorithms
	 */
	private static Map<LightAlgorithmType, LightAlgorithm> ALGORITHMS = createAlgorithms();

	/*
	 * method to create the map of algorithms
	 */
	private static Map<LightAlgorithmType, LightAlgorithm> createAlgorithms() {
		Map<LightAlgorithmType, LightAlgorithm> map = new HashMap<LightAlgorithmType, LightAlgorithm>(LightAlgorithmType.values().length);
		map.put(LightAlgorithmType.Sequence, new SequenceLightAlgorithm());
		map.put(LightAlgorithmType.Colour, new ColourLightAlgorithm());
		map.put(LightAlgorithmType.Alternate, new AlternateLightAlgorithm());
		
		return map;
	}
	
	/**
	 * Static method to return the relevant algorithm using a value of LightAlgorithmType enum
	 * 
	 * @param type LightAlgorithmType
	 * @return LightAlgoritm
	 */
	public static LightAlgorithm getAlgorithm(LightAlgorithmType type) {
		if (ALGORITHMS.containsKey(type)) {
			return ALGORITHMS.get(type);
		}
		throw new IllegalArgumentException("No Algorithm for type " + type);
	}
	
	/**
	 * Returns all algorithms
	 * @return Collection of LightAlgorithm instances
	 */
	public static Collection<LightAlgorithm> all() {
		return Collections.unmodifiableCollection(ALGORITHMS.values());
	}
	
	/**
	 * Private as we don't need instances, it's all static
	 */
	private AlgorithmFactory() {
		super();
	}
}
