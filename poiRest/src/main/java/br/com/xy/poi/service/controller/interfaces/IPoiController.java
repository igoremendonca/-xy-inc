package br.com.xy.poi.service.controller.interfaces;

import java.util.List;

import br.com.xy.poi.service.controller.PoiController;
import br.com.xy.poi.service.entity.*;
import br.com.xy.poi.service.exception.CampoObrigatorioNaoInformadoException;
import br.com.xy.poi.service.exception.InformacaoInvalidaException;

/**
 * @author Igor Emmanuel
 *
 * Interface que assina os metodos da classe {@link PoiController}.
 *  
 */
public interface IPoiController {

	/** Metodo responsavel por buscar todos os Poi da base dados
	 * @return
	 */
	List<Poi> buscaTodos();

	/** Metodo responsavel por persistir Poi na base de dados
	 * @param poi
	 * @return
	 * @throws CampoObrigatorioNaoInformadoException
	 * @throws InformacaoInvalidaException
	 */
	Poi salvar(Poi poi) throws CampoObrigatorioNaoInformadoException, InformacaoInvalidaException, Exception;

	/** Metodo responsavel por buscar os Pois a partir de uma coordenada de referencia e
	 * @param coodx
	 * @param coody
	 * @param distancia
	 * @return
	 * @throws InformacaoInvalidaException
	 */
	List<Poi> buscaPorCoordenadas(Poi poi,
			Integer distancia) throws InformacaoInvalidaException, Exception;

}
