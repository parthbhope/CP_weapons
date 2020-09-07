package templates;

import java.util.*;

public class Trie {
	class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean isEndOfWord;

		public TrieNode() {
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}

	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i <= word.length(); i++) {
			if (i == word.length())
				currentNode.isEndOfWord = true;
			else
			{
			TrieNode childNode = currentNode.children.get(word.charAt(i));

			if (childNode == null) {
				TrieNode newTrie = new TrieNode();
				currentNode.children.put(word.charAt(i), newTrie);
				currentNode = newTrie;
			}
			else	
				currentNode = childNode;
			}
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode currentNode = root;
		boolean present = true;
		for (int i = 0; i <= word.length(); i++) {
			if (i == word.length())
				return currentNode.isEndOfWord ;

			TrieNode childNode = currentNode.children.get(word.charAt(i));
			if (childNode == null)
				return false;
			currentNode = childNode;
		}
		return present;
	}
	/** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        boolean present = true;
        for(int i=0;i<=prefix.length();i++)
        {
            if(i == prefix.length())
                return currentNode.isEndOfWord || currentNode.children.size() >0;
            TrieNode childNode = currentNode.children.get(prefix.charAt(i));
            if(childNode == null)
                return false;
            currentNode = childNode;
        }
        return present;
    }

	public static void main(String[] args) {
		// TODO implement delete function
		Trie obj = new Trie();
		obj.insert("apple");
		System.out.println(obj.search("apple"));
		System.out.println(obj.startsWith("app"));
		obj.insert("app");
		System.out.println(obj.startsWith("app"));
		System.out.println(obj.startsWith("pa"));

	}

}
