import java.util.*;

public class FriendScore {
    TreeMap<Integer, Set<Integer>> myGraph;
    public int highestScore(String[] friends){
        int count = 0;
        makeGraph(friends);
//        ArrayList<String> arlist = (ArrayList<String>) Arrays.asList(friends);
        for(int p = 0; p<friends.length; p++){
            Set<Integer> friendset = checkTwoFriends(p);
            count = Math.max(friendset.size(), count);
        }
        return count;
    }

    public Set<Integer> checkTwoFriends (int y){
        TreeSet<Integer> friendsTreeList = new TreeSet<>(myGraph.get(y));
        for(int oneFriends : myGraph.get(y)){
            Set<Integer> curFriend = myGraph.get(oneFriends);
            friendsTreeList.addAll(curFriend);
        }
        friendsTreeList.remove(y);
        return friendsTreeList;
    }

    public void makeGraph(String[] infriends){
        myGraph = new TreeMap<>();

        for(int x = 0; x<infriends.length; x++){
            myGraph.put(x, new TreeSet<>());
            String curfriend = infriends[x];
            for(int q = 0; q <infriends[x].length(); q ++){
                if(curfriend.charAt(q) == 'Y') {
                    myGraph.get(x).add(q);
                }
            }
        }
    }
}
