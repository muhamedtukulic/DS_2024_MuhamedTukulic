package homework2;

import java.util.PriorityQueue;

public class ProcessQueue {
    private PriorityQueue<Process> heap;

    public ProcessQueue() {
        heap = new PriorityQueue<>();
    }

    public void addProcess(Process process) {
        heap.add(process);
    }

    public Process runNextProcess() {
        return heap.poll();
    }

    public Process peekNextProcess() {
        return heap.peek();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
