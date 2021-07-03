/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

/**
 *
 * @author Piedra Fernandez Gabriel (236557)
 */
public class MyConfiguration {

    public static final String URL_SUSALUD = "aHR0cDovL2FwcDkuc3VzYWx1ZC5nb2IucGU6ODA4MC9ycy1zZXJ2aWNpby1jaXVkYWRhbm8vc2VydmVyL2dldEFmZmlsaWF0aW9ucw==";

    public static String bodyPost(String str) {
        return "{\"fecNac\": \"\",\"codPais\": \"PER\",\"nroDni\": \"" + str + "\",\"tipoDoc\": \"1\"}";
    }
}
