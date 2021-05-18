package wearableDevices.classes;

public class Index<K extends Comparable<K>> {
    private Node<K> root;

    public Index() {
        root = null;
    }

    //COMPLETELY CHANGE THIS
    //todo check data and position variable placing
    public void put(K data, int position) {
        if (root == null) {
            root = new Node<>(data, position);
            return;
        }
        Node<K> p = root;
        while (true) {
            if (data.compareTo(p.data) < 0) {
                if (p.left == null) {
                    p.left = new Node<>(data, position);
                    return;
                } else
                    p = p.left;
            } else if (data.compareTo(p.data) > 0) {
                if (p.right == null) {
                    p.right = new Node<>(data, position);
                    return;
                } else
                    p = p.right;
            } else { // k already in the tree, update its value
                p.position = position;
                return;
            }
        }
    }

    public int get(K data) {
        if (root == null) {
            return -1;
        }
        Node<K> p = root;
        while (true) {
            if (data.compareTo(p.data) < 0) {
                if (p.left == null) {
                    return -1;
                } else
                    p = p.left;
            } else if (data.compareTo(p.data) > 0) {
                if (p.right == null) {
                    return -1;
                } else
                    p = p.right;
            } else { // the corresponding position for the data is found and returned
                return p.position;
            }
        }
    }

    public int[] getPositionData() {
        int[] posList = new int[1000];
        Node<K> current;
        Node<K> previous;
        int currentIndex = 0;
        if (root == null) {
            return new int[0];
        }

        current = root;
        while (current != null) {
            if (current.left == null) {
                posList[currentIndex] = current.position;
                currentIndex++;
                current = current.right;
            } else {
                previous = current.left;
                while (previous.right != null && previous.right != current) {
                    previous = previous.right;
                }

                if (previous.right == null) {
                    previous.right = current;
                    current = current.left;
                } else {
                    previous.right = null;
                    posList[currentIndex] = current.position;
                    currentIndex++;
                    current = current.right;
                }
            }
        }
        return posList;
    }

    private static class Node<K> {
        public K data;
        public int position;
        public Node<K> left;
        public Node<K> right;
        public DupNode same;

        public Node(K data, int position) {
            this.data = data;
            this.position = position;
        }
    }

    private static class DupNode {
        public int position;
        public DupNode same;

        public DupNode(int position) {
            this.position = position;
        }
    }
}
