import java.util.List;
import java.util.ArrayList;

class Node{
    private boolean isCoordinator;
    private int nodeId;
    public Node(int nodeId){
        this.nodeId=nodeId;
        isCoordinator=false;
    } 
    public int getId(){
        return this.nodeId;
    }
    public boolean isCoordinator(){
        return isCoordinator;
    }
    public void setCoordinator(boolean val){
        this.isCoordinator=val;
    }
    public void becomeCoordinator() {
        System.out.println("Node " + nodeId + " becomes the coordinator.");
        this.isCoordinator = true;
    }
    public void initiatElection(List<Node> nodes){
        for(Node node:nodes){
            if(node.getId()>this.nodeId){
                node.recieveElectionNotice(this);
            }
        }
        becomeCoordinator();
    }
    public void recieveElectionNotice(Node node){
        if (this.nodeId > node.getId()) {
            node.result(this);
        }
    }

    public void result(Node node){
        System.out.println("Node " + nodeId + " receives response from Node " + node.getId());
    }

}

public class Bully{
    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        node2.setCoordinator(false);
        node2.initiatElection(nodes);
    }
}