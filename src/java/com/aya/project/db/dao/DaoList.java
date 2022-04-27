/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aya.project.db.dao;

import java.util.List;

/**
 *
 * @author aya
 */
public interface DaoList<T> {
    public int signUp(T t)  throws Exception ;
    public int signIn(T t) throws Exception;
     public  List<T> ShowAllsearch( ) throws Exception;
        public T showUserBYCountry( String  Country) throws Exception ;
    
}
