package Info;
import java.util.ArrayList;

public class Admin extends Staff{
    private String name;
    private int id;

    public Admin(String name, int id) {
        super(name,id);
    }

    public static ArrayList<String> searchTeacher(String trainingCourse, Uni uni) {
        ArrayList<String> teacherList = new ArrayList<String>();
        // foreach loop to see if the teacher[i] contains this trainingCourse passed
        for (Teacher i : uni.getTeachers()) {
            if (i.getTraining().contains(trainingCourse)) {
                // if has, store teacher`s name to the list
                teacherList.add(i.getName());
            }
        }
        // check if the list is empty
        if (teacherList.isEmpty()) {
            System.out.println("The training has not been taken by any teacher.");
        }
        return teacherList;
    }

    public static ArrayList<TeachingReq> searchTeaReq(Course course, Uni uni) {
        for(Course i:uni.getCourses()) {
            if(i.getName().equals(course.getName())) {
                return i.getReq();
            }
        }return null;
    }
}