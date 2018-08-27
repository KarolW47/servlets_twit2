package com.sda.twit2;

public class AuthenticationHolder {
    public static boolean auth = false;

    public static boolean isAuth() {
        return auth;
    }

    public static void setAuth(boolean auth) {
        AuthenticationHolder.auth = auth;
    }
}
