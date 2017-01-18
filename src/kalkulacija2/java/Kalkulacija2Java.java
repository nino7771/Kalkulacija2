/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulacija2.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sinisa Babic
 */
public class Kalkulacija2Java {
 JTextField [][] z;
 private JLabel lblDatumFakture;
 private JLabel lblBrojFakture;
 private JLabel lblDobavljac;
 private JLabel lblDatumKalkulacije;
 private JLabel lblBrojKalkulacije;
 private JLabel lblProdavnica;
 private JLabel lblTotalPDV;
 private JLabel lblTotalVPV;
 private JLabel lblTotalMPV;
 private JLabel lblTotalRUC;
 private JLabel lblSifraDobavljaca;
 private JLabel lblSifraProdavnice;
 
 private JTextField txtDatumFakture;
 private JTextField txtBrojFakture;
 private JTextField txtDobavljac;
 private JTextField txtDatumKalkulacije;
 private JTextField txtBrojKalkulacije;
 private JTextField txtProdavnica;
 private JTextField txtTotalPDV;
 private JTextField txtTotalVPV;
 private JTextField txtTotalMPV;
 private JTextField txtTotalRUC;
 private JTextField txtSifraDobavljaca;
private JTextField txtSifraProdavnica; 
 
 private JButton saveButton;
 private JButton loadButton;
 private JButton openButton;
 private JButton clearButton;
 private JButton removeButton;
 private JButton saveDocumentButton;
 private JButton printButton;
 
 private DefaultTableModel model;
 private JTable table;
 private JScrollPane pane;
 
 private JFrame frame;
 private JPanel mainPanel;
 private JPanel topPanel;
 private JPanel bottomPanel;
 private JPanel buttonPanel;
 private JPanel areaPanel;
 private JTextArea textContent;
 
 
 String [] colHeadings={"R.Broj","Naziv","Kolicina","V.Cena","V.Vrednost","PDV","M.Cena","M.Vrednost",
 "RUC"};
 
 private double num1;
 private double num2;
 private double num3;
 private double num4;
 private double num5;
 private double num6;
 private double num7;
 private double num8;
 private double num9;
 private double num10;
 private double num11;
 
 private double numVPV;
 private double numMPV;
 private double numRUC;
 private double numPDV;
 
  
 private int row=1;
 private int rowCounter=0;
 final private double PDV=0.17;
 private double totalMPV;
 private double totalVPV;
 private double totalRUC;
 private double totalPDV;
 private String test="";
 private String test1="";
 private String test2="";
 private String test3="";
 private String test4="";
 private String test5="";
 private String a1;
 private String a2;
 private String a3;
 private String a4;
 private int l=0;
 boolean bool=false;
 private String[][] array;
  String text1="";
 // **//////////////////////// MAIN METHOD******////////////////////////////////
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               new Kalkulacija2Java();
           }
       });
    }
    private String[][] array1;
   
    Kalkulacija2Java(){
    showGUI();
    }

    private void showGUI() {
       frame=new JFrame("Kalkulacija");
       frame.setSize(1100, 700);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       
       mainPanel=new JPanel();
       
       
       topPanel=new JPanel();
       topPanel.setPreferredSize(new Dimension(1100,100));
       topPanel.setBackground(Color.LIGHT_GRAY);
       topPanel.setLayout(new GridBagLayout());
       GridBagConstraints gbc=new GridBagConstraints();
       gbc.insets=new Insets(1,2,1,2);
       
       lblSifraDobavljaca=new JLabel("Sifra dobavljaca ");
       lblSifraDobavljaca.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=0;
       gbc.gridy=0;
       topPanel.add(lblSifraDobavljaca,gbc);
       
       txtSifraDobavljaca=new JTextField("",3);
       txtSifraDobavljaca.setPreferredSize(new Dimension(30,25));
       txtSifraDobavljaca.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=1;
       gbc.gridy=0;
       topPanel.add(txtSifraDobavljaca,gbc);
       
       lblDobavljac=new JLabel("Dobavljac: ");
       lblDobavljac.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=2;
       gbc.gridy=0;
       topPanel.add(lblDobavljac,gbc);
       
       txtDobavljac=new JTextField("",15);
       txtDobavljac.setPreferredSize(new Dimension(80,25));
       txtDobavljac.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=3;
       gbc.gridy=0;
       topPanel.add(txtDobavljac,gbc);
       
          
       lblDatumFakture=new JLabel("Datum fakture: ");
       lblDatumFakture.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=4;
       gbc.gridy=0;
       topPanel.add(lblDatumFakture,gbc);
       
       
       
       txtDatumFakture=new JTextField("",12);
       txtDatumFakture.setPreferredSize(new Dimension(40,25));
       txtDatumFakture.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=5;
       gbc.gridy=0;
       topPanel.add(txtDatumFakture,gbc);
       
       lblBrojFakture=new JLabel("Broj fakture: ");
       lblBrojFakture.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=6;
       gbc.gridy=0;
       topPanel.add(lblBrojFakture,gbc);
       
       txtBrojFakture=new JTextField("",10);
       txtBrojFakture.setPreferredSize(new Dimension(40,25));
       txtBrojFakture.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=7;
       gbc.gridy=0;
       topPanel.add(txtBrojFakture,gbc);
       
       lblSifraProdavnice=new JLabel("Sifra prodavnice: ");
       lblSifraProdavnice.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=0;
       gbc.gridy=1;
       topPanel.add(lblSifraProdavnice,gbc);
       
       txtSifraProdavnica=new JTextField("",3);
       txtSifraProdavnica.setPreferredSize(new Dimension(30,25));
       txtSifraProdavnica.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=1;
       gbc.gridy=1;
       topPanel.add(txtSifraProdavnica,gbc);
       
       lblProdavnica=new JLabel("Prodavnica: ");
       lblProdavnica.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=2;
       gbc.gridy=1;
       topPanel.add(lblProdavnica,gbc);
       
       txtProdavnica=new JTextField("",15);
       txtProdavnica.setPreferredSize(new Dimension(80,25));
       txtProdavnica.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=3;
       gbc.gridy=1;
       topPanel.add(txtProdavnica,gbc);
       
       lblDatumKalkulacije=new JLabel("Datum kalkulacije: ");
       lblDatumKalkulacije.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=4;
       gbc.gridy=1;
       topPanel.add(lblDatumKalkulacije,gbc);
       
       txtDatumKalkulacije=new JTextField("",12);
       txtDatumKalkulacije.setPreferredSize(new Dimension(40,25));
       txtDatumKalkulacije.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=5;
       gbc.gridy=1;
       dateFormat();
       topPanel.add(txtDatumKalkulacije,gbc);
       
       lblBrojKalkulacije=new JLabel("Broj kalkulacije: ");
       lblBrojKalkulacije.setFont(new Font("Serif",Font.BOLD,18));
       gbc.gridx=6;
       gbc.gridy=1;
       topPanel.add(lblBrojKalkulacije,gbc);
       
       txtBrojKalkulacije=new JTextField("",10);
       txtBrojKalkulacije.setPreferredSize(new Dimension(40,25));
       txtBrojKalkulacije.setFont(new Font("Serif",Font.BOLD,14));
       gbc.gridx=7;
       gbc.gridy=1;
       topPanel.add(txtBrojKalkulacije,gbc);
       
       mainPanel.add(topPanel,gbc);
       
       KeyListen key=new KeyListen();
       
     
      //DefaultTableModel***********************************************************//
       model=new DefaultTableModel();
       model.setColumnIdentifiers(colHeadings);
       model.setNumRows(row);
       
      
       
      //JTable************************************************************************//
       table=new JTable(model);
       table.setRowHeight(30);
       table.setPreferredScrollableViewportSize(new Dimension(900,300));
       table.addKeyListener(key);
       table.getColumnModel().getColumn(0).setPreferredWidth(30);
      
       pane=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
               JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       
       model.setValueAt(1, 0, 0);
       mainPanel.add(pane);
       
       
       
       //buttonPanel*************************************************************************//
       ButtonClick click=new ButtonClick();
       buttonPanel=new JPanel();
       buttonPanel.setSize(new Dimension(900,100));
       buttonPanel.setLayout(new GridBagLayout());
       
       //GridBagConstraints gbc0=new GridBagConstraints();
       gbc.insets=new Insets(1,5,1,5);
       
       saveButton=new JButton("Save");
       saveButton.setFont(new Font("Serif",Font.BOLD,18));
       saveButton.setPreferredSize(new Dimension(100,40));
       gbc.gridx=0;
       gbc.gridy=0;
       buttonPanel.add(saveButton,gbc);
       
       loadButton=new JButton("Load");
       loadButton.setFont(new Font("Serif",Font.BOLD,18));
       loadButton.setPreferredSize(new Dimension(100,40));
       gbc.gridx=1;
       gbc.gridy=0;
       buttonPanel.add(loadButton,gbc);
       
       openButton=new JButton("Open");
       openButton.setFont(new Font("Serif",Font.BOLD,18));
       openButton.setPreferredSize(new Dimension(100,40));
       gbc.gridx=2;
       gbc.gridy=0;
       buttonPanel.add(openButton,gbc);
       
       clearButton=new JButton("Clear");
       clearButton.setFont(new Font("Serif",Font.BOLD,18));
       clearButton.setPreferredSize(new Dimension(100,40));
       gbc.gridx=3;
       gbc.gridy=0;
       buttonPanel.add(clearButton,gbc);
       
       removeButton=new JButton("Remove");
       removeButton.setFont(new Font("Serif",Font.BOLD,18));
       removeButton.setPreferredSize(new Dimension(100,40));
       gbc.gridx=4;
       gbc.gridy=0;
       buttonPanel.add(removeButton,gbc);
       
       saveDocumentButton=new JButton("Save Doc");
       saveDocumentButton.setFont(new Font("Serif",Font.BOLD,18));
       saveDocumentButton.setPreferredSize(new Dimension(150,40));
       gbc.gridx=5;
       gbc.gridy=0;
       buttonPanel.add(saveDocumentButton,gbc);
       
       printButton=new JButton("Print");
       printButton.setFont(new Font("Serif",Font.BOLD,18));
       printButton.setPreferredSize(new Dimension(100,40));
       gbc.gridx=6;
       gbc.gridy=0;
       buttonPanel.add(printButton,gbc);
       
       printButton.addActionListener(click);
       saveButton.addActionListener(click);
       openButton.addActionListener(click);
       clearButton.addActionListener(click);
       removeButton.addActionListener(click);
       loadButton.addActionListener(click);
       saveDocumentButton.addActionListener(click);
       mainPanel.add(buttonPanel,gbc);
       
       //bottomPanel******************************************************************
       bottomPanel=new JPanel();
       bottomPanel.setLayout(new GridBagLayout());
       bottomPanel.setPreferredSize(new Dimension(900,200));
       
       
       GridBagConstraints gbc1=new GridBagConstraints();
       gbc1.insets=new Insets(0,5,1,5);
       
       lblTotalVPV=new JLabel("V.Vrednost: ");
       gbc1.gridx=0;
       gbc1.gridy=0;
       lblTotalVPV.setFont(new Font("Serif",Font.BOLD,24));
       bottomPanel.add(lblTotalVPV,gbc1);
       
       txtTotalVPV=new JTextField("",8);
       txtTotalVPV.setPreferredSize(new Dimension(80,50));
       txtTotalVPV.setBackground(Color.blue);
       txtTotalVPV.setForeground(Color.yellow);
       txtTotalVPV.setFont(new Font("Serif",Font.BOLD,24));
       txtTotalVPV.setText("0.00");
       gbc1.gridx=1;
       gbc.gridy=0;
       bottomPanel.add(txtTotalVPV,gbc1);
       
       lblTotalMPV=new JLabel("M.Vrednost: ");
       gbc1.gridx=0;
       gbc1.gridy=1;
       lblTotalMPV.setFont(new Font("Serif",Font.BOLD,24));
       bottomPanel.add(lblTotalMPV,gbc1);
       
       txtTotalMPV=new JTextField("",8);
       txtTotalMPV.setPreferredSize(new Dimension(80,50));
       txtTotalMPV.setBackground(Color.blue);
       txtTotalMPV.setForeground(Color.yellow);
       txtTotalMPV.setFont(new Font("Serif",Font.BOLD,24));
       txtTotalMPV.setText("0.00");
       gbc1.gridx=1;
       gbc1.gridy=1;
       bottomPanel.add(txtTotalMPV,gbc1);
       
       lblTotalPDV=new JLabel("PDV: ");
       gbc1.gridx=2;
       gbc1.gridy=0;
       lblTotalPDV.setFont(new Font("Serif",Font.BOLD,24));
       bottomPanel.add(lblTotalPDV,gbc1);
       
       txtTotalPDV=new JTextField("",8);
       txtTotalPDV.setPreferredSize(new Dimension(80,50));
       txtTotalPDV.setBackground(Color.blue);
       txtTotalPDV.setForeground(Color.yellow);
       txtTotalPDV.setFont(new Font("Serif",Font.BOLD,24));
       txtTotalPDV.setText("0.00");
       gbc1.gridx=3;
       gbc1.gridy=0;
       bottomPanel.add(txtTotalPDV,gbc1);
       
       
       lblTotalRUC=new JLabel("RUC: ");
       gbc1.gridx=2;
       gbc1.gridy=1;
       lblTotalRUC.setFont(new Font("Serif",Font.BOLD,24));
       bottomPanel.add(lblTotalRUC,gbc1);
       
       txtTotalRUC=new JTextField("",8);
       txtTotalRUC.setPreferredSize(new Dimension(80,50));
       txtTotalRUC.setBackground(Color.blue);
       txtTotalRUC.setForeground(Color.yellow);
       txtTotalRUC.setFont(new Font("Serif",Font.BOLD,24));
       txtTotalRUC.setText("0.00");
       gbc1.gridx=3;
       gbc1.gridy=1;
       bottomPanel.add(txtTotalRUC,gbc1);
       
       mainPanel.add(bottomPanel,gbc1);
       
       
       textContent=new JTextArea();
       textContent.setPreferredSize(new Dimension(1100,800));
       areaPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
       areaPanel.setSize(1300, 900);
       areaPanel.add(textContent);
       areaPanel.setVisible(false);
       
       
       frame.add(areaPanel);
       frame.add(mainPanel);
       frame.setVisible(true);
    }//metod ShowGUI

    private void drawPage(Graphics2D g2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
/////////// key listen class////////////////////////////////////////////////////////
    class KeyListen implements KeyListener {
       
        @Override
        public void keyTyped(KeyEvent e) {
          
        }//method keyTyped()

        @Override
        public void keyPressed(KeyEvent e) {
         
                try{
               
             if(e.getKeyCode()==KeyEvent.VK_ENTER){
            
             sumVPV();
             sumPDV();
             sumMPV();
             sumRUC();
            
             
            
             getTotalMPV();
             getTotalVPV();
             getTotalPDV();
             getTotalRUC();
             refresh();
             addRow();
           
                    
             
           
             }
                }
              catch(NullPointerException ex){
             
            JOptionPane.showMessageDialog(frame, "Niste popunili sva polja");
            
           
                     }
            
           
                
          
            }//method keyPressed()
        

        @Override
        public void keyReleased(KeyEvent e) {
          
        }//method keyReleased()
        
    }//class KeyListen
    
      
        //******* BUTTON CLICK*****************//////////////////////////////////////////////////////
      
     private class ButtonClick implements ActionListener{

     

        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource()==removeButton){
          removeRow();
           }
           else if(e.getSource()==saveButton){
           saveFile();
           }
           else if(e.getSource()==loadButton){
          
          
           model.removeRow(0);
           loadFile();
           model.setNumRows(row);
   }
           else if(e.getSource()==saveDocumentButton){
           model.removeRow(model.getRowCount()-1);
           saveAsDocument();
           }
           
         
           
            else if(e.getSource()==openButton){
               try {
                   mainPanel.setVisible(false);
                   areaPanel.setVisible(true);
                   openDocument();
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Kalkulacija2Java.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
              else if(e.getSource()==clearButton){
           clearAll();
           }
              else if(e.getSource()==printButton){
              
            getValueForPrinter();
              print();
              areaPanel.setVisible(true);
              }
           
        }//actionperformed
     
     }//button click class
    
       
    
   ////// METHODS TO WORK WITH////////////////////////////////////////////////////
   //Racuna veleprodajnu vrednost u tabeli
    private void sumVPV(){
    String name;
    
    num1=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 2));
    num2=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 3));
    
    numVPV=num1*num2;
    name=String.format("%.2f",numVPV);
    model.setValueAt(name, table.getSelectedRow(), 4);
   
    }//method sumVPV
  
   
    //Racuna malprodajnu vrednost u tabeli 
     private void sumMPV(){
       String name;
    
    num3=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 2));
    num4=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 6));
    System.out.println(num3+" "+num4);
    numMPV=num3*num4;
    
    name=String.format("%.2f",numMPV);
    model.setValueAt(name, table.getSelectedRow(), 7);
    
    }//method sumMPV
   
     //Racuna porez u tabeli
     private void sumPDV(){
      String name;
     
         num5=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 4));
         numPDV=num5*PDV;
         name=String.format("%.2f",numPDV);
         model.setValueAt(name,table.getSelectedRow(), 5);
     }//method sumPdv
     //Racuna razliku cijene u tabeli
       private void sumRUC(){
     
       String name;
    
       num6=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 7));
       num7=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 4));
       
       numRUC=num6-num7;
       name=String.format("%.2f",numRUC);
       model.setValueAt(name,table.getSelectedRow(), 8);
    }//method sumRUC()
       //Sabira sve maloprodajne vrednosti iz tabele
      private void getTotalMPV(){
        String name;  
        
        num8=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 7));
        totalMPV=totalMPV+num8;
        name=String.format("%.2f",totalMPV);
        txtTotalMPV.setText(name);
      
      } //method getTotalMPV
      //Sabira sve veleprodajne vrednosti iz tabele
       private void getTotalVPV(){
        String name;  
      
        num9=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 4));
        totalVPV=totalVPV+num9;
        name=String.format("%.2f",totalVPV);
        txtTotalVPV.setText(name);
       } //method getTotalVPV
       
       //Sabira ssav porez iz tabele
        private void getTotalPDV(){
        String name;  
     
        num10=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 5));
        totalPDV=totalPDV+num10;
        name=String.format("%.2f",totalPDV);
        txtTotalPDV.setText(name);
       } //method getTotalPDV
        
        //Sabira razliku u cijeni iz tabele
        private void getTotalRUC(){
        String name;  
      
        num11=Double.parseDouble((String) model.getValueAt(table.getSelectedRow(), 8));
       
        totalRUC=totalRUC+num11;
        name=String.format("%.2f",totalRUC);
        txtTotalRUC.setText(name);
       } //method getTotalRUC
        
        //Dodaje jedan red nakon pritiska na tipku enter
         private void addRow(){
       
     String name;
                 
                row++;  
                model.setNumRows(row);
                
                name=Integer.toString(model.getRowCount()-1);
                model.setValueAt(name, table.getSelectedRow(), 0);
                
          }//method addRow()
         
         //Brise jedan red pritiskom na dugme Remove
         private void removeRow(){
         int pos=table.getSelectedRow();
        
         
         double a=Double.parseDouble((String)model.getValueAt(pos, 4));
         double a1=Double.parseDouble((String)model.getValueAt(pos, 7));
         double a2=Double.parseDouble((String)model.getValueAt(pos, 5));
         double a3=Double.parseDouble((String)model.getValueAt(pos, 8));
         
         
         
         totalVPV=totalVPV-a;
         txtTotalVPV.setText(String.format("%.2f", totalVPV));
         
         totalMPV=totalMPV-a1;
         txtTotalMPV.setText(String.format("%.2f", totalMPV));
         
         totalPDV=totalPDV-a2;
         txtTotalPDV.setText(String.format("%.2f", totalPDV));
         
         totalRUC=totalRUC-a3;
         txtTotalRUC.setText(String.format("%.2f", totalRUC));
         
         model.removeRow(pos);
       
        
         row--;
         for(int i=0;i<model.getRowCount();i++){
         model.setValueAt(i+1, i, 0);
         }
         }//method removeRow()
        
     //Dohvaca file izabran u JFileChooseru 
     //Aktivira se pritiskom na dugme Save    
     JFileChooser jfc=new JFileChooser(".");
     private void saveFile(){
     if(jfc.showSaveDialog(frame)==JFileChooser.APPROVE_OPTION){
     saveFile(jfc.getSelectedFile());
     }
     }//saveFile
     
     //Upisuje u gore zadati fajl podatke serilizacijom 
     private void saveFile(File file){
     try{
     
     
     ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
     
     test=txtDobavljac.getText();
     test1=txtDatumFakture.getText();
     test2=txtBrojFakture.getText();
     test3=txtProdavnica.getText();
     test4=txtDatumKalkulacije.getText();
     test5=txtBrojKalkulacije.getText();
     out.writeObject(test);
     out.writeObject(test1);
     out.writeObject(test2);
     out.writeObject(test3);
     out.writeObject(test4);
     out.writeObject(test5); 
     a1=txtTotalVPV.getText();
     a2=txtTotalMPV.getText();
     a3=txtTotalPDV.getText();
     a4=txtTotalRUC.getText();
     out.writeObject(a1);
     out.writeObject(a2);
     out.writeObject(a3);
     out.writeObject(a4);
     //for(int i=0;i<model.getRowCount();i++){
     out.writeObject(model.getDataVector());
     
     
     out.close();
     
     }catch(Exception ex){
     ex.printStackTrace();
     }
     }//method saveFile(File file)
    
     
     
    ///Otvara izabrani fajl i JFileChooseru
     //Aktivira se pritiskom na dugme load
 
     private void loadFile(){
     if(jfc.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
     loadFile(jfc.getSelectedFile());
     }
     }//loadFile
     
     
     //Ispisuje podatke iz gore navedenog fajla u TABELU koji prethodno mora biti sacuvan kako je gore to navedeno
     //Koristi se samo za ispisivanje fajla u tabelu, a ne kao dokument
     private void loadFile(File file){
     try{
    
    
     ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
     
     test=(String) in.readObject();
     txtDobavljac.setText(test);
     
     test1=(String) in.readObject();
     txtDatumFakture.setText(test1);
     
     test2=(String) in.readObject();
     txtBrojFakture.setText(test2);
     
     test3=(String) in.readObject();
     txtProdavnica.setText(test3);
     
     test4=(String) in.readObject();
     txtDatumKalkulacije.setText(test4);
     
     test5=(String) in.readObject();
     txtBrojKalkulacije.setText(test5);
     
     a1=(String) in.readObject();
     txtTotalVPV.setText(a1);
     
     a2=(String) in.readObject();
     txtTotalMPV.setText(a2);
     
     a3=(String) in.readObject();
     txtTotalPDV.setText(a3);
     
     a4=(String) in.readObject();
     txtTotalRUC.setText(a4);
     
     
     Vector data=(Vector) in.readObject();
    
     Iterator itr=data.iterator();
     
     while(itr.hasNext()){
     model.addRow((Vector)itr.next());
     row++;
      }
     row--;
     in.close();
   
     }catch(IOException | ClassNotFoundException ex){
     
     }
     }//loadFile(File file)
     
     
     
      JFileChooser jfc2=new JFileChooser();
    //Poziva oznaceni fajl u kojem ce biti sacuvan dokument
     private void saveAsDocument(){
     if(jfc2.showSaveDialog(frame)==JFileChooser.APPROVE_OPTION){
     saveAsDocument(jfc2.getSelectedFile());
     }
     }//metod saveAsDocument
     
     
     //
     private void saveAsDocument(File f){
     try
     {
         
       
     PrintWriter os=new PrintWriter(f);
     String [][] s=new String[model.getRowCount()][model.getColumnCount()];
     os.println();
     os.printf("%20s %-20s %20s %-20s %20s %-20s ","Dobavljac:", txtDobavljac.getText(),"Datum Fakture:",txtDatumFakture.getText(),
                 "BrojFakture:",txtBrojFakture.getText());
     os.println();
     os.println();
     os.printf("%20s %-20s %20s %-20s %20s %-20s","Prodavnica:",txtProdavnica.getText(),"Datum Kalkulacije:",txtDatumKalkulacije.getText(),
             "Broj Kalkulacije:",txtBrojKalkulacije.getText());
     
     os.println();
     os.println();
     os.println();
     os.println("");
     for(int col=0;col<model.getColumnCount();col++){
         if(col==1){
          os.printf("%20s",model.getColumnName(col));
          continue;
         }
     os.printf("%12s",model.getColumnName(col));
     }
     os.println();
     os.println();
     
     for(int i=0;i<model.getRowCount();i++){
         for(int j=0;j<model.getColumnCount();j++){
         s[i][j]=(String) model.getValueAt(i, j);
         
           if(j==1){
               os.printf("%20s",s[i][1]);
                continue;
           }
         os.printf("%12s",s[i][j]);
       }
         os.println();
         os.println();
        }
     
     
      os.println();
      os.printf("%25s %15s %25s %15s","Veleprodajna vrednost: ",txtTotalVPV.getText(),"PDV: ",txtTotalPDV.getText());
      os.println();
      os.println();
      os.println();
      os.printf("%25s %-15s %25s %-15s","Maloprodajna vrednost: ",txtTotalMPV.getText(),"Razlika u cijeni: ",txtTotalRUC.getText());
      os.close();
     }catch(IOException e){
     
     }
     }//metod saveAsDocument
     
     JFileChooser jfc3=new JFileChooser();
     
     private void openDocument() throws FileNotFoundException{
     if(jfc3.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
         try {
             openDocument(jfc3.getSelectedFile());
         } catch (IOException ex) {
             Logger.getLogger(Kalkulacija2Java.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     }//openDocument()
     
     private void openDocument(File text) throws FileNotFoundException, IOException{
          String f = null;
    
     FileReader reader=new FileReader(text);
     try (BufferedReader bf = new BufferedReader(reader)) {
         textContent.read(bf,frame);
     }
     textContent.requestFocus();
     }//openButton()
    
     private void getValueForPrinter(){
      
       array=new String[model.getRowCount()][model.getColumnCount()];   
      for (int i =0;i<model.getRowCount();i++){
          for (int j=0;j<model.getColumnCount();j++){
          array[i][j]=(String)model.getValueAt(i,j);
          }
         }
     }//getValueForPrinter() method
     
         
            
     
    
     private void print(){
      //array= new String[model.getColumnCount()][model.getRowCount()];
      String name=null;
      for (int i =0;i<model.getRowCount();i++){
           
          for (int j=0;j<model.getColumnCount();j++){
              
         if(array[i][j]==null){
          break;
          }
          System.out.print((String)array[i][j]+"   ");
          if(j==1){
           name+=String.format("%-30s",array[i][1]);
           continue;
          }
          name+=String.format("%-12s",array[i][j]);
         }
          name+="\n";
         textContent.setText(name);
         System.out.println();
      }
     }//print() method
     
     
   
     
     
     private void dateFormat(){
     DateFormat dtf=new SimpleDateFormat("dd/MM/yyyy");
     Calendar cal=Calendar.getInstance();
     
     txtDatumKalkulacije.setText(dtf.format(cal.getTime()));
     }// metoda dateFormat()
     
     private void refresh(){
      double a;
      double a11;
      double a12;
      double a13;
      
    
      
      totalMPV=0;
      totalVPV=0;
      totalPDV=0;
      totalRUC=0;
      
      for(int i=0;i<model.getRowCount();i++){
        a=Double.parseDouble((String)model.getValueAt(i, 4));
        a11=Double.parseDouble((String)model.getValueAt(i, 7));
        a12=Double.parseDouble((String)model.getValueAt(i, 5));
        a13=Double.parseDouble((String)model.getValueAt(i, 8));
        
        totalVPV=totalVPV+a;
        totalMPV=totalMPV+a11;
        totalPDV=totalPDV+a12;
        totalRUC=totalRUC+a13;
      
      txtTotalVPV.setText(String.format("%.2f", totalVPV));
      txtTotalMPV.setText(String.format("%.2f", totalMPV));
      txtTotalPDV.setText(String.format("%.2f", totalPDV));
      txtTotalRUC.setText(String.format("%.2f", totalRUC));
      }
      
     }//method refresh
     
      private void clearAll(){
     txtDobavljac.setText("");
     txtDatumFakture.setText("");
     txtBrojFakture.setText(""); 
     txtProdavnica.setText(""); 
     txtDatumKalkulacije.setText(""); 
     txtBrojKalkulacije.setText(""); 
     
     row=1;
     rowCounter=0;
     
     num1=0;
     num2=0; 
     num3=0;
     num4=0;
     num5=0;
     num6=0;
     num7=0;
     num8=0;
     num9=0;
     num10=0;
     num11=0;
     
     numVPV=0;
     numMPV=0;
     numPDV=0;
     numRUC=0;
     
     totalVPV=0;
     totalMPV=0;
     totalPDV=0;
     totalRUC=0;
     
     txtTotalVPV.setText("");
     txtTotalMPV.setText("");
     txtTotalPDV.setText("");
     txtTotalRUC.setText("");
     
     test="";
     test1="";
     test2="";
     test3="";
     test4="";
     test5="";
     model.setNumRows(row);
    for(int i=0;i<model.getColumnCount();i++){
        model.setValueAt(test, 0, i);
      }
     } //clearAll
    
  
      
     
}//main class
