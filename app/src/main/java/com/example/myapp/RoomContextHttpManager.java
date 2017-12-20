package com.example.myapp;

import android.content.Context;
import android.view.View;

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
    private View view;


    /*get room from sensed context
    String url = CONTEXT_SERVER_URL + "/" + room + "/switchlight";
    //get room sensed context
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id = response.getString("id").toString();
                            int lightLevel = Integer.parseInt(response.getJSONObject("light").get("level").toString());
                            String lightStatus = response.getJSONObject("light").get("status").toString();
                            int noiseLevel = Integer.parseInt(response.getJSONObject("noise").get("level").toString());
                            String noiseStatus = response.getJSONObject("noise").get("status").toString();

                            //updating state
                            state.setRoom(id);
                            state.setLevelLight(lightLevel);
                            state.setStatusLight(lightStatus);
                            state.setLevelNoise(noiseLevel);
                            state.setStatusNoise(noiseStatus);

     */
    public void switchLight(final RoomContextState state, String room){

        String url = CONTEXT_SERVER_URL + "/" + room + "/switchlight";

        //get room sensed context
        JsonObjectRequest postRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            //find current light status
                            String lightStatus = state.getStatusLight();

                            //switching light status
                            String newLightStatus;
                            if(lightStatus.equals("ON")){
                                newLightStatus = "OFF";
                            }
                            else{
                                newLightStatus = "ON";
                            }

                            //post request inutil?
                            //response.postJSONObject("light").post("status").toString();

                            //update light status
                            state.setStatusLight(newLightStatus);

                            // TO DO -- notify ContextManagementActivity for update and to refresh the iew
                            //onUpdate(state);

                           }

                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Some error to access URL : Room may not exists...
                    }
                });
        queue.add(postRequest);
    }

    /*private void onUpdate(RoomContextState state) {
        view.redraw();
    }*/



    public void retrieveRoomContextState(String room){

        String url = CONTEXT_SERVER_URL + "/" + room ;
        //get room sensed context
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id = response.getString("id").toString();
                            int lightLevel = Integer.parseInt(response.getJSONObject("light").get("level").toString());
                            String lightStatus = response.getJSONObject("light").get("status").toString();
                            int noiseLevel = Integer.parseInt(response.getJSONObject("noise").get("level").toString());
                            String noiseStatus = response.getJSONObject("noise").get("status").toString();

                            //creating state
                            RoomContextState state = new RoomContextState(id, lightStatus, noiseStatus, lightLevel, noiseLevel);

                        }

                        catch (JSONException e) {
                            e.printStackTrace();
                        }

    }
}
