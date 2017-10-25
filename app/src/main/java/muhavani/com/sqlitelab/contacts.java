package muhavani.com.sqlitelab;

/**
 * Created by mikey on 19/10/2017.
 */

public class contacts {

    //private variables

    int _id;
    String _name;
    String _phone_number;

    public contacts(){}

    public contacts(int id, String _name, String _phone_number){
        this._id  =id;
        this._name = _name;
        this._phone_number= _phone_number;

    }
    public contacts(String _name, String _phone_number){
        this._name = _name;
        this._phone_number= _phone_number;
    }

    //Getting ID
    public int get_id(){
        return this._id;
    }

    //Setting ID
    public void set_id(int _id) {
        this._id = _id;
    }

    //Get Phone Number
    public String get_phone_number() {
        return _phone_number;
    }

    //Set Phone Number
    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }

    //Get name
    public String get_name() {
        return _name;
    }

    //Set Name
    public void set_name(String _name) {
        this._name = _name;
    }
}
