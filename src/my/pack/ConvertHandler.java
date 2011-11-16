package my.pack;

import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ConvertHandler {

	final CurrencyHandler handler = new CurrencyHandler();

	public void parseXml() {
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// saxParser.parse("C:/workspace/currency_converter2/NewFile.xml",
			// handler);
			saxParser
					.parse("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml",
							handler);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, String> getCurrencies() {
		return handler.getCurrencies();
	}

	public double convert(String fromCurr, String toCurr, String Amount) {
		Double AmountD = 0.0;
		Double convertedamount = 0.0;
		Double convertToOther = 0.0;
		try {
			AmountD = Double.parseDouble(Amount);

			if (fromCurr.equalsIgnoreCase("EUR")) {
				if (toCurr.equalsIgnoreCase("EUR")) {
					convertedamount = AmountD;
					System.out
							.println("convertToOther :: -----------------------"
									+ convertToOther);
				} else {

					convertedamount = AmountD
							* (Double.parseDouble(getCurrencies().get(toCurr)));
					System.out
							.println("convertedamount :: -----------------------"
									+ convertedamount);
				}

			} else {

				if (toCurr.equalsIgnoreCase("EUR")) {
					// edw allh methodos gia alla nomismata
					convertToOther = (1 / Double.parseDouble(getCurrencies()
							.get(fromCurr)));
					convertedamount = convertToOther * AmountD;
					System.out
							.println("convertToOther :: -----------------------"
									+ convertToOther);
				} else {
					// edw allh methodos gia alla nomismata
					convertToOther = (1 / Double.parseDouble(getCurrencies()
							.get(fromCurr)))
							* (Double.parseDouble(getCurrencies().get(toCurr)));
					convertedamount = convertToOther * AmountD;
					System.out
							.println("convertToOther :: -----------------------"
									+ convertToOther);
				}

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertedamount;
	}

}
