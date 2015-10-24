//defined at
//http://www.onjava.com/pub/a/onjava/2003/11/12/reflection.html?page=2


package edu.clemson.cs.test;

import java.lang.reflect.Field;
import junit.framework.Assert;

/**
 * Provides access to private members in classes.
 */
@SuppressWarnings("deprecation")
public class PrivateAccessor {
  public static Object getPrivateField (Object o, String fieldName) {
    /* Check we have valid arguments */
    Assert.assertNotNull(o);
    Assert.assertNotNull(fieldName);
    /* Go and find the private field... */
    final Field fields[] =
        o.getClass().getDeclaredFields();
    for (int i = 0; i < fields.length; ++i) {
      if (fieldName.equals(fields[i].getName())) {
        try {
          fields[i].setAccessible(true);
          return fields[i].get(o);
        } catch (IllegalAccessException ex) {
          Assert.fail ("IllegalAccessException accessing " + fieldName);
        }
      }
    }
    Assert.fail ("Field '" + fieldName + "' not found");
    return null;
  }
}
