package org.tj.wicket.pages.base

import org.apache.wicket.Component
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * Created by Judge on 25.09.2015.
 */

@AuthorizeInstantiation(Array("SIGNED_IN"))
class SignedInPage(pageParameters: PageParameters) extends BasePage(pageParameters){

  override def onInitialize(): Unit = {
    super.onInitialize()



  }

  override def buildHeaderComponent(id: String) :Component = new SignedInHeaderPanel(id)

}
