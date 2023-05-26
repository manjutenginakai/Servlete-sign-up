package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import Dto.Student;

public class Student_dao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public Student fetch(String email) {
		List<Student> list = entityManager.createQuery("Select x from Student x where email=?1").setParameter(1, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Student fetch(long phone) {
		List<Student> list = entityManager.createQuery("Select x from Student x where phone=?1").setParameter(1, phone)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	public List<Student> fetch(){
		List<Student> list=entityManager.createQuery("Select x from Student x").getResultList();
		return list;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Student.class, id));
		entityTransaction.commit();
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
	}

}
