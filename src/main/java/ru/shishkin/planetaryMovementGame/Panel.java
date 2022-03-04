package ru.shishkin.planetaryMovementGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.*;

public class Panel extends JPanel {
    private Image img;
    private Image imgfon;
    private Image img2;
    private int x = 700, y = 300;
    private int x_mars = 700, y_mars = 300;
    private int napravlenie = 7;
    private int napravlenie_mars = 5;
    private int speed = 5;

    private class mykey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            System.out.println(keycode);

            if (keycode == 68) napravlenie = 0;
            if (keycode == 67) napravlenie = 1;
            if (keycode == 83) napravlenie = 2;
            if (keycode == 90) napravlenie = 3;
            if (keycode == 65) napravlenie = 4;
            if (keycode == 81) napravlenie = 5;
            if (keycode == 87) napravlenie = 6;
            if (keycode == 69) napravlenie = 7;

            if (keycode == 102) napravlenie_mars = 0;
            if (keycode == 99) napravlenie_mars = 1;
            if (keycode == 98) napravlenie_mars = 2;
            if (keycode == 97) napravlenie_mars = 3;
            if (keycode == 100) napravlenie_mars = 4;
            if (keycode == 103) napravlenie_mars = 5;
            if (keycode == 104) napravlenie_mars = 6;
            if (keycode == 105) napravlenie_mars = 7;
        }

        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    Panel() {
        addKeyListener(new mykey());
        setFocusable(true);

        try {
            img = ImageIO.read(getClass().getClassLoader().getResource("planeta.png"));
            img2 = ImageIO.read(getClass().getClassLoader().getResource("mars.png"));
            imgfon = ImageIO.read(getClass().getClassLoader().getResource("fon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Timer timer = new Timer(25, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //---------------------------------------------------------
                if (napravlenie == 0) {
                    x += speed;
                }
                if (napravlenie == 4) {
                    x -= speed;
                }
                if (napravlenie == 2) {
                    y += speed;
                }
                if (napravlenie == 6) {
                    y -= speed;
                }
                if (napravlenie == 1) {
                    x += speed;
                    y += speed;
                }
                if (napravlenie == 3) {
                    x -= speed;
                    y += speed;
                }
                if (napravlenie == 5) {
                    x -= speed;
                    y -= speed;
                }
                if (napravlenie == 7) {
                    x += speed;
                    y -= speed;
                }

                if (x > 1000 - 120) {
                    if (napravlenie == 1) {
                        napravlenie = 3;
                    } else if (napravlenie == 7) {
                        napravlenie = 5;
                    } else {
                        napravlenie = 4;
                    }
                }
                if (x < 0) {
                    if (napravlenie == 3) {
                        napravlenie = 1;
                    } else if (napravlenie == 5) {
                        napravlenie = 7;
                    } else {
                        napravlenie = 0;
                    }
                }
                if (y > 700 - 140) {
                    if (napravlenie == 3) {
                        napravlenie = 5;
                    } else if (napravlenie == 1) {
                        napravlenie = 7;
                    } else {
                        napravlenie = 6;
                    }
                }
                if (y < 0) {
                    if (napravlenie == 7) {
                        napravlenie = 1;
                    } else if (napravlenie == 5) {
                        napravlenie = 3;
                    } else {
                        napravlenie = 2;
                    }
                }
                //---------------------------------------------------------
                if (napravlenie_mars == 0) {
                    x_mars += speed;
                }
                if (napravlenie_mars == 4) {
                    x_mars -= speed;
                }
                if (napravlenie_mars == 2) {
                    y_mars += speed;
                }
                if (napravlenie_mars == 6) {
                    y_mars -= speed;
                }
                if (napravlenie_mars == 1) {
                    x_mars += speed;
                    y_mars += speed;
                }
                if (napravlenie_mars == 3) {
                    x_mars -= speed;
                    y_mars += speed;
                }
                if (napravlenie_mars == 5) {
                    x_mars -= speed;
                    y_mars -= speed;
                }
                if (napravlenie_mars == 7) {
                    x_mars += speed;
                    y_mars -= speed;
                }

                if (x_mars > 1000 - 120) {
                    if (napravlenie_mars == 1) {
                        napravlenie_mars = 3;
                    } else if (napravlenie_mars == 7) {
                        napravlenie_mars = 5;
                    } else {
                        napravlenie_mars = 4;
                    }
                }
                if (x_mars < 0) {
                    if (napravlenie_mars == 3) {
                        napravlenie_mars = 1;
                    } else if (napravlenie_mars == 5) {
                        napravlenie_mars = 7;
                    } else {
                        napravlenie_mars = 0;
                    }
                }
                if (y_mars > 700 - 140) {
                    if (napravlenie_mars == 3) {
                        napravlenie_mars = 5;
                    } else if (napravlenie_mars == 1) {
                        napravlenie_mars = 7;
                    } else {
                        napravlenie_mars = 6;
                    }
                }
                if (y_mars < 0) {
                    if (napravlenie_mars == 7) {
                        napravlenie_mars = 1;
                    } else if (napravlenie_mars == 5) {
                        napravlenie_mars = 3;
                    } else {
                        napravlenie_mars = 2;
                    }
                }
                //---------------------------------------------------------
                repaint();
            }
        });
        timer.start();
    }

    public void paint(Graphics arg0) {
        super.paint(arg0);
        arg0.drawImage(imgfon, 0, 0, 1000, 700, null);

        arg0.setColor(Color.yellow);
        arg0.fillOval(x - 3, y - 3, 106, 106);
        arg0.drawImage(img, x, y, 100, 100, null);

        arg0.setColor(Color.red);
        arg0.fillOval(x_mars - 3, y_mars - 3, 106, 106);
        arg0.drawImage(img2, x_mars, y_mars, 100, 100, null);
    }
}
