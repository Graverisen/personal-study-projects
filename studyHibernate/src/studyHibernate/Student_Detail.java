package studyHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="STUDENTDETAIL")
public class Student_Detail {
	@Id	
	@GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator",strategy="foreign",parameters={@Parameter(value="student",name="property")})
	private int rollNum;
	
	@Column(name="resume",nullable=false)
	private String resume;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rollNum")
	private Student_Info student;
	
		
	public Student_Info getStudent() {
		return student;
	}

	public void setStudent(Student_Info student) {
		this.student = student;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	
}
