package my.pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Redirector extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Redirector() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
	//	PrintWriter out = response.getWriter();
		//String url = (String)getServletContext().getInitParameter("infoUrl");
		String url = (String)getServletContext().getAttribute("url");
		response.sendRedirect(url);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
