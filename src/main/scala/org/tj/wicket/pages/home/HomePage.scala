package org.tj.wicket.pages.home

import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.wicket.components.PageLink
import org.tj.wicket.pages.base.BasePage
import org.tj.wicket.pages.persons.PersonsPage

/**
 * Created by Judge on 21.09.2015.
 */
class HomePage(parameters :PageParameters) extends BasePage(parameters) {

  add( PageLink("personsLink", classOf[PersonsPage]) )

}
