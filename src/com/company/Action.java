package com.company;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Action implements ActionListener {
    Swing swing;
    JFileChooser  fileChooser = new JFileChooser();
    JFileChooser  fileChooser2 = new JFileChooser();
    String[] st = new String[255];
    FileReader fileReader = null;
    FileWriter fileWriter = null;
    BufferedReader  bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    File file = null;
    File file1 = null;
    File file2 = null;

    public Action(Swing swing) {

        this.swing = swing;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton click = (JButton) e.getSource();
        Object object = e.getSource();
        if(click.equals(swing.button)){
            fileChooser.showDialog(null,"Open");
            try {
                File str = fileChooser.getSelectedFile();
                swing.textField.setText(str.getPath());
            }catch (Exception i){
                i.fillInStackTrace();
            }
        }
        if(click.equals(swing.button2)){
            if(swing.textField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Completed is TextField");
            }else{
                fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser2.showDialog(null,"Open");
                try {
                    File file = fileChooser2.getSelectedFile();
                    swing.textField2.setText(file.getPath());


                }catch (Exception i){
                    i.fillInStackTrace();
                }

            }
        }
        if(click.equals(swing.copy)&& !swing.textField.getText().equals("") && !swing.textField2.getText().equals("")){
            try {
                fileReader = new FileReader(fileChooser.getSelectedFile());
                bufferedReader = new BufferedReader(fileReader);
                file1 = new File(fileChooser.getSelectedFile().getPath());
                file2 = new File(fileChooser2.getSelectedFile().getPath()+"\\"+file1.getName());
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            try {
                int i = 0;
                while (true){
                    st[i] = bufferedReader.readLine();
                    if(st[i]==null){
                        break;
                    }
                    i++;
                }
            }catch (Exception f){
                f.printStackTrace();
            }
            try{
                if(file2.createNewFile()){
                    System.out.println("Create new fail");
                    fileWriter = new FileWriter(file2.getPath());
                    bufferedWriter = new BufferedWriter(fileWriter);
                    int i =0;
                    while (true){
                        if (st[i] == null){
                            break;
                        }
                        bufferedWriter.write(st[i]+"\n");
                        i++;
                    }
                }

            }catch (Exception ee){
            }
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
                bufferedReader.close();
                fileWriter.close();
                fileReader.close();
            }catch (Exception o){
            }



        }



    }

}

