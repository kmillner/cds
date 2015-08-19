import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
//import static org.fluentlenium.core.filter.FilterConstructor.*;

public class App {
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("albums", request.session().attribute("albums"));

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/albums", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    ArrayList<CD> albums = request.session().attribute("albums");

      if (albums == null){
        albums = new ArrayList<CD>();
        request.session().attribute("albums", albums);
      }

    String title = request.queryParams("title");
    String artist = request.queryParams("artist");
    CD newCD = new CD(title, artist);
    //request.session().attribute("album", newCD);
    albums.add(newCD);

    post("/artists", ()






    model.put("template", "templates/succces.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
  }

}
