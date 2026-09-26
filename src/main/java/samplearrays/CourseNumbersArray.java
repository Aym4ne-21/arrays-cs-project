package samplearrays;

public class CourseNumbersArray {

    public static int[] addCourse(int[] registeredCourses, int newCourse) {
        int[] updatedCourses = new int[registeredCourses.length + 1];

        for (int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }

        updatedCourses[registeredCourses.length] = newCourse;

        return updatedCourses;
    }

    public static void printCourses(int[] courses) {
        System.out.print("Updated courses : ");

        for (int course : courses) {
            System.out.print(course + " ");
        }

        System.out.println();
    }

    public static boolean containsCourse(int[] courses, int courseChecking) {
        for (int course : courses) {
            if (course == courseChecking) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        int[] updatedCourses = addCourse(registeredCourses, 2200);

        printCourses(updatedCourses);

        int courseChecking = 2080;

        if (containsCourse(updatedCourses, courseChecking)) {
            System.out.println("Course " + courseChecking + " has been found");
        } else {
            System.out.println("Course " + courseChecking + " has not been found");
        }
    }
}