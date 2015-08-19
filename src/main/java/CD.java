public class CD{
  private String mAlbumName;
  private String mArtistName;

  public CD(String albumName, String artistName){
    mAlbumName = albumName;
    mArtistName = artistName;
  }

  public String getAlbumTitle() {
    return mAlbumName;
  }

  public String getArtistName(){
    return mArtistName;
  }

}
