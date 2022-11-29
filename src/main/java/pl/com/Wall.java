package pl.com;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure,CompositeBlock {

    private List<Block> blocks;

    private String color;

    private String material;


    @Override
    public String getColor() {
        return this.color;
    }

    public Wall(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> block = blocks.stream()
                .filter(b -> b.getColor()
                        .equals(color)).findAny();
        if(block.isEmpty()){
            throw new NoBlockFoundException("No block found for provided color");
        }
        return block;
    }

    @Override
    public List<Block> findBlocksByMaterials(String material) {
        return blocks.stream()
                .filter(b -> b.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public String toString() {
        return "Wall{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
