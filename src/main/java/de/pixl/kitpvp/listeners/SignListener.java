package de.pixl.kitpvp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListener implements Listener {

    @EventHandler
    public void onSignEdit(SignChangeEvent event){
        String s = event.getLine(1);

        assert s != null;
        if (s.equalsIgnoreCase("[arena]")){
            event.setLine(1, "§7[§1To Arena§7]");
        }

        if (s.equalsIgnoreCase("[kit]")){
            event.setLine(1, "§7[§1Choose your Kit§7]");
        }

        if (s.equalsIgnoreCase("[secret]")){
            event.setLine(1, " ");
        }
    }
}
