package com.law.scrambler.scramblers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainScramblerTest {

    @Autowired
    private MainScrambler mainScrambler;

    protected Elements getTestRecepie(String path) throws IOException {
        File file = new File(path);

        return Jsoup.parse(file, "UTF-8").getAllElements();
    }

    @Test
    public void testWash() {

        String testToWash = "4 port salt och peppar";
        String shouldBeLeftWhenWashed = "salt peppar";

        String outcome = mainScrambler.wash(new Element("test").text(testToWash));

        Assert.assertEquals(shouldBeLeftWhenWashed, outcome);


    }

}
