package com.jslam.model;

import java.util.Arrays;
import java.util.List;

public class SourceGame {
    public String name;
    public int id;
    public String directory;
    public String toCfg;
    public String libraryName;
    public boolean voiceFadeOut;
    public String exeName = "hl2";
    public List<String> fileExtensions = Arrays.asList(".wav", ".mp3");

    public int sampleRate = 11025;
    public int bits = 16;
    public int channels = 1;
    public int pollInterval = 100;
    public List<Track> tracks;

    public List<String> blacklist = Arrays.asList("slam", "slam_listtracks", "list", "tracks", "la", "slam_play", "slam_play_on", "slam_play_off", "slam_updatecfg", "slam_curtrack", "slam_saycurtrack", "slam_sayteamcurtrack");

    // Constructor 
    public SourceGame(String name, int id, String directory, String toCfg, String libraryName, boolean voiceFadeOut, String exeName, List<String> fileExtensions, int sampleRate, int bits, int channels, int pollInterval, List<String> blackList) {
        this.name = name;
        this.id = id;
        this.directory = directory;
        this.toCfg = toCfg;
        this.libraryName = libraryName;
        this.voiceFadeOut = voiceFadeOut;
        this.exeName = exeName;
        this.fileExtensions = fileExtensions;
        this.sampleRate = sampleRate;
        this.bits = bits;
        this.channels = channels;
        this.pollInterval = pollInterval;
        this.blacklist = blackList;
    }
    public class Track {
        public String name;
        public List<String> tags;
        public String hotKey = null;
        public int volume = 100;
        public int startPos;
        public int endPos;

        public Track(String name, List<String> tags, String hotKey, int volume, int startPos, int endPos) {
            this.name = name;
            this.tags = tags;
            this.hotKey = hotKey;
            this.volume = volume;
            this.startPos = startPos;
            this.endPos = endPos;
        }
    }
    
    
}   
