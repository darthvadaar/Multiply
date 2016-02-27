//Building class handles each building

public class Building{
	private String type;
	private int population, x, y;
	private World world;
	
	public Building(String type, int x, int y, int population, World world){
		this.type = type;
		this.x = x;
		this.y = y;
		this.population = population;
		
	}
	
	public String getType(){return this.type;}
	public void addTo(int n){
		//adds the n amounts of residents to this building
		this.population += n;
	}
	
	public void action(){
		if (this.type.equals("temple")){
			world.setBlessings(world.getBlessings() + 1);
		}
		else if (this.type.equals("farm")){
			world.setFood(world.getFood() + 1);
		}
		else if (this.type.equals("mine")){
			world.setMetal(world.getMetal() + 1);
		}
		else if (this.type.equals("house")){
			world.setPopulation(world.getPopulation() + 1);
		}
	}
	
	
	
}