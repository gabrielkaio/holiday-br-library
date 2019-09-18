package com.gkaio.util.feriados.enums;

import java.time.Month;
import java.time.MonthDay;

public enum TabelaFeriado {
    ANO_NOVO("Ano Novo", MonthDay.of(Month.JANUARY, 1), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),    
    TIRADENTES("Tiradentes", MonthDay.of(Month.APRIL, 21), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),    
    DIA_DO_TRABALHO("Dia do Trabalho", MonthDay.of(Month.MAY, 1), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),
    CORPUS_CHRISTI("Corpus Christi", null, Abrangencia.MUNICIPAL, Local.BRASIL, Tipo.MOVEL),
    INDEPENDENCIA_DO_BRASIL("Independêcia do Brasil", MonthDay.of(Month.SEPTEMBER, 7), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),
    NOSSA_SENHORA_APARECIDA("Nossa Senhora Aparecida", MonthDay.of(Month.OCTOBER, 12), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),
    FINADOS("Finados", MonthDay.of(Month.NOVEMBER, 2), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),
    PROCLAMACAO_DA_REPUBLICA("Proclamação da República", MonthDay.of(Month.NOVEMBER, 15), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),
    NATAL("Natal", MonthDay.of(Month.DECEMBER, 25), Abrangencia.NACIONAL, Local.BRASIL, Tipo.FIXO),
    
    CARNAVAL("Carnaval", null, Abrangencia.NACIONAL, Local.BRASIL, Tipo.MOVEL),
    PASCOA("Páscoa", null, Abrangencia.NACIONAL, Local.BRASIL, Tipo.MOVEL),
    SEXTA_FEIRA_SANTA("Sexta-feira Santa", null, Abrangencia.NACIONAL, Local.BRASIL, Tipo.MOVEL),

    ANIVERSARIO_DE_SP("Aniversário de São Paulo", MonthDay.of(Month.NOVEMBER, 20), Abrangencia.MUNICIPAL, Local.SP, Tipo.FIXO),
    DIA_DA_CONSCIENCIA_NEGRA("Dia da Consciência Negra", MonthDay.of(Month.NOVEMBER, 20), Abrangencia.MUNICIPAL, Local.SP, Tipo.FIXO);
    
    
    private String nome;
    private MonthDay diaMes;
    private Abrangencia abrangencia;
    private Local local;
    private Tipo tipo;

    TabelaFeriado(String nome, MonthDay diaMes, Abrangencia abrangencia, Local local, Tipo tipo) {
        this.nome = nome;
        this.diaMes = diaMes;
        this.abrangencia = abrangencia;
        this.local = local;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public MonthDay diaMes() {
        return diaMes;
    }

    public Abrangencia getAbrangencia() {
        return abrangencia;
    }

    public Local getLocal() {
        return local;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    


}
