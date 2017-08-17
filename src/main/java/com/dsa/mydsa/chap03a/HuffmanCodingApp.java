package com.dsa.mydsa.chap03a;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhibo on 17-5-29.
 */
class HuffmanNode {
    private int weight;
    private boolean isUsed;
    private int parent;
    private int leftchild;

    public HuffmanNode(int weight) {
        this.weight = weight;
        this.setRighttchild(-1);
        this.setLeftchild(-1);
        this.setParent(-1);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(int leftchild) {
        this.leftchild = leftchild;
    }

    public int getRighttchild() {
        return righttchild;
    }

    public void setRighttchild(int righttchild) {
        this.righttchild = righttchild;
    }

    private int righttchild;
}

class HuffmanTree {
    private Map<Character, Integer> charcount = new HashMap<>();
    private HuffmanNode[] HuffmanTreeArray;
    private int size;
    private char[] chars;

    HuffmanTree(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charcount.containsKey(c)) {
                int t = charcount.get(c) + 1;
                charcount.put(c, t);
            } else {
                charcount.put(c, 1);
            }
        }
    }

    private int cursor;

    private void fillLeafNode() {
        size = 2 * charcount.size() - 1;
        HuffmanTreeArray = new HuffmanNode[size];
        int i = 0;
        chars = new char[charcount.size()];
        for (Map.Entry<Character, Integer> entry : charcount.entrySet()) {

//            System.out.println("Key = " + entry.getKey() + "  Value = " + entry.getValue());
            HuffmanTreeArray[i] = new HuffmanNode(entry.getValue());
            chars[i] = entry.getKey();
            i++;
        }
        cursor = i;
    }

    private void fillAnotherNode() {
        for (int i = cursor; i < size; i++) {
            int minindex1 = findMin();
            int minindex2 = findMin();
            int t = HuffmanTreeArray[minindex1].getWeight() + HuffmanTreeArray[minindex2].getWeight();
            HuffmanTreeArray[i] = new HuffmanNode(t);
            HuffmanTreeArray[i].setLeftchild(minindex1);
            HuffmanTreeArray[i].setRighttchild(minindex2);
            HuffmanTreeArray[minindex1].setParent(i);
            HuffmanTreeArray[minindex2].setParent(i);
        }

    }

    private int findMin() {
        int min = -1;
        int minindex = -1;
        for (int i = 0; i < HuffmanTreeArray.length; i++) {
            if ((HuffmanTreeArray[i] != null) && (!HuffmanTreeArray[i].isUsed())) {
                int w = HuffmanTreeArray[i].getWeight();
                if ((min == -1) || (min > w)) {
                    min = w;
                    minindex = i;
                }
            }

        }
        if (minindex != -1) {
            HuffmanTreeArray[minindex].setUsed(true);
        }
        return minindex;
    }

    public Map<Character, String> huffmCoding() {
        Map<Character, String> result = new HashMap<>();
        fillLeafNode();
        fillAnotherNode();
        for (int j = 0; j < charcount.size(); j++) {
            StringBuilder sb = new StringBuilder();
            int cur = j;
            int pre = HuffmanTreeArray[j].getParent();
//            while (pre < HuffmanTreeArray.length) {
            while (pre != -1) {
                int l = HuffmanTreeArray[pre].getLeftchild();
                if (l == cur) {
                    sb.insert(0, 0);
                } else {
                    sb.insert(0, 1);
                }
                cur = pre;
                pre = HuffmanTreeArray[cur].getParent();
            }
            result.put(chars[j], sb.toString());

        }
        return result;
    }
}

public class HuffmanCodingApp {
    public static void main(String[] args) {
//        String str = "It is also committed to working with these countries to maintain peace and stability in the East " +
//                "and South China seas and freedom of navigation and overflight in these regions, " +
//                "as well as the safety of regional seaways, he said.";
//        String str = "SUSIE SAYS IT IS EASY";
        String str = "AABC";
        HuffmanTree ht = new HuffmanTree(str);
        Map<Character, String> codingmap = ht.huffmCoding();

        for (Map.Entry<Character, String> entry :
                codingmap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + "  Value = " + entry.getValue());
        }

    }



}

