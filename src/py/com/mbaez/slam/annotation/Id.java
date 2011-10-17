/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.mbaez.slam.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 *
 * @author mbaez
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {

}