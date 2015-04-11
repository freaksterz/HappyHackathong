package com.happy.hack.nlp;

import java.util.Arrays;

public class StopWordRemoval {

	static String arr_stopword[];
	static{
		String stopword="a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your";
		arr_stopword=stopword.split(",");
		Arrays.sort(arr_stopword);
	}
	
	public static void main(String[] args) {
		String content="Could be great if they cared, but Not This hotel could be wonderful but the service is terrible and the desk staff is rude when there is a legitimate issue. It is a shame because this hotel does have great amenities. Off the lobby there are shops and a restaurant which thankfully are not managed by the same people as the hotel. The hotel itself is older but seems well kept and the parking garage is a great asset in L.A.However the absent communication between the desk and housekeeping equates to dirty rooms and violations of guests peace and privacy. Worse, when these deficiencies are pointed out the staff responds with rude behavior or empty promises.My experience with this hotel began well and then went down hill. Unhappy with the location of the original hotel I had booked I called Choice Hotels for an alternate location and found this hotel. Unfortunately they were not able to complete the reservation because their computers were down and my WiFi was not working so Choice gave me the number and I called the hotel directly. The young lady who answered was very pleasant and I booked a room. Upon arrival I found a very well appointed older hotel and was pleased with the value and the service of the young lady I had spoken with who was at the desk. The service made me smile and look forward to a pleasant stay. That is until walking into the room. The door was ajar when I arrived and it became apparent the housekeeping had not completed their tasks. Pillows were missing from the bed, the linens had not all been replaced, and the room had not been vacuumed. Later I found the refrigerator had a spill which was leaking out. Seeing the condition of the room I called the desk for another but they encouraged me to stay in the room when I asked to do it later because I was running tight for an appointment and needed to take a shower and change. They offered instead to send housekeeping if I called when ready . It seems the desk never contacted housekeeping because as I stepped wearing only a towel into dressing area the housekeeper came in to the great embarrassment of both of us. She hurriedly dropped a few towels and left. While I understand her angst she never returned to finish cleaning though I again called the desk and they apologized and said the room would be made and the Manager would call me the next morning. I came back late that evening to find the room in the same state. By then food and liquid left in the fridge had begun to seep out and I used the few towels I had left. The air conditioning had been off so there was an odor. I called the desk and again they would not offer another room, nor would they provide pillows or towels and the desk clerk was very rude. He said if I did not like the room they had a satisfaction guaranteed policy and the manager would refund in the morning. Notably this never happenedThe stench in the room was unbearable so I cleaned the mess they should have then opened the window and turned the air conditioning on to ventilate and cool the room and went out so it could air. As I passed the desk the clerk was in an animated conversation with another man using colorful language. Later I returned to my room and called down for a wake up call and a late check out. No wake up call came and I missed breakfast. I woke because housekeeping walked in again though there was a Do Not Disturb on the door. The clerk had not put in my late check out. I called the desk to complain again and and had a difficult time getting a late checkout though it is a benefit of the the rewards program I belong to with the chain. They did finally give me the late checkout. Though polite at this time, and though they did acknowledge the legitimacy and seriousness of my complaint the staff said they could do nothing to assist me and I needed to talk to the manager who was off property. Later I found this was not true. I asked for housekeeping to clean my room when I went out to eat and they refused saying I was checking out that day. Apparently clean rooms are not part of staying at this hotel. After an early lunch I finally found the General Manager. He was very polite gentleman from Korea I believe and shared a few nice stories about his homeland. He said how embarrassed he was about the terrible service, though in retrospect he seemed more concerned about an unauthorized person being behind his register with the night clerk than my problems. I explained how the clerk had said rather than deal with my problem I could ask for a refund but what I had wanted was the room clean and right not the money. He did offer to refund the room but suggested as it was a business stay and really did not benefit me, he offered a return stay. He was so gracious I honestly I felt this service was an anomaly and accepted his offer.The reason I accepted is the hotel is in a great location and the attached Japanese restaurant is outstanding. I ate there three times and enjoyed every meal and the extraordinarily good service. Sorry I cannot recall the name but if you do take the trouble to find it, try the lunch special. It mixes tempura sushi and sashimi and while not cheap is great food at a great value. There is also an unusual store there in the form of a quaint mountaineering and sportswear store. They staff there is very friendly and knowledgeable. I really enjoyed it and bought a few things.When I left I felt my visit had been a trial but fairly good about the hotel because of the graciousness of the Manager. It seemed that he would make it irght. However it was a placebo, and apparently not an effort to do the right thing. A week or two later I called seeking to give them another chance as the Manager had requested and offered. As a matter of fact I was optimistic I attempted to book a weekend which would have resulted in two paid days in addition to the one he offered. The staff was very rude. Desk Managers represented themselves as the General Manager. One woman I spoke with said yes she was aware of the problem and would offer me a minor discount off of rack rate which amounted to significantly more then either my AAA or Choice Privileges would provide me.I called Choice Hotels and they offered me a contact and finally a transfer took me to to the business office only to miss the GM. I did reach the accountant who was a nice guy and promised to give my number of the General Manager. No one called. Had I booked through Choice I would have a recourse. Unfortunately I was not able to. Needless to say I would not recommend this hotel. --------------------- ";
		new StopWordRemoval().getStopWordRemoval(content);
	}

	/**
	 * @Author: Kumar Ankit
	 * 
	 * @param: The review given by user in original form.
	 * 
	 * @return : The review after removal of all the 
	 * stop words from review and each sentence is 
	 * delimited by "||" without quotes.
	 */
	public String getStopWordRemoval(String content) {

		//sample has to be read from database
		content=content.replaceAll(",", "");
		content=content.replaceAll("!", "");
		content=content.replaceAll("@", "");
		content=content.replaceAll("#", "");
		content=content.replaceAll("$", "");
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
		
		
		String sample_wostop="";

		String samp[]=content.split("\\.");
		System.out.println(samp.length);
		for (String string : samp) {
			System.out.println(string);
			String words_sent[]=string.split(" ");
			String x="";
			for (String string2 : words_sent) {
				System.out.println(string2=string2.toLowerCase());
				int found=Arrays.binarySearch(arr_stopword, string2);
				if(found<0){
					x=x+" "+string2.trim();
				}
			}
			if(x.trim().length()>0)
				sample_wostop=sample_wostop+x+"||";
		}

		System.out.println(sample_wostop);
		return sample_wostop;

	}

}
