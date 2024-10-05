import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import static java.awt.Color.white;

public class Student {
    public static void createPlayGameFrame(JFrame m_main)
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
        number1.setEditable(false);
        JTextField number2 = new JTextField();
        number2.setBounds(100,150,150,20);
        number2.setEditable(false);
        JTextField sign = new JTextField();
        sign.setBounds(100,200,150,20);
        sign.setEditable(false);
        JTextField answer = new JTextField();
        answer.setBounds(100,250,150,20);
        JButton button1 = new JButton("Submit Answer");
        JButton button2 = new JButton("Menu");
        button2.setBounds(10,400,100,40);
        button1.setBounds(50,300,100,40);
        JLabel label1 = new JLabel("Number 1");
        JLabel label2 = new JLabel("Number 2");
        JLabel label3 = new JLabel("Sign");
        JLabel label4 = new JLabel("Asnwer");
        JLabel label5 = new JLabel("Student");
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
        f.add(button1);
        f.add(button2);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(label5);
        int questionindex = 0;
        if(Main.number1.size()>0)
        {
            number1.setText(Main.number1.get(questionindex).toString());
            number2.setText(Main.number2.get(questionindex).toString());
            sign.setText(Main.sign.get(questionindex));
            questionindex ++;
        }
        class questionShow implements ActionListener
        {
            public int questionindex = 1;
            public void actionPerformed(ActionEvent e)
            {
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
                if(questionindex < Main.number1.size())
                {
                    answer.setText(Integer.toString(ans));
                    number1.setText(Main.number1.get(questionindex).toString());
                    number2.setText(Main.number2.get(questionindex).toString());
                    sign.setText(Main.sign.get(questionindex));
                    questionindex ++;
                }
                if(ans == Integer.parseInt(answer.getText()))
                {
                    Main.coin++;
                }

            }
        }
        button1.addActionListener(new questionShow());
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                Main.f_main.setVisible(true);

            }
        });
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void createStudentFrame(JFrame f_main,String bg_image) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(bg_image.equals(""))
            f.getContentPane().setBackground(Color.blue);
        else
        {
            f.setLayout(new BorderLayout());
            f.setContentPane(new JLabel(new ImageIcon(bg_image)));
            f.setLayout(new FlowLayout());
        }
        JButton button1 = new JButton("Play Game");
        JButton button2 = new JButton("Item Shop");
        JButton button3 = new JButton("Menu");
        JLabel label1 = new JLabel("Student");
        label1.setFont(new Font("Arial",Font.PLAIN,20));
        label1.setBounds(200,20,200,40);
        button1.setBounds(75,100,100,40);
        button2.setBounds(300,100,100,40);
        button3.setBounds(10,400,100,40);
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                f_main.setVisible(true);

            }
        });
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                createPlayGameFrame(f_main);

            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);

                try {
                    createItemShopFrame(f_main);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        label1.setForeground(white);
        f.add(button1);
        f.add(button2);
        f.add(button3);
        f.add(label1);
        f.setSize(500, 500);
        //if(bg_image.equals(""))
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Main.f_main.setVisible(false);
        Parent.createParentFrame(Main.f_main);

    }
    public static void createItemShopFrame(JFrame f_main) throws IOException {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(Main.bg_image.equals(""))
            f.getContentPane().setBackground(Color.blue);
        else
        {
            f.setLayout(new BorderLayout());
            f.setContentPane(new JLabel(new ImageIcon(Main.bg_image)));
            f.setLayout(new FlowLayout());
        }
        JLabel label1 = new JLabel("Student");
        label1.setFont(new Font("Arial",Font.PLAIN,20));
        label1.setForeground(white);
        label1.setBounds(200,20,200,40);
        JLabel label2 = new JLabel("All Items are 10 Coins Each");
        label2.setFont(new Font("Arial",Font.PLAIN,20));
        label2.setForeground(white);
        label2.setBounds(120,50,250,40);
        JLabel coinLabel = new JLabel("Coins: " + Main.coin);
        coinLabel.setBounds(350,20,100,20);
        coinLabel.setFont(new Font("Arial",Font.PLAIN,20));
        coinLabel.setForeground(white);
        Image bg_image1 = ImageIO.read(new File("image1.jpg"));
        ImageIcon icon1 = new ImageIcon(bg_image1);
        JRadioButton image1 = new JRadioButton("1",icon1);
        image1.setBounds(100,100,150,150);
        Image bg_image2 = ImageIO.read(new File("image2.jpg"));
        ImageIcon icon2 = new ImageIcon(bg_image2);
        JRadioButton image2 = new JRadioButton("1",icon2);
        Image bg_image3 = ImageIO.read(new File("image3.jpg"));
        ImageIcon icon3 = new ImageIcon(bg_image3);
        JRadioButton image3 = new JRadioButton("1",icon3);
        Image bg_image4 = ImageIO.read(new File("image4.jpg"));
        ImageIcon icon4 = new ImageIcon(bg_image4);
        JRadioButton image4 = new JRadioButton("1",icon4);
        JButton choose = new JButton("Choose");
        JButton button1 = new JButton("Menu");
        button1.setBounds(10,400,100,40);
        choose.setBounds(350,400,100,40);
        image1.setBounds(100,100,100,40);
        image2.setBounds(100,300,100,40);
        image3.setBounds(300,100,100,40);
        image4.setBounds(300,300,100,40);
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(image1);
        buttons.add(image2);
        f.add(choose);
        f.add(button1);
        f.add(image2);
        f.add(image1);
        f.add(image3);
        f.add(image4);
        f.add(label1);
        f.add(label2);
        f.add(coinLabel);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                //f_main.setVisible(true);
                Main.changebg();

            }
        });
        class RadioButtonSelection implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Main.coin >= 10)
                {
                    if(image1.isSelected())
                        Main.bg_image = "image1.jpg";
                    else if(image2.isSelected())
                        Main.bg_image = "image2.jpg";
                    else if(image3.isSelected())
                        Main.bg_image = "image3.jpg";
                    else if(image4.isSelected())
                        Main.bg_image = "image4.jpg";
                    Main.coin = Main.coin-10;
                    coinLabel.setText("Coin: " + Main.coin);

                }
                if(!Main.bg_image.equals(""))
                {

                    try {
                        createItemShopFrame(f_main);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
        choose.addActionListener(new RadioButtonSelection());
    }

}
