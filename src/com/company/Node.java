package com.company;

public class Node {

    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean addValue(int value){

        if (this.value > value){
            if (leftChild == null){
                leftChild = new Node(value);
                return true;
            } else {
                return leftChild.addValue(value);
            }
        } else if (this.value < value){
            if (rightChild == null){
                rightChild = new Node(value);
                return true;
            } else {
                return rightChild.addValue(value);
            }
        } else {
            return false;
        }
    }

    public boolean containsValue(int value){

        if (this.value > value){
            return leftChild  == null ? false : leftChild.containsValue(value);
        } else if (this.value < value){
            return rightChild == null ? false : rightChild.containsValue(value);
        } else {
            return true;
        }
    }

    public int getNumberOfChildNodes(){

        int numberOfChildNodes = 0;
        if (leftChild != null){
            numberOfChildNodes++;
        }
        if (rightChild != null){
            numberOfChildNodes++;
        }
        return  numberOfChildNodes;
    }

    private int subtreeMaximum(){
        return rightChild == null ? value : rightChild.subtreeMaximum();
    }

    public boolean removeValue(int value){

        if (this.value > value){
            if (leftChild == null){
                return false;
            }else if (leftChild.value == value && leftChild.getNumberOfChildNodes() == 0){
                leftChild = null;
            } else {
                return rightChild.removeValue(value);
            }
        } else {
            if (leftChild == null && rightChild != null){
                this.value = rightChild.value;
                leftChild = rightChild.leftChild;
                rightChild = rightChild.rightChild;
                return true;
            } else if (leftChild != null && rightChild == null){
                this.value = leftChild.value;
                leftChild = leftChild.leftChild;
                rightChild = rightChild.rightChild;
                return true;
            } else if (leftChild != null && rightChild != null){
                if (leftChild.getNumberOfChildNodes() == 0){
                    this.value = leftChild.value;
                    leftChild = null;
                }else {
                    int replacementValue = leftChild.subtreeMaximum();
                    this.value = replacementValue;
                    leftChild.removeValue(replacementValue);
                }
                return true;
            } else {
                throw new UnsupportedOpzerationException("Node cannot delete itself!");
            }
        }
        return false;
    }
}
