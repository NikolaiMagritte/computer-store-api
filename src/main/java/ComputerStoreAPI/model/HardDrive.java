package ComputerStoreAPI.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class HardDrive extends Product {
    private double capacity;
}
