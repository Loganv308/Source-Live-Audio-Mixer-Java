package com.jslam.model;

import java.util.Arrays;
import java.util.List;

import com.jslam.model.Track;

public class SourceGame {
    public String name;
    public int id;
    public String directory;
    public String toCfg;
    public String libraryName;
    public boolean voiceFadeOut;
    public String exename = "hl2";
    public List<String> fileExtensions = Arrays.asList(".wav", ".mp3", ".ogg");

    public int sampleRate = 11025;
    public int bits = 16;
    public int channels = 1;
    public int pollInterval = 100;
    public List<Track> tracks;

    public List<String> blacklist = Arrays.asList("slam", "slam_listtracks", "list", "tracks", "la", "slam_play", "slam_play_on", "slam_play_off", "slam_updatecfg", "slam_curtrack", "slam_saycurtrack", "slam_sayteamcurtrack");
}   
