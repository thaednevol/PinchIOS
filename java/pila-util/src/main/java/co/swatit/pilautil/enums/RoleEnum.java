package co.swatit.pilautil.enums;

import co.swatit.pilautil.constants.NumberConstants;

/**
 * Enumerado que contiene los roles de la aplicación
 * 
 * @author SWAT-IT <br>
 *         Cristian Camilo Londoño <br>
 *         Email: clondono@swat-it.co <br>
 * @date 16/01/2017
 * @sprint 1.0
 */
public enum RoleEnum {

    /** Rol administrador aportante. */
    ADMINISTRADOR_APORTANTE(NumberConstants.TWO),
    /** Rol liquidador aportante. */
    LIQUIDADOR_APORTANTE(NumberConstants.TEN),
    /** Rol pagador aportante. */
    PAGADOR_APORTANTE(NumberConstants.ELEVEN),
    /** liquidador y pagador aportante */
    LIQUIDADOR_PAGADOR_APORTANTE(NumberConstants.TWELVE),
    /** Rol consultas y soportes aportante. */
    CONSULTAS_SOPORTES_APORTANTE(NumberConstants.THIRTEEN);

    /** Código del rol. */
    private int idRole;

    /**
     * Constructor por defecto del enumerado.
     * 
     * @param idRole
     *            Id del rol
     */
    private RoleEnum(int idRole) {
        this.idRole = idRole;
    }

    /**
     * Permite obtener el valor del campo IdRole
     *
     * @author SWAT-IT<br>
     *         Cristian Camilo Londoño<br>
     *         Email: clondono@swat-it.co<br>
     * 
     * @date 16/01/2017
     * @version 1.0
     * @sprint 1
     *
     * @return int, valor del campo IdRole
     */
    public int getIdRole() {
        return idRole;
    }
}
