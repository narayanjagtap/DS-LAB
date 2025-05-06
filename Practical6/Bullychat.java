import java.util.ArrayList;
import java.util.List;

class Node {
    private final int nodeId;
    private boolean isCoordinator;
    private final List<Node> nodes;

    public Node(int nodeId) {
        this.nodeId = nodeId;
        this.isCoordinator = false;
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void startElection() {
        System.out.println("Node " + nodeId + " initiates election.");
        boolean higherNodeIdExists = false;

        // Check if there's a higher node ID
        for (Node node : nodes) {
            if (node.getNodeId() > nodeId) {
                higherNodeIdExists = true;
                System.out.println("Node " + node.getNodeId() + " is asked for election.");
                node.respondToElection();
            }
        }

        // If no higher node exists, declare self as coordinator
        if (!higherNodeIdExists) {
            isCoordinator = true;
            System.out.println("Node " + nodeId + " becomes the coordinator.");
            informOtherNodes();
        }
    }

    public void respondToElection() {
        System.out.println("Node " + nodeId + " responds to the election.");
        informOtherNodes();
    }

    private void informOtherNodes() {
        for (Node node : nodes) {
            if (node.getNodeId() != nodeId) {
                node.updateCoordinatorStatus(isCoordinator);
            }
        }
    }

    public void updateCoordinatorStatus(boolean isCoordinator) {
        this.isCoordinator = isCoordinator;
    }

    public int getNodeId() {
        return nodeId;
    }

    public boolean isCoordinator() {
        return isCoordinator;
    }
}

public class BullyAlgorithm {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Setting up the network
        node1.addNode(node2);
        node1.addNode(node3);
        node1.addNode(node4);

        node2.addNode(node3);
        node2.addNode(node4);

        node3.addNode(node4);

        // Initiating election from node 1
        node1.startElection();

        // Check the coordinator
        System.out.println("Coordinator: Node " + getCoordinatorNodeId(node1, node2, node3, node4));
    }

    private static int getCoordinatorNodeId(Node... nodes) {
        for (Node node : nodes) {
            if (node.isCoordinator()) {
                return node.getNodeId();
            }
        }
        return -1; // No coordinator found
    }
}
