package enversSF;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Audited
@Entity(name = "customer")
public  class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name",length=100,nullable=false)
    private String firstName;

    @Column(name="last_name",length=100,nullable=false)
    private String lastName;
    
    
    
    
    @Column(name="sal",length=100,nullable=false)
    private String salary;
    
    @Column(name="dept",length=100,nullable=false)
    private String department;

    
    
    
    @Temporal(TemporalType.TIMESTAMP )
    @Column(name = "created_on")
    private Date createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", department=" + department + ", createdOn=" + createdOn + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getCreatedOn()="
				+ getCreatedOn() + ", getSalary()=" + getSalary() + ", getDepartment()=" + getDepartment() + "]";
	}

	

	
}