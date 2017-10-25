package muhavani.com.sqlitelab;

/**
 * Created by mikey on 25/10/2017.
 */

public class Games {

    String game_name;
    String genre;
    int id;





    public Games(){}

    public Games(int id, String game_name, String genre){
        this.game_name  = game_name;
        this.genre = genre;
        this.id= id;

    }
    public Games(String game_name, String genre){
        this.game_name = game_name;
        this.genre= genre;
    }

    //Getting ID
    public int getid(){
        return this.id;
    }

    //Setting ID
    public void setid(int id) {
        this.id = id;
    }

    //Get Game Name
    public String get_game_name() {
        return game_name;
    }

    //Set Game Name
    public void set_game_name(String game_name) {
        this.game_name = game_name;
    }

    //Get genre
    public String get_genre() {
        return genre;
    }

    //Set Genre
    public void set_genre(String genre) {
        this.genre = genre;
    }
}
