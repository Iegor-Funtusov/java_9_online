package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;

import java.util.List;

public class DepartmentDao {

    private final SessionFactory sessionFactory = new Configuration().buildSessionFactory();

    public void create(Department department) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            session.persist(department);
            department.setName("fsfgasdgfa");
            session.merge(department);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
//        session.persist(new Department());
        return sessionFactory.getCurrentSession().createQuery("from Employee ").getResultList();
    }
}
