package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assumptions;

public class SUT {
	private Job currentJob;

	public void run(Job currentJob) {
		this.currentJob = currentJob;
	}

	public boolean hasJobToRun() {
		return currentJob != null;
	}
}
