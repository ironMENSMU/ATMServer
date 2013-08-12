package servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import wsdl.PartyCustomerRead;
import wsdl.ServiceMediationConnector;

/**
 * Servlet implementation class ESBCommServlet
 */
public class ESBCommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ESBCommServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String NRIC = request.getParameter("NRIC");
		Source smConnector = ServiceMediationConnector.SOAPMessage();
		Document resultDoc = ServiceMediationConnector.sourceToDom(smConnector);
		PartyCustomerRead partyCustomerRead = new PartyCustomerRead();
		partyCustomerRead.readDocument(resultDoc);
		System.out.println(partyCustomerRead.getCertificateNo() + " " + partyCustomerRead.getFamilyName() + " " + partyCustomerRead.getGivenName());
		//System.out.println(PartyCustomerRead.readDocument(resultDoc));
		
		String charset = "UTF-8";
		String query = String.format("certNo=%s&familyName=%s&givenName=%s",
						URLEncoder.encode(partyCustomerRead.getCertificateNo(), charset),
						URLEncoder.encode(partyCustomerRead.getFamilyName(), charset),
						URLEncoder.encode(partyCustomerRead.getGivenName(), charset));
		response.sendRedirect("/UserLoginStatusServlet?"+query);
	}
}
