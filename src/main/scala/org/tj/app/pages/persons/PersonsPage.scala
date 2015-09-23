package org.tj.app.pages.persons

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.{Form, TextField}
import org.apache.wicket.markup.html.list.{ListItem, PageableListView}
import org.apache.wicket.model.{LoadableDetachableModel, Model}
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.tj.app.pages.base.BasePage
import org.tj.domain.Person
import org.tj.hibernate.Hib

/**
 *
 * Created by Judge on 23.09.2015.
 */
class PersonsPage(parameters :PageParameters) extends BasePage(parameters) {

  class SearchForm(id :String) extends Form[Nothing](id) {
    var textInput = new TextField[String]("search", Model.of(""))
    add(textInput)
    override def onSubmit(): Unit = {
      //todo
    }
  }


  class AddPersonForm(id :String) extends Form[Nothing](id) {
    var pNameInput = new TextField[String]("pName", Model.of(""))
    add(pNameInput)
    override def onSubmit(): Unit = {

      val person = new Person()
      person.name = pNameInput.getModelObject

      Hib.get.save(person)

    }
  }


  add(new SearchForm("searchForm"))
  add(new AddPersonForm("addForm"))



  val personsModel = new LoadableDetachableModel[java.util.List[Int]]() {
    override def load(): java.util.List[Int] = {
      Hib.get.createQuery("select id from Person").list().asInstanceOf[java.util.List[Int]]
    }
  }

  add( new PageableListView[Int](
    "personsList"
    , personsModel
    , 10 )
  {
    override def populateItem(item: ListItem[Int]): Unit = {
      val person = Hib.get.get(classOf[Person], item.getModelObject)

      item.add(new Label("pId", item.getModelObject))
      item.add(new Label("pName", person.name ))
    }
  })



}
