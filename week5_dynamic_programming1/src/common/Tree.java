package common;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree<T> {

    T data;
    Tree<T> parent;
    List<Tree<T>> children;
    public int level = 0;

    public Tree(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public Tree<T> addChild(T child) {
        Tree<T> childNode = new Tree<T>(child);
        childNode.parent = this;
        childNode.level = this.level + 1;
        this.children.add(childNode);
        return childNode;
    }

    public List<T> getDataPath() {
        Tree tree = this;
        List<T> data = new ArrayList<>();
        while (!tree.isRoot()) {
            data.add((T) tree.data);
            tree = tree.parent;
        }
        Collections.reverse(data);
        return data;
    }
}

