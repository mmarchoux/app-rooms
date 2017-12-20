package com.example.myapp;

/**
 * Created by Mathilde on 19/12/2017.
 */

public class RoomContextState {

    private String room;
    private String statusLight;
    private String statusNoise;
    private int levelLight;
    private float levelNoise;

    public RoomContextState(String room, String statusLight, String statusNoise, int levelLight, float levelNoise) {
        super();
        this.room = room;
        this.statusLight = statusLight;
        this.statusNoise = statusNoise;
        this.levelLight = levelLight;
        this.levelNoise = levelNoise;
    }

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

    public float getLevelNoise() {
        return this.levelNoise;
    }
}