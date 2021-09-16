package algorithm.practice;

import java.util.*;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.putKey("k1", 1);
        cache.putKey("k2", 2);
        cache.putKey("k3", 3);
        cache.putKey("k4", 4);
        cache.putKey("k5", 5);
        cache.getKey("k1");
        cache.putKey("k6", 6);
        cache.getKey("k2");
        cache.getKey("k3");
        cache.getKey("k2");
        cache.getKey("k3");
        cache.getKey("k5");
        cache.getKey("k5");
        cache.getKey("k2");
        cache.getKey("k1");
        cache.putKey("k6", 7);
        cache.putKey("k6", 8);
        cache.getKey("k1");

        cache.printElements();
    }
}

class LRUCache {
    private LinkedList<CacheNode> cacheNodes;
    private HashSet<String> keys;
    private int size;
    public LRUCache(int size) {
        cacheNodes = new LinkedList<>();
        keys = new HashSet<>();
        this.size = size;
    }

    public void putKey(String key, int newValue) {
        CacheNode node = new CacheNode(key, newValue);
        if (keys.contains(key)) {
            removeNode(key);
            cacheNodes.addLast(node);
        } else {
            if (size == cacheNodes.size()) {
                CacheNode evictedNode = cacheNodes.pollFirst();
                keys.remove(evictedNode.getKey());
            }
            cacheNodes.addLast(node);
            keys.add(key);
        }
    }

    private void removeNode(String key) {
        for (CacheNode node : cacheNodes) {
            if (node.getKey().equals(key)) {
                cacheNodes.remove(node);
                return;
            }
        }
    }

    public int getKey(String key) {
        if (keys.contains(key)) {
            for (CacheNode each : cacheNodes) {
                if (each.getKey() == key) {
                    cacheNodes.remove(each);
                    cacheNodes.addLast(each);
                    return each.getData();
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    public void printElements() {
        for (CacheNode node : cacheNodes) {
            System.out.println("Key: " + node.getKey() + " Value: " + node.getData());
        }
    }
}

class CacheNode implements Comparable<CacheNode>, Comparator<CacheNode> {
    private int data;
    private String key;

    public CacheNode(String newKey, int newData) {
        this.data = newData;
        this.key = newKey;
    }

    public int getData() {
        return data;
    }

    public String getKey() {
        return key;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int compareTo(CacheNode o) {
        return this.data == o.data && this.key.equals(o.key) ? 0 : this.data - o.data;
    }

    @Override
    public int compare(CacheNode o1, CacheNode o2) {
        return o1.key == o2.key ? 0 : 1;
    }
}