package com.javarush.test.level21.lesson05.task01;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {

        if (first==null) this.first="0";
        else
        this.first = first;

        if (last==null) this.last="0";
        else
        this.last = last;
    }


   @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;

        if(obj.getClass()!=this.getClass()) return false;

        Solution n = (Solution) obj;
        return n.first.equals(first) && n.last.equals(last);
    }
    @Override
    public int hashCode() {

        return 31*first.hashCode() + last.hashCode();
    }



    public static void main(String[] args)throws IOException{
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

        s.add(new Solution("asd",null));
        System.out.println(s.contains(new Solution("asd",null)));

        s.add(new Solution(null,null));
        System.out.println(s.contains(new Solution(null,null)));

        s.add(new Solution("first",null));
        System.out.println(s.contains(new Solution("first",null)));

        s.add(new Solution(null,"last"));
        System.out.println(s.contains(new Solution(null,"last")));

        s.add(new Solution(null,"last"));
        System.out.println(s.contains(new Solution(null,"first")));
    }

}
