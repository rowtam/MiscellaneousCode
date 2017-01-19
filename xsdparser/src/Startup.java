import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

import com.sun.xml.internal.xsom.XSSchemaSet;
import com.sun.xml.internal.xsom.parser.*;

public class Startup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		
		XSOMParser parser = new XSOMParser();
		try {
			parser.parse(new File("MySchema.xsd"));
			XSSchemaSet xss = parser.getResult();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
