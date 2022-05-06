package arvoreBinariaApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class GUI implements ActionListener {
	static String line;
    private JLabel label = new JLabel("");
    private JFrame frame = new JFrame();
    App ap = new App();
    static BST<String, Integer> st = new BST<String, Integer>();
    static fileChooser fileOption = new fileChooser();
    Scanner scanner;
    JButton buttonOpSize = new JButton("Size");
    JButton buttonOpHeight = new JButton("Height");
    JButton buttonOpInternalPath = new JButton("Internal Path");
    JButton buttonOpPreOrder = new JButton("Pre Ordem");
    JButton buttonOpInOrder = new JButton("Em Ordem");
    JButton buttonOpPostOrder = new JButton("Pos Ordem");
    static fileChooser finalFile = new fileChooser();
    
    
    public GUI() {
        buttonOpSize.addActionListener(this);
        buttonOpHeight.addActionListener(this);
        buttonOpInternalPath.addActionListener(this);
        buttonOpPreOrder.addActionListener(this);
        buttonOpInOrder.addActionListener(this);
        buttonOpPostOrder.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 50));
        panel.add(buttonOpSize);
        panel.add(buttonOpHeight);
        panel.add(buttonOpInternalPath);
        panel.add(buttonOpPreOrder);
        panel.add(buttonOpInOrder);
        panel.add(buttonOpPostOrder);
        panel.add(label);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == buttonOpSize) {
    		label.setText(Integer.toString(st.size()));
    	}
    	if(e.getSource() == buttonOpHeight) {
    		label.setText(Integer.toString(st.height()));
    	}
    	if(e.getSource() == buttonOpInternalPath) {
    		label.setText(Integer.toString(st.getInternalPathLenght()));
    	}    
    	if(e.getSource() == buttonOpPostOrder) {
    		label.setText(st.postOrder());
    		st.finalInfo = "";;
    	}   
    	if(e.getSource() == buttonOpInOrder) {
    		label.setText(st.inOrder());
    		st.finalInfo = "";;
    	}  
    	if(e.getSource() == buttonOpPreOrder) {
    		label.setText(st.preOrder());
    		st.finalInfo = "";;
    	}  
    }
    public static void main(String[] args) throws IOException{
    	new GUI();
    	st=fileChooser.run();
		System.out.print("ORDEM - ");
		st.inOrder();
		System.out.print("\nPRÉ-ORDEM - ");
		st.preOrder();
		System.out.print("\nPÓS-ORDEM - ");
		st.postOrder();
		System.out.print("\nTAMANHO - " + st.size());
		System.out.print("\nALTURA - " + st.height());
		System.out.print("\nTAMANHO_DO_CAMINHO_INTERNO - " + st.getInternalPathLenght());
    	}
    
}