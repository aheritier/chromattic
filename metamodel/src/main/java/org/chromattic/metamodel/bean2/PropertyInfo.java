/*
 * Copyright (C) 2010 eXo Platform SAS.
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

package org.chromattic.metamodel.bean2;

import org.reflext.api.ClassTypeInfo;
import org.reflext.api.MethodInfo;
import org.reflext.api.TypeInfo;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public abstract class PropertyInfo<V extends ValueInfo> {

  /** The bean this property is declared on. */
  private final BeanInfo bean;

  /** The parent property. */
  private PropertyInfo parent;

  /** The property name. */
  private final String name;

  /** The the most adapter getter. */
  private final MethodInfo getter;

  /** The the most adapted setter. */
  private final MethodInfo setter;

  /** . */
  private final V value;

  PropertyInfo(
      BeanInfo bean,
      PropertyInfo parent,
      String name,
      MethodInfo getter,
      MethodInfo setter,
      V value) {
    this.bean = bean;
    this.parent = parent;
    this.name = name;
    this.getter = getter;
    this.setter = setter;
    this.value = value;
  }

  public V getValue() {
    return value;
  }

  public BeanInfo getBean() {
    return bean;
  }

  public PropertyInfo getParent() {
    return parent;
  }

  public String getName() {
    return name;
  }

  public MethodInfo getGetter() {
    return getter;
  }

  public MethodInfo getSetter() {
    return setter;
  }
}