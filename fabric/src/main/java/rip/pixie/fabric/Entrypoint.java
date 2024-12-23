package rip.pixie.fabric;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import rip.pixie.EssentialTransformer;

public class Entrypoint implements PreLaunchEntrypoint {

    @Override
    public void onPreLaunch() {
        EssentialTransformer.transgender();
    }
}
