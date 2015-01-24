package br.com.xy.poi.service.repository.interfaces;

import java.util.List;

import br.com.xy.poi.service.entity.*;
import br.com.xy.poi.service.repository.PoiRepository;

/**
 * @author Igor Emmanuel
 *
 * Interface que assina os metodos da {@link PoiRepository}
 */
public interface IPoiRepository {

	/**
	 * Metodo responsavel por persistir um objeto POI na base de dados
	 * 
	 * @param poi
	 * @return
	 */
	public Poi cadastraPoi(Poi poi);

	/**
	 * Metodo responsavel por buscar todos os POIs da base de dados
	 * 
	 * @return
	 */
	public List<Poi> buscaTodos();

	/**
	 * Metodo responsavel por buscar todos os POIs que estao a distancia raio
	 * do ponto d referencia
	 * 
	 * @param x
	 * @param y
	 * @param raio
	 * @return
	 */
	public List<Poi> buscaPorCoordenadas(Integer x, Integer y, Integer raio);

}
