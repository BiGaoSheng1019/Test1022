package com.example.demo.controller;

import sun.util.resources.LocaleData;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * 自己的Map
 * @param <K>
 * @param <V>
 */

public class MyHashMap<K,V> {

    /*定义一个table数组*/
    private Entry[] table;

    private static  Integer CAPCITY = 16;

    private int size = 0;

    public MyHashMap() {
        this.table = new Entry[CAPCITY];
    }

    /*获取map元素个数*/
    public int size() {
        return size;
    }

    /*获取key值*/
    public Object get(Object key) {

        /*计算出key的hash值*/
        int hash = key.hashCode();
        /*通过对hash的取余计算出hash 所对应的下标*/
        int i = hash % table.length;

        for (Entry<K,V> entry = table[i]; entry!=null; entry = entry.next){
            if(entry.k.equals(key)){
                return entry.v;
            }
        }

        return null;
    }

    /*添加元素*/
    public Object put(K key, V value) {

        /*计算出key的hash值*/
        int hash = key.hashCode();
        /*通过对hash的取余计算出hash 所对应的下标*/
        int i = hash%table.length;

        for (Entry<K,V> entry = table[i]; entry!=null; entry = entry.next){

            if(entry.k.equals(key)){

                V oldVlue = entry.v;
                entry.v = value;
                return oldVlue;
            }
        }

        addEntry(key, value, i);
        return null;
    }

    private void addEntry(K key, V value, int i) {
        Entry shuzudexiabiao = table[i];
        Entry<K, V> entry = new Entry<>(key, value, shuzudexiabiao);
        table[i] = entry;
        size++;
    }

    /*定义一个Entry节点*/
    class  Entry<K,V>{

        private K k;
        private V v;
        private Entry<K,V> next;

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;

        }
    }


    public static void main(String[] args) {


        MyHashMap<Object, Object> map = new MyHashMap<>();
        map.put("123","毕秀峰");
        map.put("123","毕秀峰444");
        map.put("","2145235235");
        System.out.println(map.get(""));

    }

}
