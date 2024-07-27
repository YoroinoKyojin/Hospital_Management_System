package hospital.management.system;

import jdk.jshell.spi.ExecutionControlProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber,textName,textFieldDisease,textFieldDeposite,textFieldAge;
    JRadioButton r1,r2,r3;
    Choice c1;
    JLabel date;
    JButton b1,b2;
    NEW_PATIENT(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1950,1050);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,1000,200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(418,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(425,76,200,53);
        labelID.setFont(new Font("Tahoma",Font.BOLD,20));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"Aadhar Card","Voter ID","Driving License"});
        comboBox.setBounds(700,90,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(425,120,200,53);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,20));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(700,135,150,20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(425,160,200,53);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(700,175,150,20);
        panel.add(textName);


        JLabel Gender = new JLabel("Gender :");
        Gender.setBounds(425,200,200,53);
        Gender.setFont(new Font("Tahoma",Font.BOLD,20));
        Gender.setForeground(Color.white);
        panel.add(Gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(700,217,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(700,245,80,15);
        panel.add(r2);

        r3 = new JRadioButton("Others");
        r3.setFont(new Font("Tahoma",Font.BOLD,14));
        r3.setForeground(Color.white);
        r3.setBackground(new Color(109,164,170));
        r3.setBounds(700,273,80,15);
        panel.add(r3);

        JLabel labelNumber1 = new JLabel("Age :");
        labelNumber1.setBounds(425,311,200,53);
        labelNumber1.setFont(new Font("Tahoma",Font.BOLD,20));
        labelNumber1.setForeground(Color.white);
        panel.add(labelNumber1);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(700,322,150,20);
        panel.add(textFieldAge);

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(425,360,200,53);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,20));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(700,369,150,20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(425,399,200,53);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        c1.setBounds(700,405,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time: ");
        labelDate.setBounds(425,460,200,17);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,20));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(700,460,250,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(425,500,200,53);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,20));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(700,510,150,20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(500,590,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(700,590,120,31);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);


        setSize(1950,1050);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            conn c = new conn();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }else if(r2.isSelected()){
                radioBTN="Female";
            } else if (r3.isSelected()) {
                radioBTN="Others";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldAge.getText();
            String s6 = textFieldDisease.getText();
            String s7 = c1.getSelectedItem();
            String s8 = date.getText();
            String s9  = textFieldDeposite.getText();
            try{
                String q = "insert into Patient_Info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')";
                String q1 = "update room set Availability='Occupied' where room_no ="+s7;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
