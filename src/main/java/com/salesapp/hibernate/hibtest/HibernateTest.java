/**
 * 
 */
package com.salesapp.hibernate.hibtest;

import com.salesorderapp.common.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author freakster
 *
 */
public class HibernateTest {
	
	public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
        String stu=null;
//        /Studentold stu = new Studentold();
        //stu.setIdStudent(2);
        //stu.setStudentName("ayush");
        //stu.setStudentAge(17);
        session.save(stu);
 
        //session.save(new Employee("Jakab Gipsz",department));
        //session.save(new Employee("Captain Nemo",department));
      
        session.getTransaction().commit();
 
        Query q = session.createQuery("From Student ");
                 
        //List<Studentold> resultList = q.list();
        //System.out.println("num of students:" + resultList.size());
        //for (Studentold next : resultList) {
       //     System.out.println("next employee: " + next);
      // }

	}
}
