package org.tj.wicket_scala

import org.apache.wicket.model.IModel

/**
 *  Created by Judge on 24.09.2015.
 */

object Link {

  def apply[T](id :String, model: IModel[T])(f: => Unit) = new Link[T](id, model)(f)
  def apply(id :String)(f: => Unit) = new Link(id)(f)

}


class Link[T](id :String, model: IModel[T])(f: => Unit) extends org.apache.wicket.markup.html.link.Link[T](id, model) {

  def this(id :String)(f: => Unit) = this(id, null)(f)

  override def onClick(): Unit = f

}
