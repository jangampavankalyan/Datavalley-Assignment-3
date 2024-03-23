
class SharedResource {
    private int count = 0;

    
    public synchronized void increment() {
        count++;
    }

    
    public int getCount() {
        return count;
    }
}


class WorkerThread extends Thread {
    private SharedResource sharedResource;
    private int increments;

    public WorkerThread(SharedResource sharedResource, int increments) {
        this.sharedResource = sharedResource;
        this.increments = increments;
    }

    public void run() {
        for (int i = 0; i < increments; i++) {
            sharedResource.increment();
        }
    }
}


public class SynchronizationExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        
        WorkerThread thread1 = new WorkerThread(sharedResource, 1000);
        WorkerThread thread2 = new WorkerThread(sharedResource, 1000);


        thread1.start();
        thread2.start();

        try {
            // Wait for threads to finish execution
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        System.out.println("Final Count: " + sharedResource.getCount());
    }
}
SharedResource class represents a resource (in this case, an integer count) that will be shared among multiple threads.
The increment() method of SharedResource is synchronized using the synchronized keyword, which ensures that only one thread can execute this method at a time.
WorkerThread class represents a thread that will increment the count of the shared resource.
In the main method, two WorkerThread instances are created and started.
The join() method is called on both threads to ensure that the main thread waits for them to finish execution.
Finally, the final count of the shared resource is printed.
