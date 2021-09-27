package Info;
public class ClassDirector extends Staff {

    private String name;
    private int id;
    private Course course; //indicate what course the class director is responsible for

    public ClassDirector(String name, int id) {
        super(name, id);
        // constructor without parameters, but the constructor of Staff is parameterised, so we need to overload it.
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    // creatReq method to store courseName and TeachingReq into Course class
    public static void createTeaReqList(Course course, TeachingReq teachingReq, Uni uni) throws ItemInList {
        //check if the Course is already in uni
        if (uni.inList(course)) {
            //if yes, loop over the Course list to find the Course and add the teaching requirement to the Course
            for (Course i : uni.getCourses()) {
                if (i.getName().equals(course.getName())) {
                    i.addTeaReq(teachingReq);
                }
            }
        //if no, add the teaching requirement to the Course and add the Course to uni
        } else {
            course.addTeaReq(teachingReq);
            uni.add(course);
        }

    }
}