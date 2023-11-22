package org.scrum;

import org.scrum.extractors.ClientExtractor;
import org.scrum.extractors.DetaliiExtractor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;






@SpringBootApplication(scanBasePackages = "org.scrum.controllers")
public class test_app extends SpringBootServletInitializer {


	public static void main(String[] args) {

		// creeate a new invoice object
		FileReader fileReader = new FileReader("invoice.pdf");
		fileReader.printInvoiceInfo();

		// create an invoiceDetails object from the invoice obj
		DetaliiExtractor detaliiExtractorFactura = new DetaliiExtractor(fileReader.getText());
		detaliiExtractorFactura.printDetails();

		// create a client object from the invoice object
		ClientExtractor clientExtractor = new ClientExtractor(fileReader.getText());
		clientExtractor.printClientInfo();



		SpringApplication.run(test_app.class, args);
	}


}