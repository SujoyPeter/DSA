package LinkedList_Array;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] student, int[] cookie) {
         Arrays.sort(student);
        Arrays.sort(cookie);

        int studentIndex = 0;
        int cookieIndex = 0;

        // Try to assign cookies until any one list is fully processed
        while (studentIndex < student.length && cookieIndex < cookie.length) {
            // If the cookie satisfies the student's greed
            if (cookie[cookieIndex] >= student[studentIndex]) {
                studentIndex++;
            }
            // Move to next cookie in both cases
            cookieIndex++;
        }

        // Number of students satisfied is equal to studentIndex
        return studentIndex;
    }
    public static void main(String[] args) {
        AssignCookies obj = new AssignCookies();
        int[] student = {1, 2, 3};
        int[] cookie = {1, 1};
        System.out.println("Number of content children: " + obj.findContentChildren(student, cookie));
    }
}
