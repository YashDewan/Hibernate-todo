package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.NotesTaking;
import com.helper.FactorySetup;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveNoteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetch :
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			NotesTaking note = new NotesTaking(title,content,new Date());
			 System.out.println("*********************"+note.getId()+"....................");
			Session s = FactorySetup.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			// print in browser : 
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<h1> Saved Successfully </h1> "
					+ "<br/>" + "<a href='allnotes.jsp'>Show all Notes</a>");
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
