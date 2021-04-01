package com.gmail.game.yadokari1130;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaSpeechAPI {

	private WebDriver driver;
	private String text;
	private String uuid;

	/**
	 * Constructor
	 */
	public JavaSpeechAPI() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(0, 0));
		driver.manage().window().setPosition(new Point(-600, 0));
		driver.get("https://yadokari1130.github.io/JavaSpeechAPI/");
	}

	/**
	 * Update the text
	 *
	 * @return If the text was updated
	 */
	public boolean updateText() {
		WebElement element = null;
		try {
			element = driver.findElement(By.id("text"));
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
		if (!element.getText().contains("/")) return false;
		String temp[] = element.getText().split("/");
		String text = temp[0];
		String uuid = temp[1];

		if (!uuid.equals(this.uuid)) {
			this.uuid = uuid;
			this.text = text;
			return true;
		}
		else return false;
	}

	/**
	 * Get the text
	 *
	 * @return text
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Quit the selenium
	 */
	public void quit() {
		driver.quit();
	}
}
