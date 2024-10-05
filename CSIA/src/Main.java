import javax.imageio.ImageIO;
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

public class Main implements ActionListener {

    public static JFrame f_main;
    public static String bg_image = "";
    public static ArrayList<Integer> number1 = new ArrayList<Integer>();
    public static ArrayList<Integer> number2 = new ArrayList<Integer>();
    public static ArrayList<Integer> answer = new ArrayList<Integer>();
    public static ArrayList<String> sign = new ArrayList<String>();
    public static int coin = 40;
    Main() {
        f_main = new JFrame();
        f_main.getContentPane().setBackground(Color.blue);
        f_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(bg_image.equals(""))
            f_main.getContentPane().setBackground(Color.blue);
        else
        {
            f_main.setLayout(new BorderLayout());
            f_main.setContentPane(new JLabel(new ImageIcon(bg_image)));
            f_main.setLayout(new FlowLayout());
        }
        JButton button1 = new JButton("Student");
        JButton button2 = new JButton("Parent");
        button2.addActionListener(this);
        button1.setBounds(100,100,100,40);
        button2.setBounds(300,100,100,40);
        JLabel label1 = new JLabel("Maths For Elementary");
        label1.setFont(new Font("Arial",Font.PLAIN,20));
        label1.setBounds(150,20,200,40);
        label1.setForeground(white);
        f_main.add(label1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f_main.setVisible(false);
                Student.createStudentFrame(f_main,bg_image);

            }
        });
        f_main.setSize(500, 500);
        f_main.add(button1);
        f_main.add(button2);
        f_main.setLayout(null);
        f_main.setVisible(true);

    }

    public static void changebg()
    {

        f_main.getContentPane().setBackground(Color.blue);
        f_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(bg_image.equals(""))
            f_main.getContentPane().setBackground(Color.blue);
        else
        {
            f_main.setLayout(new BorderLayout());
            f_main.setContentPane(new JLabel(new ImageIcon(bg_image)));
            f_main.setLayout(new FlowLayout());
        }
        JButton button1 = new JButton("Student");
        JButton button2 = new JButton("Parent");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f_main.setVisible(false);
                Parent.createParentFrame(f_main);

            }
        });
        button1.setBounds(100,100,100,40);
        button2.setBounds(300,100,100,40);
        JLabel label1 = new JLabel("Maths For Elementary");
        label1.setFont(new Font("Arial",Font.PLAIN,20));
        label1.setBounds(150,20,200,40);
        label1.setForeground(white);
        f_main.add(label1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f_main.setVisible(false);
                Student.createStudentFrame(f_main,bg_image);

            }
        });
        f_main.setSize(500, 500);
        f_main.add(button1);
        f_main.add(button2);
        f_main.setLayout(null);
        f_main.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Main.f_main.setVisible(false);
        Parent.createParentFrame(Main.f_main);

    }

    public static void main(String[] args) {
        new Main();
    }




}