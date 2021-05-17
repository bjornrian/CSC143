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

    //display node position data with in-order method
//    public int[] getPositionData() {
//        int[] posList = new int[100];
//        if (root == null) {
//            return new int[0];
//        }
//        Node<K> p = root;
//
//        while (p != null) {
//            while (p.left != null) {
//                p = p.left;
//            }
//            System.out.print(p.data + " ");
//            p = p.right;
//        }
//        return posList;
//    }

    public int[] getPositionData() {
        int[] posList = new int[100];
        Node<K> current = root;
        Node<K> pre;

        if (root == null) {
            return new int[0];
        }
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + " ");
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
