package my.pack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCode() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/rar");
		response.setHeader("Content-Disposition","attachment;filename=currency_converter2.rar"); 
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream("/currency_converter2.rar");
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		OutputStream os = response.getOutputStream();
		while((read = is.read(bytes)) != -1){
			os.write(bytes,0,read);
		}
		os.flush();
		os.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
