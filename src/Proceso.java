/* Miranda Trejo Jesús Fernando
 * Sánchez Jurado Andrea Jaqueline
 * Talavera Rivera Luis Fernando 
 * Esta clase guarda el id del proceso, sus recursos maximos, asignados y faltantes para poder ejecutarse.
 */

public class Proceso {		

	int necesarios[]; //Recursos necesarios para ejecucion
	int asignados[];	//Recursos asignados por el SO
	int solicitados[] = new int[3];	//Recursos faltantes(necesarios-asignados)
	String iD;
	Estado estado;
	
	Proceso(String id,int necesarios[], int asignados[])
	{
		this.iD = id;	
		this.asignados = asignados;
		this.necesarios = necesarios;
		this.estado = Estado.esperando;
		crearSolicitud();
		
	}
	
	private void crearSolicitud()
	{
		int n = necesarios.length;		
		for(int i = 0;i < n;i++)
		{
			solicitados[i] = necesarios[i]-asignados[i];
		}
	}
}
