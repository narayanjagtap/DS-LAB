import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TokenRing {
    private final int numProcesses;
    private final Lock[] locks;
    private volatile int tokenHolder; // Index of the process holding the token

    public TokenRing(int numProcesses) {
        this.numProcesses = numProcesses;
        locks = new Lock[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            locks[i] = new ReentrantLock();
        }
        tokenHolder = 0; // Initial token holder
    }

    // Method for a process to request access to the critical section
    public void requestCriticalSection(int processId) {
        // Lock the current process to ensure mutual exclusion
        locks[processId].lock();
        
        // If the current process is the token holder, it can enter the critical section
        if (processId == tokenHolder) {
            System.out.println("Process " + processId + " is entering the critical section.");
            // Simulate some work in the critical section
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Pass the token to the next process
            tokenHolder = (tokenHolder + 1) % numProcesses;
        } else {
            System.out.println("Process " + processId + " is waiting for the token.");
        }

        // Release the lock
        locks[processId].unlock();
    }
}

public class Token {
    public static void main(String[] args) {
        int numProcesses = 5;
        TokenRing tokenRing = new TokenRing(numProcesses);

        // Simulate processes requesting access to the critical section
        for (int i = 0; i < numProcesses; i++) {
            final int processId = i;
            new Thread(() -> {
                while (true) {
                    tokenRing.requestCriticalSection(processId);
                    // Simulate some processing time before requesting again
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
