package org.tj.wicket.components

import org.apache.wicket.Page
import org.apache.wicket.markup.html.link.BookmarkablePageLink

/**
 * Created by Judge on 23.09.2015.
 */
case class PageLink(id: String, pageClass: Class[_ <: Page]) extends BookmarkablePageLink[Page](id, pageClass) {

}
