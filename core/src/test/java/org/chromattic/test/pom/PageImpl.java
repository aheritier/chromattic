/*
 * Copyright (C) 2003-2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.chromattic.test.pom;

import org.chromattic.api.RelationshipType;
import org.chromattic.api.annotations.AutoCreated;
import org.chromattic.api.annotations.Create;
import org.chromattic.api.annotations.ManyToOne;
import org.chromattic.api.annotations.MappedBy;
import org.chromattic.api.annotations.Name;
import org.chromattic.api.annotations.OneToMany;
import org.chromattic.api.annotations.OneToOne;
import org.chromattic.api.annotations.Owner;
import org.chromattic.api.annotations.PrimaryType;

import java.util.Collection;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
@PrimaryType(name = "pom:page")
public abstract class PageImpl {

  @OneToOne(type = RelationshipType.EMBEDDED)
  @Owner
  public abstract Templatized getTemplatized();

  @Name
  public abstract String getName();

/*
  public Collection<PortalSite> getTemplatizedPortals() {
    return getTemplatized(PortalSite.class);
  }

  public Collection<PageImpl> getTemplatizedPages() {
    return getTemplatized(PageImpl.class);
  }
*/

/*
  public <T> Collection<T> getTemplatized(Class<T> type) {
    ArrayList<T> portals = new ArrayList<T>();
    for (Templatized templatized : getTemplatizedObjects()) {
      Object owner = templatized.getOwner();
      if (type.isInstance(owner)) {
        portals.add(type.cast(owner));
      }
    }
    return portals;
  }
*/

  @OneToMany(type = RelationshipType.REFERENCE)
  @MappedBy("template")
  public abstract Collection<Templatized> getTemplatizedObjects();

  @OneToMany
  public abstract Collection<PageImpl> getChildren();

  @ManyToOne
  public abstract PageImpl getPageParent();

  @OneToOne
  @MappedBy("root")
  public abstract SiteImpl getSiteParent();

  @OneToOne
  @Owner
  @MappedBy("container")
  @AutoCreated
  public abstract UIContainerImpl getContainer();

  @Create
  public abstract PageImpl createPage(String name);

  public PageImpl addPage(String name) {
    PageImpl page = createPage(name);
    getChildren().add(page);
    return page;
  }
}
