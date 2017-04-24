package controllers;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ciaranroche on 24/04/2017.
 */
public class QuestionClient {
    public static Scanner scanner;
    public QuestionApi api;

    public QuestionClient(){}

    public static void main(String[] args) throws IOException {
        QuestionClient questionClient = new QuestionClient();
        scanner = new Scanner(System.in);
        Shell shell = ShellFactory.createConsoleShell("BDT",
                "      <<<<------------------------------------------------->>>>\n             " +
                        "    Welcome to the Binary Decision Tree\n      <<<<------------------------------------------------->>>>\n             " +
                            "           Please Prime The Tree\n\n"  +
                        "\n- ?help for instructions\n- ?list for commands",questionClient);
        shell.commandLoop();
    }

    @Command(description = "Prime from File")
    public void prime() throws Exception{
        api.prime();
        System.out.println("The Binary Decision Tree has been populated");
    }

    @Command(description = "Ask Questions")
    public void ask(){
        api.questionAsk();
    }
}
