package tacos.taco_cloud.repositories;

import tacos.taco_cloud.domains.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);

}
