import java.util.Random;
public class World{
	private int population,food,blessings,metal,lumber, popROC;
	private Random random = new Random();
	
	public World(){
		population = 2;
		food = 100;
		blessings = 50;
		metal = 100;
		lumber = 100;

	}
	
	
	//----------- Getters and Setters ----------//
	public int getPopulation(){
		return population;
	}
	public void setPopulation(int amount){
		population = amount;
	}
	public int getFood(){
		return food;
	}
	public void setFood(int amount){
		food += amount;
	}
	public int getLumber(){
		return lumber;
	}
	public void setLumber(int amount){
		lumber += amount;
	}
	public int getMetal(){
		return metal;
	}
	public void setMetal(int amount){
		metal += amount;
	}
	public int getBlessings(){
		return blessings;
	}
	public int setBlessings(int amount){
		return blessings;
	}
	//----------- Getters and Setters ----------//

	public void roll(){
			
	}
	
	public void collectTax(){
		//run after a set amount of time
		//takes out 25% of lumber and food
		this.metal *= 0.75;
		this.food *= 0.75;
	}
	
	public void calcResources(){
		popROC = this.food - this.population; // rate of change is dependent of food availability;
		this.population += popROC;
		
	}
}