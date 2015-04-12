package com.happy.hack.nlp;

import java.util.ArrayList;
import java.util.Arrays;

public class StopWordRemoval {

	static String arr_stopword[];
	static{
		String stopword="a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,it's,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your,very,too";
		arr_stopword=stopword.split(",");
		Arrays.sort(arr_stopword);
	}
	

	/**
	 * @Author: Kumar Ankit
	 * 
	 * @param: The review given by user in original form.
	 * 
	 * @return : The review after removal of all the 
	 * stop words from review and each sentence is 
	 * delimited by "||" without quotes.
	 * @throws Exception 
	 */
	public static String getStopWordRemoval(String content) throws Exception {

		//sample has to be read from database
		content=content.replaceAll(",", "");
		content=content.replaceAll("!", "");
		content=content.replaceAll("@", "");
		content=content.replaceAll("#", "");
		content=content.replaceAll("\\$", "");
		content=content.replaceAll("%", "");
		content=content.replaceAll("^", "");
		content=content.replaceAll("&", "");
		content=content.replaceAll("\\*", "");
		content=content.replaceAll("\\(", "");
		content=content.replaceAll("\\)", "");
		content=content.replaceAll("\\[", "");
		content=content.replaceAll("\\]", "");
		content=content.replaceAll("\\{", "");
		content=content.replaceAll("\\}", "");
		content=content.replaceAll("\\:", "");
		content=content.replaceAll("\\?", "");
		content=content.replaceAll("\\;", "");
		content=content.replaceAll("\\-", "");
		content=content.replaceAll("\"", "");
		content=content.replaceAll("\\“", "");
		content=content.replaceAll("\\`", "");
		content=content.replaceAll("^[0-9]*", "");
		
		String sample_wostop="";
// Token line
		ArrayList<String> samp=new Triplet().tokenizer(content);
//		System.out.println(samp.length);
		for (String string : samp) {
			
			String words_sent[]=string.split(" ");
			String x="";
			for (String string2 : words_sent) {
				string2=string2.toLowerCase();
			
				int found=Arrays.binarySearch(arr_stopword, string2);
				if(found<0){
					x=x+" "+string2.trim();
				}
			}
			if(x.trim().length()>0)
				sample_wostop=sample_wostop+x+"||";
		}

//		System.out.println(sample_wostop);
		return sample_wostop;

	}
	public static void main(String[] args) throws Exception {
		getStopWordRemoval("@400 per night");
	}

}
