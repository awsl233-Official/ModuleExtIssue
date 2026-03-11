package dev.illusion.features.test;

import dev.illusion.features.Module;

public class Invoker extends Module {

    public void staticMethodTest(){
        //fails compilation
        staticMethod();
    }

    public void instanceGetterTest(){
        // generics mode(fails compilation)
        Test test = Test.getInstance1();
        test.foo();

        //Fails as well
        Test.getInstance2().foo();
    }
}
