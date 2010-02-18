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

package org.chromattic.core.vt;

import org.chromattic.core.bean.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class ValueTypeFactory {

  public static <V> ValueType<V> create(final SimpleValueInfo<V> sv) {
    return create(sv, sv.getSimpleType().getKind());

  }

  private static <E, I> ValueType<E> create(SimpleValueInfo<E> sv, SimpleTypeKind<E, I> kind) {
    ValueType vt;
    if (kind == BaseSimpleTypes.STRING) {
      vt = new BaseValueType.STRING.TO_STRING((List<String>)sv.getDefaultValue(), (SimpleType<String>)sv.getSimpleType());
    } else if (kind == BaseSimpleTypes.PATH) {
      vt = new BaseValueType.PATH.TO_STRING((List<String>)sv.getDefaultValue(), (SimpleType<String>)sv.getSimpleType());
    } else if (kind == BaseSimpleTypes.INT) {
      vt = new BaseValueType.LONG.TO_INT((List<Integer>)sv.getDefaultValue(), (SimpleType<Integer>)sv.getSimpleType());
    } else if (kind == BaseSimpleTypes.BOOLEAN) {
      vt = new BaseValueType.BOOLEAN.TO_BOOLEAN((List<Boolean>)sv.getDefaultValue(), (SimpleType<Boolean>)sv.getSimpleType());
    } else if (kind == BaseSimpleTypes.LONG) {
      vt = new BaseValueType.LONG.TO_LONG((List<Long>)sv.getDefaultValue(), (SimpleType<Long>)sv.getSimpleType());
    } else if (kind == BaseSimpleTypes.DATE) {
      vt = new BaseValueType.DATE.TO_DATE((List<Date>)sv.getDefaultValue(), (SimpleType<Date>)sv.getSimpleType());
    } else if (kind == BaseSimpleTypes.DOUBLE) {
      vt = new BaseValueType.DOUBLE.TO_DOUBLE((List<Double>)sv.getDefaultValue(), (SimpleType<Double>)sv.getSimpleType()); 
    } else if (kind == BaseSimpleTypes.FLOAT) {
      vt = new BaseValueType.DOUBLE.TO_FLOAT((List<Float>)sv.getDefaultValue(), (SimpleType<Float>)sv.getSimpleType());
    } else if (kind == BaseSimpleTypes.STREAM) {
      vt = new BaseValueType.STREAM.TO_STREAM((List<InputStream>)sv.getDefaultValue(), (SimpleType<InputStream>)sv.getSimpleType());
    } else if (kind instanceof StringEnumTypeKind) {
      StringEnumTypeKind setk = (StringEnumTypeKind)kind;
      vt = new StringEnumValueType(sv.getDefaultValue(), sv.getSimpleType(), setk.getExternalType());
    } else {
      throw new AssertionError();
    }

    //
    return (ValueType<E>)vt;
  }
}