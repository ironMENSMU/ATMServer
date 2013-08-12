package wsdl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PartyCustomerRead {

	//address
	private static final String addressGroupName = "address";
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String state;
	private int postalCode;
	
	//certificate
	private static final String certificateGroupName = "certificate";
	private String certificateNo;
	private String certificateExpiryDate;
	private String certificateIssuer;
	private String certificateType;
	
	//cellphone
	private static final String cellphoneGroupName = "cellphone";
	private String countryCode;
	private int phoneNumber;
	
	private static final String familyNameGroupName = "familyName";
	private String familyName;
	private static final String givenNameGroupName = "givenName";
	private String givenName;
	
	public PartyCustomerRead() {}
	
	public void readDocument(Document doc)
	{
		if(doc != null)
		{
			setCertificateNo(getElementValue(doc, certificateGroupName, "certificateNo"));
			setFamilyName(getElementValue(doc, familyNameGroupName, ""));
			setGivenName(getElementValue(doc, givenNameGroupName, ""));
			//System.out.println(getElementValue(doc, certificateGroupName, "certificateNo"));
			//System.out.println(getElementValue(doc, familyNameGroupName, ""));
			//System.out.println(getElementValue(doc, givenNameGroupName, ""));
			
		}
	}
	
	public String getElementValue(Document doc, String parentId, String elementName)
	{
		String elementValue = null;
        NodeList nodeList = doc.getElementsByTagName(parentId);
        if(!elementName.equals(""))
        {
	        for (int i = 0; i < nodeList.getLength(); i++) {
	            Node node = nodeList.item(i);
	            if (node.getNodeType() == Node.ELEMENT_NODE) {
	                Element element = (Element) node;
	                NodeList nodelist = element.getElementsByTagName(elementName);
	                Element element1 = (Element) nodelist.item(0);
	                NodeList fstNm = element1.getChildNodes();
	                elementValue = (fstNm.item(0)).getNodeValue();
	               }
	        }
        }
        else
        {
            Element element1 = (Element) nodeList.item(0);
            NodeList fstNm = element1.getChildNodes();
            elementValue = (fstNm.item(0)).getNodeValue();
        }
		return elementValue;
	}
	
	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getCertificateExpiryDate() {
		return certificateExpiryDate;
	}

	public void setCertificateExpiryDate(String certificateExpiryDate) {
		this.certificateExpiryDate = certificateExpiryDate;
	}

	public String getCertificateIssuer() {
		return certificateIssuer;
	}

	public void setCertificateIssuer(String certificateIssuer) {
		this.certificateIssuer = certificateIssuer;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	
	/*<?xml version="1.0" encoding="UTF-8"?>
	<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://www.w3.org/2003/05/soap-envelope">
	   <SOAP-ENV:Body>
	      <ServiceMediationOperationResponse xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="">
	         <SMRespMessage xmlns:ns="http://smubank.smu.edu.sg/schemas/serviceResponseMessage/" xmlns:ns0="http://www.w3.org/2003/05/soap-envelope" xmlns="" xsi:type="ns:Content">
	            <Party_Customer_ReadResponse xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns="">
	               <ServiceRespHeader xmlns:ns="http://smubank.smu.edu.sg/schemas/serviceResponseHeader" xmlns:ns0="http://schemas.xmlsoap.org/soap/envelope/" xmlns="" xsi:type="ns:ServiceRespHeader">
	                  <ns:GlobalErrorID>010000</ns:GlobalErrorID>
	                  <ns:ErrorText>invocation successful</ns:ErrorText>
	                  <ns:ErrorDetails/>
	               </ServiceRespHeader>
	               <CDMCustomer xmlns:ns="http://com/bom/party" xmlns:ns0="http://schemas.xmlsoap.org/soap/envelope/" xmlns="" xsi:type="ns:Party">
	                  <address xmlns="">
	                     <streetAddress1 xmlns="">BLK 808, Woodlands St 81</streetAddress1>
	                     <streetAddress2 xmlns="">#07-157</streetAddress2>
	                     <city xmlns="">SG</city>
	                     <state xmlns="">SG</state>
	                     <country xmlns="">SG</country>
	                     <postalCode xmlns="">730808</postalCode>
	                  </address>
	                  <certificate xmlns="">
	                     <certificateNo xmlns="">S1234567C</certificateNo>
	                     <certificateExpiryDate xmlns="">2099-12-31</certificateExpiryDate>
	                     <certificateIssuer xmlns="">Singapore Government</certificateIssuer>
	                     <certificateType xmlns="">IC Number</certificateType>
	                  </certificate>
	                  <profile xmlns="">
	                     <customerType xmlns="">Retail</customerType>
	                     <nationality xmlns="">Singaporean</nationality>
	                     <gender xmlns="">Male</gender>
	                     <ethnicGroup xmlns="">Singaporean</ethnicGroup>
	                     <occupation xmlns="">Student</occupation>
	                     <registerFund xmlns="">Will be removed</registerFund>
	                     <email xmlns="">alanmegargel@smu.edu.sg</email>
	                     <fax xmlns="">68085276</fax>
	                  </profile>
	                  <customer xmlns="">
	                     <customerID xmlns="">0000000209</customerID>
	                  </customer>
	                  <phone xmlns="">
	                     <localNumber xmlns="">68085276</localNumber>
	                     <areaCode xmlns="">+65</areaCode>
	                     <countryCode xmlns="">+65</countryCode>
	                  </phone>
	                  <cellphone xmlns="">
	                     <countryCode xmlns="">+65</countryCode>
	                     <phoneNumber xmlns="">96690924</phoneNumber>
	                  </cellphone>
	                  <maintenacehistory xmlns="">
	                     <lastMaintenanceTellerId xmlns="">123</lastMaintenanceTellerId>
	                     <registrationDate xmlns="">2013-07-09</registrationDate>
	                  </maintenacehistory>
	                  <familyName xmlns="">Blanston</familyName>
	                  <givenName xmlns="">Gern</givenName>
	                  <taxIdentifier xmlns="">L1</taxIdentifier>
	                  <dateOfBirth xmlns="">1989-12-11T00:00:00+08:00</dateOfBirth>
	               </CDMCustomer>
	            </Party_Customer_ReadResponse>
	         </SMRespMessage>
	      </ServiceMediationOperationResponse>
	   </SOAP-ENV:Body>
	</SOAP-ENV:Envelope>
	*/
}
