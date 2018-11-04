package ua.edu.sumdu.j2se.StetsenkoDim.tasks;


public class ArrayTaskList {
    private int index;
    private final int CUT = 4;
    private Task [] task = new Task[10];
    public void add(Task tk){
        if(index == task.length-1)
            ChangeSize((int)(task.length * 1.2 + 1));
        task[index++] = tk;
    }
    private void ChangeSize(int newLength) {
        Task[] newTask = new Task[newLength];
        System.arraycopy(task, 0, newTask, 0, index);
        task = newTask;
    }
    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList nTask = new ArrayTaskList();
        for(int i = 0; i < index; i++) {
            if(task[i].nextTimeAfter(from) > 0 && task[i].nextTimeAfter(from) <= to)
                nTask.add(task[i]);
        }
        return nTask;
    }

    public int size() {
        return index;

    }
    public Task getTask(int index) {
                return this.task[index];
    }
    public boolean remove(Task tcome) {
        int ind = 0;
        for(int i = 0; i <= index; i++) {
            if(task[i] == tcome) {
                ind = i;
                break;
            }
            if(i == index)
                return false;
        }
        for (int i = ind; i < index; i++) {
            task[i] = task[i+1];
        }
        task[index] = null;
        index--;
        if (index < task.length / CUT) {
            ChangeSize((int)(task.length * 1.2 + 1));
        }
        return true;
    }
}