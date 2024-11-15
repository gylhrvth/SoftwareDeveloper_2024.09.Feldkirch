package Sandro.Week9.ZooTycoon2.ZooTycoon;

import lukas.week03.day4.Colors;

import java.util.Vector;

public class ZooKeeper {
    private String name;
    private Vector<Enclosure> tasklist;

    public ZooKeeper(String name) {
        this.name = Colors.COLORS[6] + name + Colors.RESET;
        this.tasklist = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public Vector<Enclosure> getTasklist() {
        return tasklist;
    }

    public void addTask(Zoo zoo, Enclosure task) {
        zoo.addZooKeeper(this);
        tasklist.add(task);
    }

    public void removeTask(Enclosure task) {
        tasklist.remove(task);
    }

    public boolean simulateDay(Vector<Enclosure> tasksForToday){
        int index = 0;
        boolean workHasDone = false;
        while (index < tasklist.size() && !workHasDone) {
            Enclosure enc = tasklist.get(index);
            if (tasksForToday.contains(enc)){
                System.out.println("Zookeeper " + name + " walks over to " + enc.getName());
                enc.processedBy(this);
                tasksForToday.remove(enc);
                workHasDone = true;
            } else {
                System.out.println(name + " goes over to " +enc.getName() + " but it has been already be visited");
            }
            ++index;
        }
        if (!workHasDone){

            System.out.println(name + " has all jobs finished and drinks a coffee");
        }
        return workHasDone;
    }

    public void printTaskprogression() {
//        int start = count;
//
//        for (int i = start; i < tasklist.size(); i++) {
//            if (tasklist.isEmpty()) {
//                System.out.println("no jobs left");
//            }
//            if (tasklist.get(i).isAllreadyVisit() == false) {
//                System.out.println("Zookeeper " + name + " walks over to " + tasklist.get(i).getName());
//                tasklist.get(i).printTaskprogression();
//                tasklist.get(i).setAllreadyVisit(true);
//                break;
//            } else {
//                System.out.println("there is nothing do for " + name + " at " +tasklist.get(i).getName());
//            }
//
//        }
//
//    }

//        if (tasklist.isEmpty()) {
//            System.out.println(name+ " has all jobs finished and drinks a coffee");
//        }
//        for (int i = 0; i < tasklist.size(); i++) {
//            if (tasklist.get(i) == tasklist.firstElement() && tasklist.get(i).isAllreadyVisit() == false) {
//                System.out.println("Zookeeper " + name + " walks over to " + tasklist.get(i).getName());
//                tasklist.get(i).printTaskprogression();
//                tasklist.get(i).setAllreadyVisit(true);
//            } else {
//                System.out.println("there is nothing do for " + name + " at " + tasklist.get(i).getName());
//                tasklist.remove(i);
//                i--;
//            }
//
//        }

    }

//
//        for (Enclosure task : tasklist) {
//
//            if (task == tasklist.firstElement()) {
//                System.out.println("Zookeeper " + name + " walks over to " + tasklist.firstElement().getName());
//                task.printTaskprogression();
//            } else {
//                return;
//            }
//            tasklist.remove(task);
//        }


//        while (!tasklist.isEmpty()) {
//        for (Enclosure task : tasklist) {
//
//                if (task == tasklist.firstElement()) {
//                    System.out.println("Zookeeper " + name + " walks over to " + tasklist.firstElement().getName());
//                    task.printTaskprogression();
//                }
//                tasklist.remove(task);
//            }
//        }


    public void printTask() {
        System.out.print("├── " + name + " works at: ");
        if (tasklist.isEmpty()) {
            System.out.println("│   ├── (has no job)");
        }
        for (Enclosure task : tasklist) {
            if (!task.equals(tasklist.firstElement())) {
                if (!task.equals(tasklist.lastElement())) {
                    System.out.print(", ");
                } else {
                    System.out.print(" und ");
                }
            }
            System.out.print(task.getName());
        }
        System.out.println();
    }
}
