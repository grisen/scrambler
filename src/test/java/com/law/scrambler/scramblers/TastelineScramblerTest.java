package com.law.scrambler.scramblers;

import com.law.scrambler.dtos.RecepieDTO;
import com.law.scrambler.repositories.IngredientRepository;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TastelineScramblerTest {

    @Spy
    private TastelineScrambler tastelineScrambler;

    @Autowired
    private IngredientRepository ingredientRepository;

    private Elements getTestRecepie() throws IOException {
        File file = new File("src/test/resources/test.html");

        return Jsoup.parse(file, "UTF-8").getAllElements();
    }

    @Test
    public void testProcessRecepie() throws Exception {
        Elements testRecepie = getTestRecepie();

        doReturn(testRecepie).when(tastelineScrambler).getElements(anyString());
        RecepieDTO recepieDTO = this.tastelineScrambler.processRecepie("");

        Assert.assertNotNull(recepieDTO);
        Assert.assertNotEquals(0, recepieDTO.ingredients.size());
    }

}