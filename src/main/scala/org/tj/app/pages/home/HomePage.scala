package org.tj.app.pages.home

import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.app.components.PageLink
import org.tj.app.pages.base.BasePage
import org.tj.app.pages.persons.PersonsPage

/**
 * Created by Judge on 21.09.2015.
 */
class HomePage(parameters :PageParameters) extends BasePage(parameters) {

  add( PageLink("personsLink", classOf[PersonsPage]) )

}
