package Lab11;

import javax.swing.*;
import java.awt.*;

public class lab11_1 extends JFrame {
    public lab11_1() {
        super("窗口设计");
        this.setSize(400, 300);
        this.setLocation(450, 200);
        Container con=super.getContentPane();
        con.setBackground(Color.red);
        JPanel p=new JPanel();
        JLabel lbl= new JLabel("这是我创建的第一个窗口",JLabel.CENTER);
        lbl.setFont(new Font("宋体",Font.BOLD,24));
        lbl.setForeground(Color.yellow);
        add(lbl); //将lbl增加到JFrame
        //设置窗口默认关闭方式为退出应用程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//设置窗口可见性
    }

    public static void main(String[] args) {
        new lab11_1();
    }
}