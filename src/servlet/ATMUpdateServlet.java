package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ATMUpdateServlet
 */
public class ATMUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ATMUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ATM_ID = request.getParameter("id");

		String updateCommand = request.getParameter("update");
		String deleteCommand = request.getParameter("delete");

		String num_of_10s = request.getParameter("num_of_10s");
		String num_of_50s = request.getParameter("num_of_50s");

		int numOf10s = Integer.parseInt(num_of_10s);
		int numOf50s = Integer.parseInt(num_of_50s);

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Getting a connection to the database.
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ATMDatabase", "atmUser","password");

			// Creating a statement object
			Statement stmt = connection.createStatement();

			// different implement for update and delete
			if (updateCommand != null) {
				String updateQuery = "update atmdatabase.atmstatus set NumOf10s="
						+ numOf10s
						+ ",NumOf50s="
						+ num_of_50s
						+ " where ID="
						+ ATM_ID;
				stmt.executeUpdate(updateQuery);
			} else {
				String updateQuery = "delete from atmdatabase.atmstatus where ID="
						+ ATM_ID;
				stmt.executeUpdate(updateQuery);
			}

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		response.sendRedirect("ATMmonitor.jsp?msg=success");

	}

}
