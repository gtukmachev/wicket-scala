package org.tj

import org.apache.wicket.Page
import org.apache.wicket.protocol.http.WebApplication

/**
 * Created by Judge on 21.09.2015.
 */
class WicketApplication extends WebApplication {
  
  
  override def getHomePage: Class[_ <: Page] = classOf[HomePage]


  override def init(): Unit = {
    super.init()
    
  }
  
}