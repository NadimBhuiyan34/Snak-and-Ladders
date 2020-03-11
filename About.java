
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class About extends JFrame{
    Container c;
    JPanel jp;
    JLabel create,name1,name2,name3,contact;
    
    About(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#c5f7de"));
        
        create = new JLabel();
        create.setText("C r e a t e d  B y");
        create.setFont(new Font("Showcard Gothic", Font.BOLD+Font.ITALIC, 45));
        create.setBounds(205,50,500,80);
        create.setForeground(Color.decode("#5903c1"));
        c.add(create);
               
        
        name1 = new JLabel();
        name1.setText("Abdullah AN-Noor");
        name1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        name1.setBounds(260,145,400,80);
        name1.setForeground(Color.decode("#1e3860"));
        c.add(name1);
        
        name2 = new JLabel();
        name2.setText("Nadim Bhuiyan");
        name2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        name2.setBounds(290,205,400,80);
        name2.setForeground(Color.decode("#1e3860"));
        c.add(name2);
        
        name3 = new JLabel();
        name3.setText("Fayzul Karim Pathan");
        name3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        name3.setBounds(245,265,400,80);
        name3.setForeground(Color.decode("#1e3860"));
        c.add(name3);
        
        contact = new JLabel();
        contact.setText("Contact : sourav.me@outlook.com | 01752090501");
        contact.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        contact.setBounds(135,400,600,80);
        contact.setForeground(Color.decode("#1c7556"));
        c.add(contact);
        
        setTitle("About");
        setBounds(600,200,780,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String[] args) {
        
        About frame = new About();
        
}

}
