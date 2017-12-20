package com.example.myapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mathilde on 19/12/2017.
 */

public abstract class RoomContextHttpManager extends Context {


    RequestQueue queue = Volley.newRequestQueue(this);
    String CONTEXT_SERVER_URL ="https://enigmatic-sands-54357.herokuapp.com/api/rooms";

    public void switchLight(RoomContextState state, String room){

        String url = CONTEXT_SERVER_URL + "/" + room + "/switchlight";

        //get room sensed context
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id = response.getString("id").toString();
                            int lightLevel = Integer.parseInt(response.getJSONObject("light").get("level").toString());
                            String lightStatus = response.getJSONObject("light").get("status").toString();
                            float noiseLevel = Integer.parseInt(response.getJSONObject("noise").get("level").toString());
                            String noiseStatus = response.getJSONObject("noise").get("status").toString();

                            //state = new RoomContextState(id, lightStatus, noiseStatus, lightLevel, noiseLevel);
                            // notify main activity for update...
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Some error to access URL : Room may not exists...
                    }
                });
        queue.add(contextRequest);
        onUpdate(state);
    }

    private void onUpdate(RoomContextState state) {
    }



    public void retrieveRoomContextState(String room){

    }
}
