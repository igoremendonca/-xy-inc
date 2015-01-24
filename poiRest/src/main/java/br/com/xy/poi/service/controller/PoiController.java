package br.com.xy.poi.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.xy.poi.service.PoiService;
import br.com.xy.poi.service.controller.interfaces.IPoiController;
import br.com.xy.poi.service.entity.Poi;
import br.com.xy.poi.service.exception.CampoObrigatorioNaoInformadoException;
import br.com.xy.poi.service.exception.InformacaoInvalidaException;
import br.com.xy.poi.service.repository.interfaces.IPoiRepository;
import br.com.xy.poi.service.util.CampoUtil;
import br.com.xy.poi.service.util.ConstanteUtil;
import br.com.xy.poi.service.util.enuns.AtributoEnum;

/**
 * @author Igor Emmanuel
 *
 * Classe responsavel por gerenciara as requisicoes vindas do {@link PoiService} e responde-las.
 * Acessa a Interface {@link IPoiRepository} para solicitar serviços da classe repositorio. 
 */
@Component
public class PoiController implements IPoiController {

	private final IPoiRepository poiRepository;
	private Logger log = LoggerFactory.getLogger(getClass());

	public PoiController(IPoiRepository poiRepository) {
		super();
		this.poiRepository = poiRepository;
	}
	
	public List<Poi> buscaTodos() {
		
		log.info("Buscanco POIs na base de dados...");
		List<Poi> listaPoi = poiRepository.buscaTodos();

		return listaPoi;
	}

	public Poi salvar(Poi poi) throws CampoObrigatorioNaoInformadoException,
			InformacaoInvalidaException, Exception {
		try {
			
			log.info("Validando informacoes do POI...");
			validaPoiAntesSalvar(poi);

			log.info("Salvando POI na base de dados");
			Poi poiResult = poiRepository.cadastraPoi(poi);

			return poiResult;
			
		} catch (CampoObrigatorioNaoInformadoException e) {
			
			log.info("Excecao CampoObrigatorioNaoInformadoException() lancada.");
			throw e;
			
		} catch (InformacaoInvalidaException e) {
			
			log.info("Excecao InformacaoInvalidaException() lancada.");
			throw e;
			
		} catch (Exception e) {

			log.info("Excecao nao esperada lancada.");
			throw e;
		}
	}

	public List<Poi> buscaPorCoordenadas(Poi poi,
			Integer distancia) throws InformacaoInvalidaException, Exception {
		try{
			
			log.info("Validando informacoes do POI...");
			validaAntesBuscar(poi, distancia);
			
			log.info("Buscando POIs de acordo com os paramentros...");
			List<Poi> listaResult = poiRepository.buscaPorCoordenadas(
					poi.getCoodx(), poi.getCoody(), distancia);

			return listaResult;
			
		} catch (InformacaoInvalidaException e) {

			log.info("Excecao InformacaoInvalidaException() lancada.");
			throw e;
			
		} catch (Exception e) {

			log.info("Excecao nao esperada lancada.");
			throw e;
			
		}
	}

	/** Metodo responsavel por validar os elementos passados como parametro para a busca dos POIs
	 * @param poi
	 * @param distancia
	 * @throws InformacaoInvalidaException
	 */
	private void validaAntesBuscar(Poi poi, Integer distancia) throws InformacaoInvalidaException {
		
		validaCamposInvalidos(poi, distancia);
		
	}

	/** Metodo responsavel por validar as informacoes do POI antes de persisti-lo na base de dados
	 * @param poi
	 * @throws CampoObrigatorioNaoInformadoException
	 * @throws InformacaoInvalidaException
	 */
	private void validaPoiAntesSalvar(Poi poi)
			throws CampoObrigatorioNaoInformadoException,
			InformacaoInvalidaException {

		validaCamposObrigatorios(poi);

		validaCamposInvalidos(poi, 1);

	}

	/** Metodo responsavel por validar os campos do POI
	 * @param poi
	 * @param distancia
	 * @throws InformacaoInvalidaException
	 */
	private void validaCamposInvalidos(Poi poi, Integer distancia)
			throws InformacaoInvalidaException {

		List<CampoUtil> campos = new ArrayList<CampoUtil>();

		if (poi.getCoodx() <= 0) {
			CampoUtil campo = new CampoUtil(
					AtributoEnum.COORDENADA_X.getDescricao());
			campos.add(campo);
		}

		if (poi.getCoody() <= 0) {
			CampoUtil campo = new CampoUtil(
					AtributoEnum.COORDENADA_Y.getDescricao());
			campos.add(campo);
		}
		
		if(distancia < 0){
			CampoUtil campo = new CampoUtil(
					AtributoEnum.DISTANCIA.getDescricao());
			campos.add(campo);
		}

		if (campos.size() > 0) {
			throw new InformacaoInvalidaException(
					ConstanteUtil.MENSAGEM_EXCECAO_INFORMACAO_INVALIDA, campos);
		}

	}

	/** Metodo responsavel por validar os campos obrigatorio do POI
	 * @param poi
	 * @throws CampoObrigatorioNaoInformadoException
	 */
	private void validaCamposObrigatorios(Poi poi)
			throws CampoObrigatorioNaoInformadoException {

		List<CampoUtil> campos = new ArrayList<CampoUtil>();

		if(poi == null){
			CampoUtil campo = new CampoUtil(
					AtributoEnum.POI.getDescricao());
			campos.add(campo);
			
			throw new CampoObrigatorioNaoInformadoException(
					ConstanteUtil.MENSAGEM_EXCECAO_CAMPO_OBRIGAGORIO, campos);
		}
		
		if (poi.getNome() == null || poi.getNome().trim().equals("")) {
			CampoUtil campo = new CampoUtil(
					AtributoEnum.NOME_POI.getDescricao());
			campos.add(campo);
		}

		if (poi.getCoodx() == null) {
			CampoUtil campo = new CampoUtil(
					AtributoEnum.COORDENADA_X.getDescricao());
			campos.add(campo);
		}

		if (poi.getCoody() == null) {
			
			CampoUtil campo = new CampoUtil(
					AtributoEnum.COORDENADA_Y.getDescricao());
			campos.add(campo);
		}

		if (campos.size() > 0) {
			throw new CampoObrigatorioNaoInformadoException(
					ConstanteUtil.MENSAGEM_EXCECAO_CAMPO_OBRIGAGORIO, campos);
		}

	}

	

}
