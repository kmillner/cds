import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App2 {
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("lists", request.session().attribute("lists"));
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/listmade", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      ArrayList<CDOrganizer> lists = request.session().attribute("lists");

      if (lists == null){
        lists = new ArrayList<CDOrganizer>();
        request.session().attribute("lists", lists);
      }

      String listName = request.queryParams("inputList");
      CDOrganizer newOrganizer = new CDOrganizer(listName);
      //newOrganizer.save();
      lists.add(newOrganizer);
      model.put("template", "templates/listmade.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get ("/list/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      CDOrganizer newList = CDOrganizer.find(Integer.parseInt(request.params(":id")));
      model.put("newList", newList);
      model.put("albums", request.session().attribute("albums"));
      model.put("template", "templates/CDlist.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    get ("/AddNewCD",(request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("lists", request.session().attribute("lists"));
      model.put("template", "templates/AddNewCD.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/CDsuccess", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      ArrayList<CD> albums = request.session().attribute("albums");

          if (albums == null){
          albums = new ArrayList<CD>();
          request.session().attribute("albums", albums);
        }

      String cdName = request.queryParams("title");
      String cdArtist = request.queryParams("artist");
      CD newCD = new CD(cdName, cdArtist);

      albums.add(newCD);

      model.put("template", "templates/CDSuccess.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());




  }
}
