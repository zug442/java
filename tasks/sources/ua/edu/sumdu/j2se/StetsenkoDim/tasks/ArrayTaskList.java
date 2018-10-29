package ua.edu.sumdu.j2se.StetsenkoDim.tasks;


public class ArrayTaskList {
    private Task [] task = new Task[0];
    public void add(Task tk){
            Task[] t = task;
            int len;
            try {
                len = t.length;
            } catch (NullPointerException ex) {
                len = 0;
            }
            task = new Task[len + 1];
            for(int i = 0; i < t.length; i++)
                task[i] = t[i];
            task[task.length - 1] = tk;
    }
    public ArrayTaskList incoming(int from, int to) {
        int end = 0;
        ArrayTaskList nTask = new ArrayTaskList();
        for(Task t : task) {
            if(t.isActive()){
                    for(int i = t.getStartTime() + t.getRepeatInterval(); i < t.getEndTime(); i += t.getRepeatInterval()) {
                            if (t.getStartTime() > from && t.getEndTime() < to)
                                break;
                            if (t.getEndTime() == to) {
                                nTask.add(t);
                                break;
                            }
                            if (i >= from && i <= to) {
                                nTask.add(t);
                                break;
                            } else
                                continue;
                    }
                if (t.getTime() > from && t.getTime() <= to) {
                    nTask.add(t);
                }
            }
        }
        return nTask;
    }
    public int size() {

            return task.length;

    }
    public Task getTask(int index) {
                return this.task[index];
    }
         public boolean remove(Task tk) {
        int index = 0;
        Task[]t = task;
        for(int i = 0; i < task.length; i++) {
            if(task[i] == tk) {
                index = i;
                break;
            }
            if (i == task.length - 1)
                return false;
        }
        task = new Task[t.length - 1];
        for(int i = 0; i < index; i++)
            task[i] = t[i];
        for(int i = index + 1; i < task.length + 1; i++)
            task[i - 1] = t[i];
        return true;
    }
}