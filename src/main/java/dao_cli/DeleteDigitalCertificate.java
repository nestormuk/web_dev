package dao_cli;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model.DigitalCertificate;
import util.HibernateUtil;

public class DeleteDigitalCertificate {

    public void deleteDigitalCertificate(String certificateID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Retrieve the certificate by its ID
            DigitalCertificate certificate = session.get(DigitalCertificate.class, certificateID);

            if (certificate != null) {
                // If certificate is found, delete it
                session.delete(certificate);
                transaction.commit();
                System.out.println("Certificate deleted successfully!");
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
