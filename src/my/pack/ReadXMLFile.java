package my.pack;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {
		
	public static void main(String argv[]) {
		 
		  try {
	 
			File fXmlFile = new File("C:/workspace/currency_converter2/daily_currencies.xml");
			//File fXmlFile = new File("C:/workspace/currency_converter2/NewFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			//doc.getDocumentElement().normalize();
	 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList =  doc.getElementsByTagName("Cube");
			System.out.println("-----------------------");
	 
			int i = nList.getLength();
			for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			   Node nNode = nList.item(temp);
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
			      Element eElement = (Element) nNode;
	 
			      System.out.println( eElement.getAttribute("currency"));
			      System.out.println( eElement.getAttribute("Cube"));
			      System.out.println( eElement.getNodeValue());
			      System.out.println("First Name : " + getTagValue("Cube", eElement));
			      System.out.println("Last Name : " + getTagValue("currency", eElement));
		              System.out.println("Nick Name : " + getTagValue("nickname", eElement));
			      System.out.println("Salary : " + getTagValue("salary", eElement));
	 
			   }
			}
		  } catch (Exception e) {
			e.printStackTrace();
		  }
	  }
	 
	  private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 
	        Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeValue();
	  }

}
