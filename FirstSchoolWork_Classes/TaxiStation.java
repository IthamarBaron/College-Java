package FirstSchoolWork_Classes;

// Class names should be in PascalCase
public class TaxiStation {
    private String stationName;
    private Taxi[] taxiList = new Taxi[80];
    private int counter = 0;

    public TaxiStation(String stationName) {
        this.stationName = stationName;
    }

    // Method to add a taxi to the station
    public void addToStation(String name, String txId, int numPass) {
        if (counter >= 80)
        {
            System.out.println("No more taxis can be added. Station is full.");
            return;
        }
        taxiList[counter] = new Taxi(txId, name, numPass);
        counter++;
        taxiList[counter - 1].setTaxiNum(counter); // Corrected placement of counter
    }

    // Method to find an available taxi by the number of passengers
    public String findTaxi(int num) {
        for (int i = 0; i < counter; i++) {
            if (num > 0 && num <= taxiList[i].getNumPass() && taxiList[i].isAvailable()) {
                taxiList[i].taxiBusy();
                return taxiList[i].getTaxiId();
            }
        }
        return "-1";
    }

    public int getCounter() {
        return counter;
    }
}

class Taxi {
    private String taxiId;
    private String driverName;
    private int taxiNum;
    private int numPass;
    private boolean available;

    // Constructor with default 4 passenger seats
    public Taxi(String taxiId, String driverName) {
        this.taxiId = taxiId;
        this.driverName = driverName;
        this.numPass = 4;
        this.available = true;
    }

    // Constructor to set custom number of passengers
    public Taxi(String taxiId, String driverName, int numPass) {
        this.taxiId = taxiId;
        this.driverName = driverName;
        this.numPass = numPass;
        this.available = true;
    }

    public void setTaxiNum(int taxiNum) {
        this.taxiNum = taxiNum;
    }

    public void taxiBusy() {
        this.available = false;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getTaxiNum() {
        return taxiNum;
    }

    public int getNumPass() {
        return numPass;
    }

    public boolean isAvailable() {
        return available;
    }
}
