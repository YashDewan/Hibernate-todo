package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NotesTaking;
import com.helper.FactorySetup;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int noteid = Integer.parseInt(request.getParameter("noteid").trim());
			Session s = FactorySetup.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			NotesTaking nt = (NotesTaking)s.get(NotesTaking.class, noteid);
			s.delete(nt);
			tx.commit();
			s.close();
			response.sendRedirect("allnotes.jsp");
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
