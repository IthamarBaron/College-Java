package FirstSchoolWork_Classes;


public class StudentSupport {
    private StudLes[] arr;
    private int[] count;

    public StudentSupport() {
        arr = new StudLes[12];
        count = new int[5];
    }

    public int countStudents() {
        //finding all the lessons while skipping empty slots (in case [V][N][V][V] -> 3)
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                counter++;
        }
        return counter;
    }

    public void addLesson(StudLes lesson) {
        if (this.countStudents() >= 12)
            System.out.print("No more space!");
        else {
            //find the first available slot and place it there.
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    arr[i] = lesson;
                    count[lesson.getDay()-1]++;
                    break;
                }
            }
        }
    }

    public void displayDay(byte day) {
        if (day >= 1 && day <= 5)
        {
            System.out.println("Students for day " + day);
            boolean hasStudents = false;
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i] != null && arr[i].getDay() == day)
                {
                    System.out.println(arr[i].getName());
                    hasStudents = true;
                }
            }
            if (!hasStudents)
                System.out.println("No students have a lesson on this day.");
        }
        else
            System.out.println("Invalid day! Must be between 1 and 5.");
    }

    class StudLes {
        private String name;
        private String phone;
        private byte day;


        public StudLes(String name, String phone, byte day) {
            this.name = name;
            this.phone = phone;
            this.day = day;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setDay(byte day) {
            if (day < 6 && day > 0)
                this.day = day;
            else
                throw new IllegalArgumentException("Invalid day! Must be between 1 and 5.");
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public byte getDay() {
            return day;
        }
    }
}
