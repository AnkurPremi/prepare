package DataStructures.NewWork.Misc;

import java.util.*;

public class InMemoryFileSystem {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d","hello");
        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
    }
}

class FileSystem {

    Directory parent;

    public FileSystem() {
        parent = new Directory();
    }

    ////////////////////////////////////////////////////////////////////////

    public List<String> ls(String path) {
        List<String> list = new ArrayList();
        if(path.equals("/")){
            list.addAll(new ArrayList(parent.directories.keySet()));
            list.addAll(new ArrayList(parent.files.keySet()));
        } else {
            String[] pathArr = path.split("/");
            listFiles(pathArr, 1, list, parent);
        }
        Collections.sort(list);
        return list;
    }

    private void listFiles(String[] path, int idx, List<String> list, Directory dir){
        if(idx == path.length - 1){
            if(dir.files.containsKey(path[idx])){
                list.add(path[idx]);
            } else {
                dir = dir.directories.get(path[idx]);
                list.addAll(new ArrayList(dir.directories.keySet()));
                list.addAll(new ArrayList(dir.files.keySet()));
            }
            return;
        } else {
            listFiles(path, idx + 1, list, dir.directories.get(path[idx]));
        }
    }


    //////////////////////////////////////////////////////////////////////////

    public void mkdir(String path) {
        String[] pathArr = path.split("/");
        createDirs(pathArr, 1, parent);
    }

    private void createDirs(String[] path, int idx, Directory dir){
        if(idx == path.length) return;
        if(!dir.directories.containsKey(path[idx])){
            dir.directories.put(path[idx], new Directory());
        }
        createDirs(path, idx + 1, dir.directories.get(path[idx]));
    }

    /////////////////////////////////////////////////////////////////////////

    public void addContentToFile(String filePath, String content) {
        String[] pathArr = filePath.split("/");
        addContent(pathArr, 1, parent, content);
    }

    private void addContent(String[] path, int idx, Directory dir, String con){
        if(idx == path.length - 1){
            StringBuilder builder = dir.files.getOrDefault(path[idx], new StringBuilder());
            builder.append(con);
            dir.files.put(path[idx], builder);
        } else {
            addContent(path, idx + 1, dir.directories.get(path[idx]), con);
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    public String readContentFromFile(String filePath) {
        String[] pathArr = filePath.split("/");
        return getContent(pathArr, 1, parent);
    }

    private String getContent(String[] path, int idx, Directory dir){
        if(idx == path.length - 1){
            return dir.files.get(path[idx]).toString();
        }
        return getContent(path, idx + 1, dir.directories.get(path[idx]));
    }

    ///////////////////////////////////////////////////////////////////////////
    class Directory{
        Map<String, Directory> directories;
        Map<String, StringBuilder> files;

        public Directory(){
            directories = new HashMap();
            files = new HashMap();
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */


//class FileSystem {
//
//    Directory parentDir;
//    String parentName;
//
//    public FileSystem() {
//    }
//
//    public List<String> ls(String path) {
//        if (parentDir == null) return new ArrayList();
//        String[] pathArr = path.split("/");
//        if(pathArr.length == 0) return Arrays.asList(parentName);
//        List<String> files = listFiles(parentDir, 0, pathArr);
//        Collections.sort(files);
//        return files;
//    }
//
//    private List<String> listFiles(Directory parent, int idx, String[] path) {
//        if (idx == path.length - 1) {
//            List<String> list = null;
//            if (parent.directories.containsKey(path[idx])) {
//                list = new ArrayList(parent.directories.keySet());
//            } else if (parent.files.containsKey(path[idx])) {
//                list = new ArrayList();
//                list.add(path[idx]);
//            }
//            return list;
//        } else {
//            return listFiles(parent.directories.get(path[idx]), idx + 1, path);
//        }
//    }
//
//
//    //---------------Make Dir------------------//
//
//    public void mkdir(String path) {
//        String[] pathArr = path.split("/");
//        if (parentDir == null){
//            parentName = pathArr[1];
//            parentDir = new Directory();
//        }
//        makeDir(pathArr, 1, parentDir);
//    }
//
//    private void makeDir(String[] path, int idx, Directory parent) {
//        if (idx == path.length) return;
//
//        if (!parent.directories.containsKey(path[idx])) {
//            Directory childDir = new Directory();
//            parent.directories.put(path[idx], childDir);
//            makeDir(path, idx + 1, childDir);
//        } else {
//            makeDir(path, idx + 1, parent.directories.get(path[idx]));
//        }
//    }
//
//    //---------------Make Dir------------------//
//
//
//    //-------------Add Contents----------------//
//
//    public void addContentToFile(String filePath, String content) {
//        String[] pathArr = filePath.split("/");
//        addContent(pathArr, 1, content, parentDir);
//    }
//
//    private void addContent(String[] path, int idx, String content, Directory parent) {
//        if (idx == path.length - 1) {
//            if (!parent.files.containsKey(path[idx])) {
//                StringBuilder builder = new StringBuilder();
//                builder.append(content);
//                parent.files.put(path[idx], builder);
//            } else {
//                parent.files.get(path[idx]).append(content);
//            }
//        } else {
//            addContent(path, idx + 1, content, parent.directories.get(path[idx]));
//        }
//    }
//
//    //-------------Add Contents----------------//
//
//    public String readContentFromFile(String filePath) {
//        String[] pathArr = filePath.split("/");
//        return getContent(pathArr, 1, parentDir);
//    }
//
//    private String getContent(String[] path, int idx, Directory parent) {
//        if (idx == path.length - 1) {
//            return parent.files.get(path[idx]).toString();
//        } else {
//            return getContent(path, idx + 1, parent.directories.get(path[idx]));
//        }
//    }
//
//    class Directory {
//
//        private Map<String, Directory> directories;
//        private Map<String, StringBuilder> files;
//
//        Directory() {
//            this.directories = new HashMap();
//            this.files = new HashMap();
//        }
//
//    }
//}
//
///**
// * Your FileSystem object will be instantiated and called as such:
// * FileSystem obj = new FileSystem();
// * List<String> param_1 = obj.ls(path);
// * obj.mkdir(path);
// * obj.addContentToFile(filePath,content);
// * String param_4 = obj.readContentFromFile(filePath);
// */