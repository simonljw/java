package Lab11;

import javax.swing.*;

public class lab11_3 extends JFrame {
    public lab11_3(){
        super("简单文本编辑器");
        JPanel pl1,pl2,pl3;
        pl1=new JPanel();
        pl2=new JPanel();
        pl3=new JPanel();
        JLabel lbl=new JLabel("文本文件的路径、名称");
        JTextField tf=new JPasswordField(30);
        pl1.add(lbl);
        pl1.add(tf);
        this.add(pl1,"North");
        JTextArea ta=new JTextArea("这是一个文本编辑器...",40,50);
        pl2.add(ta);
        this.add(pl2);
        JButton jb1,jb2;
        jb1=new JButton("打开文件");
        jb2=new JButton("保存文件");
        pl3.add(jb1);
        pl3.add(jb2);
        this.add(pl3,"South");
        this.setSize(600,200);
        this.setLocation(200,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new lab11_3();
    }
}