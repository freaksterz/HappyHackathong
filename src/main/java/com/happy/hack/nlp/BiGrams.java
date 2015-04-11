/**
 * 
 */
package com.happy.hack.nlp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.salesorderapp.common.util.HibernateUtil;

/**
 * @author saurabhshashank
 *
 */
public class BiGrams {
	public void biGramsConnection() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		String stu = null;
		// /Studentold stu = new Studentold();
		// stu.setIdStudent(2);
		// stu.setStudentName("ayush");
		// stu.setStudentAge(17);
		session.save(stu);

		// session.save(new Employee("Jakab Gipsz",department));
		// session.save(new Employee("Captain Nemo",department));

		session.getTransaction().commit();

		String sql = "SELECT first_name, salary FROM EMPLOYEE";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List results = query.list();
	}

	public static String biGramEngine(String content) {
		// the luine are sep by ||
		StringBuffer biGrams = new StringBuffer();
		String[] lines = content.split("\\|\\|");
		for (String line : lines) {
			String[] words = line.trim().split(" ");
			for (int i = 0; i < words.length; i++) {
				if (i == words.length - 1) {
					continue;
				}
				biGrams.append(words[i] + "-" + words[i + 1] + " ");
			}
		}
//		 Persist the data in the tables

		return biGrams.toString();
	}

	public static void main(String[] args) {
		String res = biGramEngine("good service great facilities true downtown los angeles dodgy place stay area clarion good choice||  went see show club nokia chose hotel due close proximity venue cheap price (i work travel industry employee discount price rediculously low l|| accomodation)||  initially planned walk venue receptionists advised against booked cab||  hotel old well-maintained||  public facilities clean pleasant||  room big equipped tv set refrigirator coffee making facilites - none used looked clean||  bathroom spotless water shower pipping hot high pressure bathroom amenities better quality find places||  there's free parking hotel guests great advantage||  book again needed||||");
		System.out.println("res =>\n"+res);
//		String[] biGrams = res.split(" ");
//		for (String string : biGrams) {
//			System.out.println(string);
//		}
	}
}
