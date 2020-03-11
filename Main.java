
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Main extends JFrame {
	private JPanel contentPane;
	private final JLabel lblBoard1 = new JLabel("New label");
	private final JLabel lblBoard2 = new JLabel("New label2");
	private final JLabel lblBoard3 = new JLabel("New label3");
	private final JLabel lblBoard4 = new JLabel("New label4");
	private final JLabel lblBoard5 = new JLabel("New label5");
	private JLabel lblDimage;
	private JLabel lblP1;
	private JButton btnDice, btnRestart, btnRules, btnAbout, btnExit; 
        
                      private JTextArea infoArea;
        
	private JLabel lblPlayerName;
	private JLabel lbl91 , lbl92 , lbl93 , lbl94 , lbl95 , lbl96 , lbl97 , lbl98 , lbl100 , lbl99 , lbl90 , lbl89 , lbl88 , lbl87 , lbl86 , lbl85 , lbl84 , lbl83 ,
                lbl81 , lbl82 , lbl71 , lbl72 , lbl73 , lbl74 , lbl75 , lbl76 , lbl77 , lbl78 , lbl80 , lbl79 , lbl70 , lbl69 , lbl68 , lbl67 , lbl66 , lbl65 , lbl64 , lbl63 , lbl61 ,
                lbl62 , lbl51 , lbl52 , lbl53 , lbl54 , lbl55 , lbl56 , lbl57 , lbl58 , lbl60 , lbl59 , lbl50 , lbl49 , lbl48 , lbl47 , lbl46 , lbl45 , lbl44 , lbl43 , lbl41 , lbl42 ,
                lbl31 , lbl32 , lbl33 , lbl34 , lbl35 , lbl36 , lbl37 , lbl38 , lbl40 , lbl39 , lbl30 , lbl29 , lbl28 , lbl27 , lbl26 , lbl25 , lbl24 , lbl23 , lbl21 , lbl22 , lbl11 ,
                lbl12 , lbl13 , lbl14 , lbl15 , lbl16 , lbl17 , lbl18 , lbl19, lbl20 , lbl10 , lbl9 , lbl8 , lbl7 , lbl6 , lbl5 , lbl4 , lbl3 , lbl2 , lbl1 , p1score , lblP2 , p2score ,
                lblP3 ,  p3score , lblP4 , p4score , lblPlayer , p1btn , label , label_1 , label_2;
	
                   private int flag1=0,winingPosition=0, diceClick=0, boardChange = 1;

	private int player=1;    // running player er index.
	public int playerFlag=6;
	private int[] flag= new int[playerFlag];   // flag 1 hoile khela shuru korbe prottek player
	//private int[] location= new int[2];  // 2jon player er location thakbe.
	public int playerPos=4;
	private int[] playerposition= new int[playerPos]; //4jon player er position
	private int oldposition;   //player er ager position. karon amk ager position ta muche dite hobe
	private int point, score=0, f=0;
	private int playerNo;
	private int count=0;
	private int chokkarAaagerPosition=0,chokka=0;
	public String[] playerName;
        
        
	/**
	 * Launch the application.
	 *///constructor
	public Main()  {
                                        initialize();
		setTitle("Snakes and Ladders");          
                                        setExtendedState(JFrame.MAXIMIZED_BOTH);
                                        setVisible(true);
                                        setResizable(true);
                                            
               
	}
        
	public static void main(String[] args) {                    //main method. launch from here/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
                

	}

	/**
	 * Create the frame.
	 */

	//point ta 1 theke 6 er moddhe random number create kore return kore and oi number onujayi dice er pic show kore
	public void Dice(){
		Random rn = new Random();
		point = rn.nextInt(6)+1;
		//point=chokkaTest();

		String dice = String.valueOf(point);
		String location = "/Image/dice "+dice+".jpg";
		lblDimage.setIcon(new ImageIcon(Main.class.getResource(location)));   //player er guti board e boshay

		if(point==1) flag[player-1]=1;      //gutir chal 1 hoile she khela shuru korte parbe
		if(flag[player-1]==1)movedisc();
		//System.out.println("Dice: "+dice);
		
	}
	

	 	public void Paint(int x, int y){
		//System.out.println("Paint from: "+x+" to "+y);
		new Thread() {
	        @Override
	        public void run() {
	            try {
	            	//btnDice.setEnabled(false);
	            	//btnDice.setVisible(false);
	            	Thread.sleep(500);
	            	for(int i=x; i<y; i++){
	            		//System.out.println("Paint Player after: "+p);
	            		RemoveImage(i);
	            		Thread.sleep(50);
		            	SetImage(i+1,player);
		                Thread.sleep(500);
	            	}
	            	//btnDice.setVisible(true);
	            	//btnDice.setEnabled(true);
	            } catch (InterruptedException ex) {
	                Thread.currentThread().interrupt();
	                JOptionPane.showMessageDialog(null, "Paint timer error!");
	            }

	        }
	    }.start();
	    
	    
	   ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	                

	        }
	    };
	    javax.swing.Timer t = new javax.swing.Timer(1000, taskPerformer);
	    t.setRepeats(false);
	    t.start();
	}
	
	



	   //---------------------------guti move korate ei function
	
	public void movedisc(){
		
		//-----------------------------------------------------chokka uthle count baraitesi ar na uthle count 0---------//
		if(point==6){chokka++;
		
		}
        else chokka=0;
		
		if(chokka>0){
		chokkarAaagerPosition=playerposition[player-1];
		lblPlayer.setText(playerName[player-1]);
		 count=1;
		 
		 colorChange(); //color change kori
		 
		}
		if(count==1 & chokka==0){
			if(player==playerPos)lblPlayer.setText(playerName[0]);
			
	 		else lblPlayer.setText(playerName[player]);
			count=0;
		}
		//---------------------------------------//
		if(playerposition[player-1]+point >100){   //player er position 100er beshi hole ager jaygay e thakbe//
			playerposition[player-1]= playerposition[player-1] ;
		}	
		//------------3bar chokka uthle ager ghore pathaye dibe-------------//
		else if(chokka==3){
			playerposition[player-1]=chokkarAaagerPosition;
		}
		//------------------------------------------------------------------------------------------------------------------//
		
		
		else{
			

			
        int xa= playerposition[player-1];
		//RemoveImage(playerposition[player-1]);    //she ekhon notun position e jabe. ager ghor theke ore ber kore deya hocche
		int ya= playerposition[player-1]+point;
		playerposition[player-1]+=point;              //tar ager position er sathe chal e asha man jog kortese
        for(int i=xa;i<ya;i++){
        	
        	
        	try {
        		RemoveImage(i);
        		Thread.sleep(50);
            	SetImage(i+1, player);
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }


		//SetImage(playerposition[player-1], player);      //jei jei player tar tar position e boshacche, chal e man pawar por

                    if(boardChange==1){
                              SkipTest(playerposition[player-1]); 
                             }
                    if(boardChange==2){
                             SkipTest2(playerposition[player-1]);
                           }
                    if(boardChange==3){
                             SkipTest3(playerposition[player-1]);
                           }
                    if(boardChange==4){
                             SkipTest4(playerposition[player-1]);
                           }
                    if(boardChange==5){
                             SkipTest5(playerposition[player-1]);
                           }
		   //shap e katse kina ba moi baia upore uthse kina dekhtese

                                      if(boardChange==1){  
		if(playerposition[player-1] != Skipper(playerposition[player-1])){     //jodi shap e kate ba moi paia jay tahole amader ja koroniyo
			RemoveImage(playerposition[player-1]);
			playerposition[player-1]=Skipper(playerposition[player-1]);
			SetImage(playerposition[player-1], player);
		}  
                                      }
                                      
                                      if(boardChange==2){  
		if(playerposition[player-1] != Skipper2(playerposition[player-1])){     //jodi shap e kate ba moi paia jay tahole amader ja koroniyo
			RemoveImage(playerposition[player-1]);
			playerposition[player-1]=Skipper2(playerposition[player-1]);
			SetImage(playerposition[player-1], player);
		}  
                                      }
                                      
                                      if(boardChange==3){  
		if(playerposition[player-1] != Skipper3(playerposition[player-1])){     //jodi shap e kate ba moi paia jay tahole amader ja koroniyo
			RemoveImage(playerposition[player-1]);
			playerposition[player-1]=Skipper3(playerposition[player-1]);
			SetImage(playerposition[player-1], player);
		}  
                                      }
                                      if(boardChange==4){  
		if(playerposition[player-1] != Skipper4(playerposition[player-1])){     //jodi shap e kate ba moi paia jay tahole amader ja koroniyo
			RemoveImage(playerposition[player-1]);
			playerposition[player-1]=Skipper4(playerposition[player-1]);
			SetImage(playerposition[player-1], player);
		}  
                                      }
                                      if(boardChange==5){  
		if(playerposition[player-1] != Skipper5(playerposition[player-1])){     //jodi shap e kate ba moi paia jay tahole amader ja koroniyo
			RemoveImage(playerposition[player-1]);
			playerposition[player-1]=Skipper5(playerposition[player-1]);
			SetImage(playerposition[player-1], player);
		}  
                                      }

		winCheck();     //---win hoise kina test kore msg dibe-----//
		
		
		setScore();     //-------Score set korbe. and win hole shei msg diye dibe//
		
		
		}

	}
	
                     //--------------- colorChange() 'PlayerName' er color change hobe ----------------//
        
	public void colorChange(){
		 if(player==4){
	 			lblPlayer.setForeground(new Color(0, 204, 255)); //1
	 		}
	 		if(player==1){
	 			lblPlayer.setForeground(new Color(255, 204, 0)); //4
	 		}
	 		if(player==2){
	 			lblPlayer.setForeground(new Color(255, 51, 102)); //3
	 		}
	 		if(player==3){
	 			
	 			lblPlayer.setForeground(new Color(204, 51, 204)); //2
	 		}
	}




	public void PositionCheck(int x){         //suppose dui jon eki ghore gese.. ek jon ber hoye jawar somoy jate arekjon na ber hoye jete pare

		for(int i=0; i<playerPos; i++){
			if(playerposition[i] == x && playerposition[i] != 0 && player != i+1){
				SetImage(x, i+1);
				//JOptionPane.showMessageDialog(null	, "Player matched with player "+String.valueOf(i+1));
				//JOptionPane.showMessageDialog(null	, playerName[player]+"Player matched with player "+playerName[i]);
			}
		}
		//JOptionPane.showMessageDialog(null, "position check ok");

	}


   public void winCheck(){
	   
		if(playerposition[player-1]==100) winingPosition++;
		
		if(playerposition[player-1] ==100 && flag1==0){   //
			JOptionPane.showMessageDialog(null, "Player "+player+" won!!");
			flag1=1;
		}
	   
   }
   
   public void setScore(){
	   
		if(player==1){
			
			
			//
		
			if( winingPosition==playerPos) p1score.setText("Looser :P ");
			 else if(playerposition[player-1]==100) p1score.setText("Winner "+winingPosition);
			else p1score.setText(String.valueOf(playerposition[player-1]));	    //Kun player er Score koto seta show kore ditese
		}
		
		else if(player==2){
		

			 if( winingPosition==playerPos) p2score.setText("Looser HaHA! ");
			 else if(playerposition[player-1]==100) p2score.setText("Winner "+winingPosition);
			else 
			p2score.setText(String.valueOf(playerposition[player-1]));	 	//score show
		
			
		}
		else if(player==3){
			
			 if ( winingPosition==playerPos) p3score.setText("Looser HaHA ");
			 else if(playerposition[player-1]==100) p3score.setText("Winner "+winingPosition);
				else 
				p3score.setText(String.valueOf(playerposition[player-1]));	 	//score show
		
			
		}
		else if(player==4){
	
			 if ( winingPosition==playerPos-1) p4score.setText("Looser HaHA ");
			 else if(playerposition[player-1]==100) p4score.setText("Winner "+winingPosition);
				else 
				p4score.setText(String.valueOf(playerposition[player-1]));	 	//score show
		}
	   
   }




        

        

    public void SkipTest(int score){              ///jOptionpane e show korbe shap katse kina ba moi paise kina
            if(score == 23 || score == 32  || score == 61  || score == 65 || score == 75 ){
	System.out.println(playerName[player-1]+" Ladder at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Climbed Ladder at "+String.valueOf(score));
            }
            else if(score == 21  ||score == 27 ||  score == 47 || score == 56  ||score == 74  || score == 90  || score == 99 ){
	System.out.println(playerName[player-1]+" Snake at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Eaten by Snake at "+String.valueOf(score));
            }
    }
    
    
    
        public void SkipTest2(int score){              ///jOptionpane e show korbe shap katse kina ba moi paise kina
            if(score == 4 || score == 13  || score == 33  || score == 42 || score == 50 || score == 62 || score == 74 ){
	System.out.println(playerName[player-1]+" Ladder at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Climbed Ladder at "+String.valueOf(score));
            }
            else if(score == 27  ||score == 40 ||  score == 43 || score == 54  ||score == 66  || score == 76  || score == 89 || score == 99 ){
	System.out.println(playerName[player-1]+" Snake at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Eaten by Snake at "+String.valueOf(score));
            }
    }
        
        
        public void SkipTest3(int score){              ///jOptionpane e show korbe shap katse kina ba moi paise kina
            if(score == 2 || score == 6  || score == 20  || score == 57 || score == 71 ){
	System.out.println(playerName[player-1]+" Ladder at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Climbed Ladder at "+String.valueOf(score));
            }
            else if(score == 4 || score == 30){
	System.out.println(playerName[player-1]+" ROCKET at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Climbed ROCKET at "+String.valueOf(score));
            }
            else if(score == 43  ||score == 50 ||  score == 56 || score == 84  ||score == 87  || score == 98){
	System.out.println(playerName[player-1]+" Snake at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Eaten by Snake at "+String.valueOf(score));
            }
    }
        
        public void SkipTest4(int score){              ///jOptionpane e show korbe shap katse kina ba moi paise kina
            if(score == 4 || score == 14  || score == 21  || score == 30 || score == 43 ){
	System.out.println(playerName[player-1]+" Rocket at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Climbed Rocket at "+String.valueOf(score));
            }
            else if(score == 5 || score == 61 || score == 92){
	System.out.println(playerName[player-1]+" +3 at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Climbed +3 at "+String.valueOf(score));
            }
            else if(score == 56  ||score == 62 ||  score == 76 || score == 88  ||score == 91  || score == 97){
	System.out.println(playerName[player-1]+" Crashed at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Crashed at "+String.valueOf(score));
            }
    }
        
        
                public void SkipTest5(int score){              ///jOptionpane e show korbe shap katse kina ba moi paise kina
            if(score == 2 || score == 6 || score == 20  || score == 52  || score == 57 || score == 74 || score == 78){
	System.out.println(playerName[player-1]+" Ladder at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Climbed Ladder at "+String.valueOf(score));
            }
            else if(score == 30  ||score == 37 ||  score == 56 || score == 84  || score == 87  || score == 98 ){
	System.out.println(playerName[player-1]+" Dragon at "+score);
	JOptionPane.showMessageDialog(null, playerName[player-1]+" Eaten by Dragon at "+String.valueOf(score));
            }
    }


	/*
	 * shap katle ba moi paile onno ghore jabe oi fucntion
	 */
	public int Skipper(int score){
		if(score == 21)
			return 2;
		else if(score == 27)
			return 15;
		else if(score == 23)
			return 42;
		else if(score == 32)
			return 51;

		else if(score == 47)
			return 29;
		else if(score == 56)
			return 37;
		else if(score == 61)
			return 79;
		else if(score == 65)
			return 84;
		else if(score == 74)
			return 46;
		else if(score == 90)
			return 52;
		else if(score == 75)
			return 96;
		else if(score == 99)
			return 41;

		else
			return score;

	}

        
        
        
        
        	public int Skipper2(int score){
		if(score == 4)
			return 25;
		else if(score == 27)
			return 5;
		else if(score == 40)
			return 3;
		else if(score == 43)
			return 18;

		else if(score == 13)
			return 46;
		else if(score == 33)
			return 49;
		else if(score == 54)
			return 31;
		else if(score == 42)
			return 63;
		else if(score == 66)
			return 45;
		else if(score == 50)
			return 69;
		else if(score == 76)
			return 58;
		else if(score == 62)
			return 81;
		else if(score == 89)
			return 53;
		else if(score == 74)
			return 92;
		else if(score == 99)
			return 41;

		else
			return score;

	}
                
        	public int Skipper3(int score){
		if(score == 2)
			return 23;
		else if(score == 4)
			return 68;
		else if(score == 6)
			return 45;
		else if(score == 20)
			return 59;

		else if(score == 30)
			return 96;
		else if(score == 43)
			return 17;
		else if(score == 50)
			return 5;
		else if(score == 56)
			return 8;
		else if(score == 57)
			return 96;
		else if(score == 71)
			return 92;
		else if(score == 84)
			return 58;
		else if(score == 87)
			return 49;
		else if(score == 98)
			return 40;
                
		else
			return score;

	}
                
                
        	public int Skipper4(int score){
		if(score == 4)
			return 68;
		else if(score == 5)
			return 8;
		else if(score == 14)
			return 84;
		else if(score == 21)
			return 59;

		else if(score == 30)
			return 95;
		else if(score == 43)
			return 90;
		else if(score == 56)
			return 19;
		else if(score == 61)
			return 64;
		else if(score == 62)
			return 25;
		else if(score == 76)
			return 9;
		else if(score == 88)
			return 52;
		else if(score == 91)
			return 65;
		else if(score == 92)
			return 95;
		else if(score == 97)
			return 79;
                
		else
			return score;

	}
                
        	public int Skipper5(int score){
		if(score == 2)
			return 23;
		else if(score == 6)
			return 45;
		else if(score == 20)
			return 59;
		else if(score == 30)
			return 16;
		else if(score == 37)
			return 3;
		else if(score == 52)
			return 72;
		else if(score == 56)
			return 8;
		else if(score == 57)
			return 96;
		else if(score == 74)
			return 94;
		else if(score == 78)
			return 98;
		else if(score == 84)
			return 64;
		else if(score == 87)
			return 31;
		else if(score == 98)
			return 40;
                
		else
			return score;

	}





	 // kono ghor theke gutir image remove korar jonne eita
        public void RemoveImage(int x){
                //System.out.println("Remove Image at "+ String.valueOf(x));
                if(x == 1){lbl1.setVisible(false);} else if(x == 2){lbl2.setVisible(false);} else if(x == 3){lbl3.setVisible(false);} else if(x == 4){lbl4.setVisible(false);}
                else if(x == 5){lbl5.setVisible(false);} else if(x == 6){ lbl6.setVisible(false);} else if(x == 7){lbl7.setVisible(false);}else if(x == 8){lbl8.setVisible(false);}
                else if(x == 9){lbl9.setVisible(false);} else if(x == 10){lbl10.setVisible(false);} else if(x == 11){lbl11.setVisible(false);} else if(x == 12){lbl12.setVisible(false);}
                else if(x == 13){lbl13.setVisible(false);} else if(x == 14){lbl14.setVisible(false);} else if(x == 15){lbl15.setVisible(false);} else if(x == 16){lbl16.setVisible(false);}
                else if(x == 17){lbl17.setVisible(false);} else if(x == 18){lbl18.setVisible(false);} else if(x == 19){lbl19.setVisible(false);} else if(x == 20){lbl20.setVisible(false);}
                else if(x == 21){lbl21.setVisible(false);} else if(x == 22){lbl22.setVisible(false);} else if(x == 23){lbl23.setVisible(false);} else if(x == 24){lbl24.setVisible(false);}
                else if(x == 25){lbl25.setVisible(false);} else if(x == 26){lbl26.setVisible(false);} else if(x == 27){lbl27.setVisible(false);} else if(x == 28){lbl28.setVisible(false);}
                else if(x == 29){lbl29.setVisible(false);} else if(x == 30){lbl30.setVisible(false);} else if(x == 31){lbl31.setVisible(false);} else if(x == 32){lbl32.setVisible(false);}
                else if(x == 33){lbl33.setVisible(false);} else if(x == 34){lbl34.setVisible(false);} else if(x == 35){lbl35.setVisible(false);} else if(x == 36){lbl36.setVisible(false);}
                else if(x == 37){lbl37.setVisible(false);} else if(x == 38){lbl38.setVisible(false);} else if(x == 39){lbl39.setVisible(false);} else if(x == 40){lbl40.setVisible(false);}
                else if(x == 41){lbl41.setVisible(false);} else if(x == 42){lbl42.setVisible(false);} else if(x == 43){lbl43.setVisible(false);} else if(x == 44){lbl44.setVisible(false);}
                else if(x == 45){lbl45.setVisible(false);} else if(x == 46){lbl46.setVisible(false);} else if(x == 47){lbl47.setVisible(false);} else if(x == 48){lbl48.setVisible(false);}
                else if(x == 49){lbl49.setVisible(false);} else if(x == 50){lbl50.setVisible(false);} else if(x == 51){lbl51.setVisible(false);} else if(x == 52){lbl52.setVisible(false);}
                else if(x == 53){lbl53.setVisible(false);} else if(x == 54){lbl54.setVisible(false);} else if(x == 55){lbl55.setVisible(false);} else if(x == 56){lbl56.setVisible(false);}
                else if(x == 57){lbl57.setVisible(false);} else if(x == 58){lbl58.setVisible(false);} else if(x == 59){lbl59.setVisible(false);} else if(x == 60){lbl60.setVisible(false);}
                else if(x == 61){lbl61.setVisible(false);} else if(x == 62){lbl62.setVisible(false);} else if(x == 63){lbl63.setVisible(false);} else if(x == 64){lbl64.setVisible(false);}
                else if(x == 65){lbl65.setVisible(false);} else if(x == 66){lbl66.setVisible(false);} else if(x == 67){lbl67.setVisible(false);} else if(x == 68){lbl68.setVisible(false);}
                else if(x == 69){lbl69.setVisible(false);} else if(x == 70){lbl70.setVisible(false);} else if(x == 71){lbl71.setVisible(false);} else if(x == 72){lbl72.setVisible(false);}
                else if(x == 73){lbl73.setVisible(false);} else if(x == 74){lbl74.setVisible(false);} else if(x == 75){lbl75.setVisible(false);} else if(x == 76){lbl76.setVisible(false);}
                else if(x == 77){lbl77.setVisible(false);} else if(x == 78){lbl78.setVisible(false);} else if(x == 79){lbl79.setVisible(false);} else if(x == 80){lbl80.setVisible(false);}
                else if(x == 81){lbl81.setVisible(false);} else if(x == 82){lbl82.setVisible(false);}else if(x == 83){lbl83.setVisible(false);} else if(x == 84){lbl84.setVisible(false);}
                else if(x == 85){lbl85.setVisible(false);} else if(x == 86){lbl86.setVisible(false);} else if(x == 87){lbl87.setVisible(false);} else if(x == 88){lbl88.setVisible(false);}
                else if(x == 89){lbl89.setVisible(false);} else if(x == 90){lbl90.setVisible(false);} else if(x == 91){lbl91.setVisible(false);} else if(x == 92){lbl92.setVisible(false);}
                else if(x == 93){lbl93.setVisible(false);} else if(x == 94){lbl94.setVisible(false);} else if(x == 95){lbl95.setVisible(false);} else if(x == 96){lbl96.setVisible(false);}
                else if(x == 97){lbl97.setVisible(false);} else if(x == 98){lbl98.setVisible(false);} else if(x == 99){lbl99.setVisible(false);} else if(x == 100){lbl100.setVisible(false);}

		PositionCheck(x);   //positionCheck method k call kortesi.. karon same position e koyjon ase check korar jonne

		//nicher tukun bug fix korte help kore
		//JOptionPane.showMessageDialog(null, "remove image at "+String.valueOf(x)+" for player "+String.valueOf(player));
	}


	public void SetImage(int x, int pl){   //ghore gutir image set korar jonne eta


	    String p=String.valueOf(pl);

		String location = "/Image/Player "+p+".png";


		if(x == 1){			lbl1.setVisible(true);			lbl1.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 2){			lbl2.setVisible(true);			lbl2.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 3){			lbl3.setVisible(true);			lbl3.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 4){			lbl4.setVisible(true);			lbl4.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 5){			lbl5.setVisible(true);			lbl5.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 6){			lbl6.setVisible(true);			lbl6.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 7){			lbl7.setVisible(true);			lbl7.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 8){			lbl8.setVisible(true);			lbl8.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 9){			lbl9.setVisible(true);			lbl9.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 10){			lbl10.setVisible(true);			lbl10.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 11){			lbl11.setVisible(true);			lbl11.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 12){			lbl12.setVisible(true);			lbl12.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 13){			lbl13.setVisible(true);			lbl13.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 14){			lbl14.setVisible(true);			lbl14.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 15){			lbl15.setVisible(true);			lbl15.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 16){			lbl16.setVisible(true);			lbl16.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 17){			lbl17.setVisible(true);			lbl17.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 18){			lbl18.setVisible(true);			lbl18.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 19){			lbl19.setVisible(true);			lbl19.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 20){			lbl20.setVisible(true);			lbl20.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 21){			lbl21.setVisible(true);			lbl21.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 22){			lbl22.setVisible(true);			lbl22.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 23){			lbl23.setVisible(true);			lbl23.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 24){			lbl24.setVisible(true);			lbl24.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 25){			lbl25.setVisible(true);			lbl25.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 26){			lbl26.setVisible(true);			lbl26.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 27){			lbl27.setVisible(true);			lbl27.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 28){			lbl28.setVisible(true);			lbl28.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 29){			lbl29.setVisible(true);			lbl29.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 30){			lbl30.setVisible(true);			lbl30.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 31){			lbl31.setVisible(true);			lbl31.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 32){			lbl32.setVisible(true);			lbl32.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 33){			lbl33.setVisible(true);			lbl33.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 34){			lbl34.setVisible(true);			lbl34.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 35){			lbl35.setVisible(true);			lbl35.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 36){			lbl36.setVisible(true);			lbl36.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 37){			lbl37.setVisible(true);			lbl37.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 38){			lbl38.setVisible(true);			lbl38.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 39){			lbl39.setVisible(true);			lbl39.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 40){			lbl40.setVisible(true);			lbl40.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 41){			lbl41.setVisible(true);			lbl41.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 42){			lbl42.setVisible(true);			lbl42.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 43){			lbl43.setVisible(true);			lbl43.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 44){			lbl44.setVisible(true);			lbl44.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 45){			lbl45.setVisible(true);			lbl45.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 46){			lbl46.setVisible(true);			lbl46.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 47){			lbl47.setVisible(true);			lbl47.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 48){			lbl48.setVisible(true);			lbl48.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 49){			lbl49.setVisible(true);			lbl49.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 50){			lbl50.setVisible(true);			lbl50.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 51){			lbl51.setVisible(true);			lbl51.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 52){			lbl52.setVisible(true);			lbl52.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 53){			lbl53.setVisible(true);			lbl53.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 54){			lbl54.setVisible(true);			lbl54.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 55){			lbl55.setVisible(true);			lbl55.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 56){			lbl56.setVisible(true);			lbl56.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 57){			lbl57.setVisible(true);			lbl57.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 58){			lbl58.setVisible(true);			lbl58.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 59){			lbl59.setVisible(true);			lbl59.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 60){			lbl60.setVisible(true);			lbl60.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 61){			lbl61.setVisible(true);			lbl61.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 62){			lbl62.setVisible(true);			lbl62.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 63){			lbl63.setVisible(true);			lbl63.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 64){			lbl64.setVisible(true);			lbl64.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 65){			lbl65.setVisible(true);			lbl65.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 66){			lbl66.setVisible(true);			lbl66.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 67){			lbl67.setVisible(true);			lbl67.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 68){			lbl68.setVisible(true);			lbl68.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 69){			lbl69.setVisible(true);			lbl69.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 70){			lbl70.setVisible(true);			lbl70.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 71){			lbl71.setVisible(true);			lbl71.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 72){			lbl72.setVisible(true);			lbl72.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 73){			lbl73.setVisible(true);			lbl73.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 74){			lbl74.setVisible(true);			lbl74.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 75){			lbl75.setVisible(true);			lbl75.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 76){			lbl76.setVisible(true);			lbl76.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 77){			lbl77.setVisible(true);			lbl77.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 78){			lbl78.setVisible(true);			lbl78.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 79){			lbl79.setVisible(true);			lbl79.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 80){			lbl80.setVisible(true);			lbl80.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 81){			lbl81.setVisible(true);			lbl81.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 82){			lbl82.setVisible(true);			lbl82.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 83){			lbl83.setVisible(true);			lbl83.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 84){			lbl84.setVisible(true);			lbl84.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 85){			lbl85.setVisible(true);			lbl85.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 86){			lbl86.setVisible(true);			lbl86.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 87){			lbl87.setVisible(true);			lbl87.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 88){			lbl88.setVisible(true);			lbl88.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 89){			lbl89.setVisible(true);			lbl89.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 90){			lbl90.setVisible(true);			lbl90.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 91){			lbl91.setVisible(true);			lbl91.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 92){			lbl92.setVisible(true);			lbl92.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 93){			lbl93.setVisible(true);			lbl93.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 94){			lbl94.setVisible(true);			lbl94.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 95){			lbl95.setVisible(true);			lbl95.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 96){			lbl96.setVisible(true);			lbl96.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 97){			lbl97.setVisible(true);			lbl97.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 98){			lbl98.setVisible(true);			lbl98.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 99){			lbl99.setVisible(true);			lbl99.setIcon(new ImageIcon(Main.class.getResource(location)));		}		else if(x == 100){			lbl100.setVisible(true);			lbl100.setIcon(new ImageIcon(Main.class.getResource(location)));		}

		//bug fix er jonne nicher tukun
		//JOptionPane.showMessageDialog(null, "image set at "+String.valueOf(x)+" for player "+String.valueOf(pl));

	}






	@SuppressWarnings("serial")
	public void initialize(){    //game board er label, ghorer label and other label gula shob initialize kortesi

//-----------------------------------------------------------------------------------------------------------------------//
		// Input no of players
		
		try{
			do{
				JOptionPane.showMessageDialog(null, "Players must be between 2-4!");
				playerPos = Integer.parseInt(JOptionPane.showInputDialog("Enter No of players"));
			}while(playerPos < 2 || playerPos > 4);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Invalid players");
			System.exit(0);		// Error and exit
		}


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

                                            lbl1 = new JLabel(""); lbl1.setBounds(170, 860, 90, 90); contentPane.add(lbl1);
                                            lbl2 = new JLabel(""); lbl2.setBounds(260, 860, 90, 90); contentPane.add(lbl2);
                                            lbl3 = new JLabel(""); lbl3.setBounds(350, 860, 90, 90); contentPane.add(lbl3);
                                            lbl4 = new JLabel(""); lbl4.setBounds(440, 860, 90, 90); contentPane.add(lbl4);
                                            lbl5 = new JLabel(""); lbl5.setBounds(530, 860, 90, 90); contentPane.add(lbl5);
                                            lbl6 = new JLabel(""); lbl6.setBounds(620, 860, 90, 90); contentPane.add(lbl6);
                                            lbl7 = new JLabel(""); lbl7.setBounds(710, 860, 90, 90); contentPane.add(lbl7);
                                            lbl8 = new JLabel(""); lbl8.setBounds(800, 860, 90, 90); contentPane.add(lbl8);
                                            lbl9 = new JLabel(""); lbl9.setBounds(890, 860, 90, 90); contentPane.add(lbl9);
                                            lbl10 = new JLabel(""); lbl10.setBounds(980, 860, 90, 90); contentPane.add(lbl10);
                                            lbl11 = new JLabel(""); lbl11.setBounds(980, 770, 90, 90); contentPane.add(lbl11);
                                            lbl12 = new JLabel(""); lbl12.setBounds(890, 770, 90, 90); contentPane.add(lbl12);
                                            lbl13 = new JLabel(""); lbl13.setBounds(800, 770, 90, 90); contentPane.add(lbl13);
                                            lbl14 = new JLabel(""); lbl14.setBounds(710, 770, 90, 90); contentPane.add(lbl14);
                                            lbl15 = new JLabel(""); lbl15.setBounds(620, 770, 90, 90); contentPane.add(lbl15);
                                            lbl16 = new JLabel(""); lbl16.setBounds(530, 770, 90, 90); contentPane.add(lbl16);
                                            lbl17 = new JLabel(""); lbl17.setBounds(440, 770, 90, 90); contentPane.add(lbl17);
                                            lbl18 = new JLabel(""); lbl18.setBounds(350, 770, 90, 90); contentPane.add(lbl18);
                                            lbl19 = new JLabel(""); lbl19.setBounds(260, 770, 90, 90); contentPane.add(lbl19);
                                            lbl20 = new JLabel(""); lbl20.setBounds(170, 770, 90, 90); contentPane.add(lbl20);
                                            lbl21 = new JLabel(""); lbl21.setBounds(170, 680, 90, 90); contentPane.add(lbl21);
                                            lbl22 = new JLabel(""); lbl22.setBounds(260, 680, 90, 90); contentPane.add(lbl22);
                                            lbl23 = new JLabel(""); lbl23.setBounds(350, 680, 90, 90); contentPane.add(lbl23);
                                            lbl24 = new JLabel(""); lbl24.setBounds(440, 680, 90, 90); contentPane.add(lbl24);
                                            lbl25 = new JLabel(""); lbl25.setBounds(530, 680, 90, 90); contentPane.add(lbl25);
                                            lbl26 = new JLabel(""); lbl26.setBounds(620, 680, 90, 90); contentPane.add(lbl26);
                                            lbl27 = new JLabel(""); lbl27.setBounds(710, 680, 90, 90); contentPane.add(lbl27);
                                            lbl28 = new JLabel(""); lbl28.setBounds(800, 680, 90, 90); contentPane.add(lbl28);
                                            lbl29 = new JLabel(""); lbl29.setBounds(890, 680, 90, 90); contentPane.add(lbl29);
                                            lbl30 = new JLabel(""); lbl30.setBounds(980, 680, 90, 90); contentPane.add(lbl30);
                                            lbl31 = new JLabel(""); lbl31.setBounds(980, 590, 90, 90); contentPane.add(lbl31);
                                            lbl32 = new JLabel(""); lbl32.setBounds(890, 590, 90, 90); contentPane.add(lbl32);
                                            lbl33 = new JLabel(""); lbl33.setBounds(800, 590, 90, 90); contentPane.add(lbl33);
                                            lbl34 = new JLabel(""); lbl34.setBounds(710, 590, 90, 90); contentPane.add(lbl34);
                                            lbl35 = new JLabel(""); lbl35.setBounds(620, 590, 90, 90); contentPane.add(lbl35);
                                            lbl36 = new JLabel(""); lbl36.setBounds(530, 590, 90, 90); contentPane.add(lbl36);
                                            lbl37 = new JLabel(""); lbl37.setBounds(440, 590, 90, 90); contentPane.add(lbl37);
                                            lbl38 = new JLabel(""); lbl38.setBounds(350, 590, 90, 90); contentPane.add(lbl38);
                                            lbl39 = new JLabel(""); lbl39.setBounds(260, 590, 90, 90); contentPane.add(lbl39);
                                            lbl40 = new JLabel(""); lbl40.setBounds(170, 590, 90, 90); contentPane.add(lbl40);
                                            lbl41 = new JLabel(""); lbl41.setBounds(170, 500, 90, 90); contentPane.add(lbl41);
                                            lbl42 = new JLabel(""); lbl42.setBounds(260, 500, 90, 90); contentPane.add(lbl42);
                                            lbl43 = new JLabel(""); lbl43.setBounds(350, 500, 90, 90); contentPane.add(lbl43);
                                            lbl44 = new JLabel(""); lbl44.setBounds(440, 500, 90, 90); contentPane.add(lbl44);
                                            lbl45 = new JLabel(""); lbl45.setBounds(530, 500, 90, 90); contentPane.add(lbl45);
                                            lbl46 = new JLabel(""); lbl46.setBounds(620, 500, 90, 90); contentPane.add(lbl46);
                                            lbl47 = new JLabel(""); lbl47.setBounds(710, 500, 90, 90); contentPane.add(lbl47);  
                                            lbl48 = new JLabel(""); lbl48.setBounds(800, 500, 90, 90); contentPane.add(lbl48);
                                            lbl49 = new JLabel(""); lbl49.setBounds(890, 500, 90, 90); contentPane.add(lbl49);
                                            lbl50 = new JLabel(""); lbl50.setBounds(980, 500, 90, 90); contentPane.add(lbl50);
                                            lbl51 = new JLabel(""); lbl51.setBounds(980, 410, 90, 90); contentPane.add(lbl51);
                                            lbl52 = new JLabel(""); lbl52.setBounds(890, 410, 90, 90); contentPane.add(lbl52);
                                            lbl53 = new JLabel(""); lbl53.setBounds(800, 410, 90, 90); contentPane.add(lbl53);
                                            lbl54 = new JLabel(""); lbl54.setBounds(710, 410, 90, 90); contentPane.add(lbl54);
                                            lbl55 = new JLabel(""); lbl55.setBounds(620, 410, 90, 90); contentPane.add(lbl55);
                                            lbl56 = new JLabel(""); lbl56.setBounds(530, 410, 90, 90); contentPane.add(lbl56);
                                            lbl57 = new JLabel(""); lbl57.setBounds(440, 410, 90, 90); contentPane.add(lbl57);
                                            lbl58 = new JLabel(""); lbl58.setBounds(350, 410, 90, 90); contentPane.add(lbl58);
                                            lbl59 = new JLabel(""); lbl59.setBounds(260, 410, 90, 90); contentPane.add(lbl59);
                                            lbl60 = new JLabel(""); lbl60.setBounds(170, 410, 90, 90); contentPane.add(lbl60);
                                            lbl61 = new JLabel(""); lbl61.setBounds(170, 320, 90, 90); contentPane.add(lbl61);
                                            lbl62 = new JLabel(""); lbl62.setBounds(260, 320, 90, 90); contentPane.add(lbl62);
                                            lbl63 = new JLabel(""); lbl63.setBounds(350, 320, 90, 90); contentPane.add(lbl63);
                                            lbl64 = new JLabel(""); lbl64.setBounds(440, 320, 90, 90); contentPane.add(lbl64);
                                            lbl65 = new JLabel(""); lbl65.setBounds(530, 320, 90, 90); contentPane.add(lbl65);
                                            lbl66 = new JLabel(""); lbl66.setBounds(620, 320, 90, 90); contentPane.add(lbl66);
                                            lbl67 = new JLabel(""); lbl67.setBounds(710, 320, 90, 90); contentPane.add(lbl67);
                                            lbl68 = new JLabel(""); lbl68.setBounds(800, 320, 90, 90); contentPane.add(lbl68);
                                            lbl69 = new JLabel(""); lbl69.setBounds(890, 320, 90, 90); contentPane.add(lbl69);
                                            lbl70 = new JLabel(""); lbl70.setBounds(980, 320, 90, 90); contentPane.add(lbl70);
                                            lbl71 = new JLabel(""); lbl71.setBounds(980, 230, 90, 90); contentPane.add(lbl71);
                                            lbl72 = new JLabel(""); lbl72.setBounds(890, 230, 90, 90); contentPane.add(lbl72);
                                            lbl73 = new JLabel(""); lbl73.setBounds(800, 230, 90, 90); contentPane.add(lbl73);
                                            lbl74 = new JLabel(""); lbl74.setBounds(710, 230, 90, 90); contentPane.add(lbl74);
                                            lbl75 = new JLabel(""); lbl75.setBounds(620, 230, 90, 90); contentPane.add(lbl75);
                                            lbl76 = new JLabel(""); lbl76.setBounds(530, 230, 90, 90); contentPane.add(lbl76);
                                            lbl77 = new JLabel(""); lbl77.setBounds(440, 230, 90, 90); contentPane.add(lbl77);
                                            lbl78 = new JLabel(""); lbl78.setBounds(350, 230, 90, 90); contentPane.add(lbl78);
                                            lbl79 = new JLabel(""); lbl79.setBounds(260, 230, 90, 90); contentPane.add(lbl79);
                                            lbl80 = new JLabel(""); lbl80.setBounds(170, 230, 90, 90); contentPane.add(lbl80);
                                            lbl81 = new JLabel(""); lbl81.setBounds(170, 140, 90, 90); contentPane.add(lbl81);
                                            lbl82 = new JLabel(""); lbl82.setBounds(260, 140, 90, 90); contentPane.add(lbl82);
                                            lbl83 = new JLabel(""); lbl83.setBounds(350, 140, 90, 90); contentPane.add(lbl83);
                                            lbl84 = new JLabel(""); lbl84.setBounds(440, 140, 90, 90); contentPane.add(lbl84);
                                            lbl85 = new JLabel(""); lbl85.setBounds(530, 140, 90, 90); contentPane.add(lbl85);
                                            lbl86 = new JLabel(""); lbl86.setBounds(620, 140, 90, 90); contentPane.add(lbl86);
                                            lbl87 = new JLabel(""); lbl87.setBounds(710, 140, 90, 90); contentPane.add(lbl87);
                                            lbl88 = new JLabel(""); lbl88.setBounds(800, 140, 90, 90); contentPane.add(lbl88);
                                            lbl89 = new JLabel(""); lbl89.setBounds(890, 140, 90, 90); contentPane.add(lbl89);
                                            lbl90 = new JLabel(""); lbl90.setBounds(980, 140, 90, 90); contentPane.add(lbl90);
                                            lbl91 = new JLabel(""); lbl91.setBounds(980, 50, 90, 90); contentPane.add(lbl91);
                                            lbl92 = new JLabel(""); lbl92.setBounds(890, 50, 90, 90); contentPane.add(lbl92);
                                            lbl93 = new JLabel(""); lbl93.setBounds(800, 50, 90, 90); contentPane.add(lbl93);
                                            lbl94 = new JLabel(""); lbl94.setBounds(710, 50, 90, 90); contentPane.add(lbl94);
                                            lbl95 = new JLabel(""); lbl95.setBounds(620, 50, 90, 90); contentPane.add(lbl95);
                                            lbl96 = new JLabel(""); lbl96.setBounds(530, 50, 90, 90); contentPane.add(lbl96);
                                            lbl97 = new JLabel(""); lbl97.setBounds(440, 50, 90, 90); contentPane.add(lbl97);
                                            lbl98 = new JLabel(""); lbl98.setBounds(350, 50, 90, 90); contentPane.add(lbl98);
                                            lbl99 = new JLabel(""); lbl99.setBounds(260, 50, 90, 90); contentPane.add(lbl99);
                                            lbl100 = new JLabel(""); lbl100.setBounds(170, 50, 90, 90); contentPane.add(lbl100);
                
		 lblPlayerName = new JLabel("Now will roll      . . .");
		 lblPlayerName.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		 lblPlayerName.setForeground(new Color(51, 204, 204));
		lblPlayerName.setBounds(1170, 77, 250, 50);
		contentPane.add(lblPlayerName);

		 btnDice = new JButton("Roll Dice");
		 btnDice.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		 btnDice.setForeground(new Color(255, 255, 255));
		 btnDice.setBackground(new Color(0, 0, 51));
                 
                 
                 //Board change korar jonno Dice Click er Random Value
                 
                                            Random board2Random = new Random();
		int diceClickBoard2 = (board2Random.nextInt(3)+1); 
                 
                                            Random board3Random = new Random();
		int diceClickBoard3 = (board2Random.nextInt(6)+4); 
                 
                                            Random board4Random = new Random();
		int diceClickBoard4 = (board2Random.nextInt(9)+7); 
                 
                                            Random board5Random = new Random();
		int diceClickBoard5 = (board2Random.nextInt(12)+10); 
                
                
                //Dice a click er Action Listener
                 
		 btnDice.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
                                             diceClick++;
                                             System.out.println(diceClick);
                     try {
                         Thread.sleep(900);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                     }
                                             
                                                 
                
                                             if(diceClick==diceClickBoard2){
                                                    lblBoard1.setVisible(false);
                                                 try {
                                                     Thread.sleep(1300);
                                                 } catch (InterruptedException ex) {
                                                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                                    lblBoard2.setVisible(true);
                                                    boardChange = 2;
                                                    System.out.println("Board is Changed!");
                                                    JOptionPane.showMessageDialog(null, "Board is Changed!");
                                                                             }
                                             
                                             if(diceClick==diceClickBoard3){
                                                    lblBoard2.setVisible(false);
                                                 try {
                                                     Thread.sleep(1300);
                                                 } catch (InterruptedException ex) {
                                                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                                    lblBoard3.setVisible(true);
                                                    boardChange = 3;
                                                    System.out.println("Board is Changed! ROCKET Board!");
                                                    JOptionPane.showMessageDialog(null, "Board is Changed! ROCKET Board!");
                                                                             }
                                             if(diceClick==diceClickBoard4){
                                                    lblBoard3.setVisible(false);
                                                 try {
                                                     Thread.sleep(1300);
                                                 } catch (InterruptedException ex) {
                                                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                                    lblBoard4.setVisible(true);
                                                    boardChange = 4;
                                                    System.out.println("Board is Changed! UFO Board!");
                                                    JOptionPane.showMessageDialog(null, "Board is Changed! UFO Board!");
                                                                             }
                                             
                                             if(diceClick==diceClickBoard5){
                                                    lblBoard4.setVisible(false);
                                                 try {
                                                     Thread.sleep(1300);
                                                 } catch (InterruptedException ex) {
                                                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                                    lblBoard5.setVisible(true);
                                                    boardChange = 5;
                                                    System.out.println("Board is Changed! Dragon Snake Board!");
                                                    JOptionPane.showMessageDialog(null, "Board is Changed! Dragon Snake Board!");
                                                                             }
                                                                                            
                                                                                        
		 		btnDice.setBackground(new Color(204, 0, 102));
		 		if(chokka==0){
		 		if(winingPosition==playerPos-1){
		 			int confirm = JOptionPane.showConfirmDialog(null, "Replay?", "", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION){
						dispose();
						Main frame = new Main();
						frame.setVisible(true);
					}
					else{
						setVisible(false); //No select korle frame unvisible hoye jabe
						dispose(); //Frame close hoye jabe
						
					}
		 		}
		 		
		 		//--------current player number show-------//
		 	
		 		if(player==playerPos)lblPlayer.setText(playerName[0]);
	
	 		else lblPlayer.setText(playerName[player]);
		 		
			 	//	if(player==playerPos)lblPlayer.setText(String.valueOf(1));
		 		//else lblPlayer.setText(String.valueOf(player+1));
			
				
				
		 		
		 		if(player==4){
		 			lblPlayer.setForeground(new Color(0, 204, 255)); //1
		 		}
		 		if(player==1){
		 			lblPlayer.setForeground(new Color(255, 204, 0)); //4
		 		}
		 		if(player==2){
		 			lblPlayer.setForeground(new Color(255, 51, 102)); //3
		 		}
		 		if(player==3){
		 			
		 			lblPlayer.setForeground(new Color(204, 51, 204)); //2
		 		}
		 		
		 		
		 		
		 		//---------------------------------------------//
		 		}
		 		
		 		Dice();                           //dice method call kortesi
		 		if(chokka==0)
		 		{
		 			player++;            //Ekjon dice click korlo... then arekjon dice click korbe, tai player count bariye  dicchi
		 		    if(player==playerPos+1)player=1;

		 		    while(playerposition[player-1]>=100){
		 		    	
		 		    	if(player==playerPos)lblPlayer.setText(playerName[0]);
		 			 		else lblPlayer.setText(playerName[player]);
		 		    	
		 		    	player++;            //Ekjon dice click korlo... then arekjon dice click korbe, tai player count bariye  dicchi
			 		    if(player==playerPos+1)player=1; 
		 		    }
		 		}// karon amr game e 4 jon player
		 		
		 		

		 	}
		 });
		 btnDice.setBackground(new Color(0, 0, 51));
		btnDice.setBounds(1265, 190, 210, 65);
		contentPane.add(btnDice);


		//nicher ongshotukur kaj enter button chaplei jate  button kaj kore taai..
		contentPane.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "EXIT");
                contentPane.getRootPane().getActionMap().put("EXIT", new AbstractAction(){
                public void actionPerformed(ActionEvent e)
                	{
                		btnDice.doClick();
                	}
                });


		lblP1 = new JLabel("Player1-");
		lblP1.setForeground(new Color(0, 204, 255));
		lblP1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblP1.setBounds(1190, 460, 200, 50);
		contentPane.add(lblP1);

		lblDimage = new JLabel(".");
		lblDimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimage.setBounds(1310, 290, 132, 129);
		contentPane.add(lblDimage);

        p1score = new JLabel("Score");
        p1score.setHorizontalAlignment(SwingConstants.LEFT);
        p1score.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        p1score.setForeground(new Color(255, 255, 255));
        p1score.setBounds(1455, 460, 120, 50);
        contentPane.add(p1score);

        lblP2 = new JLabel("Player2-");
        lblP2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblP2.setForeground(new Color(255, 204, 0));
        lblP2.setBounds(1190, 550, 200, 50);
        contentPane.add(lblP2);

        p2score = new JLabel("Score");
        p2score.setHorizontalAlignment(SwingConstants.LEFT);
        p2score.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        p2score.setForeground(new Color(255, 255, 255));
        p2score.setBounds(1455, 550, 120, 50);
        contentPane.add(p2score);
        
        
        //Main Board 1
        lblBoard1.setBounds(150, 50, 900, 900);
        lblBoard1.setIcon(new ImageIcon(Main.class.getResource("/Image/Board 1.png")));
        contentPane.add(lblBoard1);
        
        //Main Board 2
         lblBoard2.setIcon(new ImageIcon(Main.class.getResource("/Image/Board 2.png")));
         lblBoard2.setBounds(150, 50, 900, 900);
         contentPane.add(lblBoard2);
         lblBoard2.setVisible(false);
         
        //Main Board 3
         lblBoard3.setIcon(new ImageIcon(Main.class.getResource("/Image/Board 3.png")));
         lblBoard3.setBounds(150, 50, 900, 900);
         contentPane.add(lblBoard3);
         lblBoard3.setVisible(false);
         
        //Main Board 4
         lblBoard4.setIcon(new ImageIcon(Main.class.getResource("/Image/Board 4.png")));
         lblBoard4.setBounds(150, 50, 900, 900);
         contentPane.add(lblBoard4);
         lblBoard4.setVisible(false);
         
        //Main Board 5
         lblBoard5.setIcon(new ImageIcon(Main.class.getResource("/Image/Board 5.png")));
         lblBoard5.setBounds(150, 50, 900, 900);
         contentPane.add(lblBoard5);
         lblBoard5.setVisible(false);

        
        lblP3 = new JLabel("Player3-");
        lblP3.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblP3.setForeground(new Color(255, 51, 102));
        lblP3.setBounds(1190, 640, 200, 50);
        contentPane.add(lblP3);

        p3score = new JLabel("Score");
        p3score.setHorizontalAlignment(SwingConstants.LEFT);
        p3score.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        p3score.setForeground(new Color(255, 255, 255));
        p3score.setBounds(1455, 640, 120, 50);
        contentPane.add(p3score);

        lblP4 = new JLabel("Player4-");
        lblP4.setForeground(new Color(204, 51, 204));
        lblP4.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblP4.setBounds(1190, 730, 200, 50);
        contentPane.add(lblP4);

        p4score = new JLabel("Score");
        p4score.setHorizontalAlignment(SwingConstants.LEFT);
        p4score.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        p4score.setForeground(new Color(255, 255, 255));
        p4score.setBounds(1455, 730, 120, 50);
        contentPane.add(p4score);

        lblPlayer = new JLabel("");
        lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
        lblPlayer.setForeground(new Color(255, 0, 0));
        lblPlayer.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
        lblPlayer.setBounds(1490, 77, 250, 50);
        contentPane.add(lblPlayer);

        p1btn = new JLabel("");
        p1btn.setIcon(new ImageIcon(Main.class.getResource("/Image/player 1.png")));
        p1btn.setBounds(1630, 460, 60, 60);
        contentPane.add(p1btn);

        label = new JLabel("");
        label.setIcon(new ImageIcon(Main.class.getResource("/Image/player 2.png")));
        label.setBounds(1630, 550, 60, 60);
        contentPane.add(label);

        label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(Main.class.getResource("/Image/player 3.png")));
        label_1.setBounds(1630, 640, 60, 60);
        contentPane.add(label_1);

        label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon(Main.class.getResource("/Image/player 4.png")));
        label_2.setBounds(1630, 730, 60, 60);
        contentPane.add(label_2);


        JTextArea  infoArea = new JTextArea();
        

        btnRestart = new JButton("Restart Game");
        btnRestart.setBackground( Color.decode("#a31f53"));
        btnRestart.setForeground( Color.WHITE);
        btnRestart.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnRestart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Restart?", "Restart!", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION){
					dispose();
					Main frame = new Main();
					frame.setVisible(true);
				}
        	}
        });
        btnRestart.setBounds(1125, 887, 230, 60);
        contentPane.add(btnRestart);
       
        
        btnRules = new JButton("Rules");
        btnRules.setBackground(new Color(70, 14, 94));
       btnRules .setForeground( Color.WHITE);
        btnRules.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnRules.setBounds(1395, 887, 110, 60);
        contentPane.add(btnRules);
        btnRules.addActionListener(new ActionListener() {
            
                    
                    public void actionPerformed(ActionEvent e) {
                        
                        
                        Ludu_Rules x = new Ludu_Rules();
                        
                    }
                });
        
        
        btnAbout = new JButton("About");
        btnAbout.setBackground(new Color(29, 84, 68
        ));
        btnAbout.setForeground( Color.WHITE);
        btnAbout.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnAbout.setBounds(1545, 887, 110, 60);
        contentPane.add(btnAbout);
        btnAbout.addActionListener(new ActionListener() {
                   
                    public void actionPerformed(ActionEvent e) {
                           About x = new About();
                    }
                });
        
        
        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnExit.setBounds(1695, 887, 150, 60);
        contentPane.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                        throw new UnsupportedOperationException("Not supported yet."); 
                    }
                });
        
      // if(player==1) lblPlayer.setForeground(new Color(0, 204, 255)); 
        //if(player==2)lblPlayer.setForeground(new Color(255, 204, 0)); 
        inputName();     //name input deya hocche ei method e
        lblPlayer.setText(playerName[0]);  //initially playing player er nam hocche 1st player

        for(int i=0;i<playerPos;i++){
        	playerposition[i]=0;
        }
	}

	
	public void inputName(){
		
	     // Initialize variables

     	playerName = new String[playerPos];
     	
     		for(int i=0; i<playerPos; i++){

     			playerName[i] = "Player "+String.valueOf(i+1);

     		}

     // Input Names
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to skip names?", "Name", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.NO_OPTION){
                for(int i=0; i<playerPos; i++){
     	try{
                           playerName[i] = JOptionPane.showInputDialog("Enter Name of Player "+ String.valueOf(i+1)+" :");
                           JOptionPane.showMessageDialog(null, playerName[i]);
                           } catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Invalid name");
                                playerName[i] = "Player "+ String.valueOf(i+1);
                                                              }
                                        }
     	}
     	
     		if(playerPos == 2){
     			// = Integer.parseInt(JOptionPane.showInputDialog("Enter No of players"));
     			lblP1.setText(playerName[0]);
     			lblP2.setText(playerName[1]);
     			
     			label_1.setVisible(false);
     			lblP3.setVisible(false);
     			p3score.setVisible(false);
     			
     			label_2.setVisible(false);
     			lblP4.setVisible(false);
     			p4score.setVisible(false);
     			
     		}
     		else if(playerPos == 3){
     			lblP1.setText(playerName[0]);
     			lblP2.setText(playerName[1]);
     			lblP3.setText(playerName[2]);
     			
     			label_2.setVisible(false);
     			lblP4.setVisible(false);
     			p4score.setVisible(false);
     			
     		}
     		else if(playerPos == 4){
     			lblP1.setText(playerName[0]);
     			lblP2.setText(playerName[1]);
     			lblP3.setText(playerName[2]);
     			lblP4.setText(playerName[3]);
     			

     		}
		
	}

}

