package com.company;

public class Passenger {
    private String firstName;
    private String surname;
    private String expenses;



    public Passenger(){
        firstName = "empty";
        surname = "empty";
        expenses = "0";

    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String  expenses) {
        this.expenses = expenses;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}

