import java.util.*;
public class World{
	public int population,food,blessings,metal,lumber, popROC;
	public ArrayList<Building> buildings = new ArrayList<Building>();
	public Random random = new Random();
	
	public World(){
		population = 2;
		food = 100;
		blessings = 50;
		metal = 100;
		lumber = 100;
		createBuildings();

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
		int chance = random.nextInt(blessings);
		if (chance < 20){
			population /= 2;
		}
		else if(chance > 50){
			metal *= 1.5;
			food *= 1.5;
		}
	}
	
	public void createBuildings(){
		buildings.add(new Building("house", 100,500, population));
		buildings.add(new Building("temple", 100,100, 0));
		buildings.add(new Building("mine",500,100,0));
	}
	
	public void collectTax(){
		//run after a set amount of time
		//takes out 25% of lumber and food
		this.metal *= 0.75;
		this.food *= 0.75;
	}
	
	public void calcResources(){
		food -= population;
		if (food > 0){
			population += buildings.get(0).getPopulation()/2;
		}
		else{
			population -= 1;
		}
		if (population < 0){
			System.out.println("GAME OVER!");
			//END GAME HERE!
		}
	}
	
	public void action(){
		for (Building b : buildings){
			if (b.getType().equals("temple")){
				blessings += 1;
			}
			else if (b.getType().equals("farm")){
				food += 1;
			}
			else if (b.getType().equals("mine")){
				metal += 1;
			}
			else if (b.getType().equals("house")){
				population += 1;
			}
		}
		
	}
}