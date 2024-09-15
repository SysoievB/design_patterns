package com.command;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Speaker speaker = new SpeakerImpl();

        App app = new App();

        app.add(speaker::play);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeDown);
        app.add(speaker::volumeDown);
        app.add(speaker::pause);

        app.run();
    }
}

class SpeakerImpl implements Speaker {

    private int volume;
    private boolean isPlaying;

    public SpeakerImpl() {
        this.volume = 5; // Let's start the speaker with volume 5 (out of 10)
        this.isPlaying = false; // Initially, the speaker is paused
    }

    @Override
    public void volumeUp() {
        if (volume < 10) { // Assuming max volume is 10
            volume++;
            System.out.println("Volume increased to: " + volume);
        } else {
            System.out.println("Volume is already at maximum!");
        }
    }

    @Override
    public void volumeDown() {
        if (volume > 0) { // Assuming min volume is 0
            volume--;
            System.out.println("Volume decreased to: " + volume);
        } else {
            System.out.println("Volume is already at minimum!");
        }
    }

    @Override
    public void play() {
        if (!isPlaying) {
            isPlaying = true;
            System.out.println("Playing music...");
        } else {
            System.out.println("Already playing!");
        }
    }

    @Override
    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Music paused.");
        } else {
            System.out.println("Music is already paused.");
        }
    }
}


class App {
    private final List<Command> commands;

    public App() {
        commands = new ArrayList<>();
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void run() {
        for (Command command : commands) {
            command.execute();
        }
    }
}