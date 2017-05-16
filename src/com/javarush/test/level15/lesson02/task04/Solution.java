package com.javarush.test.level15.lesson02.task04;

import java.util.List;
import java.util.LinkedList;

/* ООП - книги
1. Создайте public static класс MarkTwainBook, который наследуется от Book.
Имя автора [Mark Twain]. Параметр конструктора - имя книги.
2. В классе MarkTwainBook реализуйте все абстрактные методы.
3. Для метода getBook расширьте тип возвращаемого результата.
4. Создайте по аналогии AgathaChristieBook. Имя автора [Agatha Christie].
5. В классе Book реализуйте тело метода getOutputByBookType так, чтобы он возвращал:
5.1. agathaChristieOutput для книг Агаты Кристи;
5.2. markTwainOutput для книг Марка Твена.
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    public abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getName();

        private String getOutputByBookType()
        {

            String output = "output";
    if (this instanceof AgathaChristieBook)
      {
        String agathaChristieOutput = author + ", " + getBook().getName() + " is a detective";
        output = agathaChristieOutput;
      }
     if (this instanceof MarkTwainBook)
      {
         String markTwainOutput = getBook().getName() + " book was written by " + author;
         output=markTwainOutput;
      }
                //Add your code here

    return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book
    {
       // public String author ="Mark Twain";
        private String bookname;
        public MarkTwainBook(String bookname) {
            super("Mark Twain");
            this.bookname =bookname;
        }

        public MarkTwainBook getBook() { return (MarkTwainBook) this; }

        public String getName(){return this.bookname;}
       // public String getAuthor(){return this.author;}
    }

    public static class AgathaChristieBook extends Book
    {
     //   public String author ="Agatha Christie";
        private String bookname;
        public AgathaChristieBook(String bookname)
        {
            super("Agatha Christie");
            this.bookname = bookname;
        }
        public AgathaChristieBook getBook() { return (AgathaChristieBook)this; }

        public String getName(){return this.bookname;}
      //  public String getAuthor(){return this.author;}
    }
}
