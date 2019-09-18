package com.gkaio.util.datas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DataUtils {

    static final Locale BRASIL = new Locale("pt", "BR");

    public static LocalTime timeNow() {
        return LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public static LocalDate ontem(){
        return LocalDate.now().minusDays(1);
    }
    public static LocalDate hoje(){
        return LocalDate.now();
    }
    public static LocalDate amanha(){
        return LocalDate.now().plusDays(1);
    }

    public static boolean isOntem(LocalDate d){
        return d.isEqual(ontem());
    }
    public static boolean isHoje(LocalDate d){
        return d.isEqual(hoje());
    }
    public static boolean isAmanha(LocalDate d){
        return d.isEqual(amanha());
    }

    public static Month doMesPassado(){ return LocalDate.now().minusMonths(1).getMonth(); }
    public static Month doMesAtual(){ return LocalDate.now().getMonth(); }
    public static Month doMesQueVem(){ return LocalDate.now().plusMonths(1).getMonth(); }

    public static int doAnoPassado(){
        return LocalDate.now().minusYears(1).getYear();
    }
    public static int doAnoAtual(){
        return LocalDate.now().getYear();
    }
    public static int doAnoQueVem(){
        return LocalDate.now().plusYears(1).getYear();
    }

    public static LocalDate getPrimeiroDiaUtilDoMes(int year, Month month){
        return LocalDate.of(year, month, 1);
    }

    public static LocalDate getUltimoDiaUtilDoMes(int year, Month month){
        return LocalDate.of(year, month, month.length(Year.of(year).isLeap()));
    }

    //public static int getNumeroDiasMes(int ano, Month mes){}
    //public static int getPrimeiroDiaUtildoMes(int ano, Month mes){}
    //public static int getUltimoDiaUtildoMes(int ano, Month mes){}
    //public static LocalDate getDiaUtil(DiaUtil.QUINTO)
    //public static LocalDate adicionarDiaUtil(LocalDate, int)
    //public static LocalDate ultimoDiaUtil(LocalDate)
    //public static LocalDate proximoDiaUtil(LocalDate)
    //public static LocalDate isDiaUtil(LocalDate)
    //public static LocalDate distanciaEntreEmDiasUteis(LocalDate de, LocalDate para)


    public static int age(LocalDate birthDate){
        return Period.between(birthDate, DataUtils.hoje()).getYears();
    }

}
