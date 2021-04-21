/* 
给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。一组重复的文件至少包括二个具有完全相同内容的文件。

输入列表中的单个目录信息字符串的格式如下：

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

这意味着有 n 个文件（f1.txt, f2.txt ... fn.txt 的内容分别是 f1_content, f2_content ... fn_content）在目录 root/d1/d2/.../dm 下。注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。

该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串：

"directory_path/file_name.txt"

示例 1：

输入：
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
输出：  
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

 */

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] values = s.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] contents = values[i].split("\\(");
                contents[1] = contents[1].replace(")", "");

                List<String> list = map.getOrDefault(contents[1], new ArrayList<String>());
                list.add(values[0] + "/" + contents[0]);
                map.put(contents[1], list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (String k : map.keySet()) {
            if (map.get(k).size() > 1) {
                ans.add(map.get(k));
            }
        }

        return ans;
    }
}