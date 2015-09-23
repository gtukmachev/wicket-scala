package org.tj.app

import org.apache.wicket.Page
import org.apache.wicket.protocol.http.WebApplication
import org.tj.app.pages.home.HomePage
import org.tj.hibernate.Hib

/**
 * Created by Judge on 21.09.2015.
 */
class WicketApplication extends WebApplication {
  
  
  override def getHomePage: Class[_ <: Page] = classOf[HomePage]


  override def init(): Unit = {
    super.init()

    Hib.init("org/tj/domain/domain.hbm.xml")


  }
  
}
