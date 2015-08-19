import java.util.ArrayList;

public class CDOrganizer{
  private ArrayList<CD> mCds;

  public CDOrganizer(){
    mCds = new ArrayList<CD>();

  }


  public void addCD(CD newCD) {
  //  CD newCD = CD(albumName, artistName);
    mCds.add(newCD);
  }
}
