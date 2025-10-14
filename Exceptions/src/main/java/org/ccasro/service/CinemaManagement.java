package org.ccasro.service;

import org.ccasro.model.Cinema;
import org.ccasro.util.InputScanner;

import java.util.InputMismatchException;

public class CinemaManagement {
    private Cinema cinema;

    public CinemaManagement(Cinema cinema){
        this.cinema = cinema;
    }

    public int menu(){

        int option;

        while(true){
            System.out.println("1. Show all booked seats.");
            System.out.println("2. Show seats booked by a person.");
            System.out.println("3. Book a seat.");
            System.out.println("4. Cancel a seat reservation.");
            System.out.println("5. Cancel all reservations of a person");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            try {
                option = InputScanner.SC.nextInt();

                if(option >= 0 && option <= 6){
                    return option;
                } else {
                    System.out.println("Please, enter a number between 1-6");
                }

            } catch (InputMismatchException e){
                System.out.println("Invalid data. You must enter an integer. ");
                InputScanner.SC.nextLine();
            }
        }
    }

    public void showSeats(){

    }

    public void showSeatsPerson(){

    }

    public void reserveSeat(){

    }

    public void cancelReservation(){

    }

    public void cancelReservationPerson(){

    }

    public String enterPerson(){
    return null;
    }

    public int enterRow(){
    return 0;
    }

    public int enterSeat(){
    return 0;
    }


}
