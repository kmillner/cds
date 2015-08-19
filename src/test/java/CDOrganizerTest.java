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
  public void cD_instantiatesCorrectly_true(){
    CD myCD = new CD("To Pimp a Butterfly", "exampleArtist");
    assertEquals(true, myCD instanceof CD);
  }

  @Test
  public void cD_instantsWithalbumtitle_true(){
    CD myCD = new CD("To Pimp a Butterfly", "exampleArtist");
    assertEquals("To Pimp a Butterfly", myCD.getAlbumTitle());
  }

  @Test
  public void cD_instantiatesWithArtistName_true(){
    CD myCD = new CD("ExampleAlbum", "ExampleArtist");
    assertEquals("ExampleArtist", myCD.getArtistName());
  }

  // @Test
  // public void artists_instantiatesCorretly_true(){
  //   Artists myArtist = new Artists("Backstreet Boys");
  //   assertEquals(true, myArtist instanceof Artists);
  // }
  //
  // @Test
  // public void artists_instantiatesWithArtistName_true(){
  //   Artists myArtist = new Artists("Backstreet Boys");
  //   assertEquals("Backstreet Boys", myArtist.getArtistName());
  // }
}
