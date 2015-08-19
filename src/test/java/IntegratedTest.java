import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegratedTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("CD Organizer");
  }

  @Test
  public void albumnameisCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#description").with("To Pimp A Butterfly");
    submit(".btn");
    assertThat(pageSource()).contains("Your album has been saved.");
  }

  @Test
  public void albumIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#description").with("To Pimp A Butterfly");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("To Pimp A Butterfly");
    }

  @Test
  public void muiltipleAlbumsDisplayed(){
    goTo("http://localhost:4567/");
    fill("#description").with("To Pimp A Butterfly");
    submit(".btn");
    click("a", withText("Go Back"));
    fill("#description").with("From Kinshasa");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("To Pimp A Butterfly");
    assertThat(pageSource()).contains("From Kinshasa");
  }
}
