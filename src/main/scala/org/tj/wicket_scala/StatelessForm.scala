package org.tj.wicket_scala

import org.apache.wicket.model.IModel

/**
 *  Created by Judge on 24.09.2015.
 */

object StatelessForm {

  def apply[T](id :String, model: IModel[T])(f: => Unit) = new StatelessForm[T](id, model)(f)
  def apply(id :String)(f: => Unit) = new StatelessForm(id)(f)

}


class StatelessForm[T](id :String, model: IModel[T])(f: => Unit) extends org.apache.wicket.markup.html.form.StatelessForm[T](id, model) {

  def this(id :String)(f: => Unit) = this(id, null)(f)

  override def onSubmit(): Unit = f

}
