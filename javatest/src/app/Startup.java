package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.*;
import generated.GreetingListType;
import generated.GreetingType;
import generated.ObjectFactory;

public class Startup {

	/**
	 * @param args
	 * @return 
	 */
	public static void main (final String[] args) {
		// TODO Auto-generated method stub

		try {

			ObjectFactory of = new ObjectFactory();
			GreetingListType glt = of.createGreetingListType();
			GreetingType gt = of.createGreetingType();
			gt.setLanguage("French");
			gt.setText("Bonjour");
			glt.getGreeting().add(gt);
			glt.getGreeting().add(gt);
			glt.getGreeting().add(gt);

			JAXBElement<GreetingListType> jbe = of.createGreetings(glt);

			JAXBContext jc = JAXBContext.newInstance("generated");
			Marshaller m = jc.createMarshaller();
			try {
				m.marshal(jbe, new FileOutputStream("hello.xml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
