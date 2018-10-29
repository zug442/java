package ua.edu.sumdu.j2se.StetsenkoDim.tasks;

import java.util.Date;

/**
 * Created by stets on 02.10.2018.
 */
public class Task {
    private static final int HOUR = 3600000; //1000*60*60 HOUR in milliseconds
    private String title;
    private Date time;
    private Date start;
    private Date end;
    private int interval;
    private boolean active = false;
    
    public Task(String title, int time) {
        this.title = title;
        this.time = new Date((long) time * HOUR);
        this.start = new Date((long) time * HOUR);
        this.end = new Date((long) time * HOUR);
    }

    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.time = new Date((long) start * HOUR);
        this.start = new Date((long) start * HOUR);
        this.end = new Date((long) end * HOUR);
        this.interval = interval;
    }
	
	public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
	
	public void setActive(boolean active) {
        this.active = active;
    }
	
	public boolean isActive() {
		return this.active;
	}

    public int getTime() {
        return (int) this.time.getTime() / HOUR;
    }

    public void setTime(int time) {
        this.time.setTime((long) time * HOUR);
        this.start.setTime((long) time * HOUR);
        this.end.setTime((long) time * HOUR);
        this.interval = 0;
		this.active = false;
    }

    public int getStartTime() {
		if (this.active != false & this.interval == 0) {
			return 0;
            }
		return (int) this.start.getTime() / HOUR;
    }

    public int getEndTime() {
		if (this.active != false && this.interval == 0) {
			return 0;
		}
		return (int) this.end.getTime() / HOUR;
    }

    public int getRepeatInterval() {
        if (this.interval == 0) {
			return 0;
		} else {
			return this.interval;
		}
    }

     public void setTime(int start, int end, int interval) {
        this.time.setTime((long) start * HOUR);
        this.start.setTime((long) start * HOUR);
        this.end.setTime((long) end * HOUR);
        this.interval = interval;
        this.active = true;
    }

    public boolean isRepeated() {
        if (this.interval != 0) {
            return true;
        }
        return false;
    }

    public int nextTimeAfter(int current) {
        if (this.isActive() == true) {
            if (current < this.getTime()) {
                return this.getTime();
            } else {
                if (this.interval > 0) {
                    for (int i = this.getStartTime(); i < this.getEndTime(); i += this.interval) {
                        if (current < i) {
                            return i;
                        }
                    }
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

}