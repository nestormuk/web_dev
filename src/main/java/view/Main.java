package view;

import dao_cli.AddDigitalCertificate;
import dao_cli.DeleteDigitalCertificate;
import dao_cli.DisplayDigitalCertificate;
import dao_cli.UpdateDigitalCertificate;
import model.DigitalCertificate;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        
        AddDigitalCertificate addCert = new AddDigitalCertificate();
        DeleteDigitalCertificate deleteCert = new DeleteDigitalCertificate();
        DisplayDigitalCertificate displayCert = new DisplayDigitalCertificate();
        UpdateDigitalCertificate updateCert = new UpdateDigitalCertificate();

        
        DigitalCertificate certificate = new DigitalCertificate(
                "cert-002",
                "owner-002",
                "token-002",
                new Date(System.currentTimeMillis()),
                false
        );

        // Adding a new certificate
        addCert.addDigitalCertificate(certificate);
        
        /*
        // Display the certificate before update
        System.out.println("Before update:");
        displayCert.displayDigitalCertificateByID("cert-001");

        // Update the certificate
        updateCert.updateDigitalCertificate("cert-001", "new-owner-002", "new-token-002", true);

        // Display the certificate after update
        System.out.println("After update:");
        displayCert.displayDigitalCertificateByID("cert-001");

        // Delete the certificate
        deleteCert.deleteDigitalCertificate("cert-001");
		*/
        // Display all certificates after deletion
        displayCert.displayAllDigitalCertificates();
    }
}
