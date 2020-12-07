package br.com.unipe.aula.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unipe.aula.model.Album;

@Repository
public class AlbumDAO {
	
	private static List<Album> albums;
	
	public AlbumDAO() {
		albums = new LinkedList<Album>();
	}
	
	public void salvar(Album album) {
		albums.add(album);
		System.out.println(albums);
	}
	
	public List<Album> getAll() {
		return albums;
	}
	
	public Album getId(int id) {
		return albums.get(id);
	}
	
	public void excluir(int id) {
		albums.remove(id);
	}
	
	public void editar(int id, Album album) {
		albums.get(id).setNome(album.getNome());
		albums.get(id).setInterprete(album.getInterprete());
	}

}
