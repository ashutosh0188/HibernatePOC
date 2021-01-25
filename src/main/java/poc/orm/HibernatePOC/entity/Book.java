package poc.orm.HibernatePOC.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    @TableGenerator(name = "tab", initialValue = 3, allocationSize = 1) //startPrimaryKey = i.e. 4 (3+1)
    private Long id;
    private String name;

    public Book() { }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void mergeBook(Book book) {
        this.setName(book.getName())    ;
    }
}
