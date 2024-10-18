package Sandro.Week6.FileStream;

import java.io.File;

public class FileCount {
    public static void main(String[] args) {

        File search = new File ("C:\\Users\\ossdr\\IdeaProjects\\HomeOffice\\src\\Schleifen") ;
        File[] content = search.listFiles();
        int count = getFileCount(content);
        long sumSize = getSizeSum(content);

        printStats(content,count,sumSize);

    }

    public static void printStats(File[] content, int count, long sum){
        int nr = 1;
        for (int i = 0; i < content.length; i++) {
            if (content[i].isFile()) {
                System.out.printf("Nr.%d) %-25s  -- [%5s]\n",nr,content[i].getName(), content[i].length());
                nr++;
            }
        }
        System.out.println("files count: " + count);
        System.out.println("sum of size: " + sum);

    }
    public static long getSizeSum (File[] content){
        long sum = 0;
        for (File fi:content) {
            if (fi.isFile()){
                sum += fi.length();

            }
        }
        return sum;
    }

    public static int getFileCount (File[] content){
        int count = 0;
        for (File fi:content) {
            if (fi.isFile()){
                count++;
            }
        }



        return count;
    }


}
