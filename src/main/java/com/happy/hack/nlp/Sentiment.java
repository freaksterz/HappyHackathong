/**
 * 
 */
package com.happy.hack.nlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 * @author saurabhshashank
 *
 */
public class Sentiment {
	static HashSet<String> positive = new HashSet<String>();
	static HashSet<String> negative = new HashSet<String>();

	public void setup() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("negative-words.txt")
				.getFile());
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			String line = br.readLine();

			while (line != null) {
				negative.add(line.trim());
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		file = new File(classLoader.getResource("positive-words.txt")
				.getFile());
		br = new BufferedReader(new FileReader(file));
		try {
			String line = br.readLine();

			while (line != null) {
				positive.add(line.trim());
				line = br.readLine();
			}
		} finally {
			br.close();
		}
	}

	public String sentimet(String content) throws Exception {
		setup();
		String[] lines=content.split("\\|\\|");
		int sentWordCount=0;
		float sentimentSum=0.0f;
		for (String line : lines) {
			String[] words=line.trim().split(" ");
			for (String word : words) {
				if (positive.contains(word.toLowerCase())) {
					sentimentSum++;
					sentWordCount++;
				}else if (negative.contains(word.toLowerCase())) {
					sentimentSum--;
					sentWordCount++;
				}
			}
		}
//		cat in +ve or -ve 
		float sentiment= sentimentSum == 0 || sentWordCount == 0? 0.0f : (sentimentSum/sentWordCount);
		return sentiment >0 ? "POSITIVE" : "Negative";

	}
	


}
