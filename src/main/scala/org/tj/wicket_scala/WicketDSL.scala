package org.tj.wicket_scala

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel
import org.apache.wicket.{Component, MarkupContainer}

/**
 * Created by Judge on 21.09.2015.
 */
trait WicketDSL { self: MarkupContainer =>

  def += (child :Component) = { self.add(child);  child }

  def link(id: String) ( f: => Unit) :Link[Any] = { self.+=(Link(id)(f)).asInstanceOf[Link[Any]] }

  def label(id:String, model: IModel[_]) = { +=( new Label(id, model ) )}

}
