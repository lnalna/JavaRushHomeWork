package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
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

    public boolean equals(Object o) {

        if (o == null) return false;

        if(o.getClass()!=this.getClass()) return false;

        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {

        return 31*first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));

        s.add(new Solution("Mickey", null));
        System.out.println(s.contains(new Solution("Mickey", null)));

        s.add(new Solution("Mickey", null));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));

        s.add(new Solution(null, "Mouse"));
        System.out.println(s.contains(new Solution(null, "Mouse")));

        s.add(new Solution(null, "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
