/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ER1301.joinMe.model;

import ER1301.joinMe.view.Main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author alex030293
 */
public class Sistema {

    private final static List<Usuario> users = new ArrayList<>();
    private final static List<GrupoDifusion> groups = new ArrayList<>();
    private final static List<Contest> contests = new ArrayList<>();

    public Sistema() {
        users.add(new Usuario("Adrian", "", "123456789A", "Adrian", "Leira"));
        users.add(new Usuario("Andrea", "", "123456789A", "Andrea", "Ardions"));
        users.add(new Usuario("Alex", "", "123456789A", "Alejandro", "Martin"));
        users.add(new Usuario("Eduardo", "", "123456789A", "Eduardo", "Mosqueira")
                .addFriend(this.getUser("Alex"))
                .addFriend(this.getUser("Adrian"))
                .addFriend(this.getUser("Andrea"))
                .post("¡Hola a todos, estoy usando JoinMe!")
                .notify("¡Bienvenido a JoinMe!")
                .addFile("Foto de gatos 1")
        );

        this.getUser("Alex").addFriend(this.getUser("Eduardo"));
        this.getUser("Andrea").addFriend(this.getUser("Adrian"));
        this.getUser("Adrian").addFriend(this.getUser("Andrea"));

        List<String> usuariosGrupoEquipo = new ArrayList<String>();
        usuariosGrupoEquipo.add("Alex");
        usuariosGrupoEquipo.add("Andrea");
        usuariosGrupoEquipo.add("Adrian");

        List<GrupoDifusion> gruposGrupoEquipo = new ArrayList<GrupoDifusion>();

        groups.add(new GrupoDifusion("Equipo", "123456789A", usuariosGrupoEquipo, gruposGrupoEquipo));

        Calendar nowEvent = Calendar.getInstance();

        Calendar endEvent = Calendar.getInstance();
        endEvent.add(Calendar.YEAR, 1);

        Contest c1 = new Contest(nowEvent, endEvent, "Concurso FD");

        Sentence s1 = new Sentence("Alex", "Esta es una prueba 1", "Concurso FD");

        Sentence s2 = new Sentence("Andrea", "Esta es una prueba 2", "Concurso FD");

        Sentence s3 = new Sentence("Adrian", "Esta es una prueba 3", "Concurso FD");

        c1.addSentenceToContest(s1);
        c1.addSentenceToContest(s2);
        c1.addSentenceToContest(s3);

        contests.add(c1);

    }

    public Sistema addUser(String login, String password, String dni, String name, String surname) {
        users.add(new Usuario(login, password, dni, name, surname)
                .notify("¡Bienvenido a JoinMe!")
                .post("¡Hola a todos, estoy usando joinMe!"));

        return this;
    }

    public Sistema addGroup(String idGrupoDifusion, String idPropietario, List<String> listaUsuariosGrupo,
            List<GrupoDifusion> listaGruposGrupo) {
        groups.add(new GrupoDifusion(idGrupoDifusion, idPropietario, listaUsuariosGrupo, listaGruposGrupo));
                //.addMsg("¡Bienvenido al grupo ", idGrupoDifusion , "!"));

        return this;
    }

    public Usuario getUser(String nameUser) {
        Usuario t = null;
        for (Usuario u : this.users) {
            if (u.getUsername().equals(nameUser)) {
                t = u;
            }
        }
        return t;
    }

    public GrupoDifusion getGroup(String nameGroup) {
        GrupoDifusion t = null;
        for (GrupoDifusion g : this.groups) {
            if (g.getIdGrupoDifusion().equals(nameGroup)) {
                t = g;
            }
        }
        return t;
    }

    public Contest getContest(String nameContest) {
        Contest t = null;
        for (Contest c : this.contests) {
            if (c.getTitle().equals(nameContest)) {
                t = c;
            }
        }
        return t;
    }
    
    public void addContest(Contest nameContest){
        contests.add(nameContest);
    }

    public static List<Usuario> getUsers() {

        return users;
    }

    public static List<Contest> getContests() {
        return contests;
    }

    public ArrayList<String> getUsersNames() {
        ArrayList<String> t = new ArrayList<>();
        this.getUsers().stream().forEach((u) -> {
            t.add(0, u.getName());
        });
        return t;
    }

    public static List<String> getContestsNames() {

        List<String> temp = new ArrayList<String>();
        for (Contest c : contests) {
            temp.add(c.getTitle());

        }
        return temp;

    }

    public ArrayList<Usuario> getFriends(Usuario u) {

        return u.getFriends();
    }

    public Boolean login(String username, String password) {
        Boolean userExists = false;
        for (Usuario u : users) {
            if (u.getUsername().equals(username)) {
                userExists = true;
                Main.logedInUser = u;
            }
        }
        return userExists;
    }

    public Boolean addUserToGroup(String userId, String groupId) {

        Boolean groupExists = false;
        for (GrupoDifusion group : this.groups) {
            if (group.getIdGrupoDifusion().equals(groupId)) {
                group.addUsuarioGrupoDifusion(userId);
                groupExists = true;
            }
        }

        return groupExists;
    }

    public static List<GrupoDifusion> getGroups() {
        return groups;
    }

    public static void notifyUser(String user, String notification) {
        for (Usuario u : Sistema.users) {
            if (u.getDni().equals(user)) {
                u.notify(notification);
            }
        }
    }

    public static List<String> getGroupsNames() {

        List<String> temp = new ArrayList<String>();
        for (GrupoDifusion g : groups) {
            temp.add(g.getIdGrupoDifusion());

        }
        return temp;
    }

    public static Usuario getUserByDNI(String dni) {
        Usuario res = null;
        for (Usuario u : users) {
            if (u.getDni().equals(dni)) {
                res = u;
            }
        }
        return res;

    }

}
