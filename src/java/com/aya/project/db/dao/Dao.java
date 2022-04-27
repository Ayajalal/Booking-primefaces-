/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aya.project.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author aya
 */
public class Dao {
       public Connection getConnection() throws Exception{
        Connection con;
         Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost/prime","root","");
        if(con!=null){
    //    JOptionPane.showMessageDialog(null, "connect to db");
         return con;
        }
           // JOptionPane.showMessageDialog(null, "not connect to db");
            return null;
        
    }
    public void closeConnection(Connection con ) throws Exception
    {
    if(con!=null){
    con.close();}
    
    }
      public static void main(String args[]) throws Exception{
    Dao d=new Dao();
    d.getConnection();
    
    }
    
}

