package com.dependencyInjection;


public class DatabaseOperations
{
    private String url;
    private String username;
    private String password;

    public DatabaseOperations() {
    }
    public void connectToDatabase(){
        System.out.println("Connection to database established....");
    }
    public void disconnectFromDatabase(){
        System.out.println("Connection to database closed....");
    }


}
