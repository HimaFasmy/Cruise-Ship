package com.company;

public class Cabin {

    private String mainName;
    private int CabinNumber;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    public Passenger getPassenger3() {
        return passenger3;
    }

    public void setPassenger3(Passenger passenger3) {
        this.passenger3 = passenger3;
    }

    public Passenger getPassenger2() {
        return passenger2;
    }

    public void setPassenger2(Passenger passenger2) {
        this.passenger2 = passenger2;
    }

    public Passenger getPassenger1() {
        return passenger1;
    }

    public void setPassenger1(Passenger passenger1) {
        this.passenger1 = passenger1;
    }

    public Cabin(Passenger passenger1, Passenger passenger2, Passenger passenger3){
        mainName = "empty";
        this.passenger1 = passenger1;
        this.passenger2 = passenger2;
        this.passenger3 = passenger3;

    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }


    public int getCabinNumber() {
        return CabinNumber;
    }

    public void setCabinNumber(int cabinNumber) {
        CabinNumber = cabinNumber;
    }
}
