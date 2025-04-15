package com.example.demo.domain.usecase

import com.example.demo.domain.model.Book
import com.example.demo.domain.port.BookRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.*

class BookServiceTest : StringSpec({

    val repository = mockk<BookRepository>(relaxed = true)
    val service = BookService(repository)

    "ajouter un livre appelle bien save()" {
        val book = Book("1984", "George Orwell")
        service.addBook(book)
        verify { repository.save(book) }
    }

    "lister les livres les trie par ordre alphabétique" {
        val books = listOf(
            Book("Zebra", "Auteur Z"),
            Book("Animal Farm", "Orwell"),
            Book("Brave New World", "Huxley")
        )
        every { repository.findAll() } returns books

        val result = service.listBooksAlphabetically()

        result shouldContainExactly listOf(
            Book("Animal Farm", "Orwell"),
            Book("Brave New World", "Huxley"),
            Book("Zebra", "Auteur Z")
        )
    }
})
