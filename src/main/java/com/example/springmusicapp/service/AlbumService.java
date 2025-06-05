package com.example.springmusicapp.service;

import com.example.springmusicapp.entity.Album;
import com.example.springmusicapp.exception.AlbumNotFoundException;
import com.example.springmusicapp.form.AlbumForm;
import com.example.springmusicapp.repository.AlbumRepository;
import com.example.springmusicapp.viewmodel.AlbumViewModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public void createAlbum(AlbumForm albumForm) {
        Album album = new Album();
        album.setTitle(albumForm.getTitle());
        album.setArtist(albumForm.getArtist());
        album.setReleaseDate(albumForm.getReleaseDate());
        albumRepository.insertAlbum(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    public List<AlbumViewModel> getAllAlbumsWithMusicCount() {
        return albumRepository.getAllAlbumsWithMusicCount();
    }

    public Album getAlbumById(long albumId) {
        return albumRepository.getAlbumById(albumId);
    }

    public void deleteAlbum(long albumId) {
        albumRepository.deleteAlbum(albumId);
    }

    @Transactional
    public void updateAlbum(long albumId, Album album) {
        Album existingAlbum = getAlbumById(albumId);
        if (existingAlbum == null) {
            throw new AlbumNotFoundException("Album not found");
        }

        if (albumId != album.getAlbumId()) {
            throw new AlbumNotFoundException("Album ID does not match");
        }
        albumRepository.updateAlbum(album);
    }
}
