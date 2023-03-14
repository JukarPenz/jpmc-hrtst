package com.pesys.jpm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlmostEq {

    public static void main(String[] args) {

        List<String> s = List.of("aaabb","abbcc","aaaaaacccc","aaaaaa","aaaa");
        List<String> t = List.of("abbbc","aabbc","aaaabb","aaaabb","bbbb");
        String rs="";
        s.stream().forEach(se->{
            String res = "YES";
            int idx=s.indexOf(se);
            //System.out.println("s: " + se+". t : " + t.get(idx)+ ". idx: "+idx);
            if(se.length()==t.get(idx).length()){
                Map<Character,Long> sm=se.chars().mapToObj(cs->(char)cs)
                        .collect(Collectors.groupingBy(cs->cs,Collectors.counting()));
                Map<Character,Long> tm=t.get(idx).chars().mapToObj(cs->(char)cs)
                        .collect(Collectors.groupingBy(cs->cs,Collectors.counting()));

                Map<Character,Long> allChars=new HashMap<Character,Long>();
                allChars.putAll(sm);
                allChars.putAll(tm);

                for(Map.Entry<Character,Long> mm :allChars.entrySet()){
                    Long n = sm.containsKey(mm.getKey()) ? sm.get(mm.getKey()):0;
                    Long tt = tm.containsKey(mm.getKey()) ? tm.get(mm.getKey()):0;
                    //System.out.println("Rs: " + mm.getKey() + ": "+n + ". Rt: " +tt);
                    if(Math.abs(n-tt)>3){
                        res="NO Chars";
                    }
                }
            }
            else{
                res="NO Length";
            }
            System.out.println(se+"\n"+t.get(idx)+"->" + res);
            idx++;
        });
    }
}
