package br.com.xy.poi.service.util.enuns;

/**
 * @author Igor Emmanuel
 *
 *	Classe Enum responsavel por armazenar atributos das classes
 */
public enum AtributoEnum {
	
	NOME_POI("Nome do Ponto de Interesse", "NPOI"),
	COORDENADA_X("Coordenada X do POI", "CODX"),
	COORDENADA_Y("Coordenada Y do POI", "CODY"),
	DISTANCIA("Distancia do POI","DIST"),
	POI("Ponto de Interesse","POI");
	
	
	private String descricao;
	private String abreviacao;
	
	private AtributoEnum(String descricao, String abreviacao) {
		this.descricao = descricao;
		this.abreviacao = abreviacao;
	}
	
	/**
	 * @return abreviacao
	 */
	public String getAbreviacao() {
		return abreviacao;
	}

	/**
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return descricao
	 */
	public static AtributoEnum parse(String abreviacao) {
		for (AtributoEnum item : AtributoEnum.values()) {
			if (item.getAbreviacao().equalsIgnoreCase(abreviacao) ) {
				return item;
			}
		}
		return null;
	}
}
