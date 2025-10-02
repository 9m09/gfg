class Solution {
    public String findOrder(String[] words) {
        // code here
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(set.contains(words[i].charAt(j)))    continue;
                max=Math.max(max,words[i].charAt(j)-'a');
                set.add(words[i].charAt(j));
            }
        }
        for(int i=0;i<words.length-1;i++){
            String cur=words[i];
            String after=words[i+1];
            int flag=0;
            for(int j=0;j<cur.length()&&j<after.length();j++){
                if(cur.charAt(j)!=after.charAt(j)){
                    edges.add(new ArrayList<>(Arrays.asList(cur.charAt(j)-97,after.charAt(j)-97)));
                    flag=1;
                    break;
                }
            }
            if(cur.length()>after.length()&&flag==0) return "";
        }
        // System.out.println(edges);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] ind = new int[max+1];
        for(int i=0;i<max+1;i++){  
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            ind[edges.get(i).get(1)]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<max+1;i++){
            if(ind[i]==0)   queue.add(i);
        }
        while(!queue.isEmpty()){
            int temp=queue.poll();
            // if(!set.contains((char)(temp + 'a'))) continue;
            list.add(temp);
            for(int i=0;i<adj.get(temp).size();i++){
                ind[adj.get(temp).get(i)]--;
                if(ind[adj.get(temp).get(i)]==0)    queue.add(adj.get(temp).get(i));
            }
        }
            // System.out.println("->"+list);

        if(list.size()<max+1)
        return "";
        StringBuilder string =new StringBuilder();
        for(int i=0;i<max+1;i++){
            if(!set.contains((char)( list.get(i)+ 97)))  continue;
            string.append((char)(list.get(i)+97));
        }
                // System.out.println(string);

        return string.toString();
    }
    
}


