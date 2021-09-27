package Info;

public class TeachingReq {
    private String reqTrain;
    private int reqStaffNo;
    private String labName;


    public TeachingReq(String labName,String reqTrain,int n){ //TeachingReq objects contains 1 lab name
        this. labName = labName;                             //1 required training
        this.reqTrain = reqTrain;                            //and 1 required number of staffs.
        reqStaffNo= n;
    }

    public String toString(){
        return labName+","+ reqTrain+","+ reqStaffNo;
    }
    public String getTrain(){
        return this.reqTrain;
    }
}