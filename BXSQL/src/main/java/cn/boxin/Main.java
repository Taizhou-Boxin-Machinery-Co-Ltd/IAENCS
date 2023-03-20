package cn.boxin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final File path = new File(System.getProperty("user.dir"), "data");//数据库基础存储位置
    public static void main(String[] args) throws IOException {
        if (!path.exists()) path.mkdirs();
        File file = new File(path, "default.json");
        if (!file.exists()) {
            Map<String, Object> map = new HashMap<>();
            List<Map<String, Object>> list = new ArrayList<>();
            Map<String, Object> obj = new HashMap<>();
            obj.put("1", "a.json");
            list.add(obj);
            map.put("filePath", list);
            Gson gson = new GsonBuilder().create();
            String s = gson.toJson(map);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(s);
            }
        } else {
            Gson gson = new GsonBuilder().create();
            Map<String, Object> map = gson.fromJson(new BufferedReader(new FileReader(file)), Map.class);
        }
    }
}