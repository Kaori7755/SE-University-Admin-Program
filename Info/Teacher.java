package Info;
import java.util.ArrayList;
public class Teacher extends Staff{

    private String name;
    private int id;
    private ArrayList<String> training ;


    public Teacher(String name, int id) {
        super(name, id);
        training = new ArrayList<String>();
    }

    public void addTrain(String training){
        this.training.add(training);
    }

    public void remove(String training){
        this.training.remove(training);
    }

    public ArrayList<String> getTraining() {
        return training;
    }


    public boolean hasTrain(String training){
        for(int i=0;i<this.training.size();i++){
            if(this.training.get(i).equals(training)){
                return true;
            }
        }return false;
    }

    public String toString() {
        String output = "Teacher," + super.toString() +",";
        for (int i=0; i<training.size()-1;i++){
            output+=(training.get(i)+",");
        }
        output += training.get(training.size()-1);
        return output;
    }

}