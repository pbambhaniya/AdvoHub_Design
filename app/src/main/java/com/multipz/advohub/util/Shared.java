package com.multipz.advohub.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Shared {
    SharedPreferences pref;
    Editor edit;

    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String LOGIN = "LoggedIn";


    public Shared(Context c) {
        // TODO Auto-generated constructor stub

        pref = c.getSharedPreferences("file_pref", Context.MODE_PRIVATE);
        edit = pref.edit();
    }

    public void putBoolean(String key, boolean b) {
        edit.putBoolean(key, b);
        edit.commit();
    }

    public boolean getBoolean(String key, boolean b) {
        return pref.getBoolean(key, b);
    }

    public void putString(String key, String def) {
        edit.putString(key, def);
        edit.commit();
    }

    public String getString(String key, String def) {
        return pref.getString(key, def);
    }

    public void putInt(String key, int def) {
        edit.putInt(key, def);
        edit.commit();
    }


    public int getInt(String key) {
        return pref.getInt(key, 0);
    }

    /****************************************Set Login********************************************/

    public String getlogin() {

        String aut_key = pref.getString(LOGIN, "");
        return aut_key;
    }

    public void setlogin(boolean login) {

        edit.putBoolean(IS_LOGIN, login);
        // commit changes
        edit.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void logout() {
        edit.clear();
        edit.commit();
    }

    /****************************************End Login********************************************/


}
