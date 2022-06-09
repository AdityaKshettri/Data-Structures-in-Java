package com.aditya.project.miscellaneous;

import java.util.HashMap;
import java.util.Map;

// TC : O(1)
public class LFUCache {

    final int capacity;
    int currSize;
    int minFreq;
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            update(node);
        } else {
            currSize++;
            if (currSize > capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
                currSize--;
            }
            minFreq = 1;
            Node node = new Node(key, value);
            DoublyLinkedList currList = freqMap.getOrDefault(1, new DoublyLinkedList());
            currList.add(node);
            freqMap.put(1, currList);
            cache.put(key, node);
        }
    }

    private void update(Node node) {
        int currFreq = node.freq;
        DoublyLinkedList currList = freqMap.get(currFreq);
        currList.remove(node);
        if (currFreq == minFreq && currList.size == 0) {
            minFreq++;
        }
        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }

    static class Node {

        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    static class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            this.size = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            Node next = head.next;
            node.next = next;
            node.prev = head;
            head.next = node;
            next.prev = node;
            size++;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }
    }
}
