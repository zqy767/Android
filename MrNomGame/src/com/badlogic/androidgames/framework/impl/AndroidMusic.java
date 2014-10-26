package com.badlogic.androidgames.framework.impl;

import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.badlogic.androidgames.framework.Music;

public class AndroidMusic implements Music, OnCompletionListener {
	MediaPlayer mediaPlayer;
	boolean isprepared = false;

	public AndroidMusic(AssetFileDescriptor assetDescriptor) {
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(),
					assetDescriptor.getStartOffset(),
					assetDescriptor.getLength());
			mediaPlayer.prepare();
			isprepared = true;
			mediaPlayer.setOnCompletionListener(this);
		} catch (Exception e) {
			throw new RuntimeException("counldnt load music");
		}
	}

	@Override
	public void play() {
		if (mediaPlayer.isPlaying())
			return;
		try {
			synchronized (this) {
				if (!isprepared)
					mediaPlayer.prepare();
				mediaPlayer.start();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		mediaPlayer.stop();
		synchronized (this) {
			isprepared = false;
		}
	}

	@Override
	public void pause() {
		if (mediaPlayer.isPlaying())
			mediaPlayer.pause();

	}

	@Override
	public void setLooping(boolean isLooping) {
		mediaPlayer.setLooping(isLooping);

	}

	@Override
	public void setVolume(float volume) {
		mediaPlayer.setVolume(volume, volume);

	}

	@Override
	public boolean isPlaying() {
		return mediaPlayer.isPlaying();
	}

	@Override
	public boolean isStopped() {
		return !isprepared;
	}

	@Override
	public boolean isLooping() {
		return mediaPlayer.isLooping();
	}

	@Override
	public void dispose() {
		if (mediaPlayer.isPlaying())
			mediaPlayer.stop();
		mediaPlayer.release();
	}

	@Override
	public void onCompletion(MediaPlayer player) {
		synchronized (this) {
			isprepared = false;
		}

	}

}
