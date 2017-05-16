package com.javarush.test.level31.lesson02.home01;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;



public class Solution extends SimpleFileVisitor<Path>{

  public Map<String,String> hashMap = new HashMap<>();
  public Map<String,String> sortedMap = new HashMap<>();

  private static HashMap sortByValues(HashMap map){

       List list = new LinkedList(map.entrySet());
        //Defined Custom Comparator here
       Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2){
                return ((Comparable)((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
            }
        });
        HashMap sortedHashMap = new LinkedHashMap();

        for(Iterator it = list.iterator(); it.hasNext();){
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(),entry.getValue());
        }
       return sortedHashMap;
  }
  /*  @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        return super.preVisitDirectory(dir, attrs);
    }
*/
    @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException  {

    File newFile = new File(file.toString());

    if(!newFile.getName().equals("resultFileAbsolutePath") && !newFile.getName().equals("allFilesContent.txt")) {
        if (newFile.length() > 50)
            Files.delete(file);
        else {
                hashMap.put(newFile.getAbsolutePath(), newFile.getName());
                sortedMap = sortByValues((HashMap) hashMap);
        }
    }

    return FileVisitResult.CONTINUE;
  }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

        File dirFile = new File(dir.toString());

        if(dirFile.listFiles().length == 0) {
            try {
                Files.delete(dir);
            } catch (IOException e) {
                System.err.println(e);
              }
        }
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {

        if (args.length < 2)
            return;

        File resultFile = new File(args[1]);
        Path startingDir = Paths.get(args[0]);
        Path resultFileAbsolutePath = Paths.get( args[1]);

        Solution solution = new Solution();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        int maxDepth = Integer.MAX_VALUE;
        Files.walkFileTree(startingDir, options, maxDepth, solution);

        if(solution.sortedMap.size()>0) {
            int i = 0;
            Path newResultFile = Paths.get(resultFile.getParent() + "/" + "allFilesContent.txt");
            try {
                 Files.move(resultFileAbsolutePath, newResultFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e){
                 System.err.println(e);
              }


        for (String key : solution.sortedMap.keySet()) {

            Path file = Paths.get(key);
            try (InputStream in = Files.newInputStream(file)) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = null;

                while ((line = reader.readLine()) != null){
                    try (OutputStream out = new BufferedOutputStream(
                          Files.newOutputStream(newResultFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
                              if (i < solution.sortedMap.size() - 1){
                                  i++;
                                  line += "\n";
                              }
                              out.write(line.getBytes(), 0, line.getBytes().length);

                    } catch(IOException e){
                            System.err.println(e);
                      }

                }
            } catch(IOException e ){
                   System.err.println(e);
              }
        }
        }
    }
}



