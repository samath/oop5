package servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCart
 */
@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		Collection<String> ids = new HashSet<String>();
		//Necessary to prevent java.util.ConcurrentModificationException
		for(String id : cart.getAllIDs()) { ids.add(id); }
		for(String id : ids) {
			try {
				int quantity = Integer.parseInt(request.getParameter(id).trim());
				cart.updateQuantity(id, quantity);
			} catch (NumberFormatException e) { /* empty */ }
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("cart.jsp");
		dispatch.forward(request, response);
	}

}
