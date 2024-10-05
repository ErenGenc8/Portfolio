import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.awt.Color.white;

public class Parent {
    public static  void createChangePasswordFrame(JFrame f_main)
    {
        ArrayList<String> passwordsys = new ArrayList<String>();
        ArrayList<String> usernamesys = new ArrayList<String>();
        File myReader = new File("Username_Password.txt");
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(myReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(myScanner.hasNextLine())
        {
            String data = myScanner.nextLine();
            String[] parts = data.split(" ");
            usernamesys.add(parts[0]);
            passwordsys.add(parts[1]);
        }
        JFrame f = new JFrame();
        if(Main.bg_image.equals(""))
            f.getContentPane().setBackground(Color.blue);
        else
        {
            f.setLayout(new BorderLayout());
            f.setContentPane(new JLabel(new ImageIcon(Main.bg_image)));
            f.setLayout(new FlowLayout());
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.blue);
        JTextField username = new JTextField();
        username.setBounds(100,100,150,20);
        JTextField password = new JPasswordField();
        password.setBounds(100,150,150,20);
        JButton button1 = new JButton("Change Password");
        button1.setBounds(50,300,100,40);
        JButton button2 = new JButton("Go Back");
        button2.setBounds(200,300,100,40);
        JLabel label5 = new JLabel("New Username");
        JLabel label4 = new JLabel("New Password");
        label4.setBounds(10,150,100,20);
        label5.setBounds(10,100,100,20);
        label4.setForeground(white);
        label5.setForeground(white);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String new_password_txt = password.getText();
                String new_username_txt = username.getText();
                boolean success = false;
                //
                for(int i = 0; i < passwordsys.size(); i++)
                {
                    success = true;
                    passwordsys.set(i, new_password_txt);
                    usernamesys.set(i,new_username_txt);

                    System.out.println("Sucessfuly Changed");
                    File myReader = new File("Username_Password.txt");
                    myReader.delete();
                    try {
                        myReader.createNewFile();
                        System.out.println("1");
                    } catch (IOException ex) {
                        System.out.println("2");
                        throw new RuntimeException(ex);

                    }
                    FileWriter myNewFile = null;
                    try {
                        System.out.println("3");
                        myNewFile = new FileWriter("Username_Password.txt");
                    } catch (IOException ex) {
                        System.out.println("4");
                        throw new RuntimeException(ex);
                    }
                    try {
                        System.out.println("5");
                        myNewFile.write(usernamesys.get(i) + " " + passwordsys.get(i));
                        myNewFile.close();
                        System.out.println(usernamesys.get(i));
                    } catch (IOException ex) {
                        System.out.println("6");
                        throw new RuntimeException(ex);
                    }
                }
                if(!success)
                    System.out.println("Change failed");
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                f_main.setVisible(true);

            }
        });
        f.add(button1);
        f.add(button2);
        f.add(username);
        f.add(password);
        f.add(label4);
        f.add(label5);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void createParentFrame(JFrame f_main)
    {
        ArrayList<String> passwordsys = new ArrayList<String>();
        ArrayList<String> usernamesys = new ArrayList<String>();

        JFrame f = new JFrame();
        if(Main.bg_image.equals(""))
            f.getContentPane().setBackground(Color.blue);
        else
        {
            f.setLayout(new BorderLayout());
            f.setContentPane(new JLabel(new ImageIcon(Main.bg_image)));
            f.setLayout(new FlowLayout());
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.blue);
        JTextField username = new JTextField();
        username.setBounds(100,100,150,20);
        JTextField password = new JPasswordField();
        password.setBounds(100,150,150,20);
        JButton button1 = new JButton("Login");
        button1.setBounds(50,300,100,40);
        JButton button4 = new JButton("Change Passowrd");
        button4.setBounds(200,300,100,40);
        JButton button3 = new JButton("Menu");
        button3.setBounds(10,400,100,40);
        JLabel label1 = new JLabel("Parent");
        JLabel label2 = new JLabel("Username");
        JLabel label3 = new JLabel("Password");
        label1.setFont(new Font("Arial",Font.PLAIN,20));
        label1.setBounds(200,20,200,40);
        label2.setBounds(10,100,100,20);
        label3.setBounds(10,150,100,20);
        label1.setForeground(white);
        label2.setForeground(white);
        label3.setForeground(white);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(button3);
        f.add(button4);
        //button1.setVisible(true);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                File myReader = new File("Username_Password.txt");
                Scanner myScanner = null;
                try {
                    myScanner = new Scanner(myReader);
                } catch (FileNotFoundException e1) {
                    throw new RuntimeException(e1);
                }
                while(myScanner.hasNextLine())
                {
                    String data = myScanner.nextLine();
                    String[] parts = data.split(" ");
                    usernamesys.add(parts[0]);
                    passwordsys.add(parts[1]);
                }
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
                        f.setVisible(false);
                        questionFrame(f);
                    }

                }
                if(!success)
                    System.out.println("Login Failed");
            }
        });

        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                f_main.setVisible(true);

            }
        });
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                createChangePasswordFrame(f);

            }
        });
        //username.setVisible(true);
        //password.setVisible(true);
        f.add(username);
        f.add(password);
        f.setSize(500, 500);
        f.add(button1);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void questionFrame(JFrame m_main)
    {
        JFrame f = new JFrame();
        if(Main.bg_image.equals(""))
            f.getContentPane().setBackground(Color.blue);
        else
        {
            f.setLayout(new BorderLayout());
            f.setContentPane(new JLabel(new ImageIcon(Main.bg_image)));
            f.setLayout(new FlowLayout());
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.blue);
        JTextField number1 = new JTextField();
        number1.setBounds(100,100,150,20);
        JTextField number2 = new JTextField();
        number2.setBounds(100,150,150,20);
        JTextField sign = new JTextField();
        sign.setBounds(100,200,150,20);
        JTextField answer = new JTextField();
        answer.setBounds(100,250,150,20);
        answer.setEditable(false);
        JButton button2 = new JButton("Menu");
        JButton button3 = new JButton("Save Question");
        JButton button4 = new JButton("Choose Question");
        button2.setBounds(10,400,100,40);
        button3.setBounds(50, 300, 100,40);
        button4.setBounds(250, 300, 100,40);
        JLabel label1 = new JLabel("Number 1");
        JLabel label2 = new JLabel("Number 2");
        JLabel label3 = new JLabel("Sign");
        JLabel label4 = new JLabel("Asnwer");
        JLabel label5 = new JLabel("Parent");
        label1.setBounds(10,100,100,20);
        label2.setBounds(10,150,100,20);
        label3.setBounds(10,200,100,20);
        label4.setBounds(10,250,100,20);
        label5.setFont(new Font("Arial",Font.PLAIN,20));
        label5.setBounds(200,20,200,40);
        label1.setForeground(white);
        label2.setForeground(white);
        label3.setForeground(white);
        label4.setForeground(white);
        label5.setForeground(white);
        f.add(number1);
        f.add(number2);
        f.add(sign);
        f.add(answer);
        f.add(button2);
        f.add(button3);
        f.add(button4);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(label5);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                Main.f_main.setVisible(true);

            }
        });
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String num1_str = number1.getText();
                String num2_str = number2.getText();
                String sign_str = sign.getText();
                int ans = 0;
                if(sign_str.equals("+"))
                    ans = Integer.parseInt(num1_str) + Integer.parseInt(num2_str);
                else if(sign_str.equals("-"))
                    ans = Integer.parseInt(num1_str) - Integer.parseInt(num2_str);
                else if(sign_str.equals("*"))
                    ans = Integer.parseInt(num1_str) * Integer.parseInt(num2_str);
                else if(sign_str.equals("/"))
                    ans = Integer.parseInt(num1_str) / Integer.parseInt(num2_str);
                answer.setText(Integer.toString(ans));
                try{
                    String filename = "question.txt";
                    FileWriter fw = new FileWriter(filename, true);
                    fw.write(num1_str + " " + num2_str + " " + sign_str + " " + ans + "\n");
                    fw.close();
                }
                catch(IOException x){
                    System.out.println(x.getMessage());

                }
            }
        });
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                chooseQuestionFrame(m_main);

            }
        });
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);




    }
    public static void chooseQuestionFrame(JFrame m_main) {
        JFrame f = new JFrame();
        if(Main.bg_image.equals(""))
            f.getContentPane().setBackground(Color.blue);
        else
        {
            f.setLayout(new BorderLayout());
            f.setContentPane(new JLabel(new ImageIcon(Main.bg_image)));
            f.setLayout(new FlowLayout());
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.blue);
        JTextField number1 = new JTextField();
        number1.setBounds(100, 100, 150, 20);
        number1.setEditable(false);
        JTextField number2 = new JTextField();
        number2.setBounds(100, 150, 150, 20);
        number2.setEditable(false);
        JTextField sign = new JTextField();
        sign.setBounds(100, 200, 150, 20);
        sign.setEditable(false);
        JTextField answer = new JTextField();
        answer.setBounds(100, 250, 150, 20);
        JButton button1 = new JButton("Skip Question");
        JButton button3 = new JButton("Use Question");
        JButton button2 = new JButton("Menu");
        button2.setBounds(10, 400, 100, 40);
        button1.setBounds(50, 300, 100, 40);
        button3.setBounds(150,300,100,40);
        JLabel label1 = new JLabel("Number 1");
        JLabel label2 = new JLabel("Number 2");
        JLabel label3 = new JLabel("Sign");
        JLabel label4 = new JLabel("Asnwer");
        JLabel label5 = new JLabel("Parent");
        label1.setBounds(10, 100, 100, 20);
        label2.setBounds(10, 150, 100, 20);
        label3.setBounds(10, 200, 100, 20);
        label4.setBounds(10, 250, 100, 20);
        label5.setFont(new Font("Arial", Font.PLAIN, 20));
        label5.setBounds(200, 20, 200, 40);
        label1.setForeground(white);
        label2.setForeground(white);
        label3.setForeground(white);
        label4.setForeground(white);
        label5.setForeground(white);
        f.add(number1);
        f.add(number2);
        f.add(sign);
        f.add(answer);
        f.add(button1);
        f.add(button2);
        f.add(button3);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(label5);
        File myfile = new File("question.txt");
        Scanner myscanner = null;
        try {
            myscanner = new Scanner(myfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(myscanner.hasNextLine())
        {
            String data = myscanner.nextLine();
            System.out.println(data);
            String[] StringPart = data.split(" ");
            System.out.println(StringPart.toString());
            number1.setText(StringPart[0]);
            number2.setText(StringPart[1]);
            sign.setText(StringPart[2]);
            answer.setText(StringPart[3]);
        }
        int currentLine = 1;
        class skipQuestion implements ActionListener
        {
            public int questionindex = 1;
            public void actionPerformed(ActionEvent e)
            {
                File myfile = new File("question.txt");
                Scanner myscanner = null;
                try {
                    myscanner = new Scanner(myfile);
                } catch (FileNotFoundException e1) {
                    throw new RuntimeException(e1);
                }
                int lineNum = 0;

                while(myscanner.hasNextLine())
                {
                    if(lineNum == questionindex)
                    {
                        String data = myscanner.nextLine();
                        String[] StringPart = data.split(" ");
                        number1.setText(StringPart[0]);
                        number2.setText(StringPart[1]);
                        sign.setText(StringPart[2]);
                        answer.setText(StringPart[3]);
                        questionindex ++;

                        break;
                    }
                    else {
                        lineNum ++;
                        myscanner.nextLine();
                    }
                }

            }
        }
        button1.addActionListener(new skipQuestion());
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                Main.f_main.setVisible(true);

            }
        });
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String num1_str = number1.getText();
                String num2_str = number2.getText();
                String sign_str = sign.getText();
                int ans = Integer.parseInt(answer.getText());
                Main.number1.add(Integer.parseInt(num1_str));
                Main.number2.add(Integer.parseInt(num2_str));
                Main.answer.add(ans);
                Main.sign.add(sign_str);
            }
        });
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

    }
}
