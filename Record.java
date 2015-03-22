package com.f0ris.lab1;

/**
 * Created by F0RIS on 11.03.2015.
 */
//класс представляет из себя запись в результирующей таблице
public  class Record implements Comparable{

    Character ch;
    Float freq;
    String code = new String();

    public Record(Character ch, Float freq) {
        this.ch = ch;
        this.freq = freq;
        code="";
    }

    Record(){

        ch = '1';
        freq = 0.0f;
        code = "";
    }

    @Override
    public int compareTo(Object o) {

        //если частоты одинаковые, то сортируем по символу
        if (Math.abs(this.freq - ((Record)o).freq) < 0.001)
            return this.ch < ((Record)o).ch? -1: 1;

        return this.freq > ((Record)o).freq? -1:1 ;
    }
}
