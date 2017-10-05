package com.example.android.insanyah.Helpers;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by mohamedmoosa on 9/17/17.
 */

public class Requests {

    public Requests(){
    }

    public static void getRequest(String urls,Callback callback){

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(urls).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("X-ApiKey","fc558353-b4b6-4a57-9b69-689219e40a41")
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

    public static void postRequest(String urls, RequestBody body,Callback callback){

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(urls).newBuilder();
        String url = urlBuilder.build().toString();


        Request request = new Request.Builder()
                .header("X-ApiKey","fc558353-b4b6-4a57-9b69-689219e40a41")
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(callback);

    }


}
