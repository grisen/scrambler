package com.law.scrambler.scramblers;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainScramblerTest {

    protected Elements getTestRecepie(String path) throws IOException {
        File file = new File(path);

        return Jsoup.parse(file, "UTF-8").getAllElements();
    }
}
