package co.swatit.pilautil.generics;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase de utilidades generales para archivos.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class FileUtilities {

	/**
	 * Referencia el Log del sistema
	 */
	private static final Logger LOGGER = Logger.getLogger(FileUtilities.class.getName());
	/**
	 * Formato de fecha.
	 */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-yyyy");
	/**
	 * Separador de archivos.
	 */
	public static final String FILE_SEPARATOR = "-";
	
	public static final int BUFFER = 2048;
	
	/**
	 * Constructor.
	 */
	private FileUtilities() {
		
	}
	
	
	/**
	 * Escribe un flujo de bytes como un archivo zip.
	 * 
	 * @param filePath Ruta donde se debe escribir el archivo.
	 * @param bytes Flujo de bytes que contiene el archivo.
	 */
	public static void write(String filePath, byte[] bytes) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			fileOutputStream.write(bytes);
		} catch (FileNotFoundException e) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
		} catch (IOException e) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
			}
		}
	}

	
	/**
	 * Descomprime un archivo con extension .zip.
	 * @param zipFilePath Ruta donde esta ubicado el archivo .zip.
	 * @param destDirectory Ruto destino donde se debe descomprimir el archivo.
	 */
	public static void unzipFile(String zipFilePath, String destDirectory) {
		try {
			File dirDestination = new File(destDirectory);
			File zipFile = new File(zipFilePath);
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			FileOutputStream fos = null;
			ZipEntry entry;
			int count;
			int index = 0;
			byte data[] = new byte[BUFFER];
			String filePath = null;
			
			while ((entry = zis.getNextEntry()) != null) {
				filePath = entry.getName();
				index = filePath.indexOf("/");
				filePath = filePath.substring(index + 1);
				if (filePath.trim().length() > 0) {
					try {
						dest = null;
						File fileDest = new File(dirDestination.getAbsolutePath()
								+ "/" + filePath);
						if (entry.isDirectory()) {
							fileDest.mkdirs();
						} else {
							if (fileDest.getParentFile().exists() == false)
								fileDest.getParentFile().mkdirs();

							fos = new FileOutputStream(fileDest);
							dest = new BufferedOutputStream(fos, BUFFER);
							while ((count = zis.read(data, 0, BUFFER)) != -1) {
								dest.write(data, 0, count);
							}
							dest.flush();
						}
					} finally {
						try {
							if (dest != null) {
								dest.close();
							}
							
							if (fos != null) {
								fos.close();
							}
							
							if (fis != null) {
								fis.close();
							}
							
							if (dest != null) {
								dest.close();
							}
							
						} catch (Exception e) {
							LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
						}
					}
				}
			}
			zipFile.delete();
		} catch (Exception e) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
		}
	}
	
	
	/**
	 * Copia la planilla a un directorio temporal.
	 * 
	 * @param fileName Nombre del archivo.
	 * @param bytes    Flujo de bytes que contienen el archivo.
	 * @return Ruta del archivo.
	 * @throws Exception
	 */
	public static String copyGetFile(String fileName, byte[] bytes)
			 {
		
		String idArchivoEnProceso = null;
		StringBuilder nombreArchivo = new StringBuilder();
		String filePath = createDir(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "PATH_FILE"));
		Long idArchivo = System.currentTimeMillis();
		idArchivoEnProceso = String.valueOf(idArchivo)
				+ FILE_SEPARATOR
				+ fileName.toUpperCase();
		nombreArchivo.append(filePath);
		nombreArchivo.append(File.separator);
		nombreArchivo.append(idArchivoEnProceso);
		if (!fileName.equals("")) {
			FileOutputStream fileOutStream;
			try {
				fileOutStream = new FileOutputStream(nombreArchivo
						.toString());
				fileOutStream.write(bytes);
				fileOutStream.flush();
				
				
				fileOutStream.close();
			} catch (FileNotFoundException e) {
				LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
			} catch (IOException e) {
				LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
			}
			
		}
		return nombreArchivo.toString();
	}
	
	
	/**
	 * Crea un directorio temporal para la creación de las planillas.
	 * 
	 * @param path Ruta del archivo.
	 * @return Ruta completa de creación del archivo.
	 */
	public static String createDir(String path){
		String strDirectory = path + File.separator
				+ DATE_FORMAT.format(Calendar.getInstance().getTime());
		try {

			// Create one directory
			boolean success = (new File(strDirectory)).mkdir();

		} catch (Exception e) {// Catch exception if any
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
		}
		return strDirectory;
	}

	
	/**
	 * Lee un archivo y lo convierte en un flujo de bytes.
	 * 
	 * @param zipFileName Ruta donde esta ubicado el archivo.
	 * @return Flujo de bytes con el contenido del archivo.
	 */
	public static byte[] readZipFile(String zipFileName) {
		byte[] bytes = null;
		FileInputStream fileInputStream = null;
		try {

			File file = new File(zipFileName);
			bytes = new byte[(int) file.length()];

			fileInputStream = new FileInputStream(zipFileName);
			fileInputStream.read(bytes);
		} catch (Exception e) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}

			} catch (IOException e) {
				LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), e);
			}
		}

		return bytes;
	}
	
	
	public static void zipFile(String rutaArchivo, String nombreArchivo, String nombreArchivoZip) {
    	byte[] buffer = new byte[1024];

    	try{

    		FileOutputStream fos = new FileOutputStream(rutaArchivo + nombreArchivoZip);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze = new ZipEntry(nombreArchivo);
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(rutaArchivo + nombreArchivo);

    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();

    		//remember close it
    		zos.close();

    		System.out.println("Done");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
    }
}
