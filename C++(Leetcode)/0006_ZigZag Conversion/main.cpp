//
//  main.cpp
//  0006_ZigZag Conversion
//
//  Created by 倪浩鹏 on 2020/3/16.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */


#include <iostream>

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1) return s;
        vector<string> rows(numRows, "");
        int row = 0;
        bool inc = true;
        for (int i = 0; i < s.size(); i++){
            rows[row].push_back(s[i]);
            if (inc){
                row++;
                if (row == numRows){            // 当已经到最后一行，上一步还加了1
                    row -= 2;
                    inc = false;
                }
            }
            else{
                row--;
                if (row == -1){                 // 当已经到第一行，上一步还减了1
                    row += 2;
                    inc = true;
                }
            }
        }
        string ans;
        for (auto str:rows){ans += str;}
        return ans;
    }
};

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
