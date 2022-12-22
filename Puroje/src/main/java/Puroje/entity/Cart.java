/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Puroje.entity;

public class Cart {

    private Vegetable product;
    private int quantity;

    public Cart() {
    }

    public Cart(Vegetable product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Vegetable getVegetable() {
        return product;
    }

    public void setVegetable(Vegetable product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
