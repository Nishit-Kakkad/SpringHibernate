/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.springhibernate.DAO;

import com.nishit.springhibernate.entity.Feedback;

/**
 *
 * @author Nishit-TCS
 */
public interface FeedbackDAOInterface {
    boolean addFeedback(Feedback feedback);
}
