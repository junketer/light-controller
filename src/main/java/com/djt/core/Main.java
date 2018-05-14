package com.djt.core;

public class Main {

	static final int RC_OK = 0;
	static final int RC_INVALID_INPUT = 10;
	static final int RC_UNKNOWN = 90;

	static final int NUM_OF_LIGHTS = 20;

	/**
	 * The main method to be called to run the program
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Main logic in a separate run method to 
		 * allow for tests that won't bomb out the JVM
		 * 
		 * This main method is required to return a return code (RC)
		 * to the command line for scripts to be able to interpret the
		 * result of the program
		 */
		System.exit(run(args));
	}

	public static int run(String[] args) {
		int RC = RC_OK;
		try {
			if (args.length == 0) {
				//
				echo(printInput("Expecting one of"));
				RC = RC_INVALID_INPUT;
			} else {

				LightAlgorithmType type = LightAlgorithmType.valueOf(args[0]);
				AlgorithmFactory.getAlgorithm(type).run();
			}
		} catch (Error e) {
			RC = RC_UNKNOWN;
		} catch (Exception e) {
			RC = RC_UNKNOWN;
		}

		return RC;
	}

	private static void echo(String printInput) {

		System.out.println(printInput);
	}

	private static String printInput(String string) {
		StringBuilder sb = new StringBuilder();
		sb.append(string);
		for (LightAlgorithmType type : LightAlgorithmType.values()) {
			sb.append(" ").append(type.toString()).append(" ");
		}
		return sb.toString();
	}

}
