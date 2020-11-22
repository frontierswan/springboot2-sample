package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED) @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository repository;

    @Test
    void saveCar() {
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
        //entityManager.persistAndFlush(car);
        repository.save(car);

        Assertions.assertNotNull(car.getId());
    }

    @Test
    void deleteCars() {
//        entityManager.persistAndFlush(new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000));
//        entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500));
        repository.save(new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000));
        repository.save(new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500));

        repository.deleteAll();
        org.assertj.core.api.Assertions.assertThat(repository.findAll()).isEmpty();
        //Assertions.assert(repository.findAll());
    }
}
