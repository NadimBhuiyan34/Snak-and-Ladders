
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ludu_Rules extends JFrame {

    Container c;
    JPanel jp;
    JTextArea ta;

    Ludu_Rules() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#4289f4"));

        jp = new JPanel();
        jp.setBounds(17, 13, 760, 600);
        c.add(jp);

        ta = new JTextArea();
        ta.setBounds(5, 5, 750, 580);
        ta.setText("\n     •  Select the color you desire to play with.\n"
                + "     •  Roll the dice by clicking the image of the dice on the righthand side of the\n        window.\n"
                + "     •  The turn of each player shuffles until we get “one” on the dice.\n"
                + "     •  When the number in the dice rolls out to be “one”, then the\n"
                + "     •  Active player can take out his button from the start area.\n"
                + "     •  Then that active player gets another chance to roll the dice.\n"
                + "     •  The button will be moved automatically, when clicked on it, to the desired block\n        as per the number on the dice.\n"
                + "     •  Whenever “one “ appears on the dice, then the active player"
                + " gets another chance\n        to roll the dice.\n"
                + "     •  If “one” doesn’t appear on the dice, then the active player gets only a single\n        chance.\n"
                + "     •  Whenever the button of one player reaches the bottom of a "
                + " ladder then the\n        player can climb up the ladder to the respective position at the top of the ladder.\n"
                + "     •  If the button of one player reaches the square with the head of "
                + "a snake, the\n        player has to retrace back to the square at the tail of the snake.\n"
                + "     •  If a player rolls three 1s on the die, they return to the"
                + " beginning of the game\n        and roll again.\n"
                + "     •  The game is won when the button of a particular player reaches the finish point\n         first.\n\n\n");
        ta.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        jp.add(ta);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setEditable(false);

        setTitle("Rules");
        setBounds(600, 200, 800, 660);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {

        Ludu_Rules frame = new Ludu_Rules();

    }
}
