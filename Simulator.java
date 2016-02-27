/**
 * @(#)Simulator.java
 *
 *
 * @author 
 * @version 1.00 2016/2/18
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.MouseInfo;

public class Simulator extends JFrame implements ActionListener{
	public Timer myTimer;   
	GamePanel game;
		
    public Simulator() {
		super("Arrow shooting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,720);

		myTimer = new Timer(10, this);	 // trigger every 10 ms
		

		game = new GamePanel(this);
		add(game);

		setResizable(false);
		setVisible(true);
    }
	
	public void start(){
		myTimer.start();
	}

	public void actionPerformed(ActionEvent evt){
		game.move();
		game.repaint();
	}

    public static void main(String[] arguments) {
		Simulator frame = new Simulator();		
    }
}

class GamePanel extends JPanel implements KeyListener{
	private boolean []keys;
	private Image monkeyImg;
	private Projectile proj; 
	private Monkey monkey;
	private boolean launched=false;
	private boolean spaceflag=false;
	private Simulator mainFrame;
	private float theta;
	private float v1=6;
	
	public GamePanel(Simulator m){
		keys = new boolean[KeyEvent.KEY_LAST+1];
		monkeyImg = new ImageIcon("monkey.gif").getImage();
		mainFrame = m;
		monkey = new Monkey (700,0,0,0);
	    proj = new Projectile (0,300,0,0);
	    theta=-1*(float)Math.atan2((monkey.y-proj.y),(monkey.x-proj.x));
		System.out.println(theta);
		setSize(1024,720);
        addKeyListener(this);
	    v1=Integer.parseInt(JOptionPane.showInputDialog("Velocity:"));
	}
	
    public void addNotify() {
        super.addNotify();
        requestFocus();
        mainFrame.start();
    }
	
	public void move(){
		if(keys[KeyEvent.VK_ESCAPE]&&launched){
			launched=false;
			monkey = new Monkey (700,0,0,0);
	    	proj = new Projectile (0,300,0,0);
	    	v1=Integer.parseInt(JOptionPane.showInputDialog("Velocity:"));
			keys[KeyEvent.VK_ESCAPE]=false;
		}
		if(keys[KeyEvent.VK_RIGHT]&&!launched ){
			proj.x += 5;
	    	theta=-1*(float)Math.atan2((monkey.y-proj.y),(monkey.x-proj.x));
			System.out.println(theta/3.14*180);
		}
		if(keys[KeyEvent.VK_LEFT]&&!launched ){
			proj.x -= 5;
	    	theta=-1*(float)Math.atan2((monkey.y-proj.y),(monkey.x-proj.x));
		//	System.out.println(theta/3.14*180);
		}
		if( keys[KeyEvent.VK_SPACE]&&!launched ){
			proj.vx=v1*(float)Math.cos(theta);
			proj.vy=-v1*(float)Math.sin(theta);
			//System.out.println("x:"+proj.vx+"y:"+proj.vy);
			launched=true;
			mainFrame.myTimer.setDelay(10);
		}
		//System.out.println(""+proj.x);
		if (launched){
			proj.move();
			monkey.move();	
		}
		
	}
	
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
    public void paintComponent(Graphics g){
		g.setColor(Color.white);  	
		g.fillRect(0,0,1024,720);//}
		g.setColor(Color.blue);  
		//g.fillRect((int)monkey.x, (int)monkey.y, 20, 20);
		//g.fillRect((int)proj.x, (int)proj.y, 20, 20);
		g.drawOval((int)monkey.x-20, (int)monkey.y-20, 2*20, 2*20);
		g.drawOval((int)proj.x-20, (int)proj.y-20, 2*20, 2*20);
		//g.drawImage(monkeyImg,(int)monkey.x-32,(int)monkey.y-32,this);
    	if (!launched){
	    	   g.drawLine((int)proj.x, (int)proj.y, (int)monkey.x, (int)monkey.y);
    	}
    }
}