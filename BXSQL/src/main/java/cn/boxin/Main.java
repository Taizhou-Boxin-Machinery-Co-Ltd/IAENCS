package cn.boxin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> obj = new HashMap<>();
        obj.put("1", "a.json");
        list.add(obj);
        map.put("filePath", list);
        Gson gson = new GsonBuilder().create();
        String s = gson.toJson(map);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir"), "basic.json")))) {
            bw.write(s);
        }
        System.out.println(s);
    }
}