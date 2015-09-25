package org.tj.wicket.app

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession
import org.apache.wicket.authroles.authorization.strategies.role.Roles
import org.apache.wicket.request.Request

/**
 * Created by Judge on 24.09.2015.
 */
class WicketScalaWebSession(request :Request) extends AuthenticatedWebSession(request) {

  val roles = new Roles()

  override def authenticate(login: String, pass: String) = {
    if (login != null && login.equals(pass)) {
      roles.add("SIGNED_IN")
      roles.add(login)
      true
    } else {
      false
    }

  }

  override def getRoles: Roles = roles

}
