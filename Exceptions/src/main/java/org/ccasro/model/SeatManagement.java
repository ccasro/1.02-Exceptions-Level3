package org.ccasro.model;

import org.ccasro.exceptions.SeatFreeException;
import org.ccasro.exceptions.SeatOccupiedException;

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
        if(searchSeat(seat.getRowNumber(),seat.getSeatNumber()) != -1){
            throw new SeatOccupiedException("That seat is already taken");
        }
        seats.add(seat);
    }

    public void removeSeat(int row, int seat) throws SeatFreeException {
        int pos = searchSeat(row,seat);
        if(pos == -1){
            throw new SeatFreeException("That seat is not reserved");
        }
        seats.remove(pos);
    }

    public int searchSeat(int row, int seat){
        for (int i = 0; i < seats.size(); i++) {
            Seat s = seats.get(i);
            if(s.getRowNumber() == row && s.getSeatNumber() == seat){
                return i;
            }
        }
        return -1;
    }

}
