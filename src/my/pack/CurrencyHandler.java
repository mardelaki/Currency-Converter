package my.pack;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class CurrencyHandler extends DefaultHandler{
	private static final String EUR = "EUR";
	private static final String CURR_URL = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
	private Map<String,String> currencies = new HashMap<String,String>();
	
	public Map<String,String> getCurrencies(){
		return currencies;
	}

	public String getDefaultMnemonic() {
		return EUR;
	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		if (attributes.getValue("currency") != null//"Cube".equals(localName) && 
				&& attributes.getValue("rate") != null){

				String cur = attributes.getValue("currency");
				//System.out.println("-----------------------"+cur);
				currencies.put(attributes.getValue("currency"),attributes.getValue("rate"));
		}
	}
	
}