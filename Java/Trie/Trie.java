package Trie;

import java.util.*;

// https://leetcode.com/problems/implement-trie-prefix-tree/
class TrieNode{
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLastChar;

    Map<Character, TrieNode> getChildNodes(){
        return this.childNodes;
    }

    boolean isLastChar(){
        return this.isLastChar;
    }

    void setIsLastChar(boolean isLastChar){
        this.isLastChar = isLastChar;
    }
}

public class Trie {

    private TrieNode rootNode;

    public Trie(){
        rootNode = new TrieNode();
    }

    public void insert(String word){
        TrieNode thisNode = this.rootNode;
        for(int i=0; i<word.length(); i++){
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c->new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

    public boolean search(String word){
        TrieNode thisNode = this.rootNode;
        for(int i=0; i<word.length(); i++){
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);

            if(node == null) return false;

            thisNode = node;
        }
        return thisNode.isLastChar();
    }

    public boolean startsWith(String prefix){
        TrieNode thisNode = this.rootNode;
        for(int i=0; i<prefix.length(); i++){
            char character = prefix.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(character);

            if(node == null) return false;

            thisNode = node;
        }
        return true;
    }
}
