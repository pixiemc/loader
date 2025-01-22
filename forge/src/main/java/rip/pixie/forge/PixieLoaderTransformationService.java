package rip.pixie.forge;

import cpw.mods.modlauncher.api.ITransformingClassLoader;
import rip.pixie.EssentialTransformer;

import java.util.function.Predicate;

@SuppressWarnings("unused")
public class PixieLoaderTransformationService implements ITransformingClassLoader {
    public PixieLoaderTransformationService() {
        EssentialTransformer.transform();
    }

    @Override
    public ClassLoader getInstance() {
        return ITransformingClassLoader.super.getInstance();
    }

    @Override
    public void addTargetPackageFilter(Predicate<String> predicate) {

    }
}
