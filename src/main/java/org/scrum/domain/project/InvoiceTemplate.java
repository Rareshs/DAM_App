package org.scrum.domain.project;
import com.groupdocs.parser.*;
import com.groupdocs.parser.data.PageTextArea;
import com.groupdocs.parser.data.DocumentData;
import java.util.*;

public class InvoiceTemplate extends TemplateInvoice {
    // Parse the PDF Invoice using the defined Template in Java
    Parser parser = new Parser("D://Invoices/invoice.pdf");
    DocumentData data = parser.parseByTemplate(template);
// Print the extracted data
for (int i = 0; i < data.getCount(); i++) {
        // Printing Field Name
        System.out.print(data.get(i).getName() + ": ");
        // Cast PageArea property value to PageTextArea
        // as we have defined only text fields in the template
        PageTextArea area = data.get(i).getPageArea() instanceof PageTextArea
                ? (PageTextArea) data.get(i).getPageArea()
                : null;
        System.out.println(area == null ? "Not a template field" : area.getText());
    }
}
