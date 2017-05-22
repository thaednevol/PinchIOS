package co.swatit.pilawebservices.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilawebservices.business.PilaBO;

/**
 * Clase que provee todas las pruebas unitarias del método getPermissionsById del proyecto pila-webservices
 * 
 * @author SWAT-IT <br>
 *         Cristian Camilo Londoño <br>
 *         Email: clondono@swat-it.co <br>
 * @date 17/01/2017
 * @sprint 1.0
 */
public class GetPermissionsByIdTest {
    /*
     * TODO: El método getPermissionsByRole es privado, para la ejecución de las pruebas se debe cambiar a publico.
     */

//    /**
//     * Test que prueba la consulta de los permisos del rol administrador aportante
//     * 
//     * @autor SWAT-IT <br>
//     *        Cristian Camilo Londoño <br>
//     *        Email: clondono@swat-it.co <br>
//     * @date 17/01/2017
//     * @version 1.0
//     *
//     */
//    @Test
//    public void testGetPermissionsAdministradorAportante() {
//        List<String> permissions = null;
//        try {
//            permissions = PilaBO.getPermissionsByRole(2);
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(permissions);
//    }
//
//    /**
//     * Test que prueba la consulta de los permisos del rol liquidador aportante
//     * 
//     * @autor SWAT-IT <br>
//     *        Cristian Camilo Londoño <br>
//     *        Email: clondono@swat-it.co <br>
//     * @date 17/01/2017
//     * @version 1.0
//     *
//     */
//    @Test
//    public void testGetPermissionsLiquidadorAportante() {
//        List<String> permissions = null;
//        try {
//            permissions = PilaBO.getPermissionsByRole(10);
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(permissions);
//    }
//
//    /**
//     * Test que prueba la consulta de los permisos del rol pagador aportante
//     * 
//     * @autor SWAT-IT <br>
//     *        Cristian Camilo Londoño <br>
//     *        Email: clondono@swat-it.co <br>
//     * @date 17/01/2017
//     * @version 1.0
//     *
//     */
//    @Test
//    public void testGetPermissionsPagadorAportante() {
//        List<String> permissions = null;
//        try {
//            permissions = PilaBO.getPermissionsByRole(11);
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(permissions);
//    }
//
//    /**
//     * Test que prueba la consulta de los permisos del rol liquidador y pagador aportante
//     * 
//     * @autor SWAT-IT <br>
//     *        Cristian Camilo Londoño <br>
//     *        Email: clondono@swat-it.co <br>
//     * @date 17/01/2017
//     * @version 1.0
//     *
//     */
//    @Test
//    public void testGetPermissionsLiquidadorPagadorAportante() {
//        List<String> permissions = null;
//        try {
//            permissions = PilaBO.getPermissionsByRole(12);
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(permissions);
//    }
//
//    /**
//     * Test que prueba la consulta de los permisos del rol consultas soportes aportante
//     * 
//     * @autor SWAT-IT <br>
//     *        Cristian Camilo Londoño <br>
//     *        Email: clondono@swat-it.co <br>
//     * @date 17/01/2017
//     * @version 1.0
//     *
//     */
//    @Test
//    public void testGetPermissionsConsultasSoportesAportante() {
//        List<String> permissions = null;
//        try {
//            permissions = PilaBO.getPermissionsByRole(13);
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(permissions);
//    }
//
//    /**
//     * Test que prueba la consulta de los permisos del rol cuando el idRol enviando no corresponde a ninguno del Enum
//     * 
//     * @autor SWAT-IT <br>
//     *        Cristian Camilo Londoño <br>
//     *        Email: clondono@swat-it.co <br>
//     * @date 17/01/2017
//     * @version 1.0
//     *
//     */
//    @Test
//    public void testGetPermissionsRolError() {
//        try {
//            PilaBO.getPermissionsByRole(14);
//        } catch (BusinessException e) {
//            Assert.assertEquals(e.getErrorDTO().getDescription(), "No se encontró el rol con el id enviado.");
//        }
//    }
//
//    /**
//     * Test que prueba la consulta de los permisos del rol cuando el idRol enviado es null
//     * 
//     * @autor SWAT-IT <br>
//     *        Cristian Camilo Londoño <br>
//     *        Email: clondono@swat-it.co <br>
//     * @date 17/01/2017
//     * @version 1.0
//     *
//     */
//    @Test
//    public void testGetPermissionsIdRolNull() {
//        try {
//            PilaBO.getPermissionsByRole(null);
//        } catch (BusinessException e) {
//            Assert.assertEquals(e.getErrorDTO().getDescription(), "Id rol enviado nulo.");
//        }
//    }
}
