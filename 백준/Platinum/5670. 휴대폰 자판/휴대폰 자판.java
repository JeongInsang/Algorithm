import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
 
public class Main {
    static class TrieNode{
        HashMap<Character, TrieNode> childNodes = new HashMap<>();
        boolean last;
    }
    static class Trie{
        TrieNode rootNode;
        Trie(){
            rootNode=new TrieNode();
        }
 
        void insert(String word) {
            TrieNode currentNode = rootNode;
            for (Character c : word.toCharArray()) {
                currentNode = currentNode.childNodes.computeIfAbsent(c, o -> new TrieNode());
            }
            currentNode.last = true;
        }
 
        double countCheck(String word) {
            TrieNode currentNode = rootNode.childNodes.get(word.charAt(0));
            int answer = 1;
            for (int i = 1; i < word.length(); i++) {
                if (currentNode.childNodes.size() != 1||currentNode.last) {
                    answer++;
                }
                currentNode = currentNode.childNodes.get(word.charAt(i));
            }
            return answer;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input="";
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            Trie trie = new Trie();
            String[] words = new String[n];
            double answer = 0;
 
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
                trie.insert(words[i]);
            }
 
            for (int i = 0; i < n; i++) {
                answer += trie.countCheck(words[i]);
            }
 
            System.out.println(String.format("%.2f", answer / n));
        }
    }
}
 
