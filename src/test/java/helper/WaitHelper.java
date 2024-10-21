package helper;

import java.time.Duration;
import java.util.function.Supplier;
import static java.lang.String.format;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(7);
    private static final int TIMES_TO_RETRY = 2;
    private static final String WEB_ELEMENT_NOT_LOCATED_MESSAGE = "The web element with locator %s was not located after %d attempts";

    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public boolean urlContains(String urlSubstring) {
        try {
            return wait.until(ExpectedConditions.urlContains(urlSubstring));
        } catch (Exception e) {
        	System.err.println(e);
        }
        return false;
    }

    private <T> T retryLogic(Supplier<T> action, WebElement element) {
        boolean shouldRetry = true;
        int attempt = TIMES_TO_RETRY;

        while (shouldRetry) {
            try {
                T result = action.get();
                shouldRetry = false;
                return result;
            } catch (Exception exception) {
                attempt--;
                if (attempt <= 0) {
                    shouldRetry = false;
                    throw new NoSuchElementException(format(WEB_ELEMENT_NOT_LOCATED_MESSAGE, element, TIMES_TO_RETRY));
                }
            }
        }
        return null; // INFO: shouldRetry cannot start with false.
    }

    public WebElement waitElementToBeClickableWithShouldRetry(WebElement element) {
        return retryLogic(() -> wait.until(ExpectedConditions.elementToBeClickable(element)), element);
    }

   
}
