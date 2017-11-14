package controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}
import repositories.UserRepository

import scala.concurrent.ExecutionContext

class UserController @Inject()(cc: ControllerComponents, userRepository: UserRepository)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  def index = Action.async {
    userRepository.all().map(_ => Ok("Users are here."))
  }
}