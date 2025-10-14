package org.ccasro.model;

public class Seat {
    private int rowNumber;
    private int seatNumber;
    private String bookedBy;

    public Seat(int rowNumber, int seatNumber, String bookedBy){
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.bookedBy = bookedBy;
    }

    public int getRowNumber(){
        return rowNumber;
    }

    public int getSeatNumber(){
        return seatNumber;
    }

    public String getBookedBy(){
        return bookedBy;
    }

    public boolean equals(Seat other){
        if (other == null) return false;
        return this.rowNumber == other.rowNumber && this.seatNumber == other.seatNumber;
    }


    @Override
    public String toString() {
        return "Row: " + rowNumber +
                ", Seat: " + seatNumber +
                ", BookedBy: " + bookedBy;
    }
}
