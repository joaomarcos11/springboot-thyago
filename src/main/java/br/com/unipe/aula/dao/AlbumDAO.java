package br.com.unipe.aula.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipe.aula.model.Album;

@Repository
public class AlbumDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public AlbumDAO() {

	}
	
	@Transactional(readOnly = false)
	public void salvar(Album album) {
		entityManager.persist(album);
	}
	
	@Transactional(readOnly = true)
	public List<Album> getAll() {
		String jpql = "from Album u";
		TypedQuery<Album> consulta = entityManager.createQuery(jpql, Album.class);
	
		return consulta.getResultList();
	}
	
	public Album getId(Long id) {
		return entityManager.find(Album.class, id);
	}
	
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		Album album = getId(id);
		entityManager.remove(album);
	}
	
	@Transactional(readOnly = false)
	public void editar(Album album) {
		entityManager.merge(album);
	}

}
