package ru.shishkin.planetaryMovementGame;

import javax.swing.JFrame;

public class Application {
    public static void main(String[] args) {
        JFrame okno = new JFrame("Planetary Movement Game");
        okno.setBounds(10, 10, 1000, 700);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.add(new Panel());
        okno.setVisible(true);
    }
}
