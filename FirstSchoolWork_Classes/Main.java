package FirstSchoolWork_Classes;

import java.awt.*;

public class Main
{
    //RUNNING TESTS (tests were generated using CHAT-GPT)
    public static void main(String[] args) {

        System.out.println("============== [QUESTION 1] ==============" );

        // Create a TaxiStation instance
        TaxiStation station = new TaxiStation("Central Station");

        // Add taxis to the station
        station.addToStation("John Doe", "TX123", 4);
        station.addToStation("Jane Doe", "TX456", 3);
        station.addToStation("Alice", "TX789", 6);

        // Get the total number of taxis
        System.out.println("Total taxis: " + station.getCounter()); // Expected: 3

        // Find a taxi for 4 passengers
        String taxiId = station.findTaxi(4);
        if (!taxiId.equals("-1")) {
            System.out.println("Taxi available for 4 passengers: " + taxiId);
        } else {
            System.out.println("No taxi available for 4 passengers.");
        }

        // Try to find a taxi for 2 passengers
        taxiId = station.findTaxi(-1);
        if (!taxiId.equals("-1")) {
            System.out.println("Taxi available for -1 passengers: " + taxiId);
        } else {
            System.out.println("No taxi available for -1 passengers.");
        }
        System.out.println("============== [QUESTION 2] ==============" );
        Resume resume1 = new Resume("Alice", 30, 5);
        Resume resume2 = new Resume("Bob", 28, 5);

        // Add job histories to the resumes
        resume1.addJob(2015, 2018, "Company A", "Developer"); // 3 years
        resume1.addJob(2019, 2021, "Company B", "Developer"); // 2 years
        resume1.addJob(2022, 2023, "Company C", "Manager");   // 1 year

        resume2.addJob(2016, 2019, "Company D", "Developer"); // 3 years
        resume2.addJob(2020, 2022, "Company E", "Designer");  // 2 years

        // Test 1: Check total veteranship in "Developer"
        int aliceDeveloperExperience = resume1.totalVeteranship("Developer");
        System.out.println("Alice's total veteranship as Developer: " + aliceDeveloperExperience); // Expected: 5

        // Test 2: Check total veteranship in "Designer"
        int bobDesignerExperience = resume2.totalVeteranship("Designer");
        System.out.println("Bob's total veteranship as Designer: " + bobDesignerExperience); // Expected: 2

        // Test 3: Print all resumes with at least 2 years experience as Developer
        System.out.println("Employees with at least 2 years experience as Developer:");
        Resume[] resumes = {resume1, resume2};
        ResumeUtils.printQualifiedEmployees(resumes, "Developer", 2);
        // Expected output: Alice, Bob

        // Test 4: Print all resumes with at least 1 year experience as Manager
        System.out.println("Employees with at least 1 year experience as Manager:");
        ResumeUtils.printQualifiedEmployees(resumes, "Manager", 1);
        // Expected output: Alice

        // Test 5: Print all resumes with at least 3 years experience as Developer
        System.out.println("Employees with at least 3 years experience as Developer:");
        ResumeUtils.printQualifiedEmployees(resumes, "Developer", 3);
        // Expected output: Alice, Bob (both have 3+ years)


        System.out.println("============== [QUESTION 3] ==============" );
        // Create a StudentSupport instance
        StudentSupport studentSupport = new StudentSupport();

        // Add some students with lessons
        System.out.println("Adding students:");
        studentSupport.addLesson(studentSupport.new StudLes("Alice", "123456789", (byte) 1));
        studentSupport.addLesson(studentSupport.new StudLes("Bob", "987654321", (byte) 1));
        studentSupport.addLesson(studentSupport.new StudLes("Charlie", "555444333", (byte) 2));
        studentSupport.addLesson(studentSupport.new StudLes("Diana", "666777888", (byte) 3));
        studentSupport.addLesson(studentSupport.new StudLes("Eva", "111222333", (byte) 5));

        // Trying to add more lessons than available slots (12)
        System.out.println("\nTrying to add 12 more students (only 7 slots should be available) (no more space 5 times):");
        for (int i = 0; i < 12; i++) {
            studentSupport.addLesson(studentSupport.new StudLes("Student" + i, "00000000" + i, (byte) 4));
        }

        // Count the number of students
        System.out.println("\nTotal students added: " + studentSupport.countStudents());  // Expected: 12

        // Display students for a particular day
        System.out.println("\nDisplay students for day 1:");
        studentSupport.displayDay((byte) 1);  // Expected: Alice, Bob

        System.out.println("\nDisplay students for day 4:");
        studentSupport.displayDay((byte) 4);  // Expected: List students added during the loop

        System.out.println("\nDisplay students for day 5:");
        studentSupport.displayDay((byte) 5);  // Expected: Eva

        // Test invalid day handling
        System.out.println("\nTest invalid day (day 6):");
        studentSupport.displayDay((byte) 6);  // Expected: Invalid day! Must be between 1 and 5.


    }
}


