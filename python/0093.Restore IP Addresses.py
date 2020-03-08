'''
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
'''

class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        self.res=[]
        ip=''
        self.dfs(s, 0, ip)
        return self.res
        
    def dfs(self, string, level, ip):
        # print(level)
        if level==4:
            if len(string)==0:
                self.res.append(ip)
                return
            else:
                return
        
        # check the length of the fourth segment
        right=min(len(string), 3)
        
        for j in range(1, right+1):
            if self.isValid(string[:j]):
                
                # check whether we need to add '.'
                if level<3:
                    copy=ip+string[:j]+'.'
                elif level==3:
                    copy=ip+string[:j]

                self.dfs(string[j:], level+1, copy)
 
    def isValid(self, string):
        if (len(string)>1 and string[0]=='0') or len(string)>3 or len(string)==0: 
        	return False
        else:
            return 0<=int(string)<=255