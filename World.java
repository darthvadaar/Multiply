import java.util.*;
public class World{
	public int population,food,blessings, metal, day;
	public ArrayList<Building> buildings = new ArrayList<Building>();
	public Random random = new Random();
	
	public World(){
		population = 2;
		food = 100;
		blessings = 50;
		metal = 100;
		createBuildings();
		day = 0;

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
	public void createBuildings(){
		buildings.add(new Building("house", 300, 225, population));
		buildings.add(new Building("temple", 100, 100, 0));
		buildings.add(new Building("mine", 500, 100,0));
		buildings.add(new Building("idle", 500, 415,0));
	}
	//----------- Getters and Setters ----------//

	public void roll(){
		int chance = random.nextInt(blessings);
		if (chance < 20){
			for (Building b : buildings){
				b.killHalf();
			}
		}
		else if(chance > 50){
			metal *= 1.5;
			food *= 1.5;
		}
	}
	
	public void endDay(){
		day += 1;
		if (day % 10 == 0 ){
			collectTax();
			//put a prompt saying tax has been collected
		}
		if (day % 15 == 0){
			roll();			
		}
		calcResources();
	}
	
	public void collectTax(){
		//run after a set amount of time
		//takes out 25% of lumber and food
		this.metal *= 0.75;
		this.food *= 0.75;
	}
	
	public void calcResources(){
		//calculates food and population calculations
		food -= population;
		if (food > population){
			buildings.get(3).population += buildings.get(0).getPopulation()/2;
		}
		else{
			for (Building b : buildings){
				b.population -= 1;		
			}
			if (food < 0){
				food = 0;
			}
		}
		if (population < 0){
			System.out.println("GAME OVER!");
			System.exit(0);
		}
	}
	
	public void updatePop(){
		int tot = 0;
		for (Building b : buildings){
			tot += b.population; 			
		}
		population = tot;
		
		if (buildings.get(3).getPopulation() <= 0){
			
		}
	}
	
	public void action(){
		//carries out the actions of each building
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