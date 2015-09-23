package org.tj.pages.base

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.wicket_scala.WicketDSL

/**
 * Created by Judge on 23.09.2015.
 */
class BasePage(parameters :PageParameters) extends WebPage(parameters) with WicketDSL  {

}
