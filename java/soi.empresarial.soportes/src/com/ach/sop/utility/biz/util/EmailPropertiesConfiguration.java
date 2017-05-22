package com.ach.sop.utility.biz.util;

import com.lucasian.common.properties.ConfigFilesProperties;
import com.lucasian.common.properties.EncryptedAndPlainProperties;
import com.lucasian.common.properties.VariableProperties;
import com.lucasian.exception.SystemException;

public class EmailPropertiesConfiguration {

	private static final EncryptedAndPlainProperties p = new EncryptedAndPlainProperties();

	private static final EmailPropertiesConfiguration INSTANCIA = new EmailPropertiesConfiguration();

	public final static String RUTA_ARCHIVO_EMAIL_COMMON = "archivo.config.email";


	private EmailPropertiesConfiguration() {

		final ConfigFilesProperties props = ConfigFilesProperties.getInstance();
		final String ruta = props.getValorPropiedad(RUTA_ARCHIVO_EMAIL_COMMON);
		try {
			p.load(ruta);
			VariableProperties.getInstance().replaceVariablesValues(p);
		} catch (Exception fne) {
			throw new SystemException(
					new StringBuilder("Error al intentar archivo de ")
					.append("configuración: ")
					.append(ruta)
					.append(", com.lucasian.exception.configuration.JEEPropertiesConfiguration.JEEPropertiesConfiguration()")
					.toString(), fne);
		}
	}

	public static EmailPropertiesConfiguration getInstance() {
		return INSTANCIA;
	}

	/**
	 * Permite obtener los valores de las rutas correspondientes a los
	 * archivos de configuracion.
	 * @param llave Nombre de la propiedad para la cual se quiere obtener
	 * su valor
	 * @return String valor de la propiedad
	 */
	public String getValorPropiedad(final String llave) {
		return p.getProperty(llave);
	}


}
