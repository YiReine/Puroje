/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.entity;

import jakarta.persistence.*;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "orderdetail")
public class Orderdetail {
    @Id
    private int OrderID;
    private int VegetableID;
    private int Quantity;
    private double Price;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getVegetableID() {
        return VegetableID;
    }

    public void setVegetableID(int VegetableID) {
        this.VegetableID = VegetableID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
}
