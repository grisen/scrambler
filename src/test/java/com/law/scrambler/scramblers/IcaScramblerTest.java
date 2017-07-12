package com.law.scrambler.scramblers;

import com.law.scrambler.dtos.RecepieDTO;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IcaScramblerTest extends MainScramblerTest {

    private String testRecepiePath = "src/test/resources/icatest.html";

    @Spy
    private IcaScrambler icaScrambler;

    @Test
    public void testProcessRecepie() throws Exception {
        Elements testRecepie = getTestRecepie(testRecepiePath);

        doReturn(testRecepie).when(icaScrambler).getElements(anyString(), anyString());
        RecepieDTO recepieDTO = this.icaScrambler.processRecepie("");

        Assert.assertNotNull(recepieDTO);
        Assert.assertNotEquals(0, recepieDTO.ingredients.size());
    }
}
