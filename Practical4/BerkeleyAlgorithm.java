import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BerkeleyAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of nodes: ");
        n = sc.nextInt();
        List<Integer> timeValues = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the time value of node " + i + ": ");
            timeValues.add(sc.nextInt());
        }

        int averageTime = calculateAverage(timeValues);

        System.out.println("Average time: " + averageTime);

        List<Integer> timeDifferences = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int timeDifference = averageTime - timeValues.get(i);
            timeDifferences.add(timeDifference);
        }

        System.out.println("Time differences: " + timeDifferences);

        System.out.println("Enter the time offset for the time server: ");
        int timeOffset = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int adjustedTime = timeValues.get(i) + timeDifferences.get(i) + timeOffset;
            System.out.println("Adjusted time for node " + i + ": " + adjustedTime);
        }
    }

    private static int calculateAverage(List<Integer> timeValues) {
        int sum = 0;
        for (int value : timeValues) {
            sum += value;
        }
        return sum / timeValues.size();
    }
}

/* OUTPUT
amol@amol-Aspire-5742:~$ java BerkeleyAlgorithm
Enter the number of nodes: 2
Enter the time value of node 0: 2
Enter the time value of node 1: 1
Average time: 1
Time differences: [-1, 0]
Enter the time offset for the time server: 
1
Adjusted time for node 0: 2
Adjusted time for node 1: 2
amol@amol-Aspire-5742:~$ java BerkeleyAlgorithm
Enter the number of nodes: 3 
Enter the time value of node 0: 3
Enter the time value of node 1: 2
Enter the time value of node 2: 4
Average time: 3
Time differences: [0, 1, -1]
Enter the time offset for the time server: 
1
Adjusted time for node 0: 4
Adjusted time for node 1: 4
Adjusted time for node 2: 4
amol@amol-Aspire-5742:~$ java BerkeleyAlgorithm
Enter the number of nodes: 4
Enter the time value of node 0: 1
Enter the time value of node 1: 3
Enter the time value of node 2: 2
Enter the time value of node 3: 3
Average time: 2
Time differences: [1, -1, 0, -1]
Enter the time offset for the time server: 
2
Adjusted time for node 0: 4
Adjusted time for node 1: 4
Adjusted time for node 2: 4
Adjusted time for node 3: 4
amol@amol-Aspire-5742:~$ 
*/
