package co.swatit.pilautil.generics;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import co.swatit.pilautil.constants.NumberConstants;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase que encapsula las utilidades generales de validación.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class Validation {

	/**
	 * Referencia el Log del sistema
	 */
	private static final Logger LOGGER = Logger.getLogger(Validation.class.getName());

	/**
	 * Constructor privado
	 */
	private Validation() {
	}

	/**
	 * Método que valida si un objeto no es nulo.
	 * 
	 * @param object
	 *            , con el objeto a validar.
	 * @return boolean con el resultado de la operación.
	 */
	public static boolean isNotNull(final Object obj) {
		return obj != null;
	}

	/**
	 * Método que valida si un objeto es nulo.
	 * 
	 * @param object
	 *            , con el objeto a validar.
	 * @return boolean con el resultado de la operación.
	 */
	public static boolean isNull(final Object obj) {
		return obj == null;
	}

	/**
	 * Método que valida si un objeto es nulo o vacio.
	 * 
	 * @param obj
	 *            , el objeto a validar.
	 * @return true si es nulo o vacio, false si no es nulo y si contiene algun valor.
	 */
	public static boolean isNullOrEmpty(final Object obj) {
		boolean result = Boolean.FALSE;
		if (obj == null) {
			result = Boolean.TRUE;
		} else if (obj instanceof String) {
			String objString = (String) obj;
			if (objString.trim().equals(Constants.EMPTY)) {
				result = Boolean.TRUE;
			}
		} else if (obj instanceof String[]) {
			String[] objString = (String[]) obj;
			if (objString.length == 0) {
				result = Boolean.TRUE;
			}
		} else if (obj instanceof List<?>) {
			List<?> list = (List<?>) obj;
			if (list.isEmpty()) {
				result = Boolean.TRUE;
			}
		}
		return result;
	}

	/**
	 * Método encargado de validar nulidad o longitud de un campo dado.
	 * 
	 * @author Swat-It <br>
	 *         Diego Mauricio Badillo Bedoya <br>
	 *         Email: dbadillo@swat-it.co<br
	 * @date 1/12/2016
	 * @version 1.0
	 * @sprint 2
	 * @issue HU-Carga y validación de registros en el archivo
	 *
	 * @param fieldName
	 *            nombre del campo.
	 * @param value
	 *            valor a validar.
	 * @param validateNull
	 *            indica si se valida nulidad (true) o no (false).
	 * @param length
	 *            indica si se valida longitud (un valor mayor de cero, solo para String)
	 * @return cadena de error presentado o vacío.
	 */
	public static String validateNullAndLengthOfField(String fieldName, Object value, Boolean validateNull,
			Integer length) {
		StringBuilder error = new StringBuilder(Constants.EMPTY);
		Boolean isNullField = Validation.isNullOrEmpty(value) || (value instanceof String && Constants.NULL_LITERAL
				.equals(value));
		Boolean applyString = !isNullField && length > NumberConstants.ZERO && value instanceof String;

		if (isNullField && validateNull) {
			error.append(fieldName);
			error.append(Constants.REQUIRED);
			error.append(Constants.COMMA);
		} else if (applyString) {
			String str = value.toString();
			if (str.length() > length) {
				error.append(fieldName);
				error.append(String.format(Constants.LENGTH_FORBIDDEN, length));
				error.append(Constants.COMMA);
			}
		}

		return error.toString();
	}

	/**
	 * Método que valida si un String no es vacio.
	 * 
	 * @param value
	 *            , con la cadena a validar.
	 * @return boolean con el resultado de la operación.
	 */
	public static boolean isNotEmpty(final String value) {
		return isNotNull(value) && !value.isEmpty() && !"null".equalsIgnoreCase(value);
	}

	/**
	 * Método que valida si una cadena es nula o vacia.
	 * 
	 * @param param
	 *            , cadena a validar.
	 * @param fieldName
	 *            , nombre del campo a validar.
	 * @throws BusinessException
	 *             Si el parametro es nulo o vacio.
	 */
	public static void validateParam(final String fieldName, final Object param) throws BusinessException {
		if (isNullOrEmpty(param)) {
			throw new BusinessException(CodeErrorEnum.ERRORREQUIREDFIELD, fieldName);
		}
	}

	/**
	 * Método que valida si una cadena corresponde a un número entero positivo.
	 * 
	 * @param param
	 *            , cadena a validar.
	 * @param fieldName
	 *            , nombre del campo a validar.
	 * @throws BusinessException
	 *             Si el parametro no es un valor entero positivo.
	 */
	public static void valideParamInteger(final String fieldName, final String param) throws BusinessException {
		validateParam(fieldName, param);

		if (!isInteger(param)) {
			throw new BusinessException(CodeErrorEnum.ERRORINTEGERFIELD, fieldName);
		}
	}

	/**
	 * Método responsable de determinar si una cadena que recibe por parámetro es o no un número entero positivo.
	 * 
	 * @param stringValue
	 *            , cadena a validar.
	 * @return boolean, resultado de la validación, TRUE en caso de que la cadena que se recibe como parámetro
	 *         corresponda a un número entero positivo, FALSE en caso contrario.
	 */
	public static boolean isInteger(final String str) {
		return str == null ? Boolean.FALSE : str.matches("[0-9]+$");
	}

	/**
	 * Realiza la validación de que el valor de un campo coincida con un rango de valores esperado.
	 * 
	 * @param fieldName
	 *            nombre del campo a validar.
	 * @param param
	 *            valor del campo.
	 * @param ignoreCase
	 *            true indica que la validación del rango de valores debe ignorar minúsculas y mayúsculas. false, indica
	 *            que las minúsculas y mayúsculas deben ser exactamente iguales.
	 * @param validValues
	 *            rango de valores válidos.
	 * @throws BusinessException
	 *             error en la validación del campo.
	 */
	public static void validateStringValue(final String fieldName, final String param, final boolean ignoreCase,
			final String... validValues) throws BusinessException {

		// Se busca que la cadena tenga el valor esperado.
		if (validValues != null && validValues.length > 0) {
			boolean valorEsperado = false;
			for (String value : validValues) {
				if ((!ignoreCase && value.equals(param)) || (ignoreCase && value.equalsIgnoreCase(param))) {
					valorEsperado = true;
					break;
				}
			}
			// Si no es el valor esperado se retorna un error.
			if (!valorEsperado) {
				getValuesString(fieldName, validValues);
			}
		}
	}

	/**
	 * Método encargado de obtener los valores válidos de un array de String.
	 * 
	 * @param fieldName
	 *            , nombre del campo.
	 * @param validValues
	 *            , array de String con los valores válidos del campo.
	 * @throws BusinessException
	 *             , se lanza excepción con el mensaje que describe que el campo debe ser uno de los valores válidos.
	 */
	private static void getValuesString(final String fieldName, final String... validValues) throws BusinessException {
		StringBuilder descValues = new StringBuilder();

		for (int i = 0; i < validValues.length; i++) {
			descValues.append(validValues[i]);
			if (i != validValues.length - 1) {
				descValues.append(Constants.COMMA);
			}
		}
		throw new BusinessException(CodeErrorEnum.ERRORSTRINGFIELDVALUE, fieldName, descValues.toString());
	}

	/**
	 * Realiza la validación de que el valor de un campo coincida con un rango de valores esperado.
	 * 
	 * @param fieldName
	 *            nombre del campo a validar.
	 * @param param
	 *            valor del campo.
	 * @param ignoreCase
	 *            true indica que la validación del rango de valores debe ignorar minúsculas y mayúsculas. false, indica
	 *            que las minúsculas y mayúsculas deben ser exactamente iguales.
	 * @param validValues
	 *            rango de valores válidos.
	 * @throws BusinessException
	 *             error en la validación del campo.
	 */
	public static void validateStringValueRequired(final String fieldName, final String param,
			final boolean ignoreCase, final String... validValues) throws BusinessException {
		// Validación básica de requerido.
		validateParam(fieldName, param);

		// Se busca que la cadena tenga el valor esperado.
		if (validValues != null && validValues.length > 0) {
			boolean valorEsperado = false;
			for (String value : validValues) {
				if ((!ignoreCase && value.equals(param)) || (ignoreCase && value.equalsIgnoreCase(param))) {
					valorEsperado = true;
					break;
				}
			}
			// Si no es el valor esperado se retorna un error.
			if (!valorEsperado) {
				getValuesString(fieldName, validValues);
			}
		}
	}

	/**
	 * Método que valida si una cadena corresponde a un numero entero positivo, pero ignora la validación si el campo es
	 * vacío.
	 * 
	 * @param param
	 *            , cadena a validar.
	 * @param fieldName
	 *            , nombre del campo a validar.
	 * @throws BusinessException
	 *             , Si el parametro no es un valor entero positivo.
	 */
	public static void validateIntegerIgnoreEmpty(final String fieldName, final String param) throws BusinessException {
		if (isNotEmpty(param) && !isInteger(param)) {
			throw new BusinessException(CodeErrorEnum.ERRORINTEGERFIELD, fieldName);
		}
	}

	/**
	 * Método que valida si una cadena corresponde a una fecha de acuerdo al formato recibido.
	 * 
	 * @param param
	 *            , cadena a validar.
	 * @param fieldName
	 *            , nombre del campo a validar.
	 * @param format
	 *            , formato con el cual se valida la fecha.
	 * @throws BusinessException
	 *             , Si el el formato de fecha no es valido, Si parametro no tiene el formato correspondiente
	 */
	public static void validateDateFormat(final String fieldName, final String param, final String format)
			throws BusinessException {
		try {
			parseDate(param, format);
		} catch (ParseException e) {
			throw new BusinessException(CodeErrorEnum.ERRORINCORRECTDATE, fieldName, format);
		}
	}

	/**
	 * Método que valida si una cadena corresponde a una fecha de acuerdo al formato recibido.
	 * 
	 * @param param
	 *            , cadena a validar.
	 * @param format
	 *            , formato con el cual se valida la fecha.
	 * @return true si el formato es válido, false de l contrario.
	 */
	public static Boolean isValidDateFormat(final String param, final String format) {
		try {
			parseDate(param, format);
		} catch (IllegalArgumentException e) {
			return false;
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	/**
	 * Método encargado de transformar una cadena a fecha de acuerdo al formato dado.
	 * 
	 * @author Swat-It <br>
	 *         Diego Mauricio Badillo Bedoya <br>
	 *         Email: dbadillo@swat-it.co<br
	 * @date 1/12/2016
	 * @version 1.0
	 * @sprint 2
	 * @issue HU-Carga y validación de registros en el archivo
	 *
	 * @param param
	 *            cadena con la fecha.
	 * @param format
	 *            formato a aplicar.
	 * @throws IllegalArgumentException
	 *             error en la validación del formato.
	 * @throws ParseException
	 *             error en la validación del formato.
	 */
	private static void parseDate(final String param, final String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);

		if (isNotEmpty(param)) {
			sdf.parse(param);
		}
	}

	/**
	 * Método encargado de validar si una fecha cumple con el formato ingresado por parametro y ademas de verificar de
	 * que no sea vacia o nula.
	 * 
	 * @param fieldName
	 *            , nombre del campo.
	 * @param param
	 *            , parámetro asociado al campo.
	 * @param format
	 *            , formato con el cual se verifica si el parametro cumple.
	 */
	public static void validateDateFormatRequired(String fieldName, String param, String format)
			throws BusinessException {
		if (isNotEmpty(param)) {
			validateDateFormat(fieldName, param, format);
		} else {
			throw new BusinessException(CodeErrorEnum.ERRORREQUIREDFIELD, fieldName);
		}
	}

	/**
	 * Método que valida si una lista tiene un tamaño determinado o no.
	 * 
	 * @param list
	 *            , objeto a validar.
	 * @param size
	 *            , tamaño a validar.
	 * @param errorEnum
	 *            , enum para mensaje de error.
	 * @param throwError
	 *            , determina si se lanza error o no.
	 * 
	 * @return boolean, true si la lista tiene el tamaño indicado y false si no.
	 * 
	 * @throws BusinessException
	 *             , Si el tamaño no corresponde al especificado.
	 */
	public static boolean validateListSize(final List<?> list, final int size, final CodeErrorEnum errorEnum,
			final boolean throwError) throws BusinessException {
		if (!isNullOrEmpty(list) && list.size() != size) {
			if (throwError) {
				throw new BusinessException(errorEnum);
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Método que se encarga de validar atributos requeridos dentro de un objeto de transporte de datos (DTO).
	 * 
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 12/09/2016
	 * @version 1.0
	 * @sprint 1
	 * @issue Motor Consignaciones
	 * 
	 * @param object
	 *            , Contiene el instancia del DTO que se pretende validar.
	 * @param requiredFields
	 *            , Contiene el nombre de los atributos del DTO que se deben validar.
	 * @throws BusinessException
	 *             , excepción generada cuando no se cumple la validación.
	 */
	@SuppressWarnings("rawtypes")
	public static void validateRequiredFields(final Object object, final String[] requiredFields)
			throws BusinessException {
		Class targetClass = object.getClass();
		StringBuilder message = new StringBuilder(Constants.EMPTY);
		for (String nombre : requiredFields) {
			if (isNullOrEmpty(object, targetClass, nombre)) {
				message.append(nombre).append(Constants.COMMA);
			}
		}

		if (!isNullOrEmpty(message.toString())) {
			message = new StringBuilder(message.substring(NumberConstants.ZERO, message.length() - NumberConstants.ONE));

			throw new BusinessException(CodeErrorEnum.ERRORREQUIREDALLFIELDS.getCode(),
					CodeErrorEnum.ERRORREQUIREDALLFIELDS.getDescription(), message.toString());
		}
	}

	/**
	 * Verifica que la propiedad del objeto no sea nula.
	 * 
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 12/09/2016
	 * @version 1.0
	 * @sprint 1
	 * @issue Motor Consignaciones
	 * 
	 * @param target
	 *            , Contiene la instancia del objeto.
	 * @param type
	 *            , Contiene la clase que representa el objeto.
	 * @param name
	 *            , Contiene el nombre del atributo que se pretende validar.
	 * @return booelan, true si el atributo es nulo o vacío, false si tiene valor.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean isNullOrEmpty(final Object target, final Class type, final String name) {
		boolean result = Boolean.FALSE;
		try {
			Method method = type.getMethod(getNameMethodGet(name), new Class[0]);
			Object value = method.invoke(target);
			if (value == null) {
				result = Boolean.TRUE;
			} else if (value instanceof String) {
				String objString = (String) value;
				if (objString.trim().equals(Constants.EMPTY)) {
					result = Boolean.TRUE;
				}
			} else if (value instanceof String[]) {
				String[] objString = (String[]) value;
				if (objString.length == 0) {
					result = Boolean.TRUE;
				}
			} else if (value instanceof List<?>) {
				List<?> list = (List<?>) value;
				if (list.isEmpty()) {
					result = Boolean.TRUE;
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			result = true;
		}
		return result;
	}

	/**
	 * Obtiene el nombre del método get de la propiedad.
	 * 
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 12/09/2016
	 * @version 1.0
	 * @sprint 1
	 * @issue Motor Consignaciones
	 * 
	 * @param property
	 *            , Contiene el nombre de la propiedad.
	 * @return String Devuelve el nombre del método get de la propiedad.
	 */
	private static String getNameMethodGet(final String property) {
		return new StringBuilder(Constants.GET_PREFIX).append(Character.toUpperCase(property.charAt(0)))
				.append(property.substring(1)).toString();
	}

	/**
	 * Método que valida si un número se encuentra en determinado intervalo.
	 * 
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 20/09/2016
	 * @version 1.0
	 * @sprint 1
	 * @issue Notificación pago factura
	 * 
	 * @param fieldName
	 *            , nombre del campo a validar.
	 * @param number
	 *            , número validar.
	 * @param min
	 *            , valor mínimo.
	 * @param max
	 *            , valor máximo.
	 * @throws BusinessException
	 *             , Si el parámetro no se encuentra dentro del rango especificado.
	 */
	public static void validateRange(final String fieldName, final String number, final int min, final int max)
			throws BusinessException {
		if (!isNullOrEmpty(number) && (min > Integer.parseInt(number)) || (Integer.parseInt(number) > max)) {
			throw new BusinessException(CodeErrorEnum.ERROROUTOFRANGE, fieldName, Integer.toString(min),
					Integer.toString(max));
		}
	}

	/**
	 * Valida si un parametro contiene una longitud máxima del arrojado como parámetro.
	 * 
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 20/09/2016
	 * @version 1.0
	 * @sprint 1
	 * @issue Notificación pago factura
	 * 
	 * @param param
	 *            Llave WS a validar.
	 * @param value
	 *            valor a validar.
	 * @param length
	 *            longitud máxima.
	 * @throws BusinessException
	 *             en caso de no cumplir.
	 */
	public static void validateMaxLength(String param, String value, Integer length) throws BusinessException {
		if (isNotEmpty(value) && value.length() > length) {
			throw new BusinessException(CodeErrorEnum.ERRORMAXLENGTHNOTALLOWED, param, Integer.toString(length));
		}
	}

	/**
	 * Método responsable de determinar si una cadena que recibe por parámetro es o no una cadena con solo letras.
	 * 
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 21/09/2016
	 * @version 1.0
	 * @sprint 1
	 * @issue Notificación pago factura
	 * 
	 * @param str
	 *            , cadena a validar.
	 * @return boolean, resultado de la validación, TRUE en caso de que la cadena que se recibe como parámetro
	 *         corresponda a una cadena con solo letras , FALSE en caso contrario.
	 */
	public static boolean isAlphabet(final String str) {
		return str == null ? Boolean.FALSE : str.matches("([a-z]|[A-Z])+");
	}

	/**
	 * Metodo que valida si una cadena corresponde a una cadena con solo letras, pero ignora la validación si el campo
	 * es vacío.
	 * 
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 21/09/2016
	 * @version 1.0
	 * @sprint 1
	 * @issue Notificación pago factura
	 * 
	 * @param fieldName
	 *            nombre del campo a validar
	 * @param param
	 *            cadena a validar
	 * 
	 * @throws BusinessException
	 *             Si el parametro no es un valor decimal
	 */
	public static void validateAlphabetIgnoreEmpty(final String fieldName, final String param) throws BusinessException {
		if (isNotEmpty(param) && !isAlphabet(param)) {
			throw new BusinessException(CodeErrorEnum.ERRORALPHABET, fieldName);
		}
	}

	/**
	 * Valida si un parametro contiene una longitud mínima del arrojado como parametro
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 5/10/2016
	 * @version 1.0
	 *
	 * @param param
	 *            Llave WS a validar
	 * @param value
	 *            valor a validar
	 * @param longitud
	 *            longitud mínima
	 * @throws BusinessException
	 *             en caso de no cumplir
	 */
	public static void validateMinLength(String param, String value, Integer longitud) throws BusinessException {
		if (isNotEmpty(value) && value.length() < longitud) {
			throw new BusinessException(CodeErrorEnum.ERRORMINLENGTHNOTALLOWED, param, Integer.toString(longitud));
		}
	}

	/**
	 * Método encargado de validar si un campo tiene los caracteres minimos o si excede los máximos permitidos.
	 * 
	 * @param param
	 *            , con el nombre del parámetro a validar.
	 * @param value
	 *            , con el valor a validar.
	 * @param min
	 *            , con el minimo permitido.
	 * @param max
	 *            , con el máximo permitido.
	 * @throws BusinessException
	 *             , en caso de que el parámetro no cumpla la minima longitud o exceda la máxima longitud permitida.
	 */
	public static void validateLength(String param, String value, Integer min, Integer max) throws BusinessException {
		if (isNotEmpty(value)) {
			if (value.length() < min) {
				throw new BusinessException(CodeErrorEnum.ERRORMINLENGTHNOTALLOWED, param, Integer.toString(min));
			} else if (value.length() > max) {
				throw new BusinessException(CodeErrorEnum.ERRORMAXLENGTHNOTALLOWED, param, Integer.toString(max));
			}
		}
	}

	/**
	 * Método encargado de validar un string contra una propiedad configurable con los valores permitidos.
	 * 
	 * @param nameParam
	 *            , nombre del parámetro.
	 * @param value
	 *            , valor del campo.
	 * @param config
	 *            , valor de la configuración de valores permitidos.
	 * @throws BusinessException
	 *             , en caso de que la propiedad este configurada y el valor no corresponda a ninguno de estos.
	 */
	public static void validateStringValuesConfig(String nameParam, String value, String config)
			throws BusinessException {
		if (isNotEmpty(config)) {
			String validValues = Constants.COMMA + config;
			Validation.validateStringValue(nameParam, value, false,
					validValues.concat(Constants.COMMA).split(Constants.COMMA));
		}
	}

	/**
	 * Valida si una cadena de texto tiene un determinado numero de caracteres
	 * 
	 * @param param
	 *            , Llave WS a validar.
	 * @param value
	 *            , valor a validar.
	 * @param longitud
	 *            , longitud.
	 * @throws BusinessException
	 *             , en caso de no cumplir la validación.
	 */
	public static void valideLength(String param, String value, Integer longitud) throws BusinessException {
		if (isNotEmpty(value) && value.trim().length() != longitud.intValue()) {
			throw new BusinessException(CodeErrorEnum.ERRORLENGTHINCORRECT, param, longitud.toString());
		}
	}

	/**
	 * Valida si un map es null o vacío o si el primer elemento es null
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 20/12/2016
	 * @version 1.0
	 *
	 * @param obj
	 *            el objeto a validar.
	 * @return true si es nulo o vacio, false si no es nulo y si contiene algun valor.
	 */
	public static boolean validateMapIsNullOrEmpty(Object obj) {
		boolean result = Boolean.FALSE;
		if (obj instanceof Map<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) obj;
			if (map.isEmpty()) {
				result = Boolean.TRUE;
			}
			for (Entry<?, ?> e : map.entrySet()) {
				if (!isNullOrEmpty(e.getKey()) || !isNullOrEmpty(e.getValue())) {
					return Boolean.FALSE;
				} else {
					result = Boolean.TRUE;
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * Método que valida si un String es un número de versión válido, ejemplos: 0.3.1, 2.3.1
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param toValidate
	 *            , String a validar
	 * @return boolean true si el elemento es un número de versión válido, false si no lo és
	 */
	public static boolean isVersionNumber(String toValidate) {
		return toValidate.matches("[0-9]+(\\.[0-9]+)*");
	}
}
