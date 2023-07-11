package org.zch.algorithm.graph.BFS;

import java.util.*;

public class 单词演变_108 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<Integer, Set<Character>> idxMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                Set<Character> cSet = idxMap.getOrDefault(i, new HashSet<>());
                cSet.add(word.charAt(i));
                idxMap.put(i, cSet);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int depth = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                String word = queue.poll();

                if (endWord.equals(word)) {
                    return depth;
                }

                for (int j = 0; j < word.length(); j++) {
                    Set<Character> set = idxMap.get(j);
                    for (Character character : set) {
                        String newWord;
                        if (j > 0) {
                            newWord  = word.substring(0, j) + character + word.substring(j + 1);
                        } else {
                            newWord = character + word.substring(j + 1);
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            depth++;
        }
        return 0;
    }

    public static void main(String[] args) {
        单词演变_108 test = new 单词演变_108();
        test.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

}
