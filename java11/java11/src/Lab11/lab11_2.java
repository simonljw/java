package Lab11;

import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JPanel;
        import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class lab11_2 extends JFrame {
    private JPanel p;
    private JLabel lblName, lblPwd, lblRePwd, lblAddress, lblMsg;
    private JTextField txtName;
    private JPasswordField txtPwd;

    private JButton btnReg, btnCancel;

    public lab11_2() {
        super("登录");
        p = new JPanel(null);
        lblName = new JLabel("用户名");
        lblPwd = new JLabel("密码");

        lblMsg = new JLabel();
        txtName = new JTextField(20);
        txtPwd = new JPasswordField(20);
        txtPwd.setEchoChar('*');


        btnReg = new JButton("注册");
        btnCancel = new JButton("清空");


        lblName.setBounds(30, 30, 60, 25);
        txtName.setBounds(80, 30, 180, 25);
        lblPwd.setBounds(30, 60, 60, 25);
        txtPwd.setBounds(80, 60, 180, 25);
        lblMsg.setBounds(60, 85, 180, 25);
        btnReg.setBounds(60, 95, 60, 25);
        btnCancel.setBounds(125, 95, 60, 25);


        p.add(lblName);
        p.add(txtName);
        p.add(lblPwd);
        p.add(txtPwd);

        p.add(lblMsg);
        p.add(btnReg);
        p.add(btnCancel);

        this.add(p);
        this.setSize(280, 180);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new lab11_2();
    }
}