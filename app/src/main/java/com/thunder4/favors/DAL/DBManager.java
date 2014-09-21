package com.thunder4.favors.DAL;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Clement on 9/21/2014.
 * sends HTTP requests to the VPS and returns data to the android client
 */
public class DBManager {
    public static String server = "107.170.79.163:5000";

    public static String GetAllPostsInDescOrder() {
        String url = server + "/post/desc";

        String jsonToParse = HttpGetMethod3(url);
        return jsonToParse;
    }

    public static String HttpGetMethod3(String url) {
        try {
            HttpClient Client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String x = Client.execute(httpget, responseHandler);
        } catch(UnsupportedEncodingException ex) {
        } catch(Exception ex) {
        }
        return "";
    }

    public static String SendHttpGet(String url) {
        HttpGet httpget = new HttpGet(url);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            return new DefaultHttpClient().execute(httpget, responseHandler);
        } catch (ClientProtocolException e) { return ""; }
         catch (IOException e) { return ""; }
    }

    public static String SendHttpRequest(String url) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                String responseString = out.toString();
                return responseString;
            } else {
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (IOException e) { Log.d("", e.getMessage()); }
        return null;
    }
}
