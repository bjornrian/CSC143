package wearableDevices.classes;

/**
 * This class represents a tree map that has a root node that has pointers to three
 * different nodes: a left Node object, a right Node object, and a same DupNode
 * object. The pointers for the left and right nodes continue on to other Node
 * objects, but the pointer to the DupNode object points to a simpler type of node
 * that only holds one pointer and position data.
 *
 * @param <K> Key type for tree
 */
public class Index<K extends Comparable<K>> {
    private Node<K> root;
    private int indexSize;
    private int[] positionList;
    private int positionListIndex;

    /**
     * Constructor just creates the tree and points the root to null
     */
    public Index() {
        root = null;
    }

    /**
     * This put method takes a key value and position data and calls
     * the other recursive put method with the start node as root.
     *
     * @param data     key value
     * @param position index in master wearable list
     */
    public void put(K data, int position) {
        root = put(data, position, root);
    }

    /**
     * This put method will look at a starting node and place the data and
     * position value into a new node at that starting position if the
     * position points to null. If the starting node has data, the input data
     * and the data in the starting node will be compared so that the method
     * knows which node to navigate to.
     *
     * @param data      key value
     * @param position  index in master wearable list
     * @param startNode start node allows method to be recursive
     * @return node that next method call will start with
     */
    public Node<K> put(K data, int position, Node<K> startNode) {
        if (startNode == null) {
            startNode = new Node<>(data, position);
            indexSize++;
        } else if (data.compareTo(startNode.data) < 0) {
            startNode.left = put(data, position, startNode.left);
        } else {
            startNode.right = put(data, position, startNode.right);
        }
        return startNode;
    }

    /**
     * This get method calls the recursive get method with a key value
     * and the root as a starting node.
     *
     * @param data key value
     * @return index of key value in master wearable array
     */
    public int get(K data) {
        return get(data, root);
    }

    /**
     * This get method takes a key value and a starting node, and
     * traverses the tree to find the matching position data for
     * the key. If the key is not found, "-1" will be returned to
     * indicate that no position data is associated with that key
     * value.
     *
     * @param data      key value
     * @param startNode node being compared
     * @return -1 for fail, position data for success, recursive
     * get method call for further searching
     */
    public int get(K data, Node<K> startNode) {
        if (startNode == null) {
            return -1;
        }
        if (startNode.data == data) {
            return startNode.position;
        } else if (data.compareTo(startNode.data) < 0) {
            return get(data, startNode.left);
        } else {
            return get(data, startNode.right);
        }
    }

    /**
     * This get position data method retrieves all of the position
     * data in order from the index tree. This means that the positions
     * will be returned in an array, and their order depends on their
     * keys which will be in ascending order.
     *
     * @return integer array of position data
     */
    public int[] getPositionData() {
        positionListIndex = 0;
        positionList = new int[indexSize];
        collectPositionData(root);
        return positionList;
    }

    /**
     * This recursive collect position data method adds to a position list
     * that the Index object has. For each recursive call, the method is called
     * again with the left pointer of the start node, the start node position
     * is added, and the method is called again with the right pointer of the
     * start node. This leads to the tree being traversed "in order" (based on
     * the keys).
     *
     * @param startNode the node who's position data is being added.
     */
    public void collectPositionData(Node<K> startNode) {
        if (startNode == null) {
            return;
        }
        collectPositionData(startNode.left);
        positionList[positionListIndex] = startNode.position;
        positionListIndex++;
        collectPositionData(startNode.right);
    }

    /**
     * This class represents a normal node in the Index tree that has two
     * data points and three pointers to other nodes.
     *
     * @param <K> node key type
     */
    private static class Node<K> {
        public K data;
        public int position;
        public Node<K> left;
        public Node<K> right;
        public DupNode same;

        /**
         * Node constructor takes in a key and integer position and stores
         * it in the node object.
         *
         * @param data key value
         * @param position index for key data in master wearable array
         */
        public Node(K data, int position) {
            this.data = data;
            this.position = position;
        }
    }

    /**
     * This class represents a simpler type of node that only points to another
     * DupNode object, and it just holds position data. This is useful for
     * duplicate data that is being used for keys as the index class represents
     * a tree that is related to binary search trees.
     */
    private static class DupNode {
        public int position;
        public DupNode same;

        /**
         * Constructor just takes a position data point and stores it in the
         * DupNode object.
         *
         * @param position index for key data in master wearable array
         */
        public DupNode(int position) {
            this.position = position;
        }
    }
}
