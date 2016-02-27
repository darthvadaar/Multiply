//Building class

public class Building{
	private String type;
	private int population;
	
	public Building(String type, int population, World world){
		this.type = type;
		this.population = population;
		
	}
	
	public String getType(){return this.type;}
	public void addTo(int n){
		//adds the n amounts of residents to this building
		this.population += n;
	}
	
	public void action(){
		if (this.type.equals("temple")){
			world.blessing += 1;
		}
		else if (this.type.equals("farm")){
			world.food += 1;
		}
		else if (this.type.equals("mine")){
			world.metal += 1;
		}
		else if (this.type.equals("house")){
			world.population += 1;
		}
	}
	
	
	
}