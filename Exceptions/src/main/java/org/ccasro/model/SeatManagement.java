package org.ccasro.model;

import org.ccasro.exceptions.SeatFreeException;
import org.ccasro.exceptions.SeatOccupiedException;
import org.ccasro.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatManagement {
    private List<Seat> seats;

    public SeatManagement(){
        this.seats = new ArrayList<>();
    }

    public List<Seat> getSeats(){
        return List.copyOf(seats);
    }

    public void addSeat(Seat seat) throws SeatOccupiedException {
        seats.add(seat);
    }

    public void removeSeat(int row, int seat) throws SeatFreeException {

    }

    public int searchSeat(int row, int seat){
    return 0;
    }




}
