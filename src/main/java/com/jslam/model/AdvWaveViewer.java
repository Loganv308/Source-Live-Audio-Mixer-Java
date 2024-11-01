package com.jslam.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.decoder.SampleBuffer;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.sound.sampled.*;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AdvWaveViewer extends Canvas {

    private Clip audioClip;
    private AnimationTimer timer;
    private AudioInputStream audioInput;
    private byte[] audioBytes;
    private int sampleSize;
    private AdvancedPlayer mp3Player;
    private Bitstream bitstream;

    public void loadAudio(String filePath) throws JavaLayerException, UnsupportedAudioFileException, IOException, LineUnavailableException{
        if (filePath.endsWith(".wav")) {
            File audioFile = new File(filePath);
            audioInput = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioInput);
        } else if (filePath.endsWith(".mp3")) {
            InputStream mp3Stream = new FileInputStream(filePath);
            bitstream = new Bitstream(mp3Stream);
            mp3Player = new AdvancedPlayer(mp3Stream);
        } else {
            throw new UnsupportedAudioFileException("Unsupported format");
        }
    }

    public void play() {
        if (audioClip != null && !audioClip.isRunning()) {
            audioClip.start();
            startWaveformAnimation();
        }
    }

    public void stop() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            stopWaveformAnimation();
        }
    }

    private void startWaveformAnimation() {
        GraphicsContext gc = getGraphicsContext2D();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                drawWaveForm(gc);
            }
        };
        timer.start();
    }
    
    private void stopWaveformAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }

    
    public void drawWaveForm(GraphicsContext gc) {
        try {
            int bytesRead = audioInput.read(audioBytes, 0, audioBytes.length);
            if (bytesRead == -1) {
                stop();
                return;
            }

            // Clear the canvas
            gc.clearRect(0, 0, getWidth(), getHeight());

            // Draw the waveform
            gc.setStroke(Color.BLUE);
            gc.setLineWidth(1);

            double midY = getHeight() / 2.0;
            double scaleFactor = getHeight() / 128.0; // Adjust for amplitude scaling
            int frameSize = audioInput.getFormat().getFrameSize();

            for (int i = 0; i < bytesRead / frameSize; i++) {
                // Convert bytes to amplitude
                int amplitude = ((audioBytes[i * 2 + 1] << 8) | (audioBytes[i * 2] & 0xff));
                
                // Map the amplitude to canvas coordinates
                double x = (i / (double) sampleSize) * getWidth();
                double y = midY - (amplitude * scaleFactor);
                
                // Draw line or dots for waveform effect
                if (i > 0) {
                    gc.strokeLine((i - 1) / (double) sampleSize * getWidth(), 
                                  midY - ((audioBytes[(i - 1) * 2 + 1] << 8 | (audioBytes[(i - 1) * 2] & 0xff)) * scaleFactor), 
                                  x, y);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
