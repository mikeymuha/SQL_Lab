package muhavani.com.sqlitelab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        //DATA INSERTION -- USERS

        Log.d("Insert: ", "Adding Users...");
        db.addUSER(new Users("JakePaul324", "Administrator"));
        db.addUSER(new Users("Anonymous", "User"));
        db.addUSER(new Users("User2541", "Active"));
        db.addUSER(new Users("Brandon365", "Administrator"));

        Log.d("Reading: ", "Reading all user information...");
        List<Users> UserList = db.getAllUsers();

        for(Users us : UserList){
            String log = "Id: "+us.getID()+" Username: " + us.getName() + " ,Status: "+us.getStatus();
            Log.d("Username: ", log);
        }


// DATA INSERTION -- GAMES

        Log.d("Insert: ", "Adding Games...");
        db.addnewGame(new Games("Uncharted: Lost Legacy", "Action"));
        db.addnewGame(new Games("Pac-Man", "Arcade"));
        db.addnewGame(new Games("FIFA 17", "Sport"));
        db.addnewGame(new Games("Minecraft: Story Mode", "Adventure"));

        Log.d("Reading: ", "Reading all games...");
        List<Games> GameList = db.getAllGames();

        for(Games gm : GameList){
            String log = "Id: "+gm.getid()+" Game: " + gm.get_game_name() + " ,Genre: "+gm.get_genre();
            Log.d("Game: ", log);
        }


//DATA INSERTION -- CONTACTS

        //Inserting contacts
        Log.d("Insert: ", "Inserting...");
        db.addContact(new contacts("Ravi", "91000000000"));
        db.addContact(new contacts("Jake", "91268464916"));
        db.addContact(new contacts("Yates", "2941648164"));
        db.addContact(new contacts("Scarlet", "1846548454"));

        //Reading all contacts
        Log.d("Reading: ", "Reading all contacts...");
        List<contacts> contacts = db.getAllContacts();

        for(contacts cn : contacts){
            String log = "Id: "+cn.get_id()+" Name: " + cn.get_name() + " ,Phone: "+cn.get_phone_number();
            Log.d("Name: ", log);
        }
    }
}

