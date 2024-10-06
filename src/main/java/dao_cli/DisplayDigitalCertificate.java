package dao_cli;

import org.hibernate.Session;
import org.hibernate.query.Query;
import model.DigitalCertificate;
import util.HibernateUtil;

import java.util.List;

public class DisplayDigitalCertificate {

    // Method to display a single certificate by its ID
    public void displayDigitalCertificateByID(String certificateID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Retrieve the certificate by its ID
            DigitalCertificate certificate = session.get(DigitalCertificate.class, certificateID);

            if (certificate != null) {
                System.out.println("Certificate Details:");
                System.out.println("Certificate ID: " + certificate.getCertificateID());
                System.out.println("Owner ID: " + certificate.getOwnerID());
                System.out.println("Token ID: " + certificate.getTokenID());
                System.out.println("Issued Date: " + certificate.getIssuedDate());
                System.out.println("Revoked: " + certificate.getRevoked());
            } else {
                System.out.println("Certificate with ID: " + certificateID + " not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to display all digital certificates
    public void displayAllDigitalCertificates() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Query to retrieve all DigitalCertificate objects
            Query<DigitalCertificate> query = session.createQuery("FROM DigitalCertificate", DigitalCertificate.class);
            List<DigitalCertificate> certificates = query.getResultList();

            if (!certificates.isEmpty()) {
                System.out.println("List of Digital Certificates:");
                for (DigitalCertificate certificate : certificates) {
                    System.out.println("------------------------------");
                    System.out.println("Certificate ID: " + certificate.getCertificateID());
                    System.out.println("Owner ID: " + certificate.getOwnerID());
                    System.out.println("Token ID: " + certificate.getTokenID());
                    System.out.println("Issued Date: " + certificate.getIssuedDate());
                    System.out.println("Revoked: " + certificate.getRevoked());
                }
            } else {
                System.out.println("No certificates found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
