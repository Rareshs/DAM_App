package org.scrum.extractors;
import lombok.Getter;




@Getter
public class DetaliiExtractor {
    private String invoiceNumber;
    private String orderNumber;
    private String invoiceDate;
    private String dueDate;

    private String totalDue;

    // Constructor
    public DetaliiExtractor(String invoiceText) {
        // invoice nr
        this.setInvoiceNumber(extractValue(invoiceText, "Invoice Number"));
        // Order nr
        this.setOrderNumber(extractValue(invoiceText, "Order Number"));
        // Invoice Date
        this.setInvoiceDate(extractValue(invoiceText, "Invoice Date"));
        // Due Date
        this.setDueDate(extractValue(invoiceText, "Due Date"));
        // Total Due
        this.setTotalDue(extractTotalDue(invoiceText));
    }



    private static String extractValue(String invoiceText, String keyword) {
        int keywordIndex = invoiceText.indexOf(keyword);
        if (keywordIndex != -1) {
            int valueStartIndex = keywordIndex + keyword.length() + 1; // +1 to skip the space after the keyword
            int valueEndIndex = invoiceText.indexOf('\n', valueStartIndex);
            if (valueEndIndex != -1) {
                return invoiceText.substring(valueStartIndex, valueEndIndex).trim();
            }
        }
        return null; // iiif no text is found, return null :D
    }

    private static String extractTotalDue(String invoiceText) {
        String totalDueString = extractValue(invoiceText, "Total Due");
        if (totalDueString != null && !totalDueString.isEmpty()) {
            return totalDueString.replace("$", "").trim();
        }
        return null;// iiif no text is found, return null ...as above
    }



    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setTotalDue(String totalDue) {
        this.totalDue = totalDue;
    }

    public void printDetails() {
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Invoice Date: " + invoiceDate);
        System.out.println("Due Date: " + dueDate);
        System.out.print("Total Due: "+ totalDue);
    }
}


