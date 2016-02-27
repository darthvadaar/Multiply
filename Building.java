//Building class handles each building
import java.awt.*;
import javax.swing.*;

public class Building{
	public String type;
	public boolean built;
	public int population, x, y;
	public World world;
	public Image image;
	
	public Building(String type, int x, int y, int population){
		this.type = type;
		this.x = x;
		this.y = y;
		this.population = population;
		if (type.equals("house")){
			this.built = true;	
		}
		else{
			this.built = false;	
		}
		
		if (type.equals("temple")){
			image = new ImageIcon("temple.png").getImage();			
		}
		else if (type.equals("cave")){
			image = new ImageIcon("mine.png").getImage();			
		}
		else if(type.equals("farm")){
			image = new ImageIcon("farm.gif").getImage();
		}
		else if(type.equals("house")){
			image = new ImageIcon("house.jpeg").getImage();
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