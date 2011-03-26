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
package org.chromattic.core.mapper.embedded;

import org.chromattic.core.bean.SingleValuedPropertyInfo;
import org.chromattic.core.bean.BeanValueInfo;
import org.chromattic.core.mapper.PropertyMapper;
import org.chromattic.core.ObjectContext;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class JCREmbeddedPropertyMapper extends PropertyMapper<SingleValuedPropertyInfo<BeanValueInfo>> {

  /** . */
  private final Class relatedClass;

  public JCREmbeddedPropertyMapper(SingleValuedPropertyInfo<BeanValueInfo> info) throws ClassNotFoundException {
    super(info);

    //
    relatedClass = Thread.currentThread().getContextClassLoader().loadClass(info.getValue().getTypeInfo().getName());
  }

  @Override
  public Object get(ObjectContext context) throws Throwable {
    return context.getMixin(info.getValue().getTypeInfo());
  }

  @Override
  public void set(ObjectContext context, Object value) throws Throwable {

    if (value == null) {
      throw new UnsupportedOperationException();
    }

    //
    ObjectContext embeddedCtx = context.getSession().unwrap(value);

    



    super.set(context, value);    //To change body of overridden methods use File | Settings | File Templates.
  }
}