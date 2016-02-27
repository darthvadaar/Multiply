//Building class handles each building
import java.awt.*;
import javax.swing.*;

public class Building{
	public String type;
	public boolean built;
	public int population, x, y, cost;
	public World world;
	public Image image;
	
	public Building(String type, int x, int y, int population, int cost){
		this.type = type;
		this.x = x;
		this.y = y;
		this.population = population;
		this.cost = cost;
		if (type.equals("house") || type.equals("idle")){
			this.built = true;	
		}
		else{
			this.built = false;	
		}
		
		if (type.equals("temple")){
			image = new ImageIcon("temple.png").getImage();
		}
		else if (type.equals("mine")){
			image = new ImageIcon("mine.png").getImage();			
		}
		else if(type.equals("farm")){
			image = new ImageIcon("farm.gif").getImage();
		}
		else if(type.equals("house")){
			image = new ImageIcon("house.png").getImage();
		}
		
	}
	
	public String getType(){return this.type;}
	public int getPopulation(){return this.population;}
	public void addTo(int n){
		//adds the n amounts of residents to this building
		this.population += n;
	}
	
	public void killHalf(){
		this.population /= 2;
	}
	
	
	
}