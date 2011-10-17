/**
 * 
 */
package py.com.mbaez.slam;
import py.com.mbaez.slam.annotation.*;
/**
 * @author mbaez
 * 
 */
@Table(name="tabla_bd")
public class Tabla {
    @Id()
    @Column(name = "pk1")
    String clavePrimaria;

    @Id()
    @Column(name = "pk2")
    private String clavePrimaria2;

    @Column(name = "descrip")
    private String descripcion;

    public String getClavePrimaria() {
        return clavePrimaria;
    }

    public void setClavePrimaria(String clavePrimaria) {
        this.clavePrimaria = clavePrimaria;
    }

    public String getClavePrimaria2() {
        return clavePrimaria2;
    }

    public void setClavePrimaria2(String clavePrimaria2) {
        this.clavePrimaria2 = clavePrimaria2;
    }
    

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
