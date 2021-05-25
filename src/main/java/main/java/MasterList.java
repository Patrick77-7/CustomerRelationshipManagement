package main.java;

import java.util.HashMap;

public abstract class MasterList {
    private String name;
    HashMap <String, Object> newHashMap = new HashMap<>();

    public MasterList() {
    }

    public MasterList(String name) {
        this.name = name;
    }

    //    remove from List
    public void removeFromList(String Id) {
        this.newHashMap.remove(Id);
    }

    // export List

//    public void exportList() {
//        FileWriter x;
//        try {
//            x = new FileWriter(this.getName());
//            Integer lastId = this.newHashmap.size() + 1;
//            for (int i = 1; i < lastId; i++) {
//                x.write(this.newHashmap.get("L " + i).getInfo() + "\n");
//            }
////            x.write("\n" + "This list contains " + (lastId-1) + " leads");
//            x.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // import list
//
//    public HashMap<String, Lead> importList() throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(this.getName()));
//        String line = null;
//        HashMap<String, Lead> map = new HashMap<>();
//        while ((line = br.readLine()).contains("L")) {
//            String str[] = line.split(";");
//            for (int i = 0; i < str.length; i++) {
//                map.put(str[0], new Lead(str[0], str[1], str[2], str[3], str[4]));
//            }
//        }
//        return map;
//    }


    public HashMap<String, Object> getNewHashmap() {
    return newHashMap;
}

    public void setNewHashmap(HashMap<String, Lead> newHashmap) {
        this.newHashMap = newHashMap;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

