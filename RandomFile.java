import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomFile implements ActionListener {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Random Frame");
        jf.setSize(1000, 1000);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setResizable(true);
        jf.setLayout(new GridLayout(4, 4));
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("" + i);
            jf.getContentPane().add(button);
        }
        JButton button = new JButton("" + 0);
        jf.getContentPane().add(button);
        JButton blah = new JButton("+");
        jf.getContentPane().add(blah);
        JButton blahBlah = new JButton("-");
        jf.getContentPane().add(blahBlah);
        JButton blahBlahBlah = new JButton("*");
        jf.getContentPane().add(blahBlahBlah);
        JButton blahBlahBlahBlah = new JButton("/");
        jf.getContentPane().add(blahBlahBlahBlah);
        JButton ok = new JButton("=");
        jf.getContentPane().add(ok);
        JButton okok = new JButton("%");
        jf.getContentPane().add(okok);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton b = (JButton) actionEvent.getSource();
    }
}
