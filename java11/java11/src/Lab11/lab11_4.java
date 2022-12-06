package Lab11;

import javax.swing.*;
import java.awt.*;

public class lab11_4 extends JFrame {
    public lab11_4(){
        super("学生信息");
        super.setLayout(new GridLayout(5,1));
        JPanel p1,p2,p3,p4,p5;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        JLabel l1,l2,l3,l4,l5;
        l1=new JLabel("姓名");
        l2=new JLabel("学号");
        l3=new JLabel("性别");
        l4=new JLabel("爱好");
        l5=new JLabel("系别");
        JTextField tf1,tf2;
        tf1=new JPasswordField(10);
        tf2=new JPasswordField(10);
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(tf2);
        add(p1);
        JRadioButton jrb1,jrb2;
        jrb1=new JRadioButton("男",true);
        jrb2=new JRadioButton("女");
        ButtonGroup bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        p2.add(l3);
        p2.add(jrb1);
        p2.add(jrb2);
        add(p2);
        JCheckBox jcb1,jcb2,jcb3,jcb4;
        jcb1=new JCheckBox("唱歌");
        jcb2=new JCheckBox("阅读");
        jcb3=new JCheckBox("运动");
        jcb4=new JCheckBox("玩游戏");
        p3.add(l4);
        p3.add(jcb1);
        p3.add(jcb2);
        p3.add(jcb3);
        p3.add(jcb4);
        add(p3);
        JComboBox jbox=new JComboBox(new String[]{"计算机系","外语系","电子系","数码媒体系","游戏系","财经系","管理系"});
        p4.add(l5);
        p4.add(jbox);
        add(p4);
        JButton jb1,jb2;
        jb1=new JButton("提交");
        jb2=new JButton("重置");
        p5.add(jb1);
        p5.add(jb2);
        add(p5);
        this.setSize(600,350);
        this.setLocation(200,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new lab11_4();
    }
}