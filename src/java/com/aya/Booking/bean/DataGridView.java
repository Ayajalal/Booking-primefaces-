/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aya.Booking.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author aya
 */
@ManagedBean(name="DataGridView")
@ViewScoped
public class DataGridView implements Serializable {

    private List<Product> products;
    private Product selectedProduct;

   @ManagedProperty(value="#{ProductService}")
    private ProductService service;

    @PostConstruct
    public void init() {
        products = service.getProducts(48);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
//
//    public void clearMultiViewState() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        String viewId = context.getViewRoot().getViewId();
//        PrimeFaces.current().multiViewState().clearAll(viewId, true, this::showMessage);
//    }
//
//    private void showMessage(String clientId) {
//        FacesContext.getCurrentInstance()
//                .addMessage(null,
//                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
//    }
}