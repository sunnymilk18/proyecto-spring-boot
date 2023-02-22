package cl.com.apirest.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contract_date", nullable = false)
    private String contractDate;

    @Column(name = "occupation", nullable = false)
    private String occupation;

    @Column(name = "type_contract", nullable = false)
    private String typeContract;

    @Column(name = "salary", nullable = false)
    private int salary;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Contract() {

    }

    public Contract(String contractDate, String occupation, String typeContract, int salary, Company company, User user) {
        this.contractDate = contractDate;
        this.occupation = occupation;
        this.typeContract = typeContract;
        this.salary = salary;
        this.company = company;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", contractDate='" + contractDate + '\'' +
                ", occupation='" + occupation + '\'' +
                ", typeContract='" + typeContract + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                ", user=" + user +
                '}';
    }
}
