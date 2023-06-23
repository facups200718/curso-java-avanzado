package com.anncode.makereport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * <h1>Report</h1>
 * Report es una clase que representa los archivos a escribir.
 * <p>
 * Report contiene el método {@code makeReport()} que se encargará de escribir un archivo.
 * <br/>
 * Las propiedades de un objeto producto de una instancia de la clase Report son: {@code nameFile}, {@code title},
 * {@code content}, y {@code extension}. Cada propiedad tiene sus respectivos métodos getter y setter.
 *
 * @author Facu
 * @version 1.1
 * @since 2023
 *
 */
public class Report {
	
	private String nameFile;
	private String title;
	private String content;
	private String extension;

	/**
	 * Devolver el nombre del archivo.
	 * @return El nombre del archivo.
	 */
	public String getNameFile() {
		return nameFile;
	}

	/**
	 * Setear el nombre del archivo.
	 * @param nameFile
	 */
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	/**
	 * Devolver el título del archivo
	 * @return El título del archivo.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setear el título del archivo.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Devolver el contenido del archivo
	 * @return El contenido del archivo.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setear el contenido del archivo.
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Crear un archivo a partir de los siguientes atributos:
	 * <ul>
	 *     <li>{@code nameFile}</li>
	 *     <li>{@code title}</li>
	 *     <li>{@code content}</li>
	 *     <li>{@code extension}</li>
	 * </ul>
	 *
	 * @return El método no devuelve un valor ya que su output es el archivo ya escrito.
	 * @throws IOException Si hay un problema en la escritura del archivo.
	 */
	public void makeReport() {
		if ( (getNameFile() != null) && (getTitle() != null) && (getContent() != null) ) {
			//Crear el archivo
			try {
				
				File file = new File(getNameFile()+"."+getExtension());
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(getContent());
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		} else {
			System.out.println("Ingresa los datos del archivo");
		}
	}


	/**
	 * Devolver la extensión del archivo
	 * @return La extensión del archivo.
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Setear la extensión del archivo.
	 * @param extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

}










