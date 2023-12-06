package SaharaReceiving;

import com.sun.jdi.Value;
import org.w3c.dom.events.Event;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.spi.FileTypeDetector;
import java.security.Key;
import java.sql.*;
import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class function extends JFrame implements ActionListener {

    ImageIcon background;
    JLabel myLabel;
    JLabel l0,l1,l2, l3, l4, l5, l6, l7, l8,l9;
    JTextField ID,Name,Date,Code,Daily,Monthly,FD,DCS,Renewal;
    JTable table;
    Object[] row;
    DefaultTableModel model;
    JScrollPane pane;
    TableColumnModel tableColumnModel;
    TableColumn tableColumn;
    TableColumn tableColumn1;
    JButton b0,b1,b2,b3,b4,b5;
    JRadioButtonMenuItem menuItem;
    JMenuBar menuBar;
    JSeparator separator;
    JMenu fileMenu, editMenu, helpMenu;
    JMenuItem newItem, openItem, saveItem, save_asItem, printItem, exitItem;
    DateFormat dateFormat;
    Date date;
    Calendar calendar;
    JComboBox comboBox;
    JFileChooser fileChooser;
    TableColumn column;
    FileReader fileReader;
    FileWriter fileWriter;
    PrintWriter printWriter;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    File file;
    MessageFormat header;
    MessageFormat footer;
     function(String user){

        setBounds(350, 90, 1000, 700);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        l0 = new JLabel("Receiving Book");
        l0.setBounds(400, 15, 250, 50);
        l0.setFont(new Font("Raleway", Font.BOLD, 27));
        l0.setForeground(Color.darkGray);
        add(l0);

        setVisible(true);

        // making comboBox
        comboBox = new JComboBox();
        comboBox.setBounds(388, 75, 230, 20);
        comboBox.setEditable(true);
        comboBox.setSelectedItem("");
        comboBox.addItem("Collection Receiving");
        comboBox.addItem("Golden Goble");
        comboBox.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                int d = comboBox.getSelectedIndex();
                if (d == 0) {
                    new function(user);
                    setVisible(false);
                }
                if (d == 1) {
                    new Options(user);
                    setVisible(false);
                }
            }
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {

            }
        });
        add(comboBox);
        comboBox.setVisible(true);
        // JLabel name
        l1 = new JLabel("ID");
        l1.setBounds(20,120,80,25);
        l1.setFont(new Font("Monogolian Baiti",Font.BOLD,15));
        l1.setForeground(Color.BLACK);
        getContentPane().add(l1);

        ID = new JTextField("");
        ID.setBounds(70,120,40,22);
        ID.setForeground(new Color(153,153,153));
        ID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                // Number key
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        getContentPane().add(ID);
        ID.setColumns(10);
        //place holder Focus listener
        ID.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ID.getText().equals("S_No")){
                    ID.setText("");
                }
                ID.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ID.getText().equals("")){
                    ID.setText("S_No");
                }
                ID.setForeground(new Color(153,153,153));
            }
        });

        l2 = new JLabel("Name");
        l2.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l2.setForeground(Color.BLACK);
        l2.setBounds(130, 120, 80, 25);
        getContentPane().add(l2);
         // JTextField Box

        Name = new JTextField("");
        Name.setBounds(180, 120, 100, 22);
        Name.setForeground(new Color(153,153,153));
        Name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                super.keyPressed(evt);
                // Accept only alphabets
                char c =evt.getKeyChar();
                if (Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
                    Name.setEditable(true);
                }else{
                    Name.setEditable(false);
                }
            }
        });
        getContentPane().add(Name);
        Name.setColumns(10);
        //place holder Focus listener
        Name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Name.getText().equals("Enter Name")){
                    Name.setText("");
                }
                Name.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Name.getText().equals("")){
                    Name.setText("Enter Name");
                }
                Name.setForeground(new Color(153,153,153));
            }
        });
        
         // background image
//         background = new ImageIcon(this.getClass().getResource("/sahara.png"));
//         myLabel = new JLabel(background);
//         myLabel.setBounds(0,0,250,150);
//         add(myLabel);

        // JLabel Date name
        l3 = new JLabel("Date");
        l3.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l3.setForeground(Color.BLACK);
        l3.setBounds(840, 20, 80, 25);
        getContentPane().add(l3);
       // JTextField Box
        Date = new JTextField();
        Date.setBounds(880, 20, 70, 22);
        Date.setEditable(false);
        getContentPane().add(Date);
        Date.setColumns(10);
         // JLabel Code
        l4 = new JLabel("Code");
        l4.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l4.setForeground(Color.BLACK);
        l4.setBounds(300, 120, 80, 25);
        getContentPane().add(l4);
        // JTextField Box
        Code = new JTextField("");
        Code.setBounds(350, 120, 100, 22);
        Code.setForeground(new Color(153,153,153));
        Code.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                super.keyTyped(evt);
                // Number key
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }

            }
        });
        getContentPane().add(Code);
        Code.setColumns(10);
        // place holder for focus gained
        Code.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Code.getText().equals("Enter Code")){
                    Code.setText("");
                }
                Code.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Code.getText().equals("")){
                    Code.setText("Enter Code");
                }
                Code.setForeground(new Color(153,153,153));
            }
        });
         // JLabel name Daily
        l5 = new JLabel("Daily");
        l5.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l5.setForeground(Color.BLACK);
        l5.setBounds(470, 120, 80, 25);
        getContentPane().add(l5);
         // JTextField Box
        Daily = new JTextField("");
        Daily.setBounds(520, 120, 100, 22);
        Daily.setForeground(new Color(153,153,153));
        Daily.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                super.keyTyped(evt);
                // Number Key
//                char c = evt.getKeyChar();
//                if (!Character.isDigit(c)){
//                    evt.consume();
//                }
            }
        });
        getContentPane().add(Daily);
        Daily.setColumns(10);
        // place holder for focus gained
        Daily.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Daily.getText().equals("Enter Daily")){
                    Daily.setText("");
                }
                Daily.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Daily.getText().equals("")){
                    Daily.setText("Enter Daily");
                }
                Daily.setForeground(new Color(153,153,153));
            }
        });
        // JLabel monthly
        l6 = new JLabel("Monthly");
        l6.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l6.setForeground(Color.BLACK);
        l6.setBounds(640, 120, 80, 25);
        getContentPane().add(l6);
        // Set JTextField
        Monthly= new JTextField("");
        Monthly.setBounds(710, 120, 100, 22);
        Monthly.setForeground(new Color(153,153,153));
        Monthly.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                super.keyTyped(evt);
                // Number Key Typed
//                char c = evt.getKeyChar();
//                if (!Character.isDigit(c)){
//                    evt.consume();
//                }
            }
        });
        getContentPane().add(Monthly);
        Monthly.setColumns(10);
        // place holder type
        Monthly.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Monthly.getText().equals("Enter Monthly")){
                    Monthly.setText("");
                }
                Monthly.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Monthly.getText().equals("")){
                    Monthly.setText("Enter Monthly");
                }
                Monthly.setForeground(new Color(153,153,153));
            }
        });
        // JLabel fd
        l7 = new JLabel("FD");
        l7.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l7.setForeground(Color.BLACK);
        l7.setBounds(825, 120, 80, 25);
        getContentPane().add(l7);
        // JTextField Box
        FD = new JTextField("");
        FD.setBounds(860, 120, 100, 22);
        FD.setForeground(new Color(153,153,153));
        FD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                super.keyTyped(evt);
                // Number key Type
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)){
                    evt.consume();
                }
            }
        });
        getContentPane().add(FD);
        FD.setColumns(10);
        // place holder Type
        FD.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (FD.getText().equals("Enter FD")){
                    FD.setText("");
                }
                FD.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (FD.getText().equals("")){
                    FD.setText("Enter FD");
                }
                FD.setForeground(new Color(153,153,153));
            }
        });
        // JLabel Dcs
        l8 = new JLabel("DCS");
        l8.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l8.setForeground(Color.BLACK);
        l8.setBounds(20, 170, 80, 25);
        getContentPane().add(l8);
        // JTextField Box
        DCS = new JTextField("");
        DCS.setBounds(70, 170, 100, 22);
        DCS.setForeground(new Color(153,153,153));
        DCS.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                super.keyTyped(evt);
                // Number key type
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)){
                    evt.consume();
                }
            }
        });
        getContentPane().add(DCS);
        DCS.setColumns(10);
        // place holder type
        DCS.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (DCS.getText().equals("Enter DCS")){
                    DCS.setText("");
                }
                DCS.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (DCS.getText().equals("")){
                    DCS.setText("Enter DCS");
                }
                DCS.setForeground(new Color(153,153,153));
            }
        });
        // JLabel Renewal
        l9 = new JLabel("Renewal");
        l9.setFont(new Font("Monogolian Baiti", Font.BOLD, 15));
        l9.setForeground(Color.BLACK);
        l9.setBounds(190, 170, 80, 25);
        getContentPane().add(l9);
        // JTextField Box
        Renewal = new JTextField("");
        Renewal.setBounds(270, 170, 90, 22);
        Renewal.setForeground(new Color(153,153,153));
        Renewal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                super.keyTyped(evt);
                // number key type
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)){
                    evt.consume();
                }
            }
        });
        getContentPane().add(Renewal);
        Renewal.setColumns(10);
        // place holder type
        Renewal.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Renewal.getText().equals("Enter Renewal")){
                    Renewal.setText("");
                }
                Renewal.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Renewal.getText().equals("")){
                    Renewal.setText("Enter Renewal");
                }
                Renewal.setForeground(new Color(153,153,153));
            }
        });
        // JButton JTextField
        b0 = new JButton("UPDATE");
        b0.setBounds(630,240,100,25);
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                try{
                if (i >= 0) {
                    model.setValueAt(ID.getText(), i, 0);
                    model.setValueAt(Name.getText(), i, 1);
                    model.setValueAt(Date.getText(), i, 2);
                    model.setValueAt(Code.getText(), i, 3);
                    model.setValueAt(Daily.getText(), i, 4);
                    model.setValueAt(Monthly.getText(), i, 5);
                    model.setValueAt(FD.getText(), i, 6);
                    model.setValueAt(DCS.getText(), i, 7);
                    model.setValueAt(Renewal.getText(), i, 8);
                    JOptionPane.showMessageDialog(null, "Record Updated Successfully");
                }else{
                    JOptionPane.showMessageDialog(null,"Please select Single Row For Update..");
                }
                        ID.setText("");
                        Name.setText("");
                      //  Date.setText("");
                        Code.setText("");
                        Daily.setText("");
                        Monthly.setText("");
                        FD.setText("");
                        DCS.setText("");
                        Renewal.setText("");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null,"Error");
                    }
            }
        });
        b0.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    int i = table.getSelectedRow();
                    try {
                        if (i >= 0) {
                            model.setValueAt(ID.getText(), i, 0);
                            model.setValueAt(Name.getText(), i, 1);
                            model.setValueAt(Date.getText(), i, 2);
                            model.setValueAt(Code.getText(), i, 3);
                            model.setValueAt(Daily.getText(), i, 4);
                            model.setValueAt(Monthly.getText(), i, 5);
                            model.setValueAt(FD.getText(), i, 6);
                            model.setValueAt(DCS.getText(), i, 7);
                            model.setValueAt(Renewal.getText(), i, 8);
                            JOptionPane.showMessageDialog(null, "Record Updated Successfully");
                        }else{
                            JOptionPane.showMessageDialog(null,"Please select Single Row For Update..");
                        }
                          ID.setText("");
                          Name.setText("");
                        //  Date.setText("");
                          Code.setText("");
                          Daily.setText("");
                          Monthly.setText("");
                          FD.setText("");
                          DCS.setText("");
                          Renewal.setText("");
                    } catch(Exception e1){
                        JOptionPane.showMessageDialog(null,"Error");
                    }
                }
            }
        });
        getContentPane().add(b0);

        b1 = new JButton("ADD DATA");
        b1.setBounds(745, 240, 100, 25);
        // by click mouse
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    row[0] = ID.getText();
                    row[1] = Name.getText();
                    row[2] = Date.getText();
                    row[3] = Code.getText();
                    row[4] = Daily.getText();
                    row[5] = Monthly.getText();
                    row[6] = FD.getText();
                    row[7] = DCS.getText();
                    row[8] = Renewal.getText();
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
                    ID.setText(null);
                    Name.setText(null);
                    Code.setText(null);
                    Daily.setText(null);
                    Monthly.setText(null);
                    FD.setText(null);
                    DCS.setText(null);
                    Renewal.setText(null);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
        // by click keyboard
        b1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    try{
                        row[0] = ID.getText();
                        row[1] = Name.getText();
                        row[2] = Date.getText();
                        row[3] = Code.getText();
                        row[4] = Daily.getText();
                        row[5] = Monthly.getText();
                        row[6] = FD.getText();
                        row[7] = DCS.getText();
                        row[8] = Renewal.getText();
                        model.addRow(row);
                        JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
                        ID.setText(null);
                        Name.setText(null);
                        Code.setText(null);
                        Daily.setText(null);
                        Monthly.setText(null);
                        FD.setText(null);
                        DCS.setText(null);
                        Renewal.setText(null);
                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,"Error");
                    }
                }
            }
        });
        getContentPane().add(b1);

        b2 = new JButton("DELETE");
        b2.setBounds(860, 240, 100, 25);
        b2.setMnemonic(KeyEvent.VK_DELETE);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                model =(DefaultTableModel) table.getModel();
                if (row >= 0) {
                    model.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Record Deleted Row Successfully");
                    try {
                        ID.setText(null);
                        Name.setText(null);
                        Code.setText(null);
                        Daily.setText(null);
                        Monthly.setText(null);
                        FD.setText(null);
                        DCS.setText(null);
                        Renewal.setText(null);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Please Select Single Row For Delete");
                }
            }
        });
        b2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    int row = table.getSelectedRow();
                    DefaultTableModel model =(DefaultTableModel) table.getModel();
                    if (row >= 0) {
                        model.removeRow(row);
                        try {
                            JOptionPane.showMessageDialog(null, "Record Deleted Row Successfully");
                            ID.setText(null);
                            Name.setText(null);
                            Code.setText(null);
                            Daily.setText(null);
                            Monthly.setText(null);
                            FD.setText(null);
                            DCS.setText(null);
                            Renewal.setText(null);
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Please Select Single Row For Delete");
                    }
                }
            }
        });
        revalidate();
        getContentPane().add(b2);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = table.getSelectedRow();
                model = (DefaultTableModel) table.getModel();
                ID.setText(model.getValueAt(selectedRow, 0).toString());
                Name.setText(model.getValueAt(selectedRow, 1).toString());
                Date.setText(model.getValueAt(selectedRow, 2).toString());
                Code.setText(model.getValueAt(selectedRow, 3).toString());
                Daily.setText(model.getValueAt(selectedRow, 4).toString());
                Monthly.setText(model.getValueAt(selectedRow, 5).toString());
                FD.setText(model.getValueAt(selectedRow, 6).toString());
                DCS.setText(model.getValueAt(selectedRow, 7).toString());
                Renewal.setText(model.getValueAt(selectedRow, 8).toString());

            }
        });
        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    int selectedRow = table.getSelectedRow();
                    model = (DefaultTableModel) table.getModel();
                    ID.setText(model.getValueAt(selectedRow, 0).toString());
                    Name.setText(model.getValueAt(selectedRow, 1).toString());
                    Date.setText(model.getValueAt(selectedRow, 2).toString());
                    Code.setText(model.getValueAt(selectedRow, 3).toString());
                    Daily.setText(model.getValueAt(selectedRow, 4).toString());
                    Monthly.setText(model.getValueAt(selectedRow, 5).toString());
                    FD.setText(model.getValueAt(selectedRow, 6).toString());
                    DCS.setText(model.getValueAt(selectedRow, 7).toString());
                    Renewal.setText(model.getValueAt(selectedRow, 8).toString());
                }
            }
        });
        pane = new JScrollPane(table);
        pane.setBounds(12, 280, 960, 350);
        getContentPane().add(pane);

        row = new Object[9];
        String[] columns  = {"ID","Name","Date","Code","Daily","Monthly","FD","DCS","Renewal"};

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(20);
        table.setAutoCreateRowSorter(true);
        tableColumnModel = table.getColumnModel();
        tableColumn = tableColumnModel.getColumn(0);
        tableColumn1 = tableColumnModel.getColumn(1);
        tableColumn.setPreferredWidth(20);
        tableColumn1.setPreferredWidth(120);


        b3 = new JButton("RESET");
        b3.setBounds(30, 240, 100, 25);
        b3.setMnemonic(KeyEvent.VK_R);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID.setText("");
                Name.setText("");
                Code.setText("");
                Daily.setText("");
                Monthly.setText("");
                FD.setText("");
                DCS.setText("");
                Renewal.setText("");
            }
        });
        b3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    ID.setText("");
                    Name.setText("");
                    Code.setText("");
                    Daily.setText("");
                    Monthly.setText("");
                    FD.setText("");
                    DCS.setText("");
                    Renewal.setText("");
                }
            }
        });
        getContentPane().add(b3);

        b4 = new JButton("CLEAR ALL");
        b4.setBounds(150, 240, 100, 25);
        b4.setMnemonic(KeyEvent.VK_P);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model = (DefaultTableModel) table.getModel();
                int rowCount= model.getRowCount();
                    try {
                        for (int i = rowCount -1; i>=0; i--) {
                            model.removeRow(i);
                        }
                        JOptionPane.showMessageDialog(null, "Clear Successfully");
                        ID.setText(null);
                        Name.setText(null);
                        Code.setText(null);
                        Daily.setText(null);
                        Monthly.setText(null);
                        FD.setText(null);
                        DCS.setText(null);
                        Renewal.setText(null);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null,e1);
                    }
            }
        });
        b4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    model = (DefaultTableModel) table.getModel();
                    int rowCount= model.getRowCount();
                    try {
                        for (int i = rowCount -1; i>=0; i--) {
                            model.removeRow(i);
                        }
                        JOptionPane.showMessageDialog(null, "Clear Successfully");
                        ID.setText(null);
                        Name.setText(null);
                        Code.setText(null);
                        Daily.setText(null);
                        Monthly.setText(null);
                        FD.setText(null);
                        DCS.setText(null);
                        Renewal.setText(null);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null,e1);
                    }
                }
            }
        });
        getContentPane().add(b4);

//        b5 = new JButton("RETRIEVE");
//        b5.setBounds(270, 240, 100, 25);
//        b5.setMnemonic(KeyEvent.VK_U);
//        b5.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
                    ////Retrieve data////---
//                model=(DefaultTableModel)table.getModel();
//                try{
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/createdb?uSSL=false", "root", "@tonytosh28");
//                    preparedStatement = connection.prepareStatement("Select * from collection_receiving");
//                    resultSet = preparedStatement.executeQuery();
//                  while (resultSet.next()){
//                      int S_No = resultSet.getInt(1);
//                      String Name = resultSet.getString(2);
//                      String Date = resultSet.getString(3);
//                      String Code = resultSet.getString(4);
//                      String Daily = resultSet.getString(5);
//                      String Monthly = resultSet.getString(6);
//                      String FD = resultSet.getString(7);
//                      String DCS = resultSet.getString(8);
//                      String Renewal = resultSet.getString(9);
//                      model.addRow(new Object[]{S_No,Name,Date,Code,Daily,Monthly,FD,DCS,Renewal});
//                  }
//                    JOptionPane.showMessageDialog(null,"Retrieve Successful");
//                }catch (Exception e1){
//                      JOptionPane.showMessageDialog(null,"Error");
//                }
//            }
//        });
//        b4.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
//                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    //Retrieve data////---
//                    try{
//                        Class.forName("com.mysql.cj.jdbc.Driver");
//                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/createdb?uSSL=false", "root", "@tonytosh28");
//                        preparedStatement = connection.prepareStatement("Select * from collection_receiving");
//                        resultSet = preparedStatement.executeQuery();
//                        while (resultSet.next()){
//                            String S_No = resultSet.getString(1);
//                            String Name = resultSet.getString(2);
//                            String Date = resultSet.getString(3);
//                            String Code = resultSet.getString(4);
//                            String Daily = resultSet.getString(5);
//                            String Monthly = resultSet.getString(6);
//                            String FD = resultSet.getString(7);
//                            String DCS = resultSet.getString(8);
//                            String Renewal = resultSet.getString(9);
//                            model.addRow(new String[]{S_No,Name,Date,Code,Daily,Monthly,FD,DCS,Renewal});
//                        }
//                        JOptionPane.showMessageDialog(null,"Reset Successful");
//                    }catch (Exception e1){
//                        JOptionPane.showMessageDialog(null,"Error");
//                    }
//                }
//            }
//        });
//        getContentPane().add(b5);


        //Date Format///
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = new Date();
        calendar = Calendar.getInstance();
        model = (DefaultTableModel)table.getModel();
        Date.setText(" " + dateFormat.format(date));

        // JMenuBar Create function//
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.lightGray);

        //add separator
        separator = new JSeparator();

        // JMenu Create function//
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        save_asItem = new JMenuItem("Save As");
        printItem = new JMenuItem("Print");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new function(user);
                setVisible(false);
            }
        });

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser("D:\\Receiving Book");
                int userSelection = fileChooser.showOpenDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try{

                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                        Object[] tableLines = bufferedReader.lines().toArray();
                                  for (int i = 1; i < tableLines.length; i++){
                                   String line = tableLines[i].toString().trim();
                                   String[] dataRow = line.split("\t");
                                   model.addRow(dataRow);
                           }
                        JOptionPane.showMessageDialog(null,"Successfully Loaded","Information",JOptionPane.INFORMATION_MESSAGE);
                        bufferedReader.close();
                        fileReader.close();
                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,"Error","Error Message",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        openItem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    fileChooser = new JFileChooser("D:\\Receiving Book");
                    int userSelection = fileChooser.showOpenDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        try{

                            fileReader = new FileReader(file);
                            bufferedReader = new BufferedReader(fileReader);
                            Object[] tableLines = bufferedReader.lines().toArray();
                            for (int i = 1; i < tableLines.length; i++){
                                String line = tableLines[i].toString().trim();
                                String[] dataRow = line.split("\t");
                                model.addRow(dataRow);
                            }
                            JOptionPane.showMessageDialog(null,"Successfully Loaded","Information",JOptionPane.INFORMATION_MESSAGE);
                            bufferedReader.close();
                            fileReader.close();
                        }catch (Exception e1){
                            JOptionPane.showMessageDialog(null,"Error","Error Message",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (fileChooser==null){
                    fileChooser=new JFileChooser("");
                    fileChooser.setFileFilter(new FileNameExtensionFilter(".txt","Text File"));
                    fileChooser.showSaveDialog(null);
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(file);
                        try {
                            fileWriter = new FileWriter(file);
                            bufferedWriter = new BufferedWriter(fileWriter);
                            for (int h = 0; h < model.getColumnCount(); h++) {
                                bufferedWriter.write(model.getColumnName(h));
                                bufferedWriter.write("    \t ");
                            }
                            bufferedWriter.write("\n");
                            // for row and columns
                            for (int i = 0; i < model.getRowCount(); i++) {
                            //    bufferedWriter.newLine();
                                for (int j = 0; j < model.getColumnCount(); j++) {
                                    bufferedWriter.write(model.getValueAt( i,  j ).toString().trim());
                                    bufferedWriter.write(" \t ");
                                }
                                bufferedWriter.newLine();//record per line
                            }
                            bufferedWriter.close();
                            JOptionPane.showMessageDialog(null, "Successfully Loaded", "Information", JOptionPane.INFORMATION_MESSAGE);
                            fileWriter.close();
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "Error", "Error Message", JOptionPane.ERROR_MESSAGE);
                        }
                }else{
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(file);
                    try {
                        //for name
                        fileWriter = new FileWriter(file);
                        bufferedWriter = new BufferedWriter(fileWriter);
                        for (int h = 0; h < model.getColumnCount(); h++) {
                            bufferedWriter.write(model.getColumnName(h));
                            bufferedWriter.write("    \t ");
                        }
                        bufferedWriter.write("\n");
                        // for row and columns
                        for (int i = 0; i < model.getRowCount(); i++) {
                            for (int j = 0; j < model.getColumnCount(); j++) {
                                bufferedWriter.write(model.getValueAt(i, j).toString().trim());
                                bufferedWriter.write(" \t ");
                            }
                            bufferedWriter.newLine();//record per line
                        }
                        bufferedWriter.close();
                        JOptionPane.showMessageDialog(null, "Successfully Loaded", "Information", JOptionPane.INFORMATION_MESSAGE);
                        fileWriter.close();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Error", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        saveItem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    if (fileChooser==null){
                        fileChooser=new JFileChooser("");
                        fileChooser.setFileFilter(new FileNameExtensionFilter(".txt","Text File"));
                        fileChooser.showSaveDialog(null);
                        file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                        try {
                            fileWriter = new FileWriter(file);
                            bufferedWriter = new BufferedWriter(fileWriter);
                            for (int h = 0; h < model.getColumnCount(); h++) {
                                bufferedWriter.write(model.getColumnName(h));
                                bufferedWriter.write("    \t ");
                            }
                            bufferedWriter.write("\n");
                            // for row and columns
                            for (int i = 0; i < model.getRowCount(); i++) {
                          //      bufferedWriter.newLine();
                                for (int j = 0; j < model.getColumnCount(); j++) {
                                    bufferedWriter.write(model.getValueAt( i,  j ).toString().trim());
                                    bufferedWriter.write(" \t ");
                                }
                                bufferedWriter.newLine();//record per line
                            }
                            bufferedWriter.close();
                            JOptionPane.showMessageDialog(null, "Successfully Loaded", "Information", JOptionPane.INFORMATION_MESSAGE);
                            fileWriter.close();
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "Error", "Error Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                        try {
                            //for name
                            fileWriter = new FileWriter(file);
                            bufferedWriter = new BufferedWriter(fileWriter);
                            for (int h = 0; h < model.getColumnCount(); h++) {
                                bufferedWriter.write(model.getColumnName(h));
                                bufferedWriter.write("    \t ");
                            }
                            bufferedWriter.write("\n");
                            // for row and columns
                            for (int i = 0; i < model.getRowCount(); i++) {
                                for (int j = 0; j < model.getColumnCount(); j++) {
                                    bufferedWriter.write(model.getValueAt(i, j).toString().trim());
                                    bufferedWriter.write(" \t ");
                                }
                                bufferedWriter.newLine();//record per line
                            }
                            bufferedWriter.close();
                            JOptionPane.showMessageDialog(null, "Successfully Loaded", "Information", JOptionPane.INFORMATION_MESSAGE);
                            fileWriter.close();
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "Error", "Error Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        });
        save_asItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser("");
                int userSelection = fileChooser.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION){
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(file);
                    try{
                        //for name
                        fileWriter = new FileWriter(file);
                        bufferedWriter= new BufferedWriter(fileWriter);
                        for (int h = 0; h < model.getColumnCount(); h++) {
                            bufferedWriter.write(model.getColumnName(h));
                            bufferedWriter.write("    \t ");
                        }
                        bufferedWriter.write("\n");
                        // for row and columns
                        for (int i = 0; i < model.getRowCount(); i++) {
                            for (int j = 0; j < model.getColumnCount(); j++) {
                                bufferedWriter.write(model.getValueAt(i,j).toString().trim());
                                bufferedWriter.write(" \t ");
                            }
                            bufferedWriter.newLine();//record per line
                        }
                        JOptionPane.showMessageDialog(null,"Successfully Loaded","Information",JOptionPane.INFORMATION_MESSAGE);
                        bufferedWriter.close();
                        fileWriter.close();
                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,"Error","Error Message",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        save_asItem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    fileChooser = new JFileChooser("");
                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION){
                        file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                        try{
                            //for name
                            fileWriter = new FileWriter(file);
                            bufferedWriter= new BufferedWriter(fileWriter);
                            for (int h = 0; h < model.getColumnCount(); h++) {
                                bufferedWriter.write(model.getColumnName(h));
                                bufferedWriter.write("    \t ");
                            }
                            bufferedWriter.write("\n");
                            // for row and columns
                            for (int i = 0; i < model.getRowCount(); i++) {
                                for (int j = 0; j < model.getColumnCount(); j++) {
                                    bufferedWriter.write(model.getValueAt(i,j).toString().trim());
                                    bufferedWriter.write(" \t ");
                                }
                                bufferedWriter.newLine();//record per line
                            }
                            JOptionPane.showMessageDialog(null,"Successfully Loaded","Information",JOptionPane.INFORMATION_MESSAGE);
                            bufferedWriter.close();
                            fileWriter.close();
                        }catch (Exception e1){
                            JOptionPane.showMessageDialog(null,"Error","Error Message",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        printItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 header = new MessageFormat("Collection Records");//this is a header
                 footer = new MessageFormat("Page{0,number,integer}");
                try {
                    table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
                }catch (Exception e1){
                 JOptionPane.showMessageDialog(null,e1);
                }
            }
        });
        printItem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    header = new MessageFormat("Collection Records");//this is a header
                    footer = new MessageFormat("Page{0,number,integer}");
                    try {
                        table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,e1);
                    }
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==exitItem){
                    System.exit(0);
                }
            }
        });
        exitItem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar()==KeyEvent.VK_ENTER) {
                    if(e.getSource()==exitItem){
                        System.exit(0);
                    }
                }
            }
        });
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        save_asItem.addActionListener(this);
        printItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + F for file
        editMenu.setMnemonic(KeyEvent.VK_E); // Alt + E for edit
        helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + H for help
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));//setMnemonic(KeyEvent.VK_N);  // N for new
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));//setMnemonic(KeyEvent.VK_O); // L for load
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));//setMnemonic(KeyEvent.VK_S); // S for save
        save_asItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK+InputEvent.ALT_MASK));// CTRL+ALT + S for save as
        printItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));//setMnemonic(KeyEvent.VK_P);// P for print
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));//setMnemonic(KeyEvent.VK_E); // E for exit

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(save_asItem);
        fileMenu.add(printItem);
        fileMenu.add(separator);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
//       // JRadio Button Menu Item //
//        menuItem = new JRadioButtonMenuItem("Small");
//        menuItem.setBounds(740,200,61,22);
//        menuItem.setBackground(Color.WHITE);
//        getContentPane().add(menuItem);
//
//        menuItem = new JRadioButtonMenuItem("Medium");
//        menuItem.setBounds(810,200,61,22);
//        menuItem.setBackground(Color.WHITE);
//        getContentPane().add(menuItem);
//
//        menuItem = new JRadioButtonMenuItem("Large");
//        menuItem.setBounds(890,200,61,22);
//        menuItem.setBackground(Color.WHITE);
//        getContentPane().add(menuItem);

    }
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[]) {

        new function("");
    }
}

