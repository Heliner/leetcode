public class Solution208 {
    static class Trie {
        Trie[] suffix;
        boolean isWord;


        public Trie() {
            this.suffix = new Trie[26];
            isWord = false;
        }

        /*补充类的代码*/
        private void set2Word() {
            this.isWord = true;
        }

        private boolean isWord() {
            return this.isWord;
        }

        private boolean containsWord(char ch) {
            return this.suffix[ch - 'a'] != null;
        }

        private void appendWord(char ch) {
            this.suffix[ch - 'a'] = new Trie();
        }

        private Trie getWordSuffix(char ch) {
            return this.suffix[ch - 'a'];
        }

        public void insert(String word) {
            Trie curt = this;
            for (char c : word.toCharArray()) {
                if (!curt.containsWord(c)) {
                    curt.appendWord(c);
                }
                curt = curt.getWordSuffix(c);
            }
            curt.set2Word();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie curt = this;
            for (char c : word.toCharArray()) {
                if (curt.containsWord(c)) {
                    curt = curt.getWordSuffix(c);
                } else {
                    return false;
                }
            }
            return curt.isWord();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie curt = this;
            for (char c : prefix.toCharArray()) {
                if (curt.containsWord(c)) {
                    curt = curt.getWordSuffix(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
