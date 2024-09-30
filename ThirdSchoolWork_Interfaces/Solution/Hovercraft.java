public class Hovercraft implements SeaVessel, LandVehicle {

	private int passenger;
	private String name;
	private int speed;
	private int numOfWheels;




	private int X = 0;
	private int Y = 0;
	public Hovercraft(int passenger, String name, int speed, int numOfWheels) {
		this.passenger = passenger;
		this.name = name;
		this.speed = speed;
		this.numOfWheels = numOfWheels;
	}

	public String getDetails(){
		return("HoverCraft Info:\n-Name: "+name+"\n-Max Speed: "+speed+"\n-Max Passengers: "+passenger+"\n-Number Of Wheels: "+numOfWheels);
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

	public int getNumOfWheels() {
		return getNumOfWheels();
	}


	public void drive() {
		// TODO Auto-generated method stub
		System.out.println(name+"Has started driving!");
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
