package br.com.xy.poi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.xy.poi.service.controller.interfaces.IPoiController;
import br.com.xy.poi.service.entity.Poi;
import br.com.xy.poi.service.exception.CampoObrigatorioNaoInformadoException;
import br.com.xy.poi.service.exception.InformacaoInvalidaException;
import br.com.xy.poi.service.util.ConstanteUtil;

/**
 * @author Igor Emmanuel
 *
 *	Classe que implementa os Servicos Web disponibilizados no projeto.
 */
@Resource
public class PoiService {

	private final Result result;
	private final IPoiController poiController;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	public PoiService(Result result, IPoiController poiController) {
		super();
		this.result = result;
		this.poiController = poiController;
	}

	@Get
	@Path("/findAll")
	public void buscaTodos() {
		
		log.info("Listagem de todos os POIs solicitada...");
		List<Poi> listaPoi = poiController.buscaTodos();

		log.info("Busca realizada com sucesso...");
		result.use(Results.json()).withoutRoot().from(listaPoi).recursive()
				.serialize();
	}
	

	@Get
	@Path("/save/{poi.nome}/{poi.coodx}/{poi.coody}")
	public void cadastrar(Poi poi) {

		try {

			if(poi == null){
				result.use(Results.json()).withoutRoot().from(ConstanteUtil.MENSAGEM_OBJETO_INVALIDO)
				.recursive().serialize();
				
				return;
			}
			
			log.info("Cadastro de novo POI solicitado...");
			Poi poiResult = poiController.salvar(poi);

			log.info("Cadastro concluido com sucesso");
			result.use(Results.json()).withoutRoot().from(poiResult)
					.recursive().serialize();
		} catch (CampoObrigatorioNaoInformadoException e) {

			result.use(Results.json()).withoutRoot()
					.from(e.retornaMensagemErroFormatada()).recursive()
					.serialize();
			
		} catch (InformacaoInvalidaException e) {

			result.use(Results.json()).withoutRoot()
					.from(e.retornaMensagemErroFormatada()).recursive()
					.serialize();
		} catch (Exception e) {

			result.use(Results.json()).withoutRoot()
					.from(ConstanteUtil.MENSAGEM_EXCECAO_INESPERADO)
					.recursive().serialize();
		}

	}
	
	@Post
	@Path("/save")
	public void cadastrarPost(Poi poi) {

		try {

			if(poi == null){
				result.use(Results.json()).withoutRoot().from(ConstanteUtil.MENSAGEM_OBJETO_INVALIDO)
				.recursive().serialize();
				
				return;
			}
			
			log.info("Cadastro de novo POI solicitado...");
			Poi poiResult = poiController.salvar(poi);

			log.info("Cadastro concluido com sucesso");
			result.use(Results.json()).withoutRoot().from(poiResult)
					.recursive().serialize();
		} catch (CampoObrigatorioNaoInformadoException e) {

			result.use(Results.json()).withoutRoot()
					.from(e.retornaMensagemErroFormatada()).recursive()
					.serialize();
			
		} catch (InformacaoInvalidaException e) {

			result.use(Results.json()).withoutRoot()
					.from(e.retornaMensagemErroFormatada()).recursive()
					.serialize();
		} catch (Exception e) {

			result.use(Results.json()).withoutRoot()
					.from(ConstanteUtil.MENSAGEM_EXCECAO_INESPERADO)
					.recursive().serialize();
		}

	}
	

	@Get
	@Path("/find/{poi.coodx}/{poi.coody}/{distancia}")
	public void buscarPoi(Poi poi, Integer distancia) {

		try{
			
			if(poi == null){
				result.use(Results.json()).withoutRoot().from(ConstanteUtil.MENSAGEM_OBJETO_INVALIDO)
				.recursive().serialize();
				
				return;
			}
			
			log.info("Busca de POIs por referencia solicitada...");
			List<Poi> listaResult = poiController.buscaPorCoordenadas(
					poi, distancia);

			log.info("Busca realizada com sucesso...");
			result.use(Results.json()).withoutRoot().from(listaResult).recursive()
					.serialize();
			
		} catch (InformacaoInvalidaException e) {

			result.use(Results.json()).withoutRoot()
					.from(e.retornaMensagemErroFormatada()).recursive()
					.serialize();
		} catch (Exception e) {

			result.use(Results.json()).withoutRoot()
					.from(ConstanteUtil.MENSAGEM_EXCECAO_INESPERADO)
					.recursive().serialize();
		}

	}
	

}
