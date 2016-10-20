/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.model;

import java.util.ArrayList;
import java.util.List;

public class GrupoDifusion {

    private String idPropietario = null;
    
    private String idGrupoDifusion = null;
    
    private List<String> listaUsuariosGrupo = new ArrayList<String>();
        
    private List<GrupoDifusion> listaGruposGrupo = new ArrayList<GrupoDifusion>();
    
    private List<Mensaje> inbox = new ArrayList<Mensaje>();
    
    /* crear grupo difusion */
    public GrupoDifusion (String idGrupoDifusion, String idPropietario, List<String> listaUsuariosGrupo,
            List<GrupoDifusion> listaGruposGrupo){
        
        this.idGrupoDifusion = idGrupoDifusion;
        this.idPropietario = idPropietario;
        this.listaUsuariosGrupo = listaUsuariosGrupo;
        this.listaGruposGrupo = listaGruposGrupo;
    
    }
   
   /* añadir usuario al grupo de difusion*/
    public void addUsuarioGrupoDifusion(String usuario) {
        
        if(!listaUsuariosGrupo.contains(usuario))
            listaUsuariosGrupo.add(usuario);
        
    }
    
     /* eliminar usuario al grupo de difusion*/
    public void removeUsuarioGrupoDifusion(String usuario) {
        
        if (this.listaUsuariosGrupo.contains(usuario))
            this.listaUsuariosGrupo.remove(usuario);
        //TODO excepción en caso necesario
        
    }
    
    /*eliminar grupo*/
    public void removeGrupoGrupoDifusion(GrupoDifusion grupoDifusion) {
        
        if (this.listaGruposGrupo.contains(grupoDifusion)) {
             this.listaGruposGrupo.remove(grupoDifusion);    
        }
        
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public String getIdGrupoDifusion() {
        return idGrupoDifusion;
    }

    public List<String> getListaUsuariosGrupo() {
        return listaUsuariosGrupo;
    }

    public List<GrupoDifusion> getListaGruposGrupo() {
        return listaGruposGrupo;
    }

    public List<Mensaje> getInbox() {
        return inbox;
    }

    public void setInbox(List<Mensaje> inbox) {
        this.inbox = inbox;
    }
    
 
    public void addMsg(Mensaje msg){
        this.inbox.add(msg);
        this.listaGruposGrupo.stream().forEach((grp) -> {
            grp.addMsg(msg);
        });
    }

    @Override
    public String toString() {
        return "GrupoDifusion{" + "idGrupoDifusion=" + idGrupoDifusion + '}';
    }
    
    
}
