package com.company;

public class Tree {

    private Node root = null;

    public Tree() {

    }

    public boolean addValue(int value){

        if (root == null){
            root = new Node(value);
            return true;
        } else {
            return root.addValue(value);
        }
    }

    public boolean removeValue(int value){

        if (root == null){
            return false;
        } else if (root.getValue() == value && root.getNumberOfChildNodes() == 0){
            root = null;
            return true;
        } else {
            return root.removeValue(value);
        }
    }

    public boolean containsValue(int value){

        return root == null ? false : root.containsValue(value);
    }
}
