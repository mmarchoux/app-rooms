package com.example.myapp;

/**
 * Created by Mathilde on 19/12/2017.
 */

public class RoomContextState {

    private String room;
    private String statusLight;
    private String statusNoise;
    private int levelLight;
    private int levelNoise;

    public RoomContextState(String room, String statusLight, String statusNoise, int levelLight, int levelNoise) {
        super();
        this.room = room;
        this.statusLight = statusLight;
        this.statusNoise = statusNoise;
        this.levelLight = levelLight;
        this.levelNoise = levelNoise;
    }

    //get methods
    public String getRoom() {
        return this.room;
    }

    public String getStatusLight() {
        return this.statusLight;
    }

    public String getStatusNoise() {
        return this.statusNoise;
    }

    public int getLevelLight() {
        return this.levelLight;
    }

    public int getLevelNoise() {
        return this.levelNoise;
    }

    //set methods
    public void setRoom(String room) {
        this.room = room;
    }

    public void setStatusLight(String statusL) {
        this.statusLight = statusL;
    }

    public void setStatusNoise(String statusN) {
        this.statusNoise = statusN;
    }

    public void setLevelLight(int levelL) {
        this.levelLight = levelL;
    }

    public void setLevelNoise(int levelN) {
        this.levelNoise = levelN;
    }

}