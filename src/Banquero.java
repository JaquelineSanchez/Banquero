/* Miranda Trejo Jesús Fernando
 * Sánchez Jurado Andrea Jaqueline
 * Talavera Rivera Luis Fernando
 * 
 * Esta clase emula el comportamiento del sistema operativo conteniendo el algoritmo principal del banquero
 * y haciendo uso de la clase proceso.
 */

public class Banquero {
	
	int  n = 4;							//Numero de procesos que puede contener
	Proceso procesos[]= new Proceso[n];
	int rTotales[];
	int rDisponibles[] = new int[3];
	int cantP = 0;
	Proceso terminados[]= new Proceso[n];
	
	Banquero()
	{
		
	}
	
	public void recursosTotales(int recursos[])
	{
		this.rTotales = recursos;
	}
	
	public void agregar(String id,int necesarios[], int asignados[])
	{
		procesos[cantP] = new Proceso(id,necesarios,asignados);
		cantP++;
	}
	
	public void calcularDisponibles()
	{
		int usados;
		for (int i = 0; i < 3; i++) 
		{
			usados = 0;
			for (int j = 0; j < procesos.length; j++) 
			{
				usados += procesos[j].asignados[i];				
			}
			rDisponibles[i] = rTotales[i]-usados;
		}
	}
	
	public boolean asegurar(int p)
	{				
		if(procesos[p].solicitados[0] <= rDisponibles[0] && procesos[p].solicitados[1] <= rDisponibles[1] && procesos[p].solicitados[2] <= rDisponibles[2])
		{
			return true;
		}
		return false;
	}
	
	private void regresarRecursos(int recursos[])
	{
		for (int i = 0; i < recursos.length; i++) {
			rDisponibles[i] += recursos[i];
		}
	}
	
	public int procesar()
	{
		int p = 0;
		int aux = 0;
		while(p < cantP)
		{
			boolean asignado = false;
			for (int i = 0; i < procesos.length; i++) 
			{
				if(procesos[i].estado == Estado.esperando && asegurar(i))
				{
					procesos[i].estado = Estado.finalizado;
					asignado = true;
					regresarRecursos(procesos[i].asignados);
					p++;
					terminados[aux] = procesos[i];
					aux++;
					i = -1;
				}				
			}
			if(asignado == false)
			{
				break;
			}
		}
		return p;
	}
	
}

