'''
Z字型读取
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
'''
def convert(self, s, numRows):
    """
    :type s: str
    :type numRows: int
    :rtype: str
    """
    zigzag = ''
    if numRows == 1 or numRows == 0 or numRows >= len(s):
        return s
    space = 2 * numRows - 2
    for i in range(1, numRows + 1):
        n = 0
        if i == 1 or i == numRows:
            while i + n * space <= len(s):
                zigzag += s[i + n * space - 1]
                n += 1
        else:
            while i + n * space <= len(s):
                zigzag += s[i + n * space - 1]
                if (2 * numRows - i) + (n * space) <= len(s):
                    zigzag += s[(2 * numRows - i) + (n * space) - 1]
                n += 1
    return zigzag

