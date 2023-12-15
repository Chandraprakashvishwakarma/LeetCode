class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> temp:paths){
            map.put(temp.get(0),temp.get(1));
        }
        String s = paths.get(0).get(0);
        while(map.get(s)!=null){
            s = map.get(s);
        }
        return s;
    }
}