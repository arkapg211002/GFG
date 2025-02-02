//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> freeRoom = new PriorityQueue<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        Map<Integer, Integer> mp = new HashMap<>();

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            freeRoom.add(i);
        }

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                freeRoom.add((int) pq.poll()[1]);
            }

            if (!freeRoom.isEmpty()) {
                int room = freeRoom.poll();
                mp.put(room, mp.getOrDefault(room, 0) + 1);
                pq.add(new long[]{end, room});
            } else {
                long[] top = pq.poll();
                long prevEndTime = top[0];
                int room = (int) top[1];
                mp.put(room, mp.getOrDefault(room, 0) + 1);
                pq.add(new long[]{prevEndTime + (end - start), room});
            }
        }

        int ans = -1;
        int maxi = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int room = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxi) {
                maxi = freq;
                ans = room;
            }
        }

        return ans;
    }
}



//{ Driver Code Starts.
// } Driver Code Ends