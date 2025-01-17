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
package ch.eggbacon.app.service;

import ch.eggbacon.app.entity.Person;
import ch.eggbacon.app.interf.PersonService;
import java.util.List;

/**
 *
 * @author guenthard
 */
public class PersonServiceImpl extends DatabaseServiceImpl<Person> implements PersonService {

    private final String TABLE_NAME = "Person";
    
    @Override
    public List<Person> searchAllPerson() {
        return getSession().createQuery("FROM "+TABLE_NAME).list();
    }
    
}
