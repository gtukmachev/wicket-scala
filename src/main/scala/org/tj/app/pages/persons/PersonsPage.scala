package org.tj.app.pages.persons

import java.util

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.{Form, TextField}
import org.apache.wicket.markup.html.list.{ListItem, PageableListView}
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.app.pages.base.BasePage

/**
 * Created by Judge on 23.09.2015.
 */
class PersonsPage(parameters :PageParameters) extends BasePage(parameters) {


  var searchLabel = new Label("searchLabel", Model.of(""))
  add(searchLabel)

  class SearchForm(id :String) extends Form[Nothing](id) {

    var textInput = new TextField[String]("search", Model.of(""))
    add(textInput)

    override def onSubmit(): Unit = {
      searchLabel.setDefaultModelObject( textInput.getModelObject )
    }
  }


  add(new SearchForm("searchForm"))


  val list = new util.ArrayList[Int](4)
  list.add(1)
  list.add(2)
  list.add(3)
  list.add(4)

  add( new PageableListView[Int](
    "personsList"
    , list
    , 10 )
  {
    override def populateItem(item: ListItem[Int]): Unit = {
      item.add(new Label("pId", item.getModelObject))
      item.add(new Label("pName", "John" + item.getModelObject))
    }
  })



}
