package com.example.android.insanyah.Helpers;


import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class JsonArrayRequest extends Request<JSONArray> {

    private Listener<JSONArray> listener;
    private Map<String, String> params;
    private Map<String, String> headers;

    public JsonArrayRequest(String url, Map<String, String> params, Map<String, String> headers, Listener<JSONArray> responseListener, ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = responseListener;
        this.params = params;
        this.headers=headers;
    }

    public JsonArrayRequest(int method, String url, Map<String, String> params, Map<String, String> headers, Listener<JSONArray> reponseListener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
        this.headers = headers;
    }

    @Override
    protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
        return params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            return Response.success(new JSONArray(jsonString), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            Log.v("res1", "err");
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            Log.v("res2", "err");
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONArray response) {
        listener.onResponse(response);
    }

}