package br.com.dunasdev.weakserv.Clientes.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Clientes")
public class Clientes {

    @Id
    @Column(name = "CodCliente")
    private Integer codCliente;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Fantasia")
    private String fantasia;

    @Column(name = "CGCCPF")
    private String cGCCPF;

    @Column(name = "InscriçãoEstadual")
    private String inscricaoEstadual;

    @Column(name = "RG")
    private String rG;

    @Column(name = "OrgãoEmissorRG")
    private String orgaoEmissorRG;

    @Column(name = "DataEmissãoRG")
    private java.time.LocalDateTime dataEmissaoRG;

    @Column(name = "Endereço")
    private String endereco;

    @Column(name = "NumCasa")
    private String numCasa;

    @Column(name = "Celular")
    private String celular;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Observações")
    private String observacoes;

    @Column(name = "CodOcupação")
    private java.math.BigDecimal codOcupacao;

    @Column(name = "LimiteCrédito")
    private java.math.BigDecimal limiteCredito;

    @Column(name = "Bairro")
    private String bairro;

    @Column(name = "Cidade")
    private String cidade;

    @Column(name = "Naturalidade")
    private String naturalidade;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "EstadoNaturalidade")
    private String estadoNaturalidade;

    @Column(name = "CEP")
    private String cEP;

    @Column(name = "Fone1")
    private String fone1;

    @Column(name = "Fone2")
    private String fone2;

    @Column(name = "País")
    private String pais;

    @Column(name = "Nascimento")
    private java.time.LocalDateTime nascimento;

    @Column(name = "Pai")
    private String pai;

    @Column(name = "Mãe")
    private String mae;

    @Column(name = "Renda")
    private java.math.BigDecimal renda;

    @Column(name = "Cobrar")
    private Boolean cobrar;

    @Column(name = "Autorizados")
    private String autorizados;

    @Column(name = "DataCadastro")
    private java.time.LocalDateTime dataCadastro;

    @Column(name = "EndereçoCobrança")
    private String enderecoCobranca;

    @Column(name = "BairroCobrança")
    private String bairroCobranca;

    @Column(name = "CEPCobrança")
    private String cEPCobranca;

    @Column(name = "EstadoCobrança")
    private String estadoCobranca;

    @Column(name = "Praça")
    private String praca;

    @Column(name = "EmpresaTrabalha")
    private String empresaTrabalha;

    @Column(name = "Profissão")
    private String profissao;

    @Column(name = "FoneEmpresa")
    private String foneEmpresa;

    @Column(name = "DataAdmissão")
    private java.time.LocalDateTime dataAdmissao;

    @Column(name = "EstadoCivil")
    private String estadoCivil;

    @Column(name = "Cônjuge")
    private String conjuge;

    @Column(name = "NascimentoCônjuge")
    private java.time.LocalDateTime nascimentoConjuge;

    @Column(name = "RendaCônjuge")
    private java.math.BigDecimal rendaConjuge;

    @Column(name = "EmpresaCônjuge")
    private String empresaConjuge;

    @Column(name = "ProfissãoCônjuge")
    private String profissaoConjuge;

    @Column(name = "FoneEmpresaCônjuge")
    private String foneEmpresaConjuge;

    @Column(name = "Email")
    private String email;

    @Column(name = "HomePage")
    private String homePage;

    @Column(name = "Contato1")
    private String contato1;

    @Column(name = "Contato2")
    private String contato2;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "TempoResidência")
    private String tempoResidencia;

    @Column(name = "CodSituação")
    private java.math.BigDecimal codSituacao;

    @Column(name = "Foto")
    private String foto;

    @Column(name = "Comissão")
    private java.math.BigDecimal comissao;

    @Column(name = "Consumidor")
    private Boolean consumidor;

    @Column(name = "NumCasaCobrança")
    private String numCasaCobranca;

    @Column(name = "Representante")
    private String representante;

    @Column(name = "EndereçoRepresentante")
    private String enderecoRepresentante;

    @Column(name = "NumRepesentante")
    private String numRepesentante;

    @Column(name = "FoneRepresentante")
    private String foneRepresentante;

    @Column(name = "FaxRepresentante")
    private String faxRepresentante;

    @Column(name = "CidadeRepresentante")
    private String cidadeRepresentante;

    @Column(name = "EstadoRepresentante")
    private String estadoRepresentante;

    @Column(name = "CelularRepresentante")
    private String celularRepresentante;

    @Column(name = "ContatoRepresentante")
    private String contatoRepresentante;

    @Column(name = "EmailRepresentante")
    private String emailRepresentante;

    @Column(name = "ContatoJurídica1")
    private String contatoJuridica1;

    @Column(name = "ContatoJurídica2")
    private String contatoJuridica2;

    @Column(name = "ComplEndereço")
    private String complEndereco;

    @Column(name = "Vendedor")
    private java.math.BigDecimal vendedor;

    @Column(name = "Empresa")
    private java.math.BigDecimal empresa;

    @Column(name = "FaturaLote")
    private Boolean faturaLote;

    @Column(name = "DiaVencimento")
    private Integer diaVencimento;

    @Column(name = "ValorNF")
    private java.math.BigDecimal valorNF;

    @Column(name = "ValorME")
    private java.math.BigDecimal valorME;

    @Column(name = "Modalidade")
    private String modalidade;

    @Column(name = "FormaPagamento")
    private java.math.BigDecimal formaPagamento;

    @Column(name = "BaseCalculo")
    private java.math.BigDecimal baseCalculo;

    @Column(name = "ISS")
    private Double iSS;

    @Column(name = "DISS")
    private Boolean dISS;

    @Column(name = "IRPF")
    private Double iRPF;

    @Column(name = "DIRPF")
    private Boolean dIRPF;

    @Column(name = "INSS")
    private Double iNSS;

    @Column(name = "DINSS")
    private Boolean dINSS;

    @Column(name = "PIS")
    private Double pIS;

    @Column(name = "DPIS")
    private Boolean dPIS;

    @Column(name = "COFINS")
    private Double cOFINS;

    @Column(name = "DCOFINS")
    private Boolean dCOFINS;

    @Column(name = "CSLL")
    private Double cSLL;

    @Column(name = "DCSLL")
    private Boolean dCSLL;

    @Column(name = "Cancelamento")
    private java.time.LocalDateTime cancelamento;

    @Column(name = "TextoNF1")
    private String textoNF1;

    @Column(name = "TextoNF2")
    private String textoNF2;

    @Column(name = "TextoNF3")
    private String textoNF3;

    @Column(name = "TextoNF4")
    private String textoNF4;

    @Column(name = "TextoNF5")
    private String textoNF5;

    @Column(name = "TextoNF6")
    private String textoNF6;

    @Column(name = "TextoNF7")
    private String textoNF7;

    @Column(name = "TextoNF8")
    private String textoNF8;

    @Column(name = "TextoNF9")
    private String textoNF9;

    @Column(name = "TextoNF10")
    private String textoNF10;

    @Column(name = "EmiteNota")
    private Boolean emiteNota;

    @Column(name = "NotaPersonalizada")
    private Boolean notaPersonalizada;

    @Column(name = "PrimeiroFaturamento")
    private java.time.LocalDateTime primeiroFaturamento;

    @Column(name = "ListaChaves")
    private String listaChaves;

    @Column(name = "BaseISS")
    private java.math.BigDecimal baseISS;

    @Column(name = "ReferênciaSIGMA")
    private String referenciaSIGMA;

    @Column(name = "ObservaçãoSIGMA")
    private String observacaoSIGMA;

    @Column(name = "ResponsávelSIGMA")
    private String responsavelSIGMA;

    @Column(name = "DataInstalaçãoAlarme")
    private java.time.LocalDateTime dataInstalacaoAlarme;

    @Column(name = "Central")
    private String central;

    @Column(name = "ÚltimoEvento")
    private java.time.LocalDateTime ultimoEvento;

    @Column(name = "ÚltimoX1")
    private java.time.LocalDateTime ultimoX1;

    @Column(name = "MínimoComissão")
    private java.math.BigDecimal minimoComissao;

    @Column(name = "CentroResultados")
    private java.math.BigDecimal centroResultados;

    @Column(name = "BaseISSAnt")
    private java.math.BigDecimal baseISSAnt;

    @Column(name = "ValorNFAnt")
    private java.math.BigDecimal valorNFAnt;

    @Column(name = "ValorMEAnt")
    private java.math.BigDecimal valorMEAnt;

    @Column(name = "BaseCalculoAnt")
    private java.math.BigDecimal baseCalculoAnt;

    @Column(name = "ÍndiceReajuste")
    private Double indiceReajuste;

    @Column(name = "DataReajuste")
    private java.time.LocalDateTime dataReajuste;

    @Column(name = "BaseIRPF")
    private java.math.BigDecimal baseIRPF;

    @Column(name = "BaseINSS")
    private java.math.BigDecimal baseINSS;

    @Column(name = "BasePIS")
    private java.math.BigDecimal basePIS;

    @Column(name = "BaseCOFINS")
    private java.math.BigDecimal baseCOFINS;

    @Column(name = "BaseCSLL")
    private java.math.BigDecimal baseCSLL;

    @Column(name = "TipoFaturamento")
    private java.math.BigDecimal tipoFaturamento;

    @Column(name = "RatChip")
    private Boolean ratChip;

    @Column(name = "RatRonda")
    private Boolean ratRonda;

    @Column(name = "RatFone")
    private Boolean ratFone;

    @Column(name = "RatExtras")
    private Boolean ratExtras;

    @Column(name = "ValorEntrega")
    private java.math.BigDecimal valorEntrega;

    @Column(name = "TelefoneLimpo")
    private String telefoneLimpo;

    @Column(name = "PropNome")
    private String propNome;

    @Column(name = "PropEnd")
    private String propEnd;

    @Column(name = "PropNum")
    private String propNum;

    @Column(name = "PropBairro")
    private String propBairro;

    @Column(name = "PropCompl")
    private String propCompl;

    @Column(name = "PropCidade")
    private String propCidade;

    @Column(name = "PropUF")
    private String propUF;

    @Column(name = "Região")
    private java.math.BigDecimal regiao;

    @Column(name = "Cobrando")
    private Boolean cobrando;

    @Column(name = "FantasiaSigma")
    private String fantasiaSigma;

    @Column(name = "ValorCHIP")
    private java.math.BigDecimal valorCHIP;

    @Column(name = "RGRepresentante")
    private String rGRepresentante;

    @Column(name = "CPFRepresentante")
    private String cPFRepresentante;

    @Column(name = "Contrato")
    private String contrato;

    @Column(name = "RatRadio")
    private Boolean ratRadio;

    @Column(name = "ValorRadio")
    private java.math.BigDecimal valorRadio;

    @Column(name = "SubstitutoTributário")
    private Boolean substitutoTributario;

    @Column(name = "MotivoCancelamento")
    private String motivoCancelamento;

    @Column(name = "NaoReajusta")
    private Boolean naoReajusta;

    @Column(name = "TaxaBoletos")
    private Boolean taxaBoletos;

    @Column(name = "Técnico")
    private java.math.BigDecimal tecnico;

    @Column(name = "CodCancelamento")
    private java.math.BigDecimal codCancelamento;

    @Column(name = "Unidade")
    private java.math.BigDecimal unidade;

    @Column(name = "ValorRonda")
    private java.math.BigDecimal valorRonda;

    @Column(name = "ValorFone")
    private java.math.BigDecimal valorFone;

    @Column(name = "ValorExtras")
    private java.math.BigDecimal valorExtras;

    @Column(name = "ValorComodato")
    private java.math.BigDecimal valorComodato;

    @Column(name = "SigmaBloqueado")
    private Boolean sigmaBloqueado;

    @Column(name = "SigmaBloqueioData")
    private java.time.LocalDateTime sigmaBloqueioData;

    @Column(name = "SigmaBloqueioUsuário")
    private String sigmaBloqueioUsuario;

    @Column(name = "NívelSegurança")
    private Integer nivelSeguranca;

    @Column(name = "PontosAlarme")
    private Integer pontosAlarme;

    @Column(name = "ComissãoServiços")
    private java.math.BigDecimal comissaoServicos;

    @Column(name = "MínimoComissãoServiços")
    private java.math.BigDecimal minimoComissaoServicos;

    @Column(name = "Área")
    private java.math.BigDecimal area;

    @Column(name = "SubÁrea")
    private java.math.BigDecimal subArea;

    @Column(name = "ReferênciasBancárias")
    private String referenciasBancarias;

    @Column(name = "Gecom")
    private java.math.BigDecimal gecom;

    @Column(name = "CobraProporcional")
    private Boolean cobraProporcional;

    @Column(name = "PlanilhaProporcional")
    private java.math.BigDecimal planilhaProporcional;

    @Column(name = "GeraCréditoICMS")
    private Boolean geraCreditoICMS;

    @Column(name = "CFOPPersonalizado")
    private String cFOPPersonalizado;

    @Column(name = "EndereçoNF")
    private String enderecoNF;

    @Column(name = "NumCasaNF")
    private String numCasaNF;

    @Column(name = "BairroNF")
    private String bairroNF;

    @Column(name = "CEPNF")
    private String cEPNF;

    @Column(name = "CidadeNF")
    private String cidadeNF;

    @Column(name = "EstadoNF")
    private String estadoNF;

    @Column(name = "ObservaçãoOS")
    private String observacaoOS;

    @Column(name = "DataObservação")
    private java.time.LocalDateTime dataObservacao;

    @Column(name = "UsuárioObserva")
    private String usuarioObserva;

    @Column(name = "TipoÍndice")
    private java.math.BigDecimal tipoIndice;

    @Column(name = "UsuárioReajuste")
    private String usuarioReajuste;

    @Column(name = "ComissãoFaturamento")
    private Boolean comissaoFaturamento;

    @Column(name = "CEPRepresentante")
    private String cEPRepresentante;

    @Column(name = "InscriçãoMunicipal")
    private String inscricaoMunicipal;

    @Column(name = "DataLimiteObserva")
    private java.time.LocalDateTime dataLimiteObserva;

    @Column(name = "ClienteMestre")
    private java.math.BigDecimal clienteMestre;

    @Column(name = "NãoGuias")
    private Boolean naoGuias;

    @Column(name = "EmailNotaDigital")
    private String emailNotaDigital;

    @Column(name = "EmailCobrança")
    private String emailCobranca;

    @Column(name = "TpISS")
    private String tpISS;

    @Column(name = "Latitude")
    private Double latitude;

    @Column(name = "Longitude")
    private Double longitude;

    @Column(name = "Serasa")
    private Boolean serasa;

    @Column(name = "SerasaData")
    private java.time.LocalDateTime serasaData;

    @Column(name = "ControlaPreventiva")
    private Boolean controlaPreventiva;

    @Column(name = "TempoPreventiva")
    private java.math.BigDecimal tempoPreventiva;

    @Column(name = "DadosPreventiva")
    private String dadosPreventiva;

    @Column(name = "EnvioBoleto")
    private Integer envioBoleto;

    @Column(name = "UsaDDA")
    private Boolean usaDDA;

    @Column(name = "MêsReajuste")
    private Integer mesReajuste;

    @Column(name = "TelefoneCobrança")
    private String telefoneCobranca;

    @Column(name = "CodTipoServiço")
    private String codTipoServico;

    @Column(name = "SigmaLocalizaPainel")
    private String sigmaLocalizaPainel;

    @Column(name = "GeoManual")
    private Boolean geoManual;

    @Column(name = "QtdeParcelasComissão")
    private java.math.BigDecimal qtdeParcelasComissao;

    @Column(name = "ChipGPRSMonitoramento")
    private java.math.BigDecimal chipGPRSMonitoramento;

    @Column(name = "ContaExportacao")
    private String contaExportacao;

    @Column(name = "CodCarteiraCobrança")
    private java.math.BigDecimal codCarteiraCobranca;

    @Column(name = "SenhaOnline")
    private String senhaOnline;

    @Column(name = "BrasPagNomeCartão")
    private String brasPagNomeCartao;

    @Column(name = "BrasPagNúmeroCartão")
    private String brasPagNumeroCartao;

    @Column(name = "BrasPagCCV")
    private String brasPagCCV;

    @Column(name = "BrasPagExpiracao")
    private String brasPagExpiracao;

    @Column(name = "ManterISS")
    private Boolean manterISS;

    @Column(name = "TextoNFLocação")
    private String textoNFLocacao;

    @Column(name = "UsuárioCadastro")
    private String usuarioCadastro;

    @Column(name = "VendedorOriginal")
    private java.math.BigDecimal vendedorOriginal;

    @Column(name = "EquipeTécnica")
    private java.math.BigDecimal equipeTecnica;

    @Column(name = "ObsNotaFaturamento1")
    private String obsNotaFaturamento1;

    @Column(name = "ObsNotaFaturamento2")
    private String obsNotaFaturamento2;

    @Column(name = "ObsNotaAvulsa1")
    private String obsNotaAvulsa1;

    @Column(name = "ObsNotaAvulsa2")
    private String obsNotaAvulsa2;

    @Column(name = "AceitandoOS")
    private Boolean aceitandoOS;

    @Column(name = "CodigoSigma")
    private java.math.BigDecimal codigoSigma;

    @Column(name = "SigmaFonePainel")
    private String sigmaFonePainel;

    @Column(name = "OrçamentoOrigem")
    private java.math.BigDecimal orcamentoOrigem;

    @Column(name = "FaturaDecimo")
    private Boolean faturaDecimo;

    @Column(name = "Inativo")
    private Boolean inativo;

    @Column(name = "IDUsuárioPagseguro")
    private String iDUsuarioPagseguro;

    @Column(name = "SigmaRota")
    private String sigmaRota;

    @Column(name = "ComplementoNF")
    private String complementoNF;

    @Column(name = "NãoReterPISCOFINSAuto")
    private Boolean naoReterPISCOFINSAuto;

    @Column(name = "PlanoMMN")
    private java.math.BigDecimal planoMMN;

    @Column(name = "SemDescontoBoleto")
    private Boolean semDescontoBoleto;

    @Column(name = "ClienteFaturaOS")
    private java.math.BigDecimal clienteFaturaOS;

    @Column(name = "DataDemissão")
    private java.time.LocalDateTime dataDemissao;

    @Column(name = "NãoEnviaSerasa")
    private Boolean naoEnviaSerasa;

    @Column(name = "NãoMalaDireta")
    private Boolean naoMalaDireta;

    @Column(name = "SigmaMeioComunicação")
    private String sigmaMeioComunicacao;

    @Column(name = "IgnoraTextoServiços")
    private Boolean ignoraTextoServicos;

    @Column(name = "ComplementoEndCobrança")
    private String complementoEndCobranca;

    @Column(name = "EntregaCPFCNPJ")
    private String entregaCPFCNPJ;

    @Column(name = "EntregaEndereço")
    private String entregaEndereco;

    @Column(name = "EntregaNúmero")
    private String entregaNumero;

    @Column(name = "EntregaComplemento")
    private String entregaComplemento;

    @Column(name = "EntregaBairro")
    private String entregaBairro;

    @Column(name = "EntregaCidade")
    private String entregaCidade;

    @Column(name = "EntregaEstado")
    private String entregaEstado;

    @Column(name = "CSAPISCOFINS")
    private String cSAPISCOFINS;

    @Column(name = "AguardandoChave")
    private Boolean aguardandoChave;

    @Column(name = "UsuárioChave")
    private String usuarioChave;

    @Column(name = "DataChave")
    private java.time.LocalDateTime dataChave;

    @Column(name = "FulltrackCode")
    private java.math.BigDecimal fulltrackCode;

    @Column(name = "PlanoComissãoRecorrenteVendedor")
    private java.math.BigDecimal planoComissaoRecorrenteVendedor;

    @Column(name = "PlanoComissãoRecorrenteCliente")
    private java.math.BigDecimal planoComissaoRecorrenteCliente;

    @Column(name = "DataInativação")
    private java.time.LocalDateTime dataInativacao;

    @Column(name = "Gênero")
    private String genero;

    @Column(name = "FaturaDiasAdicionais")
    private java.math.BigDecimal faturaDiasAdicionais;

    @Column(name = "FaturaValorOndemand")
    private java.math.BigDecimal faturaValorOndemand;

    @Column(name = "ConsumidorFinal")
    private Boolean consumidorFinal;

    @Column(name = "InCardToken")
    private String inCardToken;

    @Column(name = "ReajusteLote")
    private Boolean reajusteLote;

    @Column(name = "MunicípioISS")
    private String municipioISS;

    @Column(name = "EstadoISS")
    private String estadoISS;

    @Column(name = "NaoGerarPerfil")
    private Boolean naoGerarPerfil;

    @Column(name = "NaoExibeMySecurity")
    private Boolean naoExibeMySecurity;

    @Column(name = "PercDescontoBoleto")
    private Double percDescontoBoleto;

    @Column(name = "Representante2")
    private String representante2;

    @Column(name = "RGRepresentante2")
    private String rGRepresentante2;

    @Column(name = "CPFRepresentante2")
    private String cPFRepresentante2;

    @Column(name = "EndereçoRepresentante2")
    private String enderecoRepresentante2;

    @Column(name = "NumRepresentante2")
    private String numRepresentante2;

    @Column(name = "BairroRepresentante2")
    private String bairroRepresentante2;

    @Column(name = "CidadeRepresentante2")
    private String cidadeRepresentante2;

    @Column(name = "EstadoRepresentante2")
    private String estadoRepresentante2;

    @Column(name = "CEPRepresentante2")
    private String cEPRepresentante2;

    @Column(name = "EmailRepresentante2")
    private String emailRepresentante2;

    @Column(name = "InvTipoGerente")
    private Boolean invTipoGerente;

    @Column(name = "InvTipoAdministrativo")
    private Boolean invTipoAdministrativo;

    @Column(name = "InvTipoVendedorInterno")
    private Boolean invTipoVendedorInterno;

    @Column(name = "InvTipoVendedorExterno")
    private Boolean invTipoVendedorExterno;

    @Column(name = "InvTipoMonitorInterno")
    private Boolean invTipoMonitorInterno;

    @Column(name = "InvTipoMonitorExterno")
    private Boolean invTipoMonitorExterno;

    @Column(name = "InvTipoTecManutenção")
    private Boolean invTipoTecManutencao;

    @Column(name = "InvTipoTecInstalação")
    private Boolean invTipoTecInstalacao;

    @Column(name = "InvTipoTecTerceiro")
    private Boolean invTipoTecTerceiro;

    @Column(name = "NãoEnviarEmailNFe")
    private Boolean naoEnviarEmailNFe;

    @Column(name = "TécnicoPreventiva")
    private java.math.BigDecimal tecnicoPreventiva;

    @Column(name = "ExibirAviso")
    private java.math.BigDecimal exibirAviso;

    @Column(name = "IDMonitoramento")
    private java.math.BigDecimal iDMonitoramento;

    @Column(name = "CodTabelaPreçosVinculada")
    private java.math.BigDecimal codTabelaPrecosVinculada;

    @Column(name = "BaseOutros")
    private java.math.BigDecimal baseOutros;

    @Column(name = "Outros")
    private Double outros;

    @Column(name = "Carteira")
    private java.math.BigDecimal carteira;

    @Column(name = "GrupoEconomico")
    private java.math.BigDecimal grupoEconomico;

    @Column(name = "NãoBloquearInadimplente")
    private Boolean naoBloquearInadimplente;

    @Column(name = "NãoDanfeAuto")
    private Boolean naoDanfeAuto;

    @Column(name = "GsFamily")
    private Boolean gsFamily;

    @Column(name = "EmpresaContasReceber")
    private java.math.BigDecimal empresaContasReceber;

    @Column(name = "CelularCobrança")
    private String celularCobranca;

    @Column(name = "FormaPagamentoPadrãoOS")
    private java.math.BigDecimal formaPagamentoPadraoOS;

    @Column(name = "GRIntegração")
    private java.math.BigDecimal gRIntegracao;

    @Column(name = "MoniDataCadastro")
    private String moniDataCadastro;

    @Column(name = "GRDescreveServiçoMensal")
    private String gRDescreveServicoMensal;

    @Column(name = "UserIter")
    private java.math.BigDecimal userIter;

    @Column(name = "semReporteNao")
    private Boolean semReporteNao;

    @Column(name = "OSServCobraM")
    private java.math.BigDecimal oSServCobraM;

    @Column(name = "OSServCobraP")
    private java.math.BigDecimal oSServCobraP;

    @Column(name = "CodPréVenda")
    private java.math.BigDecimal codPreVenda;

    @Column(name = "Síndico")
    private String sindico;

    @Column(name = "SíndicoInícioMandato")
    private java.time.LocalDateTime sindicoInicioMandato;

    @Column(name = "SíndicoFimMandato")
    private java.time.LocalDateTime sindicoFimMandato;

    @Column(name = "SigmaDescPart")
    private String sigmaDescPart;

    @Column(name = "MunicípioPrestação")
    private String municipioPrestacao;

    @Column(name = "EstadoPrestação")
    private String estadoPrestacao;

    @Column(name = "EndereçoResidencial")
    private String enderecoResidencial;

    @Column(name = "NúmeroResidencial")
    private String numeroResidencial;

    @Column(name = "BairroResidencial")
    private String bairroResidencial;

    @Column(name = "CidadeResidencial")
    private String cidadeResidencial;

    @Column(name = "EstadoResidencial")
    private String estadoResidencial;

    @Column(name = "ComplementoResidencial")
    private String complementoResidencial;

    @Column(name = "CepResidencial")
    private String cepResidencial;

    @Column(name = "RepresentanteDataNascimento")
    private java.time.LocalDateTime representanteDataNascimento;

    @Column(name = "Representante2DataNascimento")
    private java.time.LocalDateTime representante2DataNascimento;

    @Column(name = "Representante2Fone")
    private String representante2Fone;

    @Column(name = "Representante2Celular")
    private String representante2Celular;

    @Column(name = "ObservacoesTecnicas")
    private String observacoesTecnicas;

    @Column(name = "TipoConta")
    private java.math.BigDecimal tipoConta;

    @Column(name = "SolucxCod")
    private String solucxCod;

    @Column(name = "EmailOS")
    private String emailOS;

    @Column(name = "OSLimiteM")
    private java.math.BigDecimal oSLimiteM;

    @Column(name = "OSLimiteP")
    private java.math.BigDecimal oSLimiteP;

    @Column(name = "ObsCancelamento")
    private String obsCancelamento;

    @Column(name = "DataEnvioDeclaraDebito")
    private java.time.LocalDateTime dataEnvioDeclaraDebito;

    @Column(name = "NFeAutorizados")
    private String nFeAutorizados;

    @Column(name = "PortariaTec")
    private java.math.BigDecimal portariaTec;

    @Column(name = "PortariaEmail")
    private String portariaEmail;

    @Column(name = "CelularOS")
    private String celularOS;

    @Column(name = "IncardTokenInside")
    private String incardTokenInside;

    @Column(name = "ConceitoClasse")
    private String conceitoClasse;

    @Column(name = "ConceitoIndice")
    private java.math.BigDecimal conceitoIndice;

    @Column(name = "ConceitoqtCli")
    private java.math.BigDecimal conceitoqtCli;

    @Column(name = "ConceitoSituacao")
    private String conceitoSituacao;

    @Column(name = "ConceitoDetalhes")
    private String conceitoDetalhes;

    @Column(name = "ConceitoMediaAtrasos")
    private java.math.BigDecimal conceitoMediaAtrasos;

    @Column(name = "EntregaNome")
    private String entregaNome;

    @Column(name = "EntregaFone")
    private String entregaFone;

    @Column(name = "EntregaCEP")
    private String entregaCEP;

    @Column(name = "EntregaEmail")
    private String entregaEmail;

    @Column(name = "RepresentanteProfissao")
    private String representanteProfissao;

    @Column(name = "RepresentanteEstadoCivil")
    private String representanteEstadoCivil;

    @Column(name = "RepresentanteProfissao2")
    private String representanteProfissao2;

    @Column(name = "RepresentanteEstadoCivil2")
    private String representanteEstadoCivil2;

    @Column(name = "AlteroSenhaPadrao")
    private Boolean alteroSenhaPadrao;

    @Column(name = "ScTTD212")
    private Boolean scTTD212;

    @Column(name = "GetrakSubCliente")
    private Boolean getrakSubCliente;

    @Column(name = "GetrakClienteID")
    private String getrakClienteID;

    @Column(name = "GetrakClienteIDGetrak")
    private String getrakClienteIDGetrak;

    @Column(name = "AgruparNotaPorTipo")
    private Boolean agruparNotaPorTipo;

    @Column(name = "SLAPadrão")
    private java.math.BigDecimal sLAPadrao;

    @Column(name = "SeguroCodAtividade")
    private java.math.BigDecimal seguroCodAtividade;

    @Column(name = "PercComissaoGecom")
    private Double percComissaoGecom;

    @Column(name = "GrupoDefeito")
    private java.math.BigDecimal grupoDefeito;

    @Column(name = "EnviaNFLocação")
    private Boolean enviaNFLocacao;

    @Column(name = "AddObservOS")
    private Boolean addObservOS;

    @Column(name = "OSTpISS")
    private String oSTpISS;

    @Column(name = "OSISS")
    private Double oSISS;

    @Column(name = "OSDISS")
    private Boolean oSDISS;

    @Column(name = "IdClienteMovidesk")
    private String idClienteMovidesk;

    @Column(name = "SACExcluiPesquisas")
    private Boolean sACExcluiPesquisas;

    @Column(name = "CreditoOutorgado")
    private Double creditoOutorgado;

    @Column(name = "NumART")
    private String numART;

    @Column(name = "CodObra")
    private String codObra;

    @Column(name = "CodCadastroMatriz")
    private java.math.BigDecimal codCadastroMatriz;

    @Column(name = "OSMunicípioISS")
    private String oSMunicipioISS;

    @Column(name = "OSEstadoISS")
    private String oSEstadoISS;

    @Column(name = "OSMunicípioPrestação")
    private String oSMunicipioPrestacao;

    @Column(name = "OSEstadoPrestação")
    private String oSEstadoPrestacao;

    @Column(name = "SolicitaLiberacaoAberturaOS")
    private Boolean solicitaLiberacaoAberturaOS;

    @Column(name = "NaoEnviarSMSAberturaOS")
    private Boolean naoEnviarSMSAberturaOS;

    @Column(name = "NãoValidaDistancia")
    private Boolean naoValidaDistancia;

    @Column(name = "Natureza")
    private String natureza;

    @Column(name = "SeparaBoletoLoca")
    private Boolean separaBoletoLoca;

    @Column(name = "SíndicoTelefone")
    private String sindicoTelefone;

    @Column(name = "FormaPagamentoLocacao")
    private java.math.BigDecimal formaPagamentoLocacao;

    @Column(name = "ValorComodatoMestre")
    private java.math.BigDecimal valorComodatoMestre;

    @Column(name = "CodADB")
    private java.math.BigDecimal codADB;

    @Column(name = "Convertido")
    private Boolean convertido;

    @Column(name = "CodClienteLegado")
    private String codClienteLegado;

    @Column(name = "CodMigracao")
    private Integer codMigracao;

    @Column(name = "AgenciaBancariaLegado")
    private String agenciaBancariaLegado;

    @Column(name = "ContaBancariaLegado")
    private String contaBancariaLegado;

    @Column(name = "CedenteBancarioLegado")
    private String cedenteBancarioLegado;

    @Column(name = "IndOper")
    private String indOper;

    @Column(name = "idEstrangeiro")
    private String idEstrangeiro;

    public Clientes() {}

}
