package com.anncode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	/**
	 * Este método captura el tiempo exacto del inicio de la visualización.
	 * @param dateI Es un objeto {@code Date} con el tiempo de inicio Exacto.,
	 * @return Devuelve la fecha y la hora capturadas.
	 */
	Date startToSee(Date dateI);

	/**
	 * Este método captura el tiempo exacto de inicio y final de visualización
	 * @param dateI
	 * @param dateF
	 */
	void stopToSee(Date dateI, Date dateF);

}
