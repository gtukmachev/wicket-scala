package org.tj.wicket

import org.apache.wicket.request.cycle.{IRequestCycleListener, RequestCycle}
import org.apache.wicket.request.{IRequestHandler, Url}
import org.tj.hibernate.Hib

/**
 * Created by Judge on 23.09.2015.
 */
class MainRequestCycleListener extends IRequestCycleListener{

  override def onExceptionRequestHandlerResolved(cycle: RequestCycle, handler: IRequestHandler, exception: Exception): Unit = {}

  override def onRequestHandlerResolved(cycle: RequestCycle, handler: IRequestHandler): Unit = {}

  override def onDetach(cycle: RequestCycle): Unit = {}

  override def onRequestHandlerScheduled(cycle: RequestCycle, handler: IRequestHandler): Unit = {}

  override def onBeginRequest(cycle: RequestCycle): Unit = {}

  override def onException(cycle: RequestCycle, ex: Exception): IRequestHandler = null

  override def onUrlMapped(cycle: RequestCycle, handler: IRequestHandler, url: Url): Unit = {}

  override def onRequestHandlerExecuted(cycle: RequestCycle, handler: IRequestHandler): Unit = {}

  override def onEndRequest(cycle: RequestCycle): Unit = {
    // commit current transaction (if have one)
    Hib.close(true)
  }
}
