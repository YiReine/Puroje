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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CatagoryID;
    private String Name;
    private String Description;

    public int getCatagoryID() {
        return CatagoryID;
    }

    public void setCatagoryID(int CatagoryID) {
        this.CatagoryID = CatagoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}
