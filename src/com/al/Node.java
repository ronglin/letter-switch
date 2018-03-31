package com.al;

public class Node {
    public String word;
    public Node parent;
    public int level;
    public boolean isExpanded;

    public Node(String word) {
        this(word, null);
    }

    public Node(String word, Node parent) {
        this.word = word;
        this.parent = parent;
        if (parent == null) {
            level = 1;
        }
        else
        {
            level = parent.level + 1;
        }
        isExpanded = false;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals (Object obj){
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Node)) {
            return false;
        }
        final Node other = (Node) obj;
        return this.word.equals(other.word);
    }

    public String toString() {
        Node node = this;
        StringBuffer sb = new StringBuffer();
        while(node.parent != null) {
            sb.append(node.word);
            sb.append("->");
            node = node.parent;
        }
        sb.append(node.word);
        sb.append(":");
        sb.append(this.level);
        return sb.toString();
    }
}
