package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
     /*   Author dan = new Author("Dan","Hayes");
        Author wendy = new Author("Wendy","Hayes");
        Author socks = new Author("Socks","Hayes");

        Book bookDan = new Book("Dan's book","1234");
        Book bookWendy = new Book("Wendy's book","5678");
        Book bookSock = new Book("Sock's book","7890");

        Publisher publisherPete = new Publisher("Dan","73 Armagh Way","Ottawa","ON","K2J4C1");

        bookDan.setPublisher(publisherPete);
        bookRepository.save(bookDan);
        publisherPete.getBooks().add(bookDan);
        publisherRepository.save(publisherPete);

        dan.getBooks().add(bookDan);
        wendy.getBooks().add(bookWendy);

        authorRepository.save(dan);
        authorRepository.save(wendy);

        bookRepository.save(bookDan);
        bookRepository.save(bookWendy);
        bookRepository.save(bookSock);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books added =" + bookRepository.count());
        System.out.println("Publisher count is " + publisherRepository.count()); */
    }
}
