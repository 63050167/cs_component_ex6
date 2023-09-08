/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student student1 = new Student(1, "Sitra", 4.0);
       Student student2 = new Student(2, "Pitha", 5.0);
       StudentTable.insertStudent(student1);
       StudentTable.insertStudent(student2); 
       List<Student> stdList = StudentTable.findAllStudent();
       printAllStudent(stdList);
    }
    public static void printAllStudent(List<Student> studentList) {
        for(Student std : studentList) {
           System.out.print(std.getId() + " ");
           System.out.print(std.getName() + " ");
           System.out.println(std.getGPA() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
