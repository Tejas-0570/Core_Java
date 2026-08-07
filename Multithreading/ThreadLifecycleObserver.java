/*
Thread lifecycle observer

Create a thread that goes through all lifecycle states — New, Runnable, Running (sleeping simulates waiting), Terminated.
Print the thread's state at each stage from the main thread using getState(). Also print thread name, priority, and id.

Before start: State: NEW
After start: State: RUNNABLE
While sleep: State: TIMED_WAITING
After finish: State: TERMINATED

Skills: thread states, getState(), join(), getName(), getPriority(), Thread.sleep()

 */

public class ThreadLifecycleObserver {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadLife());
        System.out.println("Before start: State: "+t.getState());
        t.start();
        System.out.println("After start: State: "+t.getState());

        Thread.sleep(500);
        System.out.println("While start: State: "+t.getState());
        t.join();
        System.out.println("After finish: State: "+t.getState());

        System.out.println("Name: "+t.getName()+" | Priority: "+t.getPriority()+" | ID: "+t.getId());
    }
}

class ThreadLife implements Runnable{
    public void run(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}