package com.anncode.makereport;

/**
 *
 * <h1>MakeReport</h1>
 * Clase principal del programa MakeReport.
 * MakeReport es una biblioteca que te permite escribir archivos.
 * <p>
 * Esta clase muestra un ejemplo de uso de la biblioteca MakeReport para escribir un archivo.
 *
 * @author Facu
 * @version 1.1
 * @since 2023
 *
 */
public class Main {

	/**
	 * Método principal que demuestra el uso de la biblioteca MakeReport para escribir un archivo.
	 * Crea un objeto Report, configura sus atributos y se escribe el archivo.
	 *
	 * @param args Los argumentos de línea de comandos. No se utilizan en este ejemplo.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Report report = new Report();
		report.setNameFile("reporte");
		report.setExtension("txt");
		report.setTitle(":: REPORTE:: \n");
		String content = report.getTitle();
		for (int i = 0; i < 5; i++) {
			content += "\nReporte : " + i;
		}
		report.setContent(content);
		report.makeReport();

	}

}
