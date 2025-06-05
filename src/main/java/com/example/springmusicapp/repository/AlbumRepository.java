package com.example.springmusicapp.repository;

import com.example.springmusicapp.entity.Album;
import com.example.springmusicapp.mapper.AlbumMapper;
import com.example.springmusicapp.viewmodel.AlbumViewModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    private final AlbumMapper albumMapper;

    public AlbumRepository(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    public void insertAlbum(Album album) {
        albumMapper.insertAlbum(album);
    }

    public List<Album> getAllAlbums() {
        return albumMapper.selectAllAlbums();
    }

    public List<AlbumViewModel> getAllAlbumsWithMusicCount() {
        return albumMapper.selectAllAlbumsWithMusicCount();
    }

    public Album getAlbumById(long albumId) {
        return albumMapper.selectAlbumById(albumId);
    }

    public void deleteAlbum(long albumId) {
        albumMapper.deleteAlbumById(albumId);
    }

    public void updateAlbum(Album album) {
        albumMapper.updateAlbum(album);
    }

}
