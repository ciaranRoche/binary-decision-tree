package models;
import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Created by ciaranroche on 24/04/2017.
 */
public class Question {
    public int number;
    private String question;
    private Question ansYes;
    private Question ansNo;
    private int tempYes;
    private int tempNo;

    public Question(int number, String question, int tempYes, int tempNo){
        this.number = number;
        this.question = question;
        this.tempYes = tempYes;
        this.tempNo = tempNo;
    }

    public Question(){}

    public Question(int number, String question, Question ansYes, Question ansNo){
        this.number = number;
        this.question = question;
        this.ansYes = ansYes;
        this.ansNo = ansNo;
    }

    public boolean isLeaf(){
        assert ((ansYes == null) && (ansNo == null)) || ((ansYes != null) && (ansNo != null));
        return ((ansYes == null) && (ansNo == null));
    }

    public int compareTo(Question that){
        return this.number - that.number;
    }

    public String toString(){
        return toStringHelper(getClass())
                .addValue("No: " + getNumber())
                .addValue("Question: " + getQuestion())
                .addValue("Yes: Question " + getTempYes())
                .addValue("No: Question " + getTempNo())
                .toString();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        return true;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public Question getAnsYes(){
        return ansYes;
    }

    public void setAnsYes(Question ansYes){
        this.ansYes = ansYes;
    }

    public Question getAnsNo(){
        return ansNo;
    }

    public void setAnsNo(Question ansNo){
        this.ansNo = ansNo;
    }

    public int getTempYes(){
        return tempYes;
    }

    public int getTempNo(){
        return tempNo;
    }

}

