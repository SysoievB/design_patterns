package com.command;

public interface Speaker {
    void volumeUp();

    void volumeDown();

    void play();

    void pause();
}
interface Command {
    void execute();
}
class VolumeUp implements Command {

    private final Speaker speaker;

    public VolumeUp(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.volumeUp();
    }
}

class VolumeDown implements Command {

    private final Speaker speaker;

    public VolumeDown(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.volumeDown();
    }
}

class Play implements Command {

    private final Speaker speaker;

    public Play(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.play();
    }
}

class Pause implements Command {

    private final Speaker speaker;

    public Pause(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.pause();
    }
}