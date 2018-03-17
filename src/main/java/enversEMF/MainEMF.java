package enversEMF;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainEMF {

	public static void main(String[] args) 
	{
		//create();
		//read();
		update();	/*insert();*/
		//delete();
	}

	public static void create()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enversEMF");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("--------- Starting Update Method-------------");
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		//id Auto Increment
		emp1.setE_firstName("A");
		emp1.setE_lastName("Z");
		emp1.setE_city("Delhi");
		emp1.setE_department("IT");
		emp1.setE_mobNo("99999999999");
		emp1.setCreatedOn(new Date());
		empList.add(emp1);
		em.persist(emp1);
		
		Employee emp2 = new Employee();
		//id Auto Increment
		emp2.setE_firstName("B");
		emp2.setE_lastName("Y");
		emp2.setE_city("Chandigarh");
		emp2.setE_department("Medical");
		emp2.setE_mobNo("888888888888");	
		emp2.setCreatedOn(new Date());
		empList.add(emp2);
		em.persist(emp2);
		
		Employee emp3 = new Employee();
		//id Auto Increment
		emp3.setE_firstName("C");
		emp3.setE_lastName("X");
		emp3.setE_city("Banglore");
		emp3.setE_department("Sales");
		emp3.setE_mobNo("77777777777");
		emp3.setCreatedOn(new Date());
		empList.add(emp3);
		em.persist(emp3 );
		
		em.getTransaction().commit();
		em.close();
		emf.close();	
		}
	
	public static void read()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enversEMF");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("--------- Starting Insert Method-------------");
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee ee : empList)
		{
			System.out.println("First Name :"+ee.getE_firstName());
			System.out.println("Last Name :"+ee.getE_lastName());
			System.out.println("City :" +ee.getE_city());
			System.out.println("Department:"+ee.getE_department());
			System.out.println("Mobile No:"+ee.getE_mobNo());
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();	
	}
	
	
	public static void update() 
    {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enversEMF");
		EntityManager em = emf.createEntityManager();
		System.out.println("--------------Starting Update----------");
		em.getTransaction().begin();
		
		String hql = "update employee e set e.E_department=:dname where e.id=1";
		Query query = em.createQuery(hql);
		query.setParameter("dname", "Sportssssss");
		
		
		int updateCount = query.executeUpdate();
		
		if (updateCount > 0) {
			System.out.println("Done...");
		}
		
		//em.persist(updateCount);
		
		em.getTransaction().commit();
        em.close();
	    emf.close();
    }
    
    
   public static void delete()
   {
	   	EntityManagerFactory emf = Persistence.createEntityManagerFactory("enversEMF");
		EntityManager em = emf.createEntityManager();
		System.out.println("------------Starting Deletion-----------");
		em.getTransaction().begin();
		
		String hql="delete from Employee e where e.E_id=3";  
		Query query=em.createQuery(hql);
		query.executeUpdate(); 
		
	//	Employee emp = (Employee)em.find(Employee.class, 5);
	  //  em.remove(emp);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
        
   }
	
	
	
	/*public static void delete()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enversEMF");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println("--------- Starting Delete Method-------------");
		
		Employee emp = (Employee)em.find(Employee.class, 2);
		em.remove(emp);
		
		em.getTransaction().commit();
		em.close();
		emf.close();	
	}*/
}