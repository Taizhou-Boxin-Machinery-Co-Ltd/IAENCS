package cn.boxin;

import cn.boxin.data.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final File path = new File(System.getProperty("user.dir"), "data");//数据库基础存储位置
    public static Config config = null;

    public static void init() throws IOException {
        if (!path.exists()) path.mkdirs();

        File file = new File(path, "default.json");
        if (!file.exists()) {
            List<Map<String, Object>> list = new ArrayList<>();
            config = new Config(list);
            Map<String, Object> obj = new HashMap<>();
            obj.put("1", "a.json");
            list.add(obj);
            Gson gson = new GsonBuilder().create();
            String s = gson.toJson(config);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(s);
            bw.close();
        } else {
            Gson gson = new GsonBuilder().create();
            config = gson.fromJson(new BufferedReader(new FileReader(file)), Config.class);
        }
    }
}