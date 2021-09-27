package Info;

import java.util.ArrayList;
public class Course {
    private String name;
    private ArrayList<TeachingReq> classRequirements;


    public Course(String courseName) {
        this.name = courseName;
        classRequirements = new ArrayList<TeachingReq>();
    }

    public void addTeaReq(TeachingReq tR){
        classRequirements.add(tR);
//        System.out.println(classRequirements);
    }
    public void removeTeaReq(TeachingReq tR){
        classRequirements.remove(tR);
    }
    public String toString(){
        return  "Course" + "," +name+ "," + classRequirements;
    }
    public ArrayList<TeachingReq> getReq(){
        return classRequirements;
    }

    public String getName() {
        return name;
    }
}
