import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParseTest {
	public static void main(String[] args) throws IOException {
		String file = "C:/mnwise/parseChar.xml";
		try {
			parseTest(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void parseTest(String xml) throws Exception {
	   try {
		   File fXmlFile = new File(xml);
		   
		   if (fXmlFile.length() == 0) {
				System.err.println("Input Filename...");
				System.exit(1);
			}
		   
		   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		   Document doc = dBuilder.parse(fXmlFile);
		   doc.getDocumentElement().normalize();
			  
		   System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		   NodeList nList = doc.getElementsByTagName("htmlCode");
		   System.out.println("-----------------------");
			  
		   for (int temp = 0; temp < nList.getLength(); temp++) {
			   Node nNode = nList.item(temp);
			   //if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				   Element eElement = (Element) nNode;
				   System.out.println("First Name : " + getTagValue("code", eElement));
				   System.out.println("Last Name : " + getTagValue("value", eElement));
			   //}
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
