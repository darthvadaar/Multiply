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
		int chance = random.nextInt(blessings);
		if (chance < 20){
			population /= 2;
		}
		else if(chance > 50){
			metal *= 1.5;
			food *= 1.5;
		}
	}
	
	public void collectTax(){
		//run after a set amount of time
		//takes out 25% of lumber and food
		this.metal *= 0.75;
		this.food *= 0.75;
	}
	
	public void calcResources(){
		this.food -= this.population;
		if (food < 0){
			food = -1;
			
		}
		popROC = this.food/this.population; // rate of change is dependent of food availability;
		this.population += popROC;
		if (this.population < 0){
			System.out.println("GAME OVER!");
			//END GAME HERE!
			
		}
		
	}
}