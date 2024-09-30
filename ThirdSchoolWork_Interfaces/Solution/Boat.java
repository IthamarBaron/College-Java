public class Boat implements SeaVessel {

	private int passenger;
	private String name;
	private int speed;
	private int X = 0;
	private int Y = 0;
	public Boat(int passenger, String name, int speed) {
		this.passenger = passenger;
		this.name = name;
		this.speed = speed;
	}

	public String getDetails(){
		return("Boat Info:\n-Name: "+name+"\n-Max Speed: "+speed+"\n-Max Passengers: "+passenger);
	}

	public int getMaxPassengers() {
		return passenger;
	}

	public String getName() {
		return name;
	}

	public int getMaxSpeed() {
		return speed;
	}

	public void launch() {
		System.out.println(name+"Has been lunched!");

	}
	public void move(int x, int y){
		this.X = x;
		this.Y = y;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

}
