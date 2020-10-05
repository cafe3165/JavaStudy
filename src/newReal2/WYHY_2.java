package newReal2;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-27
 */
public class WYHY_2 {
    static class File {
        String fileName;
        int fd;

        public File(String fileName, int fd) {
            this.fileName = fileName;
            this.fd = fd;
        }
    }

    private static List<File> fileList;
    private static Map<Integer, File> fdMap;

    private static int getFd() {
        int res = 0;
        boolean f = true;
        while (true) {
            int count = 0;
            for (int i = 0; i < fileList.size(); i++) {
                if (fileList.get(i).fd == res) {
                    f = false;
                    break;
                } else {
                    count++;
                }
            }
            if (f) {
                break;
            }
            if (count == fileList.size()) {
                break;
            }
            res++;
        }
        return res;
    }

    private static int open(String fileName) {
        File file = new File(fileName, getFd());
        fileList.add(file);
        fdMap.put(file.fd, file);
        return file.fd;
    }

    private static int dup(int fd) {
        int nfd = getFd();
        File file = fdMap.get(fd);
        File nfile = new File(file.fileName, nfd);
        fileList.add(nfile);
        fdMap.put(nfd, nfile);
        return nfd;
    }

    private static void dup2(int fd, int nfd) {
        File nfile = fdMap.get(nfd);
        File ofile = findFile(fd);
        if (nfile != null) {
            int index = getFileIndex(nfile.fd);
            fileList.remove(index);
            fdMap.remove(nfd);
        }

        fdMap.put(nfd, ofile);
    }

    private static void close(int fd) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++) {
            if(fdMap.get(fileList.get(i).fd).fd==fd){
                list.add(fileList.get(i).fd);
            }
        }
        for(Integer i:list){
            int index = getFileIndex(fd);
            fileList.remove(index);
        }
        fdMap.remove(fd);
    }

    private static File findFile(int fd) {
        File ofile = null;
        for (int i = 0; i < fileList.size(); i++) {
            if (fd == fileList.get(i).fd) {
                ofile = fileList.get(i);
                break;
            }
        }
        return ofile;
    }

    private static int getFileIndex(int fd) {
        int index = 0;
        for (int i = 0; i < fileList.size(); i++) {
            if (fd == fileList.get(i).fd) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static String query(int fd) {
        File file = fdMap.get(fd);
        return file.fileName;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            fileList = new ArrayList<>();
            fdMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                String s = sc.next();
                if (s.equals("open")) {
                    String fileName = sc.next();
                    int fd = open(fileName);
                    System.out.println(fd);
                } else if (s.equals("dup")) {
                    int fd = sc.nextInt();
                    int nfd = dup(fd);
                    System.out.println(nfd);
                } else if (s.equals("dup2")) {
                    int fd = sc.nextInt(), nfd = sc.nextInt();
                    dup2(fd, nfd);
                } else if (s.equals("close")) {
                    int fd = sc.nextInt();
                    close(fd);
                } else {
                    int fd = sc.nextInt();
                    String fileName = query(fd);
                    System.out.println(fileName);
                }
            }
        }
    }
}
