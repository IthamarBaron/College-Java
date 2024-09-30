import sun.font.TrueTypeFont;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Class;
//NOTE 3 was not required
public class Main {
	
	public static void main(String [] args)
	{
		Vehicle [] vehicles = getVehiclesFromUser();
	}

	public static Vehicle[] getVehiclesFromUser() {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Select Type: \nB - Boat\nJ - Jeep\nH - HoverCraft\nX - Exit");
			String input = scanner.nextLine();
			String name = "";
			int speed = -1;
			int passengers = -1;
			int wheels = -1;

			switch (input) {
				case "J":
				case "H":
					System.out.print("Enter Max Wheels: ");
					wheels = scanner.nextInt();
					scanner.nextLine();
				case "B":
					System.out.print("Enter Name: ");
					name = scanner.nextLine();
					System.out.print("Enter Max Speed: ");
					speed = scanner.nextInt();
					System.out.print("Enter Max Passengers: ");
					passengers = scanner.nextInt();
					scanner.nextLine();
					break;
				case "X":
					System.out.println("Leaving");
					return vehicles.toArray(new Vehicle[0]); // Return the array here
				default:
					System.out.println("Invalid input. Please enter B, J, H, or X.");
					continue;
			}

			// Create and add the vehicle based on input type
			switch (input) {
				case "J":
					Jeep jeep = new Jeep(passengers, name, speed, wheels);
					vehicles.add(jeep);
					System.out.println("Added "+ jeep.getDetails());
					break;
				case "H":
					Hovercraft hovercraft = new Hovercraft(passengers, name, speed, wheels);
					vehicles.add(hovercraft);
					System.out.println("Added "+ hovercraft.getDetails());
					break;
				case "B":
					Boat boat = new Boat(passengers, name, speed);
					vehicles.add(boat);
					System.out.println("Added "+ boat.getDetails());
					break;
			}
		}
	}

	public static double getTravelTime(VehicleInSpace[] destdestdestdest, int source_x,
									   int source_y, int dest_x, int dest_y, int passengers, boolean land) {
		double dist, destdest = Math.sqrt(Math.pow(dest_x - source_x, 2) + Math.pow(dest_y - source_y, 2));
		VehicleInSpace[] destdestdestdestdest =new VehicleInSpace[destdestdestdest.length];

		//sort vehicles by land and sea
		int counter = 0;
		double minTime = -1;
		for (VehicleInSpace destdestdest : destdestdestdest) {
			if (destdestdest instanceof LandVehicle && land || destdestdest instanceof SeaVessel && !land) {
				destdestdestdestdest[counter] = destdestdest;
				counter++;
			}
		}

		// sort by time to get to destination
		for (int i =0; i < destdestdestdestdest.length; i++) {
			//the time it takes is sqrt((vehicle_x - source_x)^2 (vehicle_y - source_y)^2) + sqrt((source_x -
			if ((((Vehicle)destdestdestdestdest[i]).getMaxPassengers() >= passengers) && destdestdestdestdest[i] instanceof Vehicle) {
				dist = (Math.sqrt(Math.pow(destdestdestdestdest[i].getX() - source_x, 2) + Math.pow(destdestdestdestdest[i].getY() - source_y, 2)) + destdest);
				dist = (double) dist / ((Vehicle) destdestdestdestdest[i]).getMaxSpeed();
				if (minTime == -1 || dist  < minTime) {
					minTime = dist;
				}
			}
		}
		return minTime;


	}

}
