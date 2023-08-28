package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.parametrized;

public class WordCounter {
	public int countWords(String sentence) {
		return sentence.split(" ").length;
	}
}
