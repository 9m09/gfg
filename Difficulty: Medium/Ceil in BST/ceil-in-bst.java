/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int key) {
        // code here
        if(root==null)  return -1;
        return help(root,key,-1);
    }
    int help(Node root, int key,int pre){
        if(root==null){
            if(pre>key)
            return pre;
            return -1;
        }
        if(key<root.data)   
        pre=root.data;
        if(key<root.data)    return help(root.left,key,pre);
        else if(key>root.data)  return help(root.right,key,pre);
        return key;
    }
}