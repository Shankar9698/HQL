package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtils {
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            Configuration configuration=new Configuration();
            Properties properties=new Properties();
            properties.setProperty(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            properties.setProperty(Environment.URL,"jdbc:mysql://localhost:3306/my_db6");
            properties.setProperty(Environment.USER,"root");
            properties.setProperty(Environment.PASS,"root");
            properties.setProperty(Environment.SHOW_SQL,"true");
            properties.setProperty(Environment.HBM2DDL_AUTO,"update");
            properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
 /*if these two lines are commented (27,28) then session1 and session2 will hit the db and gives o/p
                if there means only 1st time it will hit to db for same request, nxt time from cacahe the data will get
            */properties.put(Environment.USE_SECOND_LEVEL_CACHE,true);
            properties.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Student.class);



            ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory=configuration.buildSessionFactory(serviceRegistry);



        }
        return sessionFactory;
    }
}
