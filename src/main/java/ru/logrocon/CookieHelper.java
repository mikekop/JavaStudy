package ru.logrocon;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieHelper {

    public static void addCookie(String cookieName, String cookieValue, HttpServletResponse response) {
        String safeCookieName = cookieName, safeCookieValue = cookieValue;
        try {
             safeCookieName = URLEncoder.encode(cookieName, "UTF-8");
             safeCookieValue = URLEncoder.encode(cookieValue, "UTF-8");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        Cookie cookie = new Cookie(safeCookieName, safeCookieValue);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.setContentType("text/html;charset=UTF-8");
        response.addCookie(cookie);
    }

    public static String getCookieValue(String cookieName, HttpServletRequest request){
        Cookie cookie = null;
        String safeCookieName = cookieName, safeCookieValue="";
        try {
            safeCookieName = URLDecoder.decode(cookieName, "UTF-8");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        for(Cookie c :request.getCookies()){
            if(c.getName().equals(safeCookieName)){
                cookie = c;
                break;
            }
        }

        if(cookie != null){
            try {
                safeCookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }


        return safeCookieValue;
    }
}
