class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String,List<Integer>> map = new HashMap<>();
        List<String> highAccessEmp = new ArrayList();
        for(List<String> emp:access_times){
            if(map.get(emp.get(0)) == null){
                map.put(emp.get(0),new ArrayList<Integer>(){{add(Integer.valueOf(emp.get(1)));}});
            }
            else {
                List<Integer> temp = map.get(emp.get(0));
                temp.add(Integer.valueOf(emp.get(1)));
                map.put(emp.get(0),temp);
            }
        } 
        for(String s : map.keySet()){
            List<Integer> temp = map.get(s);
            if(temp.size()<3) continue;
            Collections.sort(temp);
            // System.out.println(temp);
            for(int i = 2;i<temp.size();i++){
                if(temp.get(i)-temp.get(i-2)<100) {
                    highAccessEmp.add(s);
                    break;
                }
            }
        }
        return highAccessEmp;
    }
}