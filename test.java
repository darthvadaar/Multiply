public class test{
	public static void main(String[]args){
		World w = new World();
		System.out.printf("%d, %d\n", w.getPopulation(), w.getFood());
		for (int i = 0; i < 100; i++){
			w.calcResources();
			System.out.printf("%d, %d\n", w.getPopulation(), w.getFood());	
		}
		
	}
}