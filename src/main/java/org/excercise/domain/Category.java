package org.excercise.domain;

import javax.validation.constraints.NotNull;

public class Category {
    int id;

    @NotNull(message = "Category name can not be null")
    String name;

    @NotNull(message = "Category address can not be null")
    String addressl;

    @NotNull(message = "Category latittute can not be null")
    Double latitude;

    @NotNull(message = "Category longitude can not be null")
    Double longitude;

    public Category(){

    }

    public Category(int _id, String name, String address, Double latitude, Double longitude){
        this.id = _id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId(){
        return this.id;
    }
    
    public void setId(int _id){
        this.id = _id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double _latitude){
        this.latitude = _latitude;
    }

    public double getLognitude(){
        return this.longitude;
    }

    public void setLongitude(double _longitude){
        this.longitude = _longitude;
    }
}