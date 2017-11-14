package repositories

import javax.inject.Inject

import models.UserModel
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class UserRepository @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  private val Users = TableQuery[UsersTable]

  def all(): Future[Seq[UserModel]] = db.run(Users.result)
  def insert(userModel: UserModel): Future[Unit] = db.run(Users += userModel).map(_ => ())

  class UsersTable(tag: Tag) extends Table[UserModel](tag, "users") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def password = column[String]("password")

    def * = (id, name, password) <> (UserModel.tupled, UserModel.unapply)
  }
}
