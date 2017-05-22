package co.swatit.pilautil.enums;

/**
 * Enum que contiene los nombres de las operaciones sobre las que se hará el filtrado de notificaciones
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
public enum NotificationFilterOperationEnum {

	/** Operación para determinar si la versión ingresada es igual a la del filtro */
	EQUALS,
	/** Operación para determinar si la versión ingresada es menor o igual a la del filtro */
	LESSTHANOREQUAL,
	/** Operación para determinar si la versión ingresada es mayor o igual a la del filtro */
	GREATERTHANOREQUAL,
	/** Operación para determinar si la versión ingresada está dentro del rango del filtro */
	RANGE;
}
