package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution extends SimpleFileVisitor<Path> {

    public Map<String,String> hashMap = new HashMap<>();
    public List<String> listPaths = new ArrayList<>();
    public static List<String> listPathsFoMain = new ArrayList<>();

    /*  @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
      {
          return super.preVisitDirectory(dir, attrs);
      }
  */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException  {

        File newFile = new File(file.toString());

        hashMap.put(newFile.getAbsolutePath(), newFile.getName());

        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }
  /*  @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

        return super.postVisitDirectory(dir,exc);
    }
*/
    public static List<String> getFileTree(String root) throws IOException {

        Path startingDir = Paths.get(root);

        Solution solution = new Solution();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        int maxDepth = Integer.MAX_VALUE;
        Files.walkFileTree(startingDir, options, maxDepth, solution);

        solution.listPaths.addAll(solution.hashMap.keySet());

        return solution.listPaths;

    }

    public static void main(String[] args) throws IOException
    {
        listPathsFoMain=getFileTree("C:/31_02_01");

        for(String temp:listPathsFoMain)
            System.out.println(temp);
    }
}
