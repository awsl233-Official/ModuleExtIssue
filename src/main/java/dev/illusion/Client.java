package dev.illusion;

import dev.illusion.features.test.Invoker;
import dev.illusion.managers.ModuleManager;

public class Client {

    private static Client INSTANCE;

    private ModuleManager moduleManager;

    public Client(){
        INSTANCE = this;
    }

    public void init(){
        moduleManager = new ModuleManager();
        test();
    }

    public void test(){
        Invoker invoker = Client.getInstance().getModuleManager().getModule(Invoker.class);

        invoker.staticMethodTest();

        invoker.instanceGetterTest();

        invoker.method();
    }

    public static Client getInstance(){
        return INSTANCE;
    }

    public ModuleManager getModuleManager(){
        return moduleManager;
    }
}
