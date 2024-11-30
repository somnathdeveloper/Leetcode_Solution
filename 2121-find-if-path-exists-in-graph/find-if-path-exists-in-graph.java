// 2) hashmap code using lists
class Solution {
    //public int cc =0; // a check function
    // if we found trav[source] and trav[dst]are true at any point we will change cc to 1.( marking it as true)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>>s1 = new HashMap<>();
        //boolean arr[][] = new boolean[n][n];
        for(int r=0;r<edges.length;r++){
            int e1 = edges[r][0];
            int e2 = edges[r][1];
            // marking both because bidirection graph given
            if(s1.containsKey(e1)){
                s1.get(e1).add(e2);
            }
            else{
                List<Integer>s2 = new ArrayList<>();
                s2.add(e2);
                s1.put(e1,s2);
            }

            if(s1.containsKey(e2)){
                s1.get(e2).add(e1);
            }
            else{
                List<Integer>sw = new ArrayList<>();
                sw.add(e1);
                s1.put(e2,sw);
            }
        }
          boolean trav[]= new boolean[n];
          Arrays.fill(trav,false);
          return dfs(source,destination,s1,trav,source);
    }

   public  boolean dfs(int src, int dst, HashMap<Integer,List<Integer>>s1, boolean[] trav,int sm) { 

    trav[src]=true;
    if(src==dst){
        return true;
    }

    List<Integer>s9 = s1.get(src);
    for (int s = 0; s<s9.size(); s++) {
        int elm = s9.get(s);
           if(trav[elm]==false){
           if(dfs(elm,dst,s1,trav,sm)){
            return true;
           }
           }
        }
    return false;
}
}