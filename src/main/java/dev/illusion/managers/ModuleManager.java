package dev.illusion.managers;

//Java have no 'object' type class like Kotlin, we must manage all module instances manually here

import dev.illusion.features.Module;
import dev.illusion.features.test.Test;
import dev.illusion.features.test.Invoker;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {
    private static final Map<Class<?>, Module> modules = new HashMap<>();


    public ModuleManager(){
        registerAllModules();
    }

    @SuppressWarnings("unchecked")
    public <T extends Module> T getModule(Class<T> clazz) {
        return (T) modules.get(clazz);
    }

    //assume that we're handled module registration & initialization
    public static void register(Module m) {
        modules.put(m.getClass(), m);
    }

    public void registerAllModules(){
        register(new Test());
        register(new Invoker());
    }

}
