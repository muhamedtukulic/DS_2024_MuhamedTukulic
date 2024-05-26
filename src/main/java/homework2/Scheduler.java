package homework2;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue processQueue = new ProcessQueue();
        int currentTime = 0;
        int totalBurstTime = processes.stream().mapToInt(p -> p.burstTime).sum();


        while (currentTime < totalBurstTime) {
            for (Process process : processes) {
                if (process.arrivalTime == currentTime) {
                    processQueue.addProcess(process);
                }
            }

            if (!processQueue.isEmpty()) {
                Process currentProcess = processQueue.runNextProcess();
                System.out.println("t: " + currentTime + " | " + currentProcess.name);
                currentProcess.remainingTime--;

                if (currentProcess.remainingTime > 0) {
                    processQueue.addProcess(currentProcess);
                }


            } else {
                System.out.println("t: " + currentTime + " | " + "no process");
            }

            currentTime++;
        }

        System.out.println("Total time taken: " + currentTime + " units");
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 2, 4, 1));
        processes.add(new Process("P2", 1, 1, 2));
        processes.add(new Process("P3", 3, 2, 8));

        scheduleAndRun(processes);
    }
}
