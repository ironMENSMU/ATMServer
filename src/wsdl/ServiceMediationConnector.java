package wsdl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.wsdl.WSDLException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.net.*;

public class ServiceMediationConnector {
	private static final String wsdlPath = "wsdl/ServiceMediation.wsdl";
	// private static final String soapFilepath =
	// "wsdl/Party_Customer_Read.xml";
	//private static final String soapFilepath = "http://localhost:8080/ATMServer/wsdl/Party_Customer_Read.xml";
	private static String soapFilepath = "";
	private static final String soapVersion = SOAPConstants.SOAP_1_2_PROTOCOL;
	private static final String serviceName = "ServiceMediationService";
	private static final String portName = "ServiceMediationHTTPEndpoint";
	private static final String operationName = "ServiceMediationOperation";
	private static final String soapActionURI = "/ServiceMediationService.serviceagent/ServiceMediationHTTPEndpoint/ServiceMediationOperation";
	private static final String soapAddressLocation = "http://10.0.106.169:4567/ServiceMediation";

	public static Source SOAPMessage() {

		Scanner in = new Scanner(System.in);
		Source sourceContent = null;
		SOAPConnection connection = null;
		try {
			//InetAddress localIP = InetAddress.getLocalHost();
			soapFilepath = getHostAddress() + "/wsdl/Party_Customer_Read.xml";
			// "/ATMServer/wsdl/PartyCustomer_Read.xml";
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory
					.newInstance();
			connection = soapConnFactory.createConnection();
			// Next, create the actual message
			MessageFactory mf = MessageFactory.newInstance(soapVersion);
			SOAPMessage message = mf.createMessage();
			message.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");

			// Create objects for the message parts
			SOAPPart soapPart = message.getSOAPPart();

			// Create a document object to read and store content from the soap
			// request file
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			// Document doc = builder.newDocument();
			// InputStream is =
			// ServiceMediationConnector.class.getResourceAsStream(soapFilepath);
			// Document document = builder.parse(new InputSource(is));
			Document document = builder.parse(soapFilepath);
			DOMSource domSource = new DOMSource(document);

			// Set the soap content with the document
			soapPart.setContent(domSource);

			// remove soap header-optional
			SOAPHeader header = message.getSOAPHeader();
			header.detachNode();
			MimeHeaders headers = message.getMimeHeaders();
			headers.addHeader("SOAPAction", soapActionURI);

			// Save all changes
			message.saveChanges();

			// Print the request
			System.out.println("\nREQUEST:\n");
			message.writeTo(System.out);
			System.out.println();

			// Send the message and get a reply
			// Set the destination
			URL urlEndpoint = new URL(soapAddressLocation);

			// Send the request
			SOAPMessage reply = connection.call(message, urlEndpoint);

			// Print the response
			System.out.println("\nRESPONSE:\n");

			// Create the transformer
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "3");

			// Extract the content of the reply
			sourceContent = reply.getSOAPPart().getContent();
		} catch (SOAPException | SAXException | ParserConfigurationException
				| UnsupportedOperationException | IOException
				| TransformerFactoryConfigurationError
				| IllegalArgumentException | TransformerException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sourceContent;
	}

	public static Document sourceToDom(Source s) {
		DOMResult r = new DOMResult();
		try {
			TransformerFactory.newInstance().newTransformer().transform(s, r);
		} catch (TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Document) r.getNode();
	}
	
	public static String getHostAddress() {
		try {
			String hostAddress = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/ATMServer";
			return hostAddress;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
