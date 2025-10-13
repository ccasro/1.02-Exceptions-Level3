package org.ccasro;

import java.util.Scanner;

public class Cinema {
    private int numRows;
    private int numSeatsByRow;
    private CinemaManagement cinemaManage;
    private SeatManagement seatManage;
    private Scanner sc = new Scanner(System.in);

    public Cinema() {
        this.cinemaManage = new CinemaManagement();
        this.seatManage = new SeatManagement();
        requestInitialData();
    }

    public void requestInitialData() {

        int numRows;
        int numSeatsByRow;

        while (true) {
            System.out.println("Provide the number of Rows: ");
            String input = sc.nextLine();
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
                String input = sc.nextLine();
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
    }
