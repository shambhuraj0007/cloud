import java.util.*;
public class Prims {
    static class pair{
        int vertex;
        int weight;
        int parent;// just to track a tree path
        pair(int vertex,int weight,int parent){
            this.vertex=vertex;
            this.weight=weight;
            this.parent=parent;
        }
    }
    public static void prims(ArrayList<ArrayList<pair>>adjlist,int vertices){
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        boolean[]visited=new boolean[vertices];
        ArrayList<pair>path=new ArrayList<>();// just to track a tree path
        int totalcost=0;
        pq.add(new pair(0,0,-1));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int node=p.vertex;
            if(visited[node]){
                continue;
            }
            visited[node]=true;
            totalcost+=p.weight;
            if(p.parent!=-1){
                path.add(p);
            }
            for(pair neigh:adjlist.get(node)){
                int neighbour=neigh.vertex;
                int weight=neigh.weight;
                if(!visited[neighbour]){
                    pq.add(new pair(neighbour,weight,node));
                }
            }

        }
        System.out.println("Total cost of Minimum Spanning Tree: " + totalcost);
        System.out.println("Edges in the Minimum Spanning Tree:");
        for(pair p:path){
            System.out.println(p.parent +"->"+p.vertex+":"+p.weight);
        }
    }
    public static void main(String[]args){
        int vertices=4;
        ArrayList<ArrayList<pair>>adjlist=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            adjlist.add(new ArrayList<>());
        }
        adjlist.get(0).add(new pair(1,10,-1));
        adjlist.get(1).add(new pair(0,10,-1));
        adjlist.get(0).add(new pair(2,6,-1));
        adjlist.get(2).add(new pair(0,6,-1));
        adjlist.get(0).add(new pair(3,5,-1));
        adjlist.get(3).add(new pair(0,5,-1));
        adjlist.get(1).add(new pair(3,15,-1));
        adjlist.get(3).add(new pair(1,15,-1));
        adjlist.get(2).add(new pair(3,4,-1));
        adjlist.get(3).add(new pair(2,4,-1));
        /*
        The above graph can be visualized as:
                10
            (0)----(1)
             | \    |
            6|  \5   |15
             |   \  |
            (2)----(3)
                4
         */
        prims(adjlist,vertices);
    }
}
