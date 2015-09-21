package org.tj

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.wicket_scala.WicketDSL

/**
 * Created by Judge on 21.09.2015.
 */
class HomePage(parameters :PageParameters) extends WebPage(parameters) with WicketDSL {


    +=(new Label("version", getApplication.getFrameworkSettings.getVersion))


}
