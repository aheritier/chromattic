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

package org.chromattic.test.onetomany.hierarchical.collection;

import org.chromattic.test.onetomany.hierarchical.AbstractOneToTestCase;
import org.chromattic.test.onetomany.hierarchical.collection.TOTM_A_2;
import org.chromattic.test.onetomany.hierarchical.collection.TOTM_B_2;

import javax.jcr.Node;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class OneToTestCase extends AbstractOneToTestCase<TOTM_A_2, TOTM_B_2> {

  public void setOne(TOTM_B_2 many, TOTM_A_2 one) {
    many.setParent(one);
  }

  public TOTM_A_2 getOne(TOTM_B_2 many) {
    return many.getParent();
  }
}