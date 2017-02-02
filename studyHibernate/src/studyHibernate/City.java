package studyHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CITY")
public class City {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cityId;
	@Column(name="name",nullable=false)
	private String name;
	
	//indicar para hibernate que a cidade contém vários estudantes
	@OneToMany(cascade=CascadeType.ALL, mappedBy="city")
	private Set<Student_Info> students = new HashSet<Student_Info>(0);
	
	
	public Set<Student_Info> getStudents() {
		return students;
	}
	public void setStudents(Set<Student_Info> students) {
		this.students = students;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
