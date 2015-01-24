package br.com.xy.poi.service.repository.test;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.com.xy.poi.service.controller.test.builder.PoiBuilder;
import br.com.xy.poi.service.entity.Poi;
import br.com.xy.poi.service.repository.PoiRepository;

/**
 * @author Igor Emmanuel
 *	
 * Classe que implementa os testes unitarios dos metodos do {@link PoiRepository}
 */
public class PoiRepositoryTest {
	
	private Poi poi;
	private Logger log = LoggerFactory.getLogger(getClass());

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	
	public PoiRepository poiRepository = new PoiRepository(factory.createEntityManager());
	
	@Before
	public void init(){
		poi = PoiBuilder.construir();
		
		poiRepository.create(poi);
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testaSalvar(){
		
		log.info("Rodando - testaSalvar()");
		
		Poi novoPoi = PoiBuilder.construir();
		
		poiRepository.cadastraPoi(novoPoi);
		
		Assert.assertNotNull(novoPoi.getId());
	}
	
	@Test
	@Transactional
	@Rollback
	public void testarBuscarTodos(){
		
		log.info("Rodando - testarBuscarTodos()");
		
		List<Poi> listaPoi = poiRepository.buscaTodos();
		
		Assert.assertNotNull(listaPoi);
	}

}
