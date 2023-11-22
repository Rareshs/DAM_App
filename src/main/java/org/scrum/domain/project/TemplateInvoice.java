package org.scrum.domain.project;
import com.groupdocs.*;
import com.groupdocs.parser.data.Size;
import com.groupdocs.parser.templates.*;
import com.groupdocs.parser.data.Rectangle;
import com.groupdocs.parser.data.Point;
import com.groupdocs.parser.data.Size;
import java.util.Arrays;

public class TemplateInvoice {
    // Create Template to Parse Data from Invoice using Java
// First create Template Items
    TemplateItem[] templateItems = new TemplateItem[]
            {
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 135), new Size(100, 10))), "FromCompany"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 150), new Size(100, 35))), "FromAddress"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 190), new Size(150, 2))), "FromEmail"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 250), new Size(100, 2))), "ToCompany"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 260), new Size(100, 15))), "ToAddress"),
                    new TemplateField(new TemplateFixedPosition(new Rectangle(new Point(35, 290), new Size(150, 2))), "ToEmail"),
                    new TemplateField(new TemplateRegexPosition("Invoice Number"), "InvoiceNumber"),
                    new TemplateField(new TemplateLinkedPosition(
                            "InvoiceNumber",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "InvoiceNumberValue"),
                    new TemplateField(new TemplateRegexPosition("Order Number"), "InvoiceOrder"),
                    new TemplateField(new TemplateLinkedPosition(
                            "InvoiceOrder",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "InvoiceOrderValue"),
                    new TemplateField(new TemplateRegexPosition("Invoice Date"), "InvoiceDate"),
                    new TemplateField(new TemplateLinkedPosition(
                            "InvoiceDate",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "InvoiceDateValue"),
                    new TemplateField(new TemplateRegexPosition("Due Date"), "DueDate"),
                    new TemplateField(new TemplateLinkedPosition(
                            "DueDate",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "DueDateValue"),
                    new TemplateField(new TemplateRegexPosition("Total Due"), "TotalDue"),
                    new TemplateField(new TemplateLinkedPosition(
                            "TotalDue",
                            new Size(200, 15),
                            new TemplateLinkedPositionEdges(false, false, true, false)),
                            "TotalDueValue")
            };
    // Transform into template
    Template template = new Template(Arrays.asList(templateItems));
}
