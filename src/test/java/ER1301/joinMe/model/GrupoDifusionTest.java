package ER1301.joinMe.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class GrupoDifusionTest {
    
    private GrupoDifusion gd1, gd2, gd3;
    private String u1="u1", u2="u2", u3="u3";
    private Mensaje m1, m2, m3;
    
    
    public GrupoDifusionTest() {
    }
    
    @Before
    public void setUp() {
        
        /* Creo 3 grupos de difusión */
        gd1 = new GrupoDifusion("1", "1", null, null);
        gd2 = new GrupoDifusion("2", "2", null, null);
        gd3 = new GrupoDifusion("3", "3", null, null);
        
        m1 = new Mensaje("Hola", "Que tal", "u1", "u2");
        m2 = new Mensaje("Chao", "Nos vemos", "u2", "u3");
           
    }
    
    /**
     * Test of addUsuarioGrupoDifusion method, of class GrupoDifusion.
     * PR-UN-001
     */
    @Test
    public void testAddUsuarioGrupoDifusion() {
                    
        List<String> listaUsuariosGrupo = new ArrayList<>();
        listaUsuariosGrupo.add(u1); //añado 1
        
        gd1 = new GrupoDifusion("1", "1", listaUsuariosGrupo, null);
        
        assertTrue(listaUsuariosGrupo.equals(gd1.getListaUsuariosGrupo()));
        assertEquals(listaUsuariosGrupo.size(), 1);
        
        gd1.addUsuarioGrupoDifusion(u2); //añado2
        assertEquals(gd1.getListaUsuariosGrupo().size(), 2);
        
    }

    /**
     * Test of removeUsuarioGrupoDifusion method, of class GrupoDifusion.
     * PR-UN-002
     */
    
    
    @Test
    public void testRemoveUsuarioGrupoDifusion() {
        
       // users.add(new Usuario("Adrian", "", "123456789A", "Adrian", "Leira") );
        
        List<String> listaUsuariosGrupo = new ArrayList<>();
        
        gd1 = new GrupoDifusion("1", "1", listaUsuariosGrupo, null);

        gd1.addUsuarioGrupoDifusion(u1);
        
        assertFalse(gd1.getListaUsuariosGrupo().isEmpty());
        gd1.removeUsuarioGrupoDifusion(u1);
        assertTrue(gd1.getListaUsuariosGrupo().isEmpty());
        
        //Compruebo que tras eliminar solo queda uno.
       // assertEquals(gd1.getListaUsuariosGrupo(), "1");
    }

    /**
     * Test of removeGrupoGrupoDifusion method, of class GrupoDifusion.
     * PR-UN-003
     */
    @Test
    public void testRemoveGrupoGrupoDifusion() {
        
        List <GrupoDifusion> listaGruposGrupo = new ArrayList<>();
   
        listaGruposGrupo.add(gd2);
        
        gd1 = new GrupoDifusion("1", "1", null, listaGruposGrupo);
        
      //assertEquals(gd1.getListaGruposGrupo(), "2");
        assertFalse(gd1.getListaGruposGrupo().isEmpty());
        gd1.removeGrupoGrupoDifusion(gd2);
      //assertEquals(gd1.getListaGruposGrupo(), "0");
        assertTrue(gd1.getListaGruposGrupo().isEmpty());
    }

    /**
     * Test of getIdPropietario method, of class GrupoDifusion.
     * PR-UN-004
     */
    @Test
    public void testGetIdPropietario() {

        String expResult = "3";
        String result = gd3.getIdPropietario();
        assertEquals(expResult, result);
        
        assertTrue(gd1.getIdPropietario().equals("1"));
        assertFalse(gd1.getIdPropietario().equals("2"));

    }

    /**
     * Test of getIdGrupoDifusion method, of class GrupoDifusion.
     * PR-UN-005
     */
    @Test
    public void testGetIdGrupoDifusion() {
        
        String expResult = "1";
        String result = gd1.getIdGrupoDifusion();
        assertEquals(expResult, result);
        
        assertTrue(gd2.getIdGrupoDifusion().equals("2"));
        assertFalse(gd2.getIdGrupoDifusion().equals("3"));
    }

    /**
     * Test of getListaUsuariosGrupo method, of class GrupoDifusion.
     * PR-UN-006
     */
    @Test
    public void testGetListaUsuariosGrupo() {
        
        List<String> listaUsuariosGrupo = new ArrayList<>();
        
        gd1 = new GrupoDifusion("1", "1", listaUsuariosGrupo, null);
        
        gd1.addUsuarioGrupoDifusion(u1);
        gd1.addUsuarioGrupoDifusion(u2);

      //  assertEquals(gd1.getListaUsuariosGrupo(), "2");
         assertFalse(gd1.getListaUsuariosGrupo().isEmpty());

    }

    /**
     * Test of getListaGruposGrupo method, of class GrupoDifusion.
     * PR-UN-007
     */
    @Test
    public void testGetListaGruposGrupo() {

        assertEquals(gd1.getListaGruposGrupo(), null);

    }

    /**
     * Test of getInbox method, of class GrupoDifusion.
     * PR-UN-008
     */
    @Test
    public void testGetInbox() {
        
        List<Mensaje> inbox = new ArrayList<>();
   
        gd1.setInbox(inbox);
        //assertEquals(gd1.getInbox(), "");
        assertTrue(gd1.getInbox().isEmpty()); 
        
      /*  List<Mensaje> expResult = (List<Mensaje>) m1;
        List<Mensaje> result = gd1.getInbox();
        assertEquals(expResult, result);*/

    }

    /**
     * Test of setInbox method, of class GrupoDifusion.
     * PR-UN-009
     */
    @Test
    public void testSetInbox() {
        
        List<Mensaje> inbox = new ArrayList<>();
   
        gd1.setInbox(inbox);
       // assertEquals(gd1.getInbox(), null);
        assertTrue(gd1.getInbox().isEmpty());
    }

    /**
     * Test of addMsg method, of class GrupoDifusion.
     * PR-UN-010
     */
    @Test
    public void testAddMsg() {
        
        List <GrupoDifusion> listaGruposGrupo = new ArrayList<>();
        
        gd1 = new GrupoDifusion("1", "1", null, listaGruposGrupo);
        
        Mensaje msg = m1;

        // Añadimos mensaje 1 a gd 1
       gd1.addMsg(msg);
       assertFalse(gd1.getInbox().isEmpty());
    }
    
}
