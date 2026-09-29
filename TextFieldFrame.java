/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizza.servings.calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldFrame extends JFrame {
    private final JLabel title;
    private final JLabel label;
    private final JButton calculate;
    private final JTextField textField1;
    private final JLabel resultLabel;
    private double size, servings;

    public TextFieldFrame() {
        super("Pizza Serving Calculator");
        setLayout(new GridLayout(4,1));

        this.size = 0;
        this.servings = 0;
        
       
        title = new JLabel("Pizza Serving Calculator",JLabel.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.RED);
        add(title);

        JPanel labelAndCal = new JPanel();
        label = new JLabel("Enter the size of the pizza in inches:");
        labelAndCal.add(label);
        textField1 = new JTextField(4);
        labelAndCal.add(textField1);
        add(labelAndCal);
        
        calculate = new JButton("Calculate Servings");
        add(calculate);

        resultLabel = new JLabel("",JLabel.CENTER);
        add(resultLabel);

        
        TextFieldHandler handler = new TextFieldHandler();
        calculate.addActionListener(handler);
    }

    public double calServe(double size) {
        return Math.pow((size / 8.0), 2);
    }

   
    private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
                size = Double.parseDouble(textField1.getText()); 
                servings = calServe(size);
          
                resultLabel.setText(String.format("A %.0f inch pizza will serve %.2f  people."
                                                , size, servings)); 
                }
                
         
        }
    }



