package studyHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {

	public static void main(String[] args) {
		Student_Info student = new Student_Info();
		Student_Info student2 = new Student_Info();
		Student_Detail studentDet = new Student_Detail();
		Student_Detail studentDet2 = new Student_Detail();
		
		City city = new City();
		city.setName("Belo Horizonte");
		
		Certification cert = new Certification();
		cert.setName("PMP");
		
		
		student.setCity(city);
		student.setName("Mirian");
		student.setBirthDate(new Date());
		student.getCerts().add(cert);
		studentDet.setResume("curso superior");
		studentDet.setStudent(student);
		
		student2.setCity(city);
		student2.setName("Leandro");
		student2.getCerts().add(cert);
		student2.setBirthDate(new Date());	
		studentDet2.setResume("curso superior");
		studentDet2.setStudent(student2);
		
		
				
		//HIBERNATE!
		//one to one
		/*SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(studentDet);
		session.save(studentDet2);
		session.getTransaction().commit();
		session.close();
		sf.close();*/

		
		//one to many
		city.getStudents().add(student);
		city.getStudents().add(student2);
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(student);
		session.save(student2);
		session.getTransaction().commit();
		
		//select
		student = (Student_Info) session.get(Student_Info.class, 1);
		System.out.println("ALUNO: "+ student.getName());
		
		//update
		student.setName("Mirian Silveira");
		session.update(student);
		System.out.println("ALUNO DEPOIS DO UPDATE: "+ student.getName());
		
		
		session.close();
		sf.close();
		
		
	}

}
