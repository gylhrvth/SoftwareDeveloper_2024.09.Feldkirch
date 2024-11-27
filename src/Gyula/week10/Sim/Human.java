package Gyula.week10.Sim;

import java.util.Random;
import java.util.Vector;

public class Human {
    private static Random random = new Random();
    private String name;
    private Vector<String> dailyRoutine;
    private Vector<String> taskList;


    public Human(String name){
        this.name = name;
        dailyRoutine = new Vector<>();
        taskList = new Vector<>();
    }

    public void addTask(String task){
        dailyRoutine.add(task);
    }

    public void startDay(){
        taskList.clear();
        taskList.addAll(dailyRoutine);
    }


    public String doTask(){
        if(taskList.isEmpty()){
            return null;
        }
        String task = taskList.get(random.nextInt(taskList.size()));
        System.out.println(name + ": I'm doing " + task);
        taskList.remove(task);
        return task;
    }
}
