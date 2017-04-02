/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.product;

/**
 *
 * @author MuHamd Gomaa
 */
public class items {

    public product getP() {
        return p;
    }

    public void setP(product p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public items(product p,int quantity) {
        this.quantity = quantity;
                this.p = p;

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private product p = new product();
    private int quantity;
}
