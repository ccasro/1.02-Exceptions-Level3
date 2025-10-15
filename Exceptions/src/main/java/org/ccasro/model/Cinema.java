package org.ccasro.model;

import org.ccasro.service.CinemaManagement;
import org.ccasro.util.InputScanner;

public class Cinema {
    private int numRows;
    private int numSeatsByRow;
    private CinemaManagement cinemaManager;
    private SeatManagement seatManager;

    public Cinema() {
        this.cinemaManager = new CinemaManagement(this);
        this.seatManager = new SeatManagement();
        requestInitialData();
    }

    public SeatManagement getSeatManager(){
        return this.seatManager;
    }

    public int getNumRows(){
        return this.numRows;
    }

    public int getNumSeatsByRow(){
        return this.numSeatsByRow;
    }

    public void requestInitialData() {

        int numRows;
        int numSeatsByRow;

        while (true) {
            System.out.println("Provide the number of Rows: ");
            String input = InputScanner.SC.nextLine();
            try {
                numRows = Integer.parseInt(input);
                if (numRows <= 0) {
                    System.out.println("Error: the number must be greater than 0.");
                } else break;
            } catch (NumberFormatException e) {
                    System.out.println("Error: Must provide an integer.");
                }
            }

            while (true) {
                System.out.println("Provide the number of seats by row: ");
                String input = InputScanner.SC.nextLine();
                try {
                    numSeatsByRow = Integer.parseInt(input);
                    if (numSeatsByRow <= 0) {
                        System.out.println("Error: the number must be greater than 0.");
                    } else break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Must provide an integer.");
                }

            }

            this.numRows = numRows;
            this.numSeatsByRow = numSeatsByRow;

        }

        public void start() {
        int option;
        do {
            option = cinemaManager.menu();
            switch(option){
                case 1 -> cinemaManager.showSeats();
                case 2 -> cinemaManager.showSeatsByPerson();
                case 3 -> cinemaManager.reserveSeat();
                case 4 -> cinemaManager.cancelReservation();
                case 5 -> cinemaManager.cancelReservationPerson();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while (option != 0);

        }
    }
