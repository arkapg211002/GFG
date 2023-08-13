//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Twitter obj = new Twitter();
        int total_queries = sc.nextInt();

        while (total_queries-- > 0) {
            int query = sc.nextInt();

            // if query = 1, postTweet()
            // if query = 2, getNewsFeed()
            // if query = 3, follow()
            // if query = 4, unfollow()

            if (query == 1) {
                int userId = sc.nextInt(), tweetId = sc.nextInt();

                obj.postTweet(userId, tweetId);
            } else if (query == 2) {
                int userId = sc.nextInt();

                List<Integer> vec = obj.getNewsFeed(userId);
                for (int a : vec) System.out.print(a + " ");
                System.out.println();
            } else if (query == 3) {
                int follower = sc.nextInt(), followee = sc.nextInt();
                obj.follow(follower, followee);
            } else {
                int follower = sc.nextInt(), followee = sc.nextInt();
                obj.unfollow(follower, followee);
            }
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Twitter {

    // Initialize your data structure here
    class Pair{
        int time;
        int tweetId;

        Pair(int time, int tweetId){
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    HashMap<Integer, HashSet<Integer>> followers;
    HashMap<Integer, PriorityQueue<Pair>> tweets;
    int time = 0;
    
    Twitter() {
        this.followers = new HashMap<>();
        this.tweets = new HashMap<>();
    }

    // Compose a new tweet
    void postTweet(int userId, int tweetId) {
        this.time += 1;

        this.tweets.computeIfAbsent(userId, k-> new PriorityQueue<Pair>(Comparator.comparingInt(a -> -a.time))).offer(new Pair(time, tweetId));
    }

    // Retrieve the 10 most recent tweet ids as mentioned in question
    List<Integer> getNewsFeed(int userId) {
        List<Integer> tweet = new ArrayList<>();
        List<Integer> users = new ArrayList<>();

        if(this.tweets.containsKey(userId)){
            users.add(userId);
        }
        
        if(this.followers.containsKey(userId)){
            for(int i : this.followers.get(userId)){
                users.add(i);
            }
        }
        
        HashMap<Integer, ArrayList<Pair>> temp = new HashMap<>();

        while(true){

            int maxUser = -1, maxTime = -1;
            for(int i : users){

                if(!this.tweets.containsKey(i) || this.tweets.get(i).size() == 0){
                    continue;
                }

                Pair p = this.tweets.get(i).peek();
                if(p.time > maxTime){
                    maxTime = p.time;
                    maxUser = i;
                }
            }

            if(maxUser == -1){
                break;
            }

            Pair p = this.tweets.get(maxUser).poll();
            temp.computeIfAbsent(maxUser, k -> new ArrayList<Pair>()).add(p);
            tweet.add(p.tweetId);

            if(tweet.size() == 10){
                break;
            }
        }

        for(Map.Entry<Integer, ArrayList<Pair>> entry : temp.entrySet()){
            this.tweets.computeIfAbsent(entry.getKey(), k-> new PriorityQueue<Pair>(Comparator.comparingInt(a -> -a.time))).addAll(entry.getValue());
        }

        return tweet;
    }

    // Follower follows a followee. If the operation is invalid, it should be a
    // no-op.
    void follow(int followerId, int followeeId) {
        this.followers.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
    }

    // Follower unfollows a followee. If the operation is invalid, it should be
    // a no-op.
    void unfollow(int followerId, int followeeId) {
        if(this.followers.containsKey(followerId) && this.followers.get(followerId).contains(followeeId)){
            this.followers.get(followerId).remove(followeeId);
        }
    }
}