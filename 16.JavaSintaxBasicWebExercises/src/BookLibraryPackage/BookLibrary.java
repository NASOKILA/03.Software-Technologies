package BookLibraryPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BookLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        BookLibraryModel bookLibrary = new BookLibraryModel();



        List<Book> books = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            String[] input = scanner.nextLine().split("\\s");

            Book book = new Book();

            book.setTitle(input[0]);
            book.setAuthor(input[1]);
            book.setPublisher(input[2]);

            //Taka parsvame Datata  df E FORMATA KOITO POLZVAME !
            book.setReleaseDate(LocalDate.parse(input[3], df));
            book.setISBN(input[4]);
            book.setPrice(Double.parseDouble(input[5]));

            books.add(book);
        }

        // Slagame si sisuka s knigite v libraryto
        bookLibrary.setName("Biblioteka");
        bookLibrary.setBooks(books);

        // TRQBVA DA GRUPIRAME KNIGITE PO AVTORAT IM I AKO AVTORUT E EDNAKKUV
        // GRUPIRAME GI SBORA NA CENITE  !!!

        // TRQBVA OBACHE D GI SORTIRAME, MINAVAME PREZ ENTRYSET KOETO IMA STREAM ZA
        // ZA DA MOJEM DA POLZVAME SORTED()

        bookLibrary.getBooks().stream()
                .collect(Collectors.groupingBy(b -> b.getAuthor(), Collectors.summingDouble(Book::getPrice)))
                .entrySet()
                .stream()
                .sorted((a,b) -> {

                    int result = Double.compare(b.getValue(),a.getValue());
                    if(result == 0)
                    {// ako sa ravni gi sortirame po imenata
                       a.getKey().compareTo(b.getKey());
                    }

                    return result;

                })
                .forEach(kvp -> {

                    //TUK SI GI PRINTIRAME:

                System.out.printf("%s -> %.2f", kvp.getKey(), kvp.getValue());

                    System.out.print(System.lineSeparator());
                });
    }
}
