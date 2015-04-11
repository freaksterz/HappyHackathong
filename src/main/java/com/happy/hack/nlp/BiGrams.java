/**
 * 
 */
package com.happy.hack.nlp;


/**
 * @author saurabhshashank
 *
 */
/**
 * @author saurabhshashank
 * <p>A Simple consecutive words bi-gram alogrithm</p>
 *
 */
public class BiGrams {
	public void biGramsConnection() {}

	public static void biGramEngine(String content) {
		// the line are sep by ||
		StringBuffer biGrams = new StringBuffer();
		String[] lines = content.split("\\|\\|");
		for (String line : lines) {
			String[] words = line.trim().split(" ");
			for (int i = 0; i < words.length; i++) {
				if (i == words.length - 1) {
					continue;
				}
				biGrams.append(words[i] + "-" + words[i + 1] + " ");
//				Persist the data in the tables
				System.out.println(biGrams);
				biGrams=new StringBuffer();
			}
		}

		
	}
}
