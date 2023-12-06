package SaharaReceiving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    JTextField name;
    JPasswordField password;
    JCheckBox checkBox;
  //  int attempts = 3;
    JLabel label, l1, l2, l3, l4;
    JFrame frame1;
    JLabel i1, i2, i3, i4, i5;
    JTextField textname, email, phone_no;
    JPasswordField password1;
    JCheckBox checkBox1;
    JButton t1, t2;
    File file;
    JFileChooser fileChooser;
    FileReader fileReader;
    FileWriter fileWriter;
    RandomAccessFile randomAccessFile;
    int ln;
    String forUser;
    String forPass;
    String user;
    String pass;
    String line,Username,Password,Email,Phone_no;
    Main(String User) {

        setBounds(500, 230, 450, 300);
      //  getContentPane().setBackground(Color.lightGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        label = new JLabel("Login");
        label.setBounds(190, 15, 80, 30);
        label.setFont(new Font("Monogolian Baiti", Font.BOLD, 25));
        add(label);
        // label for user name//
        l1 = new JLabel("User");
        l1.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l1.setForeground(Color.BLACK);
        l1.setBounds(60, 60, 80, 25);
        add(l1);
        // label for new box//
        l2 = new JLabel();
        l2.setFont(new Font("Monogolian", Font.BOLD, 11));
        l2.setForeground(Color.red);
        l2.setBackground(Color.red);
        l2.setBounds(146, 80, 120, 20);
        add(l2);
        // textField for password//
        name = new JTextField("Enter Username");
        name.setBounds(146, 60, 185, 22);
        name.setForeground(new Color(153, 153, 153));
        name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
//                try{
//                    int i =Integer.parseInt(password.getText());
//                    l2.setText("");
//                } catch (NumberFormatException e1){
//                    l2.setText("*Enter only Character");
//                }

            }
        });
        add(name);
        // place holder focus listener//
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name.getText().equals("Enter Username")) {
                    name.setText("");
                    name.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (name.getText().equals("")) {
                    name.setText("Enter Username");
                    name.setForeground(new Color(153, 153, 153));
                }
            }
        });
        // label for password//
        l3 = new JLabel("Password");
        l3.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l3.setForeground(Color.BLACK);
        l3.setBounds(60, 115, 80, 25);
        add(l3);
        // label for show box//
        l4 = new JLabel();
        l4.setFont(new Font("Monogolian", Font.BOLD, 10));
        l4.setForeground(Color.red);
        l4.setBackground(Color.red);
        l4.setBounds(146, 130, 90, 20);
        add(l4);
        // passwordField for password
        password = new JPasswordField("Enter Password");
        password.setBounds(146, 115, 185, 22);
        password.setForeground(new Color(153, 153, 153));
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
////                try{
//                    int i =Integer.parseInt(t2.getText());
//                    l4.setText("");
//            } catch (NumberFormatException e1){
//                    l4.setText("*Invalid number");
//                }
            }
        });
        add(password);
        // placeholder for focus listener//
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (password.getText().equals("Enter Password")) {
                    password.setText("");
                    password.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getText().equals("")) {
                    password.setText("Enter Password");
                    password.setForeground(new Color(153, 153, 153));
                }
            }
        });
        // checkbox //
        checkBox = new JCheckBox("Show Password");
        checkBox.setBounds(160, 155, 120, 25);
        checkBox.setBackground(Color.LIGHT_GRAY);
        checkBox.setMnemonic(KeyEvent.VK_C);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar('*');
                }
            }
        });
        add(checkBox);
        // button for login//
        b1 = new JButton("Login");
        b1.setBounds(80, 200, 80, 25);
        b1.setBackground(Color.lightGray);
        b1.setForeground(Color.black);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ///////login ---====-==--=
                user = name.getText();
                pass = password.getText();
                file = new File("logs_msg");
               // createFolder//
                if (file.exists()){
                     file.mkdirs();
                }
                // readFile//
                try{
                    fileReader = new FileReader(file+"\\logins.txt");
                    System.out.println("file exists!");
                }catch (FileNotFoundException e1){
                    try{
                        fileWriter= new FileWriter(file+"\\logins.txt");
                        System.out.println("File created");
                    }catch (IOException e2){
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e2);
                    }
                }
                 // checkData//
                try{
                    randomAccessFile = new RandomAccessFile(file+"\\logins.txt","rw");
                    line = randomAccessFile.readLine();
                    Username=randomAccessFile.readLine().substring(9);
                    Password=randomAccessFile.readLine().substring(9);
                    Email=randomAccessFile.readLine().substring(6);
                    Phone_no=randomAccessFile.readLine().substring(6);
                    if (user.equals(Username)& pass.equals(Password)){
                        JOptionPane.showMessageDialog(null,"Password matched");
                        new function(user);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null,"Wrong User/Password");
                    }
                }catch (FileNotFoundException e1){
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                }catch (IOException e1){
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                }
       //countlines//
                try {
                    ln=1;
                    randomAccessFile = new RandomAccessFile(file+"\\logins.txt","rw");
                    for (int i =0;randomAccessFile.readLine()!=null;i++){
                        ln++;
                    }
                    System.out.println("number of lines:"+ln);
                }catch (FileNotFoundException e1){
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                }catch (IOException e1){
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                }
            }
        });
        //keyboard listener
        b1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    ///////login ---====-==--=
                    user = name.getText();
                    pass = password.getText();
                    file = new File("logs_msg");
                    // createFolder//
                    if (file.exists()){
                        file.mkdirs();
                    }
                    // readFile//
                    try{
                        fileReader = new FileReader(file+"\\logins.txt");
                        System.out.println("file exists!");
                    }catch (FileNotFoundException e1){
                        try{
                            fileWriter= new FileWriter(file+"\\logins.txt");
                            System.out.println("File created");
                        }catch (IOException e2){
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e2);
                        }
                    }
                    // checkData//
                    try{
                        randomAccessFile = new RandomAccessFile(file+"\\logins.txt","rw");
                        line = randomAccessFile.readLine();
                        Username=randomAccessFile.readLine().substring(9);
                        Password=randomAccessFile.readLine().substring(9);
                        Email=randomAccessFile.readLine().substring(6);
                        Phone_no=randomAccessFile.readLine().substring(6);
                        if (user.equals(Username)& pass.equals(Password)){
                            JOptionPane.showMessageDialog(null,"Password matched");
                            new function(user);
                            setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(null,"Wrong User/Password");
                        }
                    }catch (FileNotFoundException e1){
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                    }catch (IOException e1){
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                    }
                    //countlines//
                    try {
                        ln=1;
                        randomAccessFile = new RandomAccessFile(file+"\\logins.txt","rw");
                        for (int i =0;randomAccessFile.readLine()!=null;i++){
                            ln++;
                        }
                        System.out.println("number of lines:"+ln);
                    }catch (FileNotFoundException e1){
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                    }catch (IOException e1){
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e1);
                    }
                }
            }
        });
        add(b1);
        // button for exits
        b2 = new JButton("Create");
        b2.setBounds(180, 200, 83, 25);
        b2.setBackground(Color.lightGray);
        b2.setForeground(Color.black);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1 = new JFrame();
                frame1.getContentPane().setBackground(Color.lightGray);
                frame1.setBounds(527, 190, 400, 390);
                // frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.setLayout(null);

                i1 = new JLabel("Create Login..");
                i1.setBounds(122, 15, 240, 30);
                i1.setFont(new Font("Monogolian Baiti", Font.BOLD, 25));
                frame1.add(i1);

                i2 = new JLabel("User");
                i2.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                i2.setForeground(Color.BLACK);
                i2.setBounds(50, 66, 80, 25);
                frame1.add(i2);

                textname = new JTextField("Enter Username");
                textname.setBounds(146, 66, 185, 22);
                textname.setForeground(new Color(153, 153, 153));
                textname.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                    }
                });
                frame1.add(textname);
                textname.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (textname.getText().equals("Enter Username")) {
                            textname.setText("");
                            textname.setForeground(Color.BLACK);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (textname.getText().equals("")) {
                            textname.setText("Enter Username");
                            textname.setForeground(new Color(153, 153, 153));
                        }
                    }
                });

                i3 = new JLabel("Password");
                i3.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                i3.setForeground(Color.BLACK);
                i3.setBounds(50, 120, 80, 25);
                frame1.add(i3);

                password1 = new JPasswordField("Enter Password");
                password1.setBounds(146, 120, 185, 22);
                password1.setForeground(new Color(153, 153, 153));
                password1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                    }
                });
                frame1.add(password1);
                password1.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (password1.getText().equals("Enter Password")) {
                            password1.setText("");
                            password1.setForeground(Color.BLACK);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (password1.getText().equals("")) {
                            password1.setText("Enter Password");
                            password1.setForeground(new Color(153, 153, 153));
                        }
                    }
                });

                checkBox1 = new JCheckBox();
                checkBox1.setBounds(340, 119, 120, 25);
                checkBox1.setBackground(Color.LIGHT_GRAY);
                checkBox1.setMnemonic(KeyEvent.VK_C);
                checkBox1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (checkBox1.isSelected()) {
                            password1.setEchoChar((char) 0);
                        } else {
                            password1.setEchoChar('*');
                        }
                    }
                });
                frame1.add(checkBox1);

                i4 = new JLabel("Email");
                i4.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                i4.setForeground(Color.BLACK);
                i4.setBounds(50, 174, 80, 25);
                frame1.add(i4);

                email = new JTextField("Enter Email");
                email.setBounds(146, 174, 185, 22);
                email.setForeground(new Color(153, 153, 153));
                email.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                    }
                });
                frame1.add(email);
                email.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (email.getText().equals("Enter Email")) {
                            email.setText("");
                            email.setForeground(Color.BLACK);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (email.getText().equals("")) {
                            email.setText("Enter Email");
                            email.setForeground(new Color(153, 153, 153));
                        }
                    }
                });

                i5 = new JLabel("Phone No.");
                i5.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                i5.setForeground(Color.BLACK);
                i5.setBounds(50, 227, 100, 25);
                frame1.add(i5);

                phone_no = new JTextField("Enter Phone Number");
                phone_no.setBounds(146, 227, 185, 22);
                phone_no.setForeground(new Color(153, 153, 153));
                phone_no.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                        String phoneNumber = phone_no.getText();
                        int length = phoneNumber.length();
                        char c = e.getKeyChar();
                        if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                            if (length < 10) {
                                phone_no.setEditable(true);
                            } else {
                                phone_no.setEditable(false);
                            }
                        } else {
                            if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                                phone_no.setEditable(true);
                            } else {
                                phone_no.setEditable(false);
                            }

                        }
                    }
                });
                frame1.add(phone_no);
                phone_no.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (phone_no.getText().equals("Enter Phone Number")) {
                            phone_no.setText("");
                            phone_no.setForeground(Color.BLACK);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (phone_no.getText().equals("")) {
                            phone_no.setText("Enter Phone Number");
                            phone_no.setForeground(new Color(153, 153, 153));
                        }
                    }
                });

                t1 = new JButton("Register");
                t1.setBounds(60, 290, 100, 25);
                t1.setBackground(Color.lightGray);
                t1.setForeground(Color.black);
                t1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ////////////////create login-=-=-=-=-=-=-=
                            String Usr = textname.getText();
                            String Pass = password1.getText();
                            String Mail = email.getText();
                            String Phone = phone_no.getText();
                            file = new File("logs_msg");
                            // createFolder//
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            // readFile//
                            try {
                                fileReader = new FileReader(file + "\\logins.txt");
                                System.out.println("file exists!");
                            } catch (FileNotFoundException e1) {
                                try {
                                    fileWriter = new FileWriter(file + "\\logins.txt");
                                    System.out.println("File created");
                                } catch (IOException e2) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e2);
                                }
                            }
                            //addData
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; i < ln; i++) {
                                    randomAccessFile.readLine();
                                }
                                //   randomAccessFile.writeBytes("\r\n");
                                randomAccessFile.writeBytes("\r\n");
                                randomAccessFile.writeBytes("Username:" + Usr + "\r\n");
                                randomAccessFile.writeBytes("Password:" + Pass + "\r\n");
                                randomAccessFile.writeBytes("Email:" + Mail + "\r\n");
                                randomAccessFile.writeBytes("Phone no:" + Phone + "\r\n");
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            //checkData//
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                line = randomAccessFile.readLine();
                                Username = randomAccessFile.readLine().substring(9);
                                Password = randomAccessFile.readLine().substring(9);
                                Email = randomAccessFile.readLine().substring(6);
                                Phone_no = randomAccessFile.readLine().substring(6);
                                if (Usr.equals(Username) & Pass.equals(Password)) {
                                    JOptionPane.showMessageDialog(null, "Login Generate");
                                    frame1.setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Wrong User/Password");
                                }
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            // logic//
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; i < ln; i += 4) {
                                    System.out.println("count" + i);
                                    forUser = randomAccessFile.readLine().substring(9);
                                    forPass = randomAccessFile.readLine().substring(9);
                                    if (Usr.equals(forUser) & Pass.equals(forPass)) {
                                        JOptionPane.showMessageDialog(null, "password matched");
                                        break;
                                    } else if (i == (ln - 3)) {
                                        JOptionPane.showMessageDialog(null, "incorrect username/password");
                                    }
                                    for (int k = 1; k <= 2; k++) {
                                        randomAccessFile.readLine();
                                    }
                                }
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            //countlines//
                            try {
                                ln = 1;
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; randomAccessFile.readLine() != null; i++) {
                                    ln++;
                                }
                                System.out.println("number of lines:" + ln);
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                    }
                });
                // keyboard listener
                t1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);
                        if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                            ////////////////create login-=-=-=-=-=-=-=
                            String Usr = textname.getText();
                            String Pass = password1.getText();
                            String Mail = email.getText();
                            String Phone = phone_no.getText();
                            file = new File("logs_msg");
                            // createFolder//
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            // readFile//
                            try {
                                fileReader = new FileReader(file + "\\logins.txt");
                                System.out.println("file exists!");
                            } catch (FileNotFoundException e1) {
                                try {
                                    fileWriter = new FileWriter(file + "\\logins.txt");
                                    System.out.println("File created");
                                } catch (IOException e2) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e2);
                                }
                            }
                            //addData
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; i < ln; i++) {
                                    randomAccessFile.readLine();
                                }
                                //   randomAccessFile.writeBytes("\r\n");
                                randomAccessFile.writeBytes("\r\n");
                                randomAccessFile.writeBytes("Username:" + Usr + "\r\n");
                                randomAccessFile.writeBytes("Password:" + Pass + "\r\n");
                                randomAccessFile.writeBytes("Email:" + Mail + "\r\n");
                                randomAccessFile.writeBytes("Phone no:" + Phone + "\r\n");
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            //checkData//
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                line = randomAccessFile.readLine();
                                Username = randomAccessFile.readLine().substring(9);
                                Password = randomAccessFile.readLine().substring(9);
                                Email = randomAccessFile.readLine().substring(6);
                                Phone_no = randomAccessFile.readLine().substring(6);
                                if (Usr.equals(Username) & Pass.equals(Password)) {
                                    JOptionPane.showMessageDialog(null, "Login Generate");
                                    frame1.setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Wrong User/Password");
                                }
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            // logic//
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; i < ln; i += 4) {
                                    System.out.println("count" + i);
                                    forUser = randomAccessFile.readLine().substring(9);
                                    forPass = randomAccessFile.readLine().substring(9);
                                    if (Usr.equals(forUser) & Pass.equals(forPass)) {
                                        JOptionPane.showMessageDialog(null, "password matched");
                                        break;
                                    } else if (i == (ln - 3)) {
                                        JOptionPane.showMessageDialog(null, "incorrect username/password");
                                    }
                                    for (int k = 1; k <= 2; k++) {
                                        randomAccessFile.readLine();
                                    }
                                }
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            //countlines//
                            try {
                                ln = 1;
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; randomAccessFile.readLine() != null; i++) {
                                    ln++;
                                }
                                System.out.println("number of lines:" + ln);
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                        }
                    }
                });
                frame1.add(t1);

                t2 = new JButton("Clear all");
                t2.setBounds(250, 290, 80, 25);
                t2.setBackground(Color.lightGray);
                t2.setForeground(Color.black);
                t2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textname.setText("");
                        password1.setText("");
                        email.setText("");
                        phone_no.setText("");
                    }
                });
                t2.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);
                        if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                            textname.setText("");
                            password1.setText("");
                            email.setText("");
                            phone_no.setText("");
                        }
                    }
                });
                frame1.add(t2);
                frame1.setVisible(true);
            }
        });
        // Keyboard Listener
        b2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    frame1 = new JFrame();
                    frame1.getContentPane().setBackground(Color.lightGray);
                    frame1.setBounds(527, 190, 400, 390);
                    // frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame1.setResizable(false);
                    frame1.setLayout(null);

                    i1 = new JLabel("Create Login..");
                    i1.setBounds(122, 15, 240, 30);
                    i1.setFont(new Font("Monogolian Baiti", Font.BOLD, 25));
                    frame1.add(i1);

                    i2 = new JLabel("User");
                    i2.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                    i2.setForeground(Color.BLACK);
                    i2.setBounds(50, 66, 80, 25);
                    frame1.add(i2);

                    textname = new JTextField("Enter Username");
                    textname.setBounds(146, 66, 185, 22);
                    textname.setForeground(new Color(153, 153, 153));
                    textname.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            super.keyPressed(e);
                        }
                    });
                    frame1.add(textname);
                    textname.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            if (textname.getText().equals("Enter Username")) {
                                textname.setText("");
                                textname.setForeground(Color.BLACK);
                            }
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            if (textname.getText().equals("")) {
                                textname.setText("Enter Username");
                                textname.setForeground(new Color(153, 153, 153));
                            }
                        }
                    });

                    i3 = new JLabel("Password");
                    i3.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                    i3.setForeground(Color.BLACK);
                    i3.setBounds(50, 120, 80, 25);
                    frame1.add(i3);

                    password1 = new JPasswordField("Enter Password");
                    password1.setBounds(146, 120, 185, 22);
                    password1.setForeground(new Color(153, 153, 153));
                    password1.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            super.keyPressed(e);
                        }
                    });
                    frame1.add(password1);
                    password1.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            if (password1.getText().equals("Enter Password")) {
                                password1.setText("");
                                password1.setForeground(Color.BLACK);
                            }
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            if (password1.getText().equals("")) {
                                password1.setText("Enter Password");
                                password1.setForeground(new Color(153, 153, 153));
                            }
                        }
                    });

                    checkBox1 = new JCheckBox();
                    checkBox1.setBounds(340, 119, 120, 25);
                    checkBox1.setBackground(Color.LIGHT_GRAY);
                    checkBox1.setMnemonic(KeyEvent.VK_C);
                    checkBox1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (checkBox1.isSelected()) {
                                password1.setEchoChar((char) 0);
                            } else {
                                password1.setEchoChar('*');
                            }
                        }
                    });
                    frame1.add(checkBox1);

                    i4 = new JLabel("Email");
                    i4.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                    i4.setForeground(Color.BLACK);
                    i4.setBounds(50, 174, 80, 25);
                    frame1.add(i4);

                    email = new JTextField("Enter Email");
                    email.setBounds(146, 174, 185, 22);
                    email.setForeground(new Color(153, 153, 153));
                    email.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            super.keyPressed(e);
                        }
                    });
                    frame1.add(email);
                    email.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            if (email.getText().equals("Enter Email")) {
                                email.setText("");
                                email.setForeground(Color.BLACK);
                            }
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            if (email.getText().equals("")) {
                                email.setText("Enter Email");
                                email.setForeground(new Color(153, 153, 153));
                            }
                        }
                    });

                    i5 = new JLabel("Phone No.");
                    i5.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
                    i5.setForeground(Color.BLACK);
                    i5.setBounds(50, 227, 100, 25);
                    frame1.add(i5);

                    phone_no = new JTextField("Enter Phone Number");
                    phone_no.setBounds(146, 227, 185, 22);
                    phone_no.setForeground(new Color(153, 153, 153));
                    phone_no.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            super.keyPressed(e);
                            String phoneNumber = phone_no.getText();
                            int length = phoneNumber.length();
                            char c = e.getKeyChar();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                if (length < 10) {
                                    phone_no.setEditable(true);
                                } else {
                                    phone_no.setEditable(false);
                                }
                            } else {
                                if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                                    phone_no.setEditable(true);
                                } else {
                                    phone_no.setEditable(false);
                                }

                            }
                        }
                    });
                    frame1.add(phone_no);
                    phone_no.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            if (phone_no.getText().equals("Enter Phone Number")) {
                                phone_no.setText("");
                                phone_no.setForeground(Color.BLACK);
                            }
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            if (phone_no.getText().equals("")) {
                                phone_no.setText("Enter Phone Number");
                                phone_no.setForeground(new Color(153, 153, 153));
                            }
                        }
                    });

                    t1 = new JButton("Rigester");
                    t1.setBounds(60, 290, 100, 25);
                    t1.setBackground(Color.lightGray);
                    t1.setForeground(Color.black);
                    t1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String Usr = textname.getText();
                            String Pass = password1.getText();
                            String Mail = email.getText();
                            String Phone = phone_no.getText();
                            file = new File("logs_msg");
                            // createFolder//
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            // readFile//
                            try {
                                fileReader = new FileReader(file + "\\logins.txt");
                                System.out.println("file exists!");
                            } catch (FileNotFoundException e1) {
                                try {
                                    fileWriter = new FileWriter(file + "\\logins.txt");
                                    System.out.println("File created");
                                } catch (IOException e2) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e2);
                                }
                            }
                            //addData
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; i < ln; i++) {
                                    randomAccessFile.readLine();
                                }
                                //   randomAccessFile.writeBytes("\r\n");
                                randomAccessFile.writeBytes("\r\n");
                                randomAccessFile.writeBytes("Username:" + Usr + "\r\n");
                                randomAccessFile.writeBytes("Password:" + Pass + "\r\n");
                                randomAccessFile.writeBytes("Email:" + Mail + "\r\n");
                                randomAccessFile.writeBytes("Phone no:" + Phone + "\r\n");
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            //checkData//
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                line = randomAccessFile.readLine();
                                Username = randomAccessFile.readLine().substring(9);
                                Password = randomAccessFile.readLine().substring(9);
                                Email = randomAccessFile.readLine().substring(6);
                                Phone_no = randomAccessFile.readLine().substring(6);
                                if (Usr.equals(Username) & Pass.equals(Password)) {
                                    JOptionPane.showMessageDialog(null, "Login Generate");
                                    frame1.setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Wrong User/Password");
                                }
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            // logic//
                            try {
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; i < ln; i += 4) {
                                    System.out.println("count" + i);
                                    forUser = randomAccessFile.readLine().substring(9);
                                    forPass = randomAccessFile.readLine().substring(9);
                                    if (Usr.equals(forUser) & Pass.equals(forPass)) {
                                        JOptionPane.showMessageDialog(null, "password matched");
                                        break;
                                    } else if (i == (ln - 3)) {
                                        JOptionPane.showMessageDialog(null, "incorrect username/password");
                                    }
                                    for (int k = 1; k <= 2; k++) {
                                        randomAccessFile.readLine();
                                    }
                                }
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                            //countlines//
                            try {
                                ln = 1;
                                randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                for (int i = 0; randomAccessFile.readLine() != null; i++) {
                                    ln++;
                                }
                                System.out.println("number of lines:" + ln);
                            } catch (FileNotFoundException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            } catch (IOException e1) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                            }
                        }
                    });
                    t1.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            super.keyTyped(e);
                            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                                String Usr = textname.getText();
                                String Pass = password1.getText();
                                String Mail = email.getText();
                                String Phone = phone_no.getText();
                                file = new File("logs_msg");
                                // createFolder//
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                // readFile//
                                try {
                                    fileReader = new FileReader(file + "\\logins.txt");
                                    System.out.println("file exists!");
                                } catch (FileNotFoundException e1) {
                                    try {
                                        fileWriter = new FileWriter(file + "\\logins.txt");
                                        System.out.println("File created");
                                    } catch (IOException e2) {
                                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e2);
                                    }
                                }
                                //addData
                                try {
                                    randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                    for (int i = 0; i < ln; i++) {
                                        randomAccessFile.readLine();
                                    }
                                    //   randomAccessFile.writeBytes("\r\n");
                                    randomAccessFile.writeBytes("\r\n");
                                    randomAccessFile.writeBytes("Username:" + Usr + "\r\n");
                                    randomAccessFile.writeBytes("Password:" + Pass + "\r\n");
                                    randomAccessFile.writeBytes("Email:" + Mail + "\r\n");
                                    randomAccessFile.writeBytes("Phone no:" + Phone + "\r\n");
                                } catch (FileNotFoundException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                } catch (IOException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                }
                                //checkData//
                                try {
                                    randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                    line = randomAccessFile.readLine();
                                    Username = randomAccessFile.readLine().substring(9);
                                    Password = randomAccessFile.readLine().substring(9);
                                    Email = randomAccessFile.readLine().substring(6);
                                    Phone_no = randomAccessFile.readLine().substring(6);
                                    if (Usr.equals(Username) & Pass.equals(Password)) {
                                        JOptionPane.showMessageDialog(null, "Login Generate");
                                        frame1.setVisible(false);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Wrong User/Password");
                                    }
                                } catch (FileNotFoundException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                } catch (IOException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                }
                                // logic//
                                try {
                                    randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                    for (int i = 0; i < ln; i += 4) {
                                        System.out.println("count" + i);
                                        forUser = randomAccessFile.readLine().substring(9);
                                        forPass = randomAccessFile.readLine().substring(9);
                                        if (Usr.equals(forUser) & Pass.equals(forPass)) {
                                            JOptionPane.showMessageDialog(null, "password matched");
                                            break;
                                        } else if (i == (ln - 3)) {
                                            JOptionPane.showMessageDialog(null, "incorrect username/password");
                                        }
                                        for (int k = 1; k <= 2; k++) {
                                            randomAccessFile.readLine();
                                        }
                                    }
                                } catch (FileNotFoundException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                } catch (IOException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                }
                                //countlines//
                                try {
                                    ln = 1;
                                    randomAccessFile = new RandomAccessFile(file + "\\logins.txt", "rw");
                                    for (int i = 0; randomAccessFile.readLine() != null; i++) {
                                        ln++;
                                    }
                                    System.out.println("number of lines:" + ln);
                                } catch (FileNotFoundException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                } catch (IOException e1) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
                                }
                            }
                        }
                    });
                    frame1.add(t1);

                    t2 = new JButton("Clear all");
                    t2.setBounds(250, 290, 80, 25);
                    t2.setBackground(Color.lightGray);
                    t2.setForeground(Color.black);
                    t2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textname.setText("");
                            password1.setText("");
                            email.setText("");
                            phone_no.setText("");
                        }
                    });
                    t2.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            super.keyTyped(e);
                            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                                textname.setText("");
                                password1.setText("");
                                email.setText("");
                                phone_no.setText("");
                            }
                        }
                    });
                    frame1.add(t2);
                    frame1.setVisible(true);
                }
            }
        });
        add(b2);
        setVisible(true);

        b3 = new JButton("Exits");
        b3.setBounds(285, 200, 80, 25);
        b3.setBackground(Color.lightGray);
        b3.setForeground(Color.black);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b1) {
                } else {
                    System.exit(0);
                }
            }
        });
        b3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER){
                    super.keyPressed(e);
                if (e.getSource() == b1) {
                } else {
                    System.exit(0);
                }
                }
            }
        });
        add(b3);
    }
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new Main("");
    }
}
