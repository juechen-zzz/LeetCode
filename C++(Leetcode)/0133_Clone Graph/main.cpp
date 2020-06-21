//
//  main.cpp
//  0133_Clone Graph
//
//  Created by 倪浩鹏 on 2020/6/21.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    克隆图
 */

/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    map<Node*, Node*> search;
    Node* cloneGraph(Node* node) {
        if (node == NULL){return nullptr;}
        //当发现这个节点已经遍历了,就直接返回当前节点，加入到当前节点的边
        if (search.count(node)){return search[node];}
        Node* r = new Node(node->val);//发现没有遍历以后visit=1
        search[node] = r;//new出来的是一个指针，但是不用打星号
        //否则没有遍历到的话,创建这个节点，并返回该节点，继续dfs原node
        for (auto n : node->neighbors) {
            r->neighbors.push_back(cloneGraph(n));
        }
        return r;
    }
};
