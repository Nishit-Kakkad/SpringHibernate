/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.springhibernate.DAO;

import com.nishit.springhibernate.entity.Feedback;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nishit-TCS
 */
@Repository
public class FeedbackDAO implements FeedbackDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public boolean addFeedback(Feedback feedback) {
        boolean result = false;
        try {
            sessionFactory.getCurrentSession().save(feedback);
            result = true;
        } catch(HibernateException ex) {
            System.out.println(ex.toString());
        }
        return result;
    }
    
}
