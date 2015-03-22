package com.f0ris.lab1;

import java.util.ArrayList;

/**
 * Created by F0RIS on 11.03.2015.
 */
public class ShannonFano {

    ArrayList<Record> tab;

    public ShannonFano(ArrayList<Record> tab) {
        this.tab = tab;

        Work(0, tab.size()-1);
    }

    //Функция суммирования вероятностей в заданном интервале
    float countFreq(int start, int end){

        float sum = 0;
        for (int i = start; i < end; i++) {
            sum += tab.get(i).freq;
        }
        return sum;
    }

    //функция для рекурсивной обработки списка
    public void Work(int begin, int end){

        Float best_dif = Float.MAX_VALUE;
        int middle = 0; //индекс элемента, разделяющего список на 2 интервала
        Float dif1 = 0f, dif2 = 0f; //суммы вероятностей в двух интервалах

        if ( (end - begin) == 1 ){ //в интервале осталось 2 элемента
            tab.get(begin).code+="1";
            tab.get(end).code+="0";
            return;
        }
        else if ( begin == end){//в интрвале один элемент
            return;

        }


        //ищем интервалы с найменьшей разницой
        for (int i = begin; i < end; i++) {


            dif1 = countFreq(begin, i);
            dif2 = countFreq(i+1, end);

            if (Math.abs(dif1 - dif2) < best_dif){
                best_dif = Math.abs(dif1 - dif2);
                //System.out.println(best_dif);

                middle = i;//запоминаем позицию
            }

        }
        //оптимальное разбиение найдено, расставляем коды

        for (int i = begin; i <= end; i++) {
            if (i <= middle) tab.get(i).code += "1";
            else
                tab.get(i).code += "0";
        }

        //рекурсивные вызовы для двух интервалов
        Work(begin, middle);
        Work(middle+1, end);


    }
}
