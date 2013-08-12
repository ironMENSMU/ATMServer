package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.action.HttpConnector;

/**
 * Servlet implementation class ATMInitializerServerSide
 */
public class ATMInitializerServerSide extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ATMInitializerServerSide() {
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
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);


	}
	
	public void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ipAddress = request.getParameter("ipAddress");
		String toUrl = "http://"+ipAddress+":8080/ATMClient/ATMInitializerClientSide";
		String ATM_ID = request.getParameter("id");
		Connection connection = null;
		String query = "";
		try {
			// Loading the JDBC driver for MySql
			Class.forName("com.mysql.jdbc.Driver");

			// remember to change location url to admin server's url
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ATMDatabase", "atmUser",
					"password");

			// Creating a statement object
			Statement stmt = connection.createStatement();

			// Executing the query and getting the result set
			String retrieveQuery = "select * from atmdatabase.atmstatus where ID="
					+ ATM_ID;
			ResultSet rs = stmt.executeQuery(retrieveQuery);
			String responseFromServer = "";

			String charset = "UTF-8";

			if (!rs.next()) {// This means there's no duplicated ATM ID in the
								// database and the initialization can proceed

				String location = request.getParameter("location");
				String lat = request.getParameter("lat");
				String lon = request.getParameter("lon");
				double locationLat = Double.parseDouble(lat);
				double locationLon = Double.parseDouble(lon);

				String status = "online";
				
				String insertQuery = "insert into atmdatabase.atmstatus values ('"
						+ ATM_ID
						+ "','"
						+ location
						+ "',"
						+ 100
						+ ","
						+ 50
						+ ",'"
						+ status
						+ "','"
						+ ipAddress
						+ "',"
						+ locationLat
						+ "," + locationLon + ")";
				
				// have to create new statement because stmt has closed
				Statement stmt2 = connection.createStatement();
				stmt2.executeUpdate(insertQuery);

				responseFromServer = "success";

				query = String
						.format("responseFromServer=%s&id=%s&location=%s&numOf10s=%s&numOf50s=%s",
								URLEncoder.encode(responseFromServer, charset),
								URLEncoder.encode(ATM_ID, charset),
								URLEncoder.encode(location, charset),
								URLEncoder.encode("100", charset),
								URLEncoder.encode("50", charset));


			} else {
				// ATM id is duplicated
				responseFromServer = "failure";
				query = String.format("responseFromServer=%s",
						URLEncoder.encode(responseFromServer, charset));

			
			}

			// close the resultset, statement and connection.
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		response.sendRedirect(toUrl+"?"+query);
	}
}
