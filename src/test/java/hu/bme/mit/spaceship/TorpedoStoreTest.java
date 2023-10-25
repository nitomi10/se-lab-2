package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

  @Test
  void fire_Success(){
    TorpedoStore store = new TorpedoStore(1);

    boolean result = store.fire(1);

    assertEquals(true, result);
    
    store = new TorpedoStore(10, 0);
    result = store.fire(store.getTorpedoCount());
    assertEquals(true, result);
  }
  @Test
  void fire_Fail(){
    TorpedoStore store = new TorpedoStore(0);
    
    boolean result = store.fire(1);

    assertEquals(false, result);

    store = new TorpedoStore(1, 1);
    result = store.fire(1);
    assertEquals(false, result);
  }
  @Test
  void torpedo_faliure(){
    TorpedoStore store = new TorpedoStore(10000, 0.5);
    
    for(int i = 0; i<10000;i++){
    
    }
  }
}
