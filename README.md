
# Description

This is a simple demonstration project showing that the there is a bug in the Firefox Selenium Driver, where the WebDriver.getText() method returns empty string for custom webcomponents, while in ChromeDriver this method works correctly.

# How to

Just run the tests by
```sh
./mvnw verify
```

The webserver will be spawned automatically on random port and the tests will be performed.
You'll see that the test for Chrome passes, but the same test for Firefox fails.

The failure is now observed when using Firefox 119 and geckodriver (FirefoxDriver) v 0.33.0

```
11:09:22.811 [main] INFO io.github.bonigarcia.wdm.WebDriverManager -- Using geckodriver 0.33.0 (resolved driver for Firefox 119)
```

If the [following bug](https://github.com/SeleniumHQ/selenium/issues/13132) has been already fixed then try to bump versions of the webdrivermanager and selenium in pom.xml - then run the tests again

# Notes

You can also review the test page content by running the web server by (and going to localhost:8080):
```sh
./mvnw spring-boot:run
```

