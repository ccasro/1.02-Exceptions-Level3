package org.ccasro.service;

import org.ccasro.exceptions.*;
import org.ccasro.model.Cinema;
import org.ccasro.model.Seat;
import org.ccasro.util.InputScanner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CinemaManagement {
    private Cinema cinema;

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
    }

    public int menu() {

        int option;

        while (true) {
            System.out.println("1. Show all booked seats.");
            System.out.println("2. Show seats booked by a person.");
            System.out.println("3. Book a seat.");
            System.out.println("4. Cancel a seat reservation.");
            System.out.println("5. Cancel all reservations of a person");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {
                option = InputScanner.SC.nextInt();
                InputScanner.SC.nextLine();

                if (option >= 0 && option <= 5) {
                    return option;
                } else {
                    System.out.println("Please, enter a number between 0-5");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid data. You must enter an integer. ");
                InputScanner.SC.nextLine();
            }
        }
    }

    public void showSeats() {
        for (Seat s : cinema.getSeatManager().getSeats()) {
            System.out.println(s);
        }
    }

    public void showSeatsByPerson() {
        String name = enterPersonName();
        for (Seat s : cinema.getSeatManager().getSeats()) {
            if (s.getBookedBy().equalsIgnoreCase(name)) {
                System.out.println(s);
            }
        }
    }

    public void reserveSeat() {
        try {
            int row = enterRow();
            int seat = enterSeat();
            String person = enterPersonName();
            cinema.getSeatManager().addSeat(new Seat(row, seat, person));
            System.out.println("Seat reserved! ");
        } catch (InputMismatchException e){
            System.out.println("Must be a number");
            InputScanner.SC.nextLine();
        } catch (InvalidRowException e) {
            System.out.println("Row error : " + e.getMessage());
        } catch (InvalidSeatException e) {
            System.out.println("Seat error : " + e.getMessage());
        } catch (InvalidPersonNameException e) {
            System.out.println("Invalid Name: " + e.getMessage());
        } catch (SeatOccupiedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelReservation() {
        try {
            int row = enterRow();
            int seat = enterSeat();
            cinema.getSeatManager().removeSeat(row, seat);
            System.out.println("Reservation cancelled! ");
        } catch (InputMismatchException e){
            System.out.println("Must be a number");
            InputScanner.SC.nextLine();
        } catch (InvalidRowException e) {
            System.out.println("Row error : " + e.getMessage());
        } catch (InvalidSeatException e){
            System.out.println("Seat error : " + e.getMessage());
        } catch (SeatFreeException e){
            System.out.println(e.getMessage());
        }
    }

    public void cancelReservationPerson() {
        try {
            String name = enterPersonName();
            List<Seat> seatsToRemove = new ArrayList<>();
            for (Seat seat : cinema.getSeatManager().getSeats()) {
                if (seat.getBookedBy().equalsIgnoreCase(name)){
                    seatsToRemove.add(seat);
                }
            }

            for (Seat s : seatsToRemove){
                cinema.getSeatManager().removeSeat(s.getRowNumber(),s.getSeatNumber());
            }
            System.out.println("All reservations cancelled for " + name);
        } catch (InvalidPersonNameException e){
            System.out.println("Error name: " + e.getMessage());
        } catch (SeatFreeException e) {
            System.out.println(e.getMessage());
        }
    }

    public String enterPersonName() throws InvalidPersonNameException {
        System.out.println("Enter person name: ");
        String name = InputScanner.SC.nextLine();
        if (name.matches(".*\\d.*")) {
            throw new InvalidPersonNameException("Name cant contain numbers.");
        }
        return name;
    }

    public int enterRow() throws InvalidRowException {
            System.out.println("Enter row number: ");
                int row = InputScanner.SC.nextInt();
                InputScanner.SC.nextLine();
                if (row < 1 || row > cinema.getNumRows()) {
                    throw new InvalidRowException("Row out of range");
                }
                return row;

        }

    public int enterSeat() throws InvalidSeatException {
            System.out.println("Enter seat number: ");
                int seat = InputScanner.SC.nextInt();
                InputScanner.SC.nextLine();
                if (seat < 1 || seat > cinema.getNumSeatsByRow()) {
                   throw new InvalidSeatException("Seat out of range");
                }
                return seat;
            }
    }
