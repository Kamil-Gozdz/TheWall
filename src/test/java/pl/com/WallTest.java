package pl.com;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import java.util.Optional;


public class WallTest {


    private static final Block block1 = new Wall("green", "iron");
    private static final Block block2 = new Wall("green", "wood");
    private static final Block block3 = new Wall("blue", "wood");
    private static final Block block4 = new Wall("pink", "plastic");
    private static final Block block5 = new Wall("red", "plastic");
    private static final Block block6 = new Wall("brown", "wood");
    private static final Wall wall = new Wall(List.of(block1, block2, block3, block4, block5, block6));


    @ParameterizedTest
    @ValueSource(strings = {"green"})
    public void shouldReturnBlockWithProvidedColor(String input) {

        //when
        Optional<Block> result = wall.findBlockByColor(input);
        //then
        Assert.assertTrue(result.isPresent());
    }
    @ParameterizedTest
    @ValueSource(strings = {"black"})
    public void shouldThrowException_whenBlockWithProvidedColorNotFound(String input) {

        //when & then
        assertThatThrownBy(() -> wall.findBlockByColor(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("No block found for provided color");
    }
    @Test
    public void shouldReturnSizeOfWall() {

        //when
        int result = wall.count();
        //then
        Assert.assertEquals(6,result);
    }
    @ParameterizedTest
    @ValueSource(strings = {"wood"})
    public void shouldReturnListOfBlocksWithProvidedMaterial(String input) {

        //when
        List<Block> result = wall.findBlocksByMaterials(input);
        //then
        Assert.assertEquals(3,result.size());
    }

}