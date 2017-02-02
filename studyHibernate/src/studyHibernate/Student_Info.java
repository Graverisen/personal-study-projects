package studyHibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="STUDENT")
public class Student_Info {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rollNum;
	
	//@Transient - faz o hibernate ignorar a coluna
	@Column(name="name",nullable=false)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private City city;
	
	
	//indicar para hibernate que o estudante contém várias certificações
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Certification> certs = new HashSet<Certification>(0);
	
	
	
	public Set<Certification> getCerts() {
		return certs;
	}
	public void setCerts(Set<Certification> certs) {
		this.certs = certs;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	
}
