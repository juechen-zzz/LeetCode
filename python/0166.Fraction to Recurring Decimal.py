'''
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
'''


class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        if not numerator:
            return '0'
        
        fuhao=''
        if numerator<0 and denominator<0:
            numerator*=(-1)
            denominator*=(-1)
        elif numerator<0:
            fuhao+='-'
            numerator*=(-1)
        elif denominator<0:
            fuhao+='-'
            denominator*=(-1)
        
        zhengshu=str(numerator//denominator)

        yushu=numerator%denominator

        if not yushu:
            return(fuhao+str(zhengshu))

        dic={}
        xiaoshu=''
        index=0

        while True:
            if yushu in dic:
                return(fuhao+zhengshu+'.'+xiaoshu[:dic[yushu]]+'('+xiaoshu[dic[yushu]:]+')')

            dic[yushu]=index
            yushu*=10
            if yushu//denominator>=1:
                xiaoshu+=str(yushu//denominator)
                yushu%=denominator
            else:
                xiaoshu+='0' 

            if yushu==0:
                return(fuhao+zhengshu+'.'+xiaoshu)

            index+=1