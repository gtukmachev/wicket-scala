package org.tj.wicket.pages.base

import java.util.MissingResourceException

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.LoadableDetachableModel
import org.tj.wicket_scala.WicketDSL

/**
 * Created by Judge on 25.09.2015.
 */
class BaseHeaderPanel (id :String) extends Panel(id) with WicketDSL {

  add(new Label("caption", new LoadableDetachableModel[String]() {
    override def load(): String = {
      try {
        getString("caption")
      } catch {
        case e : MissingResourceException => getString("title")
      }
    }
  }))

}
