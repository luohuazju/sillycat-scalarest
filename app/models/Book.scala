package models

import play.api.libs.json.Json

case class Book(var id:Option[String], title: String, author: String, isbn: String)

object Book {

  implicit val bookWrites = Json.writes[Book]
  implicit val bookReads = Json.reads[Book]

  var books = List(
    Book(Some("1"),"Python in Action", "Xman", "isbn-001"),
    Book(Some("2"), "R in Action", "Hero", "isbn-002")
  )

  def addBook(b: Book) = {
    val r = scala.util.Random
    b.id = Some(r.nextInt(10000000).toString)
    books = books ::: List(b)
  }

  def getBook(id:String):Option[Book] = {
    val finds = books filter { book =>
      book.id.get.equals(id)
    }
    finds.size match {
      case 1 => Some(finds(0))
      case _ => None
    }
  }

  def deleteBook(id:String) = {
    val filters = books filterNot { book =>
      book.id.get.equals(id)
    }
    books = filters
  }

  def updateBook(b:Book) = {
    val filters = books filterNot { book =>
      book.id.get.equals(b.id.get)
    }
    books = filters ::: List(b)
  }
}
