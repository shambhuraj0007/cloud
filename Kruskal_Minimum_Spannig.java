import java.util.*;
public class Kruskal_Minimum_Spannig{
    static class Pair{
        int u;
        int v;
        int wt;
        public Pair(int u,int v,int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
    }
    public static int find_parent(int u,int[]parent){
        if(parent[u]==u){
            return u;
        }
        return parent[u]=find_parent(parent[u],parent);
    }
    public static void union(int Pu,int Pv,int[]parent,int[]rank){
        if(rank[Pu]<rank[Pv]){
            parent[Pu]=Pv;
        }
        else if(rank[Pu]>rank[Pv]){
            parent[Pv]=Pu;
        }
        else{
            parent[Pv]=Pu;
            rank[Pu]++;
        }
    }
    public static void kruskal(ArrayList<Pair>adjlist,int V){
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        for(Pair p:adjlist){
            pq.add(p);
        }
        int[] parent=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        int[]rank=new int[V];
        int mstwt=0;
        System.out.println("Edges in the Minimum Spanning Tree:");
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int u=p.u;
            int v=p.v;
            int wt=p.wt;
            int Pu=find_parent(u,parent);
            int Pv=find_parent(v,parent);
            if(Pu!=Pv){
                System.out.println(u+"-"+v+" Edge Weight:"+wt);;
                mstwt+=wt;
                union(Pu,Pv,parent,rank);
            }
        }
        System.out.println("Minimum Spanning Tree Weight: "+mstwt);
    }
    public static void main(String[]args){
        ArrayList<Pair>adjlist=new ArrayList<>();      
        int V=4;
        adjlist.add(new Pair(0, 1, 10));
        adjlist.add(new Pair(0, 2, 6));
        adjlist.add(new Pair(0, 3, 5));
        adjlist.add(new Pair(1, 3, 15));
        adjlist.add(new Pair(2, 3, 4));
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
        kruskal(adjlist,V);
    }
}