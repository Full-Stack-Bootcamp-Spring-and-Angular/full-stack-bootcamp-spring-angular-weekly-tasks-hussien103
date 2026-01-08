package com.Example.Models;

public interface Vehicle {

    public String getModel();
    public Type getType();
    public void setModel(String model);
    public void setType(Type type);
    public void setId(int id);
    public int getId();
}
