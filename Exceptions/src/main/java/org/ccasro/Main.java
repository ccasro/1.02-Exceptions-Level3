package org.ccasro;

import org.ccasro.model.Cinema;
import org.ccasro.util.InputScanner;

public class Main {
    public static void main (String[] args) {
        Cinema cinema = new Cinema();
        cinema.start();

        InputScanner.SC.close();
    }
}
