/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracja;

/**
 *
 * @author Arkadye
 */
import javax.swing.*;

public class Minutnikk implements Runnable {
    private Thread watek;
    public JLabel jLabel50;
private int pauza = 60000;
int zmienna= 30;

 
 Minutnikk(JLabel x) {
     jLabel50=x;
}
 
public void start() {
if (watek == null) {
watek = new Thread(this);
watek.start();
}
}
public void run() {
while ( watek == Thread.currentThread()) {
if(zmienna!=0){
jLabel50.setText(Integer.toString(zmienna));
}else
{
  zmienna=0;
  jLabel50.setText(Integer.toString(zmienna));
}
try {
watek.sleep(pauza);
zmienna=zmienna-1;
} catch (InterruptedException e) {}
}
}

public void stop() {
watek = null;
}
}