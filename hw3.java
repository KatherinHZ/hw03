import java.util.*;

public class hw3code {

    static int size = 0;

    public static void addTask(ArrayList<String> tasks, ArrayList<String> statues, String task, String statue){
       
        tasks.add(task);
        statues.add(statue);
        size ++;
    }

    public static int getSize(){
        return size;
    }

    public static void removeTask(ArrayList<String> tasks, ArrayList<String> statues, int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        tasks.remove(index);
        statues.remove(index);
        size --;
    }

    public static void removeLast(ArrayList<String> tasks, ArrayList<String> statues){
        
        tasks.remove(size-1);
        statues.remove(size-1);
        size --;
    }

    public static String getTask(ArrayList<String> tasks, ArrayList<String> statues, int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return "\"" + tasks.get(index) + "\" is " + statues.get(index);
    }

    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        return false;
    }

    public static void changeTask(ArrayList<String> tasks, ArrayList<String> statues, int index, String task, String statue){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        tasks.set(index, task);
        statues.set(index, statue);
    }

    public static void changeStatue(ArrayList<String> tasks, ArrayList<String> statues, int index, String statue){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        statues.set(index, statue);
    }

    public static int findTaskIndex(ArrayList<String> tasks, ArrayList<String> statues, String finding){
        for(int i = 0; i < size; i ++){
            if(finding.contentEquals(tasks.get(i)))
            return i;
        }
        return -1;    //can't find the task
    }

    public static void foldCompletedTasks(Map<String, ArrayList<String>> folder, ArrayList<String> tasks, ArrayList<String> statues){
        
        ArrayList<String> complete = new ArrayList<>();

        for(int i = 0; i < size; i ++){
            if(statues.get(i).contentEquals("completed"))
                complete.add(tasks.get(i));
        }
        folder.put("Completed", complete);
    }

    public static void foldIncompleteTasks(Map<String, ArrayList<String>> folder, ArrayList<String> tasks, ArrayList<String> statues){
        
        ArrayList<String> incomplete = new ArrayList<>();

        for(int i = 0; i < size; i ++){
            if(!statues.get(i).contentEquals("completed"))
                incomplete.add(tasks.get(i));
        }
        
        folder.put("Incomplete", incomplete);
    }


    public static void main (String[] args){

        Map<String, ArrayList<String>> folder = new HashMap();

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<String> statues = new ArrayList<>();


        addTask(tasks, statues, "groceries", "completed");
        addTask(tasks, statues, "laundry", "completed");
        addTask(tasks, statues, "review", "in progress");

        for(int i = 0; i < getSize(); i ++){
            System.out.println(getTask(tasks, statues, i));
        }
        System.out.println("There are " + getSize() + " tasks.");

        removeLast(tasks, statues);

        addTask(tasks, statues, "homework", "in progress");
        addTask(tasks, statues, "feed the pets", "incomplete");
        addTask(tasks, statues, "learn a song", "inprogess");

        int seek = findTaskIndex(tasks, statues, "laundry");
        if (seek != -1){
            changeTask(tasks, statues, seek, "review", "in progress");
        }
        
        for(int i = 0; i < getSize(); i ++){
            System.out.println(getTask(tasks, statues, i));
        }
        System.out.println("There are " + getSize() + " tasks.");

        removeTask(tasks, statues, 2);
        
        int look = findTaskIndex(tasks, statues, "feed the pets");
        if (seek != -1){
            changeStatue(tasks, statues, look, "completed");
        }

        addTask(tasks, statues, "presentation", "completed");
        addTask(tasks, statues, "prepare gift", "in progress");
        addTask(tasks, statues, "cook", "completed");

        foldCompletedTasks(folder, tasks, statues);
        foldIncompleteTasks(folder, tasks, statues);

        System.out.println("The tasks that are completed: " + folder.get("Completed"));
        System.out.println("The tasks that are incomplete: " + folder.get("Incomplete"));
    }

}
