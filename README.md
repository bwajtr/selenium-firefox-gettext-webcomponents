
# Description

This is a simple demonstration project showing that the there is a bug in the Firefox Selenium Driver, where the WebDriver.getText() method returns empty string for custom webcomponents, while in ChromeDriver this method works correctly.

# How to 

Just run the tests by
```sh
./mvnw verify
```

The webserver will be spawned automatically on random port and the tests will be performed.
You'll see that the test for Chrome passes, but the same test for Firefox fails.

You can also review the test page content by running the web server by (and going to localhost:8080):
```sh
./mvnw spring-boot:run
```

