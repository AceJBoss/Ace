import javax.swing.*;
import java.awt.*;

public class CommandPrompt extends JFrame{

private JTextArea cmd;


public CommandPrompt(){
super("Command Prompt");
setSize(750,500);
setLocation(100,100);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


cmd = new JTextArea();
cmd.setSize(this.getWidth(),this.getHeight());
cmd.setBackground(Color.BLACK);
cmd.setForeground(Color.WHITE);

add(cmd, BorderLayout.CENTER);

}

public static void main(String [] arg){
	new CommandPrompt().setVisible(true);
}
}