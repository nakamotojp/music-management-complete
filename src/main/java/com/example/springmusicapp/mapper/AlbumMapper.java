package com.example.springmusicapp.mapper;

import com.example.springmusicapp.entity.Album;
import com.example.springmusicapp.viewmodel.AlbumViewModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AlbumMapper {

    @Insert("INSERT INTO albums (title, artist, release_date) VALUES (#{title}, #{artist}, #{releaseDate})")
    @Options(useGeneratedKeys = true, keyProperty = "albumId")
    void insertAlbum(Album album);

    @Select("SELECT * FROM albums")
    List<Album> selectAllAlbums();

    @Select("""
            SELECT albums.album_id, albums.title, artist, release_date, count(musics.music_id) AS music_count
            FROM albums
            LEFT OUTER JOIN musics ON albums.album_id = musics.album_id
            GROUP BY albums.album_id, albums.title, artist, release_date
            """)
    public List<AlbumViewModel> selectAllAlbumsWithMusicCount();

    @Select("SELECT * FROM albums WHERE album_id = #{albumId}")
    Album selectAlbumById(long albumId);

    @Delete("DELETE FROM albums WHERE album_id = #{albumId}")
    void deleteAlbumById(long albumId);

    @Update("UPDATE albums SET title = #{title}, artist = #{artist}, release_date = #{releaseDate} WHERE album_id = #{albumId}")
    void updateAlbum(Album album);
}
