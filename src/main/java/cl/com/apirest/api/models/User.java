package cl.com.apirest.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_last_name", nullable = false)
    private String lastName;

    @Column(unique = true, name = "user_rut", nullable = false)
    private String rut;


    @Column(name = "user_birthdate", nullable = false)
    private String birthdate;

    @Size(max = 15)
    @Column(name = "user_contact_number", nullable = false)
    private String contactNumber;

    @Email
    @Column(name = "user_email", nullable = false)
    private String email;

    @OneToOne(mappedBy = "user")
    private Contract contract;

    public User() {

    }

    public User(String userName, String lastName, String rut, String birthdate, String contactNumber, String email, Contract contract) {
        this.userName = userName;
        this.lastName = lastName;
        this.rut = rut;
        this.birthdate = birthdate;
        this.contactNumber = contactNumber;
        this.email = email;
        this.contract = contract;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rut='" + rut + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", contract=" + contract +
                '}';
    }
}
