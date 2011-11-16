package my.pack;

import javax.servlet.*;

public class MyListener implements ServletContextListener{
public void contextInitialized(ServletContextEvent event)
{
	ServletContext sc = event.getServletContext();
	String url = sc.getInitParameter("infoUrl");
	sc.setAttribute("url", url);
}
public void contextDestroyed(ServletContextEvent event)
{

}
}