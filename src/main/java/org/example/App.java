package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory =new HibernateUtils().getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student s1=new Student();
        s1.setId(1);
        s1.setName("shankar");
        s1.setCity("hyd");
        s1.setState("ts");
        Student s2=new Student();
        s2.setId(2);
        s2.setName("bhanuprasad");
        s2.setCity("bgl");
        s2.setState("ka");

       /* session.save(s1);
        session.save(s2);
        Query query= session.createQuery("from Student"); // casing is important
       List<Student> students= query.list();

       transaction.commit();
        System.out.println(s1+" : "+s2);
        for (Student s:students
             ) {
            System.out.println(s);

        }
       */
      /* Query query= session.createQuery("from Student where city='hyd'");
       Query query=session.createQuery("from Student where id=:id or city=:city");
       List<Student> students=query.list();
        query.setParameter("id", 1);
        query.setParameter("city","hyd");
        System.out.println(query.uniqueResult());
*/Query q=session.createQuery("select name from Student as s where s.id=:id");
q.setParameter("id",1);
        System.out.println(q.uniqueResult());

        session.close();
        sessionFactory.close();

    }
}
