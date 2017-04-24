package controllers;


import edu.princeton.cs.introcs.In;
import models.Question;

import java.io.File;
import java.util.*;

/**
 * Created by ciaranroche on 24/04/2017.
 */
public class QuestionApi {
    public static Map<Integer, Question> questionMap = new HashMap<>();
    public static String dataPath = "././data/data";
    public static Scanner scanner = new Scanner(System.in);

    public QuestionApi(){}

    public static void main(String[] args) throws Exception {
        prime();
        System.out.println(questionMap.toString());
    }

    public static void prime() throws Exception {
        File file = new File(dataPath);
        In in = new In(file);
        String delims = ":";
        while (!in.isEmpty()) {
            String questionDetails = in.readLine();
            String[] tolkens = questionDetails.split(delims);
            if (tolkens.length == 4) {
                int number = Integer.parseInt(tolkens[0]);
                String question = tolkens[1];
                int ansYes = Integer.parseInt(tolkens[2]);
                int ansNo = Integer.parseInt(tolkens[3]);
                Question q = new  Question(number, question, ansYes, ansNo);
                questionMap.put(number,q);
            }else{
                throw new Exception("CRITICAL ERROR: Invalid tolken length: " + tolkens.length);
            }
        }
        File file2 = new File(dataPath);
        In in2 = new In(file2);
        String delim = ":";
        while(!in2.isEmpty()){
            String details = in2.readLine();
            String[] tolken = details.split(delim);
            if(tolken.length==4){
                int number = Integer.parseInt(tolken[0]);
                int yesTemp = Integer.parseInt(tolken[2]);
                int noTemp = Integer.parseInt(tolken[3]);
                if(questionMap.get(yesTemp)!=null){
                    Question yes = questionMap.get(yesTemp);
                    questionMap.get(number).setAnsYes(yes);
                }
                if(questionMap.get(noTemp)!=null){
                    Question no = questionMap.get(noTemp);
                    questionMap.get(number).setAnsNo(no);

                }
            }
        }
    }

    public static void questionAsk(){
        System.out.println("Please answer yes or no?");
        String ansString;
        int ansInt;
        System.out.println(questionMap.get(1).getQuestion());
        ansString = scanner.nextLine();
        switch(ansString){
            case "yes":
                ansInt = questionMap.get(1).getTempYes();
                question(ansInt);
                break;
            case "no":
                ansInt = questionMap.get(1).getTempNo();
                question(ansInt);
                break;
        }
    }

    public static void question(int in){
        System.out.println(questionMap.get(in).getQuestion());
        String ansString;
        int ansInt;
        ansString = scanner.nextLine();
        switch(ansString){
            case "yes":
                ansInt = questionMap.get(in).getTempYes();
                question(ansInt);
                break;
            case "no":
                ansInt = questionMap.get(in).getTempNo();
                question(ansInt);
                break;
        }

    }

}
