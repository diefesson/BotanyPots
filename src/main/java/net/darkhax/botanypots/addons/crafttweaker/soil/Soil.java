package net.darkhax.botanypots.addons.crafttweaker.soil;

import org.openzen.zencode.java.ZenCodeType;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.impl.blocks.MCBlockState;

import net.darkhax.botanypots.soil.SoilReloadListener;
import net.minecraft.util.ResourceLocation;

@ZenRegister
@ZenCodeType.Name("mods.botanypots.Soil")
public class Soil {
    
    @ZenCodeType.Method
    public static void create (String id, IIngredient ingredient, MCBlockState displayState, int ticks, String[] categories) {
        
        CraftTweakerAPI.apply(new ActionSoilCreate(id, ingredient, displayState, ticks, categories));
    }
    
    @ZenCodeType.Method
    public static void remove (String id) {
        
        CraftTweakerAPI.apply(new ActionSoilRemove(id));
    }
    
    @ZenCodeType.Method
    public static void setTicks (String id, int ticks) {
        
        CraftTweakerAPI.apply(new ActionSoilSetTicks(id, ticks));
    }
    
    @ZenCodeType.Method
    public static void setIngredient (String id, IIngredient ingredient) {
        
        CraftTweakerAPI.apply(new ActionSoilSetIngredient(id, ingredient));
    }
    
    @ZenCodeType.Method
    public static void setDisplayState (String id, MCBlockState state) {
        
        CraftTweakerAPI.apply(new ActionSoilSetDisplay(id, state));
    }
    
    @ZenCodeType.Method
    public static void addCategory (String id, String[] categories) {
        
        CraftTweakerAPI.apply(new ActionSoilAddCategory(id, categories));
    }
    
    @ZenCodeType.Method
    public static void removeCategory (String id, String[] categories) {
        
        CraftTweakerAPI.apply(new ActionSoilRemoveCategory(id, categories));
    }
    
    @ZenCodeType.Method
    public static void clearCategories (String id) {
        
        CraftTweakerAPI.apply(new ActionSoilClearCategories(id));
    }
    
    @ZenCodeType.Method
    public static String[] getAllIds () {
        
        return SoilReloadListener.registeredSoil.keySet().stream().map(ResourceLocation::toString).toArray(String[]::new);
    }
    
    @ZenCodeType.Method
    public static void removeAll () {
        
        SoilReloadListener.registeredSoil.clear();
    }
}