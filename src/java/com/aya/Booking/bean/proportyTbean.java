/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aya.Booking.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aya
 */
@ManagedBean(name = "type")
@ApplicationScoped
public class proportyTbean {

    /**
     * Creates a new instance of proportyTbean
     */
    public proportyTbean() {
    }
    




    private List<PropertyType> types;

    @PostConstruct
    public void init() {
        types = new ArrayList<>();
        types.add(new PropertyType(1, "Hotels","hotel.jpg"));
         types.add(new PropertyType(2, "Apartments","hotel.jpg"));
          types.add(new PropertyType(3, "Resorts","hotel.jpg"));
           types.add(new PropertyType(4, "Villas","hotel.jpg"));
            types.add(new PropertyType(5, "Cabins","hotel.jpg"));
         types.add(new PropertyType(2, "Cottages","hotel.jpg"));
          types.add(new PropertyType(3, "Glamping","hotel.jpg"));
           types.add(new PropertyType(4, "Serviced Apartments","hotel.jpg"));
            types.add(new PropertyType(5, "Vacation Homes","hotel.jpg"));
        
    }

    public List<PropertyType> getProducts() {
        return new ArrayList<>(types);
    }

    public List<PropertyType> getProducts(int size) {

        if (size > types.size()) {
            Random rand = new Random();

            List<PropertyType> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(types.size());
                randomList.add(types.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(types.subList(0, size));
        }

    }

//    public List<Product> getClonedProducts(int size) {
//        List<Product> results = new ArrayList<>();
//        List<Product> originals = getProducts(size);
//        for (Product original : originals) {
//            results.add(original.clone());
//        }
//        return results;
//    }
}