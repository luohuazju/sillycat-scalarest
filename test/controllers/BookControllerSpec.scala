package controllers

import play.api.libs.json.JsValue

import scala.concurrent.Future

import org.scalatestplus.play._

import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

/**
 * Created by carl on 9/9/15.
 */
class BookControllerSpec extends PlaySpec with Results{

  class TestController() extends Controller with BookController

  "Book API#listBooks" should {
    "size should be 2" in {
      val controller = new TestController
      val result: Future[Result] = controller.listBooks.apply(FakeRequest())
      val bodyText: JsValue = contentAsJson(result)
      bodyText must not be null
    }
  }

}