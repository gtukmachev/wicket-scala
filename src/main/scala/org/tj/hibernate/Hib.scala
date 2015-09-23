package org.tj.hibernate

import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.boot.{Metadata, MetadataSources}
import org.hibernate.resource.transaction.spi.TransactionStatus
import org.hibernate.{Session, SessionFactory}

/**
 * Created by Judge on 22.09.2015.
 *
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

  def destroyHib() = {
    close(true)
    sessionFactory.close()
  }

  def get :Session = {

    var session = sessionFactory.getCurrentSession

    if (session == null) {
      session = sessionFactory.openSession()
      session.beginTransaction()
    }

    session
  }

  def commit() = {
    val localThreadSession = sessionFactory.getCurrentSession
    if (localThreadSession != null) {
      val transaction = localThreadSession.getTransaction
      if (transaction != null) {
        if (transaction.getStatus.isNotOneOf(TransactionStatus.ACTIVE) ) {
          transaction.commit()
          localThreadSession.beginTransaction()
        }
      }
    }
  }

  def close(isCommitTransaction :Boolean) :Unit = {
    val localThreadSession = sessionFactory.getCurrentSession
    if (localThreadSession != null) {

      try {
        val transaction = localThreadSession.getTransaction
        if (transaction != null) {
          if (transaction.getStatus.isNotOneOf(TransactionStatus.ACTIVE) ) {
            if (isCommitTransaction) {
              transaction.commit()
            } else {
              transaction.rollback()
            }
          }
        }
      } finally {
        localThreadSession.close()
      }

    }
  }

}
