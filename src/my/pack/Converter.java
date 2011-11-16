package my.pack;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String convertedAmount="0";
	public String amount="0";
	public String from="EUR";
	public String to="USD";


	public Converter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		amount = request.getParameter("amount");
		from = request.getParameter("from_currency");
		to = request.getParameter("to_currency");
       if(amount==null)amount="1";
       if(from==null)from="EUR";
       if(to==null)to="USD";
       if(from.compareTo(to)==0){convertedAmount = amount;}
        else{
			ConvertHandler convertHandler = new ConvertHandler();
			convertHandler.parseXml();                    
			
	        DecimalFormat df = new DecimalFormat("#.######");
			
			convertedAmount = df.format(convertHandler.convert(from, to, amount));
		}
		
		request.setAttribute("convertedAmount", convertedAmount);
		request.setAttribute("amount", amount);
		request.setAttribute("from_currency", from);
		request.setAttribute("to_currency", to);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);

	}


}
