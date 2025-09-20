/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.left==null&&temp.right==null)   continue;
                int left=0;
                int right=0;
                if(temp.left!=null)  {
                    left=temp.left.data;
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    right=temp.right.data;
                    queue.add(temp.right);
                }
                 
                if(left+right!=temp.data)    return false;
            }
        }
        return true;
    } 

}