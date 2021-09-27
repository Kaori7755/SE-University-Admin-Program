package Operation;
import Info.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class FileIO {

    private FileIO(){};//private constructor, so that coder-user cannot create new FileIO object


    public static void fileRead(String location, Uni uni) throws ItemInList{
        FileReader fr = null;
        try{
            //make a fileReader object
            fr = new FileReader(location);
            //make a scanner around the fileReader
            Scanner s = new Scanner(fr);
            //loop over fr until no lines
            while(s.hasNextLine()){
                //get next line
                String line = s.nextLine().trim();
                //split information using the comma
                String[] tokens = line.split(",");
                String type = tokens[0];
                //data typ (e.g. Teacher, Course) is the first element in the array


                if(type.equals("Teacher")){
                    String teacherName = tokens[1];
                    //name of staff or course is the second element in the array
                    int id = Integer.parseInt(tokens[2]);
                    //the rest of the elements in token are training, we take them out an put them in a new String array called training
                    String [] training = Arrays.copyOfRange(tokens,3, tokens.length);
                    //create new teacher object
                    Teacher t = new Teacher(teacherName, id);
                    //add training(s) to the teacher object
                    for(int i =0; i< training.length; i++){
                        t.addTrain(training[i]);
                    }
                    //add the teacher to the Teacher ArrayList located in Uni class
                    uni.add(t);
                }
                //if type is Course, create a Course object and add it to uni
                if(type.equals("Course")){
                    String courseName = tokens[1];
                    Course c = new Course(courseName);
                    String[] reqList = Arrays.copyOfRange(tokens,2, tokens.length);
                    for(int i=0;i<reqList.length;) {
                        String labName = reqList[i];
                        String reqTrain = reqList[i+1];
                        String reqNum = reqList[i+2];
                        int reqStaffNo = Integer.parseInt(reqNum);
                        c.addTeaReq(new TeachingReq(labName,reqTrain,reqStaffNo));
                        i += 3;
                    }
                    uni.add(c);
                }

            }


            //handle exceptions
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ItemInList itemInList) {
            itemInList.printStackTrace();
        }
    }

    public static void fileWrite(String outputLocation, Uni info){
        //crate new fileWriter reference
        FileWriter fw = null;
        try{
            fw = new FileWriter(outputLocation);
            //write teacher information first
            for(int i=0; i<info.getTeachers().size(); i++){
                fw.write(info.getTeachers().get(i)+"\n");
            }
            //then write course information
            for(int i = 0; i<info.getCourses().size(); i++){
                fw.write(info.getCourses().get(i)+"\n");
            }
            //handle exceptions
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fw!=null){
                try{
                    fw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
