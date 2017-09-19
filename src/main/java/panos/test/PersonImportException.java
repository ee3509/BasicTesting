/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test;

/*
 * Copyright (c) UReason.  All Rights Reserved.
 * <p/>
 * @author Panos
 */
public class PersonImportException extends Throwable
{
  private final String _msg;

  public PersonImportException(String msg) {

    _msg = msg;
  }

  public String getMsg() {
    return _msg;
  }
}
