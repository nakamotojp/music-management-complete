package com.example.springmusicapp.repository;

import com.example.springmusicapp.entity.Music;
import com.example.springmusicapp.mapper.MusicMapper;
import com.example.springmusicapp.viewmodel.MusicViewModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    private final MusicMapper musicMapper;

    public MusicRepository(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    public void insertMusic(Music music) {
        musicMapper.insertMusic(music);
    }

    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicMapper.selectMusicsById(albumId);
    }

    public void deleteMusicById(long musicId) {
        musicMapper.deleteMusicById(musicId);
    }

    public void updateMusic(Music music) {
        musicMapper.updateMusic(music);
    }

    public Music selectMusicById(long musicId) {
        return musicMapper.selectMusicById(musicId);
    }

    public List<MusicViewModel> selectMusicsWithFavorite(long albumId, long userId) {
        return musicMapper.selectMusicsWithFavorite(albumId, userId);
    }
}
