/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracja;


import javax.swing.*;
import java.util.*;
import java.text.*;

public class Zegar implements Runnable {
    private Thread watek;
    public JLabel jLabel25;
private int pauza = 1000;
 
 Zegar(JLabel x) {
     jLabel25=x;
/*super("", SwingConstants.CENTER);
setFont (new Font ("Veranda", Font.BOLD, 24));
setBackground( new Color(255,255,102));
setForeground(Color.BLACK);
setOpaque(true);*/
}
 
public void start() {
if (watek == null) {
watek = new Thread(this);
watek.start();
}
}
public void run() {
while ( watek == Thread.currentThread()) {
Date time = new Date();
DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
jLabel25.setText(df.format(time));
try {
watek.sleep(pauza);
} catch (InterruptedException e) {}
}
}

public void stop() {
watek = null;
}
}

