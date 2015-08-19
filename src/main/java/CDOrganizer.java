import java.util.ArrayList;

public class CDOrganizer{

  private static ArrayList<CDOrganizer> instances = new ArrayList<CDOrganizer>();

  private String mName;
  private ArrayList<CD> mCds;
  private int mId;

  public CDOrganizer(String name){
    mCds = new ArrayList<CD>();
    mName = name;
    instances.add(this);
    mId = instances.size() + 1;
  }


  public void addCD(CD addedCD) {
    mCds.add(addedCD);
  }

  // public void save() {
  //   ArrayList<CDOrganizer> instances = CDOrganizer.all();
  //   instances.add(this);
  //   mId = instances.size() + 1;
  // }
  // public static CDOrganixer find(String artistName) {
  //     try {
  //       return instances.get(id - 1);
  //     } catch (IndexOutOfBoundsException e) {
  //       return null;
  //     }
  //   }

  public String getOrganizerName(){
    return mName;
  }

  public int getID(){
    return mId - 1;
  }

  public static ArrayList<CDOrganizer> all() {
    return instances;
  }

  public static CDOrganizer find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
