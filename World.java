import java.util.Random;
public class World{
	private int population,food,blessings,metal,lumber;
	private Random random = new Random();
	public World{
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
		population += amount;
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
	public void setBlessings(int amount){
		return blessings;
	}
	//----------- Getters and Setters ----------//

	public void roll(){
			
	}
}