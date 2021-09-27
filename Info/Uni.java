package Info;
import java.util.ArrayList;


public class Uni {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>(); //Uni is used to store information of all teachers
    private ArrayList<Course> courses = new ArrayList<Course>();//Uni is also used to store information of all courses, including their requirements

    private Uni(){};//private constructor, so that coder-user cannot create new Uni object

    private static Uni uni = new Uni(); //create a uni object when the program starts

    public static Uni reference(){ //public method that returns the reference of Uni object
        return uni;
    }

    public void add(Teacher t) throws ItemInList {
        //if the teacher is not in Uni, store the teacher information
        if (!(inList(t))) {
            teachers.add((t));
        }
        //if the teacher is already in the list, throw ItemInList exception
        else throw new ItemInList("The teacher you want to add is already on the list.");
    }


    public void add(Course c) throws ItemInList {
        //if the Course does not exist in Uni, add the Course to uni
        if (!(inList(c))) {
            courses.add(c);
        }
        //if the Course is already exist, throw ItemInList exception
        else throw new ItemInList("The Course you want to add is already on the list.");
    }


    public boolean noInfo(){
        //if there is no information stored in Uni, return false, otherwise return true
        if (this.teachers.isEmpty() && this.courses.isEmpty() ) {
            return true;
        }return false;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void remove(Object o) throws NotInList {
        if ((inList(o)) && o instanceof Teacher){
            teachers.remove((Teacher)o);
        }
        if (inList(o) && o instanceof Course){
            courses.remove((Course)o);
        }
        //if the item is not in list, throw NotInList exception
        else throw new NotInList("The item you want to remove is not on the list, so it cannot be removed.");
    }


    public boolean inList(Object o) {
        //a public method to check if the Teacher or Course the code-user wants to add is already in Uni
        //check is the real type of the object is Teacher
        if (o instanceof Teacher) {
            //check if the Teacher already in the ArrayList
            for (int i = 0; i < teachers.size(); i++) {
                if (teachers.get(i).equals((Teacher) o)) {
                    return true;
                }
            }
            return false;
        }
        //check if the real type of the object is Course
        if (o instanceof Course) {
            Course c = (Course)o;
            //check if the Course already in the ArrayList
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getName().equals(c.getName())) { //if same name, it's in the list
                    return true;
                }
            }
        } return false;
    }


    public void printTeachers() {
        for (int i = 0; i < teachers.size(); i++) {
            System.out.print(teachers.get(i).toString());
            System.out.println();
        }
    }

    public void printCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).toString().trim());
            System.out.println();
        }
    }

    public void printAllInfo(){
        printTeachers();
        printCourses();
    }


}
