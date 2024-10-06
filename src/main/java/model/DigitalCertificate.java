package model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DigitalCertificate {
    @Id
    @Column(name = "certificate_id")
    private String certificateID;

    @Column(name = "owner_id")
    private String ownerID;

    @Column(name = "token_id")
    private String tokenID;

    @Column(name = "issued_date")
    private Date issuedDate;

    private Boolean revoked;

    // Default constructor
    public DigitalCertificate() {}

    // Parameterized constructor
    public DigitalCertificate(String certificateID, String ownerID, String tokenID, Date issuedDate, Boolean revoked) {
        this.certificateID = certificateID;
        this.ownerID = ownerID;
        this.tokenID = tokenID;
        this.issuedDate = issuedDate;
        this.revoked = revoked;
    }

    // Getters and setters
    public String getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(String certificateID) {
        this.certificateID = certificateID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }
}
