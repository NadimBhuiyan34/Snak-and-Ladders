
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Loading_Screen extends JFrame {

    Container c;
    JPanel p;
    JLabel imglabel;
    ImageIcon img;
    JProgressBar jb;
    int i = 0, num = 0;

    Loading_Screen() {
        c = this.getContentPane();
        c.setBackground(Color.decode("#0acc0d"));
        c.setLayout(null);

        p = new JPanel();
        p.setBounds(0, 0, 1925, 1080);
        c.add(p);
        
        jb=new JProgressBar(0,2000);    
        jb.setValue(0);    
        p.setBackground(Color.GREEN);


        img = new ImageIcon(getClass().getResource("/Image/background.jpg"));
        imglabel = new JLabel(img);
        imglabel.setBounds(0, 0, 1925, 1080);

        
        jb.setBounds(100, 830, 1700, 80);         
        jb.setStringPainted(true);   
        jb.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        jb.setBackground(Color.decode("#424140"));
        jb.setForeground(Color.decode("#42b0f4"));
        jb.setToolTipText("Loading ");
        jb.setString("LOADING...");
        imglabel.add(jb);
        p.add(imglabel);

    }
    
 public void iterate(){    
while(i<=2010){    
  jb.setValue(i);    
  i=i+30;    
  try{Thread.sleep(65);}catch(Exception e){}    
}
 jb.setVisible(false);
        try {
            Thread.sleep(700);
            dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(Loading_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
} 
 
    

    public static void main(String[] args) {
        Loading_Screen frame = new Loading_Screen();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.iterate();
       
       Main class2 = new Main();
      
     

    }
}
