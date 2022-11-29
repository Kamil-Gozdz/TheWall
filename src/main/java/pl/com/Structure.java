package pl.com;

import java.util.List;
import java.util.Optional;

public interface Structure {

    Optional<Block> findBlockByColor(String color);

    List<Block> findBlocksByMaterials(String material);

    int count();
}
