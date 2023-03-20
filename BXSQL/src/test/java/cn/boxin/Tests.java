package cn.boxin;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static cn.boxin.Main.config;
import static cn.boxin.Main.init;

public final class Tests {
    @Test
    public void aVoid() throws IOException {
        init();
        config.getList().forEach(stringObjectMap -> {
            stringObjectMap.forEach((s, o) -> {
                System.out.println(s);
                System.out.println(o);
            });
        });
    }
}
