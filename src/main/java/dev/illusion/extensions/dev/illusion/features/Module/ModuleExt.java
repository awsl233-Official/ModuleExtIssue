package dev.illusion.extensions.dev.illusion.features.Module;

import dev.illusion.Client;
import dev.illusion.features.Module;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;
import manifold.ext.rt.api.ThisClass;

@Extension

//all method here fails the compilation,:(
public class ModuleExt {

    //generics mode
    public static <T extends Module> T getInstance1(@ThisClass Class<T> clazz) {
        if (!Module.class.isAssignableFrom(clazz))
            throw new IllegalArgumentException(clazz.getName() + " is not a Module");

        return Client.getInstance().getModuleManager().getModule(clazz);
    }

    //@Self annotation mode
    @SuppressWarnings({"unchecked"})
    public static @Self Object getInstance2(@ThisClass Class<?> clazz) {
        if (!Module.class.isAssignableFrom(clazz))
            throw new IllegalArgumentException(clazz.getName() + " is not a Module");

        return Client.getInstance().getModuleManager().getModule((Class<Module>) clazz);
    }

    //conventional static method declaration
    public static int staticMethod(@ThisClass Class ignored){
        return Integer.MAX_VALUE;
    }

    //conventional method declaration
    public static int method(@This Module ignored){
        return Integer.MIN_VALUE;
    }

}
