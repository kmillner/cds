import org.junit.*;
//import org.fluentlenium.adapter.FluentTest;
//import org.junit.ClassRule;
import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;
//import spark.template.velocity.VelocityTemplateEngine;

public class CDOrganizerTest{

  @Test
  public void cDOrganizer_instantiatesCorrectly_true(){
    CDOrganizer myCD = new CDOrganizer("To Pimp a Butterfly");
    assertEquals(true, myCD instanceof CDOrganizer);
  }

  @Test
  public void cDOrganizer_instantsWithalbumtitle_true(){
    CDOrganizer myCD = new CDOrganizer("To Pimp a Butterfly");
    assertEquals("To Pimp a Butterfly", myCD.getAlbumTitle());
  }
}
