
import java.time.LocalDate;
import java.util.List;

import com.gkaio.util.feriados.Feriado;
import com.gkaio.util.feriados.enums.Local;
import com.gkaio.util.feriados.enums.TabelaFeriado;

public class Teste {

	public static void main(String[] args) {		
		
		// Supondo hoje ser 01/05/2022, hoje é feriado? 
		System.out.println(Feriado.isFeriado(LocalDate.now()));
		
		// Supondo hoje ser 01/05/2022, amanhã é feriado em SP?
		System.out.println(Feriado.isFeriado(LocalDate.now().plusDays(1), Local.SP));
		
		// Foi feriado em 05/03/1999?
		System.out.println(Feriado.isFeriado(LocalDate.of(1999, 3, 5)));
		
		Feriado feriado = Feriado.getFeriado(TabelaFeriado.INDEPENDENCIA_DO_BRASIL, 2022);		
		System.out.println(feriado.toString());
		
				
	}

}
