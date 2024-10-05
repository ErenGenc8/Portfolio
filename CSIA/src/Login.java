import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login {

    public static void main(String[] args) {
        ArrayList<String> passwordsys = new ArrayList<String>();
        ArrayList<String> usernamesys = new ArrayList<String>();
        passwordsys.add("123");
        usernamesys.add("Eren");
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.blue);
        JTextField username = new JTextField();
        username.setBounds(50,100,150,20);
        JTextField password = new JTextField();
        password.setBounds(50,150,150,20);
        JButton button1 = new JButton("Login");
        button1.setBounds(100,250,100,40);
        JLabel label1 = new JLabel("Parent");
        label1.setFont(new Font("Arial",Font.PLAIN,20));
        label1.setBounds(200,20,200,40);
        label1.setBackground(Color.white);
        f.add(label1);
        //button1.setVisible(true);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username_txt = username.getText();
                String password_txt = password.getText();
                System.out.println(username_txt + password_txt);
                boolean success = false;
                for(int i = 0; i < passwordsys.size(); i++)
                {
                    if(username_txt.equals(usernamesys.get(i)) && password_txt.equals(passwordsys.get(i)))
                    {
                        success = true;
                        System.out.println("Login Successful");
                    }

                }
                if(!success)
                    System.out.println("Login Failed");
            }
        });
        //username.setVisible(true);
        //password.setVisible(true);
        f.add(username);
        f.add(password);
        f.setSize(500, 500);
        f.add(button1);
        //f.pack();
        f.setLayout(null);
        f.setVisible(true);
        //f.setLayout(null);
    }
}
