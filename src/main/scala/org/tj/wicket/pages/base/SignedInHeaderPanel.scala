package org.tj.wicket.pages.base

import org.apache.wicket.protocol.http.WebSession
import org.tj.wicket.app.WicketScalaWebSession
import org.tj.wicket_scala.WicketDSL

/**
 * Created by Judge on 25.09.2015.
 */
class SignedInHeaderPanel(id :String) extends BaseHeaderPanel(id) with WicketDSL {

  link("logoutLink") { WebSession.get().asInstanceOf[WicketScalaWebSession].invalidate() }

}
