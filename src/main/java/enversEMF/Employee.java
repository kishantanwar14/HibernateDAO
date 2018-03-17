package enversEMF;

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
@Entity(name="employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "e_id")
	private int E_id;
	
	@Column(name="firstName", length=100, nullable=false)
	private String E_firstName;
	
	@Column(name="lastName", length=100, nullable=false)
	private String E_lastName;
	
	@Column(name="department", length=100, nullable=false)
	private String E_department;
	
	@Column(name="city", length=100, nullable=false)
	private String E_city;
	
	@Column(name="mob", length=100, nullable=false)
	private String E_mobNo;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;
	
	
	public int getE_id() {
		return E_id;
	}
	public void setE_id(int e_id) {
		E_id = e_id;
	}
	public String getE_firstName() {
		return E_firstName;
	}
	public void setE_firstName(String e_firstName) {
		E_firstName = e_firstName;
	}
	public String getE_lastName() {
		return E_lastName;
	}
	public void setE_lastName(String e_lastName) {
		E_lastName = e_lastName;
	}
	public String getE_department() {
		return E_department;
	}
	public void setE_department(String e_department) {
		E_department = e_department;
	}
	public String getE_city() {
		return E_city;
	}
	public void setE_city(String e_city) {
		E_city = e_city;
	}
	public String getE_mobNo() {
		return E_mobNo;
	}
	public void setE_mobNo(String e_mobNo) {
		E_mobNo = e_mobNo;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}