# -xy-inc
Repositório destinado a armazenar o projeto PoiService para a empresa XY-INC.

As seguintes instruções devem ser realizadas para a execução/teste do projeto PoiService:

  * Preparação do ambiente:
    * Instalar banco de dados Postgres (http://www.postgresql.org/download/) com configurações padronizadas (database=postgres,user=postgres, pass=123);
    * Instalar o TomCat 6 (http://tomcat.apache.org/download-60.cgi);
    * Instalar o Maven 3.2.5 (http://maven.apache.org/download.cgi).
  
  * Iniciar serviços:
    * Rodar o script XY-INC-INIT-BASE.sql na base de dados PostgresSQL (o script será responsável por criar o schema POI, a tabela POI e inserir registros iniciais);
    * Rodar o comando 'maven clean install' no diretório onde o projeto foi baixado(para que seja gerado o arquivo .war do projeto);
    * Startar uma instância do TomCat com o arquivo .war do projeto:
      * Incluir arquivo .war na pasta webapps do TomCat;
      * Iniciar os serviços do TomCat.
      
  * Testar serviços: (GET)
    * Testar serivço de cadastro de POI:
      * Inserir na URL do browser: {endpoint}/poiRest/save/{poi.nome}/{poi.x}/{poi.y}
      * Verificar retorno do serviço => Informações do novo POI cadastrado em formato JSON.
    * Testar serviço de busca dos POI cadastrados:
      * Inserir na URL do browser: {endpoint}/poiRest/findAll
      * Verificar retorno do serviço => Informações de todos os POIs cadastrado em formato JSON.
    * Testar serviço de busca dos POI por referencia:
      * Inserir na URL do browser: {endpoint}/poiRest/find/{x}/{y}/{referencia}
      * Verificar retorno do serviço => Informações de todos os POIs cadastrado que satisfazem a referencia em formato JSON.
