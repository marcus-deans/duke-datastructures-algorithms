import java.util.*;

public class ErdosNumber {
    TreeMap<String, Set<String>> myGraph;
    TreeMap<String, Integer> myDistance;
    public String[] calculateNumbers(String[] pubs){
        makeGraph(pubs);
        ArrayList<String> list = new ArrayList<>();
        bfsErdos(0);
        for(String s : myGraph.keySet()){
            if (myDistance.containsKey(s)){
                s = s + " " + myDistance.get(s);
            }
            list.add(s);
        }
        return list.toArray(new String[0]);
    }

    public void makeGraph(String[] pubi){
        for(String x : pubi){
            String[] auts = x.split(" ");
            ArrayList<String> authors = new ArrayList<>(Arrays.asList(auts));
            for(String curauth: authors){
                myGraph.putIfAbsent(curauth, new HashSet<>());
                myGraph.get(curauth).addAll(authors);
//                myGraph.put(curauth, myGraph.get(curauth).addAll(authors));
                myGraph.get(curauth).remove(curauth);
//                myGraph.put(curauth, myGraph.get(curauth).remove(curauth));
            }
        }
    }
    public Set<String> bfs (String start){
        Set<String> visited = new TreeSet<>();
        Queue<String> qu = new LinkedList<>();
        visited.add(start);
        myDistance.put("ERDOS", 0);
        qu.add(start);
        while (qu.size() > 0){
            String v = qu.remove();
            for(String adj : myGraph.getAdjacent(v)){
                if(! visited.contains(adj)){
                    visited.add(adj);
                    qu.add(adj);
                }
            }
        }
        return visited;
    }

    //loop over each publication, and split individaul authors
    //make ArrayList = authorList.asList();
    //loop over each authorin the split array
    //         myGraph.putIfAbsent( an empty hashset)
    //          myGraph.put(author, myGraph.get(author).addAll(arrayList)
    // or myGraph.get(author).addAll(arrList);
    // myGraph.get(author).remove(author);
}
