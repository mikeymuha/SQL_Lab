package muhavani.com.sqlitelab;

/**
 * Created by mikey on 25/10/2017.
 */

public class Users {

        //private variables
        int id;
        String name;
        String status;

        //constructors
        public Users (){

        }

        //read operation
        public Users (int id, String name, String status) {
            this.id = id;
            this.name = name;
            this.status = status;
        }

        //write operation
        public Users (String name, String status){
            this.name = name;
            this.status = status;
        }

        //get id
        public int getID() {
            return this.id;
        }

        //set id
        public void setID(int id) {
            this.id = id;
        }

        //get name

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


}
