import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainGenerator extends TcGenerator{
    public static String tcNo;
    public static String sonuc;
    public static void main(String[] args) {
        //obj.setBouns(x,y,w,h)
        JFrame frame = new JFrame("Tc Kimlik No Üretici");

        JPanel panel = new JPanel();
        JButton button  = new JButton("TC Üret");
        button.setBounds(10,100,100,30);

        JEditorPane l1 = new JEditorPane();
        l1.setFont(new java.awt.Font("serif", java.awt.Font.PLAIN, 14));
        l1.setBounds(95,10,40,10);
        l1.setEditable(false);
        l1.setBorder(null);
        l1.setOpaque(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TcGenerator generator = new TcGenerator();
                sonuc = generator.randomGenerate();
                l1.setText(sonuc);
            }
        });

        JButton button2  = new JButton("Mernis Ekle");
        button.setBounds(110,100,100,30);

        JEditorPane l2 = new JEditorPane();
        l1.setFont(new java.awt.Font("serif", java.awt.Font.PLAIN, 14));
        l1.setBounds(95,20,80,20);
        l1.setEditable(false);
        l1.setBorder(null);
        l1.setOpaque(false);
        l1.setAlignmentY(50);


        button2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 MernisDbHelper helper = new MernisDbHelper();
                 helper.mernisInsert(sonuc);
             }
         });

        panel.add(button);
        panel.add(button2);
        frame.add(l1, BorderLayout.NORTH);
        frame.add(panel);

        frame.setSize(280,200);
        frame.setBackground(Color.orange);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
