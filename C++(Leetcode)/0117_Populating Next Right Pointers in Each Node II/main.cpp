//
//  main.cpp
//  0117_Populating Next Right Pointers in Each Node II
//
//  Created by 倪浩鹏 on 2020/6/10.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    同上一题，只是不一定为完美二叉树
 */

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        Node *ans;
        if (root == NULL) {return ans;}
        queue<Node*> Q;
        Q.push(root);
        while (!Q.empty()){
            int n = Q.size();
            while (n > 0){
                ans = Q.front();
                Q.pop();
                ans->next = Q.front();
                if (ans->left) {Q.push(ans->left);}
                if (ans->right) {Q.push(ans->right);}
                n--;
            }
            ans->next = NULL;
        }
        return root;
    }
};
