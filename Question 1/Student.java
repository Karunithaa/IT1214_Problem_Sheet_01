class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    public Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Days Attended: " + daysAttended;
    }
}

class Classroom {
    private Student[] students;
    private int studentCount;

    public Classroom() {
        students = new Student[10];  // Maximum 10 students
        studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        } else {
            System.out.println("Classroom is full. Cannot add more students.");
        }
    }

    public void updateAttendance(int studentId, int newDaysAttended) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(newDaysAttended);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void displayAllStudents() {
        System.out.println("Student Attendance Records:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();


        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        classroom.updateAttendance(102, 16);
        classroom.updateAttendance(104, 9);

        classroom.displayAllStudents();
    }
}
