import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Node{
    char data;
    Node left, right;

    public Node(char data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        Node root = new Node('*');
        root.left = new Node('+');
        root.right = new Node('/');
        root.left.left = new Node('A');
        root.left.right = new Node('B');
        root.right.left = new Node('C');
        root.right.right = new Node('D');

        System.out.println("=== 트리 순회 결과 ===");

        System.out.print("전위 순회 (Pre-order) : ");
        preOrder(root);
        // 출력: * + A B / C D (루트가 맨 앞)
        System.out.println();

        System.out.print("중위 순회 (In-order)  : ");
        inOrder(root);
        // 출력: A + B * C / D (우리가 아는 수식 형태)
        System.out.println();

        System.out.print("후위 순회 (Post-order) : ");
        postOrder(root);
        // 출력: A B + C D / * (컴파일러/계산기 방식)
        System.out.println();
    }

    public static void preOrder(Node node){
        if(node==null)
            return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }
}