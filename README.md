# Java Speech API
Java API for speech recognition using Web Speech API

# Features
- Speech recognition for free and without token

# How to install
[![](https://jitpack.io/v/yadokari1130/JavaSpeechAPI.svg)](https://jitpack.io/#yadokari1130/JavaSpeechAPI)

# How to use
```Java
JavaSpeechAPI speech = new JavaSpeechAPI();
String text = "";

while (!text.equals("exit")) {
	if (speech.updateText()) {
		text = speech.getText();
		System.out.println(text);
	}

	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

speech.quit();
```
You run this code, Google Chrome of selenium are lunched.  
If speech recognition are succeeded, ```JavaSpeechAPI#updateText()``` returns true and you can get the text using ```JavaSpeechAPI#getText()```.