package controllers

import play.api.libs.json._
import play.api.mvc._
import models.Book

import com.wordnik.swagger.annotations.{Api,ApiModel,ApiModelProperty,ApiOperation,ApiParam,ApiResponse,ApiResponses}


@Api(value = "/api/v1/book", description = "Operations with Book")
object BookController extends Controller {
  @ApiOperation(value = "Fetch All the Books",
    notes = "Returns all the books",
    response = classOf[models.Book],
    httpMethod = "GET",
    produces = "application/json",
    position = 1)
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Successful load all books"),
    new ApiResponse(code = 500, message = "System Error.")
  )
  )
  def listBooks = Action {
    Ok(Json.toJson(Book.books))
  }

  def saveBook = Action(BodyParsers.parse.json) { request =>
    val b = request.body.validate[Book]
    b.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toJson(errors)))
      },
      book => {
        Book.addBook(book)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }

  def getBook(id:String) = Action {
    Book.getBook(id) match {
      case Some(b) => Ok(Json.toJson(b))
      case _ => Ok(Json.obj("status" -> "OK", "message" -> "Book Not Found!"))
    }
  }

  def deleteBook(id:String) = Action {
    Book.deleteBook(id)
    Ok(Json.obj("status" -> "OK"))
  }

  def updateBook(id:String) = Action(BodyParsers.parse.json){ request =>
    val b = request.body.validate[Book]
    b.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toJson(errors)))
      },
      book => {
        book.id = Some(id)
        Book.updateBook(book)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }
}
