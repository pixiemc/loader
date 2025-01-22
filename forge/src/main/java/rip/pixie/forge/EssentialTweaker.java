package rip.pixie.forge;

import java.io.File;
import java.util.List;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import rip.pixie.EssentialTransformer;

@SuppressWarnings("unused")
public class EssentialTweaker implements ITweaker {
    public EssentialTweaker() {
        EssentialTransformer.transform();
    }

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[]{};
    }
}
