# holiday-br-library

This is a straightforward library for easily manipulate brazilian holidays.

## Getting a list of national holidays

The method `getFeriadosNacionais` will return a ordered list with all national holidays    

```java
List<Feriado> feriados = Feriado.getFeriadosNacionais(2022);		
		for (Feriado feriado : feriados) {
			System.out.println(feriado.toString());
		}
```

Output:

    Feriado Ano Novo do tipo FIXO e com abrangencia Nacional ocorre na data 2022-01-01
    Feriado Carnaval do tipo MOVEL e com abrangencia Nacional ocorre na data 2022-03-01
    Feriado Sexta-feira Santa do tipo MOVEL e com abrangencia Nacional ocorre na data 2022-04-15
    Feriado Páscoa do tipo MOVEL e com abrangencia Nacional ocorre na data 2022-04-17
    Feriado Tiradentes do tipo FIXO e com abrangencia Nacional ocorre na data 2022-04-21
    Feriado Dia do Trabalho do tipo FIXO e com abrangencia Nacional ocorre na data 2022-05-01
    Feriado Corpus Christi do tipo MOVEL e com abrangencia Municipal ocorre na data 2022-06-16
    Feriado Independência do Brasil do tipo FIXO e com abrangencia Nacional ocorre na data 2022-09-07
    Feriado Nossa Senhora Aparecida do tipo FIXO e com abrangencia Nacional ocorre na data 2022-10-12
    Feriado Finados do tipo FIXO e com abrangencia Nacional ocorre na data 2022-11-02
    Feriado Proclamação da República do tipo FIXO e com abrangencia Nacional ocorre na data 2022-11-15
    Feriado Natal do tipo FIXO e com abrangencia Nacional ocorre na data 2022-12-25
    
## Check if a specific date is a holiday date

```java
// Supondo hoje ser 01/05/2022, hoje é feriado? 
System.out.println(Feriado.isFeriado(LocalDate.now()));

// Supondo hoje ser 01/05/2022, amanhã é feriado em SP?
System.out.println(Feriado.isFeriado(LocalDate.now().plusDays(1), Local.SP));

// Foi feriado em 05/03/1999?
System.out.println(Feriado.isFeriado(LocalDate.of(1999, 3, 5)));

```

Output:
	
	True
	False
	False

## Getting a particular holiday

```java
	Feriado feriado = Feriado.getFeriado(TabelaFeriado.INDEPENDENCIA_DO_BRASIL, 2022);		
	System.out.println(feriado.toString());
```

Output:
		
	Feriado Independência do Brasil do tipo FIXO e com abrangencia Nacional ocorre na data 2022-09-07
	
	
## Getting local holidays

## Easter and not fixed dates holidays  
 