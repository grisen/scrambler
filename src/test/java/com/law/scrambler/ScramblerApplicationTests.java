package com.law.scrambler;

import com.law.scrambler.entities.Ingredient;
import com.law.scrambler.mappers.IngredientMapper;
import com.law.scrambler.repositories.IngredientRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
public class ScramblerApplicationTests {

	private final String urlString = "http://www.tasteline.com/recept/lammstek-med-citron-och-orter/";

	@Autowired
	private IngredientMapper ingredientMapper;

	@Autowired
	private IngredientRepository ingredientRepository;

	@Test
	public void getUrl() throws IOException {

		Elements elemtents = getTestRecepie();//= new URLHandler().invoke(urlString);

		Assert.assertNotEquals(0, elemtents.size());
	}

	private Elements getTestRecepie() throws IOException {
		File file = new File("src/test/resources/test.html");

		return Jsoup.parse(file, "UTF-8").getAllElements();
	}

	@Test
	public void mapIngredient() throws IOException {
		Elements elements = getTestRecepie();

		elements.select(".ingredient").forEach(i-> ingredientMapper.mapIngredient(i.text()));
		elements.select(".quantity").forEach(i-> mapAndSaveUnits(i.text()));
		elements.select(".unit").forEach(i-> mapAndSaveQuantitys(i.text()));

		ingredientRepository.findAll().forEach(i -> System.out.println(i.name));
		Assert.assertNotEquals(0, ingredientRepository.findAll().size());

		ingredientRepository.deleteAll();
	}

	private void getQuantity(Element e) {
		System.out.println(e.getElementsByClass("quantity"));
	}

	private void getIngredients(Element e) {
		e.children().forEach((Element i) ->
				{
					mapAndSaveQuantitys(i.getElementsByClass("quantity").text());
					mapAndSaveUnits(i.getElementsByClass("unit").text());
					//mapAndSaveIngredients(i.select(".ingredient").text());
				});
	}

	private void mapAndSaveUnits(String unit) {
		System.out.println(unit);
	}

	private void mapAndSaveQuantitys(String quantity) {
		System.out.println(quantity);
	}



	private void getUnits(Element e) {
		System.out.println(e.getElementsByClass("unit"));
	}
}
