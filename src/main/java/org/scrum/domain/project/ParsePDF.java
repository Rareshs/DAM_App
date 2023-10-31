package org.scrum.domain.project;
import com.groupdocs.parser.*;
import com.groupdocs.parser.data.*;
public class ParsePDF extends InvoiceTemplate {
    Parser parser = new Parser("D://Invoices/invoice.pdf");
    DocumentData data = parser.parseByTemplate(template);
}
