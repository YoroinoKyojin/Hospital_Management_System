package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;
    Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,1920,1080);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(950,250,200,200);
        panel.add(label);

        table= new JTable();
        table.setBounds(150,250,700,900);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        try{
            conn c  = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e)
        {
            e.printStackTrace();;
        }
        JLabel label1 = new JLabel("Room No");
        label1.setBounds(150,230,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(330,230,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Deposite");
        label3.setBounds(510,230,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed");
        label4.setBounds(690,230,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(135,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(1920,1080);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new Room();
    }
}
