package org.scrum;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import lombok.Getter;
@Getter
public class FileReader {
    private final String fileName;
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());
    private final String text;

    public FileReader(String fileName) {
        this.fileName = fileName;
        this.text = readInvoiceText();
    }

    private String readInvoiceText() {
        String baseDir = System.getProperty("user.dir");
        String filePath = baseDir + File.separator + this.fileName;

        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            return pdfTextStripper.getText(document);
        } catch (IOException e) {
            // Log the exceptions if any
            logger.warning("Error reading the invoice text: " + e.getMessage());
            return null;
        }
    }

    // Print info about the invoice
    public void printInvoiceInfo() {
        System.out.println("Nume factura: " + fileName);
    }
}
