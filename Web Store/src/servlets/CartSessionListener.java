package servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CartSessionListener
 *
 */
@WebListener
public class CartSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CartSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
	public void sessionCreated(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        session.setAttribute("cart", new ShoppingCart());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
