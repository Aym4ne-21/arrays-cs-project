package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];

        for(int i = 0 ; i < students.length ; i++){
            if(students[i].getAge() > oldest.getAge()){
                oldest = students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(int i = 0 ; i < students.length ; i++){
            if(students[i].getAge() >= 18){
                count++;
            }
        }

        return count ;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students.length == 0) {
            return Double.NaN;
        }

        double sum = 0;

        for (int i = 0; i < students.length; i++) {
            sum += students[i].getGrade();
        }

        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(int i = 0 ; i < students.length ; i++) {
            if(students[i].getName().equalsIgnoreCase(name)){
                return students[i];
            }
        }
        return null ;
    }

    // 6) Sort Students by Grade (descending)


    public static void sortByGradeDesc(Student[] students) {
        if (students == null || students.length <= 1) {
            return;
        }

        Arrays.sort(students, (s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(int i =  0 ; i < students.length ; i++){
            if(students[i].getGrade() >= 15){
                System.out.println(students[i].getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(int i =  0 ; i < students.length ; i++) {
            if(students[i].getId() ==  id){
                students[i].setGrade(newGrade);
                return  true ;
            }
        }
        return false ;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i = 0 ; i < students.length ; i++){
            for(int j = i + 1 ; j < students.length ; j++){
                if(students[i].getName().equals(students[j].getName())){
                    return true;
                }
            }
        }

        return  false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length + 1];

        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        newStudents[students.length] = newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];

        Student s1 = new Student(1, "Aymane");
        Student s2 = new Student(2, "Rayane" , 20);
        Student s3 = new Student(3, "Amine" , 20 , 19);
        Student s4 = new Student(4, "Imane" , 19);
        Student s5 = new Student(5, "Dina" , 18 , 20);


        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;
        arr[3] = s4;
        arr[4] = s5;

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("\n== Oldest Student ==");
        System.out.println(oldest);

        // 3) Count adults
        int adults = countAdults(arr);
        System.out.println("\n== Adult Students ==");
        System.out.println("Number of adults: " + adults);

        // 4) Average grade
        double average = averageGrade(arr);
        System.out.println("\n== Average Grade ==");
        System.out.println("Average grade: " + average);

        // 5) Find by name
        Student found = findStudentByName(arr, "Dina");
        System.out.println("\n== Search Student ==");
        System.out.println(found);

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4, 17);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        boolean duplicates = hasDuplicateNames(arr);
        System.out.println("\nDuplicates found: " + duplicates);

        // 10) Append new student
        Student s6 = new Student(6, "Sara", 21, 16);
        arr = appendStudent(arr, s6);
    }
}

