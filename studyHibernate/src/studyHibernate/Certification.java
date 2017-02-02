package studyHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CERTIFICATION")
public class Certification 
{

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int certId;
	@Column(name="name",nullable=false)
	private String name;
	
	
	//indicar para hibernate que a certificação contém vários estudantes
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Student_Info> students = new HashSet<Student_Info>(0);
	
	
	public Set<Student_Info> getStudents() {
		return students;
	}
	public void setStudents(Set<Student_Info> students) {
		this.students = students;
	}
	
	
	public int getCertId() {
		return certId;
	}
	public void setCertId(int certId) {
		this.certId = certId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
