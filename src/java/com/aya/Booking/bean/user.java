/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aya.Booking.bean;

import com.aya.project.db.dao.UserDao;
import com.aya.project.db.vo.UserVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author aya
 */
@ManagedBean(name="user")
@RequestScoped


public class user  implements Serializable {
    private String text=" Where are you going ?";
    private int num1=1;
   private  int num2=0;
 
   private  int num3=1;
   private String calatext="Check-in - Check-out";
   
private UserVo uservo=new UserVo();
 private UserVo idU=new UserVo();
private List<UserVo> uservos=new ArrayList();//to get list

  private String option;
    private Country country;
    private List<Country> countries;

   @ManagedProperty(value="#{country}")
    private CountryService service;

    @PostConstruct
    public void init(){
        countries = service.getCountries();
        
        
        try {
            uservos=UserDao.getInstance().ShowAllsearch();
        } catch (Exception ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }







    /**
     * Creates a new instance of UserBean
     */
    
    
        public String register1(){
       return "search.xhtml";
          }
    
     public String ShowAllsearch() throws Exception {
          // uservos=UserDao.getInstance().ShowAllsearch(uservo.getCountry());
              return "search.xhtml";
       }
     
   
        public String register(){
        return "register.xhtml";
          }
        

    public String getText() {
    return text;
    }

    public String getCalatext() {
        return calatext;
    }

    public void setCalatext(String calatext) {
        this.calatext = calatext;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

 
  

    public void setText(String text) {
        this.text = text;
    }

public String sign(){
 return "signin.xhtml?faces.redirect=true";
}
    public void signup()throws Exception {
        UserDao.getInstance().signUp(uservo);
       
    }
       public void signin()throws Exception {
        UserDao.getInstance().signIn(uservo);
       // return "signin.xhtml";
    }
     
    public UserVo getUservo() {
        return uservo;
    }

    public void setUservo(UserVo uservo) {
        this.uservo = uservo;
    }

    public UserVo getIdU() {
        return idU;
    }

    public void setIdU(UserVo idU) {
        this.idU = idU;
    }

    public List<UserVo> getUservos() {
        return uservos;
    }

    public void setUservos(List<UserVo> uservos) {
        this.uservos = uservos;
    }
    
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void setService(CountryService service) {
        this.service = service;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }

    
    
    
    
    

//    private String option;
//    private Country country;
//    private static List<Country> countries;
//
//     @ManagedProperty(value = "#{country}")
//    private CountryService service;
//
//    @PostConstruct
//    public void init() {
//        countries = service.getCountries();
//        
//      
//    }
//    
//
//    public String getOption() {
//        return option;
//    }
//
//    public void setOption(String option) {
//        this.option = option;
//    }
//
//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//
//    public List<Country> getCountries() {
//        return countries;
//    }
//
//    public void setCountries(List<Country> countries) {
//        this.countries = countries;
//    }
//
//    public void setService(CountryService service) {
//        this.service = service;
//    }
// 
//       public static void main(String[] args){
//           CountryService x=new CountryService();
//             System.out.print(x.getCountries().get(0));
//      
//     
//    }
    


