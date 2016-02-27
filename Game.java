/**
 * @(#)Game.java
 *
 *
 * @author 
 * @version 1.00 2016/2/18
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.MouseInfo;
import java.util.ArrayList;

public class Game extends JFrame implements ActionListener{
	public Timer myTimer;
	GamePanel game;
		
    public Game() {
		super("Multiply");
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
		Game frame = new Game();		
    }
}
//AudioClip backSound;
//	
//    public Tron(){
//    	super("Tron Lightcycle");
//    	frameSetup();
//    	menu = new MenuPanel(this,"Menu.jpg");
//    	backSound = Applet.newAudioClip(getClass().getResource("Tron Music.wav"));
//    	backSound.loop();
class GamePanel extends JPanel implements MouseMotionListener, MouseListener, KeyListener{
	private boolean []keys;
	private Image islandImg;
	private Font font = new Font("Helvetica", Font.BOLD, 20);
	private Font font2 = new Font("Cooper Black", Font.BOLD, 20);
	private Game mainFrame;
	private int mousex,mousey;
	private World world;
	private boolean mousedown;
	private Building selectedBuild=null;
	private ArrayList<Particle> particles = new ArrayList<Particle>();
	public GamePanel(Game m){
		world=new World();
		addMouseMotionListener(this);
		addMouseListener(this);
		keys = new boolean[KeyEvent.KEY_LAST+1];
		islandImg = new ImageIcon("island.jpg").getImage();
		mainFrame = m;
		setSize(1024,720);
        addKeyListener(this);
	}
    public void addNotify() {
        super.addNotify();
        requestFocus();
        mainFrame.start();
    }
	
	
	
	
	public void move(){
		for (Particle particle:particles){
			particle.move();
		}
	}
	
	
	
	
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_N && keys[KeyEvent.VK_N]!=true){
    		world.calcResources();
			world.updatePop();	
			world.action();
    	}
    	else if(keys[KeyEvent.VK_ENTER]!=true&&selectedBuild!=null){
    		selectedBuild.built=true;
    	}
        keys[e.getKeyCode()] = true;
    }
    
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
    
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}    
    public void mouseClicked(MouseEvent e){}  
    	 
    public void mousePressed(MouseEvent e){	
		System.out.println(" "+mousex+" "+mousey);
		mousedown=true;
	}
    
    
    public void mouseDragged(MouseEvent e){
    	mousex = e.getX();
		mousey = e.getY();
		}
    public void mouseMoved(MouseEvent e){
    	mousex = e.getX();
		mousey = e.getY();
		}
    
    
    public void paintComponent(Graphics g){
		g.setColor(Color.white);  	
		g.fillRect(0,0,1024,720);//}
		g.setColor(Color.green);  
		g.drawImage(islandImg,-400,-100,this);

		//g.fillRect((int)proj.x, (int)proj.y, 20, 20);
		//g.drawOval(100-20, 100-20, 2*20, 2*20);
		//g.drawOval((int)proj.x-20, (int)proj.y-20, 2*20, 2*20);
		for (Particle particle:particles){
			g.drawOval(particle.x-20,particle.y-20,2*20,2*20);
		}
		
		for (Building building:world.buildings){
			if (building.built==false){
				if (pointrectcollide(mousex,mousey,building.x, building.y,100,100)){
					g.setColor(new Color(255, 255, 255, 120));
					g.fillRect(mousex, mousey, 200, 100);
					g.setColor(new Color(0,0,0));
					g.drawRect(mousex, mousey, 200, 100);
					if (mousedown){
						selectedBuild=building;
					}
					g.setColor(new Color(255, 255, 255, 50));
				}
				
				else{
				g.setColor(new Color(255, 255, 255, 100));}
				g.fillRect(building.x, building.y, 100, 100);
				
			}
			else{ //buildings already made
				g.drawImage(building.image,building.x, building.y,this);
				
			}
			
			
		}
		if(selectedBuild!=null){	
			
			g.setColor(new Color(255,255,255));
			g.fillRect(0,600,1024, 200);
   			g.setFont(font);
			g.setColor(new Color(0,0,0));
			g.drawString("Are you sure you want to build a " +selectedBuild.type.toUpperCase()+" (PRESS ENTER TO ACCEPT).",0,650);
		}
		g.setColor(Color.white);
		g.setFont(font2);
		g.drawString("Population: "+ world.population,20,20);
		
		g.drawString("Food: "+ world.food,20,40);
		
		g.drawString("Metal: "+ world.metal,20,60);
		
		g.drawString("Blessings: "+ world.blessings,20,80);
		
   			
		
		mousedown=false;
		
    }
    public boolean pointrectcollide(int x,int y,int rectx,int recty,int w,int h){
   		return (x>rectx&&y>recty&&x<rectx+w&&y<recty+h);
   	}
   	public boolean rectcollide(int rect1x,int rect1y,int w1,int h1,int rect2x,int rect2y,int w2,int h2){
   		Rectangle r1 = new Rectangle (rect1x, rect1y, w1, h1);
   		Rectangle r2 = new Rectangle (rect2x, rect2y, w2, h2);
   		return r1.intersects(r2);
   	}
}