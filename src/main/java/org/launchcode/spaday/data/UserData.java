package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;

public class UserData {
    private ArrayList <User> users = new ArrayList<>();
    //add, getAll, getByID

    public void add(User user){
        users.add(user);
        return;
    }

    public ArrayList<User> getAll(){
        return this.users;
    }

    public User getById(int id){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId() == id) return users.get(i);
        }
        return null;
    }
}
