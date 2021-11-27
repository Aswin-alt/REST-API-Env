package com.aswin.controller;

import com.aswin.model.Person;
import com.aswin.dao.DataStore;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


//import org.json.simple.JSONObject;

/**
 * Servlet implementation class PersonSer
 */
//@WebServlet("/people/*")
public class PersonSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		PrintWriter out = response.getWriter();
		String requestUrl = request.getRequestURI();
		String name = requestUrl.substring("Aswin_REST/people/".length()+1);
		Person person = DataStore.getInstance().getPerson(name);
		JSONObject jsonObject = new JSONObject();
		 
//		 try {
//		 out.println(person.getName());
//		 }
//		 catch(Exception e) {	
//			 System.out.println(e);
//		 }
		
		if(person != null){
			String json = "{\n";
//			json += "\"name\": " + jsonObject.get(person.getName()) + ",\n";
//			json += "\"about\": " + jsonObject.get(person.getAbout()) + ",\n";
			json += "\"name\": " + person.getName() + ",\n";
			json += "\"about\": " + person.getAbout() + ",\n";
			json += "\"birthYear\": " + person.getBirthYear() + "\n";
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			//That person wasn't found, so return an empty JSON object. We could also return an error.
			response.getOutputStream().println("{}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String about = request.getParameter("about");
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
		
		DataStore.getInstance().putPerson(new Person(name, about, birthYear));
	}

}
