package dao_cli;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model.DigitalCertificate;
import util.HibernateUtil; 

public class AddDigitalCertificate {

    public void addDigitalCertificate(DigitalCertificate certificate) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.save(certificate);

            transaction.commit();

            System.out.println("Certificate added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
