/* 
给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。



注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。



示例 1：

输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
解释：
条件：a / b = 2.0, b / c = 3.0
问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
示例 2：

输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
输出：[3.75000,0.40000,5.00000,0.20000]
示例 3：

输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
输出：[0.50000,2.00000,-1.00000,-1.00000]

 */

// BFS
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int stringNum = 0;
        Map<String, Integer> variables = new HashMap<>();

        // 首先需要遍历 equations 数组，找出其中所有不同的字符串，并通过哈希表将每个不同的字符串映射成整数。
        int n = equations.size();
        for (int i = 0; i < n; i++){
            if (!variables.containsKey(equations.get(i).get(0))){
                variables.put(equations.get(i).get(0), stringNum++);
            }
            if (!variables.containsKey(equations.get(i).get(1))){
                variables.put(equations.get(i).get(1), stringNum++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[stringNum];
        for (int i = 0; i < stringNum; i++){edges[i] = new ArrayList<Pair>();}
        for (int i = 0; i < n; i++){
            int valA = variables.get(equations.get(i).get(0));
            int vaiB = variables.get(equations.get(i).get(1));
            edges[valA].add(new Pair(vaiB, values[i]));
            edges[vaiB].add(new Pair(valA, 1.0 / values[i]));
        }

        // BFS
        int queriesCount = queries.size();
        double[] ans = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++){
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))){
                int A = variables.get(query.get(0)), B = variables.get(query.get(1));
                if (A == B){result = 1.0;}
                else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(A);
                    double[] ratios = new double[stringNum];
                    Arrays.fill(ratios, -1.0);
                    ratios[A] = 1.0;

                    while (!points.isEmpty() && ratios[B] < 0){
                        int x = points.poll();
                        for (Pair pair : edges[x]){
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0){
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[B];
                }
            }
            ans[i] = result;
        }
        return ans;
    }
}

class Pair {
    int index;
    double value;
    Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }
}