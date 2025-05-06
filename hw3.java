import java.util.*;

public class hw3code {

    static int size = 0;

    public static void addTask(ArrayList<String> tasks, ArrayList<String> status, String task, String statu){
       
        tasks.add(task);
        status.add(statu);
        size ++;
    }

    public static int getSize(){
        return size;
    }

    public static void removeTask(ArrayList<String> tasks, ArrayList<String> status, int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        tasks.remove(index);
        status.remove(index);
        size --;
    }

    public static void removeLast(ArrayList<String> tasks, ArrayList<String> status){
        
        tasks.remove(size-1);
        status.remove(size-1);
        size --;
    }

    public static String getTask(ArrayList<String> tasks, ArrayList<String> status, int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return "\"" + tasks.get(index) + "\" is " + status.get(index);
    }

    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        return false;
    }

    public static void changeTask(ArrayList<String> tasks, ArrayList<String> status, int index, String task, String statu){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        tasks.set(index, task);
        status.set(index, statue);
    }

    public static void changeStatue(ArrayList<String> tasks, ArrayList<String> status, int index, String statu){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        status.set(index, statue);
    }

    public static int findTaskIndex(ArrayList<String> tasks, ArrayList<String> status, String finding){
        for(int i = 0; i < size; i ++){
            if(finding.contentEquals(tasks.get(i)))
            return i;
        }
        return -1;    //can't find the task
    }

    public static void foldCompletedTasks(Map<String, ArrayList<String>> folder, ArrayList<String> tasks, ArrayList<String> status){
        
        ArrayList<String> complete = new ArrayList<>();

        for(int i = 0; i < size; i ++){
            if(status.get(i).contentEquals("completed"))
                complete.add(tasks.get(i));
        }
        folder.put("Completed", complete);
    }

    public static void foldIncompleteTasks(Map<String, ArrayList<String>> folder, ArrayList<String> tasks, ArrayList<String> status){
        
        ArrayList<String> incomplete = new ArrayList<>();

        for(int i = 0; i < size; i ++){
            if(!status.get(i).contentEquals("completed"))
                incomplete.add(tasks.get(i));
        }
        
        folder.put("Incomplete", incomplete);
    }


    public static void main (String[] args){

        Map<String, ArrayList<String>> folder = new HashMap();

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();


        addTask(tasks, status, "groceries", "completed");
        addTask(tasks, status, "laundry", "completed");
        addTask(tasks, status, "review", "in progress");

        for(int i = 0; i < getSize(); i ++){
            System.out.println(getTask(tasks, status, i));
        }
        System.out.println("There are " + getSize() + " tasks.");

        removeLast(tasks, status);

        addTask(tasks, status, "homework", "in progress");
        addTask(tasks, status, "feed the pets", "incomplete");
        addTask(tasks, status, "learn a song", "inprogess");

        int seek = findTaskIndex(tasks, status, "laundry");
        if (seek != -1){
            changeTask(tasks, status, seek, "review", "in progress");
        }
        
        for(int i = 0; i < getSize(); i ++){
            System.out.println(getTask(tasks, status, i));
        }
        System.out.println("There are " + getSize() + " tasks.");

        removeTask(tasks, status, 2);
        
        int look = findTaskIndex(tasks, status, "feed the pets");
        if (seek != -1){
            changeStatue(tasks, status, look, "completed");
        }

        addTask(tasks, status, "presentation", "completed");
        addTask(tasks, status, "prepare gift", "in progress");
        addTask(tasks, status, "cook", "completed");

        foldCompletedTasks(folder, tasks, status);
        foldIncompleteTasks(folder, tasks, status);

        System.out.println("The tasks that are completed: " + folder.get("Completed"));
        System.out.println("The tasks that are incomplete: " + folder.get("Incomplete"));
    }

}
