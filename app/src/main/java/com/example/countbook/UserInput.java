package com.example.countbook;

/**
 * Created by Shally on 2017-09-16.
 */


//Todo later this is just skelatal code
public class UserInput {
    private static UserInput ourInstance = new UserInput();

    public static UserInput getInstance() {
        return ourInstance;
    }


    private String comment = "";
    private String name;
    private Integer initialValue;

    public String getName(){
        return "";
    }

    public String getComment(){
        return "";
    }

    public Integer getInitialValue(){
        return 0;
    }

    public void setName( String nameToSet ){

    }

    public void setComment( String commentToSet ){

    }

    public void setInitialValue( Integer initValueToSet ){

    }

    private UserInput() {

    }
}
