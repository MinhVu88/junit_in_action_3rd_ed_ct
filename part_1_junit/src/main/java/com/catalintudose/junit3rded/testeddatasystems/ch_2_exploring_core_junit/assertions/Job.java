package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assertions;

import java.util.Objects;

public class Job {
	private String name;

	public Job(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}

		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Job job = (Job) obj;
		
		return Objects.equals(name, job.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "job: " + name;
	}
}
