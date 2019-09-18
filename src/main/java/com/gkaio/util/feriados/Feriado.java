package com.gkaio.util.feriados;

import com.gkaio.util.feriados.enums.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implementação de feriados nacionais e municipais brasileiros. Pendente
 * tratamento de exceptions e completar lista com feriados municipais
 * 
 * @author Gabriel Kaio
 * @version 1.0
 * @since 1.0
 */
public class Feriado {

	private TabelaFeriado tabelaFeriado;
	private LocalDate data;

	private Feriado(TabelaFeriado tabelaFeriado, LocalDate data) {
		this.tabelaFeriado = tabelaFeriado;
		this.data = data;
	}

	/**
	 * Retorna uma lista ordenada por data contendo todos os feriados nacionais
	 * (fixos e móveis) de um determinado ano
	 * 
	 * @param ano ano o qual deseja obter a lista de feriados
	 * @return lista com feriados
	 */
	public static List<Feriado> getFeriadosNacionais(int ano) {
		List<Feriado> feriadosNacionais = new ArrayList<Feriado>();

		for (TabelaFeriado t : TabelaFeriado.values()) {
			if (t.getAbrangencia().equals(Abrangencia.NACIONAL) && t.getTipo().equals(Tipo.FIXO))
				feriadosNacionais
						.add(new Feriado(t, LocalDate.of(ano, t.diaMes().getMonth(), t.diaMes().getDayOfMonth())));
		}

		feriadosNacionais.addAll(getFeriadosMoveis(ano));
		feriadosNacionais.sort(Comparator.comparing(Feriado::getData));

		return feriadosNacionais;
	}

	/**
	 * Retorna uma lista ordenada por data contendo todos os feriados MÓVEIS
	 * nacionais de um determinado ano
	 * 
	 * @param ano ano o qual deseja obter a lista de feriados móveis
	 * @return lista com feriados móveis
	 */
	private static List<Feriado> getFeriadosMoveis(int ano) {

		List<Feriado> feriadosMoveis = new ArrayList<Feriado>();

		LocalDate pascoa = Pascoa.getData(ano);

		feriadosMoveis.add(new Feriado(TabelaFeriado.PASCOA, pascoa));
		feriadosMoveis.add(new Feriado(TabelaFeriado.CARNAVAL, pascoa.minusDays(47)));
		feriadosMoveis.add(new Feriado(TabelaFeriado.CORPUS_CHRISTI, pascoa.plusDays(60)));
		feriadosMoveis.add(new Feriado(TabelaFeriado.SEXTA_FEIRA_SANTA, pascoa.minusDays(2)));

		return feriadosMoveis;
	}

	/**
	 * Retorna uma lista ordenada por data contendo todos os feriados municipais de
	 * um determinado local. Exemplo de uso: getFeriadosMunicipais(2022, Local.SP)
	 * Pendente implementar feriados municipais móveis e completar lista
	 * 
	 * @param ano   ano o qual deseja obter a lista de feriados municipais
	 * @param local local o qual deseja obter a lista de feriados municipais
	 * @return lista com feriados municipais
	 */
	public static List<Feriado> getFeriadosMunicipais(int ano, Local local) {
		List<Feriado> feriados = new ArrayList<Feriado>();

		for (TabelaFeriado t : TabelaFeriado.values()) {
			if (t.getAbrangencia().equals(Abrangencia.MUNICIPAL) && t.getLocal().equals(local))
				if (t.getTipo().equals(Tipo.FIXO))
					feriados.add(new Feriado(t, LocalDate.of(ano, t.diaMes().getMonth(), t.diaMes().getDayOfMonth())));
		}

		return feriados;
	}

	/**
	 * Retorna uma lista ordenada por data contendo todos os feriados nacionais
	 * (fixos e móveis) e municipais de um determinado local e de um determinado ano
	 * 
	 * @param ano   ano o qual deseja obter a lista de feriados
	 * @param local local o qual deseja obter a lista de feriados
	 * @return lista com feriados nacionais (fixos e móveis) e municipais
	 */
	public static List<Feriado> getFeriadosNacionaisMunicipais(int ano, Local local) {
		List<Feriado> feriados = getFeriadosNacionais(ano);
		feriados.addAll(getFeriadosMunicipais(ano, local));

		return feriados;
	}

	/**
	 * Retorna um feriado específico de acordo com o tipo informado. Exemplo
	 * getFeriado(TabelaFeriado.CORPUS_CHRISTI, 2022)
	 * 
	 * @param tabelaFeriado feriado que deseja obter
	 * @param ano           ano o qual deseja obter o feriado
	 * @return Feriado
	 */
	public static Feriado getFeriado(TabelaFeriado tabelaFeriado, int ano) {

		if (tabelaFeriado.getTipo().equals(Tipo.FIXO))
			return new Feriado(tabelaFeriado,
					LocalDate.of(ano, tabelaFeriado.diaMes().getMonth(), tabelaFeriado.diaMes().getDayOfMonth()));
		else
			return getFeriadosMoveis(ano).stream().filter(f -> f.getTabelaFeriado().equals(tabelaFeriado)).findFirst()
					.get();
	}

	/**
	 * Verifica se é feriado em uma data informada
	 * 
	 * @param data data a qual se deseja verificar se é ou não feriado
	 * @return VERDADEIRO se é feriado na data informada e FALSO caso contrário
	 */
	public static boolean isFeriado(LocalDate data) {
		if (getFeriadosNacionais(data.getYear()).stream().filter(f -> f.getData().equals(data)).findAny().isPresent())
			return true;
		return false;
	}

	/**
	 * Verifica se é feriado em uma determinada data e local informado. Se a data
	 * corresponder à um feriado nacional OU municipal, o método retorna VERDADEIRO.
	 * Caso contrário, FALSO
	 * 
	 * @param data  data a qual se deseja verificar se é ou não feriado
	 * @param local local o qual se deseja verificar se é ou não feriado
	 * @return Se a data corresponder à um feriado nacional OU municipal, o método
	 *         retorna VERDADEIRO. Caso contrário, FALSO
	 */
	public static boolean isFeriado(LocalDate data, Local local) {
		if (getFeriadosNacionaisMunicipais(data.getYear(), local).stream().filter(f -> f.getData().equals(data))
				.findAny().isPresent())
			return true;
		return false;
	}

	// Getters and Setters, hashCode, equals

	/**
	 * Obtém a tabela de feriado que é atributo da classe Feriado
	 * 
	 * @return tabela do feriado
	 */
	public TabelaFeriado getTabelaFeriado() {
		return tabelaFeriado;
	}

	/**
	 * Obtém a data do feriado
	 * 
	 * @return data do feriado
	 */
	public LocalDate getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Feriado " + tabelaFeriado.getNome() + " do tipo " + tabelaFeriado.getTipo() + " e com abrangencia " + tabelaFeriado.getAbrangencia() + " ocorre na data " + data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((tabelaFeriado == null) ? 0 : tabelaFeriado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feriado other = (Feriado) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (tabelaFeriado != other.tabelaFeriado)
			return false;
		return true;
	}

}
