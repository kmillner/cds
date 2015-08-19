// import java.util.ArrayList;
// import java.util.Map;
// import java.util.HashMap;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;
// //import static org.fluentlenium.core.filter.FilterConstructor.*;
//
// public class App {
//   public static void main(String[] args){
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";
//
//     //
//     get("/", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       model.put("albums", request.session().attribute("albums"));
//
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     // index of all organizers
//     // get("/organizers
//
//     // creating a new organizer
//     post("/organizers", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       String organizerName = request.queryParams("organizerName");
//       CDOrganizer newOrganizer = new CDOrganizer(organizerName);
//       newOrganizer.save();
//       model.put("template", "templates/succces.vtl");
//     }, new VelocityTemplateEngine());
//
//     // displaying info about 1 organizer
//     get("/organizers/:id", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       int id = Integer.parseInt(request.params("id"));
//
//       CDOrganizer newOrganizer = CDOrganizer.find(id);
//
//
//       model.put("template", "templates/succces.vtl");
//     }, new VelocityTemplateEngine());
//
//     // creating a new CD and relating it to 1 organizer
//     post("/organizers/:id/cds", (request, response) -> {
//       HashMap<String, Object> model = new HashMap<String, Object>();
//       int id = Integer.parseInt(request.params("id"));
//       CDOrganizer newOrganizer = CDOrganizer.find(id);
//
//       String title = request.queryParams("title");
//       String artist = request.queryParams("artist");
//       CD newCD = new CD(title, artist);
//
//       newOrganizer.addCD(newCD);
//
//
//     model.put("template", "templates/succces.vtl");
//     }, new VelocityTemplateEngine());
//
//
//
//     post("/success", (request, response) -> {
//     HashMap<String, Object> model = new HashMap<String, Object>();
//     ArrayList<CD> albums = request.session().attribute("albums");
//
//       if (albums == null){
//         albums = new ArrayList<CD>();
//         request.session().attribute("albums", albums);
//       }
//
//
//     CD newCD = new CD(title, artist);
//     albums.add(newCD);
//
//     model.put("template", "templates/succces.vtl");
//     return new ModelAndView(model, layout);
//   }, new VelocityTemplateEngine());
//   }
//
// }
