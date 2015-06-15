/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Arek
 */
public class strglowna extends javax.swing.JFrame {      
Connection con;
Statement stmt;
ResultSet rs;
public PrintWriter out;
 int kwota;
public static int i=1;
public static String[] tab=new String[20];
 public Siec conn;
    public strglowna() {
        
        
        initComponents();
        
        oknostart.setVisible(true);
        Dane.setVisible(false);
        Logowanie.setVisible(true);
        Rejestracja.setVisible(false);
        Polaczenie();
        
        
    }
    
    public void Polaczenie() {
         
    try {
        //Połączenie z bazą danych
        String host = "jdbc:derby://localhost:1527/ADMINISTRATOR";
        String uzytkownik = "administrator";
        String passwd = "admin";
        con = DriverManager.getConnection(host,uzytkownik,passwd);
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "SELECT * FROM Uzytkownicy";
        rs = stmt.executeQuery(sql);
        
     
           
    } catch (SQLException err){
        JOptionPane.showMessageDialog(strglowna.this, err.getMessage());
    }   
    }
    
    public void sendCommand(String output)
    {
        try {
            out.println(output);
        } catch(Exception ex) {
            addStatus(ex.getMessage());
        }
    }
    public void addStatus(String txt)
    {
        if(Siec.master==true){
        jTextArea3.append(txt + "\n");
        jTextArea3.setCaretPosition(jTextArea3.getText().length()-1);
        }else{
            jTextArea4.append(txt + "\n");
        jTextArea4.setCaretPosition(jTextArea4.getText().length()-1);
                }
                
    }
     private void chatSend()
    {
       if(out != null) {
            if(Siec.master==true){
           sendCommand("CHAT:"+jTextField6.getText());
           jTextArea3.append("<ja> " +  jTextField6.getText()+"\n");
           jTextField6.setText("");
           jTextArea3.setCaretPosition(jTextArea3.getText().length()-1);
            }
            else{
              sendCommand("CHAT:"+jTextField7.getText());
           jTextArea4.append("<ja> " +  jTextField7.getText()+"\n");
           jTextField7.setText("");
           jTextArea4.setCaretPosition(jTextArea4.getText().length()-1);
              
            
            }
       } else {
           addStatus("Brak połączenia");
       }               
    }
      private void zamSend()
    {
       if(out != null) {
            if(Siec.master==false){
                
           sendCommand("ZAM:"+ jTextArea9.getText());
          sendCommand("DANE:"+ jTextArea5.getText());
           //jTextArea3.append("<ja> " +  jTextField6.getText()+"\n");
           jTextArea9.setText("");
           //jTextArea3.setCaretPosition(jTextArea3.getText().length()-1);
            }
          
            
            
       } else {
           addStatus("Brak połączenia");
       }               
    }
     public void readCommand(String input)
    {
        String cmdName, cmdContent;
        int fo = input.indexOf(':');
        if(fo==-1) {
            cmdName = input;
        } else {
            cmdName = input.substring(0, fo);
        }
        if(input.length()>fo-1) {
            cmdContent = input.substring(fo+1);
        } else {
            cmdContent = "";
        }       
        
        if(cmdName.equals("CHAT")) {
            if(Siec.master==true){
            jTextArea3.append("<klient> " + cmdContent + "\n");
            jTextArea3.setCaretPosition(jTextArea3.getText().length()-1);
        }else{
               jTextArea4.append("<obsluga> " + cmdContent + "\n");
            jTextArea4.setCaretPosition(jTextArea4.getText().length()-1); 
            }
        }else if(cmdName.equals("ZAM")) {
                if(Siec.master==true){
            jTextArea1.append("Zamówienie "+i+": " + cmdContent + "\n");
            jTextArea1.setCaretPosition(jTextArea1.getText().length()-1);
                    
                    
            }
        }else if(cmdName.equals("DANE")){
                 if(Siec.master==true){
                     jTextArea2.append("Zamówienie "+i+": " + cmdContent + "\n");
            jTextArea2.setCaretPosition(jTextArea2.getText().length()-1);
            i++;
                 }
            }
    
    }
    /**
     
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oknostart = new javax.swing.JFrame();
        Logowanie = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        Rejestracja = new javax.swing.JPanel();
        imierej = new javax.swing.JTextField();
        nazwiskorej = new javax.swing.JTextField();
        emailrej = new javax.swing.JTextField();
        loginrej = new javax.swing.JTextField();
        passwdrej = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ulicarej = new javax.swing.JTextField();
        mieszrej = new javax.swing.JTextField();
        kodrej = new javax.swing.JTextField();
        miejscowoscrej = new javax.swing.JTextField();
        telefonrej = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelobslugi = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        DefaultListModel model = new DefaultListModel();
        jList1 = new javax.swing.JList(model);
        jTextField6 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton21 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Zapiszklient = new javax.swing.JFileChooser();
        Otworzklient = new javax.swing.JFileChooser();
        Zapishistoria = new javax.swing.JFileChooser();
        Zapiszpo = new javax.swing.JFileChooser();
        Realizuj = new javax.swing.JDialog();
        jButton15 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jButton16 = new javax.swing.JButton();
        Zapiszamowien = new javax.swing.JDialog();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        Zapiszdane = new javax.swing.JDialog();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        Dane = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButton48 = new javax.swing.JButton();
        Panelklienta = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        wyloguj = new javax.swing.JButton();
        zapisz = new javax.swing.JButton();
        zamowienie = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        Menu = new javax.swing.JTabbedPane();
        Zupy = new javax.swing.JPanel();
        Rosol = new javax.swing.JLabel();
        Barszcz = new javax.swing.JLabel();
        poleinfo = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        Dodatki = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Desery = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jTextArea6 = new javax.swing.JTextArea();
        Napoje = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTextField7 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        Histzamow = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        oknostart.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        oknostart.setTitle("Restauracja");
        oknostart.setLocation(new java.awt.Point(0, 0));
        oknostart.setMinimumSize(new java.awt.Dimension(600, 400));

        Logowanie.setBackground(new java.awt.Color(255, 255, 102));
        Logowanie.setMaximumSize(new java.awt.Dimension(600, 400));
        Logowanie.setMinimumSize(new java.awt.Dimension(600, 400));
        Logowanie.setPreferredSize(new java.awt.Dimension(600, 400));

        jButton1.setBackground(new java.awt.Color(255, 204, 153));
        jButton1.setText("Zaloguj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setText("Zakończ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 153));
        jButton3.setText("Zarejestruj");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("login");

        jLabel2.setText("hasło");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 102));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Klient");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 102));
        jCheckBox2.setText("Obsługa");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogowanieLayout = new javax.swing.GroupLayout(Logowanie);
        Logowanie.setLayout(LogowanieLayout);
        LogowanieLayout.setHorizontalGroup(
            LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogowanieLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LogowanieLayout.createSequentialGroup()
                            .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogowanieLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        LogowanieLayout.setVerticalGroup(
            LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogowanieLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LogowanieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        Rejestracja.setBackground(new java.awt.Color(153, 204, 255));
        Rejestracja.setEnabled(false);
        Rejestracja.setMaximumSize(new java.awt.Dimension(600, 400));
        Rejestracja.setMinimumSize(new java.awt.Dimension(600, 400));
        Rejestracja.setPreferredSize(new java.awt.Dimension(600, 400));

        imierej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imierejActionPerformed(evt);
            }
        });

        nazwiskorej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nazwiskorejActionPerformed(evt);
            }
        });

        loginrej.setToolTipText("");

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setText("Zarejestruj");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 102, 102));
        jButton5.setText("Wróć");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nazwisko");

        jLabel3.setText("Imię");

        jLabel5.setText("e-mail");

        jLabel6.setText("login");

        jLabel7.setText("haslo");

        miejscowoscrej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miejscowoscrejActionPerformed(evt);
            }
        });

        jLabel11.setText("Ulica");

        jLabel12.setText("Nr mieszkania");

        jLabel13.setText("Kod pocztowy");

        jLabel14.setText("Miejscowość");

        jLabel15.setText("Telefon");

        javax.swing.GroupLayout RejestracjaLayout = new javax.swing.GroupLayout(Rejestracja);
        Rejestracja.setLayout(RejestracjaLayout);
        RejestracjaLayout.setHorizontalGroup(
            RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RejestracjaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RejestracjaLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(RejestracjaLayout.createSequentialGroup()
                        .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imierej)
                            .addComponent(nazwiskorej)
                            .addComponent(emailrej)
                            .addComponent(loginrej)
                            .addComponent(passwdrej, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RejestracjaLayout.createSequentialGroup()
                                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ulicarej)
                                    .addComponent(mieszrej, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(RejestracjaLayout.createSequentialGroup()
                                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(miejscowoscrej)
                                    .addComponent(telefonrej)
                                    .addComponent(kodrej, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(93, Short.MAX_VALUE))))
        );
        RejestracjaLayout.setVerticalGroup(
            RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RejestracjaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(imierej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(ulicarej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwiskorej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(mieszrej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodrej, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailrej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginrej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14)
                    .addComponent(miejscowoscrej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(passwdrej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(telefonrej, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(RejestracjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout oknostartLayout = new javax.swing.GroupLayout(oknostart.getContentPane());
        oknostart.getContentPane().setLayout(oknostartLayout);
        oknostartLayout.setHorizontalGroup(
            oknostartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknostartLayout.createSequentialGroup()
                .addComponent(Rejestracja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(oknostartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(oknostartLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Logowanie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        oknostartLayout.setVerticalGroup(
            oknostartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknostartLayout.createSequentialGroup()
                .addComponent(Rejestracja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
            .addGroup(oknostartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(oknostartLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Logowanie, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelobslugi.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panelobslugi.setTitle("Restauracja - Okno obsługi");
        panelobslugi.setLocation(new java.awt.Point(275, 50));
        panelobslugi.setMinimumSize(new java.awt.Dimension(800, 500));
        panelobslugi.setPreferredSize(new java.awt.Dimension(800, 500));
        panelobslugi.setResizable(false);
        panelobslugi.setSize(new java.awt.Dimension(800, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 520));

        jButton7.setBackground(new java.awt.Color(255, 204, 102));
        jButton7.setText("Realizuj zamówienie");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 204, 102));
        jButton9.setText("Zapis zamówienia");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 204, 102));
        jButton10.setText("Zapis danych klienta");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 102, 102));
        jButton11.setText("Wyczyść zamówienia");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 102, 102));
        jButton12.setText("Wyloguj");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Zamówienie");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jList1);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        jButton21.setText("Wyślij");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                    .addComponent(jTextField6))
                                .addGap(18, 18, 18)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 25, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jMenuBar2.setBackground(new java.awt.Color(204, 0, 0));
        jMenuBar2.setForeground(new java.awt.Color(255, 255, 255));

        jMenu2.setBackground(new java.awt.Color(204, 0, 0));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Menu");

        jMenuItem4.setText("Historia zamówień");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Wyjście");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar2.add(jMenu2);

        panelobslugi.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout panelobslugiLayout = new javax.swing.GroupLayout(panelobslugi.getContentPane());
        panelobslugi.getContentPane().setLayout(panelobslugiLayout);
        panelobslugiLayout.setHorizontalGroup(
            panelobslugiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelobslugiLayout.setVerticalGroup(
            panelobslugiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Zapiszklient.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        Zapiszklient.setCurrentDirectory(new java.io.File("C:\\Users\\Arkadye\\Desktop"));
        Zapiszklient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Otworzklient.setCurrentDirectory(new java.io.File("C:\\Users\\Arkadye\\Desktop"));

        Zapishistoria.setCurrentDirectory(new java.io.File("C:\\Users\\Arkadye\\Desktop"));

        Zapiszpo.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        Zapiszpo.setCurrentDirectory(new java.io.File("C:\\Users\\Arkadye\\Desktop"));

        Realizuj.setMinimumSize(new java.awt.Dimension(400, 300));
        Realizuj.setResizable(false);

        jButton15.setText("Realizuj");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane8.setViewportView(jTextArea8);

        jButton16.setText("Anuluj");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RealizujLayout = new javax.swing.GroupLayout(Realizuj.getContentPane());
        Realizuj.getContentPane().setLayout(RealizujLayout);
        RealizujLayout.setHorizontalGroup(
            RealizujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RealizujLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RealizujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(RealizujLayout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        RealizujLayout.setVerticalGroup(
            RealizujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RealizujLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(RealizujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Zapiszamowien.setMinimumSize(new java.awt.Dimension(400, 250));
        Zapiszamowien.setResizable(false);

        jButton17.setText("Zapisz");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Anuluj");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ZapiszamowienLayout = new javax.swing.GroupLayout(Zapiszamowien.getContentPane());
        Zapiszamowien.getContentPane().setLayout(ZapiszamowienLayout);
        ZapiszamowienLayout.setHorizontalGroup(
            ZapiszamowienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZapiszamowienLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        ZapiszamowienLayout.setVerticalGroup(
            ZapiszamowienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZapiszamowienLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(ZapiszamowienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        Zapiszdane.setMinimumSize(new java.awt.Dimension(400, 300));
        Zapiszdane.setResizable(false);

        jButton19.setText("Zapisz");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Anuluj");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel24.setText("Zapis danych klienta");

        javax.swing.GroupLayout ZapiszdaneLayout = new javax.swing.GroupLayout(Zapiszdane.getContentPane());
        Zapiszdane.getContentPane().setLayout(ZapiszdaneLayout);
        ZapiszdaneLayout.setHorizontalGroup(
            ZapiszdaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZapiszdaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(152, 152, 152))
            .addGroup(ZapiszdaneLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        ZapiszdaneLayout.setVerticalGroup(
            ZapiszdaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZapiszdaneLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel24)
                .addGap(92, 92, 92)
                .addGroup(ZapiszdaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        Dane.setMinimumSize(new java.awt.Dimension(400, 300));
        Dane.setResizable(false);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane6.setViewportView(jTextArea5);

        jButton48.setText("Zamknij");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DaneLayout = new javax.swing.GroupLayout(Dane.getContentPane());
        Dane.getContentPane().setLayout(DaneLayout);
        DaneLayout.setHorizontalGroup(
            DaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DaneLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        DaneLayout.setVerticalGroup(
            DaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton48)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restauracja-Okno Klienta");
        setLocation(new java.awt.Point(200, 50));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        Panelklienta.setBackground(new java.awt.Color(255, 255, 102));
        Panelklienta.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        wyloguj.setBackground(new java.awt.Color(153, 153, 153));
        wyloguj.setText("wyloguj");
        wyloguj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wylogujActionPerformed(evt);
            }
        });

        zapisz.setBackground(new java.awt.Color(255, 153, 102));
        zapisz.setText("Zapisz zamówienie");
        zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszActionPerformed(evt);
            }
        });

        zamowienie.setBackground(new java.awt.Color(255, 153, 51));
        zamowienie.setText("Złóż zamówienie");
        zamowienie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zamowienieActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        Menu.setBackground(new java.awt.Color(204, 255, 255));
        Menu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Menu.setMinimumSize(new java.awt.Dimension(437, 23));

        Zupy.setBackground(new java.awt.Color(255, 255, 153));

        Rosol.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Rosol.setText("Margherita");
        Rosol.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                RosolMouseMoved(evt);
            }
        });

        Barszcz.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Barszcz.setText("Funghi");
        Barszcz.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BarszczMouseMoved(evt);
            }
        });

        poleinfo.setEditable(false);
        poleinfo.setBackground(new java.awt.Color(255, 255, 153));
        poleinfo.setColumns(20);
        poleinfo.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        poleinfo.setRows(5);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Mała: 15zł              Duża: 20zł");

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel26.setText("Salami");
        jLabel26.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel26MouseMoved(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel27.setText("Pikantna");
        jLabel27.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel27MouseMoved(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel28.setText("Tropikalna");
        jLabel28.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel28MouseMoved(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel29.setText("4 sery");
        jLabel29.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel29MouseMoved(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Mała: 20zł             Duża: 25zł");

        jLabel44.setText("Średnice: Mała 25cm, Duża 35cm");

        jButton23.setBackground(new java.awt.Color(255, 153, 51));
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Dodaj");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(255, 153, 51));
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("Dodaj");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 153, 51));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Dodaj");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(255, 153, 51));
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Dodaj");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(255, 153, 51));
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Dodaj");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(255, 153, 51));
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Dodaj");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(255, 153, 51));
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Dodaj");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(255, 153, 51));
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Dodaj");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(255, 153, 51));
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setText("Dodaj");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(255, 153, 51));
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Dodaj");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(255, 153, 51));
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Dodaj");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(255, 153, 51));
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("Dodaj");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ZupyLayout = new javax.swing.GroupLayout(Zupy);
        Zupy.setLayout(ZupyLayout);
        ZupyLayout.setHorizontalGroup(
            ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZupyLayout.createSequentialGroup()
                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZupyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel44))
                    .addGroup(ZupyLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel10))
                    .addGroup(ZupyLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rosol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Barszcz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ZupyLayout.createSequentialGroup()
                                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel43)
                            .addGroup(ZupyLayout.createSequentialGroup()
                                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(poleinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        ZupyLayout.setVerticalGroup(
            ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZupyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poleinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZupyLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jButton24)
                    .addComponent(Rosol, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton25)
                    .addComponent(Barszcz, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jButton26)
                    .addComponent(jButton27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jButton28)
                    .addComponent(jButton29))
                .addGap(18, 18, 18)
                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jButton30)
                    .addComponent(jButton31))
                .addGap(18, 18, 18)
                .addGroup(ZupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jButton32)
                    .addComponent(jButton33))
                .addGap(35, 35, 35)
                .addComponent(jLabel44)
                .addContainerGap())
        );

        Menu.addTab("Pizze", Zupy);

        Dodatki.setBackground(new java.awt.Color(255, 204, 153));
        Dodatki.setForeground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel30.setText("Dodatkowy ser");

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel31.setText("Sos czosnkowy");

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel32.setText("Sos pomidorowy");

        jLabel33.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel33.setText("Sos meksykański");

        jButton34.setBackground(new java.awt.Color(204, 102, 0));
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Dodaj");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(204, 102, 0));
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Dodaj");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(204, 102, 0));
        jButton36.setForeground(new java.awt.Color(255, 255, 255));
        jButton36.setText("Dodaj");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(204, 102, 0));
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("Dodaj");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Wszystkie dodatki - 5 zł");

        javax.swing.GroupLayout DodatkiLayout = new javax.swing.GroupLayout(Dodatki);
        Dodatki.setLayout(DodatkiLayout);
        DodatkiLayout.setHorizontalGroup(
            DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DodatkiLayout.createSequentialGroup()
                .addGroup(DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DodatkiLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(107, 107, 107)
                        .addGroup(DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton37)
                            .addComponent(jButton36)
                            .addComponent(jButton35)
                            .addComponent(jButton34)))
                    .addGroup(DodatkiLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel9)))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        DodatkiLayout.setVerticalGroup(
            DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DodatkiLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jButton34))
                .addGap(18, 18, 18)
                .addGroup(DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jButton35))
                .addGap(18, 18, 18)
                .addGroup(DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jButton36))
                .addGap(18, 18, 18)
                .addGroup(DodatkiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jButton37))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        Menu.addTab("Dodatki", Dodatki);

        Desery.setBackground(new java.awt.Color(204, 255, 153));

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel34.setText("Cezar");
        jLabel34.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel34MouseMoved(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel35.setText("Grecka");
        jLabel35.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel35MouseMoved(evt);
            }
        });
        jLabel35.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jLabel35ComponentMoved(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel36.setText("Grillowa");
        jLabel36.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel36MouseMoved(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel37.setText("Chilli");
        jLabel37.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel37MouseMoved(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Każda sałatka:  10zł");

        jButton39.setBackground(new java.awt.Color(102, 153, 0));
        jButton39.setForeground(new java.awt.Color(255, 255, 255));
        jButton39.setText("Dodaj");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setBackground(new java.awt.Color(102, 153, 0));
        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.setText("Dodaj");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(102, 153, 0));
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.setText("Dodaj");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(102, 153, 0));
        jButton42.setForeground(new java.awt.Color(255, 255, 255));
        jButton42.setText("Dodaj");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jTextArea6.setBackground(new java.awt.Color(204, 255, 153));
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jTextArea6.setRows(5);

        javax.swing.GroupLayout DeseryLayout = new javax.swing.GroupLayout(Desery);
        Desery.setLayout(DeseryLayout);
        DeseryLayout.setHorizontalGroup(
            DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeseryLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DeseryLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(316, 316, 316))
                    .addGroup(DeseryLayout.createSequentialGroup()
                        .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton41)
                            .addComponent(jButton42)
                            .addComponent(jButton39)
                            .addComponent(jButton40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        DeseryLayout.setVerticalGroup(
            DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeseryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeseryLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jButton39))
                        .addGap(18, 18, 18)
                        .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jButton40))
                        .addGap(18, 18, 18)
                        .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jButton41))
                        .addGap(18, 18, 18)
                        .addGroup(DeseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jButton42)))
                    .addGroup(DeseryLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu.addTab("Sałatki", Desery);

        Napoje.setBackground(new java.awt.Color(255, 153, 102));

        jLabel38.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel38.setText("Herbata");

        jLabel39.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel39.setText("Kawa");

        jLabel40.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel40.setText("Coca cola [0,5l]");

        jLabel41.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel41.setText("Nestea [0,5l]");

        jLabel42.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel42.setText("Woda minerala [0,5l]");

        jButton43.setBackground(new java.awt.Color(204, 0, 0));
        jButton43.setForeground(new java.awt.Color(255, 255, 255));
        jButton43.setText("Dodaj");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setBackground(new java.awt.Color(204, 0, 0));
        jButton44.setForeground(new java.awt.Color(255, 255, 255));
        jButton44.setText("Dodaj");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setBackground(new java.awt.Color(204, 0, 0));
        jButton45.setForeground(new java.awt.Color(255, 255, 255));
        jButton45.setText("Dodaj");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(204, 0, 0));
        jButton46.setForeground(new java.awt.Color(255, 255, 255));
        jButton46.setText("Dodaj");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(204, 0, 0));
        jButton47.setForeground(new java.awt.Color(255, 255, 255));
        jButton47.setText("Dodaj");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Cena:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("4 zł");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("4 zł");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("5 zł");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("5 zł");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("3 zł");

        javax.swing.GroupLayout NapojeLayout = new javax.swing.GroupLayout(Napoje);
        Napoje.setLayout(NapojeLayout);
        NapojeLayout.setHorizontalGroup(
            NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NapojeLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NapojeLayout.createSequentialGroup()
                        .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton43)
                            .addComponent(jButton44)
                            .addComponent(jButton45)
                            .addComponent(jButton46)
                            .addComponent(jButton47))
                        .addGap(234, 234, 234))
                    .addGroup(NapojeLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        NapojeLayout.setVerticalGroup(
            NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NapojeLayout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(20, 20, 20)
                .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jButton43)
                    .addComponent(jLabel45))
                .addGap(18, 18, 18)
                .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jButton44)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jButton45)
                    .addComponent(jLabel47))
                .addGap(18, 18, 18)
                .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jButton46)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(NapojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jButton47)
                    .addComponent(jLabel49))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        Menu.addTab("Napoje", Napoje);

        jButton6.setBackground(new java.awt.Color(255, 153, 153));
        jButton6.setText("Otwórz zamówienie");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("RAZEM:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel17.setText("PLN");

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        jButton22.setText("Wyślij");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("jLabel25");

        jButton38.setText("Wyczyść zamówienie");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jScrollPane1.setViewportView(jTextArea9);

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel51.setText("Czas realizacji:");

        javax.swing.GroupLayout PanelklientaLayout = new javax.swing.GroupLayout(Panelklienta);
        Panelklienta.setLayout(PanelklientaLayout);
        PanelklientaLayout.setHorizontalGroup(
            PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelklientaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelklientaLayout.createSequentialGroup()
                        .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelklientaLayout.createSequentialGroup()
                                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelklientaLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelklientaLayout.createSequentialGroup()
                                        .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelklientaLayout.createSequentialGroup()
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                                .addGap(57, 57, 57))
                                            .addGroup(PanelklientaLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel51)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(102, 102, 102))
                                    .addGroup(PanelklientaLayout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zapisz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wyloguj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zamowienie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelklientaLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addGap(0, 46, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(PanelklientaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        PanelklientaLayout.setVerticalGroup(
            PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelklientaLayout.createSequentialGroup()
                .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelklientaLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelklientaLayout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelklientaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton38)
                        .addGap(13, 13, 13)
                        .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zamowienie, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelklientaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelklientaLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(PanelklientaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelklientaLayout.createSequentialGroup()
                                .addComponent(zapisz, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wyloguj, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelklientaLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 48, Short.MAX_VALUE))
        );

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane9.setViewportView(jTextArea7);

        jButton13.setText("Zapisz");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Wróć");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HistzamowLayout = new javax.swing.GroupLayout(Histzamow);
        Histzamow.setLayout(HistzamowLayout);
        HistzamowLayout.setHorizontalGroup(
            HistzamowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HistzamowLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(HistzamowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HistzamowLayout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        HistzamowLayout.setVerticalGroup(
            HistzamowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HistzamowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(HistzamowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 102));

        jMenu1.setText("Edycja");

        jMenuItem1.setText("Zamówienie");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Historia zamówień");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem6.setText("Dane klienta");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem3.setText("Wyjście");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelklienta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Histzamow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelklienta, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Histzamow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
Panelklienta.setVisible(true);   
Histzamow.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
Panelklienta.setVisible(false);   
Histzamow.setVisible(true);  
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
Zapishistoria.setFileFilter(filter);
   int odpowiedz = Zapishistoria.showSaveDialog(this);
   if (odpowiedz == Zapishistoria.APPROVE_OPTION) {
       File file = Zapishistoria.getSelectedFile();
       try {
           FileWriter out = new FileWriter(file);
           String text = jTextArea7.getText();
           out.write(text.replaceAll("\n", System.getProperty("line.separator")));
           out.close();

       } catch (IOException e) {
           System.out.println("Nie mogę zapisać pliku: "+file.getAbsolutePath());
           System.out.println("Problem: "+e);
       } 
   }// TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Panelklienta.setVisible(true);
        Histzamow.setVisible(false);              // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
FileNameExtensionFilter filter = new FileNameExtensionFilter("Plik tekstowy", "txt", "text");
Zapiszpo.setFileFilter(filter);
        int odpowiedz = Zapiszpo.showSaveDialog(this);
   if (odpowiedz == Zapiszpo.APPROVE_OPTION) {
       File file = Zapiszpo.getSelectedFile();
       try {
           FileWriter out = new FileWriter(file);
           String text = jTextArea2.getText();
           out.write(text.replaceAll("\n", System.getProperty("line.separator")));
           out.close();
         
       } catch (IOException e) {
           System.out.println("Nie mogę zapisać pliku: "+file.getAbsolutePath());
           System.out.println("Problem: "+e);
       } 
   }     
   Zapiszdane.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
Zapiszdane.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        Zapiszamowien.dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        Zapiszpo.setFileFilter(filter);
        int odpowiedz = Zapiszpo.showSaveDialog(this);
        if (odpowiedz == Zapiszpo.APPROVE_OPTION) {
            File file = Zapiszpo.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file);
              
                    String text = jTextArea1.getText()+"\n"+jTextArea2.getText();
                    out.write(text.replaceAll("\n", System.getProperty("line.separator")));
                    out.close();
               
            } catch (IOException e) {
                System.out.println("Nie mogę zapisać pliku: "+file.getAbsolutePath());
                System.out.println("Problem: "+e);
            }
        }
        Zapiszamowien.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        DefaultListModel model = (DefaultListModel)jList1.getModel();
        int index=jList1.getSelectedIndex();
        int size = model.getSize();
        if (size>0){
            jTextArea1.setText(tab[index+1]);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        panelobslugi.dispose();
        oknostart.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        DefaultListModel model = (DefaultListModel)jList1.getModel();
        model.removeAllElements();
        i=1;
        jTextArea1.setText("");
        jTextArea2.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Zapiszdane.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Zapiszamowien.setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 
        Realizuj.setVisible(true); 
        jTextArea8.append(jTextArea1.getText());
        jTextArea8.append(jTextArea2.getText());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void miejscowoscrejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miejscowoscrejActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miejscowoscrejActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Rejestracja.setVisible(false);
        Logowanie.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Rejestracja.setVisible(false);
        Logowanie.setVisible(true);
        
        String imie=imierej.getText();
        String nazwisko=nazwiskorej.getText();
        String email=emailrej.getText();
        String login=loginrej.getText();
        String haslo=passwdrej.getText();
        String ulica=ulicarej.getText();
        String mieszkanie=mieszrej.getText();
        String kod=kodrej.getText();
        String miejscowosc=miejscowoscrej.getText();
        String telefon=telefonrej.getText();
       
         
        try{
            rs.last();
            int licznik = rs.getInt("ID");
            rs.moveToInsertRow();
            rs.updateInt("ID",licznik+1);
            rs.updateString("Imie", imie);
            rs.updateString("Nazwisko", nazwisko);
            rs.updateString("Login", login);
            rs.updateString("Haslo", haslo);
            rs.updateString("Email", email);
            rs.updateString("Ulica", ulica);
            rs.updateString("Mieszkanie", mieszkanie);
            rs.updateString("Kod", kod);
            rs.updateString("Miejscowosc", miejscowosc);
            rs.updateString("Telefon", telefon);
           
            rs.insertRow();
             
            stmt.close();
            rs.close();
             
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM Uzytkownicy";
            rs = stmt.executeQuery(sql);
         
            rs.next();
            
            String imie2 = rs.getString("Imie");
            String nazwisko2 = rs.getString("Nazwisko");
            String email2=rs.getString("Email");
            String login2=rs.getString("Login");
            String haslo2=rs.getString("Haslo");
            String ulica2=rs.getString("Ulica");
            String mieszkanie2=rs.getString("Mieszkanie");
            String kod2=rs.getString("Kod");
            String miejscowosc2=rs.getString("Miejscowosc");
            String telefon2=rs.getString("Telefon");
             
            
            imierej.setText(imie2);
            nazwiskorej.setText(nazwisko2);
            emailrej.setText(email2);
            loginrej.setText(login2);
            passwdrej.setText(haslo2);
            ulicarej.setText(ulica2);
            mieszrej.setText(mieszkanie2);
            kodrej.setText(kod2);
            miejscowoscrej.setText(miejscowosc2);
            telefonrej.setText(telefon2);
         
            stmt.close();
            rs.close();
             
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nazwiskorejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nazwiskorejActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nazwiskorejActionPerformed

    private void imierejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imierejActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imierejActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Rejestracja.setVisible(true);
        Logowanie.setVisible(false);

             
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel8.setText("Witamy " + jTextField1.getText());
        String log=jTextField1.getText();
        String has=jPasswordField1.getText();
        
        if (jCheckBox1.isSelected()){
            try {
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs=stmt.executeQuery("SELECT * FROM Uzytkownicy WHERE Login='"+log+"' AND Haslo='"+has+"'");
                
                if(rs.next()){ 
                jTextArea5.append(rs.getString("Login")+" | ");
                jTextArea5.append(rs.getString("Imie")+" | ");
                jTextArea5.append(rs.getString("Nazwisko")+" | ");
                jTextArea5.append(rs.getString("Ulica")+" | ");
                jTextArea5.append(rs.getString("Mieszkanie")+" | ");
                jTextArea5.append(rs.getString("Kod")+" | ");
                jTextArea5.append(rs.getString("Miejscowosc")+" | ");
                jTextArea5.append(rs.getString("Email")+" | ");
                jTextArea5.append(rs.getString("Telefon")+" | ");
                    
               this.setVisible(true);
            oknostart.setVisible(false);
            Panelklienta.setVisible(true);
            Histzamow.setVisible(false);
            conn = new Siec(this, false , "localhost");
            jTextField1.setText("");
            jPasswordField1.setText("");
            Zegar zegar = new Zegar(jLabel25);
            
            zegar.start();
                }
            stmt.close();
            rs.close();
            } catch (SQLException err) {
                 System.out.println(err.getMessage());
                    }
           // Klient polklient = new Klient(jTextArea4,jTextField7,jTextArea5);
    //polklient.start();
            
        }
        else
        {
            if(log.equals("admin") & has.equals("obsluga12")){
            conn = new Siec(this, true , "localhost");
            panelobslugi.setVisible(true);
            oknostart.setVisible(false);
            //Serwer polserwer = new Serwer(jTextArea3,jTextField6,jTextArea1);
            //polserwer.start();
            }
            
        }
        
       //new jFrame1().setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        Otworzklient.setFileFilter(filter);
        int odpowiedz = Otworzklient.showOpenDialog(this);
        if (odpowiedz == Otworzklient.APPROVE_OPTION) {
            File file = Otworzklient.getSelectedFile();
            try {
                jTextArea9.read( new FileReader( file.getAbsolutePath() ), null );
            } catch (IOException e) {
                System.out.println("Nie mogę otworzyć pliku: "+file.getAbsolutePath());
                System.out.println("Problem: "+e);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BarszczMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarszczMouseMoved
        poleinfo.setText("Składniki: \n sos pomidorowy\n ser mozzarella\n przyprawy\n pieczarki ") ;        // TODO add your handling code here:
    }//GEN-LAST:event_BarszczMouseMoved

    private void RosolMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RosolMouseMoved
        poleinfo.setText("Składniki: \n sos pomidorowy\n ser mozzarella\n przyprawy ") ;  // TODO add your handling code here:
    }//GEN-LAST:event_RosolMouseMoved

    private void zamowienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zamowienieActionPerformed
        if(jTextArea9.getText().equals("")){
            jLabel19.setText("Nie wybrano nic");
        }else{
            
            
           // Klient.pauza=false;
            DefaultListModel model = (DefaultListModel)jList1.getModel();
            model.addElement("Zamówienie " + i);
            tab[i]= jTextArea9.getText();
            //i++;
            jLabel19.setText("");
            kwota=0;
            zamSend();
           Minutnikk min = new Minutnikk(jLabel50);
           min.start();
            
        }
        jTextArea7.append(jTextArea9.getText()+ "\n****************************************\n");
        //jTextPane1.setText("");
        jTextField4.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_zamowienieActionPerformed

    private void zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        Zapiszklient.setFileFilter(filter);
        int odpowiedz = Zapiszklient.showSaveDialog(this);

        if (odpowiedz == Zapiszklient.APPROVE_OPTION) {
            File file = Zapiszklient.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file);
                String text = jTextArea9.getText();
                out.write(text.replaceAll("\n", System.getProperty("line.separator")));
                out.close();
            } catch (IOException e) {
                System.out.println("Nie mogę zapisać pliku: "+file.getAbsolutePath());
                System.out.println("Problem: "+e);
            }
        }
    }//GEN-LAST:event_zapiszActionPerformed

    private void wylogujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wylogujActionPerformed
        this.dispose();
        oknostart.setVisible(true);

    }//GEN-LAST:event_wylogujActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
//Serwer.pauzaa=false; 
//jTextArea3.setCaretPosition(jTextArea3.getText().length()+1);
chatSend();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
//Klient.pauza=false;
//jTextArea4.setCaretPosition(jTextArea4.getText().length()+1);
chatSend();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
jTextArea9.append("Margherita - duża | ");
kwota=kwota+20;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
jTextArea9.append("Margherita - mała | ");
kwota=kwota+15;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);// TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
jTextArea9.append("Funghi - mała | ");
kwota=kwota+15;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
jTextArea9.append("Funghi - duża | ");
kwota=kwota+20;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
jTextArea9.append("Salami - mała | ");
kwota=kwota+15;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
jTextArea9.append("Salami - duża | ");
kwota=kwota+20;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
jTextArea9.append("Pikanta - mała | ");
kwota=kwota+20;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
      jTextArea9.append("Pikanta - duża | ");
kwota=kwota+25;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
     jTextArea9.append("Tropikalna - mała | ");
kwota=kwota+20;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);     // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
jTextArea9.append("Tropikalna - duża | ");
kwota=kwota+25;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
jTextArea9.append("4sery - mała | ");
kwota=kwota+20;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
jTextArea9.append("4sery - duża | ");
kwota=kwota+25;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
jTextArea9.append("Dodatkowy ser | ");
kwota=kwota+5;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
jTextArea9.append("Sos czosnkowy | ");
kwota=kwota+5;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
jTextArea9.setText("");
jTextField4.setText("");
kwota=0;// TODO add your handling code here:
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
     jTextArea9.append("Sos pomidorowy | ");
kwota=kwota+5;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
jTextArea9.append("Sos meksykański | ");
kwota=kwota+5;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
       jTextArea9.append("Sałatka Cezar | ");
kwota=kwota+10;
String suma=Integer.toString(kwota);
jTextField4.setText(suma); // TODO add your handling code here:
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
jTextArea9.append("Sałatka Grecka | ");
kwota=kwota+10;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
jTextArea9.append("Sałatka Grillowa | ");
kwota=kwota+10;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
jTextArea9.append("Sałatka Chilli | ");
kwota=kwota+10;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
jTextArea9.append("Herbata | ");
kwota=kwota+4;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
jTextArea9.append("Kawa | ");
kwota=kwota+4;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
jTextArea9.append("Coca cola | ");
kwota=kwota+5;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
jTextArea9.append("Nestea | ");
kwota=kwota+5;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
jTextArea9.append("Woda mineralna  ");
kwota=kwota+3;
String suma=Integer.toString(kwota);
jTextField4.setText(suma);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jLabel26MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseMoved
 poleinfo.setText("Składniki: \n sos pomidorowy\n ser mozzarella\n przyprawy\n salami ");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseMoved

    private void jLabel27MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseMoved
     poleinfo.setText("Składniki: \n sos pomidorowy\n ser mozzarella\n przyprawy\n szynka\n papryka chilli ");   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseMoved

    private void jLabel28MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseMoved
         poleinfo.setText("Składniki: \n sos pomidorowy\n ser mozzarella\n przyprawy\n szynka\n ananas\n kukurydza "); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseMoved

    private void jLabel29MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseMoved
 poleinfo.setText("Składniki: \n sos pomidorowy\n przyprawy\n ser mozzarella\n ser feta\n ser parmezan\n ser camembert");         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseMoved

    private void jLabel34MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseMoved
jTextArea6.setText("Składniki: \n sałata\n kurczak \n pomidor\n przyprawy\n ser parmezan");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseMoved

    private void jLabel35ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel35ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35ComponentMoved

    private void jLabel35MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseMoved
jTextArea6.setText("Składniki: \n sałata\n ser feta \n pomidor\n przyprawy\n oliwki\n cebula");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseMoved

    private void jLabel36MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseMoved
jTextArea6.setText("Składniki: \n sałata\n grillowana kiełbasa \n pomidor\n ogórek\n cebula\n przyprawy");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel36MouseMoved

    private void jLabel37MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseMoved
jTextArea6.setText("Składniki: \n sałata\n kurczak \n pomidor\n przyprawy\n papryka chilli");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MouseMoved

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       Dane.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
Dane.setVisible(false);    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
Realizuj.dispose();
jTextArea8.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new strglowna();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Barszcz;
    private javax.swing.JDialog Dane;
    private javax.swing.JPanel Desery;
    private javax.swing.JPanel Dodatki;
    private javax.swing.JPanel Histzamow;
    private javax.swing.JPanel Logowanie;
    private javax.swing.JTabbedPane Menu;
    private javax.swing.JPanel Napoje;
    private javax.swing.JFileChooser Otworzklient;
    private javax.swing.JPanel Panelklienta;
    private javax.swing.JDialog Realizuj;
    private javax.swing.JPanel Rejestracja;
    private javax.swing.JLabel Rosol;
    private javax.swing.JFileChooser Zapishistoria;
    private javax.swing.JDialog Zapiszamowien;
    private javax.swing.JDialog Zapiszdane;
    private javax.swing.JFileChooser Zapiszklient;
    private javax.swing.JFileChooser Zapiszpo;
    private javax.swing.JPanel Zupy;
    private javax.swing.JTextField emailrej;
    private javax.swing.JTextField imierej;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField kodrej;
    private javax.swing.JTextField loginrej;
    private javax.swing.JTextField miejscowoscrej;
    private javax.swing.JTextField mieszrej;
    private javax.swing.JTextField nazwiskorej;
    private javax.swing.JFrame oknostart;
    private javax.swing.JFrame panelobslugi;
    private javax.swing.JPasswordField passwdrej;
    private javax.swing.JTextArea poleinfo;
    private javax.swing.JTextField telefonrej;
    private javax.swing.JTextField ulicarej;
    private javax.swing.JButton wyloguj;
    private javax.swing.JButton zamowienie;
    private javax.swing.JButton zapisz;
    // End of variables declaration//GEN-END:variables

 
}
