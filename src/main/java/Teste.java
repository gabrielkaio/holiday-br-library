
import java.time.LocalDate;

import com.gkaio.util.feriados.Feriado;
import com.gkaio.util.feriados.enums.Local;

public class Teste {

	public static void main(String[] args) {
		
		System.out.println(Feriado.isFeriado(LocalDate.of(2019, 11, 20), Local.SP));
				
	}

}
