package com.servlets;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NotesTaking;
import com.helper.FactorySetup;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noteid = Integer.parseInt(request.getParameter("noteid").trim());
		System.out.println("---------------------  "+noteid+"  --------");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("---------------------------------------"+noteid);
		Session s = FactorySetup.getFactory().openSession();
		System.out.println("---------------------------------------"+noteid);
		Transaction tx = s.beginTransaction();
		NotesTaking nt = (NotesTaking)s.get(NotesTaking.class, noteid);
		System.out.println("---------------------------------------"+noteid);
		nt.setTitle(title);
		nt.setContent(content);
		nt.setDate(new Date());
		tx.commit();
		s.close();
		response.sendRedirect("allnotes.jsp");
	}

}
