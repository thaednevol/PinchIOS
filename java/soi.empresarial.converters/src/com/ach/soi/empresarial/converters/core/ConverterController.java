package com.ach.soi.empresarial.converters.core;

import com.ach.soi.empresarial.converters.enums.TipoArchivo;
import com.ach.soi.empresarial.converters.model.Archivo2388TO;
import com.ach.soi.empresarial.converters.model.ErrorValidacionTO;

public class ConverterController {

	
	/**
	 * 
	 * Metodo que valida la estructura sintactica de un archivo plano
	 * de liquidacion de planilla PILA de activos o pensionados.
	 * 
	 * 
	 * 
	 * @param pathArchivo Ruta en el filesystem del archivo plano
	 * @param tipoArchivo 1747 para activos, 2145 para pensionados
	 * @return Arreglo con los errores ocurridos durante la validacion, arreglo vacio en caso que no ocurra ningun error.
	 */
	public ErrorValidacionTO[] validarArchivoPila ( String pathArchivo, String tipoArchivo ) throws Exception{
		Validator1747 val1747 = new Validator1747(); 
		Validator2145 val2145 = new Validator2145();
		TipoArchivo tp = TipoArchivo.getTipoArchivoPorCod(tipoArchivo);
		
		switch (tp) {
		case ACTIVOS:
			return val1747.validarArchivo1747(pathArchivo);
		case PENSIONADOS:
			return val2145.validarArchivo2145(pathArchivo);
		default:
			throw new Exception("Tipo de archivo no implementado: "+tipoArchivo);
		}
		
	}
	
	
	/**
	 * 
	 * Metodo que permite convertir un archivo al formato 2388 adecuado de acuerdo al tipo seleccionado
	 * 
	 * @param pathArchivo Path del archivo plano origen a convertir
	 * @param tipoArchivo 1747 para activos, 2145 para pensionados
	 * @return Objeto que contiene todos los elementos del archivo plano en formato 2388
	 */
	public Archivo2388TO convertirArchivoA2388 ( String pathArchivo, String pathArchivoComplementario,String tipoArchivo ) throws Exception{
		
		Converter1747to2388 converter = new Converter1747to2388();
		Converter2145to2388 converter2145 = new Converter2145to2388();
		
		TipoArchivo tp = TipoArchivo.getTipoArchivoPorCod(tipoArchivo);
		
		switch (tp) {
		case ACTIVOS:
			return converter.convertir1747a2388(pathArchivo,pathArchivoComplementario);
		case PENSIONADOS:
			return converter2145.convertir2145a2388(pathArchivo);
		default:
			throw new Exception("Tipo de archivo no implementado: "+tipoArchivo);
		}
		
	}
	
	/**
	 * 
	 * Metodo que permite leer un archivo 2388 y formatearlo a json
	 * 
	 * @param pathArchivo Path del archivo plano origen a convertir
	 * @param tipoArchivo 1747 para activos, 2145 para pensionados
	 * @return Objeto que contiene todos los elementos del archivo plano en formato 2388
	 */
	public Archivo2388TO leerArchivo2388 ( String pathArchivo ) throws Exception{
		Validator2388 val = new Validator2388();
		
		return val.read2388File(pathArchivo);
	}
	
}
