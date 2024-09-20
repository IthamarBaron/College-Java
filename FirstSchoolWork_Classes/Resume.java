package FirstSchoolWork_Classes;

public class Resume {
    private String name;
    private int age;
    private int maxPlaces;
    private JobHistory[] jobs;
    private int counter;

    public Resume(String name, int age, int maxPlaces) {
        this.name = name;
        this.age = age;
        this.maxPlaces = maxPlaces;
        this.jobs = new JobHistory[maxPlaces];
        this.counter = 0;
    }

    public int totalVeteranship(String type) {
        int sum = 0;
        for (int i = 0; i < counter; i++) {
            if (jobs[i].getJobType().equals(type)) {
                sum += jobs[i].veteranship();
            }
        }
        return sum;
        // O(N) because we are iterating through all jobs in the resume.
    }


    public void addJob(int fromYear, int tillYear, String company, String jobType) {
        if (counter < maxPlaces) {
            jobs[counter] = new JobHistory(fromYear, tillYear, company, jobType);
            counter++;
        }
    }

    public String getName() {
        return name;
    }
}

class JobHistory {
    private int fromYear;
    private int tillYear;
    private String company;
    private String jobType;

    public JobHistory(int fromYear, int tillYear, String company, String jobType) {
        this.fromYear = fromYear;
        this.tillYear = tillYear;
        this.company = company;
        this.jobType = jobType;
    }

    public int veteranship() {
        return this.tillYear - this.fromYear;
    }

    public String getJobType() {
        return jobType;
    }
}

//PART 5 ANSWER
class ResumeUtils{
    public static void printQualifiedEmployees(Resume[] resumes, String jobType, int requiredVeteranship) {
        for (int i = 0; i < resumes.length; i++) {
            if (resumes[i] != null) {
                int totalVeteranship = resumes[i].totalVeteranship(jobType);
                if (totalVeteranship >= requiredVeteranship) {
                    System.out.println(resumes[i].getName());
                }
            }
        }
    }
    /*
    * O(M * N).
    * where M is the number of resumes in the array.
    * where N is the maximum number of job entries in a resume (the length of jobs[] in the Resume class).
    */
}
