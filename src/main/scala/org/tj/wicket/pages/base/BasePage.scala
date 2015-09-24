package org.tj.wicket.pages.base

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.AbstractReadOnlyModel
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.wicket_scala.WicketDSL

/**
 * Created by Judge on 23.09.2015.
 */
class BasePage(parameters :PageParameters) extends WebPage(parameters) with WicketDSL  {

  override def onInitialize(): Unit = {
    super.onInitialize()

    add(buildTitleComponent("title"))
    add(buildCaptionComponent("caption"))

    add(new Label("version", getApplication.getFrameworkSettings.getVersion))
  }


  def buildTitleComponent(id :String) = new Label(id, buildTitleModel)

  def buildCaptionComponent(id :String) = buildTitleComponent(id)

  def buildTitleModel = new AbstractReadOnlyModel[String] {
      override def getObject: String = getString("title")
  }

}
