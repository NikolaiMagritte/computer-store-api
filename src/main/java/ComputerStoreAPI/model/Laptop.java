package ComputerStoreAPI.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Laptop extends Product {
    @Enumerated(EnumType.STRING)
    @Column(name = "screen_size")
    private ScreenSize screenSize;
}
