package org.tj.hibernate

import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.boot.{Metadata, MetadataSources}

/**
 * Created by Judge on 22.09.2015.
 */
object Hib  {

  var sessionFactory :SessionFactory = _


  def init(hbmFile: String) = {
    // A SessionFactory is set up once for an application!
    val registry = new StandardServiceRegistryBuilder()
      .configure() // configures settings from hibernate.cfg.xml
      .build()


    try {

      val metadataSource = new MetadataSources( registry )
        .addResource( hbmFile )

      val metadata :Metadata = metadataSource.buildMetadata()

      sessionFactory = metadata.buildSessionFactory()
    }
    catch {
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      case e :Exception => StandardServiceRegistryBuilder.destroy( registry )
        throw e
    }

  }


}
