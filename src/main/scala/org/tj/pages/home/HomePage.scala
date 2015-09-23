package org.tj.pages.home

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.pages.base.BasePage

/**
 * Created by Judge on 21.09.2015.
 */
class HomePage(parameters :PageParameters) extends BasePage(parameters) {


    +=(new Label("version", getApplication.getFrameworkSettings.getVersion))


}
