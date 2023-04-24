package org.example;


import net.sf.ehcache.hibernate.EhCacheRegionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SessionFactory sessionFactory = new HibernateUtils().getSessionFactory();
        Session session = sessionFactory.openSession();
        //Transaction transaction = session.beginTransaction();
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("shankar");
        s1.setSal(1000);
        s1.setCity("hyd");
        s1.setState("ts");
        s1.setCountry("india");
        Student s2 = new Student();
        s2.setId(2);
        s2.setSal(2000);
        s2.setName("bhanuprasad");
        s2.setCity("bgl");
        s2.setState("ka");
        s2.setCountry("india");
       // session.save(s1);
        //session.save(s2);
       /* Query query = session.createQuery("from Student"); // casing is important
        List<Student> students = query.list();

        transaction.commit();
        System.out.println(s1 + " : " + s2);
        for (Student s : students
        ) {
            System.out.println(s);

        }
        Query query = session.createQuery("from Student where city='hyd'");
        Query query = session.createQuery("from Student where id=:id or city=:city");//hql
        List<Student> students = query.list();
        query.setParameter("id", 1);
        query.setParameter("city", "hyd");
        System.out.println(query.uniqueResult());
        Query q = session.createQuery("select name from Student as s where s.id=:id");
        q.setParameter("id", 1);
        System.out.println(q.uniqueResult());
        Criteria criteria = session.createCriteria(Student.class); //hcql
        criteria.add(Restrictions.gt("sal", 1500));
        criteria.add(Restrictions.lt("sal", 1200));
        criteria.add(Restrictions.like("name", "s%"));
        criteria.add(Restrictions.eq("city", "hyd"));
        List<Student> list = criteria.list();
        for (Student s : list
        ) {
            System.out.println(s.getName());

        }
     */
        // first level cache by default it will be activated
       /* Student s=session.get(Student.class,1);
        System.out.println(s);

        Student ss=session.get(Student.class,2);
        System.out.println(ss);*/
      // transaction.commit();

        //second level cache
      //  EhcacheRegionFactory -> used to get package which should be updated in HibernateUtils class

       SessionFactory sessionFactory1= new HibernateUtils().getSessionFactory();
       Session session1=sessionFactory1.openSession();
       Student stu1=session1.get(Student.class,1);

       Session session2=sessionFactory1.openSession();
      Student stu2= session2.get(Student.class, 1);

        System.out.println(stu1);
        System.out.println(stu2);
        session.close();
        sessionFactory.close();

    }
}
