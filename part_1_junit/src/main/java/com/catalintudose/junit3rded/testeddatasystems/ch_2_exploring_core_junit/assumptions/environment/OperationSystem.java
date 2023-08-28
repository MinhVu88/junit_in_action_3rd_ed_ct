package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assumptions.environment;

public class OperationSystem {
	private String name;
	private String architecture;

	public OperationSystem(String name, String architecture) {
		this.name = name;
		this.architecture = architecture;
	}

	public String getName() {
		return name;
	}

	public String getArchitecture() {
		return architecture;
	}
}
