package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class LoginContextListener
 *
 */
@WebListener
public class LoginContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoginContextListener() {
        // empty
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
	public void contextInitialized(ServletContextEvent arg0) {
        ServletContext context = arg0.getServletContext();
        context.setAttribute("accountManager", new AccountManager());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
	public void contextDestroyed(ServletContextEvent arg0) {
        // empty
    }
	
}
