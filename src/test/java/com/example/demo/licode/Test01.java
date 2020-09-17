package com.example.demo.licode;

import lombok.NoArgsConstructor;

import java.util.HashSet;

public class Test01 {
    public static void main(String[] args) {

        String s = "aa";
        System.out.println(save( s ));
    }


    public static Integer save(String s){
        int size;
        int max =0;
        HashSet set = new HashSet();
        if(!(s.length()<=1||s==null)){
            for (int i = 0; i <s.length()-1 ; i++) {
                set.add( s.charAt( i ) );
                for (int j = i+1; j <s.length() ; j++) {
                    size = set.size();
                    set.add( s.charAt( j ) );
                    if(size == set.size()||j==s.length()-1){     //重复
                        if(max<set.size()){
                            max=set.size();
                        }
                        set.clear();
                        break;
                    }
                }
            }
        }else {
            return s.length();
        }
        return max;
    }
}
