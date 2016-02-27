//Building class handles each building

public class Building{
	public String type;
	public boolean built;
	public int population, x, y;
	public World world;
	
	public Building(String type, int x, int y, int population){
		this.type = type;
		this.x = x;
		this.y = y;
		this.population = population;
		this.built = false;
		
	}
	
	public String getType(){return this.type;}
	public int getPopulation(){return this.population;}
	public void addTo(int n){
		//adds the n amounts of residents to this building
		this.population += n;
	}
	
	
	
}