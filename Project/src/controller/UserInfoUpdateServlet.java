package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateServlet() {
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
			ResultSet rs = dao.loginId2(num);

			if (rs.next()) {
				String loginId = rs.getString("login_id");
				String pass = rs.getString("password");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				user = new User(loginId, pass, id, name, birthDate, createDate, updateDate);
			}



			request.setAttribute("reference2", user);
		} catch (SQLException e) {
			e.printStackTrace();
			}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userInfoUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		String passwordCheck = request.getParameter("passCheck");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		UserDao dao = new UserDao();
		Boolean user2 = dao.infoUpdate(loginId, pass, name, birthDate);



		if (user2 != true || !pass.equals(passwordCheck) ) {


			User us = new User(loginId, name, convertDate2(birthDate));
			request.setAttribute("keep2", us);

			request.setAttribute("errMsg2", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userInfoUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		response.sendRedirect("UserListServlet");
	}

	private Date convertDate2(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formatDate;
		try {
			formatDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		return formatDate;

	}
}