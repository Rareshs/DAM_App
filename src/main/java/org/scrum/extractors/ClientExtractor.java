package org.scrum.extractors;
import java.util.logging.Logger;

import lombok.Getter;


@Getter
public class ClientExtractor {
    private final String name;
    private final String address;
    private final String email;
    private static final Logger logger = Logger.getLogger(ClientExtractor.class.getName());

    public ClientExtractor(String invoiceText) {
        // Check if invoiceText is valid (contains "To:")
        if (isValidInvoiceText(invoiceText)) {
            // Perform extraction logic and set properties
            this.name = extractClientName(invoiceText);
            this.address = extractClientAddress(invoiceText);
            this.email = extractClientEmail(invoiceText);
        } else {
            // Handle the case where invoiceText is not valid
            logger.warning("Invalid invoice... could not find client information.");
            this.name = null;
            this.address = null;
            this.email = null;
        }
    }

    private boolean isValidInvoiceText(String invoiceText) {
        return invoiceText != null && invoiceText.contains("To:");
    }

    private String extractClientName(String invoiceText) {
        int toIndex = invoiceText.indexOf("To:");
        if (toIndex != -1) {
            int nextLineIndex = toIndex + 3;
            while (nextLineIndex < invoiceText.length() &&
                    Character.isWhitespace(invoiceText.charAt(nextLineIndex))) {
                nextLineIndex++;
            }

            int lineEndIndex = invoiceText.indexOf('\n', nextLineIndex);
            if (lineEndIndex != -1) {
                return invoiceText.substring(nextLineIndex, lineEndIndex).trim();
            }
        }

        return null;
    }
    private String extractClientAddress(String invoiceText) {
        int toIndex = invoiceText.indexOf("To:");
        int addressStartIndex = toIndex + 3;

        // Skip the first two lines after "To:" to get to the start of the address
        for (int i = 0; i < 2; i++) {
            addressStartIndex = invoiceText.indexOf('\n', addressStartIndex) + 1;
        }

        // Find the end of the address (2 lines long)
        int addressEndIndex = invoiceText.indexOf('\n', addressStartIndex);
        if (addressEndIndex != -1) {
            // Skip the next line to include the second line of the address
            addressEndIndex = invoiceText.indexOf('\n', addressEndIndex + 1) + 1;
            return invoiceText.substring(addressStartIndex, addressEndIndex).trim();
        }

        return null;
    }
    private String extractClientEmail(String invoiceText) {
        int toIndex = invoiceText.indexOf("To:");
        int emailIndex = toIndex + 4; // Start 4 lines after "To:"

        // Skip the first four lines after "To:" to get to the email
        for (int i = 0; i < 4; i++) {
            emailIndex = invoiceText.indexOf('\n', emailIndex) + 1;
        }

        // Find the end of the email (1 line)
        int emailEndIndex = invoiceText.indexOf('\n', emailIndex);
        if (emailEndIndex != -1) {
            return invoiceText.substring(emailIndex, emailEndIndex).trim();
        }

        return null;
    }

    public void printClientInfo() {

            System.out.println("Client Name: " + name);
            System.out.println("Client Address: " + address);
            System.out.println("Client Email: " + email);

    }
}
