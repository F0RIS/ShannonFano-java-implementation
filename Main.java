package com.f0ris.lab1;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        String message = "саша  само совершенство а еще самосовершенствуется";


        HashMap<Character, Integer> map = countSybmols(message);

        ArrayList<Record> tab = new ArrayList<Record>();

        int len = message.length();
        for (Map.Entry<Character, Integer> item : map.entrySet())
        {
            Float fr = item.getValue()/(float)len;
            tab.add(new Record(item.getKey(), fr));
        }

        Collections.sort(tab);

        ShannonFano fano = new ShannonFano(tab);

        for (Record item :tab){
            System.out.println(item.ch + " " + item.code);
        }


    }


    static HashMap countSybmols(String message){

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        char a[] = message.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i]))
                map.put(a[i], 1);
            else
            {
                map.put(a[i], map.get(a[i])+1);
            }
        }

        return map;
    }
}
