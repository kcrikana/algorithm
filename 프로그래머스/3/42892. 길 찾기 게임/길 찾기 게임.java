import java.util.*;
class Solution {
    // x 좌표 겹치지 않음
    // y가 트리 레벨
    ArrayList<Node> nodes = new ArrayList<>();
    int preIdx = 0;
    int postIdx = 0;
    int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        Collections.sort(nodes, (o1, o2) -> (o2.y-o1.y));
        Node root = nodes.get(0);
        for(int i=1; i<nodeinfo.length; i++) offer(root, nodes.get(i));    
        order(root);
        return answer;
    }
    
    void offer(Node parent, Node child) {
        if(child.x < parent.x) {
            if(parent.left == null) parent.left = child;
            else offer(parent.left, child);
        }
        else {
            if(parent.right == null) parent.right = child;
            else offer(parent.right, child);
        }
    }
    
    void order(Node now) {
        answer[0][preIdx++] = now.v;
        if(now.left != null) order(now.left);
        if(now.right != null) order(now.right);
        answer[1][postIdx++] = now.v;
    }
}

class Node {
    int x, y, v;
    Node left, right;
    public Node(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}