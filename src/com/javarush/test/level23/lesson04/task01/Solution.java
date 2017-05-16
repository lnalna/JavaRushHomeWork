package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static void main(String[] args)
    {
        Solution[] arr_sol = new Solution[2];


        arr_sol = getTwoSolutions();

        for(Solution temp: arr_sol)
        {
            System.out.println(temp.innerClasses[0]);
            System.out.println(temp.innerClasses[1]);
        }
    }

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] temp_sol = new Solution[2];

        Solution obj1 = new Solution();
        Solution obj2 = new Solution();

        temp_sol[0] = obj1;
        temp_sol[1] = obj2;

        InnerClass i_obj1 = new Solution().new InnerClass();
        InnerClass i_obj2 = new Solution().new InnerClass();
        InnerClass i_obj3 = new Solution().new InnerClass();
        InnerClass i_obj4 = new Solution().new InnerClass();

        obj1.innerClasses[0]=i_obj1;
        obj1.innerClasses[1]=i_obj2;

        obj2.innerClasses[0]=i_obj3;
        obj2.innerClasses[1]=i_obj4;

        return temp_sol;
    }
}
