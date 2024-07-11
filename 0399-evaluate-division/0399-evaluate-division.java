class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] value, List<List<String>> queries) {
        int qn = queries.size();
        int en = equations.size();
        double [] res = new double[qn];
        Arrays.fill(res,-1);
        
        Map<String,List<Pair>> adj = new HashMap<>();
        Map<String,Boolean> vis = new HashMap<>();
        
        for(int i=0;i<en;i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            
            if(!adj.containsKey(u)) adj.put(u,new ArrayList<Pair>());
            adj.get(u).add(new Pair(v,value[i]));
            
            if(!adj.containsKey(v)) adj.put(v,new ArrayList<Pair>());
            adj.get(v).add(new Pair(u,1/value[i]));
            
            vis.put(u,false);
            vis.put(v,false);
            
        }
        
        
        
        for(int i=0;i<qn;i++){
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            
            if(!adj.containsKey(u) || !adj.containsKey(v)) res[i] = -1;
            else {
                dfs(u,v,adj,res,i,1,vis);
            }
        }
        
        return res;
    }
    
    public void dfs(String s,String d,Map<String,List<Pair>> adj,double[] res,int i,double ans,Map<String,Boolean> vis){
        
        vis.put(s,true);
        
        if(s.equals(d)) {
            
            res[i] = ans;
            vis.put(s,false);
            return ;
        }
        
        for(Pair p:adj.get(s)){
            if(!vis.get(p.key)) dfs(p.key,d,adj,res,i,ans*p.val,vis);
        }
        
        vis.put(s,false);
    }
}

class Pair{
    public String key;
    public double val;
    
    public Pair(String key,double val){
        this.key = key;
        this.val = val;
    }
}