package vn.iostar.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.config.DBConnectSQL;
import vn.iostar.models.User;
import vn.iostar.services.UserService;
import vn.iostar.services.Imp.UserServiceImp;

@WebServlet(urlPatterns = "/forgotpassword")
public class forgotpassword extends HttpServlet {
	UserService service = new UserServiceImp();
	public Connection conn = null;
	public PreparedStatement ps = null;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String username = req.getParameter("username");

	    if (username != null && !username.isEmpty()) {
	        // Lưu username vào request để chuyển sang form 2
	        req.setAttribute("username", username);
	        // Chuyển tiếp đến form 2 (resetpassword.jsp)
	        req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
	    } else {
	        // Nếu không có username, trả về trang lỗi hoặc thông báo
	        resp.getWriter().println("Please enter a valid username.");
	    }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}
}
