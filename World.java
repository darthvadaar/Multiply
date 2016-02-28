import java.util.*;
import java.applet.*;
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
	public int getMetal(){
		return metal;
	}
	public int getBlessings(){
		return blessings;
	}
	public int setBlessings(int amount){
		return blessings;
	}
	public void createBuildings(){
		buildings.add(new Building("house", 300, 225, population, 0));
		buildings.add(new Building("temple", 100, 100, 0, 20));
		buildings.add(new Building("mine", 500, 100,0, 15));
		buildings.add(new Building("farm", 300, 10,0, 100));
		buildings.add(new Building("idle", 500, 415,0, 0));
	}
	//----------- Getters and Setters ----------//

	public void roll(){
		int chance = random.nextInt(blessings);
		if (chance < 20){
			for (Building b : buildings){
				b.killHalf();
			}
			AudioClip scream= Applet.newAudioClip(getClass().getResource("scream.wav"));
    		scream.play();
    		System.out.println("DEATH");
		}
		else if(chance > 50){
			//BLESSED
			
			AudioClip blessed= Applet.newAudioClip(getClass().getResource("blessed.wav"));
    		blessed.play();
			metal *= 1.5;
			food *= 1.5;
		}
	}
	
	public void endDay(){
		if (day % 7 == 0 && day != 0 ){
			collectTax();
			//put a prompt saying tax has been collected
		}
		if (day % 10 == 0 && day != 0){
			roll();			
		}
		calcResources();
		action();
		day += 1;
	}
	
	public void collectTax(){
		//run after a set amount of time
		//takes out 25% of lumber and food
		AudioClip chaching= Applet.newAudioClip(getClass().getResource("chaching.wav"));
    	chaching.play();
		this.metal *= 0.75;
		this.food *= 0.75;
	}
	
	public void calcResources(){
		//calculates food and population calculations
		if (population <= 0){
			System.out.println("GAME OVER!");
			System.exit(0);
		}
		food -= population;
		if (food > population){
			buildings.get(4).population += buildings.get(0).getPopulation()/2;
		}
		else{
			for (Building b : buildings){
				if (b.population > 0){
					b.population -= 1;		
				}
					
			}
		}
		
		food += buildings.get(3).population;
		if (food < 0){
			food = 0;
		}

	}
	
	public void updatePop(){
		int tot = 0;
		for (Building b : buildings){
			tot += b.population;		
		}
		population = tot;
		if (population < 0){
			System.exit(0);
		}
	}
	
	public void action(){
		//carries out the actions of each building
		for (Building b : buildings){
			if (b.getType().equals("temple") && b.built){
				if (b.population > population/3){	//1/3 of population must be priests for blessing to go up
					blessings += b.population;	
				}
				else{
					blessings -= 1;	
				}
			}
			else if (b.getType().equals("farm") && b.built){
				food += b.population;
			}
			else if (b.getType().equals("mine") && b.built){
				metal += b.population;
			}
			else if (b.getType().equals("house") && b.built){
				population += b.population;
			}
		}
	}






}