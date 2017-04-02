/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author MuHamd Gomaa
 */
public class hiber_data {
      static SessionFactory factory=new Configuration().configure().buildSessionFactory();

    public List findall(){

            Session ss = factory.openSession();
              List<product> itemss=null;
 try{
        ss.beginTransaction();
        product dd=new product();
       itemss=ss.createQuery("from product").list();
       
        ss.getTransaction().commit();
           ss.close();
     
    }catch(HibernateException e){
    e.printStackTrace();
    }
 
    return itemss;

    }
    public product find(int id){
   
                Session ss = factory.openSession();

ss.beginTransaction();

product p =     (product) ss.get(product.class, id);
ss.getTransaction().commit();

 return  p;

    
}
      public void save(product p){
                  Session ss = factory.openSession();
ss.beginTransaction();
ss.save(p);
ss.getTransaction().commit();
    
    
}



    
}
