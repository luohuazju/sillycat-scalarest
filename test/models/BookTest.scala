package models

import org.junit.{Assert, Test}

/**
 * Created by carl on 9/9/15.
 */
class BookTest {

  @Test
  def loadAll(): Unit ={
    val books = Book.books
    Assert.assertNotNull(books)
    Assert.assertTrue("books.size should be 2", books.size > 0)
  }

  @Test
  def saveBook() = {
    val book = Book(None, "titlex", "sillycat", "ISBN-94983")
    val id = Book.addBook(book)
    Assert.assertNotNull(id)
  }

  @Test
  def getBook() = {
    val book = Book.getBook("1")
    Assert.assertNotNull(book)
    Assert.assertNotNull(book.get)
    Assert.assertNotNull(book.get.title)
  }

  @Test
  def updateBook() = {
    val b1 = Book(None, "titleb1", "sillycat", "ISBN-1")
    val id = Book.addBook(b1)

    val b2 = Book(Some(id), "titleb2", "kiko", "ISBN-2")
    Book.updateBook(b2)
    val b3 = Book.getBook(id)
    Assert.assertNotNull(b3)
    Assert.assertNotNull(b3.get)
    Assert.assertEquals(b3.get.id,b2.id)
    Assert.assertEquals(b3.get.title,b2.title)
    Assert.assertEquals(b3.get.author,b2.author)
  }

  @Test
  def deleteBook() = {
    val b1 = Book(None,"tttt", "carl", "isbn-1")
    val id = Book.addBook(b1)

    Assert.assertNotNull(Book.getBook(id))
    Assert.assertNotNull(Book.getBook(id).get)

    Book.deleteBook(id)

    val b2 = Book.getBook(id)
    Assert.assertEquals(b2,None)
  }

}
