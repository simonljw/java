import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab12_1 extends JFrame implements ActionListener
{
    private int count;
    JPanel p;
    JButton b;
    Lab12_1()
    {
        super("ActionEvent事件");
        p = new JPanel();
        b = new JButton("已点击" + count + "次");
        b.addActionListener(this);
        p.add(b);
        add(p);
        setBounds(200, 300, 200, 300 );
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        count++;
        b.setText("已点击" + count + "次");
    }

    public static void main(String[] args) {
        new Lab12_1();
    }
}
