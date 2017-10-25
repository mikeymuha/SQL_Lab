package muhavani.com.sqlitelab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.version;

/**
 * Created by mikey on 19/10/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //All static variables
    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "peopleManager";

    //GAMES STATIC VARIABLES
    private static final String GAMES_TABLE="games";

    private static final String KEY_ID2 = "id";
    private static final String KEY_GAME_NAME = "game";
    private static final String KEY_GENRE = "genre";

    //USERS STATIC VARIABLES
    private static final String USERS_TABLE="users";

    private static final String KEY_ID3 = "id";
    private static final String KEY_USER_NAME = "username";
    private static final String KEY_STATUS = "status";


    //Contacts table name
    private static final String TABLE_CONTACTS="contacts";

    //Contacts Table Column Names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " +KEY_PH_NO + " TEXT"
                + ");";
        db.execSQL(CREATE_CONTACTS_TABLE);


        String CREATE_GAMES_TABLE = " CREATE TABLE " + GAMES_TABLE + "("
                + KEY_ID2 + " INTEGER PRIMARY KEY, " + KEY_GAME_NAME + " TEXT, " +KEY_GENRE + " TEXT"
                + ");";
        db.execSQL(CREATE_GAMES_TABLE);

        String CREATE_USERS_TABLE = " CREATE TABLE " + USERS_TABLE + "("
                + KEY_ID3 + " INTEGER PRIMARY KEY, " + KEY_USER_NAME + " TEXT, " +KEY_STATUS + " TEXT"
                + ");";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if it existed

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        //Create table again
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + GAMES_TABLE);
        onCreate(db);
        //Create table again

        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);

    }

    //CRUDE OPERATIONS -- USERS

    public void addUSER(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues user_values = new ContentValues();

        user_values.put(KEY_USER_NAME, user.getName());
        user_values.put(KEY_STATUS, user.getStatus());


        db.insert(USERS_TABLE, null, user_values);
        db.close();
    }

    public Users getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(USERS_TABLE, new String[]{ KEY_ID3, KEY_USER_NAME, KEY_STATUS}, KEY_ID3 + "=?",
                new String[]{ String.valueOf(id)}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        Users user = new Users(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        //return contact
        return user;
    }

    public List<Users> getAllUsers(){
        List<Users> UserList = new ArrayList<Users>();


        String select_query = "SELECT * FROM " + USERS_TABLE +";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);


        if(cursor.moveToFirst()){
            do{
                Users user = new Users();
                user.setID(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setStatus(cursor.getString(2));


                UserList.add(user);

            } while(cursor.moveToNext());
        }
        return UserList;
    }

    public int getUsersCount(){
        String CountQuery = "SELECT * FROM " + USERS_TABLE + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(CountQuery, null);
        cursor.close();


        return cursor.getCount();
    }

    public int updateUsers(Users user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_USER_NAME, user.getName());
        values.put(KEY_STATUS, user.getStatus());

        //Updating row
        return db.update(USERS_TABLE, values, KEY_ID3 + "=?",
                new String[]{ String.valueOf(user.getID()) });
    }

    public void deleteUSERS(Users user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(USERS_TABLE, KEY_ID3 + "=?",
                new String[]{ String.valueOf(user.getID()) });

        db.close();
    }


//CRUD OPERATIONS --- GAMES

    public void addnewGame(Games games) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues game_values = new ContentValues();

        game_values.put(KEY_GAME_NAME, games.get_game_name());
        game_values.put(KEY_GENRE, games.get_genre());


        db.insert(GAMES_TABLE, null, game_values);
        db.close();
    }

    public Games getGame(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(GAMES_TABLE, new String[]{ KEY_ID2, KEY_GAME_NAME, KEY_GENRE}, KEY_ID2 + "=?",
                new String[]{ String.valueOf(id)}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        Games game = new Games(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        //return contact
        return game;
    }

    public List<Games> getAllGames(){
        List<Games> GameList = new ArrayList<Games>();


        String select_query = "SELECT * FROM " + GAMES_TABLE +";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);


        if(cursor.moveToFirst()){
            do{
                Games game = new Games();
                game.setid(Integer.parseInt(cursor.getString(0)));
                game.set_game_name(cursor.getString(1));
                game.set_genre(cursor.getString(2));


                GameList.add(game);

            } while(cursor.moveToNext());
        }
        return GameList;
    }


    public int getGamesCount(){
        String CountQuery = "SELECT * FROM " + GAMES_TABLE + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(CountQuery, null);
        cursor.close();


        return cursor.getCount();
    }

    public int updateGame(Games game){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_GAME_NAME, game.get_game_name()); //Contact Name
        values.put(KEY_GENRE, game.get_genre()); //Phone number

        //Updating row
        return db.update(GAMES_TABLE, values, KEY_ID2 + "=?",
                new String[]{ String.valueOf(game.getid()) });
    }

    public void deleteGame(Games game){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(GAMES_TABLE, KEY_ID2 + "=?",
                new String[]{ String.valueOf(game.getid()) });

        db.close();
    }


//CRUDE OPERATIONS -- CONTACTS

    //Adding a new contact
    public void addContact(contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, contact.get_name()); //Contact Name
        values.put(KEY_PH_NO, contact.get_phone_number()); //Phone number

        //inserting database values
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); //closing the database connection
    }

    //Getting a single contact
    public contacts getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{ KEY_ID, KEY_NAME, KEY_PH_NO}, KEY_ID + "=?",
                new String[]{ String.valueOf(id)}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        contacts contact = new contacts(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        //return contact
        return contact;
    }

    //Getting all contacts
    public List<contacts> getAllContacts(){
        List<contacts> ContactList = new ArrayList<contacts>();

        //Selecting all query
        String select_query = "SELECT * FROM " + TABLE_CONTACTS +";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        //looping through all rows to add to the list
        if(cursor.moveToFirst()){
            do{
                contacts contact = new contacts();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phone_number(cursor.getString(2));

                //Adding a contact to the list
                ContactList.add(contact);

            } while(cursor.moveToNext());
        }
        return ContactList;
    }

    //Getting contacts count
    public int getContactsCount(){
            String CountQuery = "SELECT * FROM " + TABLE_CONTACTS + ";";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(CountQuery, null);
            cursor.close();

        //Return count
        return cursor.getCount();
    }

    //updating a single contact
    public int updateContact(contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, contact.get_name()); //Contact Name
        values.put(KEY_PH_NO, contact.get_phone_number()); //Phone number

        //Updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + "=?",
                new String[]{ String.valueOf(contact.get_id()) });

    }

    //Deleting a single contact
    public void deleteContact(contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + "=?",
                new String[]{ String.valueOf(contact.get_id()) });

        db.close();
    }
}
