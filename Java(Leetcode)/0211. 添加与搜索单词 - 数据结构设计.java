/* 
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 

示例：

输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

 */

class WordDictionary {
    HashMap<Integer, HashSet<String>> map;

    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int n = word.length();
        //将字符串加入对应长度的 set 中
        if (map.containsKey(n)) {
            HashSet<String> set = map.get(n);
            set.add(word);
        } else {
            HashSet<String> set = new HashSet<String>();
            set.add(word);
            map.put(n, set);
        }
    }

    /**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
    public boolean search(String word) {
        int n = word.length();
        if (!map.containsKey(n)) {return false;}
        HashSet<String> wordList = map.get(n);
        for (String s : wordList) {
            if (equal(s, word)) {return true;}
        }
        return false;
    }

    private boolean equal(String s, String word) {
        char[] c1 = s.toCharArray();
        char[] c2 = word.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (c1[i] != c2[i] && c2[i] != '.') {
                return false;
            }
        }
        return true;
    }
}
