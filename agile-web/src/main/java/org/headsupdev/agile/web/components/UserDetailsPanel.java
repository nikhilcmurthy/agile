/*
 * HeadsUp Agile
 * Copyright 2009-2012 Heads Up Development Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.headsupdev.agile.web.components;

import org.headsupdev.agile.web.HeadsUpSession;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.basic.Label;
import org.headsupdev.agile.api.User;
import org.headsupdev.agile.api.Project;

/**
 * TODO document me
 *
 * @author Andrew Williams
 * @since 1.0
 */
public class UserDetailsPanel
    extends Panel
{
    public UserDetailsPanel( String id, User user, Project project )
    {
        super( id );

        add( new Label( "username", user.getUsername() ) );
        add( new Label( "firstname", user.getFirstname() ) );
        add( new Label( "lastname", user.getLastname() ) );
        add( new Label( "email", user.getEmail() ) );
        add( new Label( "telephone", user.getTelephone() ) );
        add( new Label( "last", new FormattedDateModel( user.getLastLogin(),
                ( (HeadsUpSession) getSession() ).getTimeZone() ) ) );
        add( new Label( "description", new MarkedUpTextModel( user.getDescription(), project ) )
                .setEscapeModelStrings( false ) );
    }
}
