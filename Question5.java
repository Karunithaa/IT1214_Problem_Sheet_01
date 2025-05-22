class Student {
    private String name;
    private int exam1;
    private int exam2;
    private int exam3;

    	boolean validateMarks(int marks){
		if(marks<=100 && marks>=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	Student(String name, int exam1, int exam2, int exam3){
		
		try{
			if(ValidateMarks(exam1)&& ValidateMarks(exam2) && validateMarks(exam3)){
			this.exam1=exam1;
			this.exam2=exam2;
			this.exam3=exam3;
			}
		}
		catch(Exception e){
			System.out.println("Exam scores must be between 0 and 100");
		}

    public String getName() {
        return name;
    }

    public int getExam1() {
        return exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public int getExam3() {
        return exam3;
    }

    public double calculateAverage() {
        return (exam1 + exam2 + exam3) / 3.0;
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student("John", 75, 110, 90);
            System.out.println("Student: " +student.getName()+"Average Score:  " + student.calculateAverage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
}