package Operation;
import javax.swing.*;
import Info.*;

public class GUI {


    private String fileLocation;
    //private FileIO fileIO;
    private Uni uni;
//private Admin admin;
//private ClassDirector classDirector;


    public GUI(){
//        this.fileIO = FileIO.reference();
        this.uni = Uni.reference();
//        this.admin = new Admin("Helen", 123); //create an Admin
//        this.classDirector = new ClassDirector("Ron",223); //create a classDirector
    }

    public	void start() throws ItemInList {
        // if a file is not uploaded (nothing in uni), keep the loop running
        while(uni.noInfo())
        {   //ask for user input
            fileLocation = JOptionPane.showInputDialog(
                    "Please provide file location");
            //call fileRead() of FileIO
            FileIO.fileRead(fileLocation,uni);
            //print out what is in the file
            System.out.print("Information:" + "\n");
            uni.printAllInfo();
        }
    }


    public void run() throws ItemInList {
        boolean run = true;
        while (run)
        {   //ask for user input
            String input = JOptionPane.showInputDialog(
                    "What do you want to do? (s)search (c)create teaching requirement (q)Quite");
            char	i = input.charAt(0);
            switch (i)
            {
                //if the input is 's', call search()
                case 's': search();
                    //when search() is done, get out of the loop
                    break;
                //if the input is 'c', call create()
                case 'c': create();
                    //when create() is done, get out of the loop
                    break;
                //if input is 'q', stop the while loop, which will end this method
                case'q': run = false;
            }
        }
    }


    public void search(){
        //ask for user input
        String	input1 = JOptionPane.showInputDialog(
                "What do you want to search for? (t)Teacher (l)List of teaching requirement ");
        char	c = input1.charAt(0);
        switch(c)
        {   //if input is 't', ask the user to input the parameter (training name)
            case't': String requiredTrain = JOptionPane.showInputDialog(
                    "Please enter required training");
                System.out.println("Qualified teachers:" + Admin.searchTeacher(requiredTrain,uni));
                //get out of the loop when the search teacher function is done
                break;
            //if the input is 'l', ask the user to input the parameter (Course name)
            case'l':String input3 = JOptionPane.showInputDialog(
                    "Please enter Course name");
                //call the searchTeaReq() of Admin class and show the user the output (the list of teaching requirement)
                System.out.println("Teaching requirement of " + input3 + ":" +Admin.searchTeaReq(new Course(input3),uni));
                //get out of the loop when the search teaching requirement function is done
                break;

        }
    }

    public void create() throws ItemInList {
        //ask for user input (parameters) and store the input
        String	courseName = JOptionPane.showInputDialog(
                "Please enter the Course name");
        String labName = JOptionPane.showInputDialog(
                "Please enter the lab name");
        String	reqNumber = JOptionPane.showInputDialog(
                "Please enter the required number of staff for the teaching requirement");
        //cast the input2 into a int type, so that we can pass it to the TeachingReq constructor
        int reqStaffNo = Integer.parseInt(reqNumber);
        String reqTrain = JOptionPane.showInputDialog(
                "Please enter the required training");
        //call the createTeaReqList() of classDirector class
        ClassDirector.createTeaReqList(new Course(courseName),new TeachingReq(labName,reqTrain,reqStaffNo),uni);
    }

    public void end(){
        //write the new information back to the file
        FileIO.fileWrite(fileLocation,uni);
    }
}