package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wsdl.ServiceMediationConnector;

import model.ATMServer;
import model.action.HttpConnector;

/**
 * Servlet implementation class UserLoginStatusServlet
 */
public class UserLoginStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginStatusServlet() {
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
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);

	}
	
	public void process (HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		
		String toUrl = request.getParameter("fromUrl");
		String nric = request.getParameter("NRIC");
		String certNo = request.getParameter("certNo");
		String familyName = request.getParameter("familyName");
		String givenName = request.getParameter("givenName");
		
		String charset = "UTF-8";

		String responseFromAdmin = "";
		System.out.println(nric);
		if(ATMServer.isDuplicate(nric)){
			//same NRIC is used currently
			responseFromAdmin = "failure";
			String query = String.format("responseFromServer=%s",
					URLEncoder.encode(responseFromAdmin, charset));
			//HttpConnector.buildHttpConnection(toUrl, query);
			response.sendRedirect(toUrl+"?"+query);
		}else{
			
			if(certNo == null || familyName == null || givenName == null)
			{
				String query = String.format("NRIC=%s", URLEncoder.encode(nric, charset));
				String url = ServiceMediationConnector.getHostAddress();
				response.sendRedirect(url + "/ESBCommServlet?"+query);
			}
			else
			{
				ATMServer.addUser(nric);
				responseFromAdmin = "success";
				String query = String.format("responseFromServer=%s&certNo=%s&familyName=%s&givenName=%s",
						URLEncoder.encode(responseFromAdmin, charset),
						URLEncoder.encode(certNo, charset),
						URLEncoder.encode(familyName, charset),
						URLEncoder.encode(givenName, charset));
				response.sendRedirect(toUrl+"?"+query);
			}
			
		}
		// prepare query in response to loginServlet
		//System.out.println(toUrl);

	}

}
