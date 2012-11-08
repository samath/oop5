package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class creation
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
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
		AccountManager am = (AccountManager) getServletContext().getAttribute("accountManager");
		String name = request.getParameter("name"), password = request.getParameter("password");
		
		try {
			am.insertUser(name, password);
			request.getSession().setAttribute("name", name);
			RequestDispatcher dispatch = request.getRequestDispatcher("home.jsp");
			dispatch.forward(request, response);	
		} catch (AccountExistsException e) {
			RequestDispatcher dispatch = request.getRequestDispatcher("exists.jsp");
			dispatch.forward(request, response);
		}
		
	}

}
