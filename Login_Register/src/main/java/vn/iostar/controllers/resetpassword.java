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
@WebServlet(urlPatterns = "/resetpassword")
public class resetpassword extends HttpServlet {
	UserService service = new UserServiceImp();
	public Connection conn = null;
	public PreparedStatement ps = null;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("newPassword");
		String username =req.getParameter("username");
		if ( password !=null) {
			String sql = "UPDATE [User] SET password = ? WHERE username = ? ";
			try {
				conn = new DBConnectSQL().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, password);
				ps.setString(2, username);
				ps.executeUpdate();
				conn.close();
				resp.sendRedirect(req.getContextPath() + "/login");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	//@Override
	//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
	//}
}
