package model;


import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Felipe Frechiani
 */
@Entity
@Table(name = "locacao")
public class Locacao {
    
    @Id
    @GeneratedValue(generator = "increment")    
    @GenericGenerator(name = "increment", strategy = "increment")
    private  int id;
    private  Date data;
    private  Time time;
    
    
    
    
}
