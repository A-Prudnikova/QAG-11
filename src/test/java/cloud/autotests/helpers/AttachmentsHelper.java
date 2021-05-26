package cloud.autotests.helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.addAttachment;


public class AttachmentsHelper {
   private static final Logger LOG = LoggerFactory.getLogger(AttachmentsHelper.class);

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] attachPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

//    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
//    public static String attachVideo(String sessionId) {
//        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
//                + getVideoUrl(sessionId)
//                + "' type='video/mp4'></video></body></html>";
//    }
//
//    public static String getVideoUrl(String sessionId) {
//        return getWebVideoUrl(sessionId);
//    }
//
//    public static String getWebVideoUrl(String sessionId) {
//        try {
//            return new URL(DriverHelper.getVideoUrl() + sessionId + ".mp4") + "";
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static void attachVideo(String sessionId) {
        URL videoUrl = getVideoUrl(sessionId);
        if (videoUrl != null) {
            InputStream videoInputStream = null;
            sleep(1000);

            for (int i = 0; i < 10; i++) {
                try {
                    videoInputStream = videoUrl.openStream();
                    break;
                } catch (FileNotFoundException e) {
                    sleep(1000);
                } catch (IOException e) {
                    LOG.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video, {}", videoUrl);
                    e.printStackTrace();
                }
            }
            addAttachment("Video", "video/mp4", videoInputStream, "mp4");
        }
    }

    public static URL getVideoUrl(String sessionId) {
        String videoUrl = DriverHelper.getVideoUrl() + sessionId + ".mp4";
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            LOG.warn("[ALLURE VIDEO ATTACHMENT ERROR] Wrong test video url, {}", videoUrl);
            e.printStackTrace();
        }
        return null;
    }
}