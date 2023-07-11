package org.zch.algorithm.test;

import com.sun.tools.javac.util.Pair;
import utils.Print;

import java.util.*;

public class Test {
    public boolean field;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int matrixSum(int[][] nums) {
        int sum = 0;
        int m = nums.length, n = nums[0].length;

        for (int[] num : nums) {
            Arrays.sort(num);
        }

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, nums[j][i]);
            }
            sum += max;
        }

        return sum;
    }
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            char peek = s.charAt(stack.peek());
            if (peek == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        int max = 0;
        int right = s.length();
        while (!stack.isEmpty()) {
            int left = stack.pop();
            max = Math.max(max, right - left);
            right = left;
        }
        max = Math.max(max, right);
        return max;
    }


    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Pair<Integer, Integer>[][] dp = new Pair[m][n];

        dp[0][0] = matrix[0][0] == '1' ? Pair.of(1, 1) : Pair.of(0, 0);
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? Pair.of(1, dp[i - 1][0].snd + 1) : Pair.of(0, 0);
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? Pair.of(dp[0][j - 1].fst + 1, 1) : Pair.of(0, 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = Pair.of(0, 0);
                } else {
                    int s1 = (Math.min(dp[i - 1][j].fst - 1, dp[i][j - 1].fst) + 1) * (dp[i - 1][j].snd + 1);
                    int s2 = (dp[i][j - 1].fst + 1) * (Math.min(dp[i][j - 1].snd - 1, dp[i - 1][j].snd) + 1);
                    if (s1 > s2) {
                        dp[i][j] = Pair.of(Math.min(dp[i - 1][j].fst - 1, dp[i][j - 1].fst) + 1, dp[i - 1][j].snd + 1);
                    } else {
                        dp[i][j] = Pair.of(dp[i][j - 1].fst + 1, Math.min(dp[i][j - 1].snd - 1, dp[i - 1][j].snd) + 1);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dp[i][j].fst * dp[i][j].snd, max);
            }
        }
        return max;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                dfs(i, j, grid, visited);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(i + 1, j, grid, visited);
        dfs(i - 1, j, grid, visited);
        dfs(i, j + 1, grid, visited);
        dfs(i, j - 1, grid, visited);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        int leftLen = rootIdx - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inStart, rootIdx - 1);
        root.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, rootIdx + 1, inEnd);
        return root;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (target.equals(cur)) {
                    return depth;
                }
                if (Arrays.asList(deadends).contains(cur)) {
                    continue;
                }
                if (!visited.add(cur)) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    String p = plus(cur, j);
                    queue.offer(p);
                    String m = minus(cur, j);
                    queue.offer(m);
                }
            }
            depth++;
        }
        return -1;
    }

    private String plus(String cur, int idx) {
        char[] arr = cur.toCharArray();
        char c = arr[idx];
        arr[idx] = c == '9' ? '0' : (char) (c + 1);

        return new String(arr);
    }

    private String minus(String cur, int idx) {
        char[] arr = cur.toCharArray();
        char c = arr[idx];
        arr[idx] = c == '0' ? '9' : (char) (c - 1);

        return new String(arr);
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        Map<ListNode, Integer> map = new HashMap<>();
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        int len = 0;
        while (p != null) {

            while (!stack.isEmpty() && stack.peek().val < p.val) {
                map.put(stack.pop(), p.val);
            }

            stack.push(p);
            p = p.next;
            len++;
        }

        int[] res = new int[len];
        p = head;
        int i = 0;
        while (p != null) {
            res[i] = map.getOrDefault(p, 0);
            i++;
            p = p.next;
        }

        return res;
    }

    boolean[] visited;
    boolean[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < graph.length; i++) {
            if (!traverse(graph, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean traverse(List<Integer>[] graph, int idx) {
        if (onPath[idx]) {
            return false;
        }
        if (visited[idx]) {
            return true;
        }

        visited[idx] = true;
        onPath[idx] = true;
        for (Integer point : graph[idx]) {
            if (traverse(graph, point)) {
                return false;
            }
        }
        onPath[idx] = false;
        return true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] site : prerequisites) {
            graph[site[0]].add(site[1]);
        }
        return graph;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int k = i, j = 0;
            while (j < needle.length() && k < haystack.length()) {
                if (haystack.charAt(k++) == needle.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            int i = 0, j = 0;
            boolean match = true;
            while (i < query.length() && j < pattern.length()) {
                char q = query.charAt(i);
                char p = pattern.charAt(j);

                if (q == p) {
                    i++;
                    j++;
                } else if (isBig(q)) {
                    match = false;
                    break;
                } else if (!isBig(q) && isBig(p)) {
                    i++;
                } else {
                    i++;
                }
            }

            if (!match || j < pattern.length()) {
                res.add(match);
                continue;
            }
            while (i < query.length()) {
                if (isBig(query.charAt(i++))) {
                    match = false;
                }
            }
            res.add(match);
        }
        return res;
    }

    private boolean isBig(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int plus = 0;
                if (check(s, i, j)) {
                    plus = 1;
                }
                dp[i][j] = dp[i + 1][j] + plus;
            }
        }
        Print.array(dp);
        int sum = 0;
        for (int j = 0; j < len; j++) {
            sum += dp[0][j];
        }
        return sum;

    }

    public boolean check(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = maxDiff(root);
        return res[2];
    }

    private int[] maxDiff(TreeNode root) {
        int[] left = new int[0];
        if (root.left != null) {
            left = maxDiff(root.left);
        }

        int[] right = new int[0];
        if (root.right != null) {
            right = maxDiff(root.right);
        }

        if (left.length == 0 && right.length == 0) {
            return new int[]{root.val, root.val, 0};
        } else if (left.length == 0) {
            int maxDiff = Math.max(Math.abs(root.val - right[0]), Math.abs(root.val - right[1]));
            maxDiff = Math.max(maxDiff, right[2]);
            return new int[]{Math.min(root.val, right[0]), Math.max(root.val, right[1]), maxDiff};
        } else if (right.length == 0) {
            int maxDiff = Math.max(Math.abs(root.val - left[0]), Math.abs(root.val - left[1]));
            maxDiff = Math.max(maxDiff, left[2]);
            return new int[]{Math.min(root.val, left[0]), Math.max(root.val, left[1]), maxDiff};
        } else {
            int min = Math.min(left[0], right[0]);
            min = Math.min(min, root.val);

            int max = Math.max(left[1], right[1]);
            max = Math.max(max, root.val);

            int maxDiff = Math.max(left[2], right[2]);
            maxDiff = Math.max(maxDiff, Math.abs(root.val - min));
            maxDiff = Math.max(maxDiff, Math.abs(root.val - max));
            return new int[]{min, max, maxDiff};
        }
    }


    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (connected(parent, edge[0], edge[1])) {
                return edge;
            }
            connect(parent, edge[0], edge[1]);
        }
        return new int[0];
    }

    private void connect(int[] parent, int p, int q) {
        int rootP = find(parent, p);
        int rootQ = find(parent, q);
        parent[rootP] = rootQ;
    }

    private boolean connected(int[] parent, int p, int q) {
        int rootP = find(parent, p);
        int rootQ = find(parent, q);
        return rootP == rootQ;
    }

    private int find(int[] parent, int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    List<List<Integer>> pathList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return pathList;
    }

    private void backtrack(int[] nums, int idx, List<Integer> path) {
        pathList.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[idx]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            int midRow = (mid - 1) / n;
            int midCol = (mid - 1) % n;
            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            int k = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    k = Math.max(k, dp[j]);
                }
            }
            dp[i] = k + 1;
        }

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        int[] ans = new int[temperatures.length];
        while (i < temperatures.length) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
            i++;
        }
        return ans;
    }


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int fir = booking[0];
            int sec = booking[1];
            int seat = booking[2];

            if (fir - 1 >= 0) {
                diff[fir - 1] += seat;
            }

            if (sec < n) {
                diff[sec] -= seat;
            }
        }

        int[] result = new int[n];
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }

        return result;

    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int current = stack.pop();
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    sum += (i - left - 1) * (Math.min(height[i], height[left]) - height[current]);
                }
            }
            stack.push(i);
        }
        return sum;
    }

    public int maximumSum(int[] arr) {

        int dp0 = arr[0], dp1 = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }

    boolean success = false;
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> path = new ArrayList<>(colsum.length);
        backtrack(0, upper, lower, colsum, 0, 0, path);
        if (success) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(path);
            List<Integer> tmp = new ArrayList<>(path.size());
            for (int i = 0; i < path.size(); i++) {
                tmp.add(colsum[i] - path.get(i));
            }
            res.add(tmp);
            return res;
        }
        return new ArrayList<>(0);
    }

    private void backtrack(int idx, int upper, int lower, int[] colsum, int curUpper, int curLower, List<Integer> path) {
        if (idx == colsum.length && curLower == lower && curUpper == upper) {
            success = true;
            return;
        } else if (idx >= colsum.length) {
            return;
        }

        int[] selected = new int[] {0, 1};
        for (int u : selected) {
            int l = colsum[idx] - u;
            if (l > 1 || l < 0) {
                continue;
            }
            if (curUpper + u <= upper && curLower + l <= lower) {
                path.add(u);
                backtrack(idx + 1, upper, lower, colsum, curUpper + u, curLower + l, path);
                if (success) {
                    return;
                }
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }

        for (int i = 0; i < sentence.length(); i++) {
            char cur = sentence.charAt(i);
            if (cur == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newL1 = reverse(l1);
        ListNode newL2 = reverse(l2);

        ListNode res = null, p = newL1, q = newL2;
        int add = 0;
        while (p != null || q != null) {
            int curP = p == null ? 0 : p.val;
            int curQ = q == null ? 0 : q.val;

            int v = (curQ + curP) % 10 + add;
            add = (curQ + curP) / 10;

            ListNode tmp = new ListNode(v);
            tmp.next = res;
            res = tmp;

            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
        }

        if (add > 0) {
            ListNode tmp = new ListNode(add);
            tmp.next = res;
            res = tmp;
        }

        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null, p = head;
        while (p != null) {
            ListNode next = p.next;

            p.next = newHead;
            newHead = p;

            p = next;
        }
        return newHead;
    }


    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        if (k <= numOnes + numZeros) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);

    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new ArrayList<>(0);
        }
        if (finalSum == 4 || finalSum == 2) {
            return Collections.singletonList(finalSum);
        }

        long max = (long) Math.sqrt(finalSum + 1);
        long n;
        for (long i = max; ; i--) {
            long sum = i * (i + 1);
            if (sum > finalSum) {
                continue;
            }
            if (sum == finalSum) {
                n = i;
                break;
            }
            if ((finalSum - sum) / 2 > i) {
                n = i;
                break;
            }
        }

        List<Long> res = new ArrayList<>();
        for (long i = 1; i <= n; i++) {
            res.add(i * 2);
        }
        if (n * (n + 1) < finalSum) {
            res.add(finalSum - n * (n + 1));
        }
        return res;
    }

    public long maxAlternatingSum(int[] nums) {
        long sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int min = stack.isEmpty() ? 0 : nums[stack.peek()];
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            stack.push(i);
            if (min < nums[i]) {
                sum = sum - min + nums[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Test test = new Test();
        //test.matrixSum(new int[][]{{7,2,1},{6,4,2},{6,5,3},{3,2,1}});

        Integer a = true ? (Integer) null : 1;
    }


}
