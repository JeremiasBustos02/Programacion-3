package ProgramacionIII.TP2_1_Arboles;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeBook {
    private TreeNodeBook root;

    public BinaryTreeBook(TreeNodeBook root) {
        this.root = root;
    }
    public BinaryTreeBook() {
        this.root = null;
    }

    /* Ejercicio 6
    Se desea desarrollar una aplicación para mejorar la atención de una biblioteca en cuanto a la
    búsqueda de libros dentro del catálogo disponible. Cada libro estará compuesto por un
    identificador único y datos propios de los libros (título, autor, géneros, año de publicación,
    cantidad de ejemplares, etc.)
    Se sabe, además, que los libros nuevos se agregan al catálogo en horarios fuera de la atención al público.

    Se desean proveer los siguientes servicios:
    • Obtener la cantidad de ejemplares de un libro dado su identificador único.
    • Obtener todos los libros de un género dado.
    • Obtener todos los libros publicados entre dos años de publicación dados.

    Responda y justifique:
    1) ¿Qué estructura de datos utilizaría para almacenar todos los libros en memoria dentro
    de la aplicación?

    2) ¿Cómo resolvería cada uno de los servicios solicitados? ¿Utilizaría alguna estructura
    adicional de acceso para mejorar el costo de respuesta de cada servicio. */

    public int cantExamples(long id) {
        return cantExamples(this.root, id);
    }

    private int cantExamples(TreeNodeBook node, long id) {
        if (node.getBook() != null) {
            if (node.getBook().getId() == id) {
                return node.getBook().getExamples();
            } else {
                if (node.getBook().getId() > id) {
                    return cantExamples(node.getLeft(), id);
                } else {
                    return cantExamples(node.getRight(), id);
                }
            }
        }
        return 0;
    }

    public List<Book> getBooksByGenre(String genre) {
        List<Book> books = new ArrayList<Book>();
        if (this.root != null) {
            getBooksByGenre(this.root, books, genre);
        }
        return books;
    }

    public void getBooksByGenre(TreeNodeBook node, List<Book> books, String genre) {
        if (node.getBook() != null) {
            if (node.getBook().getGenres().contains(genre)) {
                books.add(node.getBook());
            }
            getBooksByGenre(node.getLeft(), books, genre);
            getBooksByGenre(node.getRight(), books, genre);
        }
    }

    public List<Book> getBooksByTwoYears(int year1, int year2) {
        List<Book> books = new ArrayList<Book>();
        if (this.root != null) {
            getBooksByTwoYears(this.root, books, year1, year2);
        }
        return books;
    }

    private void getBooksByTwoYears(TreeNodeBook node, List<Book> books, int year1, int year2) {
        if (node.getBook() != null) {
            if (node.getBook().getYear() >= year1 && node.getBook().getYear() <= year2) {
                books.add(node.getBook());
            }
            getBooksByTwoYears(node.getLeft(), books, year1, year2);
            getBooksByTwoYears(node.getRight(), books, year1, year2);
        }
    }
}
