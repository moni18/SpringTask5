package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column
    private int series;

//    @OneToOne(mappedBy = "car")
//    private User owner;
    public Car(){}

    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }

    public Long getId(){  return id;  }

    public void setId(Long id){ this.id = id;  }

    public String getModel(){ return model;  }

    public void setModel(String model){ this.model = model;}

    public int getSeries(){ return series; }

    public void setSeries(int series){this.series = series;}


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
