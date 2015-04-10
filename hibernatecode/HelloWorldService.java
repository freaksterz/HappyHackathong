package com.salesapp.business.ws;

import com.google.gson.Gson;
import com.salesorderapp.hibernate.entity.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.salesapp.hibernate.util.Hibernate;



	@Path("/hello")
	public class HelloWorldService {
	 
		/*@GET
		@Path("/{param}")
		public Response getMsg(@PathParam("param") String msg) {
	 
			String output = "Shuti say : " + msg;*/
			
			/*Session session = HibernateUtil.getSessionFactory().openSession();
			  
	        session.beginTransaction();
	 
	        Studentold stu = new Studentold();
	        //stu.setIdStudent(2);
	        stu.setStudentName("vikram");
	        stu.setStudentAge(18);
	        session.save(stu);
	 
	        //session.save(new Employee("Jakab Gipsz",department));
	        //session.save(new Employee("Captain Nemo",department));
	      
	        session.getTransaction().commit();
	 
	        Query q = session.createQuery("From Student ");
	                 
	        List<Studentold> resultList = q.list();
	        System.out.println("num of students:" + resultList.size());
	        for (Studentold next : resultList) {
	            System.out.println("next getEntitystudents: " + next);
	       }*/
			@GET
			@Path("/get")
			@Produces(MediaType.APPLICATION_JSON)
			public String getTrackInJSON() {
		 
				Student stu = new Student();
				//stu.setIdStudent(12);
				stu.setStudentAge(12);
				stu.setStudentName("Aman");
				/*ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(stu);
				return json;*/
				
				Gson gson = new Gson();
				return gson.toJson(stu);
				
		 
			}
			
			/*return Response.status(200).entity(output).build();*/
	 
		}
	 
	//}
	
	

