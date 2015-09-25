package org.tj.wicket.app

import org.apache.wicket.Page
import org.apache.wicket.authroles.authentication.pages.SignInPage
import org.apache.wicket.authroles.authentication.{AbstractAuthenticatedWebSession, AuthenticatedWebApplication}
import org.apache.wicket.markup.html.WebPage
import org.slf4j.LoggerFactory
import org.tj.hibernate.Hib
import org.tj.wicket.pages.home.HomePage
import org.tj.wicket.pages.persons.PersonsPage

/**
*   Created by Judge on 21.09.2015.
*/
object WicketScalaApplication {
  val logger = LoggerFactory.getLogger(classOf[WicketScalaApplication])
}

class WicketScalaApplication extends AuthenticatedWebApplication {
  import WicketScalaApplication._

  override def getHomePage: Class[_ <: Page] = classOf[HomePage]

  override def init(): Unit = {
    logger.info("\n\n\n\n\n\n\n7\n6\n5\n4\n3\n2\n1\ngo!\n" +
      "*********************************************************************\n" +
      "*****\n" +
      "***** WicketScalaApplication init...\n" +
      "*****\n" +
      "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n\n")

    super.init()

    Hib.init("org/tj/domain/domain.hbm.xml")


    mountPage("/persons", classOf[PersonsPage] )

    logger.info("\n\n" +
      "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
      "*****\n" +
      "***** WicketScalaApplication STARTED \n" +
      "*****\n" +
      "*********************************************************************\n\n")

  }

  override def getWebSessionClass: Class[_ <: AbstractAuthenticatedWebSession] = classOf[WicketScalaWebSession]

  override def getSignInPageClass: Class[_ <: WebPage] = classOf[SignInPage]
}
