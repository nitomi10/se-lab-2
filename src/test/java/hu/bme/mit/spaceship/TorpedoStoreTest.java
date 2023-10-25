package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.doubleThat;

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
    boolean result;
    try{
     result = store.fire(1);
     result = store.fire(0);
     result = store.fire(-1);
    }catch(IllegalArgumentException e){
      result = false;
    }
    assertEquals(false, result);

    store = new TorpedoStore(1, 1);
    result = store.fire(1);
    assertEquals(false, result);
  }
  @Test
  void torpedo_faliure(){
    int try_num = 10000;
    double faliure = 0.5;
    double epsilon = 0.1;
    TorpedoStore store = new TorpedoStore(try_num, faliure);
    double success_num = 0;
    for(int i = 0; i<try_num;i++){
      boolean success = store.fire(1);
      if (success){
        success_num++;
      }
    }
    double all_trys = try_num;
    
    assertEquals( faliure,(success_num/all_trys), epsilon );
  }
  @Test
  void torpedo_store(){
    TorpedoStore store = new TorpedoStore(1);
    int num = store.getTorpedoCount();
    assertEquals(1,num);
    boolean result = store.isEmpty();
    assertEquals(false,result);
    store.fire(1);
    result = store.isEmpty();
    assertEquals(true,result);
  }
}
