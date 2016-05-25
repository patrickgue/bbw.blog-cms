/*
 * Copyright (C) 2016 guenthard
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.eggbacon.app.controller;

import ch.eggbacon.app.entity.Person;
import ch.eggbacon.app.util.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author guenthard
 */
@ManagedBean
@SessionScoped
public class PersonController {
    private List<Person> personList;
    private SessionFactory fc;
    private Session session;
    
    private String filterString;

    public PersonController () {
        try {
            fc = HibernateUtil.getSessionFactory();
            session = fc.openSession();

            personList = session.createQuery("FROM Person").list();
            
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public SessionFactory getFc() {
        return fc;
    }

    public void setFc(SessionFactory fc) {
        this.fc = fc;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    
}