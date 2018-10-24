package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserDeleteConfirmServlet
 */
@WebServlet("/UserDeleteConfirmServlet")
public class UserDeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		Connection conn = null;
		User user = null;
		conn = DBManager.getConnection();

		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		try {

			UserDao dao = new UserDao();
			int num = Integer.parseInt(idStr);
			ResultSet rs = dao.loginId(num);


			if (rs.next()) {
				String loginId = rs.getString("login_id");
				user = new User(loginId);



				request.setAttribute("reference3", user);
			}



		} catch (SQLException e) {
		e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDeleteConfirm.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String ok = request.getParameter("ok");

		if (ok != null) {
			UserDao dao = new UserDao();
			dao.infoDelete(loginId);
		}

		response.sendRedirect("UserListServlet");
	}
}