package com.capstone.caledonia.testing;
import com.capstone.caledonia.map.GameMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapTest {
    GameMap map;

    @Before
    public void before() {
        map = new GameMap();
    }

    @Test
    public void mapHas10Elements() {
        assertEquals(10, map.getNodes().size());
    }
}
