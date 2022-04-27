/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aya.project.db.dao;

import com.aya.project.db.vo.UserVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aya
 */
public class UserDao extends Dao  implements DaoList<UserVo> {
    
    private UserDao() {
    }
    ;
    private static UserDao userdao;
    public static UserDao getInstance (){
    if(userdao==null){
    userdao=new UserDao();
    }
    return userdao; 
    }

    @Override
    public int signUp(UserVo t) throws Exception {
       Connection conn=null;
       int count =0;
       PreparedStatement stm =null;
       try{
       conn=getConnection();
       String qry="insert into user(userName,password,fisrtName,lastName,email) values(?,?,?,?,?)";
       stm=conn.prepareStatement(qry);
          stm.setString(1, t.getUserName());
            stm.setString(2, t.getPassword());
            
         stm.setString(3, t.getFirstName());
                  stm.setString(4, t.getLastName());
                           stm.setString(5, t.getLastName());
            count = stm.executeUpdate();
       
       }
       finally{
           conn.close();
           stm.close();
       }
       return count;
    }

    @Override
    public int signIn(UserVo t) throws Exception {
   Connection conn = null;
        int count = 0;
        PreparedStatement stm = null;
         ResultSet rs=null;
  try{
conn=getConnection();
String qry ="SELECT *FROM user where userName=? and password=?";
stm=conn.prepareStatement(qry);
           stm.setString(1, t.getUserName());
            stm.setString(2, t.getPassword());
   rs=stm.executeQuery();

  }

finally{

stm.close();
closeConnection(conn);

}
        return count;
    }

    @Override
    public List<UserVo> ShowAllsearch() throws Exception {
     
        
       Connection conn=null;
        PreparedStatement stm=null;
        UserVo list=null;
        List<UserVo> uList=null;
        ResultSet rs=null;
        try{
        conn=getConnection();
        
        // WHERE Country=?
          String qry="SELECT *FROM search";
        stm=conn.prepareStatement(qry);
       //  stm.setString(1, Country);
        rs=stm.executeQuery();
        
       
       uList=new ArrayList();
           while(rs.next()){
           list=new UserVo();
           list.setId(rs.getInt("id_user"));
           list.setImage(rs.getString("image"));
           list.setDesc(rs.getString("desc"));
           list.setNameHotel(rs.getString("name"));
           list.setStatus(rs.getString("status"));
          list.setCountry(rs.getString("Country"));
       uList.add(list);
       }
        
        }
        finally{
        stm.close();
        rs.close();
        closeConnection(conn);
        
        }
        return uList;
    }

    @Override
    public UserVo showUserBYCountry( String Country) throws Exception {
       
         Connection conn=null;
        ResultSet rs=null;
        PreparedStatement stm=null;
        UserVo list=null;
        try{
        conn=getConnection();
        String qry="SELECT *FROM search WHERE Country=?";
        stm=conn.prepareStatement(qry);
         stm.setString(1, Country);
        rs=stm.executeQuery();
        
      
           while(rs.next()){
           list=new UserVo();
           list.setId(rs.getInt("id_user"));
           list.setDesc(rs.getString("desc"));
           list.setNameHotel(rs.getString("name"));
           list.setStatus(rs.getString("status"));
           list.setImage(rs.getString("image"));
//           list.setName(rs.getString("name"));
//            list.setAge(rs.getInt("age"));
//                 list.setJob(rs.getString("job"));
//                 list.setAddress(rs.getString("address"));
//             list.setGender(rs.getString("gender"));
//        
//          List<String> myList = new ArrayList<String>(Arrays.asList(rs.getString("knowledge")));
//               list.setKnowledge(myList);
//                   list.setHobbies(rs.getString("hobbies"));
       
       
       }
        
        }
        finally{
        rs.close();
        stm.close();
        closeConnection(conn); 
        }
       return list;
    }
    
    
    public static void main(String args[] )throws Exception{
    UserDao d=new UserDao();
   
   System.out.print(d.ShowAllsearch());
        
    }
    
}
