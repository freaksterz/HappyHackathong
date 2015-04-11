/**
 * 
 */
package com.happy.hack.nlp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

/**
 * @author saurabhshashank
 *         <p>
 *         implementation of white paper published Technical University of
 *         Cluj-Napoca, Faculty of Automation and Computer Science. Using open
 *         NLP parser. Parsing the parse tree.
 *         </p>
 */
public class Triplet {
	public static String[] IE(Parse parse) {
		String[] aspect=new String[2];
		String NP = "", VP = "", obj;
//		parse.show();
		if (parse.getType().equals("S")) {
			// parse.show();
			Parse[] sent = parse.getChildren();
			for (Parse child : sent) {
				if (child.getType().equals("NP")) {
					NP = child.getCoveredText();
//					TODO
					System.out.print("Sub : ");
					key(child.getChildren());
				} else if (child.getType().equals("VP")) {
					VP = child.getCoveredText();
					System.out.print("\nRelation : ");
					getRel(child.getChildren());
					System.out.print("\nObj : ");
					key(child.getChildren());

				}
			}
		}
//		
		System.out.println("\nNP=" + NP + "\tVP=" + VP);
//		TODO remove stop words
		aspect[0]=NP;
		aspect[1]=VP;
		return aspect;

	}

	public static void getRel(Parse[] parses) {
		for (Parse parse : parses) {
			if (parse.getType().matches("\\w*V\\w*")) {
				System.out.print(parse.getCoveredText());
			}
		}
	}

	public static void key(Parse[] parse) {
		for (Parse parse2 : parse) {
			if (parse2.getType().matches("\\w*NN\\w*")) {
				System.out.print(parse2.getCoveredText() + " ");
			} else if (parse2.getChildCount() == 0) {
				return;
			} else {
				key(parse2.getChildren());
			}
		}
	}

	public void triplet(String content) throws Exception {
		ArrayList<String> lines = tokenizer(content);
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("en-parser-chunking.bin")
				.getFile());
		FileInputStream modelIn = new FileInputStream(file);
		try {
			ParserModel model = new ParserModel(modelIn);
			Parser parser = ParserFactory.create(model);
			// String sentence =
			// "The quick brown fox jumps over the lazy dog .";
			for (String line : lines) {
				Parse topParses[] = ParserTool.parseLine(line, parser, 1);
				for (Parse parse : topParses) {
					String[] aspect=IE(parse.getChildren()[0]);
//					TODO persist apsect with sentiment too. so better get sentiment for the content here and do what ever you want to do man
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
				}
			}
		}

	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new Triplet().triplet(" Good service, great facilities True, Downtown Los Angeles is a dodgy place to stay, but if you must be in the area, Clarion is a good choice. We went to see a show in Club Nokia and chose this hotel due to its close proximity to the venue and the cheap price (I work in the travel industry and after my employee discount the price was rediculously low for an L.A accomodation). We had initially planned to walk to the venue, but the receptionists advised us against it an booked us a cab. The hotel might be old but well-maintained. Public facilities are clean and pleasant. Room was big, equipped with a TV set, refrigirator and coffee making facilites - none of which we used, but all looked clean. Bathroom was spotless, water in the shower pipping hot and with high pressure, bathroom amenities of better quality than what you find in most places. There's free parking for hotel guests, which is a great advantage. Will book there again if needed.");
	}

	public ArrayList<String> tokenizer(String content) throws Exception {
		ArrayList<String> lines = new ArrayList<String>();

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("en-sent.bin").getFile());
		FileInputStream fileInputStream = new FileInputStream(file);
		SentenceModel model = new SentenceModel(fileInputStream);
		SentenceDetectorME detectorME = new SentenceDetectorME(model);
		String[] sent = detectorME.sentDetect(content);
		for (String string : sent) {
			lines.add(string);
		}
		fileInputStream.close();

		return lines;

	}
	

}
