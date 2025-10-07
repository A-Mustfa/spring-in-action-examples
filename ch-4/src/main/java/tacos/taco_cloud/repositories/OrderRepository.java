package tacos.taco_cloud.repositories;

import org.springframework.data.repository.CrudRepository;

import tacos.taco_cloud.domains.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder,Long> {



}
