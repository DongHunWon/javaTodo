package kr.ac.jejunu.user.model;

import lombok.Data;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "todo")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String todo_content;
    private Integer isdone;
}