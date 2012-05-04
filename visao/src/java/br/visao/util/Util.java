/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.visao.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author Fabio
 */
public class Util {
    public static void setSession(String sessionName, Object object)
    {
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .put(sessionName, object);
    }
    
}
