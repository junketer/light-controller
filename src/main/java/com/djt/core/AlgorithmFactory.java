package com.djt.core;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmFactory {

	private static Map<LightAlgorithmType, LightAlgorithm> ALGORITHMS = createAlgorithms();

	private static Map<LightAlgorithmType, LightAlgorithm> createAlgorithms() {
		Map<LightAlgorithmType, LightAlgorithm> map = new HashMap<LightAlgorithmType, LightAlgorithm>(LightAlgorithmType.values().length);
		map.put(LightAlgorithmType.Sequence, new SequenceLightAlgorithm());
		return map;
	}
	
	
	public static LightAlgorithm getAlgorithm(LightAlgorithmType type) {
		if (ALGORITHMS.containsKey(type)) {
			return ALGORITHMS.get(type);
		}
		throw new IllegalArgumentException("No Algorithm for type " + type);
	}
}
