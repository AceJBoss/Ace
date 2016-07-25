import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame{


JButton [] buttons ;
String [] buttonValues = {"1","2","3","4","5","6","7","8","9","0","+","-","x","/"};
JTextField display;
JPanel buttonsPanel;
JPanel displayPanel;


public Calculator(){
super("Simple Calculator");
buttonsPanel = new JPanel();
buttonsPanel.setLayout(new GridLayout(3,5));
displayPanel = new JPanel();

buttons = new JButton[buttonValues.length];
display = new JTextField(20);
display.setHorizontalAlignment(JTextField.RIGHT);


for(int i= 0; i< buttonValues.length; i++){

buttons[i] = new JButton(buttonValues[i]);
buttonsPanel.add(buttons[i]);
}

displayPanel.add(display, BorderLayout.NORTH);
displayPanel.add(buttonsPanel, BorderLayout.CENTER);
add(displayPanel);

}

public static void main(String [] arg){

Calculator app = new Calculator();

app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
app.setSize(100,100);
app.setVisible(true);


}




}