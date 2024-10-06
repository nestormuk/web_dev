package dao_cli;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model.DigitalCertificate;
import util.HibernateUtil;

public class UpdateDigitalCertificate {

    public void updateDigitalCertificate(String certificateID, String newOwnerID, String newTokenID, boolean isRevoked) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Retrieve the certificate by ID
            DigitalCertificate certificate = session.get(DigitalCertificate.class, certificateID);

            if (certificate != null) {
                // Update the fields
                certificate.setOwnerID(newOwnerID);
                certificate.setTokenID(newTokenID);
                certificate.setRevoked(isRevoked);

                // Update the certificate in the database
                session.update(certificate);

                // Commit the transaction
                transaction.commit();

                System.out.println("Certificate updated successfully!");
            } else {
                System.out.println("Certificate with ID: " + certificateID + " not found.");
            }

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
