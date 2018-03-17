package enversSF;

import java.util.Date;
import enversSF.Customer;
import enversSF.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientTest {

	public static void main(String[] args) {
		Transaction tx = null;
		/*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Customer customer1 = new Customer();
			customer1.setFirstName("AAAAA");
			customer1.setLastName("BBBBB");
			customer1.setDepartment("IT");
			customer1.setSalary("11111111");
			customer1.setCreatedOn(new Date());
			
			Customer customer2 = new Customer();
			customer2.setFirstName("CCCCCC");
			customer2.setLastName("DDDDDDDDD");
			customer2.setDepartment("Sales");
			customer2.setSalary("2222222222");
			customer2.setCreatedOn(new Date());
			
			Customer customer3 = new Customer();
			customer3.setFirstName("EEEEEEEEE");
			customer3.setLastName("FFFFFFFF");
			customer3.setDepartment("Sales");
			customer3.setSalary("333333333");
			customer3.setCreatedOn(new Date());
			
			Customer customer4 = new Customer();
			customer4.setFirstName("GGGGGGG");
			customer4.setLastName("HHHHHHHH");
			customer4.setDepartment("Marking");
			customer4.setSalary("44444444444");
			customer4.setCreatedOn(new Date());
			
			Customer customer5 = new Customer();
			customer5.setFirstName("IIIIIII");
			customer5.setLastName("JJJJJJJJJJ");
			customer5.setDepartment("BPO");
			customer5.setSalary("55555555");
			customer5.setCreatedOn(new Date());

			session.save(customer1);
			session.save(customer2);
			session.save(customer3);
			session.save(customer4);
			session.save(customer5);

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
*/
		 System.out.println("----------Update a Record--------------------");

		 try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		 {
		 	long customerId = 2L;

			Customer customer = session.get(Customer.class, customerId);
			if (customer != null) {
				tx = session.beginTransaction();
				customer.setDepartment("HR");
				customer.setFirstName("Harsh");
				customer.setSalary("99999995");
				session.update(customer);
				tx.commit();
			} 
			else
			{
				System.out.println("Customer details not found in database with ID:" + customerId);
			}

		}
		catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}

		/* System.out.println("----------Delete a Record--------------------");

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			long customerId = 2L;

			Customer customer = session.get(Customer.class, customerId);
			if (customer != null) {
				tx = session.beginTransaction();
				session.delete(customer);
				tx.commit();
			} else {
				System.out.println("Customer details not found in database with ID:" + customerId);
			}

			System.out.println("----------Delete a Record--------------------");

		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}*/
	}
}