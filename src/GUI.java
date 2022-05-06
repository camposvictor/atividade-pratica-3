import javax.swing.*;
import javax.swing.border.CompoundBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GUI extends JFrame {
    static BST<String, Integer> st;

    public GUI() {
        JPanel container = new JPanel();
        JPanel optionsPanel = new JPanel();
        JPanel chooseFilePanel = new JPanel();
        JPanel resultsPanel = new JPanel();

        JLabel selectedFile = new JLabel("Nenhum arquivo selecionado");
        JLabel resultsLabel = new JLabel("Nenhuma opção selecionada");

        JLabel optionsTitle = new JLabel("Escolha uma das opções", SwingConstants.LEFT);
        optionsTitle.setFont(new Font("Helvetica", Font.BOLD, 16));
        optionsTitle.setForeground(new Color(35, 41, 57));
        optionsTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        JLabel resultsTitle = new JLabel("Resultado", SwingConstants.LEFT);
        resultsTitle.setFont(new Font("Helvetica", Font.BOLD, 16));
        resultsTitle.setForeground(new Color(35, 41, 57));
        resultsTitle.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        CustomButton sizeOptButton = new CustomButton("Size");
        CustomButton heightOptButton = new CustomButton("Height");
        CustomButton internalPathOptButton = new CustomButton("Internal Path");
        CustomButton preOrderOptButton = new CustomButton("Pré-Ordem");
        CustomButton inOrderOptButton = new CustomButton("Ordem");
        CustomButton postOrderOptButton = new CustomButton("Pós-Ordem");
        CustomButton selectFileButton = new CustomButton("Escolher arquivo");

        GridBagConstraints constraints = new GridBagConstraints();

        sizeOptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsLabel.setText(Integer.toString(st.size()));
            }
        });
        heightOptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsLabel.setText(Integer.toString(st.height()));
            }
        });
        internalPathOptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsLabel.setText(Integer.toString(st.getInternalPathLenght()));
            }
        });
        preOrderOptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsLabel.setText(st.preOrder());
            }
        });
        inOrderOptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsLabel.setText(st.inOrder());
            }
        });
        postOrderOptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultsLabel.setText(st.postOrder());
            }
        });

        selectedFile.setBorder(new CompoundBorder(
                BorderFactory.createLineBorder(new Color(179, 186, 204), 1),
                BorderFactory.createEmptyBorder(0, 5, 0, 5)));
        selectedFile.setFont(new Font("Helvetica", Font.BOLD, 14));
        selectedFile.setForeground(new Color(35, 41, 57));

        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    File file = FileChooser.run();
                    selectedFile.setText(file.getName());

                    FileReader fileReader = new FileReader(file.getAbsolutePath());
                    BufferedReader reader = new BufferedReader(fileReader);

                    st = new BST<String, Integer>();

                    String line = reader.readLine();
                    int key = 0;
                    while (line != null) {
                        st.put(line, key++);
                        line = reader.readLine();
                    }

                } catch (IOException e) {
                    st = null;
                    selectedFile.setText(e.getMessage());
                }

            }
        });

        chooseFilePanel.setLayout(new GridBagLayout());
        chooseFilePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        chooseFilePanel.setBackground(Color.WHITE);

        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = 2;
        chooseFilePanel.add(selectedFile, constraints);

        constraints.anchor = GridBagConstraints.EAST;

        constraints.gridwidth = 1;
        chooseFilePanel.add(selectFileButton);

        optionsPanel.setBackground(Color.WHITE);
        optionsPanel.add(sizeOptButton);
        optionsPanel.add(heightOptButton);
        optionsPanel.add(internalPathOptButton);
        optionsPanel.add(preOrderOptButton);
        optionsPanel.add(inOrderOptButton);
        optionsPanel.add(postOrderOptButton);

        resultsPanel.setBackground(Color.WHITE);
        resultsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        resultsLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        resultsLabel.setForeground(new Color(35, 41, 57));
        resultsPanel.add(resultsLabel);

        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        container.setLayout(new GridBagLayout());
        container.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        container.setBackground(Color.WHITE);

        container.add(chooseFilePanel, constraints);
        container.add(optionsTitle, constraints);
        container.add(optionsPanel, constraints);
        container.add(resultsTitle, constraints);
        container.add(resultsPanel, constraints);

        add(container);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GUI");
        pack();
        setVisible(true);
    }
}